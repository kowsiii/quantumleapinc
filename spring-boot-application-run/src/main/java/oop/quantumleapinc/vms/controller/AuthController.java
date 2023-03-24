package oop.quantumleapinc.vms.controller;

import oop.quantumleapinc.vms.login.payload.request.LoginRequest;
import oop.quantumleapinc.vms.login.payload.request.SignupRequest;
import oop.quantumleapinc.vms.login.payload.response.MessageResponse;
import oop.quantumleapinc.vms.login.payload.response.UserInfoResponse;
import oop.quantumleapinc.vms.model.ERole;
import oop.quantumleapinc.vms.model.Role;
import oop.quantumleapinc.vms.model.User;
import oop.quantumleapinc.vms.repository.RoleRepository;
import oop.quantumleapinc.vms.repository.UserRepository;
import oop.quantumleapinc.vms.security.awt.JwtUtils;
import oop.quantumleapinc.vms.service.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwt(userDetails);
        //ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        roles, jwt));

//        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwt)
//                .body(new UserInfoResponse(userDetails.getId(),
//                        userDetails.getUsername(),
//                        roles));

//        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//                .body(new UserInfoResponse(userDetails.getId(),
//                        userDetails.getUsername(),
//                        roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()));

        //Set<String> strRoles = signUpRequest.getRole();
        //Set<String> strRoles = new HashSet<String>();
        //strRoles.add(signUpRequest.getRole());

        Set<Role> roles = new HashSet<>();

        if (signUpRequest.getRole() != null) {
            switch (signUpRequest.getRole()) {
                case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    case "approver":
                        Role appRole = roleRepository.findByName(ERole.ROLE_APPROVER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(appRole);

                        break;
                    default:
                        Role vendRole = roleRepository.findByName(ERole.ROLE_VENDOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(vendRole);
            }
            
            //Role userRole = roleRepository.findByName(ERole.ROLE_USER)
            //    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            //roles.add(userRole);
        } else {
            throw new RuntimeException("Error: Role is not assigned.");
        }

        // if (strRoles == null) {
        //     Role userRole = roleRepository.findByName(ERole.ROLE_USER)
        //             .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        //     roles.add(userRole);
        // } else {
        //     strRoles.forEach(role -> {
        //         switch (role) {
        //             case "admin":
        //                 Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
        //                         .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        //                 roles.add(adminRole);

        //                 break;
        //             case "mod":
        //                 Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
        //                         .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        //                 roles.add(modRole);

        //                 break;
        //             default:
        //                 Role userRole = roleRepository.findByName(ERole.ROLE_USER)
        //                         .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        //                 roles.add(userRole);
        //         }
        //     });
        // }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
}
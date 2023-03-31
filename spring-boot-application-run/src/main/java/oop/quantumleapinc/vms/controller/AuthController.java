package oop.quantumleapinc.vms.controller;

import jakarta.persistence.EntityNotFoundException;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        try {
            logger.debug("registerUser: login " + signUpRequest.getUsername());
            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error", "Username is already taken."));
            }

            // Create new user's account
            User user = new User(signUpRequest.getUsername(),
                    encoder.encode(signUpRequest.getPassword()),
                    signUpRequest.getName());
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
                    } else {
                        throw new RuntimeException("Error: Role is not assigned.");
                    }
            
            user.setRoles(roles);
            user.setActive("Y");
            userRepository.save(user);
            return ResponseEntity.ok(new MessageResponse("Success", "User registered successfully."));
        } catch (Exception ex) {
            logger.error("registerUser: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to signup."));
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        logger.debug("authenticateUser: login " + loginRequest.getUsername());
        try {
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
        } catch (Exception ex) {
            logger.error("authenticateUser: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to sign-in."));
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> users() {
        logger.debug("users: get users list");
        try {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("users: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to get users."));
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long userId) {
        logger.debug("users: get user for " + userId);
        try {
            return new ResponseEntity<>(userRepository.findById(userId), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("user: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to get user."));
        }
    }

    @PostMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody SignupRequest signUpRequest,  @PathVariable("id") Long userId) {
        logger.debug("users: update user for " + userId);
        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException(userId.toString()));
            user.setActive(signUpRequest.getActive());
            user.setName(signUpRequest.getName());
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
            } else {
                throw new RuntimeException("Error: Role is not assigned.");
            }

            user.getRoles().clear();
            user.setRoles(roles);

            userRepository.saveAndFlush(user);
            return ResponseEntity.ok().body(new MessageResponse("Success", "user updated."));
        } catch (Exception ex) {
            logger.error("user: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to update user."));
        }
    }

//    @PostMapping("/signout")
//    public ResponseEntity<?> logoutUser() {
//        logger.debug("signout:");
//        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
//        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
//                .body(new MessageResponse("Success", "You've been signed out!"));
//    }

}
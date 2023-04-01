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
import oop.quantumleapinc.vms.service.EmailSenderService;
import oop.quantumleapinc.vms.service.UserDetailsImpl;
import jakarta.persistence.EntityNotFoundException;
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


import oop.quantumleapinc.vms.payload.email.EmailRequest;
import oop.quantumleapinc.vms.repository.UserRepository;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    UserRepository userRepository;

    @Autowired
	private EmailSenderService senderService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/sendEmail")
    public ResponseEntity<?> updatePassword(@RequestBody EmailRequest emailRequest) {
        logger.debug("Sending an email to"+ emailRequest.getEmail());
        try {
            User user = userRepository.findByUsername(emailRequest.getEmail())
                    .orElseThrow(() -> new EntityNotFoundException(emailRequest.getEmail().toString()));
            senderService.sendEmail(emailRequest.getEmail(),"test","hello!");
            return ResponseEntity.ok().body(new MessageResponse("Success", "email has been sent to "+ user.getUsername()));
        } catch (Exception ex) {
            logger.error("send email: " + ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("Error", "Not able to send email."));
        }
    }
}

package oop.quantumleapinc.vms.util;


import oop.quantumleapinc.vms.model.ERole;
import oop.quantumleapinc.vms.model.Role;
import oop.quantumleapinc.vms.model.User;
import oop.quantumleapinc.vms.repository.RoleRepository;
import oop.quantumleapinc.vms.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public void run(String... args) throws Exception {
        logger.debug("MyRunner: called to create default user and password.");
        String rolesValues = "ROLE_ADMIN,ROLE_VENDOR,ROLE_APPROVER";
        Set<Role> roles = (Arrays.stream(rolesValues.split(","))
                .map(Role::new)
                .collect(Collectors.toSet()));

        roles.forEach(role -> {
                    if (!roleRepository.existsByName(role.getName())) {
                        roleRepository.saveAndFlush(role);
                        logger.debug("MyRunner: created role " + role.getName());
                    }
                }
        );

        if (!userRepository.existsByUsername("admin@admin.com")) {
            User user = new User("admin@admin.com", encoder.encode("123456"), "Default Admin");
            user.setActive("Y");
            Role role = roleRepository.findByName(ERole.ROLE_ADMIN).get();
            Set<Role> rolesDefault = new HashSet<>();
            rolesDefault.add(role);
            user.setRoles(rolesDefault);
            userRepository.saveAndFlush(user);
            logger.debug("MyRunner: created default user admin with default admin role");
        }
        logger.debug("MyRunner: finished to create default user and password.");
    }
}

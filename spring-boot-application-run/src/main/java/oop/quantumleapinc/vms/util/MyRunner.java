package oop.quantumleapinc.vms.util;


import oop.quantumleapinc.vms.model.Role;
import oop.quantumleapinc.vms.repository.RoleRepository;
import oop.quantumleapinc.vms.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

//@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    

    @Override
    public void run(String...args) throws Exception {

//        repository.save(new Employee("Bilbo Baggins", "burglar"));
//        repository.save(new Employee("Frodo Baggins", "thief"));


//        //$2a$12$afM4LAo9qqudzghsgUO4du5QOatEkRc9bEDrttj0bM4IdgjOauoNC - 123456
//
//        //USER-1
//        User user = new User("admin",
//                "$2a$12$afM4LAo9qqudzghsgUO4du5QOatEkRc9bEDrttj0bM4IdgjOauoNC");
//
//        //String[] values = "admin".split(",");
        String rolesvalues = "ROLE_ADMIN,ROLE_VENDOR,ROLE_APPROVER";
        Set<Role> roles =(Arrays.stream(rolesvalues.split(","))
                .map(Role::new)
                .collect(Collectors.toSet()));
        roles.forEach(role -> roleRepository.save(role));
//
//        user.setRoles(roles);
//        userRepository.save(user);
//
//        //USER-2
//        user = new User("user",
//                "$2a$12$afM4LAo9qqudzghsgUO4du5QOatEkRc9bEDrttj0bM4IdgjOauoNC");
//        rolesvalues = "ROLE_USER";
//        roles =(Arrays.stream(rolesvalues.split(","))
//                .map(Role::new)
//                .collect(Collectors.toSet()));
//        roles.forEach(role -> roleRepository.save(role));
//
//        user.setRoles(roles);
//        userRepository.save(user);
//
//        logger.info("# of users: {}", userRepository.count());
//
//        logger.info("All users unsorted:");
//
//        Iterable < User > users = userRepository.findAll();
//        Iterator< User > iterator = users.iterator();
//        while (iterator.hasNext()) {
//            logger.info("{}", iterator.next().toString());
//        }
//
//        logger.info("------------------------");

    }
}

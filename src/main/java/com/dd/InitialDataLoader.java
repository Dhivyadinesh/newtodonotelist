package com.dd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dd.entity.User;
import com.dd.repository.Userrepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private Userrepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        User user = new User();
        user.setFirstName("Admin1");
        user.setLastName("Last1");
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));

        User user2 = userRepository.findByUsername("admin");
        if (user2 == null)
            userRepository.save(user);

        alreadySetup = true;
    }


}
package org.example.hvala.services.Impl;

import org.example.hvala.dtos.users.SignupRequest;
import org.example.hvala.models.entities.User;
import org.example.hvala.models.enums.RoleEnum;
import org.example.hvala.repositories.RoleRepository;
import org.example.hvala.repositories.UserRepository;
import org.example.hvala.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public void addUser(SignupRequest signupRequest) {

        if (!signupRequest.getPassword().equals(signupRequest.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }

        Optional<User> byUsername = this.userRepository.findByUsername(signupRequest.getUsername());
        Optional<User> byEmail = this.userRepository.findByEmail(signupRequest.getEmail());

        if (byUsername.isPresent()) {
            throw new RuntimeException("login.used");
        }

        if (byEmail.isPresent()) {
            throw new RuntimeException("email.used");
        }

        var role = roleRepository.findByName(RoleEnum.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role USER is not found."));

        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword())
        );
        user.setRole(role);
        userRepository.save(user);
    }
}

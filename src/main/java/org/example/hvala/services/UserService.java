package org.example.hvala.services;

import org.example.hvala.dtos.users.SignupRequest;

public interface UserService {
    void addUser(SignupRequest signupRequest);
}

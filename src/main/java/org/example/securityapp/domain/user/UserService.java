package org.example.securityapp.domain.user;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void 회원가입(String username, String password, String email) {
        userRepository.save(username, password, email);
    }
}
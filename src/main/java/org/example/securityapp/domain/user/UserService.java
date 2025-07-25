package org.example.securityapp.domain.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.securityapp._core.JWTUtil;
import org.example.securityapp.controller.dto.UserRequest;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void 회원가입(UserRequest.Join reqDTO) {
        String encPassword = bCryptPasswordEncoder.encode(reqDTO.getPassword());
        String roles = "USER";
        userRepository.save(roles, reqDTO.getUsername(), encPassword, reqDTO.getEmail());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public String 로그인(UserRequest.Login reqDTO) {
        User user = userRepository.findByUsername(reqDTO.getUsername());

        if (user == null) throw new RuntimeException("유저네임을 찾을 수 없습니다");

        if (!bCryptPasswordEncoder.matches(reqDTO.getPassword(), user.getPassword()))
            throw new RuntimeException("비밀번호가 틀렸습니다");

        // 4. JWT 토큰 생성
        String jwtToken = JWTUtil.create(user);

        return jwtToken;
    }
}

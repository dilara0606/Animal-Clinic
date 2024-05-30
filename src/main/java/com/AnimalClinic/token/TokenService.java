package com.AnimalClinic.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    void saveToken(Token token) {
        tokenRepository.save(token);
    }
}

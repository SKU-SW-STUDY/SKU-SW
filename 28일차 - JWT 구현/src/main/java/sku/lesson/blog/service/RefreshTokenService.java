package sku.lesson.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sku.lesson.blog.domain.RefreshToken;
import sku.lesson.blog.repository.RefreshTokenRepository;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected token"));
    }
}

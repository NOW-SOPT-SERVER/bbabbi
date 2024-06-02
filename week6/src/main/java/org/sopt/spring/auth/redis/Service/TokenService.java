package org.sopt.spring.auth.redis.Service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sopt.spring.auth.UserAuthentication;
import org.sopt.spring.auth.redis.domain.Token;
import org.sopt.spring.auth.redis.repository.TokenRepository;
import org.sopt.spring.common.dto.ErrorMessage;
import org.sopt.spring.common.jwt.JwtTokenProvider;
import org.sopt.spring.exception.NotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenRepository tokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void saveRefreshToken(
            final Long userId,
            final String refreshToken
    ) {
        tokenRepository.save(
                Token.of(
                        userId,
                        refreshToken
                )
        );
    }

    @Transactional
    public void deleteRefreshToken(
            final Long userId
    ) {
        Token token = tokenRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.REFRESH_TOKEN_NOT_FOUND)
        );
        tokenRepository.delete(token);
    }

    public Long findIdByRefreshToken(
            final String refreshToken
    ) {
        Token token = tokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessage.REFRESH_TOKEN_NOT_FOUND)
                );
        return token.getId();
    }

    protected String generateAccessToken(Long userId) {
        return jwtTokenProvider.issueAccessToken(
                UserAuthentication.createUserAuthentication(userId)
        );
    }

    protected String generateRefreshToken(Long userId) {
        return jwtTokenProvider.issueRefreshToken(
                UserAuthentication.createUserAuthentication(userId)
        );
    }
}
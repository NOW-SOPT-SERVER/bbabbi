package org.sopt.spring.auth.redis.Service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.spring.auth.UserAuthentication;
import org.sopt.spring.auth.redis.domain.Token;
import org.sopt.spring.auth.redis.repository.TokenRepository;
import org.sopt.spring.common.dto.ErrorMessage;
import org.sopt.spring.common.jwt.JwtTokenProvider;
import org.sopt.spring.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
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

    public Long findIdByRefreshToken(
            final String refreshToken
    ) {
        Token token = tokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessage.REFRESH_TOKEN_NOT_FOUND)
                );
        return token.getId();
    }

    public String generateAccessToken(Long userId) {
        return jwtTokenProvider.issueAccessToken(
                UserAuthentication.createUserAuthentication(userId)
        );
    }

}
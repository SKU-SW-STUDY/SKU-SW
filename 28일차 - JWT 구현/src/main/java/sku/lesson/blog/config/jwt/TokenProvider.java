package sku.lesson.blog.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import sku.lesson.blog.domain.User;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TokenProvider {

    private final JwtProperties jwtProperties;

    // JWT 토큰 생성 함수
    public String generateToken(User user, Duration expiredAt){
        Date now = new Date();
        return makeToken(new Date(now.getTime() + expiredAt.toMillis()), user);
    }

    // JWT 토큰 생성 함수
    public String makeToken(Date expiry, User user){
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)   // 헤더 typ : jwt
                .setIssuer(jwtProperties.getIssuer())           // 내용 iss : properties 에 설정한 값 (토큰 발급자)
                .setIssuedAt(now)                               // 내용 iat : 현재시간 - 토큰이 발급된 시간 (토큰 만료일자)
                .setExpiration(expiry)                          // 내용 exp : expiry 멤버 변수값
                .setSubject(user.getEmail())                    // 내용 sub : 유저의 이메일
                .claim("id", user.getId())                   // 클레임 ID : 유저 Id
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())   // 서명 : 비밀값과 함께 해시값을 HS256 방식으로 암호화
                .compact();
    }

    // 토큰 유효성 확인 함수
    public boolean validToken(String token){
        try{
            Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())       // 비밀값 복호화 (HS256 대칭키 )
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e){      // 복호화 과정에서 에러가 나면 유효하지 않은 토큰 (비밀키로 암호화 하지 않은 토큰)
            return false;
        }
    }

    // 토큰 기반으로 인증 정보를 가져오는 함수
    public UsernamePasswordAuthenticationToken getAuthentication(String token){
        Claims claims = getClaims(token);
        Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken(new org.springframework.security.core.userdetails.User(claims.getSubject(),
                "", authorities), token, authorities);
    }

    // 토큰 기반으로 유저 ID를 가져오는 메서드
    public Long getUserId(String token){
        Claims claims = getClaims(token);
        return claims.get("id", Long.class);
    }

    // 클레임을 가져오는 함수
    private Claims getClaims(String token){
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }


}

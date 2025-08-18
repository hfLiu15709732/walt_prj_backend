package org.example.walt_prj_backend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.example.walt_prj_backend.pojo.entity.User;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    // 密钥，请妥善保管，不要泄露
    private static final String SECRET = "your_secret_key_here"; 
    // 过期时间，单位毫秒，这里设置为1小时
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    /**
     * 生成JWT Token
     * @param user 用户信息
     * @return Token字符串
     */
    public static String generateToken(User user) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        return JWT.create()
                .withHeader(header)
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withExpiresAt(expiration)
                .withIssuedAt(now)
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 验证JWT Token
     * @param token Token字符串
     * @return 解码后的JWT对象
     * @throws JWTVerificationException 验证失败时抛出异常
     */
    public static DecodedJWT verifyToken(String token) throws JWTVerificationException {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);
    }

    /**
     * 从Token中获取用户ID
     * @param token Token字符串
     * @return 用户ID
     */
    public static Long getUserId(String token) {
        DecodedJWT jwt = verifyToken(token);
        return jwt.getClaim("id").asLong();
    }

    /**
     * 从Token中获取用户名
     * @param token Token字符串
     * @return 用户名
     */
    public static String getUsername(String token) {
        DecodedJWT jwt = verifyToken(token);
        return jwt.getClaim("username").asString();
    }

    /**
     * 对字符串进行MD5加密
     * @param text 待加密字符串
     * @return MD5加密后的字符串
     */
    public static String md5(String text) {
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }
}
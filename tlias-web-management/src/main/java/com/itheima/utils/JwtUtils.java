package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String SECRET_KEY = "aXRoZWltYQ=="; //密钥
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000; //有效期十二个小时

    /*
    * 生成Jwt令牌
    * @Param claims令牌中包含的信息
    * @return 生成的Jwt令牌字符串
    */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    /*
    * 解析Jwt令牌
    * @Param token 要解析的Jwt令牌字符串
    * @return 包含令牌信息的Claims对象
    * @throws Exception 如果令牌无效或过期，则抛出异常
    */
    public static Claims parseToken(String token) throws Exception {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}

package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    // 统一密钥（推荐使用原始字符串）
    private static final byte[] SECRET_KEY = "itheima".getBytes(StandardCharsets.UTF_8);

    @Test
    public void testGenJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "admin");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))
                .compact();

        System.out.println("生成的JWT: " + jwt);
    }

    @Test
    public void testParseJwt(){
        // 应使用上面方法生成的token
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc1MDMwMzgyN30.ydK_Au8wMqBlgF0oPjCL9xRkBrYwcSsbXFViaoq6S_0";

        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY) // 使用相同密钥
                .parseClaimsJws(token)
                .getBody();

        System.out.println("解析结果: " + claims);
    }
}

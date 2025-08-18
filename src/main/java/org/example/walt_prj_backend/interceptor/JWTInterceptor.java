package org.example.walt_prj_backend.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.walt_prj_backend.utils.JwtUtil;
import org.example.walt_prj_backend.utils.ResponseMessage;
import org.springframework.web.servlet.HandlerInterceptor;


public class JWTInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            try {
                DecodedJWT decodedJWT = JwtUtil.verifyToken(token);
                // 把用户 ID 放到 request 里，后续控制器可直接取
                request.setAttribute("userId", decodedJWT.getClaim("userId").asLong());
                return true;
            } catch (Exception e) {
                // 无效 token
                writeJson(response, ResponseMessage.error(401, "Invalid Token"));
                return false;
            }
        }

        // 缺少 token
        writeJson(response, ResponseMessage.error(401, "Token Missing"));
        return false;
    }

    /**
     * 把 ResponseMessage 以 JSON 形式写回客户端
     */
    private void writeJson(HttpServletResponse response, ResponseMessage<?> body) throws Exception {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(body));
    }
}
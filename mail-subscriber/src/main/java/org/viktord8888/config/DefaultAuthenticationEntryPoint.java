package org.viktord8888.config;

//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class DefaultAuthenticationEntryPoint {
//public class DefaultAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

//    @Override
//    public void commence(
//            HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
//            throws IOException {
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        PrintWriter writer = response.getWriter();
//        writer.println("HTTP Status 401 - " + authEx.getMessage());
//    }
//
//    @Override
//    public void afterPropertiesSet() {
//        setRealmName("MailSubscriber");
//        super.afterPropertiesSet();
//    }
}

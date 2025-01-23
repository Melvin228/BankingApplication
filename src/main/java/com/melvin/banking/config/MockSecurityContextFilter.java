package com.melvin.banking.config;

import com.melvin.banking.common.model.CustomUser;
import com.melvin.banking.model.User;
import com.melvin.banking.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class MockSecurityContextFilter extends OncePerRequestFilter {
    private final UserRepository userRepository;

    public MockSecurityContextFilter(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final User mockUser = userRepository.findByUsername("tester1");

        final CustomUser userDetails = new CustomUser(
                mockUser.getId(),
                mockUser.getUsername(),
                null,
                Collections.emptyList()
        );

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                )
        );

        filterChain.doFilter(request, response);
    }
}
package com.melvin.banking.security;

import com.melvin.banking.common.constants.Constants;
import com.melvin.banking.common.model.CustomUser;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SecurityUtils {
    public static Optional<CustomUser> getCurrentUserDetails() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(authentication.getPrincipal())
                .filter(CustomUser.class::isInstance)
                .map(userDetails -> (CustomUser) userDetails);
    }

    public static CustomUser getCurrentUserDetailsSafely() {
        return getCurrentUserDetails().orElseThrow(() -> new InsufficientAuthenticationException(Constants.ErrorMessage.INSUFFICIENT_AUTHENTICATION));
    }
}

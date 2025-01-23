package com.melvin.banking.config;

import com.melvin.banking.common.constants.Constants;
import com.melvin.banking.common.exception.InvalidAccountDetailsException;
import com.melvin.banking.common.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String FAIL_PAGE = "fail";

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return FAIL_PAGE;
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        System.out.println(ex.getMessage());
        model.addAttribute("errorMessage", Constants.ErrorMessage.GENERIC_ERROR);
        return FAIL_PAGE;
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public String handleUserAlreadyExistsException(UserAlreadyExistsException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return FAIL_PAGE;
    }

    @ExceptionHandler(InvalidAccountDetailsException.class)
    public String handleInvalidAccountDetails(InvalidAccountDetailsException ex, Model model) {
        model.addAttribute("errorHeader", Constants.ErrorHeader.INVALID_ACCOUNT_DETAILS_HEADER);
        model.addAttribute("errorMessage", ex.getMessage());
        return FAIL_PAGE;
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public String handleInsufficientAccountException(InsufficientAuthenticationException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return FAIL_PAGE;
    }
}
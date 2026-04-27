package com.uskudar_uni.se302.exception;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ModelAndView handleNoResourceFound(NoResourceFoundException ex, HttpServletRequest request) {
        return createModelAndView(request, HttpStatus.NOT_FOUND, "The requested page could not be found", "error/404");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handleAccessDenied(AccessDeniedException ex, HttpServletRequest request) {
        return createModelAndView(request, HttpStatus.FORBIDDEN, "You do not have permission to access this resource", "error/403");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGenericException(Exception ex, HttpServletRequest request) {
        return createModelAndView(request, HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", "error/500");
    }

    private ModelAndView createModelAndView(
            HttpServletRequest request,
            HttpStatus status,
            String message,
            String viewName
    ) {
        ModelAndView modelAndView = new ModelAndView(viewName, status);
        modelAndView.addObject("timestamp", LocalDateTime.now());
        modelAndView.addObject("status", status.value());
        modelAndView.addObject("error", status.getReasonPhrase());
        modelAndView.addObject("message", message);
        modelAndView.addObject("path", request.getRequestURI());
        return modelAndView;
    }
}

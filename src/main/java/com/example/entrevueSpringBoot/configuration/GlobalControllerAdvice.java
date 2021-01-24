package com.example.entrevueSpringBoot.configuration;


import com.example.entrevueSpringBoot.controllers.exceptions.FilmNotFoundException;
import com.example.entrevueSpringBoot.dto.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.util.Collections;
import java.util.List;

/**
 * Class Filter exception GlobalControllerAdvice.
 */
@ControllerAdvice
public class GlobalControllerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerAdvice.class);
    private static final String UNKNOWN_EXCEPTION_TYPE = "Unknown exception type:";

    @ExceptionHandler({
            FilmNotFoundException.class,
    })
    @Nullable
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        LOGGER.error("Handling " + ex.getClass().getSimpleName() + " due to " + ex.getMessage());
        if (ex instanceof FilmNotFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            FilmNotFoundException unfe = (FilmNotFoundException) ex;
            return handleUserNotFoundException(unfe, headers, status, request);
        } else {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn(UNKNOWN_EXCEPTION_TYPE + " " + ex.getClass().getName());
            }
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, null, headers, status, request);
        }
    }

    /**
     * A single place to customize the response body of all Exception types.
     *
     * <p>The default implementation sets the {@link WebUtils#ERROR_EXCEPTION_ATTRIBUTE}
     * request attribute and creates a {@link ResponseEntity} from the given
     * body, headers, and status.
     *
     * @param ex      The exception
     * @param body    The body for the response
     * @param headers The headers for the response
     * @param status  The response status
     * @param request The current request
     */
    protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, @Nullable ApiError body,
                                                               HttpHeaders headers, HttpStatus status,
                                                               WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }

    /**
     * Customize the response for FilmNotFoundException.
     *
     * @param ex      The exception
     * @param headers The headers to be written to the response
     * @param status  The selected response status
     * @return a {@code ResponseEntity} instance
     */
    protected ResponseEntity<ApiError> handleUserNotFoundException(FilmNotFoundException ex,
                                                                   HttpHeaders headers, HttpStatus status,
                                                                   WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return handleExceptionInternal(ex, new ApiError(errors), headers, status, request);
    }
}
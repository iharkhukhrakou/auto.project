package auto.project.web.controller.rest.advice;

import auto.project.core.dto.error.ErrorMessageDTO;
import auto.project.core.exception.ResourceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<ErrorMessageDTO> handleResourceException(final ResourceException ex) {
        System.out.println("---------------------------RestResponseEntityExceptionHandler--------------------------------");
        return ResponseEntity.status(ex.getErrorCode()).body(ErrorMessageDTO.builder()
                .status(ex.getErrorCode())
                .code(ex.getErrorCode())
                .message(ex.getMessage())
                .build());
    }
}

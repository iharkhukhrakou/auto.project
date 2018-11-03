package auto.project.web.controller.rest.advice;

import auto.project.web.controller.rest.error.ErrorValidation;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.constraints.NotNull;
import java.util.Locale;

@RestControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;
    private final Locale currentLocale =  LocaleContextHolder.getLocale();

    public RestControllerExceptionHandler(@NotNull final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("-----------------------------------------");
        String message = "HTTP " + ex.getHttpMethod() + " for " + ex.getRequestURL() + " is not supported.";
        return super.handleNoHandlerFoundException(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //ResponseEntity.badRequest().headers(new HttpHeaders()).body();
        final ErrorValidation errorValidation = new ErrorValidation();

        ex.getBindingResult().getFieldErrors().stream().forEach(
                fieldError->{
                    errorValidation.addFieldError(fieldError.getField(),messageSource.getMessage(fieldError, currentLocale));
                });
        return new ResponseEntity<>(errorValidation, headers, status);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        System.out.println("-----     -----     HANDLE ALL     -----     -----");
        return new ResponseEntity<Object>(ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

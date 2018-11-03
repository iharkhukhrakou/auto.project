package auto.project.web.controller.rest.advice;

import auto.project.web.controller.rest.error.ErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Locale;

//@RestControllerAdvice
public class DTOValidationExceptionHandler {
    private final MessageSource messageSource;

    @Autowired
    public DTOValidationExceptionHandler(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorValidation processValidationError(final MethodArgumentNotValidException ex) {
        final BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();

        return processFieldErrors(fieldErrors);
    }

    private ErrorValidation processFieldErrors(final List<FieldError> fieldErrors) {
        final ErrorValidation dto = new ErrorValidation();

        for (final FieldError fieldError: fieldErrors) {
            final String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
            dto.addFieldError(fieldError.getField(), localizedErrorMessage);
            //dto.addFieldError(fieldError.getField(), fieldError.toString());
        }
        return dto;
    }

    private String resolveLocalizedErrorMessage(final FieldError fieldError) {
        final Locale currentLocale =  LocaleContextHolder.getLocale();

        //If the message was not found, return the most accurate field error code instead.
        //You can remove this check if you prefer to get the default error message.
        //if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
        //    String[] fieldErrorCodes = fieldError.getCodes();
        //    localizedErrorMessage = fieldErrorCodes[0];
        //}

        return messageSource.getMessage(fieldError, currentLocale);
    }
}

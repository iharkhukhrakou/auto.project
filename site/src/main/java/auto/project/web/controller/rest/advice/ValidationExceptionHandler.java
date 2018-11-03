package auto.project.web.controller.rest.advice;

import auto.project.web.controller.rest.error.ErrorValidation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

//@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorValidation processValidationError(final ConstraintViolationException ex) {
        final ErrorValidation errorvalidation = new ErrorValidation();

        final Set<ConstraintViolation<?>> set =  ex.getConstraintViolations();

        //for (Iterator<ConstraintViolation<?>> iterator = set.iterator(); iterator.hasNext(); ) {
        //    ConstraintViolation<?> next =  iterator.next();

        //    validationErrorDTO.getFieldErrors()
        //            .add(new ErrorFieldDTO(((PathImpl)next.getPropertyPath()).getLeafNode().getName(),
        //                    next.getMessage()));
        //}

        return errorvalidation;
    }
}

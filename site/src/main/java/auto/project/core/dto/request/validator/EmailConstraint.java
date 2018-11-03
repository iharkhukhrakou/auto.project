package auto.project.core.dto.request.validator;

import auto.project.core.dto.request.validator.impl.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target( {ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraint {
    String message() default "Please enter a valid e-mail address.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

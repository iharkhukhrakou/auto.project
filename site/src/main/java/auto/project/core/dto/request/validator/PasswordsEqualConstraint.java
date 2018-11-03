package auto.project.core.dto.request.validator;


import auto.project.core.dto.request.validator.impl.PasswordsEqualConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordsEqualConstraintValidator.class)
@Target( {ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordsEqualConstraint {
    String message() default "Passwords are not equal.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

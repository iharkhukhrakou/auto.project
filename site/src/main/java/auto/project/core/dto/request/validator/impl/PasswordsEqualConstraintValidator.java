package auto.project.core.dto.request.validator.impl;

import auto.project.core.dto.request.RegistrationDTO;
import auto.project.core.dto.request.validator.PasswordsEqualConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsEqualConstraintValidator implements ConstraintValidator<PasswordsEqualConstraint, Object> {

    @Override
    public void initialize(PasswordsEqualConstraint constraintAnnotation) {}

    @Override
    public boolean isValid(Object candidate, ConstraintValidatorContext context) {
        System.out.println("777777");
        final RegistrationDTO registationDTO = (RegistrationDTO) candidate;
        System.out.println(registationDTO.getPassword());
        return registationDTO.getPassword().equals(registationDTO.getPasswordconfirm());
    }
}
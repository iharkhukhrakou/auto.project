package auto.project.core.service;

import auto.project.core.dto.request.RegistrationDTO;
import auto.project.core.exception.ResourceConflictException;

import javax.validation.Valid;

//@Validated
public interface AccountService {
    String createUser(@Valid final RegistrationDTO registerDTO) throws ResourceConflictException;
}

package auto.project.core.service;

import auto.project.core.dto.Account;
import auto.project.core.exception.ResourceNotFoundException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

//@Validated
public interface AccountSearchService {
    boolean existsByEmail(@NotBlank @Email final String email);
    Account getByEmail(@NotBlank @Email final String email) throws ResourceNotFoundException;
}

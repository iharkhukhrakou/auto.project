package auto.project.core.dao;

import auto.project.core.jpa.entity.AccountEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

public interface AccountDAO {
    Boolean existsByEmail(@NotBlank @Email final String email);
    Optional<AccountEntity> findByEmail(@NotBlank @Email final String email);
    void save(final AccountEntity account);
}

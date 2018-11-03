package auto.project.core.service.impl;

import auto.project.core.dao.AccountDAO;
import auto.project.core.dto.Account;
import auto.project.core.exception.ResourceNotFoundException;
import auto.project.core.service.AccountSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Service("accountSearchService")
@Transactional(readOnly = true)
//@Validated
public class AccountSearchServiceImpl implements AccountSearchService {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountSearchServiceImpl(final AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public boolean existsByEmail(@NotBlank @Email final String email) {
        return accountDAO.existsByEmail(email);
    }

    @Override
    public Account getByEmail(@NotBlank @Email final String email) throws ResourceNotFoundException {


        return null;
    }


}

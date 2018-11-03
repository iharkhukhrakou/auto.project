package auto.project.core.service.impl;

import auto.project.core.dao.AccountDAO;
import auto.project.core.dto.request.RegistrationDTO;
import auto.project.core.exception.ResourceConflictException;
import auto.project.core.jpa.entity.AccountEntity;
import auto.project.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service("accountService")
public class AccountSetviceImpl implements AccountService {
    private final AccountDAO accountDAO;

    @Autowired
    private AccountSetviceImpl(@NotNull final AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    @Override
    public String createUser(@Valid RegistrationDTO registerDTO) throws ResourceConflictException {
        return null;
    }
}

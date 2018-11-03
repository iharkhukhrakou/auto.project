package auto.project.core.jpa.dao;

import auto.project.core.dao.AccountPropertyDAO;
import auto.project.core.jpa.entity.AccountPropertyEntity;
import org.springframework.stereotype.Repository;

@Repository("accountPropertyDao")
public class AccountPropertyJpaImpl extends AbstractJpa<Long, AccountPropertyEntity> implements AccountPropertyDAO {

    @Override
    public void save(AccountPropertyEntity account) {
        
    }
}

package auto.project.core.jpa.dao;

import auto.project.core.dao.AccountDAO;
import auto.project.core.jpa.entity.AccountEntity;
import auto.project.core.jpa.entity.AccountEntity_;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository("accountDao")
public class AccountJpaImpl extends AbstractJpa<Long, AccountEntity> implements AccountDAO {

    public AccountJpaImpl() {
        super();
    }

    @Override
    public Boolean existsByEmail(@NotBlank @Email final String email) {
        return findByEmail(email).isPresent();
    }

    @Override
    public Optional<AccountEntity> findByEmail(final String email) {
        CriteriaBuilder qb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AccountEntity> cq = qb.createQuery(AccountEntity.class);
        Root<AccountEntity> r = cq.from(AccountEntity.class);
        cq.select(r);
        cq.where(qb.equal(r.get(AccountEntity_.email), email));
        TypedQuery<AccountEntity> typed = getEntityManager().createQuery(cq);

        return typed.getResultStream().findFirst();
    }

    @Override
    public void save(final AccountEntity account) {
        persist(account);
        //getByPK(account.getId()).ifPresent();
    }


    public void test(Long id) {
        System.out.println(getByPK(id).isPresent());
        //if(getByPK(account.getId())== null){
        //    persist(account);
        //} else {
        //    update(account);
        //}
    }
}

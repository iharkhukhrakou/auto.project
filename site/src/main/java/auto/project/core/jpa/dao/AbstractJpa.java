package auto.project.core.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

public abstract class AbstractJpa<PK extends Serializable, T> {

    protected final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractJpa(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager(){
        return this.entityManager;
    }

    protected Optional<T> getByPK(PK key) {
        T entity = entityManager.find(persistentClass, key);
        if (entity==null) {
            return Optional.empty();
        }else{
            return Optional.of(entity);
        }
    }


    protected void persist(T entity) {
        entityManager.persist(entity);
    }

    protected void update(T entity) {
        entityManager.merge(entity);
    }

    protected void delete(T entity) {
        entityManager.remove(entity);
    }


}

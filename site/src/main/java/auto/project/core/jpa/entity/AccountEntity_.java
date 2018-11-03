package auto.project.core.jpa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AccountEntity.class)
public abstract class AccountEntity_ {

	public static volatile SingularAttribute<AccountEntity, String> firstName;
	public static volatile SingularAttribute<AccountEntity, String> lastName;
	public static volatile SingularAttribute<AccountEntity, String> password;
	public static volatile SingularAttribute<AccountEntity, Long> id;
	public static volatile SingularAttribute<AccountEntity, String> email;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String PASSWORD = "password";
	public static final String ID = "id";
	public static final String EMAIL = "email";

}


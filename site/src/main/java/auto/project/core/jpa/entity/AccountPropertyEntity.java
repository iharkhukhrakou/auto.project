package auto.project.core.jpa.entity;

import auto.project.core.dto.SecurityRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "accounts_properties")
public class AccountPropertyEntity implements Serializable {
    //@Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    //@Column(unique = true, nullable = false, updatable = false)
    //private Long id;

    @Id
    @Column(name = "account_id", unique = true, nullable = false, updatable = false)
    private Long accountID;

    //@Column(name = "activation_token")
    //private String activationToken;

    //@ElementCollection(fetch = FetchType.EAGER)
    //@CollectionTable(
    //        name = "accounts_authorities",
    //        joinColumns = {
    //                @JoinColumn(name = "account_id", nullable = false, updatable = false)
    //        }
    //)
    //@Column(name = "authority", nullable = false, updatable = false)
    //@Enumerated(EnumType.STRING)
    //private Set<SecurityRole> authorities;
}

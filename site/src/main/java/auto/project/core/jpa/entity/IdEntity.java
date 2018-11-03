package auto.project.core.jpa.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@ToString
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public class IdEntity implements Serializable {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;
}

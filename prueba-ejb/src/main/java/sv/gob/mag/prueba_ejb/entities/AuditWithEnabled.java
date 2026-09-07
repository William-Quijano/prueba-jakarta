package sv.gob.mag.prueba_ejb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AuditWithEnabled extends Audit {

    @Column(name = "ENABLED" , columnDefinition = "NUMBER(1)", nullable = false)
    private Integer enabled;
}

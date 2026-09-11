package sv.gob.mag.ejb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import sv.gob.mag.dto.enums.EnabledEnum;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public class AuditWithEnabled extends Audit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "ENABLED" , columnDefinition = "NUMBER(1)", nullable = false)
    private EnabledEnum enabled;
}

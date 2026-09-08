package sv.gob.mag.ejb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sv.gob.mag.ejb.entities.listeners.AuditListener;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PARENT_DETAIL", schema = "TEMPLATEDB")
@EntityListeners(AuditListener.class)
public class ParentDetail extends Audit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME" , columnDefinition = "VARCHAR2(210 CHAR)")
    private String name;

    @Column(name = "QUANTITY", precision = 19, scale = 4, columnDefinition = "NUMBER(19, 4)")
    private BigDecimal quantity;

    @ManyToOne()
    @JoinColumn(name = "ID_PARENT", referencedColumnName = "ID", nullable = false)
    private Parent parent;
}

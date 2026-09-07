package sv.gob.mag.prueba_ejb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sv.gob.mag.prueba_ejb.enums.StatusEnum;
import sv.gob.mag.prueba_ejb.entities.listeners.AuditListener;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "PARENT", schema = "TEMPLATEDB")
@EntityListeners(AuditListener.class)
public class Parent extends AuditWithEnabled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE", columnDefinition = "VARCHAR2(255)", nullable = false, unique = true, updatable = false)
    private UUID code;

    @Column(name = "NAME",  columnDefinition = "VARCHAR2(100)", nullable = false)
    private String name;

    @Column(name = "STATUS", columnDefinition = "VARCHAR2(9, CHAR)" )
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<ParentDetail> parentDetails;

}
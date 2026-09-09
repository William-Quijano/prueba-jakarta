package sv.gob.mag.ejb.entities;

import jakarta.persistence.*;

import lombok.*;
import sv.gob.mag.dto.response.ParentDetailResponseDTO;
import sv.gob.mag.ejb.enums.StatusEnum;
import sv.gob.mag.ejb.entities.listeners.AuditListener;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "PARENT", schema = "TEMPLATEDB")
@EntityListeners(AuditListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Parent extends AuditWithEnabled implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE", columnDefinition = "VARCHAR2(255)", nullable = false, unique = true, updatable = false)
    private String code;

    @Column(name = "NAME",  columnDefinition = "VARCHAR2(100)", nullable = false)
    private String name;

    @Column(name = "STATUS", columnDefinition = "VARCHAR2(9, CHAR)" )
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParentDetail> parentDetails;

}
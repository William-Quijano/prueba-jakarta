package sv.gob.mag.prueba_ejb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PARENT")
public class Parent extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE", columnDefinition = "VARCHAR2(255)", nullable = false)
    private String code;

    @Column(name = "NAME",  columnDefinition = "VARCHAR2(100)", nullable = false)
    private String name;

    @Column(name = "STATUS", columnDefinition = "VARCHAR2(9, CHAR)" )
    private String status;

    @Column(name = "ENABLED")
    private int enable;

}
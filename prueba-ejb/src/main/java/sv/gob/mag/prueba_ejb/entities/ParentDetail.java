package sv.gob.mag.prueba_ejb.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PARENT_DETAIL")
public class ParentDetail extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME" , columnDefinition = "VARCHAR2(210 CHAR)")
    private String name;

    @Column(name = "QUANTITY", columnDefinition = "RAW(255)")
    private byte[] quantity;


}

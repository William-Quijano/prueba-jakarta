package sv.gob.mag.prueba_ejb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class Audit {

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "CREATED_AT", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "CREATED_BY")
    private Long updateBy;

    @Column(name = "UPDATED_AT", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.createdBy = 1L;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
        this.updateBy = 1L;
    }
    
}

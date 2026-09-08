package sv.gob.mag.ejb.entities.listeners;

import jakarta.persistence.PrePersist;
import sv.gob.mag.ejb.entities.Audit;
import sv.gob.mag.ejb.entities.AuditWithEnabled;
import sv.gob.mag.ejb.entities.Parent;
import sv.gob.mag.ejb.enums.StatusEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class AuditListener {

    @PrePersist
    public void lifeCycle(Object entity){
        if(entity instanceof Audit audit){
            registerDatesAudit(audit);
        }

        if(entity instanceof AuditWithEnabled auditWithEnabled){
            registerEnabled(auditWithEnabled);
        }

        if(entity instanceof Parent parent){
            registerCode(parent);
        }
    }

    private void registerDatesAudit(Audit audit){
        audit.setCreatedAt(LocalDateTime.now());
        audit.setCreatedBy(1L);
    }

    private void registerEnabled(AuditWithEnabled auditWithEnabled){
        if (auditWithEnabled.getEnabled() != null) return;
        auditWithEnabled.setEnabled(1);

    }

    private void registerCode(Parent parent){
        parent.setStatus(StatusEnum.PENDIENTE);
        if(parent.getCode() != null) return;
        parent.setCode(UUID.randomUUID());

    }
}

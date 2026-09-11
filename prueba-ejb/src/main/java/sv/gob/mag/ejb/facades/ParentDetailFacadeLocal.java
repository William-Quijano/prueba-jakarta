package sv.gob.mag.ejb.facades;

import jakarta.ejb.Local;
import sv.gob.mag.dto.response.ParentDetailResponseDTO;
import sv.gob.mag.ejb.entities.ParentDetail;

import java.util.Optional;

@Local
public interface ParentDetailFacadeLocal {
    Optional<ParentDetail> findById(Long idParentDetail);

    ParentDetailResponseDTO save(ParentDetail parentDetail);

    void update(ParentDetail parentDetail);

    void remove(ParentDetail parentDetail);


}

package sv.gob.mag.prueba_ejb.services;

import jakarta.ejb.Local;
import sv.gob.mag.prueba.api.dto.ParentDetailRequestDTO;
import sv.gob.mag.prueba_ejb.entities.ParentDetail;

import java.util.List;

@Local
public interface ParentDetailService {
    List<ParentDetail> listParent();
    ParentDetail saveParent (ParentDetailRequestDTO parentDetailRequestDto);
    ParentDetail findParentById (Long idParentDetail);
    ParentDetail updateParent (Long idParentDetail, ParentDetailRequestDTO parentDetailRequestDto);
    ParentDetail removeParent (Long idParentDetail);
}

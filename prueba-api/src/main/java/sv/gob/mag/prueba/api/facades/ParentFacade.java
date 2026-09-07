package sv.gob.mag.prueba.api.facades;

import sv.gob.mag.prueba.api.dto.ParentRequestDTO;
import sv.gob.mag.prueba.api.dto.ParentResponseDTO;

import java.util.List;

public interface ParentFacade {
    List<ParentResponseDTO> getListParent();

}

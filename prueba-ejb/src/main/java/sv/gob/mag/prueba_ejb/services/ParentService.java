package sv.gob.mag.prueba_ejb.services;

import jakarta.ejb.Local;
import sv.gob.mag.prueba.api.dto.ParentRequestDTO;
import sv.gob.mag.prueba_ejb.entities.Parent;

import java.util.List;

@Local
public interface ParentService {

    List<Parent> listParent();
    Parent saveParent (ParentRequestDTO parentRequestDto);
    Parent findParentById (Long idParent);
    Parent updateParent (Long idParent, ParentRequestDTO parentRequestDto);
    Parent removeParent (Long idParent);
}

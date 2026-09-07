package sv.gob.mag.prueba_ejb.repositories;


import sv.gob.mag.prueba.api.dto.ParentRequestDTO;
import sv.gob.mag.prueba.api.dto.ParentResponseDTO;
import sv.gob.mag.prueba_ejb.entities.Parent;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ParentRepository {
    List<Parent> listAll();
    Parent save (ParentRequestDTO parentRequestDto);
    Optional<Parent> findById (Long idParent);
    Optional<Parent> findByCode (UUID codeParent);
    Parent update (Long idParent, ParentRequestDTO parentRequestDto);
    Parent remove (Long idParent);
}

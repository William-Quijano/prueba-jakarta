package sv.gob.mag.ejb.facades;

import jakarta.ejb.Local;
import sv.gob.mag.dto.request.ParentRequestDTO;
import sv.gob.mag.ejb.entities.Parent;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Local
public interface ParentFacadeLocal {
    List<Parent> listAll(Integer page, Integer prePage);
    Parent save(ParentRequestDTO parentRequestDto);
    Optional<Parent> findById(Long idParent);
    Optional<Parent> findByCode(UUID codeParent);
    Parent update(Long idParent, ParentRequestDTO parentRequestDto);
    Parent remove(Long idParent);
}
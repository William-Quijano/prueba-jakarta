package sv.gob.mag.ejb.facades;

import jakarta.ejb.Local;
import sv.gob.mag.ejb.entities.Parent;

import java.util.List;
import java.util.Optional;

@Local
public interface ParentFacadeLocal {
    List<Parent> getAll(Integer page, Integer prePage);
    Parent save(Parent parent);
    Optional<Parent> findById(Long idParent);
    Optional<Parent> findByCode(String codeParent);
    void update(Parent parent);
    void remove(Parent Parent);
    Long countAll();
    void updateEnabled(Parent parent);
}
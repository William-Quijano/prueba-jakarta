package sv.gob.mag.ejb.facades;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sv.gob.mag.dto.response.ParentDetailResponseDTO;
import sv.gob.mag.ejb.entities.ParentDetail;

import java.util.Optional;

@Stateless
public class ParentDetailFacade implements ParentDetailFacadeLocal {

    @PersistenceContext(unitName = "prueba_jakarta")
    private EntityManager em;

    @Override
    public Optional<ParentDetail> findById(Long idParentDetail) {
        return Optional.empty();
    }

    @Override
    public ParentDetailResponseDTO save(ParentDetail parentDetail) {
        em.persist(parentDetail);
        return null;
    }

    @Override
    public void update(ParentDetail parentDetail) {

    }

    @Override
    public void remove(ParentDetail parentDetail) {

    }
}

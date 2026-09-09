package sv.gob.mag.ejb.facades;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.TypedQuery;
import lombok.NoArgsConstructor;
import sv.gob.mag.dto.request.ParentRequestDTO;
import sv.gob.mag.ejb.entities.Parent;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Stateless
public class ParentFacade implements ParentFacadeLocal {


    @PersistenceContext(unitName = "prueba_jakarta")
    private EntityManager em;


    @Override
    public List<Parent> listAll(Integer page, Integer perPage) {
        TypedQuery<Parent> query = em.createQuery(
                "SELECT p FROM Parent p ORDER BY p.id DESC", Parent.class);
        query.setFirstResult((page - 1) * perPage);
        query.setMaxResults(perPage);
        List<Parent> parents = query.getResultList();

        if (!parents.isEmpty()) {
            em.createQuery(
                            "SELECT DISTINCT p FROM Parent p LEFT JOIN FETCH p.parentDetails WHERE p IN :parents",
                            Parent.class)
                    .setParameter("parents", parents)
                    .getResultList();
        }
        return parents;
    }

    @Override
    public Long countAll() {
        return em.createQuery("SELECT COUNT(p) FROM Parent p", Long.class).getSingleResult();
    }

    @Override
    public Parent save(Parent parent) {
        em.persist(parent);
        return parent;
    }

    @Override
    public Optional<Parent> findById(Long idParent) {
        return Optional.empty();
    }

    @Override
    public Optional<Parent> findByCode(UUID codeParent) {
        return Optional.empty();
    }

    @Override
    public Parent update(Long idParent, Parent parent) {
        return null;
    }

    @Override
    public Parent remove(Long idParent) {
        return null;
    }
}

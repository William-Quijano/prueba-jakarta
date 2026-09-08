package sv.gob.mag.ejb.facades;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.TypedQuery;
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
        EntityGraph<Parent> graph = em.createEntityGraph(Parent.class);
        graph.addSubgraph("parentDetails");


        TypedQuery<Parent> query = em.createQuery("SELECT p FROM Parent p ORDER BY p.id ASC", Parent.class);

        query.setFirstResult((page - 1) * perPage);
        query.setMaxResults(perPage);


        query.setHint("jakarta.persistence.fetchgraph", graph);

        List<Parent> parents = query.getResultList();
        return parents;
    }


    @Override
    public Parent save(ParentRequestDTO parentRequestDto) {
        return null;
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
    public Parent update(Long idParent, ParentRequestDTO parentRequestDto) {
        return null;
    }

    @Override
    public Parent remove(Long idParent) {
        return null;
    }
}

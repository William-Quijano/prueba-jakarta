package sv.gob.mag.prueba_ejb.repositories.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import sv.gob.mag.prueba.api.dto.ParentRequestDTO;

import sv.gob.mag.prueba_ejb.entities.Parent;
import sv.gob.mag.prueba_ejb.repositories.ParentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ParentRepositoryImpl implements ParentRepository {

    @PersistenceContext(unitName = "prueba_jakarta")
    private EntityManager em;

    @Override
    public List<Parent> listAll() {
        String queryString = "SELECT p FROM Parent p WHERE p.enabled = 1";
        TypedQuery<Parent> query = em.createQuery(queryString, Parent.class);

        EntityGraph<Parent> parentGraph = em.createEntityGraph(Parent.class);
        parentGraph.addAttributeNodes("parentDetails");

        query.setHint("jakarta.persistence.fetchgraph", parentGraph);

        return query.getResultList();
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

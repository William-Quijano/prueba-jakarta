package sv.gob.mag.ejb.facades;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.TypedQuery;
import sv.gob.mag.ejb.entities.Parent;

import java.util.List;
import java.util.Optional;


@Stateless
public class ParentFacade implements ParentFacadeLocal {


    @PersistenceContext(unitName = "prueba_jakarta")
    private EntityManager em;


    /**
     * Lista todo los parents con sus respectivos detalles
     *
     * @return {parents} lista de parent con sus detalles
     * @rarams {page, perPage}
     *
     */
    @Override
    public List<Parent> getAll(Integer page, Integer perPage) {
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


    /**
     * Obtiene la cantidad de parents totales
     *
     * @return La cantidad totales de parent
     * @rarams N/A
     *
     */
    @Override
    public Long countAll() {
        return em.createQuery("SELECT COUNT(p) FROM Parent p", Long.class).getSingleResult();
    }

    /**
     * Guarda un nuevo registro
     *
     * @return El nuevo registro guardado
     * @rarams {Parent parent}
     *
     */
    @Override
    public Parent save(Parent parent) {
        em.persist(parent);
        return parent;
    }


    /**
     * Busca un registro por el id
     *
     * @return null || El parent que coincida con el id
     * @rarams {Long idParent}
     *
     */
    @Override
    public Optional<Parent> findById(Long idParent) {
        return Optional.ofNullable(em.find(Parent.class, idParent));
    }

    /**
     * Busca un registro por el code
     *
     * @return null || El parent que coincida con el code
     * @rarams {String code}
     *
     */
    @Override
    public Optional<Parent> findByCode(String code) {
        return Optional.empty();
    }


    /**
     * Actualiza un registro
     *
     * @return El registro actualizado
     * @rarams {Long id, Parent parent}
     *
     */
    @Override
    public Parent update(Parent parent) {
        parent.setName(parent.getName());
        parent.setStatus(parent.getStatus());
        return em.merge(parent);
    }


    /**
     * Elimina un registro
     *
     * @return El registro eliminado
     * @rarams {Long id}
     *
     */
    @Override
    public Parent remove(Long idParent) {
        return null;
    }
}

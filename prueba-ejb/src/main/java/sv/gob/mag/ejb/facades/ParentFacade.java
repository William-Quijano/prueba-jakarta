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
                "SELECT DISTINCT p FROM Parent p LEFT JOIN FETCH p.parentDetails ORDER BY p.id DESC", Parent.class);
        query.setFirstResult((page - 1) * perPage);
        query.setMaxResults(perPage);
        return query.getResultList();
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
    public void update(Parent parent) {
        Parent parentUpdate = em.merge(parent);
        parentUpdate.setName(parent.getName());
        parentUpdate.setStatus(parent.getStatus());
    }


    /**
     * Elimina un registro
     *
     * @return El registro eliminado
     * @rarams {Long id}
     *
     */
    @Override
    public void remove(Parent parent) {
        if (!em.contains(parent)) {
            parent = em.merge(parent);
        }
        em.remove(parent);
    }

    @Override
    public void updateEnabled(Parent parent) {
        Parent parentUpdate = em.merge(parent);
        parentUpdate.setEnabled(parent.getEnabled());
    }
}

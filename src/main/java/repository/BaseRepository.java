package repository;

import entity.BaseEntity;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepository<T extends BaseEntity>  {
    protected EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    public T save(T entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        } else {

            return null;
        }
    }

    public T update(T entity) {
        if (entity.getId() != null) {
            entityManager.merge(entity);
            return entity;
        } else {
            return null;
        }
    }

    public Boolean delete(T entity) {
        if (entity.getId() != null) {
            entityManager.remove(entity);
            return true;
        } else {
            return false;
        }
    }

    public Optional<T> loadById(ID id) {
        return Optional.ofNullable(entityManager.find(getEntityClass(), id));
    }

    public abstract Class<T> getEntityClass();

    public List<T> loadAll() {
        return entityManager.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass()).
                getResultList();
    }

    public Boolean contains(T entity) {
        return entity.getId() != null;
    }
}

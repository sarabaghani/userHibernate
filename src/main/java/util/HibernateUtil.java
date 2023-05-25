package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
private static final EntityManagerFactory ENTITY_MANAGER_FACTORY
        = Persistence.createEntityManagerFactory("user");
    public static EntityManagerFactory getEntityManagerFactory(){
        return ENTITY_MANAGER_FACTORY;
    }
}

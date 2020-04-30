package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static EntityManagerFactory emf;

    private PersistenceUtil() {

    }
    public static EntityManagerFactory getFactory(){
        if(emf==null)
        {
            emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        }
        return emf;
    }
}

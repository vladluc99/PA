package repo;

import entity.Artist;
import util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {

    public void create(Artist artist){
        EntityManager em= PersistenceUtil.getFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        em.close();
        PersistenceUtil.getFactory().close();
    }

    public Artist findById(int id){
        EntityManager em = PersistenceUtil.getFactory().createEntityManager();
        return em.find(Artist.class,id);
    }

    public List<Artist> findByName(String name){
        EntityManager em = PersistenceUtil.getFactory().createEntityManager();
       // List<Artist> artistList = new ArrayList<>();

        Query query = em.createNamedQuery("Artist.findByName")
                .setParameter("name",name);
        return query.getResultList();
    }

}

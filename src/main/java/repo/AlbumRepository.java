package repo;

import entity.Album;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AlbumRepository {
    public void create(Album album){
        EntityManager em= PersistenceUtil.getFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        em.close();
        PersistenceUtil.getFactory().close();
    }

    public Album findById(int id){
        EntityManager em = PersistenceUtil.getFactory().createEntityManager();
        return em.find(Album.class,id);
    }

    public List<Album> findByName(String name){
        EntityManager em = PersistenceUtil.getFactory().createEntityManager();
        Query query = em.createNamedQuery("Album.findByName")
                .setParameter("name",name);
        return query.getResultList();
    }

    public List<Album> findByArtist(int id){
        EntityManager em = PersistenceUtil.getFactory().createEntityManager();
        Query query = em.createNamedQuery("Album.findByArtist")
                .setParameter("id",id);
        return query.getResultList();
    }
}

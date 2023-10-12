package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try {
            Movie movie = new Movie();
            movie.setActor("actor1");
            movie.setDirector("director1");
            movie.setPrice(1000);
            movie.setName("movie1");
            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }
        finally {
              em.close();

        }

        emf.close();
    }
}

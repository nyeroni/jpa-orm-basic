package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try {
             
            Team team  = new Team();
            team.setName("teamA");
            em.persist(team);
            
            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);
            

            em.flush();
            em.clear();
            
            
            Member m = em.find(Member.class, member.getId());

            System.out.println("m.getTeam().getCreatedBy() = " + m.getTeam().getCreatedBy());

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

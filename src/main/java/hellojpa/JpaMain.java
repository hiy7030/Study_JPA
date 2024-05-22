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
            // 전체 회원 조회 : JPQL 사용
            List<Member> members = em.createQuery("select m from Member as m", Member.class).getResultList();

            for(Member m : members) {
                System.out.println("id: "+ m.getId() + ", name: " + m.getName());
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

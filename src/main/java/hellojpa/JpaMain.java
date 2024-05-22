package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {
        // 서버 실행 시, 생성되어 서버가 종료될 때 종료
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 클라이언트의 요청이 올때마다 생성되고 종료
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("bye");

            // 수정을 했으니 저장을 해야 하나? -> JPA는 하나의 트랜잭션에서 이루어진 변경을 감지하여 자동으로 변경해준다.
//            em.persist(findMember);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

package com.tenco.blog_v1.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository // IoC
public class UserRepository {

    private final EntityManager em;

    /**
     * 사용자 저장 메서드 (JPA API 사용)
     * @param user
     * @return 저장된 사용자 엔티티
     */
    @Transactional
    public User save(User user) {
        // JPQL 은 INSERT 구문을 직접 지원하지 않습니다.
        em.persist(user); // 영속화
        return  user;
    }



    /**
     * 사용자 이름과 비밀번호로 사용자 조회
     * @param username
     * @param password
     * @return 조회된 User 엔티티, null
     */
    public User findByUsernameAndPassword(String username, String password) {
        TypedQuery<User> jpql =
                em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        jpql.setParameter("username", username);
        jpql.setParameter("password", password);
        return jpql.getSingleResult();
    }

}

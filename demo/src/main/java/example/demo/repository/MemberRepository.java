package example.demo.repository;

import example.demo.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager entityManager;

    public Member findMember(Long id) {
        return entityManager.find(Member.class, id);
    }

}

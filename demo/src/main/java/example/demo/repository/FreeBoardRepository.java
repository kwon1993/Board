package example.demo.repository;

import example.demo.domain.FreeBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public abstract class FreeBoardRepository {

    private final EntityManager entityManager;

    public List<FreeBoard> freeBoardList() {
        return null;
    }

    public FreeBoard findFreeBoardById(Long id) {
        return entityManager.find(FreeBoard.class, id);
    }

    public FreeBoard findNewFreeBoardByName(Long id) {
        String query = "select f from FreeBoard f where f.writer = :writer order by f.id desc";
        return entityManager.createQuery(query, FreeBoard.class)
                .setParameter("writer", id)
                .setFirstResult(0)
                .setMaxResults(1)
                .getSingleResult();
    }

    public void saveFreeBoard(FreeBoard freeBoard) {
        entityManager.persist(freeBoard);
    }

    public void deleteFreeBoard(Long id) {

    }

}

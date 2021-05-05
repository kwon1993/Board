package example.demo.repository;

import example.demo.domain.FreeBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FreeBoardRepository {

    private final EntityManager entityManager;

    public List<FreeBoard> freeBoardList() {
        return null;
    }

    public FreeBoard findFreeBoardById(Long id) {
        return entityManager.find(FreeBoard.class, id);
    }

    public FreeBoard findFreeBoardByName(Long id) {
        return null;
    }

    public void saveFreeBoard(FreeBoard freeBoard) {
        entityManager.persist(freeBoard);
    }

    public void deleteFreeBoard(Long id) {

    }

}

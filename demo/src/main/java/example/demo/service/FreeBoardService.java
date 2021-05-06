package example.demo.service;

import example.demo.domain.FreeBoard;
import example.demo.domain.Member;
import example.demo.dto.FreeBoardEdit;
import example.demo.dto.FreeBoardRead;
import example.demo.dto.FreeBoardWrite;
import example.demo.repository.FreeBoardRepository;
import example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;
    private final MemberRepository memberRepository;

    public List<FreeBoardRead> freeBoardList() {
        List<FreeBoardRead> freeBoardReadList = new ArrayList<>();
        List<FreeBoard> freeBoards = freeBoardRepository.freeBoardList();
        for (FreeBoard freeBoard : freeBoards) {
            freeBoardReadList.add(new FreeBoardRead(
                    freeBoard.getId(),
                    freeBoard.getTitle(),
                    freeBoard.getWriter().getId(),
                    memberRepository.findMember(freeBoard.getWriter().getId()).getNickname(),
                    freeBoard.getContent(),
                    freeBoard.getWriteDate(),
                    freeBoard.getModifyDate(),
                    freeBoard.getViewCount(),
                    freeBoard.getReplyCount()
                    )
            );
        }
        return freeBoardReadList;
    }

    public FreeBoardRead readFreeBoard(Long id) {
        FreeBoard freeBoard = freeBoardRepository.findFreeBoardById(id);
        FreeBoardRead freeBoardRead = new FreeBoardRead(
                freeBoard.getId(),
                freeBoard.getTitle(),
                freeBoard.getWriter().getId(),
                memberRepository.findMember(freeBoard.getWriter().getId()).getNickname(),
                freeBoard.getContent(),
                freeBoard.getWriteDate(),
                freeBoard.getModifyDate(),
                freeBoard.getViewCount(),
                freeBoard.getReplyCount()
        );
        return freeBoardRead;
    }

    public Long saveFreeBoard(FreeBoardWrite freeBoardWrite) {
        Member member = memberRepository.findMember(freeBoardWrite.getWriterId());
        FreeBoard freeBoard = new FreeBoard(
                freeBoardWrite.getTitle(),
                member,
                freeBoardWrite.getContent()
        );
        freeBoardRepository.saveFreeBoard(freeBoard);
        return freeBoardRepository.findNewFreeBoardByName(member.getId()).getId();
    }

    public void editFreeBoard(FreeBoardEdit freeBoardEdit) {
        FreeBoard freeBoard = freeBoardRepository.findFreeBoardById(freeBoardEdit.getId());
        freeBoard.editFreeBoard(freeBoardEdit.getTitle(), freeBoardEdit.getContent());
    }
}

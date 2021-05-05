package example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FreeBoardReply {

    @Id
    @GeneratedValue
    @Column(name = "free_board_reply_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "free_board_id")
    private FreeBoard freeBoardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

    private String content;
    private LocalDateTime writeDate;
    private LocalDateTime modifyDate;

    public FreeBoardReply(FreeBoard freeBoardId, Member writer, String content) {
        this.freeBoardId = freeBoardId;
        this.writer = writer;
        this.content = content;
        this.writeDate = LocalDateTime.now();
    }
}

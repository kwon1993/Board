package example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FreeBoard {

    @Id
    @GeneratedValue
    @Column(name = "free_board_id")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

    private String content;
    private LocalDateTime writeDate;
    private LocalDateTime modifyDate;
    private int viewCount;
    private int replyCount;

    public FreeBoard(String title, Member writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.writeDate = LocalDateTime.now();
        this.viewCount = 0;
        this.replyCount = 0;
    }

    public void editFreeBoard(String title, String content) {
        this.title = title;
        this.content = content;
        this.modifyDate = LocalDateTime.now();
    }
}

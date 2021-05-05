package example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class FreeBoardRead {

    private Long id;
    private String title;
    private Long writerId;
    private String writer;
    private String content;
    private LocalDateTime writeDate;
    private LocalDateTime modifyDate;
    private int viewCount;
    private int replyCount;

}

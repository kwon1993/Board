package example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FreeBoardWrite {

    private String title;
    private Long writerId;
    private String content;

}

package example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FreeBoardEdit {

    private Long id;
    private String title;
    private String content;

}

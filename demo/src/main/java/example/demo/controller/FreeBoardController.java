package example.demo.controller;

import example.demo.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class FreeBoardController {

    private final FreeBoardService freeBoardService;

    @GetMapping("/freeBoard/{page}")
    public String freeBoardList() {
        return "/freeBoard/list";
    }

    @GetMapping("/freeBoard/{id}")
    public String freeBoardRead() {
        return "/freeBoard/read";
    }

    @GetMapping("/freeBoard/write")
    public String freeBoardWriteForm() {
        return "/freeBoard/write";
    }

    @PostMapping("/freeBoard/write")
    public String freeBoardWrite() {
        Long returnedPostId = 0L;
        return "redirect:/freeBoard/" + returnedPostId;
    }

    @GetMapping("/freeBoard/{id}/edit")
    public String freeBoardEditForm() {
        return "/freeBoard/edit";
    }

    @PostMapping("/freeBoard/{id}/edit")
    public String freeBoardEdit(Long id) {
        return "redirect:/freeBoard/" + id;
    }

    @DeleteMapping("/freeBoard/{id}/delete")
    public String freeBoardDelete() {
        return "redirect:/freeBoard";
    }
}

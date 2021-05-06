package example.demo.controller;

import example.demo.dto.FreeBoardEdit;
import example.demo.dto.FreeBoardRead;
import example.demo.dto.FreeBoardWrite;
import example.demo.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class FreeBoardController {

    private final FreeBoardService freeBoardService;

    @GetMapping("/freeBoard/{page}")
    public String freeBoardList(int page) {
        return "/freeBoard/list";
    }

    @GetMapping("/freeBoard/{id}")
    public String freeBoardRead(Long id, Model model) {
        FreeBoardRead freeBoardRead = freeBoardService.readFreeBoard(id);
        model.addAttribute(freeBoardRead);
        return "/freeBoard/read";
    }

    @GetMapping("/freeBoard/write")
    public String freeBoardWriteForm() {
        return "/freeBoard/write";
    }

    @PostMapping("/freeBoard/write")
    public String freeBoardWrite(FreeBoardWrite freeBoardWrite) {
        Long returnedId = freeBoardService.saveFreeBoard(freeBoardWrite);
        return "redirect:/freeBoard/" + returnedId;
    }

    @GetMapping("/freeBoard/{id}/edit")
    public String freeBoardEditForm() {
        return "/freeBoard/edit";
    }

    @PostMapping("/freeBoard/{id}/edit")
    public String freeBoardEdit(FreeBoardEdit freeBoardEdit) {
        freeBoardService.editFreeBoard(freeBoardEdit);
        return "redirect:/freeBoard/" + freeBoardEdit.getId();
    }

    @DeleteMapping("/freeBoard/{id}/delete")
    public String freeBoardDelete() {
        return "redirect:/freeBoard";
    }
}

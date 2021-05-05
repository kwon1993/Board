package example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/member")
    public String member(Long id) {
        return "/member/info";
    }

    @GetMapping("/member/join")
    public String memberJoinForm() {
        return "/member/join";
    }

    @PostMapping("/member/join")
    public String memberJoin() {
        return "redirect:/";
    }

    @GetMapping("/member/edit")
    public String memberEditForm(Long id) {
        return "/member/edit";
    }

    @PostMapping("/member/edit")
    public String memberEdit(Long id) {
        return "redirect:/member/info";
    }

    @DeleteMapping("/member/delete")
    public String memberDelete(Long id) {
        return "redirect:/";
    }
}

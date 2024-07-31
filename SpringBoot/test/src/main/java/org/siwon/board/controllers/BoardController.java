package org.siwon.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.siwon.board.entities.Board;
import org.siwon.board.services.BoardInfoService;
import org.siwon.board.services.BoardSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardSaveService saveService;
    private final BoardInfoService infoService;

    @GetMapping("/write")
    public String write(@ModelAttribute RequestBoard form) {
        return "front/board/write";
    }

    @GetMapping("/update/{seq}")
    public String update(@PathVariable("seq") Long seq, Model model) {
        RequestBoard form = infoService.getForm(seq);
        model.addAttribute("requestBoard", form);
        return "front/board/update";
    }

    @PostMapping("/save") // 등록 및 수정을 하기 위한 매서드 write, update 둘다
    public String save(@Valid RequestBoard form, Errors errors) {
        String mode = form.getSeq() == null ? "update" : "write";
        if (errors.hasErrors()) {
            return "front/board/" + mode;
        }

        saveService.save(form);

        return "redirect:/board/list";
    }

    @GetMapping("/view/{seq}")
    public String view(@PathVariable("seq") Long seq, Model model) {
        Board data = infoService.get(seq);
        model.addAttribute("data", data);
        return "front/board/view";
    }

    @GetMapping("/list")
    public String list() {

        return "front/board/list";
    }
}
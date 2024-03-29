package sku.board.mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sku.board.mini.dto.BoardDTO;
import sku.board.mini.service.MainService;

@Controller
public class BoardController {

    private final MainService mainService;

    public BoardController(MainService mainService) {
        this.mainService = mainService;
    }

    @DeleteMapping("/board/{seq}")
    @ResponseBody
    public String deleteBoard(@PathVariable Long seq) {
        mainService.deleteBoard(seq);
        return "Deleted board with seq: " + seq;
    }

    @PutMapping("/board/{seq}")
    @ResponseBody
    public String updateBoard(@PathVariable Long seq, @RequestBody BoardDTO boardDTO) {
        mainService.updateBoard(seq, boardDTO.getTitle(), boardDTO.getContent());
        return "Updated board with seq: " + seq;
    }
}

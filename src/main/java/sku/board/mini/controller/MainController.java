package sku.board.mini.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sku.board.mini.dto.BoardDTO;
import sku.board.mini.dto.BoardRequestDTO;
import sku.board.mini.dto.ResponseDTO;
import sku.board.mini.service.MainService;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    public final MainService mainService;

    @GetMapping("/index/{seq}")
    public String showNotice(@PathVariable Long seq, Model model) {
        BoardDTO board = mainService.findById(seq);
        model.addAttribute("board", board);
        return "boardView";
    }

    @GetMapping("/")
    public String index(Model model){
        List<BoardDTO> list = mainService.findAll();
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/writeView")
    public String writeView(){

        return "writeView";
    }

    @PostMapping("/writeInsert")
    @ResponseBody
    public ResponseEntity<ResponseDTO> writeInsert(@RequestBody BoardRequestDTO dto){
        mainService.save(dto);
        return ResponseEntity.ok()
                .body(ResponseDTO.builder()
                        .code(200)
                        .message("성공")
                        .build());
    }

}

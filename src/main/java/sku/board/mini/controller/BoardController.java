package sku.board.mini.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sku.board.mini.domain.Board;
import sku.board.mini.dto.BoardDTO;
import sku.board.mini.dto.ResponseDTO;
import sku.board.mini.service.MainService;

import java.util.Optional;

@Controller
public class BoardController {

    private final MainService mainService;

    public BoardController(MainService mainService) {
        this.mainService = mainService;
    }

    @DeleteMapping("/board/{seq}")
    @ResponseBody
    public ResponseEntity<ResponseDTO> deleteBoard(@PathVariable Long seq, @RequestParam String password) {

        boolean result = mainService.deleteBoard(seq, password);

        if(result){
            return ResponseEntity.ok()
                    .body(ResponseDTO.builder()
                            .code(200)
                            .message("성공")
                            .build());
        }else {
            return ResponseEntity.ok()
                    .body(ResponseDTO.builder()
                            .code(201)
                            .message("실패")
                            .build());
        }
    }

    @PutMapping("/board/{seq}")
    @ResponseBody
    public ResponseEntity<ResponseDTO> updateBoard(@PathVariable Long seq, @RequestBody BoardDTO boardDTO) {
        // 클라이언트에서 보낸 데이터 중 비밀번호를 추가하여 서비스로 전달
        boolean result = mainService.updateBoard(seq, boardDTO.getPassword(), boardDTO.getContent());
        if(result){
            return ResponseEntity.ok()
                    .body(ResponseDTO.builder()
                            .code(200)
                            .message("성공")
                            .build());
        } else{
            return ResponseEntity.ok()
                    .body(ResponseDTO.builder()
                            .code(201)
                            .message("실패")
                            .build());
        }
    }
}

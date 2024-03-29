package sku.board.mini.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sku.board.mini.domain.Board;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class BoardDTO {

    private Long seq;
    private String title;
    private String content;
    private String writer;
    private String password;
    private Timestamp createDate;

    public BoardDTO(Board board){
        this.seq = board.getSeq();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.password = board.getPassword();
        this.createDate = board.getCreateDate();
    }

}

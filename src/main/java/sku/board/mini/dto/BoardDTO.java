package sku.board.mini.dto;

import lombok.*;
import sku.board.mini.domain.Board;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardDTO {

    private Long seq;
    private String title;
    private String content;
    private String writer;
    private String password;
    private Timestamp createDate;
    private int viewCount;

    public BoardDTO(Board board){
        this.seq = board.getSeq();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.password = board.getPassword();
        this.createDate = board.getCreateDate();
        this.viewCount = board.getViewCount();
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .password(password)
                .viewCount(viewCount)
                .build();
    }

}

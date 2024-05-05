package sku.board.mini.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sku.board.mini.domain.Board;

@Getter
@Setter
@ToString
public class BoardRequestDTO {
    private String title;
    private String content;
    private String writer;
    private String password;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .password(password)
                .build();
    }
}

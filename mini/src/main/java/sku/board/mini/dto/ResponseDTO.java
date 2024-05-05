package sku.board.mini.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO {

    int code;
    String message;

    @Builder
    public ResponseDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

package sku.board.mini.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 20)
    private String writer;

    @Column(length = 20)
    private String password;

    @Column
    private int viewCount;
}

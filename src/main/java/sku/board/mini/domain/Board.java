package sku.board.mini.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long seq;

    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 20)
    private String writer;

    @Column(length = 20)
    private String password;

    @Column(columnDefinition = "int default 0")
    private int viewCount;

    @CreatedDate
    @Column
    private Timestamp createDate;

    @Builder
    public Board(String title, String content, String writer, String password, int viewCount) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
        this.viewCount = viewCount;
    }
}

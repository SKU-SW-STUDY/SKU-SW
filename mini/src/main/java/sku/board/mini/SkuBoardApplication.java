package sku.board.mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SkuBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkuBoardApplication.class, args);
    }

}

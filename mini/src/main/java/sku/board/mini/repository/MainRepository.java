package sku.board.mini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sku.board.mini.domain.Board;

public interface MainRepository extends JpaRepository<Board, Long> {
}

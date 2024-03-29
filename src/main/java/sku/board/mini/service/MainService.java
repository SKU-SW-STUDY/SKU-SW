package sku.board.mini.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sku.board.mini.domain.Board;
import sku.board.mini.repository.MainRepository;

import java.util.Optional;

@Service
public class MainService {

    private final MainRepository mainRepository;

    @Autowired
    public MainService(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public void deleteBoard(Long seq) {
        mainRepository.deleteById(seq);
    }

    public void updateBoard(Long seq, String title, String content){
        Optional<Board> optionalBoard = mainRepository.findById(seq);
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            board.setTitle(title);
            board.setContent(content);
            mainRepository.save(board);
        } else {
            throw new RuntimeException("게시글이 존재하지 않습니다. seq: " + seq);
        }
    }
}

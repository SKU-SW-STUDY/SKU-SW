package sku.board.mini.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sku.board.mini.domain.Board;
import sku.board.mini.dto.BoardDTO;
import sku.board.mini.dto.BoardRequestDTO;
import sku.board.mini.repository.MainRepository;

import java.util.List;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainRepository mainRepository;

    public BoardDTO findById(Long seq){
        Optional<Board> b = mainRepository.findById(seq);
        if (b.isPresent()) {
            b.get().setViewCount(b.get().getViewCount() + 1);
            mainRepository.save(b.get());
        }
        return new BoardDTO(b.get());
    }
    public List<BoardDTO> findAll(){
        return mainRepository.findAll().stream().map(BoardDTO::new).toList();
    }

    public void save(BoardRequestDTO dto) {
        mainRepository.save(dto.toEntity());
    }
    public boolean deleteBoard(Long seq, String password) {
        boolean result = false;
        Optional<Board> b = mainRepository.findById(seq);
        if (b.isPresent()) {
            if (b.get().getPassword().equals(password)) {
                mainRepository.deleteById(seq);
                result = true;
            }
        }

        return result;
    }

    public boolean updateBoard(Long seq, String password, String content){
        Optional<Board> optionalBoard = mainRepository.findById(seq);
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            if (board.getPassword().equals(password)) {
                board.setContent(content);
                mainRepository.save(board);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

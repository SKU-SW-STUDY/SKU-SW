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
        b.get().setViewCount(b.get().getViewCount()+1);
        mainRepository.save(b.get());
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

        System.out.println("b:"+b.get().getPassword());
        System.out.println("b1:"+password);
        if(b.get().getPassword().equals(password)){
            mainRepository.deleteById(seq);
            result = true;
        }else result = false;

        return result;
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

package sku.board.mini.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sku.board.mini.domain.Board;
import sku.board.mini.dto.BoardDTO;
import sku.board.mini.dto.BoardRequestDTO;
import sku.board.mini.repository.MainRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainRepository mainRepository;

    public List<BoardDTO> findAll(){
        return mainRepository.findAll().stream().map(BoardDTO::new).toList();
    }

    public boolean save(BoardRequestDTO dto){
        Board b = mainRepository.save(dto.toEntity());
        if(b != null) return true;
        else return false;
    }
}

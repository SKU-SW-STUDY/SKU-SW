package sku.board.mini.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sku.board.mini.repository.MainRepository;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainRepository mainRepository;
}

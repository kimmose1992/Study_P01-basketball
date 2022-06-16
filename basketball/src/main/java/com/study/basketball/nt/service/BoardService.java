package com.study.basketball.nt.service;

import com.study.basketball.nt.dto.BoardDto;
import com.study.basketball.nt.models.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

}

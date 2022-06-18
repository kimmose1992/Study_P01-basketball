package com.study.basketball.nt.service;

import com.study.basketball.nt.models.entity.Board;
import com.study.basketball.nt.models.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    @Override
    public List<Board> boardList () {
        List<Board> boardList = boardRepository.findAll();

        return boardList;
    }

}

package com.study.basketball.nt.controller;

import com.study.basketball.nt.models.entity.Board;
import com.study.basketball.nt.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/board/")
@RequiredArgsConstructor // 생성자를 자동으로 생성(의존성 주입)해주는 애노테이션
public class BoardController {

    private final BoardServiceImpl boardService;

    private static final Logger logger = LoggerFactory.getLogger(JdbcTemplate.class);

    @RequestMapping("boardList")
    public ModelAndView boardList (ModelAndView mav) {

        List<Board> boardList = boardService.boardList();

        mav.addObject("boardList", boardList);
        mav.setViewName("basketball/ur/VWUR0001");

        return mav;
    }
}

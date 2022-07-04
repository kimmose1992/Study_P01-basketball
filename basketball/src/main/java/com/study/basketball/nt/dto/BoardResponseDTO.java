package com.study.basketball.nt.dto;

import com.study.basketball.nt.models.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDTO {

    private Long boardSeq;
    private String boardDivCd;
    private String title;
    private String content;
    private int viewCnt;
    private String delYn;
    private String reqSeq;
    private String mdfSeq;

    public BoardResponseDTO(Board entity) {
        this.boardSeq = entity.getBoardSeq();
        this.boardDivCd = entity.getBoardDivCd();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.viewCnt = entity.getViewCnt();
        this.delYn = entity.getRegSeq();
        this.reqSeq = entity.getRegSeq();
        this.mdfSeq = entity.getMdfSeq();
    }
}

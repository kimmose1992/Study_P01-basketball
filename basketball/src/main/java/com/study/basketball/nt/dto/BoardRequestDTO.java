package com.study.basketball.nt.dto;

import com.study.basketball.nt.models.entity.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequestDTO {

    private Long boardSeq;
    private String boardDivCd;
    private String title;
    private String content;
    private int viewCnt;
    private String delYn;
    private String reqSeq;
    private String mdfSeq;

    public Board toEntity() {
        return Board.builder()
                .boardSeq(boardSeq)
                .boardDivCd(boardDivCd)
                .title(title)
                .content(content)
                .viewCnt(0)
                .delYn("N")
                .regSeq(reqSeq)
                .mdfSeq(mdfSeq)
                .build();
    }
}

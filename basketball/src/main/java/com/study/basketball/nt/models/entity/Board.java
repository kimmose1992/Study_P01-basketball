package com.study.basketball.nt.models.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Board extends Time {

    @Id
    @Column(name = "BOARD_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSeq;      // 게시판일련번호

    @Column(name = "BOARD_DIV_CD", nullable = false)
    private String boardDivCd;  // 게시판구분코드

    @Column(name = "TITLE", nullable = false)
    private String title;       // 제목

    @Column(name = "CONTENT", nullable = false)
    private String content;     // 내용

    @Column(name = "VIEW_CNT", nullable = false)
    private int viewCnt;        // 조회수

    @Column(name = "DEL_YN", nullable = false)
    private String delYn;       // 사용여부

    @Column(name = "REQ_SEQ", nullable = false)
    private String regSeq;      // 작성자

    @Column(name = "MDF_SEQ", nullable = false)
    private String mdfSeq;      // 수정자

}

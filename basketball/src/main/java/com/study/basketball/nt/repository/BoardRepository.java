package com.study.basketball.nt.repository;

import com.study.basketball.nt.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository <Board, Long> {

}

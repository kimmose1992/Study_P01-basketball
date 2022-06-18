package com.study.basketball.nt.models.repository;

import com.study.basketball.nt.models.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository <Board, Long> {
}

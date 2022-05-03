package hj.seminar.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hj.seminar.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
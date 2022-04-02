package my_portfolio.portfolio.repository;

import my_portfolio.portfolio.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}

package my_portfolio.portfolio.repository;

import my_portfolio.portfolio.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}

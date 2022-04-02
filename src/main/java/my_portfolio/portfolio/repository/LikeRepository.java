package my_portfolio.portfolio.repository;

import my_portfolio.portfolio.entity.Board;
import my_portfolio.portfolio.entity.Comment;
import my_portfolio.portfolio.entity.LikeFunction;
import my_portfolio.portfolio.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<LikeFunction,Long> {

    // like 레포에서 어떤 멤버가 게시글에 좋아요를 누른 좋아요가 있는지 찾음
    Optional<LikeFunction> findByMemberAndBoard(Member member, Board board);

    // like 레포에서 어떤 멤버가 댓글에 좋아요를 누른 좋아요가 있는지 찾음
    Optional<LikeFunction> findByMemberAndComment(Member member, Comment comment);
}

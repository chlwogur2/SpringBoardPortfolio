package my_portfolio.portfolio.service;

import my_portfolio.portfolio.entity.Board;
import my_portfolio.portfolio.entity.Comment;
import my_portfolio.portfolio.entity.Like;
import my_portfolio.portfolio.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import my_portfolio.portfolio.repository.BoardRepository;
import my_portfolio.portfolio.repository.CommentRepository;
import my_portfolio.portfolio.repository.LikeRepository;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;

    // 사용자가 게시글에 이미 좋아요 눌렀는지 체크 (중복을 체크)
    // 만약 안 눌렀으면 like 레포에 해당 좋아요가 비어있음
    public Boolean boardAlreadyLike(Member member, Board board) {
        return likeRepository.findByMemberAndBoard(member, board).isEmpty();
    }

    // 사용자가 댓글에 이미 좋아요 눌렀는지 체크 (중복을 체크)
    public Boolean commentAlreadyLike(Member member, Comment comment) {
        return likeRepository.findByMemberAndComment(member, comment).isEmpty();
    }

    // 게시글에 좋아요 추가
    public Boolean boardAddLike(Member member, Long boardId) {     // 이미 존재하는 게시글에 대한 좋아요니까 레포에서 id로 불러옴
       Board board = boardRepository.findById(boardId).orElseThrow();

       // 사용자가 좋아요 누른적이 없으면
        if (boardAlreadyLike(member, board)) {
            Like like = new Like(member, board);
            likeRepository.save(like);
            like.addLike();

            return true;
        }
        else
            return false;
    }

    // 코멘트에 좋아요 추가
    public Boolean commentAddLike(Member member, Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        // 사용자가 좋아요 누른적이 없으면
        if (commentAlreadyLike(member,comment)){
            Like like = new Like(member, comment);
            likeRepository.save(like);
            like.addLike();

            return true;
        }
        return false;
    }
}

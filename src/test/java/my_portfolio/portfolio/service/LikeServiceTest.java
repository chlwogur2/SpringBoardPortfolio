package my_portfolio.portfolio.service;

import my_portfolio.portfolio.entity.*;
import my_portfolio.portfolio.repository.BoardRepository;
import my_portfolio.portfolio.repository.CommentRepository;
import my_portfolio.portfolio.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import my_portfolio.portfolio.repository.LikeRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LikeServiceTest {
    @Autowired BoardRepository boardRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired CommentRepository commentRepository;
    @Autowired LikeRepository likeRepository;
    @Autowired LikeService likeService;


    @Test
    void 게시글좋아요() {

        // given
        Member member = new Member("userA");
        memberRepository.save(member);
        Board board = new Board("First", "hello", Category.VLOG);
        boardRepository.save(board);
        // when
        likeService.boardAddLike(member, board.getId());

        // then
        LikeFunction likeFunction = likeRepository.findByMemberAndBoard(member, board).get();
        assertEquals(likeFunction.getLikeCount(),1);

    }
    @Test
    void 게시글좋아요중복(){

        // given
        Member member = new Member("userA");
        memberRepository.save(member);
        Board board = new Board("First", "hello", Category.VLOG);
        boardRepository.save(board);
        likeService.boardAddLike(member, board.getId());

        // when
        likeService.boardAddLike(member, board.getId());

        // then
        LikeFunction likeFunction = likeRepository.findByMemberAndBoard(member, board).get();
        assertEquals(likeFunction.getLikeCount(),1);
    }
    @Test
    void 댓글좋아요(){
        // given
        Member member = new Member("userA");
        memberRepository.save(member);
        Board board = new Board("First", "hello", Category.VLOG);
        boardRepository.save(board);
        Comment comment = new Comment(member,board,"hellohello");
        commentRepository.save(comment);

        // when
        likeService.commentAddLike(member, comment.getId());

        // then
        LikeFunction likeFunction = likeRepository.findByMemberAndComment(member, comment).get();
        assertEquals(likeFunction.getLikeCount(),1);
    }

}
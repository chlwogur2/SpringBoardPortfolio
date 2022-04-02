package my_portfolio.portfolio.service;

import my_portfolio.portfolio.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import my_portfolio.portfolio.repository.LikeRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LikeServiceTest {
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    LikeService likeService;

    @Test
    void 게시글좋아요() {

        // given
        Member member = new Member("userA");
        Board board = new Board("First", "hello", Category.VLOG);

        // when
        likeService.boardAddLike(member, board.getId());

        // then
        Like like = likeRepository.findByMemberAndBoard(member, board).get();
        assertEquals(like.getLikeCount(),1);

    }
    @Test
    void 게시글좋아요중복(){

        // given
        Member member = new Member("userA");
        Board board = new Board("First", "hello", Category.VLOG);
        likeService.boardAddLike(member, board.getId());

        // when
        likeService.boardAddLike(member, board.getId());

        // then
        Like like = likeRepository.findByMemberAndBoard(member, board).get();
        assertEquals(like.getLikeCount(),1);
    }
    @Test
    void 댓글좋아요(){
        // given
        Member member = new Member("userA");
        Board board = new Board("First", "hello", Category.VLOG);
        Comment comment = new Comment(member,board,"hellohello");

        // when
        likeService.commentAddLike(member, comment.getId());

        // then
        Like like = likeRepository.findByMemberAndComment(member, comment).get();
        assertEquals(like.getLikeCount(),1);
    }

}
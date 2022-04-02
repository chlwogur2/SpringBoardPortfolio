package my_portfolio.portfolio.service;

import entity.Board;
import entity.Category;
import entity.Like;
import entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import repository.BoardRepository;
import repository.LikeRepository;
import repository.MemberRepository;
import service.LikeService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LikeServiceTest {
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    LikeService likeService;

    @Test
    void 좋아요() {

        // given
        Member member = new Member("userA");
        Board board = new Board("First", "hello", Category.VLOG);

        // when
        likeService.boardAddLike(member, board.getId());

        // then
        Like like = likeRepository.findByMemberAndBoard(member, board).get();
        assertEquals(like.getLikeCount(),1);

    }

}
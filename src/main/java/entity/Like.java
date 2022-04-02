package entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Like extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "like_id")
    private String id;

    private int likeCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    // 게시글 좋아요 생성자
    public Like(Member member, Board board) {
        this.member = member;
        this.board = board;
    }

    // 댓글 좋아요 생성자
    public Like(Member member, Comment comment) {
        this.member = member;
        this.comment = comment;
    }

    // -----------비즈니스 로직-------------

    // 좋아요 수 증가
    public void addLike(){
        this.likeCount += 1;
    }

    // 좋아요 수 감소
    public void deleteLike(){
        this.likeCount -= 1;
    }


}

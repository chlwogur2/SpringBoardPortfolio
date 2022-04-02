package my_portfolio.portfolio.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Board extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;
    private String content;

//    private int likeCount;    가변 객체가 돼버림

    @Enumerated(EnumType.STRING)
    private Category category;

    public Board(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }
}

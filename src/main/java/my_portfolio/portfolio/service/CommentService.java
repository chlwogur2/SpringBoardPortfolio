package my_portfolio.portfolio.service;

import lombok.RequiredArgsConstructor;
import my_portfolio.portfolio.entity.Comment;
import org.springframework.stereotype.Service;
import my_portfolio.portfolio.repository.CommentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    // 댓글 삭제
    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }


}

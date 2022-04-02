package my_portfolio.portfolio.service;

import lombok.RequiredArgsConstructor;
import my_portfolio.portfolio.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 삭제
    public void deleteBoard(Long boardId){
        boardRepository.deleteById(boardId);
    }
}

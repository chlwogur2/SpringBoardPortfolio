package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.LikeRepository;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
}

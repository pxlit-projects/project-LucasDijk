package be.lucas.service;

import be.lucas.domain.Post;
import be.lucas.dto.PostRequest;
import be.lucas.dto.PostResponse;
import be.lucas.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponse createPost(PostRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(request.getAuthor())
                .dateCreated(LocalDateTime.now())
                .status(Post.PostStatus.DRAFT)
                .build();
        post = postRepository.save(post);
        return mapToPostResponse(post);
    }

    public PostResponse getPost(Long id) {
        return postRepository.findById(id)
                .map(this::mapToPostResponse)
                .orElse(null);
    }

    private PostResponse mapToPostResponse(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .dateCreated(post.getDateCreated())
                .status(post.getStatus())
                .build();
    }
}

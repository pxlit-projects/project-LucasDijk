package be.lucas.service;

import be.lucas.domain.Comment;
import be.lucas.dto.CommentRequest;
import be.lucas.dto.CommentResponse;
import be.lucas.feign.PostClient;
import be.lucas.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostClient postClient;

    public CommentResponse addComment(CommentRequest request) {
        // Validate post existence
        postClient.getPost(request.getPostId());
        Comment comment = Comment.builder()
                .postId(request.getPostId())
                .author(request.getAuthor())
                .content(request.getContent())
                .dateCreated(LocalDateTime.now())
                .build();
        comment = commentRepository.save(comment);
        return mapToResponse(comment);
    }

    private CommentResponse mapToResponse(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .postId(comment.getPostId())
                .author(comment.getAuthor())
                .content(comment.getContent())
                .dateCreated(comment.getDateCreated())
                .build();
    }
}

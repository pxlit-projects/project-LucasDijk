package be.lucas.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CommentResponse {
    private Long id;
    private Long postId;
    private String author;
    private String content;
    private LocalDateTime dateCreated;
}

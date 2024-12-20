package be.lucas.dto;

import lombok.Data;

@Data
public class CommentRequest {
    private Long postId;
    private String author;
    private String content;
}

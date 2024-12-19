package be.lucas.dto;


import be.lucas.domain.Post.PostStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime dateCreated;
    private PostStatus status;
}

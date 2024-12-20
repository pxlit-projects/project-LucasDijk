package be.lucas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewResponse {
    private Long id;
    private Long postId;
    private boolean approved;
    private String reviewerComment;
}

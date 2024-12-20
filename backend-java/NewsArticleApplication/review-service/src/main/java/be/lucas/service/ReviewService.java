package be.lucas.service;

import be.lucas.domain.Review;
import be.lucas.dto.ReviewResponse;
import be.lucas.feign.PostClient;
import be.lucas.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final PostClient postClient;

    public ReviewResponse approvePost(Long postId, String comment) {
        // Placeholder: fetch post en check condities
        postClient.getPost(postId);
        Review review = Review.builder()
                .postId(postId)
                .approved(true)
                .reviewerComment(comment)
                .build();
        review = reviewRepository.save(review);
        return mapToReviewResponse(review);
    }

    private ReviewResponse mapToReviewResponse(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .postId(review.getPostId())
                .approved(review.isApproved())
                .reviewerComment(review.getReviewerComment())
                .build();
    }
}

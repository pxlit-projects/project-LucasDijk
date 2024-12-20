package be.lucas.controller;

import be.lucas.dto.ReviewResponse;
import be.lucas.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/approve/{postId}")
    public ReviewResponse approvePost(@PathVariable Long postId,
                                      @RequestParam String comment,
                                      @RequestHeader(value="X-User", required=false) String userRole) {
        // Placeholder voor rol checks
        return reviewService.approvePost(postId, comment);
    }
}

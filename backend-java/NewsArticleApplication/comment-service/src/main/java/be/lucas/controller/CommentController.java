package be.lucas.controller;

import be.lucas.dto.CommentRequest;
import be.lucas.dto.CommentResponse;
import be.lucas.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public CommentResponse addComment(@RequestBody CommentRequest request, @RequestHeader(value="X-User", required=false) String userRole) {
        // Placeholder voor rol checks
        return commentService.addComment(request);
    }
}

package be.lucas.controller;

import be.lucas.dto.PostRequest;
import be.lucas.dto.PostResponse;
import be.lucas.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public PostResponse createPost(@RequestBody PostRequest request, @RequestHeader(value="X-User", required=false) String userRole) {
        // userRole is een placeholder
        return postService.createPost(request);
    }

    @GetMapping("/{id}")
    public PostResponse getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }
}

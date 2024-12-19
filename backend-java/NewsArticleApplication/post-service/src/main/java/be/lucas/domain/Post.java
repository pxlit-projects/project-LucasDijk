package be.lucas.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(length = 5000)
    private String content;
    private String author;
    private LocalDateTime dateCreated;

    @Enumerated(EnumType.STRING)
    private PostStatus status;

    public enum PostStatus {
        DRAFT,
        SUBMITTED_FOR_REVIEW,
        PUBLISHED,
        REJECTED
    }
}

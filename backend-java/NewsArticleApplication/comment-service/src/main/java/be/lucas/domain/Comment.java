package be.lucas.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private String author;
    @Column(length = 2000)
    private String content;
    private LocalDateTime dateCreated;
}

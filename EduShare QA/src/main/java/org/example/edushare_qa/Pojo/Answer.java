package org.example.edushare_qa.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    private Long id;
    private String content;
    private String authorId;
    private String questionId;
    private String fileUrl;
    private LocalDateTime createdAt;
}

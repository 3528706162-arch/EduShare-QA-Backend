package org.example.edushare_qa.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Long id;
    private String title;
    private String content;
    private String authorId;
    private String questionType;
    private String classBelong;
    private String isSolved;
    private String fileUrl;
    private String tags;
    private LocalDateTime createdAt;
}

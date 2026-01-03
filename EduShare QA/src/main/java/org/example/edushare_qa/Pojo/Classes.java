package org.example.edushare_qa.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes {
    private Long id;
    private String title;//课程名称
    private String classType;
    private String description;
    private String teacherName;
    private String institute;//学院
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

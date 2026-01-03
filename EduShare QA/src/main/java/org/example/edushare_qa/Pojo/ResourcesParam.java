package org.example.edushare_qa.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourcesParam {
    private Long userId;
    private Long id;
    private String title;
    private String description;
    private String fileUrl;
    private String fileType;
    private String uploaderName;
    private String classBelong;
    private String tags;
    private boolean isPublic;
    private long downloadCount;
    private LocalDateTime  createdAt;
}

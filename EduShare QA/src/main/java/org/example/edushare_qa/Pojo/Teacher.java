package org.example.edushare_qa.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String phonenumber;
    private String classesName;
    private String introduction;
    private String title;//职称
    private LocalDateTime createdAt;
}
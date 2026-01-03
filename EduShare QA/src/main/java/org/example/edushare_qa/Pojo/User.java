package org.example.edushare_qa.Pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
        private Long id;
        private String username;
        private String email;
        private String password;
        private String role;
        private String phonenumber;
        private String imageUrl;
        private String classesChoose;
        private LocalDateTime createdAt;
    }

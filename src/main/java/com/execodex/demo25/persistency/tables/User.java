package com.execodex.demo25.persistency.tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Table("users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

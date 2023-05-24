package com.userservices.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {
     @Id
     @Column(name = "ID")
     private String userId;
     @Column(name = "NAME")
     private String name;
     @Column(name = "Email")
     private String email;
     @Column(name = "ABOUT")
     private String body;

     @Transient //it is not store in a database
     private List<Rating> ratings = new ArrayList<>();
}

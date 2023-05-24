package com.ratingservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rating_service")
public class Rating {
     @Id
     private String ratingId;
     private String userId;
     private String hotelId;

     private int rating;
     private String feedback;
}

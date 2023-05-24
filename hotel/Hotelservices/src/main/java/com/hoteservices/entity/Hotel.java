package com.hoteservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
     @Id
     private String hotelId;
     private String name;
     private String location;
     private String about;
}

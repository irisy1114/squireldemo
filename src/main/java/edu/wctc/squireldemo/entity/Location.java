package edu.wctc.squireldemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="Location")
public class Location {
    @Id
    @Column(name="location_id")
    private int id;


    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;
}

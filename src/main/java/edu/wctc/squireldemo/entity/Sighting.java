package edu.wctc.squireldemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name="Sighting")
public class Sighting {

    @Id
    @Column(name="sighting_id")
    private int id;

    @Column(name="spotter_name")
    private String spotterName;

    @Column(name="count")
    private int count;

    @Column(name="spotted_at")
    private LocalDateTime spottedAt;

    @Column(name="sq_id")
    private int squirrelId;

    @ManyToOne
    @JoinColumn(name="loc_id")
    private Location location;
}

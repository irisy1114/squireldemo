package edu.wctc.squireldemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="spotter_name")
    @NotBlank
    @Size(min=1, max=200)
    private String spotterName;

    @Column(name="count")
    @Min(1)
    @Max(20)
    private int count;

    @Column(name="spotted_at")
    private LocalDateTime spottedAt;

    @Column(name="sq_id")
    private int squirrelId;

    @ManyToOne
    @JoinColumn(name="loc_id")
    private Location location;
}

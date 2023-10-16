package com.catalogo.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Table(name = "course")
@Entity(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
public class Course extends GenericEntity {

    @Column
    private String name;

    @Column
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Video> videos = new ArrayList<>();
}

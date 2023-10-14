package com.catalogo.Auth.domain.course;

import com.catalogo.Auth.domain.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "course")
@Entity(name = "course")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends GenericEntity {

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "course")
    private List<Video> videos = new ArrayList<>();
}

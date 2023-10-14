package com.catalogo.Auth.domain.course;

import com.catalogo.Auth.domain.GenericEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "video")
@Entity(name = "video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Video extends GenericEntity {


    @Column
    private String name;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}

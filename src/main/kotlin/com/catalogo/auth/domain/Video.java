package com.catalogo.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Table(name = "video")
@Entity(name = "video")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
public class Video extends GenericEntity {

    @Column
    private String name;

    @Column
    private String url;

    @Column
    private Long ordering;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @JsonIgnore
    @OneToMany(mappedBy = "video")
    private List<VideoComment> videoComments = new ArrayList<>();

    @Column
    private Company company;

}

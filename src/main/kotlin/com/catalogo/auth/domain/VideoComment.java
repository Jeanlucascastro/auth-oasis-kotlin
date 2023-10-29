package com.catalogo.auth.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

@EqualsAndHashCode(callSuper = true)
@Table(name = "video_comment")
@Entity()
@Data
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
public class VideoComment extends GenericEntity {

    @Column
    private String text;

    @Column
    private Boolean answered;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;
}

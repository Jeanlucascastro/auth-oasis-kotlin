package com.catalogo.auth.repositories;

import com.catalogo.auth.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {


    List<Video> findAllByCourseId(Long courseId);

}

package com.catalogo.auth.repositories;

import com.catalogo.auth.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

}

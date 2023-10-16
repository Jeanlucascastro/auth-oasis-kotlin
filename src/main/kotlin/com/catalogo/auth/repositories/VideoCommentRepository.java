package com.catalogo.auth.repositories;

import com.catalogo.auth.domain.VideoComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoCommentRepository extends JpaRepository<VideoComment, Long> {

}

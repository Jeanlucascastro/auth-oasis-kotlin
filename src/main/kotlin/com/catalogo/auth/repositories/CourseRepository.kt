package com.catalogo.auth.repositories

import com.catalogo.auth.domain.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course?, Long?>

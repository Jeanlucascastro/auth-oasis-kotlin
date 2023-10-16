package com.catalogo.auth.controllers;

import com.catalogo.auth.domain.Course;
import com.catalogo.auth.domain.Video;
import com.catalogo.auth.domain.DTO.VideoDTO;
import com.catalogo.auth.exception.GenericException;
import com.catalogo.auth.services.CourseService;
import com.catalogo.auth.services.VideoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController()
@RequestMapping(value = "/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private CourseService courseService;
    @Autowired
    public VideoController(VideoService videoService, VideoService videoService1, CourseService courseService) {
        this.videoService = videoService1;
        this.courseService = courseService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Video> saveVideo(@RequestBody VideoDTO videoDTO) {
        Video video = new Video();
        video.setName(videoDTO.getName());
        video.setUrl(videoDTO.getUrl());
        video.setOrdering(videoDTO.getOrdering());
        Optional<Course> course = Optional.ofNullable(this.courseService.findbyId(videoDTO.getCourseId()));
        course.ifPresent(video::setCourse);
        Video savedVideo = this.videoService.saveVideo(video);
        return new ResponseEntity<>(savedVideo, HttpStatus.CREATED);
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody VideoDTO videoDTO) {
        try {
            Video updatedVideo = this.videoService.atualizarPorId(id, videoDTO);
            return new ResponseEntity<>(updatedVideo, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Video> deleteVideo(@PathVariable Long id) {
        try {
            Video deletedVideo = this.videoService.deleteFisicamente(id);
            return new ResponseEntity<>(deletedVideo, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<Page<Video>> searchVideos(@RequestParam(required = false, defaultValue = "true") Boolean isPageable, Pageable pageable) {
        try {
            Page<Video> videos = this.videoService.pesquisar(pageable, isPageable);
            return new ResponseEntity<>(videos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id) {
        try {
            Video video = this.videoService.findById(id);
            return new ResponseEntity<>(video, HttpStatus.OK);
        } catch (GenericException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

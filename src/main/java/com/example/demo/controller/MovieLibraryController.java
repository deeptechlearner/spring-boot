package com.example.demo.controller;

import com.example.demo.model.AddMovieModel;
import com.example.demo.model.MovieDetailsOutputModel;
import com.example.demo.model.UpdateMovieModel;
import com.example.demo.service.MovieLibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieLibraryController {

    private final MovieLibService movieLibService;

    @Autowired
    public MovieLibraryController(MovieLibService service) {
        this.movieLibService = service;
    }

    @GetMapping("/v1/movie/name/{movieName}")
    public ResponseEntity<List<MovieDetailsOutputModel>> getMovieDataByMovieName(@PathVariable String movieName) {
        List<MovieDetailsOutputModel> movieDetails = movieLibService.getAllMoviesByName(movieName);
        return new ResponseEntity<>(movieDetails, HttpStatus.OK);
    }

    @GetMapping("/v1/movie/id/{id}")
    public ResponseEntity<MovieDetailsOutputModel> getMovieDataByMovieId(@PathVariable int id) {
        MovieDetailsOutputModel movieData = movieLibService.getMovieById(id);
        return new ResponseEntity<>(movieData, HttpStatus.OK);
    }

    @GetMapping("/v1/movie/collection")
    public ResponseEntity<List<MovieDetailsOutputModel>> getMovieDataByCollection(@RequestParam String start, @RequestParam String end) {
        List<MovieDetailsOutputModel> movieDataByCollection = movieLibService.getMovieDetailsByCollectionRange(start, end);
        return new ResponseEntity<>(movieDataByCollection, HttpStatus.OK);
    }

    @PostMapping("/v1/movie/add")
    public ResponseEntity<MovieDetailsOutputModel> addMovie(@RequestBody AddMovieModel inputData) {
        MovieDetailsOutputModel addedData = movieLibService.addMovieByAdmin(inputData);
        return new ResponseEntity<>(addedData, HttpStatus.OK);
    }

    @PutMapping("/v1/movie/modify")
    public ResponseEntity<MovieDetailsOutputModel> modify(@RequestBody UpdateMovieModel inputData) {
        MovieDetailsOutputModel addedData = movieLibService.modifyMovieByAdmin(inputData);
        return new ResponseEntity<>(addedData, HttpStatus.OK);
    }
}

package com.skillstorm.springdatajpa.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.springdatajpa.services.MovieService;
import com.skillstorm.springdatajpa.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
  
  @Autowired
  MovieService movieService;


  @GetMapping
  public ResponseEntity<List<Movie>> findAllMovies () {
    List<Movie> movies = movieService.findAllMovies();
    
    return new ResponseEntity<List<Movie>>(movies,HttpStatus.OK);
  }

  @GetMapping("/movie/{id}")
  public ResponseEntity<Movie> createMovie(@PathVariable int id) {
    Movie movie = movieService.findMovieById(id);
    if(movie == null) {
      // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      return ResponseEntity.notFound().build();
    }
    return new ResponseEntity<Movie>(movie, HttpStatus.OK);
  }

  @GetMapping("/rating/{rating}")
  public ResponseEntity<List<Movie>> findMoviesByRating(@PathVariable int rating) {

    List<Movie> movies = movieService.findMoviesByRating(rating);

    if(movies == null) {
      return ResponseEntity.notFound().build();
    }

    return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
  }


  @PostMapping("/movie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {

    // insert the director that is provided with the movie - handle this in the service

    Movie newMovie = movieService.saveMovie(movie);    
    return new ResponseEntity<Movie>(newMovie, HttpStatus.CREATED);
  }

  @PutMapping("/movie")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {

    // insert the director that is provided with the movie - handle this in the service

    Movie newMovie = movieService.saveMovie(movie);    
    return new ResponseEntity<Movie>(newMovie, HttpStatus.OK);
  }

  @PutMapping("/movie/updateTitle")
    public ResponseEntity<Integer> updateMovie(@RequestBody Movie movie, @RequestParam String newTitle) {

    // insert the director that is provided with the movie - handle this in the service

    int updated = movieService.updateTitle(movie, newTitle);    
    return new ResponseEntity<Integer>(updated, HttpStatus.OK);
  }

 
}

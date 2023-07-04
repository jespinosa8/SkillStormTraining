package com.skillstorm.springaop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.skillstorm.springaop.models.Director;
import com.skillstorm.springaop.models.Movie;
import com.skillstorm.springaop.repositories.MovieRepository;

@Service
public class MovieService {
  
  @Autowired
  MovieRepository movieRepository;

  @Autowired
  DirectorService directorService;

  public List<Movie> findAllMovies() {
    Sort sort = Sort.by(Sort.Direction.ASC, "id");
    return movieRepository.findAll(sort);     // calls the findAll() in JpaRepository
  }

  public Movie findMovieById(int id) {
    Optional<Movie> movie = movieRepository.findById(id);

    if(movie.isPresent()) {       // ispresent checks if the optional returned the onbject
      return movie.get();         // get will retrieve the object
    }
    return null;
  }

  public List<Movie> findMoviesByRating(int rating) {
    Optional<List<Movie>> movies = movieRepository.findAllByRatingGreaterThanEqual(rating);

    if(movies.isPresent()) { 
      
      return movies.get();
    }

    return null;
  }

  public Movie saveMovie(Movie movie) {

    /*
     * 
     * save performs an isNew() check using your primary key
     */

    Director directorWithId = directorService.saveDirector(movie.getDirector());

    movie.setDirector(directorWithId);
    

    return movieRepository.save(movie);          // comes out of the box with jpa repository
  }

  public int updateTitle(Movie movie, String newTitle) {

    return movieRepository.updateMovieTitle(movie.getId(), newTitle);
  }

  public void deleteMovieById(int id) {
    movieRepository.deleteById(id);
  }

}

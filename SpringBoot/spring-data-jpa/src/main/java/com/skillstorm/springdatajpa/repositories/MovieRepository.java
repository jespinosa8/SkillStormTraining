package com.skillstorm.springdatajpa.repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.springdatajpa.models.Movie;

/*
 * repositories talk to your database
 *  no business logic
 * 
 *  needs to be an interfacte that extends an existing repository class
 *      CrudRepository                - provides crud operations
 *      PagingAndSortingRepository    - extends CrudReposity and includes methods for pagination and sorting
 *      JpaRepository                 - extends PagingAndSorting plus lots of extras
 * 
 */

@Repository     // VS code may say that this is unnecessary - ignore warning and ALWAYS keep the annotation
public interface MovieRepository extends JpaRepository<Movie, Integer> {

  /*
   * the point of JPA is that you don't have to write basic queries anymore
   * 
   * jpa comes with many methods out of the box
   *    save, findAll, findById, delete, deleteByID, deleteAll, etc
   * 
   * you can create your own methods
   *    jpa will convert the name of your method into a JPQL query 
   *    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
   * 
   */

  public Optional<List<Movie>> findAllByRatingGreaterThanEqual(int minRating);

  /*
   * use @Query to write your own JPQL queries
   * 
   * 
   * instead of @Param("var_name") and var_name
   * 
   * you can use ?1, ?2, ?3. etc
   * 
   * need to use @Modifying for any insert, update, or delete queries
   *    if used, the method MUST  return void or int
   * 
   */

  // @Query("UPDATE Movie m set m.title = ?2 WHERE id = ?1")
  @Query("UPDATE Movie m set m.title = :new_title WHERE id = :movie_id")
  @Modifying
  @Transactional    // for transaction management in spring boot  
  public int updateMovieTitle(@Param("movie_id") int id, @Param("new_title") String newTitle);


  /*
   * @Transactional
   *    make the method rollback if an error happens
   * 
   *    once a transaction starts, it cannot be stopped/interrupted (all at once)
   *    if an error occurs, roll everything back (all or none)
   * 
   */
  
}
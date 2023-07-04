package com.skillstorm.springaop.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity                           // tells jpa that this class relates to a db table
@Table(name = "DIRECTORS")       // tells jpa WHICH db table -name isn't needed if your name is the same as db table
public class Director {
  
  @Id                            // specifies the primary key
  @Column                        // says this is a db column
  @GeneratedValue(strategy = GenerationType.IDENTITY)     // specify it uses Auto-Increment
  private int id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  // specifies this is the ONE side of the relationship
  @JsonBackReference    // prevents JSON infinite recursion - this set of movies will be omitted  from our JSON
  @OneToMany(targetEntity = Movie.class, mappedBy = "director")    // mappedBy is the name of the JAVA VARIABLE in the other object
  private Set<Movie> movies;

  public Director() {
  }
  

  public Director(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Director(String firstName, String lastName, Set<Movie> movies) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.movies = movies;
  }


  public Director(int id, String firstName, String lastName, Set<Movie> movies) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.movies = movies;
  }

  public int getId() {
    return id;
  }


  public void setId(int id) {
    this.id = id;
  }


  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public Set<Movie> getMovies() {
    return movies;
  }


  public void setMovies(Set<Movie> movies) {
    this.movies = movies;
  }



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((movies == null) ? 0 : movies.hashCode());
    return result;
  }



  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Director other = (Director) obj;
    if (id != other.id)
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (movies == null) {
      if (other.movies != null)
        return false;
    } else if (!movies.equals(other.movies))
      return false;
    return true;
  }



  @Override
  public String toString() {
    return "Director [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
  }  

  
}

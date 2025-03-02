package com.example.demo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="table_1")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema (hidden = true)
    private Integer id;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "movie_genre")
    private String movieGenre;
    @Column(name = "movie_year")
    private Integer movieYear;
    @Column(name = "movie_description")
    private String movieDescription;

    public Integer getId() {
        return id;
    }
    public String getMovieName() {
        return movieName;
    }
    public String getMovieGenre() {
        return movieGenre;
    }
    public Integer getMovieYear() {
        return movieYear;
    }
    public String getMovieDescription() {
        return movieDescription;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }
    public void setMovieYear(Integer movieYear) {
        this.movieYear = movieYear;
    }
    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }
}

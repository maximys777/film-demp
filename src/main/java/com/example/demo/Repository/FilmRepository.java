package com.example.demo.Repository;

import com.example.demo.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {

}

package com.example.demo.Service;

import com.example.demo.Film;
import com.example.demo.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film updateFilm(Long id, Film filmDetails) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Фильм не найден"));

        film.setMovieName(filmDetails.getMovieName());
        film.setMovieDescription(filmDetails.getMovieDescription());
        film.setMovieYear(filmDetails.getMovieYear());
        film.setMovieGenre(filmDetails.getMovieGenre());

        return filmRepository.save(film);
    }

    public void deleteFilm(Long id) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Фильм не найден"));
        filmRepository.delete(film);
    }
}
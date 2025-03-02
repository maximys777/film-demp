package com.example.demo.Controller;

import com.example.demo.Film;
import com.example.demo.Service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
@Tag(name = "Пользователи", description = "Управление пользователями")
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping("/add")
    @Operation(summary = "создать фильм", description = "Добавляет фильм")
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        film.setId(null);
        Film savedFilm = filmService.saveFilm(film);
        return ResponseEntity.ok(savedFilm);
    }

    @GetMapping("/all")
    @Operation(summary = "Получить все фильмы", description = "Возвращает все фильмы")
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = filmService.getAllFilms();
        return ResponseEntity.ok(films);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить фильм", description = "Обновляет информацию о фильме")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film film) {
        return ResponseEntity.ok(filmService.updateFilm(id, film));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить фильм", description = "Удаляет фильм по id")
    public ResponseEntity<Film> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }

}
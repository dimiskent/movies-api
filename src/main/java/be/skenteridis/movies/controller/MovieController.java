package be.skenteridis.movies.controller;

import be.skenteridis.movies.dto.MovieRequestDTO;
import be.skenteridis.movies.dto.MovieResponseDTO;
import be.skenteridis.movies.service.MovieService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
@Validated
public class MovieController {
    private final MovieService service;
    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getMovies(
            @Positive(message = "Rating must be positive, 10 or less!") @Max(value = 10, message = "Must be 10 or less!") @RequestParam(required = false) Byte rating,
            @RequestParam(required = false) Boolean favorite
            ) {
        List<MovieResponseDTO> movies = new ArrayList<>();

        if(favorite != null) movies.addAll(service.getMoviesByFavorite(favorite));
        else if(rating != null) movies.addAll(service.getMoviesByRating(rating));
        else movies.addAll(service.getMovies());

        return movies.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<?> addMovie(@Valid @RequestBody MovieRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addMovie(dto));
    }
}

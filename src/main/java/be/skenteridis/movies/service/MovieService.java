package be.skenteridis.movies.service;

import be.skenteridis.movies.dto.MovieRequestDTO;
import be.skenteridis.movies.dto.MovieResponseDTO;
import be.skenteridis.movies.mapper.MovieMapper;
import be.skenteridis.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository repository;
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public MovieResponseDTO addMovie(MovieRequestDTO dto) {
        return MovieMapper.mapToMovieResponseDTOFromMovie(
                repository.save(
                        MovieMapper.mapToMovieFromMovieRequestDTO(dto)
                )
        );
    }

    public List<MovieResponseDTO> getMovies() {
        return repository.findAll().stream().map(MovieMapper::mapToMovieResponseDTOFromMovie).toList();
    }

    public List<MovieResponseDTO> getMoviesByFavorite(boolean favorite) {
        return repository.findByIsFavorite(favorite).stream().map(MovieMapper::mapToMovieResponseDTOFromMovie).toList();
    }

    public List<MovieResponseDTO> getMoviesByRating(byte rating) {
        return repository.findByRatingGreaterThanEqual(rating).stream().map(MovieMapper::mapToMovieResponseDTOFromMovie).toList();
    }

    public List<MovieResponseDTO> getMoviesOrderedByRating() {
        return repository.findAllByOrderByRatingDesc().stream().map(MovieMapper::mapToMovieResponseDTOFromMovie).toList();
    }
}

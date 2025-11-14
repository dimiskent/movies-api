package be.skenteridis.movies.mapper;

import be.skenteridis.movies.dto.MovieRequestDTO;
import be.skenteridis.movies.dto.MovieResponseDTO;
import be.skenteridis.movies.model.Movie;

public class MovieMapper {
    public static MovieResponseDTO mapToMovieResponseDTOFromMovie(Movie movie) {
        MovieResponseDTO dto = new MovieResponseDTO();
        dto.setId(movie.getId());
        dto.setIsFavorite(movie.getIsFavorite());
        dto.setGenre(movie.getGenre());
        dto.setTitle(movie.getTitle());
        dto.setRating(movie.getRating());
        return dto;
    }
    public static Movie mapToMovieFromMovieRequestDTO(MovieRequestDTO dto) {
        Movie movie = new Movie();
        movie.setIsFavorite(dto.getIsFavorite());
        movie.setGenre(dto.getGenre());
        movie.setTitle(dto.getTitle());
        movie.setRating(dto.getRating());
        return movie;
    }
}

package be.skenteridis.movies.repository;

import be.skenteridis.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByRatingGreaterThanEqual(double rating);
    List<Movie> findByIsFavorite(boolean favorite);
    List<Movie> findAllByOrderByRatingDesc();
}

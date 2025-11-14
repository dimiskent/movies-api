package be.skenteridis.movies.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MovieRequestDTO {
    @NotBlank(message = "Title cannot be blank!")
    private String title;

    @NotBlank(message = "Genre cannot be blank!")
    private String genre;

    @Min(value = 0, message = "Rating must be 0 or more!") @Max(value = 10, message = "Rating must be less than 10")
    private Byte rating;

    @NotNull(message = "Favorite boolean cannot be empty!")
    private Boolean isFavorite;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Byte getRating() {
        return rating;
    }

    public void setRating(Byte rating) {
        this.rating = rating;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean favorite) {
        isFavorite = favorite;
    }
}

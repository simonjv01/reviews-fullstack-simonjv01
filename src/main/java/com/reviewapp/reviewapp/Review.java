package com.reviewapp.reviewapp;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    private Category category;
    private String synopsis;
    private String imageUrl;





    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Review(String title, String description, Category category, String synopsis, String imageUrl) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.synopsis = synopsis;
        this.imageUrl = imageUrl;


    }



    public Review(){

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

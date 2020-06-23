package com.project.reviews.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    String title;
    private String imageUrl;
    @ManyToOne
    private Category category;
    private String content;
    private String synopsis;


    public Long getId() { return id; }


    public Review(){
    }





    public Review(String title, String  imageUrl, Category category,String content,  String synopsis) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.category = category;
        this.content = content;
        this.synopsis = synopsis;
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

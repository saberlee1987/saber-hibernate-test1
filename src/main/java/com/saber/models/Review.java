package com.saber.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "comment")
    private String comment;

    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(comment, review.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}

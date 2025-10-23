package com.example.tourizm.model;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tour tour;

    private Long bookingId;
    private String author;
    private int rating;
    private String comment;

    public Review() {}
    public Review(Long id, Tour tour, Long bookingId, String author, int rating, String comment) {
        this.id = id; this.tour = tour; this.bookingId = bookingId; this.author = author; this.rating = rating; this.comment = comment;
    }

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public Tour getTour() { return tour; } public void setTour(Tour tour) { this.tour = tour; }
    public Long getBookingId() { return bookingId; } public void setBookingId(Long bookingId) { this.bookingId = bookingId; }
    public String getAuthor() { return author; } public void setAuthor(String author) { this.author = author; }
    public int getRating() { return rating; } public void setRating(int rating) { this.rating = rating; }
    public String getComment() { return comment; } public void setComment(String comment) { this.comment = comment; }
}
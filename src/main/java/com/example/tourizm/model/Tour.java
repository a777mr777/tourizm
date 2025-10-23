package com.example.tourizm.model;

import jakarta.persistence.*;

@Entity
public class Tour {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    private Destination destination;

    @ManyToOne
    private Guide guide;

    private int capacity;

    public Tour() {}
    public Tour(Long id, String title, String description, Destination destination, Guide guide, int capacity) {
        this.id = id; this.title = title; this.description = description;
        this.destination = destination; this.guide = guide; this.capacity = capacity;
    }

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; } public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; } public void setDescription(String description) { this.description = description; }
    public Destination getDestination() { return destination; } public void setDestination(Destination destination) { this.destination = destination; }
    public Guide getGuide() { return guide; } public void setGuide(Guide guide) { this.guide = guide; }
    public int getCapacity() { return capacity; } public void setCapacity(int capacity) { this.capacity = capacity; }
}
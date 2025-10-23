package com.example.tourizm.model;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private String clientEmail;
    private int seats;

    @ManyToOne
    private Tour tour;

    private boolean confirmed;

    public Booking() {}
    public Booking(Long id, String clientName, String clientEmail, int seats, Tour tour, boolean confirmed) {
        this.id = id; this.clientName = clientName; this.clientEmail = clientEmail; this.seats = seats; this.tour = tour; this.confirmed = confirmed;
    }

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getClientName() { return clientName; } public void setClientName(String clientName) { this.clientName = clientName; }
    public String getClientEmail() { return clientEmail; } public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }
    public int getSeats() { return seats; } public void setSeats(int seats) { this.seats = seats; }
    public Tour getTour() { return tour; } public void setTour(Tour tour) { this.tour = tour; }
    public boolean isConfirmed() { return confirmed; } public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }
}
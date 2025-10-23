package com.example.tourizm.controller;

import com.example.tourizm.model.Booking;
import com.example.tourizm.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingRepository repository;
    public BookingController(BookingRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Booking> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Booking getById(@PathVariable Long id) { return repository.findById(id).orElse(null); }

    @PostMapping
    public Booking create(@RequestBody Booking booking) { return repository.save(booking); }

    @PutMapping("/{id}")
    public Booking update(@PathVariable Long id, @RequestBody Booking booking) {
        Booking b = repository.findById(id).orElse(null);
        if(b != null) {
            b.setClientName(booking.getClientName());
            b.setClientEmail(booking.getClientEmail());
            b.setSeats(booking.getSeats());
            b.setTour(booking.getTour());
            b.setConfirmed(booking.isConfirmed());
            return repository.save(b);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
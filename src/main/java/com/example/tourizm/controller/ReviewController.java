package com.example.tourizm.controller;

import com.example.tourizm.model.Review;
import com.example.tourizm.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewRepository repository;
    public ReviewController(ReviewRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Review> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Review getById(@PathVariable Long id) { return repository.findById(id).orElse(null); }

    @PostMapping
    public Review create(@RequestBody Review review) { return repository.save(review); }

    @PutMapping("/{id}")
    public Review update(@PathVariable Long id, @RequestBody Review review) {
        Review r = repository.findById(id).orElse(null);
        if(r != null) {
            r.setTour(review.getTour());
            r.setBookingId(review.getBookingId());
            r.setAuthor(review.getAuthor());
            r.setRating(review.getRating());
            r.setComment(review.getComment());
            return repository.save(r);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
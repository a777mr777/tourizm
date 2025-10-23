package com.example.tourizm.controller;

import com.example.tourizm.model.Tour;
import com.example.tourizm.repository.TourRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    private final TourRepository repository;
    public TourController(TourRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Tour> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Tour getById(@PathVariable Long id) { return repository.findById(id).orElse(null); }

    @PostMapping
    public Tour create(@RequestBody Tour tour) { return repository.save(tour); }

    @PutMapping("/{id}")
    public Tour update(@PathVariable Long id, @RequestBody Tour tour) {
        Tour t = repository.findById(id).orElse(null);
        if(t != null) {
            t.setTitle(tour.getTitle());
            t.setDescription(tour.getDescription());
            t.setDestination(tour.getDestination());
            t.setGuide(tour.getGuide());
            t.setCapacity(tour.getCapacity());
            return repository.save(t);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
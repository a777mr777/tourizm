package com.example.tourizm.controller;

import com.example.tourizm.model.Destination;
import com.example.tourizm.repository.DestinationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    private final DestinationRepository repository;
    public DestinationController(DestinationRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Destination> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Destination getById(@PathVariable Long id) { return repository.findById(id).orElse(null); }

    @PostMapping
    public Destination create(@RequestBody Destination destination) { return repository.save(destination); }

    @PutMapping("/{id}")
    public Destination update(@PathVariable Long id, @RequestBody Destination destination) {
        Destination d = repository.findById(id).orElse(null);
        if(d != null) {
            d.setName(destination.getName());
            d.setCountry(destination.getCountry());
            d.setDescription(destination.getDescription());
            return repository.save(d);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
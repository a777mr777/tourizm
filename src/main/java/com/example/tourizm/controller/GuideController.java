package com.example.tourizm.controller;

import com.example.tourizm.model.Guide;
import com.example.tourizm.repository.GuideRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guides")
public class GuideController {

    private final GuideRepository repository;
    public GuideController(GuideRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Guide> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Guide getById(@PathVariable Long id) { return repository.findById(id).orElse(null); }

    @PostMapping
    public Guide create(@RequestBody Guide guide) { return repository.save(guide); }

    @PutMapping("/{id}")
    public Guide update(@PathVariable Long id, @RequestBody Guide guide) {
        Guide g = repository.findById(id).orElse(null);
        if(g != null) {
            g.setName(guide.getName());
            g.setPhone(guide.getPhone());
            g.setLanguage(guide.getLanguage());
            return repository.save(g);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
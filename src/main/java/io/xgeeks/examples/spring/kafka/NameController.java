package io.xgeeks.examples.spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/names")
public class NameController {

    private final NameService service;

    @Autowired
    public NameController(NameService service) {
        this.service = service;
    }

    @GetMapping
    public List<NameStatus> findAll() {
        return service.findAll();
    }

    @GetMapping("{name}")
    public NameStatus findByName(@PathVariable("name") String name) {
        return service.findByName(name);
    }

    @DeleteMapping(value = "{name}")
    public void decrement(@PathVariable("name") String name) {
        service.decrement(name);
    }

    @PutMapping(value = "{name}")
    public void increment(@PathVariable("name") String name) {
        service.increment(name);
    }
}

package io.xgeeks.examples.springkarka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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

    public NameStatus findByName(String name) {
        Optional<NameStatus> nameStatus = service.findByName(name);
        return nameStatus.orElseGet(() -> new NameStatus(name, 0));
    }
}

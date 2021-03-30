package io.xgeeks.examples.springkarka;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NameService {

    private final NameCounter counter;

    public NameService(NameCounter counter) {
        this.counter = counter;
    }

    public List<NameStatus> findAll() {
        return counter.getValues()
                .map(NameStatus::of)
                .collect(Collectors.toUnmodifiableList());
    }

    public NameStatus findByName(String name) {
        return new NameStatus(name, counter.get(name));
    }
}

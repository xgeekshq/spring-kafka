package io.xgeeks.examples.spring.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NameService {

    private final NameCounter counter;

    private final KafkaTemplate<String, Name> template;

    public NameService(NameCounter counter, KafkaTemplate<String, Name> template) {
        this.counter = counter;
        this.template = template;
    }

    public List<NameStatus> findAll() {
        return counter.getValues()
                .map(NameStatus::of)
                .collect(Collectors.toUnmodifiableList());
    }

    public NameStatus findByName(String name) {
        return new NameStatus(name, counter.get(name));
    }

    public void decrement(String name) {
        template.send(TopicProducer.NAME_DECREMENT, new Name(name));
    }

    public void increment(String name) {
        template.send(TopicProducer.NAME_INCREMENT, new Name(name));
    }
}

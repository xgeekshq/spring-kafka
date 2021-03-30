package io.xgeeks.examples.spring.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class NameConsumer {

    private static final Logger LOGGER = Logger.getLogger(NameConsumer.class.getName());

    private final NameCounter counter;

    public NameConsumer(NameCounter counter) {
        this.counter = counter;
    }


    @KafkaListener(id = "increment", topics = TopicProducer.NAME_INCREMENT)
    public void increment(Name name) {
        LOGGER.info("Increment listener to " + name);
        counter.increment(name.get());
    }

    @KafkaListener(id = "decrement", topics = TopicProducer.NAME_DECREMENT)
    public void decrement(Name name) {
        LOGGER.info("Decrement listener to " + name);
        counter.decrement(name.get());
    }
}

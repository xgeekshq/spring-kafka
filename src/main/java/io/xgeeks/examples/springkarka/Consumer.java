package io.xgeeks.examples.springkarka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(id = "myId", topics = "topic2")
    public void listen(Name in) {
        System.out.println(in);
    }
}

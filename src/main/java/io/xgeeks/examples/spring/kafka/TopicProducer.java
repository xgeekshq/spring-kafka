package io.xgeeks.examples.spring.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicProducer {

    static final String NAME_INCREMENT = "name_increment";
    static final String NAME_DECREMENT = "name_decrement";

    @Bean
    public NewTopic increment() {
        return TopicBuilder.name(NAME_INCREMENT)
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic decrement() {
        return TopicBuilder.name(NAME_DECREMENT)
                .partitions(10)
                .replicas(1)
                .build();
    }

}

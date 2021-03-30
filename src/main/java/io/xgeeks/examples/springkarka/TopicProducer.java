package io.xgeeks.examples.springkarka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class TopicProducer {

    private static final String TOPIC_NAME = "name";

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(TOPIC_NAME)
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, Name> template) {
        return args -> {
            var otavio = new Name();
            otavio.setName("Otavio");
            template.send(TOPIC_NAME, otavio);
        };
    }
}

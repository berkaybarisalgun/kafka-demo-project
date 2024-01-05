package kafkademo.kafkademo.service;

import kafkademo.kafkademo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserListener {
    @KafkaListener(topics = "kafka-demo", containerFactory = "kafkaListenerContainerFactory")
    public void consume(
            @Payload User user
    ) {
        log.info("userId: {}, agentName: {}, partition: {}, offset: {}", user.getId());
    }
}

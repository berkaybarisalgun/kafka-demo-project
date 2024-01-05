package kafkademo.kafkademo.controller;

import kafkademo.kafkademo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping
    public ResponseEntity<User> create() throws ExecutionException, InterruptedException {
        var user = User.builder()
                .id(UUID.randomUUID().toString())
                .userName("berkayalgun")
                .age(30)
                .build();

        Message<User> userMsg = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"kafka-demo")
                //.setHeader(KafkaHeaders.KEY,user.getUserName())
                .setHeader(KafkaHeaders.PARTITION,0)
                .setHeader("X-AgentName", "kafka-demo-app")
                .build();

        kafkaTemplate.send(userMsg).get();

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}

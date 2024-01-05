package kafkademo.kafkademo.model;

import lombok.*;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private String id;
    private String userName;
    private Integer age;

}

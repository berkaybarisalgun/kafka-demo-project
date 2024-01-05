package kafkademo.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaDemoApplication {

	public static void main(String[] args) {
		topla(4,3);

		SpringApplication.run(KafkaDemoApplication.class, args);
	}



	public static int topla(int a,int b){
		return a+b;
	}



}

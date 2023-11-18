package info.cafeit.notificationserivce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;

@SpringBootApplication
public class NotificationSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationSerivceApplication.class, args);
	}


	@Bean
	public JsonMessageConverter converter() {
		return new JsonMessageConverter();
	}
}

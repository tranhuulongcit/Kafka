package info.cafeit.tradingorderserivce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;

@SpringBootApplication
public class TradingOrderSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingOrderSerivceApplication.class, args);
	}

	@Bean
	public JsonMessageConverter converter() {
		return new JsonMessageConverter();
	}
}

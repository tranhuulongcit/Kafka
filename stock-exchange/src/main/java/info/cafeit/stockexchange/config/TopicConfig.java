package info.cafeit.stockexchange.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    public static final String NOTIFICATION = "notification";
    public static final String TRADING_ORDER = "tradingOrder";

    @Bean
    public NewTopic notification() {
        return new NewTopic(NOTIFICATION, 4, (short) 1);
    }


    @Bean
    public NewTopic tradingOrder() {
        return new NewTopic(TRADING_ORDER, 4, (short) 1);
    }

}

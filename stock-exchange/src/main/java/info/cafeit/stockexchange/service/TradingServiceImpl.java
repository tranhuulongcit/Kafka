package info.cafeit.stockexchange.service;

import info.cafeit.stockexchange.config.TopicConfig;
import info.cafeit.stockexchange.model.Message;
import info.cafeit.stockexchange.model.TradingOrder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TradingServiceImpl implements TradingService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public TradingServiceImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public TradingOrder setOrder(TradingOrder orderDto) {

        Message notify = Message.builder()
                .sendTo(orderDto.getEmail())
                .subject(String.format("[%s] Transaction notification",
                        orderDto.getOrderType().toString().replace("_", "/")))
                .content(String.format("Your have just order transaction with the trading pair [%s] with the amount [%f].",
                        orderDto.getPairTradeName(), orderDto.getAmount()))
                .build();

        kafkaTemplate.send(TopicConfig.NOTIFICATION, notify); // send email notify to user

        kafkaTemplate.send(TopicConfig.TRADING_ORDER, orderDto); // set order
        return orderDto;
    }
}

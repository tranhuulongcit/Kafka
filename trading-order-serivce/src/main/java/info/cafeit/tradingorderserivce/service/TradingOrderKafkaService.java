package info.cafeit.tradingorderserivce.service;

import info.cafeit.tradingorderserivce.model.TradingOrder;
import info.cafeit.tradingorderserivce.model.TradingOrderDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class TradingOrderKafkaService {

    private final TradingOrderService tradingOrderService;

    public TradingOrderKafkaService(TradingOrderService tradingOrderService) {
        this.tradingOrderService = tradingOrderService;
    }

    @KafkaListener(id = "tradingOrderGroup", topics = "tradingOrder")
    public void listener(TradingOrderDTO tradingOrderDTO) {
        log.info("Receive data...");
        Optional<TradingOrder> tradingOrder = tradingOrderService.insertTradingOrder(tradingOrderDTO);
        log.info("Insert success::id={}", tradingOrder.get().getId());
    }
}

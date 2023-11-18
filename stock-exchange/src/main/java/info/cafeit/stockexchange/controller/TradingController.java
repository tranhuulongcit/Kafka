package info.cafeit.stockexchange.controller;

import info.cafeit.stockexchange.model.TradingOrder;
import info.cafeit.stockexchange.service.TradingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trading")
public class TradingController {

    private final TradingService tradingService;

    public TradingController(TradingService tradingService) {
        this.tradingService = tradingService;
    }

    @PostMapping("/order")
    public ResponseEntity<?> setOrder(@RequestBody TradingOrder orderDto) {
        TradingOrder order = tradingService.setOrder(orderDto);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Transaction error", HttpStatus.NOT_FOUND);
        }
    }
}

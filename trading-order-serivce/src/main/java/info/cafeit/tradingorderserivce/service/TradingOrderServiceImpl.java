package info.cafeit.tradingorderserivce.service;

import info.cafeit.tradingorderserivce.model.TradingOrderDTO;
import info.cafeit.tradingorderserivce.model.TradingOrder;
import info.cafeit.tradingorderserivce.repository.TradingOrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TradingOrderServiceImpl implements TradingOrderService {

    private final TradingOrderRepository tradingOrderRepository;

    @Override
    @Transactional
    public Optional<TradingOrder> insertTradingOrder(TradingOrderDTO dto) {
        TradingOrder tradingOrder = TradingOrder.builder()
                .orderType(TradingOrder.OrderType.valueOf(dto.getOrderType().name()))
                .amount(dto.getAmount())
                .email(dto.getEmail())
                .pairTradeName(dto.getPairTradeName())
                .createdDate(new Date())
                .updatedDate(new Date())
                .build();

        return Optional.of(tradingOrderRepository.save(tradingOrder));
    }
}

package info.cafeit.tradingorderserivce.service;

import info.cafeit.tradingorderserivce.model.TradingOrderDTO;
import info.cafeit.tradingorderserivce.model.TradingOrder;

import java.util.Optional;

public interface TradingOrderService {
    Optional<TradingOrder> insertTradingOrder(TradingOrderDTO dto);
}

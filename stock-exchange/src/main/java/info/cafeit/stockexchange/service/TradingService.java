package info.cafeit.stockexchange.service;

import info.cafeit.stockexchange.model.TradingOrder;

public interface TradingService {

    TradingOrder setOrder(TradingOrder orderDto);
}

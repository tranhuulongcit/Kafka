package info.cafeit.tradingorderserivce.repository;

import info.cafeit.tradingorderserivce.model.TradingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingOrderRepository extends JpaRepository<TradingOrder, Integer> {
}

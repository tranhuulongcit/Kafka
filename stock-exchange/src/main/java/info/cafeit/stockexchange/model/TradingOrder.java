package info.cafeit.stockexchange.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradingOrder {

    private OrderType orderType;
    private String pairTradeName;
    private Double amount;
    private String email;

    public enum OrderType {
        SPOT_BUY, SPOT_SELL, FEATURE_LONG, FEATURE_SHORT
    }
}

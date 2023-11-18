package info.cafeit.tradingorderserivce.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TradingOrder")
@Getter
@Setter
@Builder
public class TradingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "orderType")
    private OrderType orderType;

    @Column(name = "pairTradeName")
    private String pairTradeName;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "email")
    private String email;

    @CreatedDate
    @Column(name = "createdDate")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "updatedDate")
    private Date updatedDate;

    public enum OrderType {
        SPOT_BUY, SPOT_SELL, FEATURE_LONG, FEATURE_SHORT
    }

}
package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    private int id;
    private LocalDateTime date;
    private Customer customer;

    private BigDecimal totalPrice;


}

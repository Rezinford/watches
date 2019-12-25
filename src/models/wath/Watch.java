package models.wath;

import models.Vendor;
import models.type.Brand;
import models.type.WatchType;

import java.math.BigDecimal;

public class Watch {
    private String brand;
    private WatchType type;
    private BigDecimal price;
    private int quantity;
    private Vendor vendor;

      public Watch(String brand, WatchType type, BigDecimal price, int quantity, Vendor vendor) {
    this.brand=brand;
    this.type=type;
    this.price=price;
    this.quantity=quantity;
    this.vendor= vendor;
    }

}

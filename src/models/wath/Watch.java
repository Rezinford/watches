package models.wath;

import models.Vendor;
import models.type.Brand;
import models.type.WatchType;

import java.math.BigDecimal;

public class Watch {
    private Brand brand;
    private WatchType type;
    private BigDecimal price;
    private int quantity;
    private Vendor vendor;
}

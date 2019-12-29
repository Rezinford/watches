package models.order;

import models.wath.Watch;

import java.math.BigDecimal;

public class Purchase {
    private int id;
    private Watch watch;
    private BigDecimal price;
    private int quantity;

    public Purchase(Watch watch, int quantity) {
        this.watch = watch;
        this.price = watch.getPrice();
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

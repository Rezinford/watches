package models.wath;

import models.Vendor;

import java.math.BigDecimal;
import java.util.Objects;

public class Watch {
    private int id;
    private WatchType type;
    private BigDecimal price;
    private int quantity;
    private Vendor vendor;

    public Watch(int id, WatchType type, BigDecimal price, int quantity, Vendor vendor) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.vendor = vendor;
    }

    public Watch(WatchType type, BigDecimal price, int quantity, Vendor vendor) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.vendor = vendor;
    }

    public int getId() {
        return id;
    }

    public WatchType getType() {
        return type;
    }

    public void setType(WatchType type) {
        this.type = type;
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

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Watch watch = (Watch) o;
        return id == watch.id &&
                quantity == watch.quantity &&
                Objects.equals(type, watch.type) &&
                Objects.equals(price, watch.price) &&
                Objects.equals(vendor, watch.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, price, quantity, vendor);
    }

    @Override
    public String toString() {
        return "Watch{" +
                "id=" + id +
                ", type=" + type +
                ", price=" + price +
                ", quantity=" + quantity +
                ", vendor=" + vendor +
                '}';
    }
}

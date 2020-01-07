package models.order;

import models.Customer;
import models.watch.Watch;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private LocalDateTime date;
    private Customer customer;
    private List<Purchase> purchases;
    private BigDecimal totalPrice;

    private Order() {
    }

    public static class OrderBuilder {
        private Order newOrder;

        public OrderBuilder(Customer customer) {
            newOrder = new Order();
            newOrder.customer = customer;
            newOrder.date = LocalDateTime.now();
            newOrder.purchases = new ArrayList<>();
            newOrder.totalPrice = BigDecimal.ZERO;

        }

        OrderBuilder addItem(Watch watch) {
            return addItem(watch, 1);
        }

        OrderBuilder addItem(Watch watch, int quantity) {
            Purchase purchase = new Purchase(watch, quantity);
            newOrder.totalPrice = newOrder.totalPrice.add(purchase.getPrice().multiply(new BigDecimal(purchase.getQuantity())));
            newOrder.purchases.add(purchase);

            return this;
        }

        public Order build() {
            return newOrder;
        }
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}

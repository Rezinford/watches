package models;

import java.util.Objects;

public class Customer {
    private int id;
    private String name;
    private DiscountCard discountCard;
    private double sumOfOrders;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(int id, String name, DiscountCard discountCard, double sumOfOrders) {
        this.id = id;
        this.name = name;
        this.discountCard = discountCard;
        this.sumOfOrders = sumOfOrders;
    }

    public Customer(String name, DiscountCard discountCard, double sumOfOrders) {
        this.name = name;
        this.discountCard = discountCard;
        this.sumOfOrders = sumOfOrders;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    public double getSumOfOrders() {
        return sumOfOrders;
    }

    public void setSumOfOrders(double sumOfOrders) {
        this.sumOfOrders = sumOfOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Double.compare(customer.sumOfOrders, sumOfOrders) == 0 &&
                Objects.equals(name, customer.name) &&
                Objects.equals(discountCard, customer.discountCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, discountCard, sumOfOrders);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discountCard=" + discountCard +
                ", sumOfOrders=" + sumOfOrders +
                '}';
    }
}

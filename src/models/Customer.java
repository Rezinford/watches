package models;

public class Customer {
    private int id;
    private String name;
    private int cartNumber;
    private double sumOfOrders;

    public Customer(String name, int cartNumber) {
        this.name = name;
        this.cartNumber = cartNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public double getSumOfOrders() {
        return sumOfOrders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public void setSumOfOrders(double sumOfOrders) {
        this.sumOfOrders = sumOfOrders;
    }
}

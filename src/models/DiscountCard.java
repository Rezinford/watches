package models;

import java.util.Objects;

public class DiscountCard {
  private int id;
  private int number;
  private int discount;

  public DiscountCard(int id, int number, int discount){
    this.id = id;
    this.number = number;
    this.discount = discount;
  }

  public DiscountCard(int number, int discount) {
    this.number = number;
    this.discount = discount;
  }

  public int getId() {
    return id;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public int getDiscount() {
    return discount;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DiscountCard that = (DiscountCard) o;
    return id == that.id &&
            number == that.number &&
            discount == that.discount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, discount);
  }

  @Override
  public String toString() {
    return "DiscountCard{" +
            "id=" + id +
            ", number=" + number +
            ", discount=" + discount +
            '}';
  }
}

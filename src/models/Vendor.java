package models;

import java.util.Objects;

public class Vendor {
    private int id;
    private String name;
    private Country country;

    public Vendor(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Vendor(int id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return id == vendor.id &&
                Objects.equals(name, vendor.name) &&
                Objects.equals(country, vendor.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}

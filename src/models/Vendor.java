package models;

import java.util.Objects;

public class Vendor {
    private int id;
    private  String vendorName;
    private Country country;

    public Vendor(String vendorName, Country country) {
        this.vendorName = vendorName;
        this.country = country;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
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
                Objects.equals(vendorName, vendor.vendorName) &&
                Objects.equals(country, vendor.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vendorName, country);
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorName='" + vendorName + '\'' +
                ", country=" + country +
                '}';
    }
}

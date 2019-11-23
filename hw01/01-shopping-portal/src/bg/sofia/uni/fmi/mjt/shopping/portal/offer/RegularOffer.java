package bg.sofia.uni.fmi.mjt.shopping.portal.offer;

import org.jetbrains.annotations.Contract;

import java.time.LocalDate;
import java.util.Comparator;

public class RegularOffer implements Offer, Comparator<RegularOffer> {

    private String productName;
    private LocalDate date;
    private String description;
    private double price;
    private double shippingPrice;

    @Contract(pure = true)
    public RegularOffer(String productName, LocalDate date, String description, double price, double shippingPrice) {
        this.productName = productName;
        this.date = date;
        this.description = description;
        this.price = price;
        this.shippingPrice = shippingPrice;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getShippingPrice() {
        return this.shippingPrice;
    }

    @Override
    public double getTotalPrice() {
        return this.price + this.shippingPrice;
    }

    @Override
    public int compare(RegularOffer o1, RegularOffer o2) {
        if (o1.getTotalPrice() == o2.getTotalPrice()) {
            return 0;
        } else if (o1.getTotalPrice() < o2.getTotalPrice()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof RegularOffer)) {
            return false;
        } else {
            return this.getProductName().toLowerCase() == ((RegularOffer) o).getProductName().toLowerCase()
                    && this.getDate() == ((RegularOffer) o).getDate()
                    && this.getTotalPrice() == ((RegularOffer) o).getTotalPrice();
        }
    }
}

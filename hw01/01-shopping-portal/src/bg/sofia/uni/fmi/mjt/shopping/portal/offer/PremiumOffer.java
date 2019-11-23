package bg.sofia.uni.fmi.mjt.shopping.portal.offer;

import org.jetbrains.annotations.Contract;

import java.time.LocalDate;
import java.util.Comparator;

public class PremiumOffer implements Offer, Comparator<PremiumOffer> {

    private String productName;
    private LocalDate date;
    private String description;
    private double price;
    private double shippingPrice;
    private double discount;

    @Contract(pure = true)
    public PremiumOffer(String productName, LocalDate date, String description, double price, double shippingPrice, double discount) {
        this.productName = productName;
        this.date = date;
        this.description = description;
        this.price = price;
        this.shippingPrice = shippingPrice;
        this.discount = discount;
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

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = (double)Math.round((1 - discount) * this.getTotalPrice() * 100) / 100;
    }

    @Override
    public double getTotalPrice() {
        return this.price + this.shippingPrice;
    }

    @Override
    public int compare(PremiumOffer o1, PremiumOffer o2) {
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
        } else if (!(o instanceof PremiumOffer)) {
            return false;
        } else {
            return this.getProductName().toLowerCase() == ((PremiumOffer) o).getProductName().toLowerCase()
                    && this.getDate() == ((PremiumOffer) o).getDate()
                    && this.getTotalPrice() == ((PremiumOffer) o).getTotalPrice();
        }
    }
}

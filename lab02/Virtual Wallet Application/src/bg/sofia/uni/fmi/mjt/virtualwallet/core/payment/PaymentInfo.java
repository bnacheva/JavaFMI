package bg.sofia.uni.fmi.mjt.virtualwallet.core.payment;

import java.time.LocalDateTime;

public class PaymentInfo {

    private LocalDateTime date;
    private String reason;
    private String location;
    private double cost;

    public PaymentInfo() {

    }

    public PaymentInfo(String reason, String location, double cost) {
        this.reason = reason;
        this.location = location;
        this.cost = cost;
    }

    public PaymentInfo(LocalDateTime date, String reason, String location, double cost) {
        this.date = date;
        this.reason = reason;
        this.location = location;
        this.cost = cost;
    }

    public LocalDateTime getDate() { return this.date; }

    public void setDate(LocalDateTime date) { this.date = date; }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

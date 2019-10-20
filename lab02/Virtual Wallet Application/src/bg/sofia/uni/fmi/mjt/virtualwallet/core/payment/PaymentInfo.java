package bg.sofia.uni.fmi.mjt.virtualwallet.core.payment;

public class PaymentInfo {

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

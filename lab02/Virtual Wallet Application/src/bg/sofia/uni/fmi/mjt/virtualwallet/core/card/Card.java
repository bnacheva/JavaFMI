package bg.sofia.uni.fmi.mjt.virtualwallet.core.card;

public abstract class Card {

    private String name;
    private double amount;

    public Card(String name) {
        this.name = name;
    }

    public abstract boolean executePayment(double cost);

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

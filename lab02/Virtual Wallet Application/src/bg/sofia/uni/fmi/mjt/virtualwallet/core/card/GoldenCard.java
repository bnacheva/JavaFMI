package bg.sofia.uni.fmi.mjt.virtualwallet.core.card;

public class GoldenCard extends Card {

    public GoldenCard(String name) {
        super(name);
    }

    @Override
    public boolean executePayment(double cost) {
        if (cost > 0) {
            this.setAmount(this.getAmount() - 0.75*cost);
            return true;
        }
        else {
            return false;
        }
    }
}

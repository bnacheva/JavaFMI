package bg.sofia.uni.fmi.mjt.virtualwallet.core;

import bg.sofia.uni.fmi.mjt.virtualwallet.core.card.Card;
import bg.sofia.uni.fmi.mjt.virtualwallet.core.card.GoldenCard;
import bg.sofia.uni.fmi.mjt.virtualwallet.core.card.StandardCard;
import bg.sofia.uni.fmi.mjt.virtualwallet.core.payment.PaymentInfo;

import java.util.ArrayList;
import java.util.List;

public class VirtualWallet implements VirtualWalletAPI {

    private List<Card> wallet = new ArrayList<>();

    public VirtualWallet() {

    }

    public List<Card> getCards() {
        return this.wallet;
    }

    public void setCards(List<Card> wallet) {
        this.wallet = wallet;
    }

    @Override
    public boolean registerCard(Card card) {
        if(wallet.isEmpty()) {
            wallet.add(card);
            return true;
        }
        else {
            for (Card c : wallet) {
                if (c.getName() == card.getName()) {
                    return false;
                }
                else if (wallet.size() < 5) {
                    wallet.add(card);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean executePayment(Card card, PaymentInfo paymentInfo) {
        if (card instanceof StandardCard) {
            card.executePayment(paymentInfo.getCost());
            return true;
        }
        else if (card instanceof GoldenCard) {
            card.executePayment(paymentInfo.getCost());
            return true;
        }
        return false;
    }

    @Override
    public boolean feed(Card card, double amount) {
        if (amount > 0) {
            card.setAmount(card.getAmount() + amount);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Card getCardByName(String name) {
        if (wallet.isEmpty()) {
            return null;
        }
        else {
            for (Card c : wallet) {
                if (c.getName() == name) {
                    return c;
                }
            }
            return null;
        }
    }

    @Override
    public int getTotalNumberOfCards() {
        if (wallet.isEmpty()) {
            return 0;
        }
        else {
            return wallet.size();
        }
    }

    public void printWallet() {
        if (wallet.isEmpty()) {
            System.out.println("The virtual wallet is empty!");
        }
        else {
            for (Card c : wallet) {
                System.out.println(c.getName() + " - " + c.getAmount());
            }
        }
    }
}

package bg.sofia.uni.fmi.mjt.virtualwallet.core.payment;

import bg.sofia.uni.fmi.mjt.virtualwallet.core.card.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction {
    private Map<Card, PaymentInfo> allTransactions = new HashMap<>();
    private Card card;
    private PaymentInfo paymentInfo;

    public Transaction() {

    }

    public Map<Card, PaymentInfo> getAllTransactions() {
        return this.allTransactions;
    }

    public void setAllTransactions(Map<Card, PaymentInfo> transactions) {
        this.allTransactions = transactions;
    }

    public void addTransaction(Card c, PaymentInfo p) {
        allTransactions.put(c, p);
    }

    public void printAllTransactions() {
        if (allTransactions.isEmpty()) {
            System.out.println("No new transactions!");
        }
        else {
            for (Map.Entry<Card, PaymentInfo> entry : allTransactions.entrySet())
                System.out.println("Card = " + entry.getKey().getName() +
                        ", PaymentInfo = " + entry.getValue().getReason() + ", " +
                        entry.getValue().getLocation() + ", " + entry.getValue().getCost());
        }
    }
}

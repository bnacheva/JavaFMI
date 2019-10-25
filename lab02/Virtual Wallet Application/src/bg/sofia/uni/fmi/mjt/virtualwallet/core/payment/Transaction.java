package bg.sofia.uni.fmi.mjt.virtualwallet.core.payment;

import bg.sofia.uni.fmi.mjt.virtualwallet.core.card.Card;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Transaction {
    private Map<Card, PaymentInfo> allTransactions = new LinkedHashMap<>();
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
        if (allTransactions.size() < 10) {
            allTransactions.put(c, p);
        } else {
            allTransactions.entrySet().remove(0);
            allTransactions.put(c, p);
        }
    }

    public void printAllTransactions() {
        if (allTransactions.isEmpty()) {
            System.out.println("No new transactions!");
        }
        else {
            for (Map.Entry<Card, PaymentInfo> entry : allTransactions.entrySet())
                System.out.println("Card = " + entry.getKey().getName() +
                        ", PaymentInfo = " + entry.getValue().getDate() + ", " +  entry.getValue().getReason() + ", " +
                        entry.getValue().getLocation() + ", " + entry.getValue().getCost());
        }
    }
}

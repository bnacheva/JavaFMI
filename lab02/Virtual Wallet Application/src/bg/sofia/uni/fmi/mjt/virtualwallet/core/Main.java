package bg.sofia.uni.fmi.mjt.virtualwallet.core;

import bg.sofia.uni.fmi.mjt.virtualwallet.core.card.Card;
import bg.sofia.uni.fmi.mjt.virtualwallet.core.card.GoldenCard;
import bg.sofia.uni.fmi.mjt.virtualwallet.core.card.StandardCard;
import bg.sofia.uni.fmi.mjt.virtualwallet.core.payment.PaymentInfo;
import bg.sofia.uni.fmi.mjt.virtualwallet.core.payment.Transaction;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Card newStandardCard = new StandardCard("standardCard1");
        newStandardCard.setAmount(10);
        Card newGoldenCard = new GoldenCard("goldenCard1");
        newGoldenCard.setAmount(20);
        VirtualWallet wallet = new VirtualWallet();
        wallet.registerCard(newStandardCard);
        wallet.registerCard(newGoldenCard);
        System.out.println("Total number of the cards in the wallet - " + wallet.getTotalNumberOfCards());
        wallet.printWallet();
        wallet.feed(newStandardCard, 5);
        wallet.printWallet();
        wallet.getCardByName("what");
        wallet.getCardByName("goldenCard1");
        PaymentInfo newPaymentInfo = new PaymentInfo("why", "BG", 10);
        wallet.executePayment(newStandardCard, newPaymentInfo);
        wallet.executePayment(newGoldenCard, newPaymentInfo);
        wallet.printWallet();
        String location = LocalDateTime.now().toString();
        PaymentInfo tryPaymentInfo = new PaymentInfo("payment", location, 10);
        Transaction newTransaction = new Transaction();
        newTransaction.addTransaction(newStandardCard, tryPaymentInfo);
        newTransaction.printAllTransactions();
    }
}

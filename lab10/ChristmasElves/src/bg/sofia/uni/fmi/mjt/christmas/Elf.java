package bg.sofia.uni.fmi.mjt.christmas;

import org.jetbrains.annotations.Contract;

public class Elf extends Thread {

    private Workshop workshop;

    private int id;

    private int totalGiftsCrafted;

    @Contract(value = "_, _ -> fail", pure = true)
    public Elf(int id, Workshop workshop) {
        this.id = id;
        this.workshop = workshop;
    }

    @Override
    public void run() {
        craftGift();
    }

    /**
     * Gets a wish from the backlog and creates the wanted gift.
     **/
    public void craftGift() {
        Gift gift = null;

        while ((gift = workshop.nextGift()) != null) {
            try {
                Thread.sleep(gift.getCraftTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            totalGiftsCrafted++;
        }

        System.out.println("Elf #" + id + " created " + totalGiftsCrafted + " gifts");
    }

    /**
     * Returns the total number of gifts that the given elf has crafted.
     **/
    public int getTotalGiftsCrafted() {
        return totalGiftsCrafted;
    }
}

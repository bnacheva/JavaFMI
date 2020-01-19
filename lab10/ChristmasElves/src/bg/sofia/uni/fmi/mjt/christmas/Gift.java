package bg.sofia.uni.fmi.mjt.christmas;

import org.jetbrains.annotations.Contract;

import java.util.Random;

public enum Gift {

    BIKE("Bicycle", 50), CAR("Car", 10),
    DOLL("Barbie doll", 6), PUZZLE("Puzzle", 15);

    private final String type;
    private final int craftTime;

    private static Gift[] gifts = Gift.values();

    private static Random giftRand = new Random();

    @Contract(pure = true)
    private Gift(String type, int craftTime) {
        this.type = type;
        this.craftTime = craftTime;
    }

    @Contract(pure = true)
    public String getType() {
        return type;
    }

    @Contract(pure = true)
    public int getCraftTime() {
        return craftTime;
    }

    public static Gift getGift() {
        return gifts[giftRand.nextInt(gifts.length)];
    }

}

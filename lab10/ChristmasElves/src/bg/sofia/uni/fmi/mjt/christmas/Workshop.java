package bg.sofia.uni.fmi.mjt.christmas;

import org.jetbrains.annotations.Contract;

public class Workshop {

    @Contract(pure = true)
    public Workshop() {

    }

    /**
     * Adds a gift to the elves' backlog.
     **/
    public void postWish(Gift gift) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns an array of the elves working in Santa's workshop.
     **/
    public Elf[] getElves() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the next gift from the elves' backlog that has to be manufactured.
     **/
    public Gift nextGift() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the total number of wishes sent to Santa's workshop by the kids.
     **/
    public int getWishCount() {
        throw new UnsupportedOperationException();
    }
}

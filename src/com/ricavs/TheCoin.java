package com.ricavs;

// Ignora este
public class TheCoin {
    private String optionCoin;
    private final String[] coinKeys = { "Heads", "Tails" };

    public TheCoin() {}

    public void setRandomCoin() {
        optionCoin = coinKeys[(Math.random()) < 0.5 ? 0 : 1];
    }

    public String getOptionCoin() {
        return optionCoin;
    }
}

package com.ricavs;
// Ignora Este
public class Player {
    private final String name;
    private String optionCoin = "";

    public Player(String playerName) {
        this.name = playerName;
    }

    public String getOptionCoin() {
        return optionCoin;
    }

    public String getName() {
        return this.name;
    }

    public void setOptionCoin(String chosenOption) {
        this.optionCoin = chosenOption;
    }
}

package com.ricavs;

import java.security.SecureRandom;

public class ThePlayer {
    private String name;
    private String handOption;

    public ThePlayer() {

    }

    public ThePlayer(String name) {
        this.name = name;

    }
    public void setHandOption(String hand) {
        this.handOption = hand;
    }

    public String getOptionHand() {
        return this.handOption;
    }

    public String generateRandomHand() {
       return this.handOption = randomHand(GameHands.class).toString();
    }

    // Pick random hand for PC player
    private static <T extends Enum<?>> T randomHand(Class<T> clazz){
        SecureRandom random = new SecureRandom();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}

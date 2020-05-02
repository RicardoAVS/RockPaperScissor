package com.ricavs;
import java.util.Scanner;

public class TheCoinGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keepPlaying = "";

        do {
            RockScissorPaperGame game = new RockScissorPaperGame();
            game.gameStart("Ricardo");

            System.out.println("Play Again?");
            keepPlaying = scanner.nextLine();

        } while (keepPlaying.startsWith("Y") || keepPlaying.startsWith("y"));
    }
}
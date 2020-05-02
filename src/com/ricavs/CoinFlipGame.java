package com.ricavs;
import java.util.Scanner;

// ignora este
public class CoinFlipGame {
    private final Player[] players = new Player[2];

    public void gameStart(String player1, String player2) {
        players[0] = new Player(player1);
        players[1] = new Player(player2);

        var selectedPlayer = pickRanPlayer();
        coinPick(selectedPlayer);
    }

    // Select a random player
    public Player pickRanPlayer() {
        var randomIndex = (Math.random() < 0.5 ? 0 : 1);
        var pickedPlayer = players[randomIndex];
        System.out.println("*** " + pickedPlayer.getName() + " has been randomly picked *** ");
        System.out.println("");
        return pickedPlayer;
    }

    //
    public void coinPick(Player selectedPlayer) {
        Scanner scanner = new Scanner(System.in);

        TheCoin coin = new TheCoin();
        coin.setRandomCoin();

        System.out.print(selectedPlayer.getName() + " choose a side (Heads or Tails): ");
        var pickedOption = scanner.nextLine();

        selectedPlayer.setOptionCoin(pickedOption);
        var winningOption = selectedPlayer.getOptionCoin();

        if (winningOption.equalsIgnoreCase(coin.getOptionCoin())) {
            System.out.println(selectedPlayer.getName() + " has won with " + winningOption);
        } else {
            System.out.println(selectedPlayer.getName() + " has lost with " + winningOption);
        }

    }
}

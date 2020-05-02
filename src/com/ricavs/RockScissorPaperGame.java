package com.ricavs;
import java.util.Scanner;

public class RockScissorPaperGame {
    private final ThePlayer[] players = new ThePlayer[2];
    private Integer matchScore;
    private Integer playerOneScore = 0;
    private Integer playerTwoScore = 0;
    boolean stillInGame = true;

    public void gameStart(String player1Name) {
        players[0] = new ThePlayer(player1Name);
        players[1] = new ThePlayer();

        boolean invalidNumFormat = true;
        String playerOneHand;
        String playerTwoHand;

        while (invalidNumFormat) {

            try {
                invalidNumFormat = false;
                Scanner theGame = new Scanner(System.in);

                System.out.print("What will be the maximum score: ");
                String winPoints = theGame.nextLine();
                Integer validNumberFormat = Integer.valueOf(winPoints);

                setMatchScore(validNumberFormat);


                int numRounds = 1;
                while (stillInGame) {
                    System.out.println("");
                    System.out.println("             Round #" + numRounds + "          ");
                    System.out.println(" **** Available hand options **** ");
                    System.out.println("              ROCK               ");
                    System.out.println("             SCISSOR             ");
                    System.out.println("              PAPER              ");
                    System.out.println("                                 ");
                    System.out.print("Pick your hand: ");
                    playerOneHand = theGame.nextLine();
                    players[0].setHandOption(playerOneHand);

                    // generate random hand for Bot player
                    playerTwoHand = players[1].generateRandomHand();

                    compareHands(playerOneHand, playerTwoHand);
                    System.out.println("    ********* Game table *********      ");
                    System.out.println("    **    - Match Points:   " + matchScore + "   **");
                    System.out.println("    **    - Your Score:     " + playerOneScore + "   **");
                    System.out.println("    **    - Computer Score: " + playerTwoScore + "   **");
                    System.out.println("    ****************************** ");
                    numRounds++;

                    // end game if any player reach maxScore
                   stillInGame = endGame();
                }


                System.out.println("");
                if (playerOneScore == matchScore) {
                    System.out.println("Congratulations you won the game!");
                    System.out.println("");
                } else if (playerTwoScore == matchScore) {
                    System.out.println("You Lose!");
                    System.out.println("");
                }

            } catch (NumberFormatException numberFormatException) {
                System.out.println("Please provide a valid number format.");
                invalidNumFormat = true;
            }
        }
    }

    private void setMatchScore(Integer points) {
        this.matchScore = points;
    }

    private void compareHands(String playerOneHand, String playerTwoHand) {
       players[1].setHandOption(playerTwoHand);

        System.out.println("");
        System.out.println(" -- Your hand " + players[0].getOptionHand().toUpperCase() + " vs " + "Opponent's hand " + players[1].getOptionHand() + " --");
        System.out.print("");
        System.out.println("");
        // Compare to ROCK hand
        if (players[0].getOptionHand().equalsIgnoreCase("ROCK")) {

            if (players[1].getOptionHand().equalsIgnoreCase("ROCK")) {
                System.out.println("         This round was a Tie");
            } else if (players[1].getOptionHand().equalsIgnoreCase("PAPER")) {
                System.out.println("         You lose this round ");
                playerTwoScore += 1;
            } else if (players[1].getOptionHand().equalsIgnoreCase("SCISSOR")) {
                System.out.println("          Your won this round");
                playerOneScore += 1;
            }
            System.out.println("");

            // Compare to SCISSOR hand
        } else if (players[0].getOptionHand().equalsIgnoreCase("SCISSOR")) {

            if (players[1].getOptionHand().equalsIgnoreCase("SCISSOR")) {
                System.out.println("            This round was a Tie  ");
            } else if (players[1].getOptionHand().equalsIgnoreCase("ROCK")) {
                System.out.println("            You lose this round");
                playerTwoScore += 1;
            } else if (players[1].getOptionHand().equalsIgnoreCase("PAPER")) {
                System.out.println("           Your won this round ");
                playerOneScore += 1;
            }
            System.out.println("");

            // Compare to PAPER hand
         } else if (players[0].getOptionHand().equalsIgnoreCase("PAPER")) {

            if (players[1].getOptionHand().equalsIgnoreCase("PAPER")) {
                System.out.println("          This round was a Tie");
            } else if (players[1].getOptionHand().equalsIgnoreCase("SCISSOR")) {
                System.out.println("          You lose this round ");
                playerTwoScore += 1;
            } else if (players[1].getOptionHand().equalsIgnoreCase("ROCK")) {
                System.out.println("          Your won this round");
                playerOneScore += 1;
            }
            System.out.println("");

        }
   }


    private boolean endGame() {
      boolean endGame = true;
        if (playerOneScore == matchScore) {
            endGame = false;
        } else if (playerTwoScore == matchScore) {
            endGame = false;
        }
        return endGame;
    }

}

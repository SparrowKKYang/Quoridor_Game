/**
 * GameCenter.java
 *
 * it will start some turn based game
 * These include 'Tic Tac Toe', 'Order and Chaos' and 'Super Tic Tac Toe'
 * if one round ends, and ask user to play another round
 * if user want to quit, it will print summary results
 *
 */

import java.util.Scanner;

public class GameCenter {

    // print a menu, and prompt user to enter 1 - 3
    // for starting a different game.
    // return user select
    private int chooseTurnBaseGame(){
        String head = "Welcome to play TTT games.\n";
        head += "you have  games to choose.\n";
        Menu menu = new Menu(head);

        menu.addOption("Quoridor");
        menu.addOption("Tic Tac Toe");
        menu.addOption("Order and Chaos");
        menu.addOption("Super Tic Tac Toe");
        menu.addOption("exit game");
        menu.printMenu();
        int select = menu.selectOption();
        return  select;
    }

    //prompt user to enter player's name
    //return a player
    private Player readName(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String name = sc.nextLine();
        return new Player(name);
    }

    // create a turn based game
    private TurnGame CreateTurnGame(){
        int choose = chooseTurnBaseGame();
        TurnGame game = null;

        switch (choose){
            case 1:
                game = new Quoridor();
                System.out.println("You will play quoridor");
                break;
            case 2:
                game = new TicTacToe();
                System.out.println("You will play a new Tic Tac Toe");
                break;
            case 3:
                game = new OrderAndChaos();
                System.out.println("You will play Order and Chaos");
                break;
            case 4:
                game = new SuperTicTacToe();
                System.out.println("You will play Order super Tic Tac Toe");
                break;
        }
        return game;
    }

    // start a TTT game, if one round is over,
    // The user is asked to continue to the next round.
    public void startTurnBaseGame(){
        while(true){
            TurnGame game = CreateTurnGame();
            if(game == null){
                return; // exit game
            }
            // create 2 players
            Player player1 = readName("Please enter one player's name: ");
            Player player2 = readName("Please enter the other player's name: ");
            game.addPlayer(player1);
            game.addPlayer(player2);

            while (true){
                game.initialGame(); // initial TTT game
                game.oneRound(); // play one round
                if(!isTryAnotherRound()){
                    break;
                }
            }
            // print summary result
            String summary = game.getSummaryResult();
            System.out.println(summary);
        }
    }

    // ask user want to play another round
    public boolean  isTryAnotherRound(){
        String prompt = "Would you like to start another round?\n";
        prompt += "Press 'y' to continue, or any other key to exit game.";

        if(Menu.readAChar(prompt) != 'y'){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        GameCenter center = new GameCenter();
        center.startTurnBaseGame();
    }
}

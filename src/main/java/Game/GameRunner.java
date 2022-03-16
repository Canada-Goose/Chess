package Game;

import Board.Coordinate;
import Board.CoordinateException;

import java.util.Scanner;

public class GameRunner {
    // The game that will be run
    private Game game;

    // The scanner object that is used to get input from the user
    private final Scanner scanner = new Scanner(System.in);

    public GameRunner(Game game) {
        this.game = game;
    }

    public void start() {
        // The main game loop
        while (!this.game.isEnded()) {

            // Print the status of the game
            this.printTurn();

            // Have the user input their move
            Move move = this.getPlayerMove();

            // Make the move
            this.game.performMove(move);

            // Advance to the next turn
            this.game.nextPlayer();
        }

        // The game is over, print the end message
        this.printEndMessage();
    }

    private Move getPlayerMove() {

        Move move = null;

        while(move == null) {
            // Get the url of the square that the piece is on
            System.out.println("Input the coordinates of the piece you want to move: ");
            Coordinate startCoordinate = this.inputCoordinates();

            // Get the url of the square that the piece will move to
            System.out.println("Input the coordinates of the destination you want to move to: ");
            Coordinate endCoordinate = this.inputCoordinates();

            // Create a move using the coordinates that the player input
            move = this.game.createMove(startCoordinate, endCoordinate);

            if (move == null) {
                System.out.println("Please enter a valid move.");
            }
        }

        return move;
    }

    private Coordinate inputCoordinates() {
        Coordinate coordinate = null;

        while (coordinate == null) {

            // Get input from the user
            String input = this.scanner.nextLine();

            // If the input is a valid coordinate, return a coordinate object, otherwise ask again

            try {
                coordinate = new Coordinate(input);
            } catch (CoordinateException e) {
                System.out.println("Invalid coordinate.  Try again: ");
            }


        }

        return coordinate;
    }

    public void printTurn() {
        // Print the color of the turn
        System.out.println("It is " + this.game.getCurrentPlayer().getColor().toString().toLowerCase() + "'s turn.\n");
        // Print out the board
        System.out.println(this.game.getBoard().toString());
    }

    public void printEndMessage() {
        // If the game is over
        if (this.game.isEnded()) {
            // Print out a message based to the status of the game
            if (this.game.getStatus() == GameStatus.WON) {
                System.out.println("The game has been won.");
            } else if (this.game.getStatus() == GameStatus.TIE) {
                System.out.println("The game is a draw.");
            }
        }
    }
}

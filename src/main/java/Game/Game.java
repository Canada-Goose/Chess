package Game;

import Board.*;
import Piece.*;


import java.util.ArrayList;

public class Game {
    // The players playing the game
    private ArrayList<Player> players = new ArrayList<Player>();

    // The game board
    private Board board = new Board();

    // The player whose turn it currently is
    private Player currentPlayer;

    // A history of all moves made
    private MoveHistory moveHistory = new MoveHistory();

    // The current status of the game, in progress, won, or tied
    private GameStatus gameStatus = GameStatus.IN_PROGRESS;

    public Game(Player whitePlayer, Player blackPlayer) throws GameException {

        // Make sure there is a white and a black player
        if ((whitePlayer != null && blackPlayer != null) && (!whitePlayer.isColor(Color.WHITE) && !blackPlayer.isColor(Color.BLACK))) {
            throw new GameException("Players must be not be null and players must be opposite colors");
        }

        // Add both players to the players array
        this.players.add(whitePlayer);
        this.players.add(blackPlayer);

        // The current player starts as the first player
        this.currentPlayer = this.players.get(0);

        // Set up the board
        this.setupBoard();
    }

    public Move createMove(Coordinate start, Coordinate end) {

        // Get the squares that define the move
        Square startSquare = this.board.getSquare(start);
        Square endSquare = this.board.getSquare(end);

        // Make sure there is a piece to move
        if (!startSquare.squareIsEmpty()) {
            // Make sure the piece is the right color
            if (startSquare.getPiece().isColor(this.currentPlayer.getColor())) {
                return new Move(this.currentPlayer, startSquare.getPiece(), startSquare, endSquare);
            }
        }

        return null;
    }

    public boolean performMove(Move move) {

        // Execute the move
        boolean moveWasSuccessful = move.execute();

        // If the move was successful, save the move, and check if it was a winning move
        if (moveWasSuccessful) {
            this.moveHistory.save(move);
            this.checkForWin();
        }

        return moveWasSuccessful;
    }

    private void checkForWin() {
        // Check to see if the current player won the game
        // TODO Need to check for win
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public void nextPlayer() {
        // Advance to the next player
        this.currentPlayer = this.currentPlayer.equals(this.players.get(0)) ? this.players.get(1) : this.players.get(0);
    }

    public GameStatus getStatus() {
        return this.gameStatus;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isEnded() {
        return !this.getStatus().equals(GameStatus.IN_PROGRESS);
    }

    public Board getBoard() {
        return this.board;
    }

    public void setupBoard() {
        // Create new piece objects and set them on the board

        try {

            // Setup white pieces
            this.getBoard().setPieceOnSquare("A1", new Castle(Color.WHITE));
            this.getBoard().setPieceOnSquare("B1", new Knight(Color.WHITE));
            this.getBoard().setPieceOnSquare("C1", new Bishop(Color.WHITE));
            this.getBoard().setPieceOnSquare("D1", new King(Color.WHITE));
            this.getBoard().setPieceOnSquare("E1", new Queen(Color.WHITE));
            this.getBoard().setPieceOnSquare("F1", new Bishop(Color.WHITE));
            this.getBoard().setPieceOnSquare("G1", new Knight(Color.WHITE));
            this.getBoard().setPieceOnSquare("H1", new Castle(Color.WHITE));

            this.getBoard().setPieceOnSquare("A2", new Pawn(Color.WHITE));
            this.getBoard().setPieceOnSquare("B2", new Pawn(Color.WHITE));
            this.getBoard().setPieceOnSquare("C2", new Pawn(Color.WHITE));
            this.getBoard().setPieceOnSquare("D2", new Pawn(Color.WHITE));
            this.getBoard().setPieceOnSquare("E2", new Pawn(Color.WHITE));
            this.getBoard().setPieceOnSquare("F2", new Pawn(Color.WHITE));
            this.getBoard().setPieceOnSquare("G2", new Pawn(Color.WHITE));
            this.getBoard().setPieceOnSquare("H2", new Pawn(Color.WHITE));

            // Setup black pieces
            this.getBoard().setPieceOnSquare("A8", new Castle(Color.BLACK));
            this.getBoard().setPieceOnSquare("B8", new Knight(Color.BLACK));
            this.getBoard().setPieceOnSquare("C8", new Bishop(Color.BLACK));
            this.getBoard().setPieceOnSquare("D8", new King(Color.BLACK));
            this.getBoard().setPieceOnSquare("E8", new Queen(Color.BLACK));
            this.getBoard().setPieceOnSquare("F8", new Bishop(Color.BLACK));
            this.getBoard().setPieceOnSquare("G8", new Knight(Color.BLACK));
            this.getBoard().setPieceOnSquare("H8", new Castle(Color.BLACK));

            this.getBoard().setPieceOnSquare("A7", new Pawn(Color.BLACK));
            this.getBoard().setPieceOnSquare("B7", new Pawn(Color.BLACK));
            this.getBoard().setPieceOnSquare("C7", new Pawn(Color.BLACK));
            this.getBoard().setPieceOnSquare("D7", new Pawn(Color.BLACK));
            this.getBoard().setPieceOnSquare("E7", new Pawn(Color.BLACK));
            this.getBoard().setPieceOnSquare("F7", new Pawn(Color.BLACK));
            this.getBoard().setPieceOnSquare("G7", new Pawn(Color.BLACK));
            this.getBoard().setPieceOnSquare("H7", new Pawn(Color.BLACK));

        } catch (CoordinateException exception) {
            exception.printStackTrace();
        }

    }
}

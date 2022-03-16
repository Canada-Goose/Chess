package Game;

import Board.Square;
import Piece.Piece;

public class Move {
    // The player making the move
    private Player player;
    // The piece that is being moved
    private Piece piece;
    // The square where the move begins
    private Square startSquare;
    // The square where the move ends
    private Square destinationSquare;

    public Move(Player player, Piece piece, Square startSquare, Square destinationSquare) {
        this.player = player;
        this.piece = piece;
        this.startSquare = startSquare;
        this.destinationSquare = destinationSquare;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public Square getStartSquare() {
        return this.startSquare;
    }

    public Square getDestinationSquare() {
        return this.destinationSquare;
    }

    public boolean execute() {
        if (this.getPiece().canMove(this.getStartSquare(), this.getDestinationSquare())) {
            // If there is a piece on the destination square, capture it
            if (!this.getDestinationSquare().squareIsEmpty()) {
                Piece pieceToCapture = this.getDestinationSquare().getPiece();
                this.getPlayer().addCapturedPiece(pieceToCapture);
            }

            // Remove the piece from the move's source square
            this.getStartSquare().removePiece();
            // Set the piece on the move's destination sqaure
            this.getDestinationSquare().setPiece(this.getPiece());

            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        // This needs to return a string of the move in Chess Notation
        return "This move is owned by: " + this.getPlayer().toString() + "\n" +
                "The piece that is moving is: " + this.getPiece().toString() + "\n" +
                "This move is starting at: " + this.getStartSquare().getPosition().toString() + "\n" +
                "This move is ending at: " + this.getDestinationSquare().getPosition().toString() + "\n";
    }

}

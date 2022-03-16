package Piece;

import Board.Square;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    @Override
    public Boolean canMove(Square startSquare, Square destinationSquare) {
        // There is a piece at the destination, and it's the same color
        if (!destinationSquare.squareIsEmpty()) {
            if (destinationSquare.getPiece().isColor(this.getColor())) {
                return false;
            }
        }

        // The Queen can move straight or diagonally in any direction, so check both cases
        int xMove = Math.abs(startSquare.getPosition().getX() - destinationSquare.getPosition().getX());
        int yMove = Math.abs(startSquare.getPosition().getY() - destinationSquare.getPosition().getY());

        if (xMove * yMove == 0) {
            return true;
        } else {
            return xMove / yMove == 1;
        }
    }

    @Override
    public String getAbbrev() {
        return this.isColor(Color.WHITE) ? "♛" : "♕";
    }
}

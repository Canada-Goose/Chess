package Piece;

import Board.Square;

public class Bishop extends Piece {

    public Bishop(Color color) {
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

        // Bishops can move diagonally in any direction, so the difference between the X values
        // divided by the difference between the Y values should equal one
        int xMove = Math.abs(startSquare.getPosition().getX() - destinationSquare.getPosition().getX());
        int yMove = Math.abs(startSquare.getPosition().getY() - destinationSquare.getPosition().getY());

        return xMove / yMove == 1;
    }

    @Override
    public String getAbbrev() {
        return this.isColor(Color.WHITE) ? "♝" : "♗";
    }
}

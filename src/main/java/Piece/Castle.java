package Piece;

import Board.Square;

public class Castle extends Piece {

    public Castle(Color color) {
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

        int xMove = Math.abs(startSquare.getPosition().getX() - destinationSquare.getPosition().getX());
        int yMove = Math.abs(startSquare.getPosition().getY() - destinationSquare.getPosition().getY());

        return xMove * yMove == 0;
    }

    @Override
    public String getAbbrev() {
        return this.isColor(Color.WHITE) ? "♜" : "♖";
    }
}

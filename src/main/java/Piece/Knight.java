package Piece;

import Board.Square;

public class Knight extends Piece {

    public Knight(Color color) {
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

        // TODO Implement this
        return true;
    }

    @Override
    public String getAbbrev() {
        return this.isColor(Color.WHITE) ? "♞" : "♘";
    }
}

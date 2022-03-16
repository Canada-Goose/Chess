package Board;

import Piece.Piece;
import Piece.Color;

import java.util.Objects;

public class Square {
    // A coordinate representing the position of the square in the board
    private Coordinate position;

    // The color of the square
    private Color color;

    // The piece that is currently on the square, null there is no piece
    private Piece piece;

    public Square(int x, int y, Color color) {
        this.position = new Coordinate(x, y);
        this.color = color;
        this.piece = null;
    }

    public Square(Coordinate position) {
        this.position = position;
    }

    public Coordinate getPosition() {
        return position;
    }

    public Color getColor() {
        return this.color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece removePiece() {
        Piece pieceToRemove = this.getPiece();
        this.setPiece(null);
        return pieceToRemove;
    }

    public boolean squareIsEmpty() {
        return this.piece == null;
    }

    public boolean isColor(Color color) {
        return this.color.equals(color);
    }

    @Override
    public String toString() {
        return this.getPiece() == null ?
                (this.isColor(Color.WHITE) ? "◼" : "◻")
                : this.getPiece().getAbbrev();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Square square = (Square) o;

        return position.equals(square.position) && color == square.color && Objects.equals(piece, square.piece);
    }
}

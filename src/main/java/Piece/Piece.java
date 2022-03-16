package Piece;

import Board.Square;

public abstract class Piece {
    private Color color;
    private boolean isCaptured = false;

    public Piece(Color color) {
        this.color = color;
    }

    public boolean isCaptured() {
        return this.isCaptured;
    }

    public void setCaptured() {
        this.isCaptured = true;
    }

    public Color getColor() {
        return this.color;
    }

    public boolean isColor(Color color) {
        return this.color.equals(color);
    }

    public abstract Boolean canMove(Square startSquare, Square destinationSquare);

    public abstract String getAbbrev();

    @Override
    public String toString() {
        return this.getAbbrev();
    }
}

package Game;

import Piece.Color;
import Piece.Piece;

import java.util.ArrayList;

public class Player {
    // The color that represents the player
    private Color color;
    // The pieces that the player has captured
    private ArrayList<Piece> capturedPieces = new ArrayList<Piece>();

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Piece> getCapturedPieces() {
        return this.capturedPieces;
    }

    public void addCapturedPiece(Piece piece) {
        this.capturedPieces.add(piece);
    }

    public boolean isColor(Color color) {
        return this.getColor().equals(color);
    }

    @Override
    public String toString() {
        return this.getColor().toString().toLowerCase();
    }
}

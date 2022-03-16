package Board;

import Piece.Color;
import Piece.Piece;

import java.util.ArrayList;

public class Board {
    // The nested arraylist that represents the board
    private final ArrayList<ArrayList<Square>> board = new ArrayList<>();

    // The width of the board
    private final int width = 8;
    // The height of the board
    private final int height = 8;

    public Board() {
        this.initialize();
    }

    private void initialize() {
        // Initialize the 2D array that represents the board
        for (int y = 0; y < this.height; y++) {
            // Create an array for a single row
            ArrayList<Square> boardRow = new ArrayList<>();

            for (int x = 0; x < this.width; x++) {
                // Get the color for the square
                Color color = Color.WHITE;
                if ((y % 2 == 0 && x % 2 == 0) || (y % 2 == 1 && x % 2 == 1)) {
                    color = Color.BLACK;
                }

                // Create the square
                Square square = new Square(x, y, color);

                // Add the square to the board
                boardRow.add(square);
            }
            // Add the row to the board
            this.board.add(boardRow);
        }
    }

    public void setPieceOnSquare(String url, Piece piece) throws CoordinateException {
        this.getSquare(url).setPiece(piece);
    }

    private Square getSquare(int x, int y) {

        // Verify that the x and y values are on the board
        if (x < 0 || x > this.width || y < 0 || y > this.height) {
            // throw new Exception("Index out of bounds");
            return null;
        }

        return this.board.get(y).get(x);
    }

    public Square getSquare(String url) throws CoordinateException {
        // Create a coordinate from the url
        Coordinate coordinate = new Coordinate(url);

        return this.getSquare(coordinate);
    }

    public Square getSquare(Coordinate coordinate) {
        // Call getSquare(x, y) with the X and Y values from the provided coordinate
        return this.getSquare(coordinate.getX(), coordinate.getY());
    }

    @Override
    public String toString() {
        // A string builder to represent the board
        StringBuilder boardString = new StringBuilder();

        // Add some padding to the left of the letter coordinates
        boardString.append("  ");

        // The first line of the string should be letters for the X values
        for (int i = 0; i < this.width; i++) {
            boardString.append((char) (i + 65));
        }

        boardString.append("\n");

        // Loop over the rows in the board, create a string for each row, and then add it to the board string
        for (int y = this.height - 1; y >= 0; y--) {
            StringBuilder rowString = new StringBuilder();

            // Add the number of the row on the left for the Y coordinate
            rowString.append(y + 1).append(" ");

            for (int x = 0; x < this.width; x++) {
                // Add the square string to the row string
                rowString.append(this.getSquare(x, y).toString());
            }

            // Add the row string to the board string
            boardString.append(rowString.toString().strip()).append("\n");
        }

        // Return the final string
        return boardString.toString();
    }
}

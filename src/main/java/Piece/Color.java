package Piece;

public enum Color {
    WHITE,
    BLACK;

    private String abbreviation;

    static {
        WHITE.abbreviation = "W";
        BLACK.abbreviation = "B";
    }

    public String getAbbrev() {
        return abbreviation;
    }
}

package Board;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinate {
    // The x position of the coordinate
    private int x;
    // The y position of the coordinate
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(String url) throws CoordinateException {
        String cleanUrl = url.toLowerCase();

        if (Coordinate.urlIsValid(url)) {

            char firstPart = cleanUrl.charAt(0);
            char secondPart = cleanUrl.charAt(1);

            this.x = firstPart - 'a';
            this.y = Integer.parseInt(String.valueOf(secondPart)) - 1;
        } else {
            throw new CoordinateException("Invalid coordinate string");
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        String xString = String.valueOf((char) ((this.x) + (int) 'A'));
        String yString = String.valueOf(this.y + 1);
        return xString + yString;
    }

    public static Boolean urlIsValid(String url) {

        // The url should start with a letter, end with a number, and be only two characters long
        Pattern pattern = Pattern.compile("^[a-zA-Z][1-9]$");
        Matcher matcher = pattern.matcher(url);

        return matcher.matches();
    }
}

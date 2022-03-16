import Game.Game;
import Game.GameRunner;
import Game.GameException;
import Game.Player;
import Piece.Color;

public class Chess {
    public static void main(String[] args) throws Exception {

        // Create the two players, black and white, that will play the game
        Player whitePlayer = new Player(Color.WHITE);
        Player blackPlayer = new Player(Color.BLACK);

        // Create a new game with both players
        try {
            Game game = new Game(whitePlayer, blackPlayer);

            // Create a game runner to run the game
            GameRunner gameRunner = new GameRunner(game);

            // Start the game
            gameRunner.start();

        } catch (GameException exception) {
            exception.printStackTrace();
        }

    }
}

package Game;

import java.util.ArrayList;

public class MoveHistory {
    private ArrayList<Move> history = new ArrayList<>();

    public void save(Move move) {
        this.history.add(move);
    }

    public Move getLastMove() {
        return this.history.get(this.history.size() - 1);
    }
}

package domain;

import java.util.List;
import java.util.Random;

public class LadderGame {

    private final LadderLines ladderLines;

    public LadderGame(LadderLines ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static LadderGame start(int width, LadderHeight height, Random random) {
        return new LadderGame(LadderLines.generate(width, height, random));
    }

    public int getFinalPosition(int startPosition) {
        return ladderLines.getFinalPosition(startPosition);
    }

    public List<LadderLine> getLadderStructure() {
        return ladderLines.getLines();
    }
}

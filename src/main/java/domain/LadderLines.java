package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLines {

    private final List<LadderLine> lines;

    public LadderLines(List<LadderLine> lines) {
        this.lines = List.copyOf(lines);
    }

    public static LadderLines generate(int width, LadderHeight height, Random random) {
        List<LadderLine> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(new LadderLine(width, random));
        }

        return new LadderLines(lines);
    }

    public int getFinalPosition(int startPosition) {
        int currentPosition = startPosition;

        for (LadderLine line : lines) {
            int nextPosition = line.move(currentPosition);
            if (nextPosition != currentPosition) {
                currentPosition = nextPosition;
            }
        }

        return currentPosition;
    }

    public List<LadderLine> getLines() {
        return List.copyOf(lines);
    }
}

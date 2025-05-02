package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final List<Line> lines;
    private final Width width;

    public Ladder(List<Line> lines, Width width) {
        this.lines = lines;
        this.width = width;
    }

    public static Ladder generate(Width width, Height height, Random random) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            Line line = new Line(width);
            line.connect(random);
            lines.add(line);
        }
        return new Ladder(lines, width);
    }

    public int getFinalPosition(int startPosition) {
        int currentPosition = startPosition;
        for (Line line : lines) {
            currentPosition = moveToNextPosition(currentPosition, line);
        }
        return currentPosition;
    }

    private int moveToNextPosition(int currentPosition, Line line) {
        List<Point> points = line.getPoints();

        if (canMoveLeft(currentPosition, points)) {
            currentPosition--;
        }
        if (canMoveRight(currentPosition, points)) {
            currentPosition++;
        }
        return currentPosition;
    }

    private boolean canMoveLeft(int currentPosition, List<Point> points) {
        return currentPosition > 0 && points.get(currentPosition - 1).isConnectedToRight();
    }

    private boolean canMoveRight(int currentPosition, List<Point> points) {
        return currentPosition < points.size() - 1 && points.get(currentPosition).isConnectedToRight();
    }

    public List<Line> getLines() {
        return lines;
    }

    public Width getWidth() {
        return width;
    }
}

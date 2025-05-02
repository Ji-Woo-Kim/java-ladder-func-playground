package view;

import domain.Ladder;
import domain.Line;
import domain.Point;

import java.util.List;

public class LadderPrinter {

    private static final int CONNECTION_WIDTH = 5;

    public void printLadder(Ladder ladder) {
        int width = ladder.getWidth().value();
        for (Line line : ladder.getLines()) {
            printLine(line, width);
        }
    }

    private void printLine(Line line, int width) {
        StringBuilder lineBuilder = new StringBuilder();
        List<Point> points = line.getPoints();

        for (int i = 0; i < width; i++) {
            lineBuilder.append("|");
            lineBuilder.append(printConnection(points, i));
        }

        System.out.println(lineBuilder);
    }

    private String printConnection(List<Point> points, int i) {
        if (i < points.size() && points.get(i).isConnectedToRight()) {
            return "-".repeat(CONNECTION_WIDTH);
        }
        return " ".repeat(CONNECTION_WIDTH);
    }
}

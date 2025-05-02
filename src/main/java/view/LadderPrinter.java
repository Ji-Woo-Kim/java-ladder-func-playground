package view;

import domain.Ladder;
import domain.Line;
import domain.Point;

import java.util.List;

public class LadderPrinter {

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

        System.out.println(lineBuilder.toString());
    }

    private String printConnection(List<Point> points, int i) {
        if (i < points.size() && points.get(i).isConnectedToRight()) {
            return "-----";
        }
        return "     ";
    }
}

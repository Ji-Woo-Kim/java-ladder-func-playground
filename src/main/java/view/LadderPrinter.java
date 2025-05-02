package view;

import domain.Ladder;
import domain.Line;
import domain.Point;

public class LadderPrinter {

    public void print(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder("     ");
        for (Point point : line.getLinks()) {
            stringBuilder.append("|");
            stringBuilder.append(point.hasRightLine() ? "------" : "      ");
        }
        stringBuilder.append("|");
        System.out.println(stringBuilder);
    }
}

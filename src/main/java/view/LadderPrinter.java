package view;

import domain.LadderGame;
import domain.LadderLine;

public class LadderPrinter {

    private static final String POINT = "|";
    private static final String CONNECT_LINE = "-";
    private static final String NO_CONNECT = " ";
    private static final int CONNECTION_WIDTH = 5;

    public static void printLadder(LadderGame ladderGame) {
        ladderGame.getLadderStructure().forEach(LadderPrinter::printLine);
    }

    private static void printLine(LadderLine line) {
        StringBuilder lineBuilder = new StringBuilder();

        lineBuilder.append(POINT);  // 첫 번째 세로줄
        line.getPoints().forEach(point -> {
            if (point.isConnectedRight()) {
                lineBuilder.append(CONNECT_LINE.repeat(CONNECTION_WIDTH));
            } else {
                lineBuilder.append(NO_CONNECT.repeat(CONNECTION_WIDTH));
            }
            lineBuilder.append(POINT);  // 다음 세로줄
        });

        System.out.println(lineBuilder);
    }
}

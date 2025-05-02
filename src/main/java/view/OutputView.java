package view;

import domain.Ladder;

public class OutputView {

    private final LadderPrinter ladderPrinter = new LadderPrinter();

    public void printLadderResult(Ladder ladder) {
        System.out.println("실행결과");

        ladderPrinter.printLadder(ladder);
        for (int i = 0; i < ladder.getLines().get(0).getPoints().size(); i++) {
            System.out.println(i + " -> " + ladder.getFinalPosition(i));
        }
    }
}

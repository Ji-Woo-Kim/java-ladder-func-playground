package view;

import domain.Ladder;

import java.util.List;

public class OutputView {

    private final LadderPrinter ladderPrinter = new LadderPrinter();

    public void printLadder(List<String> playerNames, Ladder ladder, List<String> results) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        printNames(playerNames);
        ladderPrinter.printLadder(ladder);
        printNames(results);
    }

    private void printNames(List<String> names) {
        for (String name : names) {
            System.out.print(String.format("%-6s", name));
        }
        System.out.println();
    }

    public void printSingleResult(String name, String result) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public void printAllResults(List<String> playerNames, List<String> results, Ladder ladder) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < playerNames.size(); i++) {
            int finalIndex = ladder.getFinalPosition(i);
            String result = results.get(finalIndex);
            System.out.println(playerNames.get(i) + " : " + result);
        }
    }
}

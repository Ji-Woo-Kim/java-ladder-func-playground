package controller;

import domain.Height;
import domain.Ladder;
import domain.Width;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Random;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> playerNames = readValidatedPlayerNames();
        List<String> gameResults = readValidatedGameResults(playerNames.size());

        Width width = new Width(playerNames.size());
        Height height = inputView.readHeight();
        Ladder ladder = Ladder.generate(width, height, new Random());
        outputView.printLadder(playerNames, ladder, gameResults);

        String request = inputView.readResultRequest();
        handleResultRequest(request, playerNames, ladder, gameResults);
    }

    private List<String> readValidatedPlayerNames() {
        List<String> names = inputView.readPlayerNames();
        for (String name : names) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("참여자 이름은 1자 이상 5자 이하여야 합니다: " + name);
            }
        }
        return names;
    }

    private List<String> readValidatedGameResults(int expectedSize) {
        List<String> results = inputView.readGameResults();
        if (results.size() != expectedSize) {
            throw new IllegalArgumentException("이름과 결과의 개수가 일치하지 않습니다.");
        }
        return results;
    }

    private void handleResultRequest(String request, List<String> names, Ladder ladder, List<String> results) {
        while (!request.equals("all")) {// 입력이 'all'이 아닐 때
            try {
                int playerIndex = getValidPlayerIndex(request, names);
                outputView.printSingleResult(
                        names.get(playerIndex),
                        results.get(ladder.getFinalPosition(playerIndex))
                );
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 이름입니다. 다시 입력해주세요.");
            }
            request = inputView.readResultRequest();
        }
        // 'all' 입력될 때
        outputView.printAllResults(names, results, ladder);
    }

    private int getValidPlayerIndex(String name, List<String> names) {
        int index = names.indexOf(name);
        if (index == -1) {
            throw new IllegalArgumentException("잘못된 이름입니다: " + name);
        }
        return index;
    }
}

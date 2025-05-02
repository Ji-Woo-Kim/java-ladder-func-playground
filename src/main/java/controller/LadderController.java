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
        final List<String> playerNames = inputView.readPlayerNames();
        final List<String> gameResults = inputView.readGameResults();
        Width width = new Width(playerNames.size());
        Height height = inputView.readHeight();

        Ladder ladder = Ladder.generate(width, height, new Random());

        outputView.printLadder(playerNames, ladder, gameResults);

        String request = inputView.readResultRequest();
        handleResultRequest(request, playerNames, ladder, gameResults);
    }

    private void handleResultRequest(String request, List<String> names, Ladder ladder, List<String> results) {
        while (!request.equals("all")) {
            int playerIndex = names.indexOf(request);
            if (playerIndex != -1) {
                outputView.printSingleResult(names.get(playerIndex), results.get(ladder.getFinalPosition(playerIndex)));
            } else {
                System.out.println("잘못된 이름입니다. 다시 입력해주세요.");
            }
            request = inputView.readResultRequest();
        }
        // 'all' 입력될 때
        outputView.printAllResults(names, results, ladder);
    }
}

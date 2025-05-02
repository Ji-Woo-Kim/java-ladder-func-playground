package controller;

import domain.Height;
import domain.Ladder;
import domain.Width;
import view.InputView;
import view.OutputView;

import java.util.Random;

public class LadderController {

    private final InputView inputview;
    private final OutputView outputview;

    public LadderController(InputView inputview, OutputView outputview) {
        this.inputview = inputview;
        this.outputview = outputview;
    }

    public void run() {
        Width width = inputview.readWidth();
        Height height = inputview.readHeight();

        Ladder ladder = Ladder.generate(width, height, new Random());

        outputview.printLadderResult(ladder);
    }
}

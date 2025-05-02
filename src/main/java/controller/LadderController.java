package controller;

import domain.Height;
import domain.Ladder;
import domain.Width;
import view.InputView;
import view.LadderPrinter;

import java.util.Random;

public class LadderController {

    private final InputView inputview;

    public LadderController(InputView inputview) {
        this.inputview = inputview;
    }

    public void run() {
        Width width = inputview.readWidth();
        Height height = inputview.readHeight();

        Ladder ladder = Ladder.generate(width, height, new Random());
        new LadderPrinter().print(ladder);
    }
}

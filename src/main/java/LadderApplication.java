import controller.LadderController;
import view.InputView;

public class LadderApplication {

    public static void main(String[] args) {
        InputView inputview = new InputView();
        LadderController ladderController = new LadderController(inputview);
        ladderController.run();
    }
}

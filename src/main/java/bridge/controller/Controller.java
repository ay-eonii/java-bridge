package bridge.controller;

import bridge.view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();

    public void execute() {
        outputView.printGreetings();

    }
}

package bridge.controller;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void execute() {
        outputView.printGreetings();
        int size = inputView.readBridgeSize();
        Bridge bridge = new Bridge(size);
        inputView.readMoving();
    }
}

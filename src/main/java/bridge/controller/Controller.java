package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.ResultMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void execute() {
        outputView.printGreetings();

        int size = inputView.readBridgeSize();
        Bridge bridge = new Bridge(size);
        bridgeGame.initGame(bridge);

        String gameCommand;
        do {
            prepare();
            play();
            gameCommand = inputView.readGameCommand();
        } while (bridgeGame.retry(gameCommand));
    }

    private void prepare() {
        ResultMaker.initResult();
        bridgeGame.initGame();
    }

    private void play() {
        boolean isMovable;
        do {
            String moving = inputView.readMoving();
            isMovable = bridgeGame.move(moving);
            String result = ResultMaker.getResult(moving, isMovable);
            outputView.printMap(result);
        } while (isMovable && bridgeGame.hasBridgeLeft());
    }
}

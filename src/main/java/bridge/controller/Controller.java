package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.ResultMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void execute() {
        outputView.printGreetings();
        Bridge bridge = new Bridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);
        start(bridgeGame);
        outputView.printResult(ResultMaker.getResult(bridgeGame));
    }

    private void start(BridgeGame bridgeGame) {
        prepare(bridgeGame);
        play(bridgeGame);
        if (!bridgeGame.hasLeft()) {
            return;
        }
        String gameCommand = inputView.readGameCommand();
        if (bridgeGame.retry(gameCommand)) {
            start(bridgeGame);
        }
    }

    private void prepare(BridgeGame bridgeGame) {
        ResultMaker.initResult();
        bridgeGame.initGame();
    }

    private void play(BridgeGame bridgeGame) {
        String moving = inputView.readMoving();
        boolean isMovable = bridgeGame.move(moving);
        String result = ResultMaker.getResult(moving, isMovable);
        outputView.printMap(result);
        if (isMovable && bridgeGame.hasLeft()) {
            play(bridgeGame);
        }
    }
}

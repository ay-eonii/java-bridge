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

        int size = inputView.readBridgeSize();
        Bridge bridge = new Bridge(size);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        boolean retry;
        do {
            prepare(bridgeGame);
            if (play(bridgeGame) && !bridgeGame.hasBridgeLeft()) {
                break;
            }
            String gameCommand = inputView.readGameCommand();
            retry = bridgeGame.retry(gameCommand);
        } while (retry);

        outputView.printResult(ResultMaker.getResult(bridgeGame));
    }

    private void prepare(BridgeGame bridgeGame) {
        ResultMaker.initResult();
        bridgeGame.initGame();
    }

    private boolean play(BridgeGame bridgeGame) {
        boolean isMovable;
        do {
            String moving = inputView.readMoving();
            isMovable = bridgeGame.move(moving);
            String result = ResultMaker.getResult(moving, isMovable);
            outputView.printMap(result);
        } while (isMovable && bridgeGame.hasBridgeLeft());
        return isMovable;
    }
}

package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private int playCount;
    private int playerLocation = -1;

    public void initGame(Bridge bridge) {
        playCount++;
        this.bridge = bridge;
        initGame();
    }

    public void initGame() {
        playerLocation = -1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        playerLocation++;
        return bridge.isMovable(playerLocation, moving);
    }

    public boolean hasBridgeLeft() {
        return bridge.hasBridgeLeft(playerLocation);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        return GameCommand.R.name().equals(gameCommand);
    }
}

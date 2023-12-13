package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private int playCount = -1;
    private int playerLocation;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        initGame();
    }

    public void initGame() {
        playCount++;
        playerLocation = -1;
    }

    public int getPlayCount() {
        return playCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        if (bridge.isMovable(playerLocation + 1, moving)) {
            playerLocation++;
            return true;
        }
        return false;
    }

    public boolean hasLeft() {
        return bridge.hasLeft(playerLocation);
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

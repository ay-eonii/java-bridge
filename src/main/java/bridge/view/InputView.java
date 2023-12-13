package bridge.view;

import bridge.validator.BridgeValidator;
import bridge.validator.CommandValidator;
import bridge.validator.MoveValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(System.lineSeparator() + BRIDGE_SIZE);
        return getBridge();
    }

    private int getBridge() {
        String size = Console.readLine().trim();
        try {
            return BridgeValidator.validate(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBridge();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(System.lineSeparator() + MOVE);
        return getMove();
    }

    private String getMove() {
        String move = Console.readLine().trim();
        try {
            return MoveValidator.validate(move);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMove();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(System.lineSeparator() + GAME_COMMAND);
        return getGameCommand();
    }

    private String getGameCommand() {
        String gameCommand = Console.readLine().trim();
        try {
            return CommandValidator.validate(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getGameCommand();
        }
    }
}

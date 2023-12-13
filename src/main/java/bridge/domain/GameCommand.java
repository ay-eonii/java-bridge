package bridge.domain;


import bridge.view.constant.ExceptionMessage;

import java.util.Arrays;

public enum GameCommand {
    Q, R;
    public static GameCommand match(String input) {
        return Arrays.stream(values())
                .filter(command -> command.name().equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COMMAND));
    }
}

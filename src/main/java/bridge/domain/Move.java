package bridge.domain;

import bridge.view.constant.ExceptionMessage;

import java.util.Arrays;

public enum Move {
    U, D;
    public static Move match(String input) {
        return Arrays.stream(values())
                .filter(move -> move.name().equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_MOVE));
    }
}

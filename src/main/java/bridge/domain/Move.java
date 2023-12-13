package bridge.domain;

import bridge.view.constant.ExceptionMessage;

import java.util.Arrays;

public enum Move {
    U(1),
    D(0);

    private final int value;

    Move(int value) {
        this.value = value;
    }

    public static Move match(String input) {
        return Arrays.stream(values())
                .filter(move -> move.name().equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_MOVE));
    }

    public static Move match(int input) {
        return Arrays.stream(values())
                .filter(move -> move.value == input)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_MOVE));
    }
}

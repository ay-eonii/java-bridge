package bridge.validator;

import bridge.view.constant.ExceptionMessage;

import java.util.Arrays;

public class MoveValidator {

    public static String validate(String input) {
        return Move.match(input).name();
    }

    private enum Move {
        U, D;
        private static Move match(String input) {
            return Arrays.stream(values())
                    .filter(move -> move.name().equals(input))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_MOVE_SIZE));
        }
    }
}

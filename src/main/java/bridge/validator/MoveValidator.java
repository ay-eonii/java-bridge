package bridge.validator;

import bridge.domain.Move;

public class MoveValidator {

    public static String validate(String input) {
        return Move.match(input).name();
    }
}

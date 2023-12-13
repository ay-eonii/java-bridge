package bridge.validator;

import bridge.domain.GameCommand;

public class CommandValidator {
    public static String validate(String input) {
        return GameCommand.match(input).name();
    }
}

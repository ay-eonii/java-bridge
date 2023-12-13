package bridge.validator;

import bridge.view.constant.ExceptionMessage;

public class BridgeValidator {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    public static int validate(String input) {
        int size = convertToInteger(input);
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE);
        }
        return size;
    }

    private static int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE);
        }
    }
}

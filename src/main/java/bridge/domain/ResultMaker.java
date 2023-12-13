package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultMaker {
    private static final String BRIDGE_EDGE = "[ %s ]";
    private static final String BRIDGE_SEPARATE_SYMBOL = " | ";
    private static final String RESULT_TEMPLATE = "게임 성공 여부: %s\n총 시도한 횟수: %d";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static List<String> upBridge = new ArrayList<>();
    private static List<String> downBridge = new ArrayList<>();

    public static void initResult() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    public static String getResult(String moving, boolean isCorrect) {
        if (isCorrect) {
            markSuccessResult(moving);
        }
        if (!isCorrect) {
            markFailResult(moving);
        }
        return createResult();
    }

    public static String getResult(BridgeGame bridgeGame) {
        StringBuilder result = new StringBuilder();
        if (!bridgeGame.hasBridgeLeft()) {
            return result.append(createResult())
                    .append(System.lineSeparator())
                    .append(String.format(RESULT_TEMPLATE, SUCCESS, bridgeGame.getPlayCount()))
                    .toString();
        }
        return result.append(createResult())
                .append(System.lineSeparator())
                .append(String.format(RESULT_TEMPLATE, FAIL, bridgeGame.getPlayCount()))
                .toString();
    }

    private static String createResult() {
        StringBuilder result = new StringBuilder();
        String upResult = String.join(BRIDGE_SEPARATE_SYMBOL, upBridge);
        String downResult = String.join(BRIDGE_SEPARATE_SYMBOL, downBridge);

        return result.append(String.format(BRIDGE_EDGE, upResult))
                .append(System.lineSeparator())
                .append(String.format(BRIDGE_EDGE, downResult))
                .toString();
    }

    private static void markSuccessResult(String moving) {
        if (Move.U.name().equals(moving)) {
            upBridge.add("O");
            downBridge.add(" ");
        }
        if (Move.D.name().equals(moving)) {
            downBridge.add("O");
            upBridge.add(" ");
        }
    }

    private static void mark(String moving, boolean isCorrect) {
        if (Move.U.name().equals(moving)) {
            if (isCorrect) {
                upBridge.add("O");
            }
            if (!isCorrect) {
                upBridge.add("X");
            }
            downBridge.add(" ");
        }
        if (Move.D.name().equals(moving)) {
            if (isCorrect) {
                downBridge.add("O");
            }
            if (!isCorrect) {
                downBridge.add("X");
            }
            upBridge.add(" ");
        }
    }

    private static void markFailResult(String moving) {
        if (Move.U.name().equals(moving)) {
            upBridge.add("X");
            downBridge.add(" ");
        }
        if (Move.D.name().equals(moving)) {
            downBridge.add("X");
            upBridge.add(" ");
        }
    }
}

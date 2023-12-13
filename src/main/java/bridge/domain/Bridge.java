package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final BridgeMaker bridgeMaker;

    public Bridge(int size) {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public boolean isMovable(int location, String moving) {
        return bridge.get(location).equals(moving);
    }

    public boolean hasLeft(int location) {
        return location != bridge.size() - 1;
    }

    @Override
    public String toString() {
        return bridge.toString();
    }
}

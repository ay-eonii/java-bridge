package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final BridgeMaker bridgeMaker;

    public Bridge(int size) {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }
}

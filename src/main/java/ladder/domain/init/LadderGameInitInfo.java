package ladder.domain.init;

import ladder.util.ObjectUtil;

import java.util.List;
import java.util.Objects;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final List<String> names;

    private LadderGameInitInfo(final List<String> names, final int height) {
        ObjectUtil.checkNull(names, "Names are null");

        this.names = names;
        this.ladderInitInfo = LadderInitInfo.init(height, names.size());
    }

    public static LadderGameInitInfo init(final List<String> names, final int height) {
        return new LadderGameInitInfo(names, height);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public List<String> getNames() {
        return names;
    }
}

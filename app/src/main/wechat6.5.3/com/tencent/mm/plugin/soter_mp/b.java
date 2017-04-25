package com.tencent.mm.plugin.soter_mp;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class b implements ag {
    public final HashMap<Integer, c> ti() {
        v.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter getBaseDBFactories");
        return null;
    }

    public final void ed(int i) {
        v.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter clearPluginData");
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter onAccountPostReset");
    }

    public final void aH(boolean z) {
        v.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoterMp onSdcardMount");
    }

    public final void th() {
        v.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoterMp onAccountRelease");
    }
}

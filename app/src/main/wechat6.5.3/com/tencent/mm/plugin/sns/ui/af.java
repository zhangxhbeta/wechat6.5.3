package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class af {
    String fHQ = "";
    long jJu = 0;
    String jJv = "";
    int jJw = 0;
    long jne = 0;
    int position = 0;

    public final boolean aWl() {
        v.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[]{Long.valueOf(be.az(this.jJu))});
        v.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", new Object[]{Long.valueOf(this.jJu), this.fHQ, this.jJv, Long.valueOf(this.jne), Integer.valueOf(this.position), Integer.valueOf(this.jJw)});
        if (be.az(this.jJu) >= 180000 || this.position <= 0) {
            return false;
        }
        v.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[]{Long.valueOf(this.jne)});
        if (this.jne == 0) {
            return false;
        }
        ad.aSu().u(this.jne, -1);
        return true;
    }
}

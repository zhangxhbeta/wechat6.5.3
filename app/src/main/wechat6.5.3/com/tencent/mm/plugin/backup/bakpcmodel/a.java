package com.tencent.mm.plugin.backup.bakpcmodel;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public int csO;
    public int efJ;
    public int efK;
    private int efL;
    int efM;
    int efN;
    int efO;
    public int efP;

    private void reset() {
        this.efJ = 0;
        this.efK = 0;
        this.csO = 0;
        this.efL = 0;
        this.efM = 0;
        this.efN = 0;
        this.efO = 0;
        this.efP = 0;
    }

    public final void zR() {
        if (this.efJ == 0) {
            reset();
            return;
        }
        v.i("MicroMsg.BakPCReportor", "report: %s", String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.efJ), Integer.valueOf(this.efK), Integer.valueOf(this.csO), Integer.valueOf(this.efL), Integer.valueOf(this.efM), Integer.valueOf(this.efN), Integer.valueOf(this.efO), Integer.valueOf(this.efP)}));
        g.iuh.Y(11103, r0);
        reset();
    }
}

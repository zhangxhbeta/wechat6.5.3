package com.tencent.mm.plugin.ipcall.a.c;

import com.tencent.mm.sdk.platformtools.v;

public final class b {
    public String bfd = "";
    public String dwA = "";
    public int gFG = 0;
    public long gFH = 0;
    public int gFJ = 0;
    public int gGV = 0;
    public int gGW = 0;
    public int gGX = 0;
    public int gGY = 0;
    public int gGZ = 0;
    public long gHa = 0;
    public long gHb = 0;
    public int gHc = 0;
    public long gHd = 0;
    public int gHe = 0;
    public long gHf = 0;
    public int gHg = 0;
    public String gHh = "";
    public long gHi = 0;
    public long gHj = 0;
    public long gHk = 0;
    public long gHl = 0;
    public long gHm = 0;
    public String gHn = "";
    public String gHo = "";
    public String gHp = "";
    public long gHq = 0;
    public long gHr = 0;
    public long gHs = 0;
    public int gHt = 0;
    public int gHu = 0;
    public int gHv = 0;
    public int gHw = 0;

    public final void auI() {
        v.i("MicroMsg.IPCallReportHelper", "selfShutdown");
        this.gGZ = 1;
    }

    public final void auJ() {
        v.i("MicroMsg.IPCallReportHelper", "selfCancel");
        this.gGY = 1;
        if (this.gHs == 0 && this.gHi != 0) {
            this.gHs = System.currentTimeMillis() - this.gHi;
            v.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", new Object[]{Long.valueOf(this.gHs)});
        }
    }

    public final void auK() {
        v.i("MicroMsg.IPCallReportHelper", "channelConnect");
        this.gHc = 1;
    }

    public final void auL() {
        if (this.gHv == 0) {
            this.gHv = 1;
        }
    }

    public final void auM() {
        v.d("MicroMsg.IPCallReportHelper", "markConnect");
        if (this.gHq == 0) {
            this.gHq = System.currentTimeMillis();
            this.gHr = this.gHq - this.gHi;
            v.d("MicroMsg.IPCallReportHelper", "connectTime: %d", new Object[]{Long.valueOf(this.gHr)});
        }
    }

    public final void auN() {
        v.d("MicroMsg.IPCallReportHelper", "markStartTalk");
        if (this.gHl == 0) {
            this.gHl = System.currentTimeMillis();
        }
    }
}

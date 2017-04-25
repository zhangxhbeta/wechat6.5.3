package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class f extends a {
    private long gHW;
    public long gHX;
    public long gId = 0;
    public String gIe = "";
    public String gIf = "";
    public long gIg = 0;
    public long gIh = 0;
    public long gIi = 0;
    public String gIj = "";

    public final void start() {
        super.start();
        this.gHW = System.currentTimeMillis();
    }

    public final void reset() {
        this.gHW = 0;
        this.gHX = 0;
        this.gId = 0;
        this.gIe = "";
        this.gIf = "";
        this.gIg = 0;
        this.gIh = 0;
        this.gIi = 0;
        this.gIj = "";
    }

    protected final void auO() {
        g.iuh.h(12933, new Object[]{Long.valueOf(this.gHW), Long.valueOf(this.gHX), Long.valueOf(this.gId), this.gIe, this.gIf, Long.valueOf(this.gIg), Long.valueOf(this.gIh), Long.valueOf(this.gIi), this.gIj});
    }
}

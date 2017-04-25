package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class b extends a {
    private long gHW;
    public long gHX;
    public long gHY = 0;
    public long gHZ = 0;
    public long gIa = 0;

    public final void start() {
        super.start();
        this.gHW = System.currentTimeMillis();
    }

    public final void reset() {
        this.gHW = 0;
        this.gHX = 0;
        this.gHY = 0;
        this.gHZ = 0;
        this.gIa = 0;
    }

    protected final void auO() {
        g.iuh.h(12930, new Object[]{Long.valueOf(this.gHW), Long.valueOf(this.gHX), Long.valueOf(this.gHY), Long.valueOf(this.gHZ), Long.valueOf(this.gIa)});
    }
}

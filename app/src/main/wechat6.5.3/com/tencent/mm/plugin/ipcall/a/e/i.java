package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class i extends a {
    private long gHW;
    public long gHX;
    public long gIo = 0;
    public long gIp = 0;
    public long gIq = 0;

    public final void start() {
        super.start();
        this.gHW = System.currentTimeMillis();
    }

    public final void reset() {
        this.gHW = 0;
        this.gHX = 0;
        this.gIo = 0;
        this.gIp = 0;
        this.gIq = 0;
    }

    protected final void auO() {
        g.iuh.h(12934, new Object[]{Long.valueOf(this.gHW), Long.valueOf(this.gHX), Long.valueOf(this.gIo), Long.valueOf(this.gIp), Long.valueOf(this.gIq)});
    }
}

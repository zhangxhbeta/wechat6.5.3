package com.tencent.mm.plugin.ipcall.a.e;

public final class g extends a {
    private long gHW;
    public long gHX;
    private long gIk = 0;
    public long gIl = 0;
    public long gIm = 0;
    public long gIn = 0;

    public final void start() {
        super.start();
        this.gHW = System.currentTimeMillis();
    }

    public final void reset() {
        this.gHW = 0;
        this.gHX = 0;
        this.gIk = 0;
        this.gIl = 0;
        this.gIm = 0;
        this.gIn = 0;
    }

    protected final void auO() {
        com.tencent.mm.plugin.report.service.g.iuh.h(12931, new Object[]{Long.valueOf(this.gHW), Long.valueOf(this.gHX), Long.valueOf(this.gIk), Long.valueOf(this.gIl), Long.valueOf(this.gIm), Long.valueOf(this.gIn)});
    }
}

package com.tencent.mm.pluginsdk.k.a.b;

import java.io.IOException;

public final class b extends IOException {
    private final long bsM;
    private final long lEb;

    public b() {
        this(0, 0);
    }

    public b(long j, long j2) {
        super(String.format("contentLength: %d, requestRange:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        this.bsM = j;
        this.lEb = j2;
    }

    public final String toString() {
        return "FileSizeOutOfRangeException{contentLength=" + this.bsM + ", requestRange=" + this.lEb + '}';
    }
}

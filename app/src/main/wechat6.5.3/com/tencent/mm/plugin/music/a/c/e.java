package com.tencent.mm.plugin.music.a.c;

public final class e {
    public int hDC = 4;

    public final synchronized boolean aDl() {
        return this.hDC == 2;
    }

    public final synchronized boolean isPlaying() {
        return this.hDC == 3;
    }
}

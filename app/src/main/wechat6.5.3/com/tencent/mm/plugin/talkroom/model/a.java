package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.compatible.d.l;

public final class a {
    public static final int kjH;
    private static int kjU;

    static {
        int rx = l.rx();
        kjU = rx;
        kjH = (rx & 1024) != 0 ? 16000 : 8000;
    }
}

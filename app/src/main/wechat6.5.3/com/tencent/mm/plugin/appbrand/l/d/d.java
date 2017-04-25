package com.tencent.mm.plugin.appbrand.l.d;

import java.nio.ByteBuffer;

public interface d {

    public enum a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    boolean SA();

    boolean SB();

    a SC();

    ByteBuffer Sz();

    void e(d dVar);
}

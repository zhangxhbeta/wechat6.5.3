package com.tencent.mm.memory;

import com.tencent.mm.sdk.b;
import com.tencent.mm.sdk.i.e;
import java.nio.ByteBuffer;

public final class h extends b<ByteBuffer> {
    public static h cnw = new h();

    static /* synthetic */ void a(h hVar, Object obj) {
        if (hVar.vN != null && hVar.vO < hVar.vN.length) {
            hVar.vN[hVar.vO] = obj;
            hVar.vO++;
        }
    }

    static {
        e.a(new Runnable() {
            public final void run() {
                for (int i = 0; i < 10; i++) {
                    h.a(h.cnw, ByteBuffer.allocate(16384));
                }
            }
        }, "DecodeTempStorage_preload");
    }

    private h() {
    }
}

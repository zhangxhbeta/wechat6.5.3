package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.model.c;

public final class u {
    private static u fxw = null;
    private c fxx;
    private f fxy;

    private static u ajU() {
        if (fxw == null) {
            fxw = new u();
        }
        return fxw;
    }

    public static f ajV() {
        if (ajU().fxy == null) {
            ajU().fxy = new f();
        }
        return ajU().fxy;
    }

    public static void a(m mVar) {
        ajW().frL = mVar;
    }

    public static c ajW() {
        if (ajU().fxx == null) {
            u ajU = ajU();
            if (c.frK == null) {
                c.frK = new c();
            }
            ajU.fxx = c.frK;
        }
        return ajU().fxx;
    }
}

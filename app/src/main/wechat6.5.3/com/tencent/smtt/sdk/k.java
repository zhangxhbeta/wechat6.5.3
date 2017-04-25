package com.tencent.smtt.sdk;

import android.os.HandlerThread;

final class k extends HandlerThread {
    private static k pwq;

    private k(String str) {
        super(str);
    }

    public static synchronized k bNl() {
        k kVar;
        synchronized (k.class) {
            if (pwq == null) {
                kVar = new k("TbsHandlerThread");
                pwq = kVar;
                kVar.start();
            }
            kVar = pwq;
        }
        return kVar;
    }
}

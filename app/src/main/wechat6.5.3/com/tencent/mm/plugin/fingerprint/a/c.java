package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.v;

public final class c {
    public static boolean anp() {
        boolean ant = a.lxX.ant();
        v.i("MicroMsg.FingerPrintAuthMgr", "isSupportFP is " + ant);
        return ant;
    }

    public static int a(b bVar, boolean z) {
        return a.lxX.a(bVar, 0, z);
    }

    public static void release() {
        a.lxX.any();
    }

    public static void abort() {
        a.lxX.anz();
    }

    public static void anq() {
        a.lxX.anq();
    }

    public static boolean anr() {
        return a.lxX.anu();
    }

    public static g ans() {
        return a.lxX.ans();
    }
}

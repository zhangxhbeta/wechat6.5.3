package com.tencent.mm.pluginsdk.l;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Looper;
import com.tencent.mm.e.a.gt;
import com.tencent.mm.e.a.oo;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

public final class f {
    public static void a(Context context, final d dVar) {
        v.i("MicroMsg.SoterProcessManager", "hy: starting gen ask");
        final b ooVar = new oo();
        ooVar.bpQ.context = context;
        ooVar.bpQ.bpS = new h();
        ooVar.bpQ.bpT = new Runnable() {
            public final void run() {
                int i = ooVar.bpR.errCode;
                String str = ooVar.bpR.biS;
                if (dVar != null) {
                    dVar.h(i, str, null);
                }
            }
        };
        a.nhr.z(ooVar);
    }

    public static void a(Context context, boolean z, final d dVar, e eVar) {
        v.i("MicroMsg.SoterProcessManager", "start upload ASK");
        final b ooVar = new oo();
        ooVar.bpQ.context = context;
        ooVar.bpQ.bpS = new j(z);
        ((j) ooVar.bpQ.bpS).cii = eVar;
        ooVar.bpT = new Runnable() {
            public final void run() {
                int i = ooVar.bpR.errCode;
                String str = ooVar.bpR.biS;
                if (dVar != null) {
                    dVar.h(i, str, null);
                }
            }
        };
        a.nhr.a(ooVar, Looper.getMainLooper());
    }

    public static void a(Context context, String str, final d dVar, boolean z) {
        v.i("MicroMsg.SoterProcessManager", "starting gen auth key: %s, isAutoGenASKWhenNone: %b", str, Boolean.valueOf(z));
        final b ooVar = new oo();
        ooVar.bpQ.context = context;
        c iVar = new i();
        iVar.bgo = str;
        iVar.lES = z;
        ooVar.bpQ.bpS = iVar;
        ooVar.bpQ.bpT = new Runnable() {
            public final void run() {
                v.i("MicroMsg.SoterProcessManager", "event call back run");
                int i = ooVar.bpR.errCode;
                String str = ooVar.bpR.biS;
                if (dVar != null) {
                    dVar.h(i, str, null);
                }
            }
        };
        a.nhr.z(ooVar);
    }

    public static void a(Context context, String str, String str2, final d dVar, b bVar, CancellationSignal cancellationSignal) {
        v.i("MicroMsg.SoterProcessManager", "starting authentication");
        final b ooVar = new oo();
        ooVar.bpQ.context = context;
        ooVar.bpQ.bpS = new g(str, str2);
        ((g) ooVar.bpQ.bpS).lER = bVar;
        ((g) ooVar.bpQ.bpS).kdv = cancellationSignal;
        ((g) ooVar.bpQ.bpS).kdw = -1;
        ooVar.bpT = new Runnable() {
            public final void run() {
                int i = ooVar.bpR.errCode;
                String str = ooVar.bpR.biS;
                String str2 = ooVar.bpR.bpU;
                if (dVar != null) {
                    dVar.h(i, str, str2);
                }
            }
        };
        a.nhr.a(ooVar, Looper.getMainLooper());
    }

    public static String aQ(Context context, String str) {
        b gtVar = new gt();
        gtVar.bgm.context = context;
        gtVar.bgm.bgo = str;
        a.nhr.z(gtVar);
        return gtVar.bgn.bgp;
    }
}

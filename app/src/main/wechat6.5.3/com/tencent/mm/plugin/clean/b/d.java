package com.tencent.mm.plugin.clean.b;

import com.tencent.mm.plugin.clean.b.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class d {
    private static final ac eUB = new ac();
    private static int eUC = 0;
    private static b eUr;
    private static long eUx = 0;
    private static long eUy = 0;
    private static ArrayList<b> eaw;

    public static void a(b bVar) {
        eUr = bVar;
    }

    public static b adN() {
        boolean z = true;
        String str = "MicroMsg.CleanLogic";
        String str2 = "getThreadController threadController is null? %b";
        Object[] objArr = new Object[1];
        if (eUr != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.d(str, str2, objArr);
        return eUr;
    }

    public static void s(ArrayList<b> arrayList) {
        boolean z = true;
        String str = "MicroMsg.CleanLogic";
        String str2 = "set analyse data: is null? %b";
        Object[] objArr = new Object[1];
        if (arrayList != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        eaw = arrayList;
    }

    public static ArrayList<b> Tu() {
        return eaw;
    }

    public static void aP(long j) {
        eUy = j;
    }

    public static long adO() {
        return eUy;
    }

    public static void aQ(long j) {
        eUx = j;
    }

    public static long adP() {
        return eUx;
    }

    public static final void adQ() {
        v.i("MicroMsg.CleanLogic", "startCleanDataNow");
        eUB.removeCallbacksAndMessages(null);
        eUy = 0;
        eUx = 0;
        s(null);
        eUC = 0;
    }

    public static final void adR() {
        v.i("MicroMsg.CleanLogic", "start to post clean runnable!!");
        eUB.removeCallbacksAndMessages(null);
        eUB.postDelayed(new Runnable() {
            public final void run() {
                if (d.eUC == 0) {
                    v.i("MicroMsg.CleanLogic", "clean data");
                    d.aP(0);
                    d.s(null);
                    return;
                }
                v.i("MicroMsg.CleanLogic", "clean data is using");
            }
        }, 300000);
    }

    public static final void adS() {
        eUC++;
    }

    public static final void adT() {
        eUC--;
    }
}

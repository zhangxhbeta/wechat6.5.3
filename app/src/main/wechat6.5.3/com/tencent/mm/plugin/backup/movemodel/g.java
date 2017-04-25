package com.tencent.mm.plugin.backup.movemodel;

import com.tencent.mm.plugin.backup.movemodel.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class g implements c {
    private static ArrayList<a> eaA = null;
    private static ArrayList<a> eaw = new ArrayList();
    private static boolean eay = false;
    private static List<String> efQ = null;
    public b egg;
    public c ekX;
    public ah ekY;
    public Object lock = new Object();

    public static ArrayList<a> Tu() {
        return eaw;
    }

    public static void Y(List<String> list) {
        efQ = list;
    }

    public static List<String> Wi() {
        return efQ;
    }

    public static void q(ArrayList<a> arrayList) {
        eaA = arrayList;
    }

    public static ArrayList<a> Wj() {
        return eaA;
    }

    public static boolean Wk() {
        return eay;
    }

    public final void a(long j, long j2, ArrayList<a> arrayList, boolean z) {
        v.i("MicroMsg.BakMoveChooseServer", "onCalcuChooseProgress progress:%d, converSize%d", Long.valueOf(j), Long.valueOf(j2));
        if (z) {
            eaw = (ArrayList) arrayList.clone();
        }
        if (this.ekX != null) {
            this.ekX.a(j, j2, arrayList, z);
        }
    }

    public final void p(ArrayList<a> arrayList) {
        Collections.sort(arrayList);
        eaw = (ArrayList) arrayList.clone();
        eay = true;
        if (this.ekX != null) {
            this.ekX.p(arrayList);
        }
    }
}

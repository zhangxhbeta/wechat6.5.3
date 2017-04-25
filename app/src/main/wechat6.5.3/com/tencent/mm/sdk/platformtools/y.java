package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class y {
    public static b bXz;
    private static int niq;
    public static Map<Integer, y> niu = new HashMap();
    private static boolean niw = false;
    public static boolean nix;
    public long kCe = 0;
    public final int nir;
    private final boolean nis;
    public long nit = 0;
    private final a niv;

    public interface a {
        boolean oU();
    }

    public interface b {
        void cancel();

        void prepare();
    }

    public static void a(b bVar) {
        niw = true;
        bXz = bVar;
    }

    protected final void finalize() {
        QI();
        super.finalize();
    }

    public y(a aVar) {
        Assert.assertTrue("bumper not initialized", niw);
        this.niv = aVar;
        this.nis = true;
        if (niq >= 8192) {
            niq = 0;
        }
        int i = niq + 1;
        niq = i;
        this.nir = i;
    }

    public static long btd() {
        nix = false;
        List linkedList = new LinkedList();
        Set<Integer> hashSet = new HashSet();
        hashSet.addAll(niu.keySet());
        long j = Long.MAX_VALUE;
        for (Integer num : hashSet) {
            long j2;
            y yVar = (y) niu.get(num);
            if (yVar != null) {
                long az = be.az(yVar.nit);
                if (az < 0) {
                    az = 0;
                }
                if (az > yVar.kCe) {
                    if (yVar.niv.oU() && yVar.nis) {
                        j = yVar.kCe;
                    } else {
                        linkedList.add(num);
                    }
                    yVar.nit = be.Nj();
                } else if (yVar.kCe - az < j) {
                    j2 = yVar.kCe - az;
                    j = j2;
                }
            }
            j2 = j;
            j = j2;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            niu.remove(linkedList.get(i));
        }
        if (!(nix || j != Long.MAX_VALUE || bXz == null)) {
            bXz.cancel();
            v.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
        }
        return j;
    }

    public final void QI() {
        niu.remove(Integer.valueOf(this.nir));
    }

    public static boolean dZ(long j) {
        v.d("MicroMsg.MAlarmHandler", "check need prepare: check=" + j);
        long j2 = Long.MAX_VALUE;
        for (Entry value : niu.entrySet()) {
            long j3;
            y yVar = (y) value.getValue();
            if (yVar != null) {
                long az = be.az(yVar.nit);
                if (az < 0) {
                    az = 0;
                }
                if (az > yVar.kCe) {
                    j2 = yVar.kCe;
                } else if (yVar.kCe - az < j2) {
                    j3 = yVar.kCe - az;
                    j2 = j3;
                }
            }
            j3 = j2;
            j2 = j3;
        }
        return j2 > j;
    }
}

package com.tencent.mm.performance.wxperformancetool;

import com.tencent.mm.performance.c.b;
import com.tencent.mm.performance.d.a;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class c {
    HashSet<a> doj = new HashSet();
    public b dok;

    public final boolean MN() {
        boolean lP = lP(com.tencent.mm.performance.a.a.TYPE);
        boolean z;
        if (lP) {
            z = false;
        } else {
            com.tencent.mm.performance.a.a aVar = new com.tencent.mm.performance.a.a();
            z = aVar.MJ();
            if (z) {
                aVar.dnu = new HashSet();
                this.doj.add(aVar);
            }
        }
        if (lP || r1) {
            return true;
        }
        return false;
    }

    public final void a(com.tencent.mm.performance.a.a.a aVar) {
        if (lP(com.tencent.mm.performance.a.a.TYPE)) {
            ((com.tencent.mm.performance.a.a) lQ(com.tencent.mm.performance.a.a.TYPE)).a(aVar);
            return;
        }
        throw new IllegalArgumentException("registerActivityLifeCycleCallback, you must set monitor activity lifecycle first");
    }

    public final boolean MO() {
        if (lP(b.TYPE)) {
            return false;
        }
        if (lP(com.tencent.mm.performance.a.a.TYPE)) {
            b bVar = new b();
            bVar.dnD = new HashSet();
            bVar.dnJ = new HashSet();
            bVar.dnI = new HashMap();
            if (com.tencent.mm.performance.c.a.isEnabled()) {
                com.tencent.mm.performance.c.a.bh(aa.getContext());
            }
            a(new b());
            this.doj.add(bVar);
            return true;
        }
        throw new IllegalArgumentException("setMonitorMemoryLeak, you should setMonitorActivityLifeCycle first(and return true)");
    }

    public final void a(com.tencent.mm.performance.c.b.c cVar) {
        if (lP(b.TYPE)) {
            b bVar = (b) lQ(b.TYPE);
            synchronized (bVar.dnD) {
                bVar.dnD.add(cVar);
            }
            return;
        }
        throw new IllegalArgumentException("registerMemoryLeakCallback, you must set monitor memoryleak first");
    }

    public final boolean MP() {
        int i = 0;
        boolean lP = lP(com.tencent.mm.performance.b.a.TYPE);
        if (!lP) {
            boolean z;
            com.tencent.mm.performance.b.a aVar = new com.tencent.mm.performance.b.a();
            aVar.dnT = 60000;
            aVar.dnz = 50;
            aVar.dnA = 70;
            aVar.dnB = 90;
            if (aVar.dny > 0) {
                z = true;
            }
            aVar.dnC = z;
            i = aVar.dnC;
            if (i != 0) {
                aVar.dnD = new HashSet();
                this.doj.add(aVar);
            }
        }
        return i | lP;
    }

    public final void a(com.tencent.mm.performance.b.a.a aVar) {
        if (lP(com.tencent.mm.performance.b.a.TYPE)) {
            com.tencent.mm.performance.b.a aVar2 = (com.tencent.mm.performance.b.a) lQ(com.tencent.mm.performance.b.a.TYPE);
            synchronized (aVar2.dnD) {
                aVar2.dnD.add(aVar);
            }
            return;
        }
        throw new IllegalArgumentException("registerMemoryAlarmCallback, you must set monitor memoryleak first");
    }

    public final void lO(String str) {
        a lQ = lQ(str);
        if (lQ != null) {
            lQ.dnT = 10000;
            return;
        }
        throw new IllegalArgumentException("setTypeMointorInterval, " + str + " is not opened");
    }

    private boolean lP(String str) {
        if (this.doj.isEmpty()) {
            return false;
        }
        Iterator it = this.doj.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).MK().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private a lQ(String str) {
        if (this.doj.isEmpty()) {
            return null;
        }
        Iterator it = this.doj.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.MK().equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}

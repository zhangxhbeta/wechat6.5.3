package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.g.d;
import com.tencent.mm.plugin.sns.g.e;
import com.tencent.mm.plugin.sns.g.f;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class aa {
    String bYE = "";
    private d jln;
    private List<Integer> jlo = new Vector();
    private Map<String, Integer> jlp = new HashMap();
    private List<Integer> jlq = new Vector();
    private Map<Integer, Integer> jlr = new HashMap();
    private String path;

    public static boolean Ao(String str) {
        if (str != null && str.startsWith("_AD_TAG_")) {
            return true;
        }
        return false;
    }

    public aa(String str) {
        this.path = str;
        if (!aSh()) {
            this.jln = new d();
        }
        this.jlo.clear();
        this.jlp.clear();
    }

    public final synchronized void aSf() {
        if (!X(this.jln.jqq)) {
            if (!X(this.jln.jqr) && !X(this.jln.jqs) && !X(this.jln.jqt)) {
                f fVar;
                while (!this.jln.jqu.isEmpty()) {
                    fVar = (f) this.jln.jqu.getFirst();
                    if (be.ax((long) fVar.jqx) <= 21600) {
                        ak.vy().a(new p(fVar.jqz, 1), 0);
                        break;
                    }
                    this.jln.jqu.removeFirst();
                }
                while (!this.jln.jqv.isEmpty()) {
                    fVar = (f) this.jln.jqv.getFirst();
                    if (be.ax((long) fVar.jqx) <= 21600) {
                        ak.vy().a(new p(fVar.jqz, 5), 0);
                        break;
                    }
                    this.jln.jqv.removeFirst();
                }
            }
        }
    }

    private static boolean X(LinkedList<e> linkedList) {
        while (!linkedList.isEmpty()) {
            e eVar = (e) linkedList.getFirst();
            if (be.ax((long) eVar.jqx) > 21600) {
                linkedList.removeFirst();
            } else {
                if (Ao(eVar.jqw)) {
                    ak.vy().a(new j(eVar.jjS, eVar.jqw, eVar.jqy), 0);
                } else {
                    ak.vy().a(new m(eVar.jjS, eVar.jqw), 0);
                }
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean cO(long j) {
        boolean z;
        Iterator it = this.jln.jqu.iterator();
        while (it.hasNext()) {
            if (((f) it.next()).jqz == j) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public final synchronized void cP(long j) {
        f fVar = new f();
        fVar.jqz = j;
        fVar.jqx = (int) be.Nh();
        this.jln.jqu.add(fVar);
        aSg();
    }

    final synchronized void cQ(long j) {
        Object obj;
        Iterator it = this.jln.jqu.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.jqz == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.jln.jqu.remove(obj);
        }
        aSg();
    }

    private static boolean a(LinkedList<avr> linkedList, String str, int i) {
        if (be.kS(str)) {
            return true;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            avr com_tencent_mm_protocal_c_avr = (avr) it.next();
            if (str.equals(com_tencent_mm_protocal_c_avr.hQP) && i == com_tencent_mm_protocal_c_avr.hNS) {
                return true;
            }
        }
        return false;
    }

    public final synchronized awa c(awa com_tencent_mm_protocal_c_awa) {
        if (be.kS(this.bYE)) {
            this.bYE = k.xF();
        }
        if (!(this.jln.jqq.size() == 0 && this.jln.jqr.size() == 0)) {
            e eVar;
            avr com_tencent_mm_protocal_c_avr;
            long j = com_tencent_mm_protocal_c_awa.mjq;
            Iterator it = this.jln.jqq.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                avr a = a(eVar.jjS);
                if (eVar.jjS.mjq == j && !a(com_tencent_mm_protocal_c_awa.mTk, a.hQP, a.hNS)) {
                    com_tencent_mm_protocal_c_awa.mTk.add(a);
                    com_tencent_mm_protocal_c_awa.mTi++;
                }
            }
            Iterator it2 = com_tencent_mm_protocal_c_awa.mTk.iterator();
            while (it2.hasNext()) {
                com_tencent_mm_protocal_c_avr = (avr) it2.next();
                if (com_tencent_mm_protocal_c_avr.mdw.equals(this.bYE)) {
                    Object obj = null;
                    Iterator it3 = this.jln.jqv.iterator();
                    while (it3.hasNext()) {
                        Object obj2;
                        if (((f) it3.next()).jqz == j) {
                            com_tencent_mm_protocal_c_awa.mTk.remove(com_tencent_mm_protocal_c_avr);
                            com_tencent_mm_protocal_c_awa.mTi--;
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        break;
                    }
                }
            }
            it = this.jln.jqr.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                if (eVar.jjS.mjq == j) {
                    com_tencent_mm_protocal_c_avr = a(eVar.jjS);
                    if (!a(com_tencent_mm_protocal_c_awa.mTn, com_tencent_mm_protocal_c_avr.hQP, com_tencent_mm_protocal_c_avr.hNS)) {
                        com_tencent_mm_protocal_c_awa.mTn.add(com_tencent_mm_protocal_c_avr);
                        com_tencent_mm_protocal_c_awa.mTl++;
                    }
                }
            }
        }
        return com_tencent_mm_protocal_c_awa;
    }

    public static avr a(avn com_tencent_mm_protocal_c_avn) {
        avm com_tencent_mm_protocal_c_avm = com_tencent_mm_protocal_c_avn.mST;
        avm com_tencent_mm_protocal_c_avm2 = com_tencent_mm_protocal_c_avn.mSU;
        avr com_tencent_mm_protocal_c_avr = new avr();
        com_tencent_mm_protocal_c_avr.hQP = com_tencent_mm_protocal_c_avm.hQP;
        com_tencent_mm_protocal_c_avr.hNS = com_tencent_mm_protocal_c_avm.hNS;
        com_tencent_mm_protocal_c_avr.mGq = com_tencent_mm_protocal_c_avm.mSK;
        com_tencent_mm_protocal_c_avr.mcP = com_tencent_mm_protocal_c_avm.mcP;
        com_tencent_mm_protocal_c_avr.efm = com_tencent_mm_protocal_c_avm.efm;
        com_tencent_mm_protocal_c_avr.mdw = com_tencent_mm_protocal_c_avm.mOk;
        com_tencent_mm_protocal_c_avr.mSN = com_tencent_mm_protocal_c_avm.mSN;
        com_tencent_mm_protocal_c_avr.mSQ = com_tencent_mm_protocal_c_avm.mSQ;
        com_tencent_mm_protocal_c_avr.mTc = com_tencent_mm_protocal_c_avm2.mOk;
        com_tencent_mm_protocal_c_avr.mSP = com_tencent_mm_protocal_c_avm2.mSP;
        com_tencent_mm_protocal_c_avr.mSM = com_tencent_mm_protocal_c_avm2.mSM;
        return com_tencent_mm_protocal_c_avr;
    }

    public final boolean a(String str, avn com_tencent_mm_protocal_c_avn) {
        return a(str, com_tencent_mm_protocal_c_avn, "");
    }

    public final synchronized boolean a(String str, avn com_tencent_mm_protocal_c_avn, String str2) {
        boolean z = true;
        synchronized (this) {
            e eVar = new e();
            eVar.jqw = str;
            eVar.jjS = com_tencent_mm_protocal_c_avn;
            eVar.jqx = (int) be.Nh();
            eVar.jqy = str2;
            switch (com_tencent_mm_protocal_c_avn.mST.efm) {
                case 1:
                    this.jln.jqq.add(eVar);
                    if (cS(com_tencent_mm_protocal_c_avn.mjq)) {
                        z = false;
                        break;
                    }
                    break;
                case 2:
                    this.jln.jqr.add(eVar);
                    break;
                case 3:
                    this.jln.jqs.add(eVar);
                    break;
                case 5:
                    this.jln.jqt.add(eVar);
                    break;
                case 7:
                    this.jln.jqq.add(eVar);
                    if (cS(com_tencent_mm_protocal_c_avn.mjq)) {
                        z = false;
                        break;
                    }
                    break;
                case 8:
                    this.jln.jqr.add(eVar);
                    break;
            }
            if (!aSg()) {
                v.e("MicroMsg.SnsAsyncQueueMgr", "error listToFile");
            }
        }
        return z;
    }

    public final void c(long j, int i, String str) {
        ah.aSU();
        d(j, i, str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void d(long r2, int r4, java.lang.String r5) {
        /*
        r1 = this;
        monitor-enter(r1);
        switch(r4) {
            case 1: goto L_0x0009;
            case 2: goto L_0x0014;
            case 3: goto L_0x002c;
            case 4: goto L_0x0004;
            case 5: goto L_0x0034;
            case 6: goto L_0x0004;
            case 7: goto L_0x001c;
            case 8: goto L_0x0024;
            default: goto L_0x0004;
        };
    L_0x0004:
        r1.aSg();	 Catch:{ all -> 0x0011 }
        monitor-exit(r1);
        return;
    L_0x0009:
        r0 = r1.jln;	 Catch:{ all -> 0x0011 }
        r0 = r0.jqq;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0011:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0014:
        r0 = r1.jln;	 Catch:{ all -> 0x0011 }
        r0 = r0.jqr;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x001c:
        r0 = r1.jln;	 Catch:{ all -> 0x0011 }
        r0 = r0.jqq;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0024:
        r0 = r1.jln;	 Catch:{ all -> 0x0011 }
        r0 = r0.jqr;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x002c:
        r0 = r1.jln;	 Catch:{ all -> 0x0011 }
        r0 = r0.jqs;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
    L_0x0034:
        r0 = r1.jln;	 Catch:{ all -> 0x0011 }
        r0 = r0.jqt;	 Catch:{ all -> 0x0011 }
        a(r2, r0, r5);	 Catch:{ all -> 0x0011 }
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.e.aa.d(long, int, java.lang.String):void");
    }

    private static void a(long j, LinkedList<e> linkedList, String str) {
        a(j, linkedList, str, false);
    }

    private static boolean a(long j, LinkedList<e> linkedList, String str, boolean z) {
        Object obj;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            obj = (e) it.next();
            if (obj.jjS.mjq == j && (z || obj.jqw.equals(str))) {
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return false;
        }
        linkedList.remove(obj);
        return true;
    }

    public final synchronized boolean cR(long j) {
        boolean z = true;
        synchronized (this) {
            f fVar = new f();
            fVar.jqz = j;
            fVar.jqx = (int) be.Nh();
            this.jln.jqv.add(fVar);
            aSg();
            if (a(j, this.jln.jqq, "", true)) {
                z = false;
            }
        }
        return z;
    }

    final synchronized boolean cS(long j) {
        boolean z;
        Object obj;
        Iterator it = this.jln.jqv.iterator();
        while (it.hasNext()) {
            obj = (f) it.next();
            if (obj.jqz == j) {
                break;
            }
        }
        obj = null;
        if (obj != null) {
            this.jln.jqv.remove(obj);
            z = true;
        } else {
            z = false;
        }
        aSg();
        return z;
    }

    private synchronized boolean aSg() {
        boolean z = false;
        synchronized (this) {
            try {
                byte[] toByteArray = this.jln.toByteArray();
                if (FileOp.b(this.path, toByteArray, toByteArray.length) == 0) {
                    z = true;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.SnsAsyncQueueMgr", e, "listToFile failed: " + this.path, new Object[0]);
                FileOp.deleteFile(this.path);
            }
        }
        return z;
    }

    private synchronized boolean aSh() {
        boolean z;
        byte[] c = FileOp.c(this.path, 0, -1);
        if (c == null) {
            z = false;
        } else {
            try {
                this.jln = (d) new d().az(c);
                z = true;
            } catch (Throwable e) {
                v.a("MicroMsg.SnsAsyncQueueMgr", e, "", new Object[0]);
                FileOp.deleteFile(this.path);
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean pY(int i) {
        return this.jlo.contains(Integer.valueOf(i));
    }

    public final synchronized boolean pZ(int i) {
        boolean z;
        if (this.jlo.contains(Integer.valueOf(i))) {
            z = false;
        } else {
            this.jlo.add(Integer.valueOf(i));
            z = true;
        }
        return z;
    }

    public final synchronized boolean qa(int i) {
        this.jlo.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized boolean Ap(String str) {
        return this.jlp.containsKey(str);
    }

    public final synchronized boolean Aq(String str) {
        boolean z = false;
        synchronized (this) {
            if (!this.jlp.containsKey(str)) {
                this.jlp.put(str, Integer.valueOf(0));
                z = true;
            }
        }
        return z;
    }

    public final synchronized boolean Ar(String str) {
        this.jlp.remove(str);
        return true;
    }

    public final synchronized int aSi() {
        return this.jlp.size();
    }

    public final synchronized boolean qb(int i) {
        boolean z;
        if (this.jlq.contains(Integer.valueOf(i))) {
            z = false;
        } else {
            this.jlq.add(Integer.valueOf(i));
            z = true;
        }
        return z;
    }

    public final synchronized boolean qc(int i) {
        this.jlq.remove(Integer.valueOf(i));
        this.jlr.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized boolean cr(int i, int i2) {
        this.jlr.put(Integer.valueOf(i), Integer.valueOf(i2));
        return true;
    }

    public final synchronized boolean qd(int i) {
        this.jlr.remove(Integer.valueOf(i));
        return true;
    }

    public final synchronized int qe(int i) {
        int intValue;
        if (this.jlr.containsKey(Integer.valueOf(i))) {
            intValue = ((Integer) this.jlr.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        return intValue;
    }
}

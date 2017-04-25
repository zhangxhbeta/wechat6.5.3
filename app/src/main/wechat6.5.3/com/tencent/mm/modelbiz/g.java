package com.tencent.mm.modelbiz;

import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.bit;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.u.i;
import com.tencent.mm.u.n;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class g implements e {
    Object cCN = new Object();
    Set<String> cCO = new HashSet();
    public LinkedList<a> cCP = new LinkedList();

    public interface a {
        String Dq();

        void d(LinkedList<bit> linkedList);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.modelbiz.g.a r7) {
        /*
        r6 = this;
        r1 = r6.cCN;
        monitor-enter(r1);
        r0 = r6.cCP;	 Catch:{ all -> 0x0053 }
        r0 = r0.contains(r7);	 Catch:{ all -> 0x0053 }
        if (r0 != 0) goto L_0x0051;
    L_0x000b:
        r0 = r6.cCP;	 Catch:{ all -> 0x0053 }
        r2 = r0.iterator();	 Catch:{ all -> 0x0053 }
    L_0x0011:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x004c;
    L_0x0017:
        r0 = r2.next();	 Catch:{ all -> 0x0053 }
        r0 = (com.tencent.mm.modelbiz.g.a) r0;	 Catch:{ all -> 0x0053 }
        if (r7 == 0) goto L_0x0011;
    L_0x001f:
        if (r0 == 0) goto L_0x0011;
    L_0x0021:
        r3 = r7.Dq();	 Catch:{ all -> 0x0053 }
        r3 = com.tencent.mm.sdk.platformtools.be.ma(r3);	 Catch:{ all -> 0x0053 }
        r0 = r0.Dq();	 Catch:{ all -> 0x0053 }
        r0 = com.tencent.mm.sdk.platformtools.be.ma(r0);	 Catch:{ all -> 0x0053 }
        r0 = r3.equals(r0);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0011;
    L_0x0037:
        r0 = "MicroMsg.BizKFService";
        r2 = "the same callbacker %s, return";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0053 }
        r4 = 0;
        r5 = r7.Dq();	 Catch:{ all -> 0x0053 }
        r3[r4] = r5;	 Catch:{ all -> 0x0053 }
        com.tencent.mm.sdk.platformtools.v.i(r0, r2, r3);	 Catch:{ all -> 0x0053 }
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
    L_0x004b:
        return;
    L_0x004c:
        r0 = r6.cCP;	 Catch:{ all -> 0x0053 }
        r0.add(r7);	 Catch:{ all -> 0x0053 }
    L_0x0051:
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
        goto L_0x004b;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0053 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.g.a(com.tencent.mm.modelbiz.g$a):void");
    }

    public final void b(a aVar) {
        synchronized (this.cCN) {
            if (this.cCP.contains(aVar)) {
                this.cCP.remove(aVar);
            }
        }
    }

    public final void R(String str, String str2) {
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.BizKFService", "doKFGetDefaultList error args, %s, %s", str, str2);
        } else if (this.cCO.contains(str2)) {
            v.i("MicroMsg.BizKFService", "doKFGetInfoList: same is running, %s", str2);
        } else {
            this.cCO.add(str2);
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            k sVar = new s(str, linkedList);
            sVar.tag = str2;
            ak.vy().a(sVar, 0);
            v.i("MicroMsg.BizKFService", "doKFGetInfoList %s, %s, %d", str, str2, Integer.valueOf(this.cCP.size()));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.BizKFService", "onSceneEnd errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar == null) {
            v.e("MicroMsg.BizKFService", "scene == null");
            c(null);
        } else if (i == 0 && i2 == 0) {
            v.i("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(kVar.getType()));
            i Bo = n.Bo();
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = null;
            long currentTimeMillis = System.currentTimeMillis();
            LinkedList linkedList3;
            Iterator it;
            bit com_tencent_mm_protocal_c_bit;
            h hVar;
            if (kVar.getType() == 672) {
                if (((r) kVar).Du() == null) {
                    v.e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(kVar.getType()));
                    c(null);
                    return;
                }
                linkedList3 = ((r) kVar).Du().mFb;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    v.e("MicroMsg.BizKFService", "empty workers");
                    c(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bit = (bit) it.next();
                    linkedList.add(new f(com_tencent_mm_protocal_c_bit.ndl, ((r) kVar).cDf, com_tencent_mm_protocal_c_bit.muL, com_tencent_mm_protocal_c_bit.mGq, 1, currentTimeMillis));
                    if (Bo != null) {
                        hVar = new h();
                        hVar.username = com_tencent_mm_protocal_c_bit.ndl;
                        hVar.cyC = com_tencent_mm_protocal_c_bit.muL;
                        hVar.aP(false);
                        hVar.bBY = 3;
                        Bo.a(hVar);
                        n.Bq().gE(com_tencent_mm_protocal_c_bit.ndl);
                    }
                }
                linkedList2 = linkedList3;
            } else if (kVar.getType() == 675) {
                this.cCO.remove(((s) kVar).tag);
                if (((s) kVar).Dv() == null) {
                    v.e("MicroMsg.BizKFService", "KFGetInfoList resp is null, type = %s", Integer.valueOf(kVar.getType()));
                    c(null);
                    return;
                }
                linkedList3 = ((s) kVar).Dv().mFb;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    v.e("MicroMsg.BizKFService", "empty workers");
                    c(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bit = (bit) it.next();
                    v.i("MicroMsg.BizKFService", "onScenEnd: workers=%s, tag=%s", com_tencent_mm_protocal_c_bit.ndl, ((s) kVar).tag);
                    linkedList.add(new f(com_tencent_mm_protocal_c_bit.ndl, ((s) kVar).cDf, com_tencent_mm_protocal_c_bit.muL, com_tencent_mm_protocal_c_bit.mGq, ((s) kVar).cDg, currentTimeMillis));
                    if (Bo != null) {
                        hVar = new h();
                        hVar.username = com_tencent_mm_protocal_c_bit.ndl;
                        hVar.cyC = com_tencent_mm_protocal_c_bit.muL;
                        hVar.aP(false);
                        hVar.bBY = 3;
                        Bo.a(hVar);
                        n.Bq().gE(com_tencent_mm_protocal_c_bit.ndl);
                    }
                }
                linkedList2 = linkedList3;
            } else if (kVar.getType() == 674) {
                if (((q) kVar).Dt() == null) {
                    v.e("MicroMsg.BizKFService", "resp is null, type = %s", Integer.valueOf(kVar.getType()));
                    c(null);
                    return;
                }
                linkedList3 = ((q) kVar).Dt().mFb;
                if (linkedList3 == null || linkedList3.size() <= 0) {
                    v.e("MicroMsg.BizKFService", "empty workers");
                    c(null);
                    return;
                }
                it = linkedList3.iterator();
                while (it.hasNext()) {
                    com_tencent_mm_protocal_c_bit = (bit) it.next();
                    linkedList.add(new f(com_tencent_mm_protocal_c_bit.ndl, ((q) kVar).cDf, com_tencent_mm_protocal_c_bit.muL, com_tencent_mm_protocal_c_bit.mGq, 2, currentTimeMillis));
                    if (Bo != null) {
                        hVar = new h();
                        hVar.username = com_tencent_mm_protocal_c_bit.ndl;
                        hVar.cyC = com_tencent_mm_protocal_c_bit.muL;
                        hVar.aP(false);
                        hVar.bBY = 3;
                        Bo.a(hVar);
                        n.Bq().gE(com_tencent_mm_protocal_c_bit.ndl);
                    }
                }
                linkedList2 = linkedList3;
            }
            v.i("MicroMsg.BizKFService", "insertOrUpdateBizKFs %d", Integer.valueOf(u.Dx().e(linkedList)));
            c(linkedList2);
        } else {
            v.e("MicroMsg.BizKFService", "scene.getType() = %s", Integer.valueOf(kVar.getType()));
            c(null);
            if (kVar.getType() == 675) {
                this.cCO.remove(((s) kVar).tag);
            }
        }
    }

    private void c(LinkedList<bit> linkedList) {
        synchronized (this.cCN) {
            ArrayList arrayList = new ArrayList(this.cCP);
            for (int i = 0; i < arrayList.size(); i++) {
                a aVar = (a) arrayList.get(i);
                if (aVar != null) {
                    aVar.d(linkedList);
                }
            }
        }
    }
}

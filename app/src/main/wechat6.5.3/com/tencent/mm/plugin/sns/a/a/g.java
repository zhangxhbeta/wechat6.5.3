package com.tencent.mm.plugin.sns.a.a;

import android.app.Activity;
import android.view.View;
import com.tencent.mm.e.a.is;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class g implements b {
    public static Map<String, Integer> jcn = new HashMap();
    public Activity aXH;
    public long evC = 0;
    public int hGO = 1;
    public int jbB = 0;
    public HashMap<String, Long> jce = new HashMap();
    public HashSet<Long> jcf = new HashSet();
    public Map<String, Long> jcg = new HashMap();
    public Map<String, Integer> jch = new HashMap();
    public HashSet<Long> jci = new HashSet();
    public Map<Long, h> jcj = new HashMap();
    public Map<String, a> jck = new HashMap();
    private LinkedList<String> jcl = new LinkedList();
    private Map<String, Integer> jcm = new HashMap();
    private int jco = 0;
    public View jcp = null;
    private a jcq = null;
    private int jcr = -1;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int dIT;
        final /* synthetic */ long jcs;
        final /* synthetic */ g jct;
        final /* synthetic */ boolean jcu = true;

        AnonymousClass2(g gVar, long j, int i, boolean z) {
            this.jct = gVar;
            this.jcs = j;
            this.dIT = i;
        }

        public final void run() {
            this.jct.c(this.jcs, this.dIT, this.jcu);
        }
    }

    static class a {
        public String bpp;
        public String cZv;
        public long cZw;
        public int eKg;
        public int position;
        public long time;

        public a(long j, String str, int i, String str2, int i2, long j2) {
            this.time = j;
            this.bpp = str;
            this.position = i;
            this.cZv = str2;
            this.cZw = j2;
            this.eKg = i2;
        }
    }

    public final boolean cB(long j) {
        return this.jcf.contains(Long.valueOf(j));
    }

    public g(int i) {
        this.hGO = i;
    }

    public final void onResume() {
        if (this.evC > 0) {
            long az = be.az(this.evC);
            for (String str : this.jck.keySet()) {
                v.i("MicroMsg.SnsAdStatistic", "before Key " + str + " " + ((a) this.jck.get(str)).time);
            }
            for (String str2 : this.jck.keySet()) {
                a aVar = (a) this.jck.get(str2);
                aVar.time -= az;
            }
            for (String str22 : this.jck.keySet()) {
                v.i("MicroMsg.SnsAdStatistic", "update Key " + str22 + " " + ((a) this.jck.get(str22)).time);
            }
        }
    }

    public final void cC(final long j) {
        ad.o(new Runnable(this) {
            final /* synthetic */ g jct;

            public final void run() {
                if (this.jct.cB(j)) {
                    g gVar = this.jct;
                    long j = j;
                    h hVar = gVar.jcj.containsKey(Long.valueOf(j)) ? (h) gVar.jcj.get(Long.valueOf(j)) : new h("timeline");
                    hVar.jcx = 1;
                    hVar.jcB.jdw++;
                    gVar.jcj.put(Long.valueOf(j), hVar);
                }
            }
        });
    }

    public final void s(long j, int i) {
        ad.o(new AnonymousClass2(this, j, i, true));
    }

    public final void c(long j, int i, boolean z) {
        h hVar;
        if (this.jcj.containsKey(Long.valueOf(j))) {
            hVar = (h) this.jcj.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (i > 0) {
            hVar.jcB.jdy = i;
        }
        hVar.jcx = z ? 1 : 0;
        this.jcj.put(Long.valueOf(j), hVar);
    }

    public final void j(long j, boolean z) {
        h hVar;
        if (this.jcj.containsKey(Long.valueOf(j))) {
            hVar = (h) this.jcj.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (z) {
            hVar.jcB.jdz = 2;
        } else {
            hVar.jcB.jdz = 1;
        }
        hVar.jcB.jdA = 1;
        this.jcj.put(Long.valueOf(j), hVar);
    }

    public final void m(long j, long j2) {
        final long j3 = j;
        final long j4 = j2;
        ad.o(new Runnable(this) {
            final /* synthetic */ g jct;

            public final void run() {
                if (this.jct.cB(j3)) {
                    g gVar = this.jct;
                    long j = j4;
                    if (!gVar.jci.contains(Long.valueOf(j))) {
                        gVar.jci.add(Long.valueOf(j));
                    }
                }
            }
        });
    }

    public final boolean cD(long j) {
        if (this.jci.contains(Long.valueOf(j))) {
            return true;
        }
        return false;
    }

    public final void n(long j, long j2) {
        final long j3 = j;
        final long j4 = j2;
        ad.o(new Runnable(this) {
            final /* synthetic */ g jct;

            public final void run() {
                if (this.jct.cB(j3)) {
                    g gVar = this.jct;
                    long j = j3;
                    long j2 = j4;
                    h hVar = gVar.jcj.containsKey(Long.valueOf(j)) ? (h) gVar.jcj.get(Long.valueOf(j)) : new h("timeline");
                    if (hVar.jcB.jdB == 0) {
                        hVar.jcB.jdB = j2;
                    }
                    gVar.jcj.put(Long.valueOf(j), hVar);
                }
            }
        });
    }

    public final void a(int i, String str, String str2, boolean z, View view, long j, bc bcVar, awa com_tencent_mm_protocal_c_awa, int i2) {
        this.jcf.add(Long.valueOf(j));
        this.jce.put(str, Long.valueOf(j));
        if (this.jcr == -1) {
            this.jcr = this.aXH == null ? -1 : e.db(this.aXH);
        }
        if (this.jcq == null && view != null && com.tencent.mm.plugin.sns.e.ad.jlu) {
            this.jcq = new a(bcVar == null ? null : bcVar.jYN, j, view, this.jbB, this.jcp, this.jcr, this.hGO, com_tencent_mm_protocal_c_awa, i);
            a aVar = this.jcq;
            aVar.jbK = System.currentTimeMillis();
            com.tencent.mm.plugin.sns.e.ad.aqz().post(new Runnable(aVar) {
                final /* synthetic */ a jcd;

                {
                    this.jcd = r1;
                }

                public final void run() {
                    if (!this.jcd.jbv) {
                        this.jcd.aQT();
                    }
                }
            });
        }
        if (this.jcg.containsKey(str)) {
            long az = be.az(((Long) this.jcg.get(str)).longValue());
            if (az < 1200000) {
                int intValue = this.jch.containsKey(str) ? ((Integer) this.jch.get(str)).intValue() : 0;
                if (intValue >= 2) {
                    v.i("MicroMsg.SnsAdStatistic", "passed localid " + str + " viewid " + str2 + " passedTime: " + az);
                    return;
                }
                this.jch.put(str, Integer.valueOf(intValue + 1));
            } else {
                this.jcg.put(str, Long.valueOf(be.Nj()));
                this.jch.put(str, Integer.valueOf(0));
            }
        }
        if (!this.jck.containsKey(str)) {
            this.jck.put(str, new a(be.Nj(), str, i, str2, i2, j));
            v.i("MicroMsg.SnsAdStatistic", "onAdAdded " + i + " " + str + "  isExposure: " + z);
            if (i2 == 9) {
                h hVar;
                if (this.jcj.containsKey(Long.valueOf(j))) {
                    hVar = (h) this.jcj.get(Long.valueOf(j));
                } else {
                    hVar = new h("timeline");
                }
                hVar.jcz = be.Nj();
                this.jcj.put(Long.valueOf(j), hVar);
            }
            if (!this.jcl.contains(str)) {
                this.jcl.add(str);
                v.i("MicroMsg.SnsAdStatistic", "exposures item " + str);
                this.jcm.put(str, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            }
            if (i2 == 9) {
                ak.vy().a(new d(str2, this.hGO, 2), 0);
            } else {
                ak.vy().a(new d(str2, this.hGO, 1), 0);
            }
        }
    }

    public final void u(int i, String str, String str2) {
        if (this.jce.containsKey(str)) {
            this.jcf.remove(Long.valueOf(((Long) this.jce.remove(str)).longValue()));
        }
        at atVar = null;
        aw awVar = null;
        if (this.jcq != null && com.tencent.mm.plugin.sns.e.ad.jlu) {
            a aVar = this.jcq;
            aVar.eDI = true;
            aVar.jbL = System.currentTimeMillis();
            aVar = this.jcq;
            if (aVar.jbG < 0) {
                aVar.jcb = 2;
            } else {
                aVar.jcb = 1;
            }
            if (aVar.jbI < 0) {
                aVar.jcc = 2;
            } else {
                aVar.jcc = 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.cE(aVar.cZw) + ",");
            stringBuilder.append(aVar.cZx + ",");
            stringBuilder.append(aVar.jcb + ",");
            stringBuilder.append(aVar.jcc + ",");
            stringBuilder.append(aVar.jbY + ",");
            stringBuilder.append(aVar.jbZ + ",");
            stringBuilder.append(aVar.jca + ",");
            stringBuilder.append(aVar.jbK + ",");
            stringBuilder.append(aVar.jbL + ",");
            if (aVar.jbO > 0 && aVar.jbR == 0) {
                aVar.jbR = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.jbO + ",");
            stringBuilder.append(aVar.jbR + ",");
            if (aVar.jbU > 0 && aVar.jbX == 0) {
                aVar.jbX = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.jbU + ",");
            stringBuilder.append(aVar.jbX);
            f.a(aVar.cZw, stringBuilder);
            v.i("MicroMsg.AdViewStatic", "report " + stringBuilder.toString());
            atVar = new at();
            atVar.mbn = aVar.jbU;
            atVar.mbo = aVar.jbX;
            atVar.jcb = aVar.jcb;
            atVar.jcc = aVar.jcc;
            atVar.mbi = (float) aVar.jbY;
            atVar.mbj = (float) aVar.jbZ;
            atVar.mbk = (float) aVar.jca;
            atVar.mbl = aVar.jbO;
            atVar.mbm = aVar.jbR;
            atVar.startTime = aVar.jbK;
            atVar.endTime = aVar.jbL;
            com.tencent.mm.plugin.sns.e.ad.aSy().h(12010, stringBuilder.toString());
            com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(730);
            gh.kj(i.cE(aVar.cZw)).kj(aVar.cZx).gk(aVar.jcb).gk(aVar.jcc).gk(aVar.jbY).gk(aVar.jbZ).gk(aVar.jca).kj(aVar.jbK).kj(aVar.jbL).kj(aVar.jbO).kj(aVar.jbR).kj(aVar.jbU).kj(aVar.jbX);
            gh.JF();
            is isVar = new is();
            isVar.bji.position = aVar.position;
            com.tencent.mm.sdk.c.a.nhr.z(isVar);
            if (q.dqP) {
                int nextInt = new Random(System.currentTimeMillis()).nextInt(2000) + 10;
                v.i("MicroMsg.AdViewStatic", "run on test kv " + nextInt);
                for (int i2 = 0; i2 < nextInt; i2++) {
                    com.tencent.mm.plugin.sns.e.ad.aSy().h(12010, stringBuilder.toString());
                }
            }
            a aVar2 = this.jcq;
            aw awVar2 = new aw();
            if (aVar2.jbw != null) {
                awVar2.mbt = aVar2.jbw.mTl;
                awVar2.mbs = aVar2.jbw.mTi;
            } else {
                awVar2 = null;
            }
            this.jcq = null;
            awVar = awVar2;
        }
        if (this.jck.containsKey(str)) {
            a aVar3 = (a) this.jck.remove(str);
            this.jcg.put(str, Long.valueOf(be.Nj()));
            if (aVar3 != null) {
                k dVar;
                long az = be.az(aVar3.time);
                v.i("MicroMsg.SnsAdStatistic", "onAdRemoved " + i + " " + str + " " + az + " ");
                if (aVar3.eKg == 9) {
                    h hVar = (h) this.jcj.remove(Long.valueOf(aVar3.cZw));
                    String str3 = "";
                    if (hVar != null) {
                        hVar.pP(0);
                        str3 = hVar.aQV();
                    }
                    this.jci.remove(Long.valueOf(aVar3.cZw));
                    dVar = new d(str2, this.hGO, (int) az, atVar, awVar, 2, str3);
                } else {
                    dVar = new d(str2, this.hGO, (int) az, atVar, awVar, 1, "");
                }
                ak.vy().a(dVar, 0);
                return;
            }
            return;
        }
        v.i("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + i + " " + str);
    }

    public final void aQU() {
        if (this.jcq != null && com.tencent.mm.plugin.sns.e.ad.jlu) {
            this.jcq.aQT();
        }
    }

    public final void clear() {
        String str;
        v.i("MicroMsg.SnsAdStatistic", "clean the adRemove" + this.jcl.size());
        List<String> linkedList = new LinkedList();
        for (String str2 : this.jck.keySet()) {
            linkedList.add(str2);
        }
        for (String str22 : linkedList) {
            a aVar = (a) this.jck.get(str22);
            u(aVar.position, aVar.bpp, aVar.cZv);
        }
        Iterator it = this.jcl.iterator();
        while (it.hasNext()) {
            str22 = (String) it.next();
            c qB = com.tencent.mm.plugin.sns.e.ad.aSF().qB(s.BL(str22));
            if (qB != null) {
                int intValue;
                qB.field_localFlag |= 128;
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (this.jcm.containsKey(str22)) {
                    intValue = ((Integer) this.jcm.get(str22)).intValue();
                } else {
                    intValue = currentTimeMillis;
                }
                qB.field_exposureTime = intValue;
                com.tencent.mm.plugin.sns.e.ad.aSF().b(qB.field_snsId, qB);
            }
        }
        this.jcl.clear();
        this.jcm.clear();
    }
}

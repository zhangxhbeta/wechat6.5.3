package com.tencent.mm.plugin.sns.e;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.pluginsdk.j.q.e;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class ak {

    public static class a implements e, com.tencent.mm.v.e {
        public static int jna = -1;
        private Map<com.tencent.mm.pluginsdk.j.q.e.a, String> cAd = new HashMap();
        private Map<String, Long> jnb = new HashMap();
        private Map<String, Integer> jnc = new HashMap();
        private int jnd = 0;
        public long jne = 0;
        private LinkedList<String> jnf = new LinkedList();
        public Map<String, ArrayList<b>> jng = new HashMap();
        public Map<String, Integer> jnh = new HashMap();

        static /* synthetic */ void a(a aVar) {
            if (!ad.aSn() && aVar.cAd.isEmpty()) {
                ad.aSB().aRR();
                v.d("MicroMsg.SnsService", "clean sns cache");
            }
        }

        public final void e(String str, ArrayList<b> arrayList) {
            this.jng.put(str, arrayList);
        }

        public final Intent e(Intent intent, String str) {
            intent.putExtra("sns_userName", str);
            if (this.jnf != null && this.jnf.contains(str)) {
                intent.addFlags(536870912);
                intent.addFlags(67108864);
            }
            return intent;
        }

        public final void a(int i, String str, com.tencent.mm.pluginsdk.j.q.e.a aVar) {
            v.i("MicroMsg.SnsService", "startServer " + i + " " + aVar);
            ad.aSD().bYE = k.xF();
            ad.aSD().aSf();
            ad.aSA().aTe();
            if (this.cAd.isEmpty()) {
                com.tencent.mm.model.ak.vy().a(211, this);
                com.tencent.mm.model.ak.vy().a(212, this);
            }
            if (!this.cAd.containsKey(aVar)) {
                if (i == 1) {
                    this.cAd.put(aVar, "@__weixintimtline");
                } else if (i == 2 || i == 3) {
                    this.cAd.put(aVar, str);
                } else if (i == 4) {
                    this.cAd.put(aVar, "@__classify_timeline");
                } else if (i == 5) {
                    this.cAd.put(aVar, "");
                } else {
                    this.cAd.put(aVar, "");
                }
            }
            switch (i) {
                case 1:
                    this.jne = 0;
                    this.jnd = aTa();
                    v.Al("@__weixintimtline");
                    return;
                case 2:
                    synchronized (this.jnb) {
                        this.jnb.put(str, Long.valueOf(0));
                    }
                    synchronized (this.jnc) {
                        if (!this.jnc.containsKey(str)) {
                            this.jnc.put(str, Integer.valueOf(aTa()));
                        }
                    }
                    x.An(str);
                    this.jnf.add(str);
                    return;
                default:
                    return;
            }
        }

        public final boolean a(com.tencent.mm.pluginsdk.j.q.e.a aVar, int i) {
            v.d("MicroMsg.SnsService", "closeServer");
            this.cAd.remove(aVar);
            if (i == 2 && this.jnf.size() > 0) {
                this.jnf.removeLast();
            }
            if (this.cAd.isEmpty()) {
                com.tencent.mm.model.ak.vy().b(211, this);
                com.tencent.mm.model.ak.vy().b(212, this);
                al.release();
                com.tencent.mm.plugin.sns.storage.k.release();
                new ac(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ a jni;

                    {
                        this.jni = r1;
                    }

                    public final void run() {
                        a.a(this.jni);
                    }
                }, 5000);
                ah.aSU();
                v.i("MicroMsg.SnsService", "close finish");
            }
            return true;
        }

        public final void a(int i, String str, boolean z, int i2) {
            if (!q.dpQ) {
                v.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[]{str, Integer.valueOf(i), Long.valueOf(this.jne), this.jnb});
                if (i == 2) {
                    if (x.Am(str)) {
                        long j = 0;
                        synchronized (this.jnb) {
                            if (this.jnb.containsKey(str)) {
                                j = ((Long) this.jnb.get(str)).longValue();
                            }
                        }
                        if (j == 0) {
                            v.Al(str);
                        } else {
                            com.tencent.mm.model.ak.vy().a(new x(str, j, z, i2), 0);
                        }
                    }
                } else if (i == 1) {
                    if (!v.Ak("@__weixintimtline")) {
                        return;
                    }
                    if (this.jne == 0) {
                        v.Al("@__weixintimtline");
                    } else {
                        com.tencent.mm.model.ak.vy().a(new v(this.jne), 0);
                    }
                } else if (i == 3 || i != 4 || !l.Ak("@__classify_timeline")) {
                } else {
                    if (this.jne == 0) {
                        l.Al("@__classify_timeline");
                    } else {
                        com.tencent.mm.model.ak.vy().a(new l(""), 0);
                    }
                }
            }
        }

        public final void b(int i, String str, boolean z, int i2) {
            if (!q.dpQ) {
                v.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[]{Integer.valueOf(i), str});
                if (i == 2) {
                    if (x.Am(str)) {
                        com.tencent.mm.model.ak.vy().a(new x(str, 0, z, i2), 0);
                    }
                } else if (i == 1) {
                    if (v.Ak("@__weixintimtline")) {
                        com.tencent.mm.model.ak.yW();
                        c.vf().set(68377, "");
                        com.tencent.mm.model.ak.vy().a(new v(0), 0);
                    }
                } else if (i != 3 && i == 4 && l.Ak("@__classify_timeline")) {
                    com.tencent.mm.model.ak.vy().a(new l(""), 0);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int Ax(java.lang.String r3) {
            /*
            r2 = this;
            r1 = r2.jnc;
            monitor-enter(r1);
            r0 = r2.jnc;	 Catch:{ all -> 0x0026 }
            r0 = r0.containsKey(r3);	 Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0020;
        L_0x000b:
            r0 = r2.jnc;	 Catch:{ all -> 0x0026 }
            r0 = r0.get(r3);	 Catch:{ all -> 0x0026 }
            r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0026 }
            r0 = r0.intValue();	 Catch:{ all -> 0x0026 }
            if (r0 <= 0) goto L_0x001b;
        L_0x0019:
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        L_0x001a:
            return r0;
        L_0x001b:
            r0 = com.tencent.mm.plugin.sns.data.i.aRa();	 Catch:{ all -> 0x0026 }
            goto L_0x0019;
        L_0x0020:
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
            r0 = com.tencent.mm.plugin.sns.data.i.aRa();
            goto L_0x001a;
        L_0x0026:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.e.ak.a.Ax(java.lang.String):int");
        }

        public final int aTa() {
            return this.jnd > 0 ? this.jnd : i.aRa();
        }

        public final void u(long j, int i) {
            v.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[]{Long.valueOf(j)});
            if (i > 0) {
                this.jnd = i;
                i.pT(i);
            }
            if (j != 0) {
                this.jne = j;
            }
        }

        public static int aTb() {
            if (jna != -1) {
                return jna;
            }
            int aQZ = i.aQZ();
            jna = aQZ;
            return aQZ;
        }

        public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
            Object obj;
            v.i("MicroMsg.SnsService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
            if ((i == 4 && i2 == 207) || ((i == 4 && i2 == 203) || (i == 0 && i2 == 0))) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                String str2;
                int i3;
                switch (kVar.getType()) {
                    case 211:
                        v vVar = (v) kVar;
                        u(vVar.jjW, vVar.jjY);
                        i3 = vVar.jjZ;
                        if (jna != i3) {
                            i.pS(i3);
                        }
                        jna = i3;
                        break;
                    case 212:
                        x xVar = (x) kVar;
                        str2 = xVar.userName;
                        long j = xVar.jjW;
                        i3 = xVar.jjY;
                        if (i3 > 0) {
                            synchronized (this.jnc) {
                                this.jnc.put(str2, Integer.valueOf(i3));
                            }
                        }
                        if (j != 0) {
                            synchronized (this.jnb) {
                                this.jnb.put(str2, Long.valueOf(j));
                            }
                            break;
                        }
                        break;
                }
                if (kVar.getType() == 212 || kVar.getType() == 211) {
                    d dVar = (d) kVar;
                    Iterator it = new ArrayList(this.cAd.keySet()).iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.pluginsdk.j.q.e.a aVar = (com.tencent.mm.pluginsdk.j.q.e.a) it.next();
                        if (this.cAd.containsKey(aVar)) {
                            str2 = (String) this.cAd.get(aVar);
                            if (dVar.getUserName().equals(str2)) {
                                v.d("MicroMsg.SnsService", "notify ui " + str2);
                                str2 = dVar.aRO() == 0 ? "" : i.cF(dVar.aRO());
                                if (dVar.aRK()) {
                                    aVar.a(dVar.aRM(), dVar.aRL(), str2, dVar.aRP());
                                } else {
                                    aVar.b(dVar.aRL(), str2, dVar.aRN());
                                }
                            }
                        }
                    }
                }
            }
        }

        public static void Ay(String str) {
            aa aSD = ad.aSD();
            if (be.kS(aSD.bYE)) {
                aSD.bYE = k.xF();
            }
            String str2 = aSD.bYE;
            com.tencent.mm.plugin.sns.storage.k Bp = f.Bp(str);
            try {
                awa com_tencent_mm_protocal_c_awa = (awa) new awa().az(Bp.field_attrBuf);
                Iterator it = com_tencent_mm_protocal_c_awa.mTk.iterator();
                while (it.hasNext()) {
                    avr com_tencent_mm_protocal_c_avr = (avr) it.next();
                    if (com_tencent_mm_protocal_c_avr.mdw.equals(str2)) {
                        com_tencent_mm_protocal_c_awa.mTk.remove(com_tencent_mm_protocal_c_avr);
                        com_tencent_mm_protocal_c_awa.mTi--;
                        Bp.field_attrBuf = com_tencent_mm_protocal_c_awa.toByteArray();
                        if (Bp.qC(32)) {
                            ad.aSF().a(Bp.aUS());
                        } else {
                            ad.aSE().z(Bp);
                        }
                        if (!ad.aSD().cR(s.BK(str))) {
                            if (Bp.qC(32)) {
                                com.tencent.mm.model.ak.vy().a(new p(s.BK(str), 5), 0);
                                return;
                            }
                            com.tencent.mm.plugin.sns.storage.a aUo = Bp.aUo();
                            String str3 = aUo != null ? "" : aUo.jbF;
                            g.iuh.h(11855, new Object[]{Integer.valueOf(0), str3});
                            com.tencent.mm.model.ak.vy().a(new p(s.BK(str), 7), 0);
                        }
                        return;
                    }
                }
            } catch (Exception e) {
            }
            if (!ad.aSD().cR(s.BK(str))) {
                return;
            }
            if (Bp.qC(32)) {
                com.tencent.mm.model.ak.vy().a(new p(s.BK(str), 5), 0);
                return;
            }
            com.tencent.mm.plugin.sns.storage.a aUo2 = Bp.aUo();
            if (aUo2 != null) {
            }
            g.iuh.h(11855, new Object[]{Integer.valueOf(0), str3});
            com.tencent.mm.model.ak.vy().a(new p(s.BK(str), 7), 0);
        }

        public static avr a(com.tencent.mm.plugin.sns.storage.k kVar, int i, String str) {
            return a(kVar, i, str, null, false);
        }

        public static avr a(com.tencent.mm.plugin.sns.storage.k kVar, int i, String str, avr com_tencent_mm_protocal_c_avr) {
            return a(kVar, i, str, com_tencent_mm_protocal_c_avr, false);
        }

        public static avr a(com.tencent.mm.plugin.sns.storage.k kVar, int i, String str, avr com_tencent_mm_protocal_c_avr, boolean z) {
            String str2;
            avm com_tencent_mm_protocal_c_avm = new avm();
            com_tencent_mm_protocal_c_avm.hQP = str;
            com_tencent_mm_protocal_c_avm.hNS = (int) (be.Ni() / 1000);
            com_tencent_mm_protocal_c_avm.mSK = k.xH();
            com_tencent_mm_protocal_c_avm.mOk = k.xF();
            com_tencent_mm_protocal_c_avm.mcP = 0;
            com_tencent_mm_protocal_c_avm.mSL = l.er(kVar.field_userName);
            com_tencent_mm_protocal_c_avm.mqR = kVar.field_userName;
            com_tencent_mm_protocal_c_avm.efm = i;
            if (kVar.qC(32)) {
                com_tencent_mm_protocal_c_avm.mSP = com_tencent_mm_protocal_c_avr == null ? 0 : com_tencent_mm_protocal_c_avr.mSQ;
            } else {
                com_tencent_mm_protocal_c_avm.mSM = com_tencent_mm_protocal_c_avr == null ? 0 : com_tencent_mm_protocal_c_avr.mSN;
            }
            avm com_tencent_mm_protocal_c_avm2 = new avm();
            com_tencent_mm_protocal_c_avm2.mOk = com_tencent_mm_protocal_c_avr == null ? "" : com_tencent_mm_protocal_c_avr.mdw;
            avn com_tencent_mm_protocal_c_avn = new avn();
            com_tencent_mm_protocal_c_avn.mjq = kVar.field_snsId;
            com_tencent_mm_protocal_c_avn.mST = com_tencent_mm_protocal_c_avm;
            com_tencent_mm_protocal_c_avn.mSU = com_tencent_mm_protocal_c_avm2;
            String str3 = "";
            if (kVar.qC(32)) {
                Object obj;
                com.tencent.mm.plugin.sns.storage.a aUo = kVar.aUo();
                if (aUo == null) {
                    obj = "";
                } else {
                    str2 = aUo.jbF;
                }
                str3 = aUo == null ? "" : aUo.jpt;
                if (com_tencent_mm_protocal_c_avm.efm == 7) {
                    g.iuh.h(11855, new Object[]{Integer.valueOf(1), obj});
                } else if (com_tencent_mm_protocal_c_avm.efm == 8) {
                    g.iuh.h(11855, new Object[]{Integer.valueOf(2), obj});
                }
                com.tencent.mm.plugin.sns.storage.c aUS = kVar.aUS();
                if (aUS != null && aUS.field_firstControlTime == 0) {
                    aUS.field_firstControlTime = com_tencent_mm_protocal_c_avm.hNS;
                    ad.aSF().b(aUS.field_snsId, aUS);
                }
            }
            str2 = com.tencent.mm.a.g.m((be.Nj()).getBytes());
            if (kVar.qC(32)) {
                str2 = "_AD_TAG_" + str2;
            }
            if (!ad.aSD().a(str2, com_tencent_mm_protocal_c_avn)) {
                v.e("MicroMsg.SnsService", "can not add Comment");
            } else if (aa.Ao(str2)) {
                com.tencent.mm.model.ak.vy().a(new j(com_tencent_mm_protocal_c_avn, str2, str3), 0);
            } else {
                com.tencent.mm.model.ak.vy().a(new m(com_tencent_mm_protocal_c_avn, str2), 0);
            }
            if (!z) {
                return null;
            }
            avr com_tencent_mm_protocal_c_avr2 = new avr();
            com_tencent_mm_protocal_c_avr2.hNS = com_tencent_mm_protocal_c_avm.hNS;
            com_tencent_mm_protocal_c_avr2.efm = com_tencent_mm_protocal_c_avm.efm;
            com_tencent_mm_protocal_c_avr2.mcP = com_tencent_mm_protocal_c_avm.mcP;
            com_tencent_mm_protocal_c_avr2.mdw = com_tencent_mm_protocal_c_avm.mOk;
            com_tencent_mm_protocal_c_avr2.mGq = com_tencent_mm_protocal_c_avm.mSK;
            com_tencent_mm_protocal_c_avr2.hQP = com_tencent_mm_protocal_c_avm.hQP;
            if (kVar.qC(32)) {
                com_tencent_mm_protocal_c_avr2.mSP = com_tencent_mm_protocal_c_avr == null ? 0 : com_tencent_mm_protocal_c_avr.mSQ;
            } else {
                com_tencent_mm_protocal_c_avr2.mSM = com_tencent_mm_protocal_c_avr == null ? 0 : com_tencent_mm_protocal_c_avr.mSN;
            }
            com_tencent_mm_protocal_c_avr2.mTc = com_tencent_mm_protocal_c_avr == null ? "" : com_tencent_mm_protocal_c_avr.mdw;
            return com_tencent_mm_protocal_c_avr2;
        }

        public static avr a(com.tencent.mm.plugin.sns.storage.k kVar, int i, String str, String str2, int i2) {
            String str3;
            avm com_tencent_mm_protocal_c_avm = new avm();
            com_tencent_mm_protocal_c_avm.hQP = str;
            com_tencent_mm_protocal_c_avm.hNS = (int) (be.Ni() / 1000);
            com_tencent_mm_protocal_c_avm.mSK = k.xH();
            com_tencent_mm_protocal_c_avm.mOk = k.xF();
            com_tencent_mm_protocal_c_avm.mcP = i2;
            com_tencent_mm_protocal_c_avm.mSL = l.er(kVar.field_userName);
            com_tencent_mm_protocal_c_avm.mqR = kVar.field_userName;
            com_tencent_mm_protocal_c_avm.efm = i;
            if (kVar.qC(32)) {
                com_tencent_mm_protocal_c_avm.mSP = 0;
            } else {
                com_tencent_mm_protocal_c_avm.mSM = 0;
            }
            avm com_tencent_mm_protocal_c_avm2 = new avm();
            com_tencent_mm_protocal_c_avm2.mOk = str2;
            avn com_tencent_mm_protocal_c_avn = new avn();
            com_tencent_mm_protocal_c_avn.mjq = kVar.field_snsId;
            com_tencent_mm_protocal_c_avn.mST = com_tencent_mm_protocal_c_avm;
            com_tencent_mm_protocal_c_avn.mSU = com_tencent_mm_protocal_c_avm2;
            String str4 = "";
            if (kVar.qC(32)) {
                Object obj;
                com.tencent.mm.plugin.sns.storage.a aUo = kVar.aUo();
                if (aUo == null) {
                    obj = "";
                } else {
                    str3 = aUo.jbF;
                }
                str4 = aUo == null ? "" : aUo.jpt;
                if (com_tencent_mm_protocal_c_avm.efm == 7) {
                    g.iuh.h(11855, new Object[]{Integer.valueOf(1), obj});
                } else if (com_tencent_mm_protocal_c_avm.efm == 8) {
                    g.iuh.h(11855, new Object[]{Integer.valueOf(2), obj});
                }
            }
            str3 = com.tencent.mm.a.g.m((be.Nj()).getBytes());
            if (kVar.qC(32)) {
                str3 = "_AD_TAG_" + str3;
            }
            if (!ad.aSD().a(str3, com_tencent_mm_protocal_c_avn, str4)) {
                v.e("MicroMsg.SnsService", "can not add Comment");
            } else if (aa.Ao(str3)) {
                com.tencent.mm.model.ak.vy().a(new j(com_tencent_mm_protocal_c_avn, str3, str4), 0);
            } else {
                com.tencent.mm.model.ak.vy().a(new m(com_tencent_mm_protocal_c_avn, str3), 0);
            }
            return null;
        }

        public static void a(String str, int i, String str2, com.tencent.mm.plugin.sns.storage.k kVar, int i2) {
            if (i == 3 || i == 5) {
                avm com_tencent_mm_protocal_c_avm = new avm();
                com_tencent_mm_protocal_c_avm.hQP = str2;
                com_tencent_mm_protocal_c_avm.hNS = (int) (System.currentTimeMillis() / 1000);
                com_tencent_mm_protocal_c_avm.mSK = k.xH();
                com_tencent_mm_protocal_c_avm.mOk = k.xF();
                com_tencent_mm_protocal_c_avm.mcP = i2;
                com_tencent_mm_protocal_c_avm.mSL = l.er(str);
                com_tencent_mm_protocal_c_avm.mqR = str;
                com_tencent_mm_protocal_c_avm.efm = i;
                avn com_tencent_mm_protocal_c_avn = new avn();
                com_tencent_mm_protocal_c_avn.mjq = kVar.field_snsId;
                com_tencent_mm_protocal_c_avn.mST = com_tencent_mm_protocal_c_avm;
                com_tencent_mm_protocal_c_avn.mSU = new avm();
                String m = com.tencent.mm.a.g.m((be.Nj()).getBytes());
                long j = kVar.field_snsId;
                try {
                    v.v("MicroMsg.SnsService", "comment stg inserted");
                    com.tencent.mm.plugin.sns.storage.g gVar = new com.tencent.mm.plugin.sns.storage.g();
                    gVar.field_talker = str;
                    gVar.field_snsID = j;
                    gVar.field_createTime = (int) (System.currentTimeMillis() / 1000);
                    gVar.field_curActionBuf = com_tencent_mm_protocal_c_avm.toByteArray();
                    gVar.field_type = i;
                    gVar.field_isSend = true;
                    gVar.field_isRead = (short) 1;
                    ad.aSH().b(gVar);
                } catch (Throwable e) {
                    v.a("MicroMsg.SnsService", e, "", new Object[0]);
                }
                ad.aSD().a(m, com_tencent_mm_protocal_c_avn);
            }
        }

        public final void Az(String str) {
            String xh = ad.xh();
            String str2 = str + "bg_";
            String str3 = str + "tbg_";
            if (FileOp.aR(str2)) {
                FileOp.deleteFile(al.cA(xh, str) + str3);
                FileOp.n(al.cA(xh, str), str2, str3);
            }
        }
    }
}

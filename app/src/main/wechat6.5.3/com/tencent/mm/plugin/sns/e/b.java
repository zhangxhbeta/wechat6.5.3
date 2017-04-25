package com.tencent.mm.plugin.sns.e;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.h.j;
import com.tencent.mm.memory.n;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.a.d;
import com.tencent.mm.plugin.sns.e.g.AnonymousClass9;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements com.tencent.mm.plugin.sns.e.a.b.a, e {
    static int jiE = 0;
    private static final int jiF = (VERSION.SDK_INT >= 14 ? 100 : 25);
    LinkedList<f> caF;
    Set<b> cbh;
    private ac handler;
    private long jiG;
    private int jiH;
    private int jiI;
    private LinkedList<g> jiJ;
    public HashMap<String, Long> jiK;
    public boolean jiL;
    public Set<a> jiM;
    Map<String, Long> jiN;
    Map<String, com.tencent.mm.plugin.sns.data.c> jiO;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String dhf;
        final /* synthetic */ b jiQ;
        final /* synthetic */ String un;

        public AnonymousClass3(b bVar, String str, String str2) {
            this.jiQ = bVar;
            this.un = str;
            this.dhf = str2;
        }

        public final void run() {
            if (this.jiQ.jiM != null) {
                for (a aVar : this.jiQ.jiM) {
                    if (aVar != null) {
                        aVar.cx(this.un, this.dhf);
                    }
                }
            }
        }
    }

    public interface a {
        void cx(String str, String str2);
    }

    public interface b {
        void Aa(String str);

        void aRc();

        void ai(String str, boolean z);

        void aj(String str, boolean z);
    }

    class c implements IdleHandler {
        final /* synthetic */ b jiQ;

        c(b bVar) {
            this.jiQ = bVar;
        }

        public final boolean queueIdle() {
            v.d("MicroMsg.DownloadManager", "I run idleHandler ");
            this.jiQ.jiG = be.Nh();
            return b.a(this.jiQ);
        }
    }

    static /* synthetic */ void a(b bVar, String str) {
        v.d("MicroMsg.DownloadManager", "onDownLoadFinish by scene %s", new Object[]{str});
        ad.aSD().Ar(str);
        bVar.Ge();
    }

    static /* synthetic */ boolean a(b bVar) {
        if (bVar.jiJ == null || bVar.jiJ.size() <= 0) {
            return false;
        }
        g gVar = (g) bVar.jiJ.remove();
        new ap().l(gVar);
        return true;
    }

    static /* synthetic */ boolean a(b bVar, aib com_tencent_mm_protocal_c_aib, int i, com.tencent.mm.plugin.sns.data.e eVar, ak akVar) {
        if (!i.zV(ad.xq())) {
            v.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[]{ad.xq(), com.tencent.mm.compatible.util.e.cni});
            return false;
        } else if (com_tencent_mm_protocal_c_aib.gID.startsWith("Locall_path") || com_tencent_mm_protocal_c_aib.gID.startsWith("pre_temp_sns_pic")) {
            v.d("MicroMsg.DownloadManager", "is a local img not need download");
            return false;
        } else {
            String ac = i.ac(i, com_tencent_mm_protocal_c_aib.gID);
            if (bVar.jiO.containsKey(ac)) {
                Iterator it = bVar.caF.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar.boL.gID.equals(com_tencent_mm_protocal_c_aib.gID) && fVar.requestType == i) {
                        if (bVar.caF.remove(fVar)) {
                            bVar.caF.addLast(fVar);
                        }
                        v.v("MicroMsg.DownloadManager", "update the donwload list ");
                    }
                }
            } else {
                v.d("MicroMsg.DownloadManager", "add list %s", new Object[]{com_tencent_mm_protocal_c_aib.gID});
                bVar.jiO.put(ac, new com.tencent.mm.plugin.sns.data.c(eVar, i));
                bVar.caF.add(new f(com_tencent_mm_protocal_c_aib, i, ac, akVar));
            }
            v.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", new Object[]{Integer.valueOf(ad.aSD().aSi()), Integer.valueOf(bVar.jiN.size())});
            v.v("MicroMsg.DownloadManager", "lockwaitdownload. %s * %s memeryFiles.size() ", new Object[]{Integer.valueOf(bVar.jiO.size()), Integer.valueOf(bVar.jiO.size()), Integer.valueOf(bVar.jiJ.size())});
            if (Looper.myLooper() == null) {
                v.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
                return false;
            }
            Looper.myQueue().addIdleHandler(new c(bVar));
            if ((be.ax(bVar.jiG) * 1000 > 300000 ? 1 : null) != null) {
                bVar.handler.postDelayed(new Runnable(bVar) {
                    final /* synthetic */ b jiQ;

                    {
                        this.jiQ = r1;
                    }

                    public final void run() {
                        b.a(this.jiQ);
                    }
                }, 500);
            }
            List<String> linkedList = new LinkedList();
            for (Entry key : bVar.jiN.entrySet()) {
                linkedList.add(key.getKey());
            }
            for (String ac2 : linkedList) {
                if (bVar.jiN.containsKey(ac2) && be.ax(((Long) bVar.jiN.get(ac2)).longValue()) * 1000 > 300000) {
                    v.d("MicroMsg.DownloadManager", "too long to download");
                    bVar.jiN.remove(ac2);
                    bVar.jiO.remove(ac2);
                }
            }
            if (bVar.caF.size() > 0) {
                bVar.handler.postDelayed(new Runnable(bVar) {
                    final /* synthetic */ b jiQ;

                    {
                        this.jiQ = r1;
                    }

                    public final void run() {
                        this.jiQ.Ge();
                    }
                }, 500);
            }
            return true;
        }
    }

    public static void aRH() {
    }

    public static boolean aRI() {
        return false;
    }

    public final void G(int i, boolean z) {
        this.jiI = i;
        try {
            String value;
            String str;
            if (com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                value = j.sU().getValue("SnsImgDownloadConcurrentCountForWifi");
            } else {
                value = j.sU().getValue("SnsImgDownloadConcurrentCountForNotWifi");
            }
            if (be.kS(value) && com.tencent.mm.sdk.b.b.bsI()) {
                str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
            } else {
                str = value;
            }
            if (!be.kS(str)) {
                int i2;
                String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
                int KL = (be.KL(split[1]) + (be.KL(split[0]) * 60)) - ((((int) i.Ef()) - 8) * 60);
                if (KL < 0) {
                    i2 = KL + 1440;
                } else if (KL >= 1440) {
                    i2 = KL - 1440;
                } else {
                    i2 = KL;
                }
                String[] split2 = str.split(";");
                for (int i3 = 0; i3 < split2.length; i3++) {
                    if (!be.kS(split2[i3])) {
                        split = split2[i3].split("-");
                        if (split == null || split.length < 4) {
                            v.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", new Object[]{Integer.valueOf(i3), str});
                        } else {
                            String[] split3 = split[0].split(":");
                            int KL2 = be.KL(split3[1]) + (be.KL(split3[0]) * 60);
                            String[] split4 = split[1].split(":");
                            v.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", new Object[]{Integer.valueOf(i3), Integer.valueOf(KL2), Integer.valueOf(be.KL(split4[1]) + (be.KL(split4[0]) * 60)), Integer.valueOf(i2), split[2], split[3]});
                            if (i2 <= be.KL(split4[1]) + (be.KL(split4[0]) * 60) && i2 > KL2) {
                                KL = be.KL(z ? split[2] : split[3]);
                                if (KL > 0) {
                                    this.jiI = KL;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            v.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[]{be.e(e)});
        }
        v.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[]{Integer.valueOf(this.jiI)});
    }

    public b() {
        this.handler = null;
        this.jiG = 0;
        this.jiH = 0;
        this.jiI = 2;
        this.jiJ = new LinkedList();
        this.jiK = new HashMap();
        this.jiL = true;
        this.cbh = new HashSet();
        this.jiM = new HashSet();
        this.caF = new LinkedList();
        this.jiN = new ConcurrentHashMap();
        this.jiO = new HashMap();
        this.handler = ad.aqz();
        aRJ();
    }

    private void aRJ() {
        this.caF.clear();
        this.jiO.clear();
        this.jiN.clear();
        this.jiJ.clear();
        this.jiK.clear();
    }

    public final void a(final b bVar) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ b jiQ;

            public final void run() {
                b bVar = this.jiQ;
                bVar.cbh.add(bVar);
                int i = b.jiE + 1;
                b.jiE = i;
                if (i <= 1) {
                    com.tencent.mm.model.ak.vy().a(208, bVar);
                }
            }
        });
    }

    public final void b(final b bVar) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ b jiQ;

            public final void run() {
                b bVar = this.jiQ;
                bVar.cbh.remove(bVar);
                int i = b.jiE - 1;
                b.jiE = i;
                if (i <= 0) {
                    com.tencent.mm.model.ak.vy().b(208, bVar);
                }
            }
        });
    }

    public final boolean a(aib com_tencent_mm_protocal_c_aib, int i, com.tencent.mm.plugin.sns.data.e eVar, ak akVar) {
        if (com_tencent_mm_protocal_c_aib == null) {
            v.e("MicroMsg.DownloadManager", "unknow case media is null " + be.bur().toString());
            return false;
        }
        final aib com_tencent_mm_protocal_c_aib2 = com_tencent_mm_protocal_c_aib;
        final int i2 = i;
        final com.tencent.mm.plugin.sns.data.e eVar2 = eVar;
        final ak akVar2 = akVar;
        ad.aqz().post(new Runnable(this) {
            final /* synthetic */ b jiQ;

            public final void run() {
                as.AC(com_tencent_mm_protocal_c_aib2.gID);
                b.a(this.jiQ, com_tencent_mm_protocal_c_aib2, i2, eVar2, akVar2);
            }
        });
        return true;
    }

    public final void Af(String str) {
        v.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str});
        com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) this.jiO.get(str);
        if (cVar != null) {
            com.tencent.mm.plugin.sns.data.e eVar = cVar.jdH;
            if (eVar != null) {
                aib com_tencent_mm_protocal_c_aib;
                g aSB = ad.aSB();
                aib com_tencent_mm_protocal_c_aib2 = (aib) eVar.gKQ.get(0);
                for (int i = 1; i < eVar.gKQ.size(); i++) {
                    aib com_tencent_mm_protocal_c_aib3 = (aib) eVar.gKQ.get(i);
                    if (str != null && str.indexOf(com_tencent_mm_protocal_c_aib3.gID) >= 0) {
                        com_tencent_mm_protocal_c_aib = com_tencent_mm_protocal_c_aib3;
                        break;
                    }
                }
                com_tencent_mm_protocal_c_aib = com_tencent_mm_protocal_c_aib2;
                String cA = al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID);
                String d = eVar.jdO == 0 ? i.d(com_tencent_mm_protocal_c_aib) : eVar.jdO == 4 ? i.e(com_tencent_mm_protocal_c_aib) : eVar.jdO == 5 ? i.e(com_tencent_mm_protocal_c_aib) : i.c(com_tencent_mm_protocal_c_aib);
                if (!aSB.jiY.aI(i.ab(eVar.jdO, com_tencent_mm_protocal_c_aib.gID))) {
                    new b(aSB, i.ab(eVar.jdO, com_tencent_mm_protocal_c_aib.gID), cA + d, cA, com_tencent_mm_protocal_c_aib, eVar.jdO).l("");
                }
            }
        }
        this.jiO.remove(str);
    }

    public final void Ge() {
        if (!this.jiL) {
            return;
        }
        if (ad.aSn()) {
            aRJ();
        } else if (i.zV(ad.xq())) {
            int i = this.jiI;
            if (q.dpO > 0) {
                i = q.dpO;
            }
            if (this.caF.size() > 0 && ad.aSD().aSi() + this.jiN.size() <= r2) {
                v.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", new Object[]{Integer.valueOf(ad.aSD().aSi()), Integer.valueOf(this.jiN.size()), Integer.valueOf(this.caF.size()), Integer.valueOf(this.jiI)});
                f fVar = (f) this.caF.removeLast();
                aib com_tencent_mm_protocal_c_aib = fVar.boL;
                int i2 = fVar.requestType;
                String str = fVar.apU;
                if (!this.jiO.containsKey(str) || this.jiO.get(str) == null) {
                    this.jiO.remove(str);
                    return;
                }
                boolean z;
                String str2;
                int i3;
                Object obj;
                com.tencent.mm.plugin.sns.data.e eVar = ((com.tencent.mm.plugin.sns.data.c) this.jiO.get(str)).jdH;
                if (i2 == 1 || i2 == 5 || i2 == 7) {
                    z = true;
                    String str3 = com_tencent_mm_protocal_c_aib.mHP;
                    if (i2 == 7 && !be.kS(com_tencent_mm_protocal_c_aib.mHZ)) {
                        str3 = com_tencent_mm_protocal_c_aib.mHZ;
                    }
                    int i4 = com_tencent_mm_protocal_c_aib.mHQ;
                    if (be.kS(str3) && com_tencent_mm_protocal_c_aib.efm == 2) {
                        str2 = com_tencent_mm_protocal_c_aib.glb;
                        i3 = com_tencent_mm_protocal_c_aib.mHO;
                    } else {
                        i3 = i4;
                        str2 = str3;
                    }
                } else if (i2 == 6) {
                    z = false;
                    str2 = com_tencent_mm_protocal_c_aib.mHW;
                    i3 = com_tencent_mm_protocal_c_aib.mHO;
                } else {
                    z = false;
                    str2 = com_tencent_mm_protocal_c_aib.glb;
                    i3 = com_tencent_mm_protocal_c_aib.mHO;
                }
                if (str2 == null || str2.equals("")) {
                    v.d("MicroMsg.DownloadManager", "url  " + str2);
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    this.jiO.remove(str);
                } else if (i3 == 2) {
                    if (!ad.aSD().Ap(str)) {
                        v.d("MicroMsg.DownloadManager", "to downLoad scene " + com_tencent_mm_protocal_c_aib.gID + "  " + str2);
                        com.tencent.mm.model.ak.vy().a(new n(com_tencent_mm_protocal_c_aib, com_tencent_mm_protocal_c_aib.gID, str2, com_tencent_mm_protocal_c_aib.efm, z, i2, str), 0);
                        ad.aSD().Aq(str);
                    }
                } else if (i3 == 1 || i3 == 0) {
                    if (i3 == 0) {
                        v.e("MicroMsg.DownloadManager", "others http: urlType" + i3 + " -- url : " + str2 + " isThumb :" + z);
                    }
                    if (!this.jiN.containsKey(str)) {
                        v.d("MicroMsg.DownloadManager", "to downLoad cdn " + com_tencent_mm_protocal_c_aib.gID + "  " + str2);
                        if (!(com_tencent_mm_protocal_c_aib == null || i2 == 6 || !this.jiK.containsKey(str))) {
                            long longValue = ((Long) this.jiK.get(str)).longValue();
                            if (System.currentTimeMillis() - longValue < 300000) {
                                this.jiO.remove(str);
                                v.w("MicroMsg.DownloadManager", "download error pass " + longValue + " url " + str2 + " id: " + com_tencent_mm_protocal_c_aib.gID);
                                return;
                            }
                        }
                        this.jiN.put(str, Long.valueOf(be.Nh()));
                        if (i2 == 2) {
                            com.tencent.mm.model.ak.yW();
                            int a = be.a((Integer) com.tencent.mm.model.c.vf().get(68391, null), 0);
                            com.tencent.mm.model.ak.yW();
                            com.tencent.mm.model.c.vf().set(68391, Integer.valueOf(a + 1));
                        }
                        com.tencent.mm.plugin.sns.e.a.a aVar = new com.tencent.mm.plugin.sns.e.a.a(com_tencent_mm_protocal_c_aib.gID);
                        aVar.jfX = com_tencent_mm_protocal_c_aib;
                        aVar.jot = fVar.jdP;
                        if (i2 == 4) {
                            aVar.jor = true;
                        } else {
                            aVar.jor = false;
                        }
                        aVar.url = str2;
                        i = com_tencent_mm_protocal_c_aib.efm;
                        aVar.joq = z;
                        aVar.jos = i2;
                        aVar.jke = str;
                        aVar.jdH = eVar;
                        com.tencent.mm.plugin.sns.e.a.b bVar = null;
                        if (i2 == 1 || i2 == 5 || i2 == 7) {
                            bVar = new com.tencent.mm.plugin.sns.e.a.g(this, aVar);
                        } else if (i2 == 4) {
                            v.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
                            bVar = new com.tencent.mm.plugin.sns.e.a.f(this, aVar);
                        } else if (i2 == 2 || i2 == 3) {
                            bVar = new d(this, aVar);
                        } else if (i2 == 6) {
                            aVar.url = com_tencent_mm_protocal_c_aib.mHW;
                            aVar.aZy = com_tencent_mm_protocal_c_aib.mHY;
                            bVar = new com.tencent.mm.plugin.sns.e.a.c(this, aVar);
                        }
                        bVar.l("");
                    }
                } else {
                    this.jiO.remove(str);
                }
            }
        }
    }

    public final void a(int i, aib com_tencent_mm_protocal_c_aib, int i2, boolean z, String str, int i3) {
        if (ad.aSn() || !com.tencent.mm.model.ak.uz()) {
            aRJ();
            return;
        }
        this.jiH += i3;
        if (this.jiH > 512000 && this.caF.size() == 0) {
            v.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[]{Integer.valueOf(this.jiH)});
            com.tencent.mm.model.ab.a.csa.aC(this.jiH, 0);
            this.jiH = 0;
        }
        if (i == 1 || i == 3) {
            this.jiK.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        if (!(i == 3 || i != 1 || i2 == 3)) {
            g aSB = ad.aSB();
            v.d("MicroMsg.LazyerImageLoader2", "updateCache " + com_tencent_mm_protocal_c_aib.gID);
            n nVar = (n) aSB.jiY.get(i.ab(1, com_tencent_mm_protocal_c_aib.gID));
            if (i.b(nVar)) {
                nVar.wo();
                v.d("MicroMsg.LazyerImageLoader2", "force update");
                ad.aSr().post(new AnonymousClass9(aSB, com_tencent_mm_protocal_c_aib));
            }
        }
        for (b bVar : this.cbh) {
            if (bVar != null) {
                if (i != 2) {
                    if (i2 == 3) {
                        bVar.aRc();
                    } else if (i2 == 1 || i2 == 5 || i2 == 7) {
                        bVar.Aa(com_tencent_mm_protocal_c_aib.gID);
                    } else if (i2 == 2) {
                        bVar.ai(com_tencent_mm_protocal_c_aib.gID, true);
                    } else if (i2 == 4 || i2 == 6) {
                        bVar.aj(com_tencent_mm_protocal_c_aib.gID, true);
                    }
                } else if (i2 == 2) {
                    bVar.ai(com_tencent_mm_protocal_c_aib.gID, false);
                } else if (i2 == 4 || i2 == 6) {
                    bVar.aj(com_tencent_mm_protocal_c_aib.gID, false);
                }
            }
        }
        v.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s", new Object[]{str});
        this.jiN.remove(str);
        Ge();
        Af(str);
    }

    public final void Ag(final String str) {
        ad.aqz().post(new Runnable(this) {
            final /* synthetic */ b jiQ;

            public final void run() {
                b.a(this.jiQ, str);
                this.jiQ.Af(str);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
        if (kVar.getType() == 208) {
            n nVar = (n) kVar;
            if (i == 0 && i2 == 0) {
                if (kVar.getType() == 208) {
                    for (b bVar : this.cbh) {
                        if (bVar != null) {
                            if (nVar.jkc == 3) {
                                bVar.aRc();
                            } else if (nVar.jkc == 1 || nVar.jkc == 5 || nVar.jkc == 7) {
                                bVar.Aa(nVar.mediaId);
                            } else if (nVar.jkc == 2) {
                                bVar.ai(nVar.mediaId, true);
                            }
                        }
                    }
                }
            } else if (nVar.jkc == 2) {
                for (b bVar2 : this.cbh) {
                    if (bVar2 != null) {
                        bVar2.ai(nVar.mediaId, false);
                    }
                }
            }
        }
    }
}

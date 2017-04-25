package com.tencent.mm.ae;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class h implements e, f {
    private static Set<Integer> cME = new HashSet();
    private ah aVA = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ h cMJ;

        {
            this.cMJ = r1;
        }

        public final boolean oU() {
            try {
                h.e(this.cMJ);
            } catch (Throwable e) {
                v.e("MicroMsg.ImgService", "exception:%s", be.e(e));
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    private Queue<d> aVq = new LinkedList();
    private boolean aVu = false;
    private boolean aVv = false;
    int aVw = 0;
    private long aVx = 0;
    com.tencent.mm.compatible.util.g.a aVz = new com.tencent.mm.compatible.util.g.a();
    private LinkedList<k> cMF = new LinkedList();
    public a cMG = null;
    private boolean cMH = false;
    private com.tencent.mm.ae.k.a cMI = new com.tencent.mm.ae.k.a(this) {
        final /* synthetic */ h cMJ;

        {
            this.cMJ = r1;
        }

        public final void Gu() {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 cMK;

                {
                    this.cMK = r1;
                }

                public final void run() {
                    v.i("MicroMsg.ImgService", "on image upload end. queue size : " + this.cMK.cMJ.cMF.size());
                    this.cMK.cMJ.cMH = false;
                    if (this.cMK.cMJ.cMF.size() > 0) {
                        k kVar = (k) this.cMK.cMJ.cMF.poll();
                        v.i("MicroMsg.ImgService", "upload image scene hashcode : " + kVar.hashCode());
                        ak.vy().a(kVar, 0);
                        this.cMK.cMJ.cMH = true;
                    }
                }
            });
        }
    };

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ h cMJ;
        final /* synthetic */ d cMM;
        final /* synthetic */ int cMN;

        AnonymousClass6(h hVar, d dVar, int i) {
            this.cMJ = hVar;
            this.cMM = dVar;
            this.cMN = i;
        }

        public final void run() {
            ak.vy().a(new k((int) this.cMM.cLu, this.cMN, (byte) 0), 0);
        }
    }

    public interface a {
        void a(long j, int i, int i2);

        void b(long j, boolean z);
    }

    static /* synthetic */ void e(h hVar) {
        d dVar;
        hVar.aVx = System.currentTimeMillis();
        if (!hVar.aVu && hVar.aVq.size() == 0) {
            f GH = n.GH();
            Cursor rawQuery = GH.cuX.rawQuery(("select * " + " FROM ImgInfo2") + " WHERE iscomplete= 0 AND totalLen != 0 ", null);
            int count = rawQuery.getCount();
            v.d("MicroMsg.ImgInfoStorage", "getUnfinishInfo resCount:" + count);
            List list;
            if (count == 0) {
                rawQuery.close();
                list = null;
            } else {
                list = new ArrayList();
                for (int i = 0; i < count; i++) {
                    rawQuery.moveToPosition(i);
                    d dVar2 = new d();
                    dVar2.b(rawQuery);
                    d fD = GH.fD((int) dVar2.cLu);
                    if (fD != null) {
                        if (fD.bmL != 0 || fD.cLC != 0) {
                            list.add(dVar2);
                        }
                    } else if (dVar2.bmL != 0 || dVar2.cLC != 0) {
                        list.add(dVar2);
                    }
                }
                rawQuery.close();
            }
            if (r0 == null || r0.size() == 0) {
                v.i("MicroMsg.ImgService", "get need run info by search db, but size is 0.");
            } else {
                for (d dVar3 : r0) {
                    if (be.kS(dVar3.cLv)) {
                        v.i("MicroMsg.ImgService", "the process is killed while selecting pic");
                    } else {
                        d fD2 = n.GH().fD((int) dVar3.cLu);
                        if (cME.contains(Integer.valueOf(fD2 == null ? (int) dVar3.cLu : (int) fD2.cLu))) {
                            v.d("MicroMsg.ImgService", "File is Already running:" + dVar3.cLu);
                        } else {
                            if (fD2 != null) {
                                if (fD2.cLC > 0) {
                                    if (fD2.bmL <= 0) {
                                        if (dVar3.offset <= dVar3.cyu) {
                                            if (dVar3.status != -1) {
                                                if (fD2.status == -1) {
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (dVar3.cLC > 0 && dVar3.bmL <= 0 && dVar3.offset <= dVar3.cyu && dVar3.status != -1) {
                            }
                            if (((long) (dVar3.cLB + 600)) < be.Nh()) {
                                fG((int) dVar3.cLu);
                            } else {
                                hVar.aVq.add(dVar3);
                            }
                        }
                    }
                }
                hVar.aVq.size();
            }
        }
        if (hVar.aVu || hVar.aVq.size() > 0) {
            dVar3 = null;
            if (!hVar.aVu && hVar.aVq.size() > 0) {
                d fD3;
                while (hVar.aVq.size() > 0) {
                    dVar3 = (d) hVar.aVq.poll();
                    fD3 = n.GH().fD((int) dVar3.cLu);
                    if (cME.contains(Integer.valueOf(fD3 == null ? (int) dVar3.cLu : (int) fD3.cLu))) {
                        dVar3 = null;
                    }
                }
                hVar.aVu = true;
                if (dVar3 != null && dVar3.cLu > 0) {
                    k kVar;
                    fD3 = n.GH().fD((int) dVar3.cLu);
                    if (fD3 != null) {
                        v.d("MicroMsg.ImgService", "try upload hdinfo ");
                        kVar = new k((int) fD3.cLu, 1);
                    } else {
                        v.d("MicroMsg.ImgService", "try upload normalinfo ");
                        kVar = new k((int) dVar3.cLu, 0);
                    }
                    ak.vy().a(kVar, 0);
                    return;
                }
                return;
            }
            return;
        }
        hVar.pu();
        v.d("MicroMsg.ImgService", "No Data Any More , Stop Service");
    }

    public static boolean fE(int i) {
        return cME.add(Integer.valueOf(i));
    }

    public static boolean fF(int i) {
        return cME.remove(Integer.valueOf(i));
    }

    public h() {
        if (ak.vy() != null) {
            ak.vy().a((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (e) this);
        }
        this.cMF.clear();
        this.cMH = false;
    }

    public final void a(String str, String str2, ArrayList<String> arrayList, int i, boolean z) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            v.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", Boolean.valueOf(z), Integer.valueOf(com.tencent.mm.model.k.a(str3, str2, z) ? 1 : 0));
            a(new k(3, str, str2, str3, r6, this, i, this.cMI, 2130837922));
        }
    }

    public final void a(ArrayList<Integer> arrayList, String str, String str2, ArrayList<String> arrayList2, int i, boolean z) {
        Iterator it = arrayList2.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String str3 = (String) it.next();
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            int i3 = i2 + 1;
            int i4 = com.tencent.mm.model.k.a(str3, str2, z) ? 1 : 0;
            String str4 = SQLiteDatabase.KeyEmpty;
            d fC = n.GH().fC(intValue);
            if (fC != null) {
                str4 = fC.cLF;
            }
            k kVar = new k(intValue, 3, str, str2, str3, i4, (f) this, i, str4, SQLiteDatabase.KeyEmpty, 2130837922);
            kVar.cNq = new b(kVar, this.cMI);
            a(kVar);
            i2 = i3;
        }
    }

    private void a(final k kVar) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ h cMJ;

            public final void run() {
                v.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", Boolean.valueOf(this.cMJ.cMH), Integer.valueOf(kVar.hashCode()));
                if (this.cMJ.cMH) {
                    this.cMJ.cMF.offer(kVar);
                    return;
                }
                ak.vy().a(kVar, 0);
                this.cMJ.cMH = true;
            }
        });
    }

    public static void fG(int i) {
        v.w("MicroMsg.ImgService", "setImgError, %d", Integer.valueOf(i));
        d fC = n.GH().fC(i);
        if (fC != null && fC.cLu > 0) {
            at ek;
            d fD = n.GH().fD((int) fC.cLu);
            if (fD != null) {
                fD.dh(-1);
                fD.bkU = 264;
                n.GH().a((int) fD.cLu, fD);
                ak.yW();
                ek = c.wJ().ek(fD.cLC);
            } else {
                fC.dh(-1);
                fC.bkU = 264;
                n.GH().a(i, fC);
                ak.yW();
                ek = c.wJ().ek(fC.cLC);
            }
            if (ek.field_msgId == fC.cLC) {
                ek.dh(5);
                ak.yW();
                c.wJ().a((long) ((int) ek.field_msgId), ek);
            }
        }
    }

    public final void a(int i, int i2, String str, final k kVar) {
        v.d("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar instanceof k) {
            k kVar2 = (k) kVar;
            if (!(this.cMG == null || kVar2 == null || kVar2.aXd == null)) {
                this.cMG.b(kVar2.aXd.field_msgId, kVar2.aXd.field_status != 5);
            }
        }
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ h cMJ;

            public final void run() {
                if (kVar.getType() == MMGIFException.D_GIF_ERR_CLOSE_FAILED && (kVar instanceof k)) {
                    this.cMJ.aVu = false;
                    h.cME.remove(Integer.valueOf((int) ((k) kVar).cMQ));
                    if (this.cMJ.aVw > 0) {
                        h.e(this.cMJ);
                    } else {
                        this.cMJ.pu();
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    private void pu() {
        this.aVq.clear();
        this.aVv = false;
        v.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.aVz.sn());
    }

    public final void run() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ h cMJ;

            {
                this.cMJ = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.cMJ.aVx;
                if (this.cMJ.aVv) {
                    if (currentTimeMillis >= 60000) {
                        v.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + this.cMJ.aVv + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.cMJ.aVv);
                    } else {
                        return;
                    }
                }
                this.cMJ.aVv = true;
                this.cMJ.aVw = 3;
                this.cMJ.aVz.cgu = SystemClock.elapsedRealtime();
                this.cMJ.aVA.ea(10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final void a(int i, int i2, k kVar) {
        k kVar2 = (k) kVar;
        if (this.cMG != null && kVar2 != null && kVar2.aXd != null) {
            this.cMG.a(kVar2.aXd.field_msgId, i, i2);
        }
    }
}

package com.tencent.mm.ae;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import junit.framework.Assert;

public class m {
    private static m cNP;
    ConcurrentHashMap<Long, d> cNN = new ConcurrentHashMap();
    public c cNO = new c();
    public ConcurrentHashMap<Long, e> cNQ = new ConcurrentHashMap();
    public ArrayList<Long> cNR = new ArrayList();
    ArrayList<e> cNS = new ArrayList();

    public static class a {
        static ac aPK;
        private ReentrantLock aPI = new ReentrantLock();
        private Condition aPJ = this.aPI.newCondition();
        int cLy;
        a cNT;

        public static class a {
            String cLF;
            PString cNW;
            PString cNX;
            PString cNY;
            PString cNZ;
        }

        public static a a(final e eVar) {
            synchronized (a.class) {
                if (aPK == null) {
                    HandlerThread handlerThread = new HandlerThread("big file gen Worker");
                    handlerThread.start();
                    aPK = new ac(handlerThread.getLooper());
                }
            }
            a aVar = new a();
            eVar.cOp = aVar;
            aPK.post(new Runnable(eVar.cOp) {
                final /* synthetic */ a cNV;

                public final void run() {
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    a aVar = new a();
                    aVar.cNW = new PString();
                    aVar.cNX = new PString();
                    aVar.cNY = new PString();
                    aVar.cNZ = new PString();
                    aVar.cLF = n.GH().a(eVar.cOg, FileOp.jV(eVar.cOg), eVar.cLy, true, aVar.cNW, aVar.cNX, aVar.cNY, aVar.cNZ, eVar.cOi, eVar.cOn);
                    this.cNV.aPI.lock();
                    try {
                        this.cNV.cNT = aVar;
                        this.cNV.aPJ.signal();
                        v.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", eVar.cOg, Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
                    } finally {
                        this.cNV.aPI.unlock();
                    }
                }
            });
            aVar.cLy = eVar.cLy;
            return aVar;
        }

        public final a GA() {
            this.aPI.lock();
            while (this.cNT == null) {
                try {
                    v.i("MicroMsg.SendImgSpeeder", "getResult await");
                    this.aPJ.await();
                } catch (Exception e) {
                } finally {
                    this.aPI.unlock();
                }
            }
            return this.cNT;
        }
    }

    private static class b {
        com.tencent.mm.a.b cOa;
        String cOb;

        private b() {
        }
    }

    public static class c {
        public LinkedList<b> cOc = new LinkedList();
        public LinkedList<b> cOd = new LinkedList();

        public final synchronized void GB() {
            int i = 0;
            synchronized (this) {
                int size = this.cOc.size();
                if (size <= 0) {
                    int i2 = 5 - size;
                    for (size = 0; size < i2; size++) {
                        this.cOc.add(iZ(null));
                    }
                    v.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", Integer.valueOf(i2), Integer.valueOf(this.cOc.size()));
                    GC();
                }
                size = this.cOd.size();
                if (size <= 0) {
                    size = 5 - size;
                    while (i < size) {
                        this.cOd.add(ja(null));
                        i++;
                    }
                    GD();
                    v.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", Integer.valueOf(size), Integer.valueOf(this.cOd.size()));
                }
            }
        }

        public static b iZ(String str) {
            b bVar = new b();
            if (be.kS(str)) {
                bVar.cOb = f.Gs();
            } else {
                bVar.cOb = str;
            }
            String a = n.GH().a(bVar.cOb, SQLiteDatabase.KeyEmpty, ".jpg", false);
            if (!jb(a)) {
                return null;
            }
            bVar.cOa = new com.tencent.mm.a.b(a);
            return bVar;
        }

        public static b ja(String str) {
            b bVar = new b();
            if (be.kS(str)) {
                bVar.cOb = f.Gs();
            } else {
                bVar.cOb = str;
            }
            String a = n.GH().a("THUMBNAIL_DIRPATH://th_" + bVar.cOb, "th_", SQLiteDatabase.KeyEmpty, false);
            if (!jb(a)) {
                return null;
            }
            bVar.cOa = new com.tencent.mm.a.b(a);
            return bVar;
        }

        private static boolean jb(String str) {
            if (FileOp.jP(str) <= 0) {
                return true;
            }
            v.e("MicroMsg.SendImgSpeeder", "file has exist %s", str);
            return false;
        }

        public final synchronized b fJ(int i) {
            b bVar = null;
            synchronized (this) {
                if (i == 1) {
                    if (this.cOc.size() > 0) {
                        bVar = (b) this.cOc.remove();
                        GC();
                    } else {
                        bVar = iZ(null);
                    }
                } else if (i == 2) {
                    if (this.cOd.size() > 0) {
                        bVar = (b) this.cOd.remove();
                        GD();
                    } else {
                        bVar = ja(null);
                    }
                }
                GB();
            }
            return bVar;
        }

        private synchronized void GC() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.cOc.size(); i++) {
                stringBuilder.append(((b) this.cOc.get(i)).cOb);
                if (i != this.cOc.size() - 1) {
                    stringBuilder.append("-");
                }
            }
            v.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", stringBuilder.toString());
            ak.yW();
            com.tencent.mm.model.c.vf().set(348176, stringBuilder.toString());
        }

        private synchronized void GD() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.cOd.size(); i++) {
                stringBuilder.append(((b) this.cOd.get(i)).cOb);
                if (i != this.cOd.size() - 1) {
                    stringBuilder.append("-");
                }
            }
            v.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", stringBuilder.toString());
            ak.yW();
            com.tencent.mm.model.c.vf().set(348177, stringBuilder.toString());
        }
    }

    public static class d {
        public long cOe;
        public long cOf;
    }

    public static class e {
        public long bao;
        public int bbT;
        public int bha;
        public int cLy;
        public String cOg;
        public String cOh;
        public String cOi;
        public long cOj;
        PString cOk;
        PInt cOl;
        PInt cOm;
        public com.tencent.mm.a.b cOn;
        public com.tencent.mm.a.b cOo;
        public a cOp;
    }

    public static m Gy() {
        if (cNP == null) {
            synchronized (m.class) {
                if (cNP == null) {
                    cNP = new m();
                }
            }
        }
        return cNP;
    }

    public final boolean ak(long j) {
        return this.cNN.containsKey(Long.valueOf(j));
    }

    public final d al(long j) {
        return (d) this.cNN.get(Long.valueOf(j));
    }

    public final void a(ArrayList<String> arrayList, boolean z, int i, int i2, String str) {
        v.d("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg compressImg[%b], source[%d], stack[%s]", Boolean.valueOf(z), Integer.valueOf(i), be.bur());
        Iterator it = this.cNS.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (arrayList.contains(eVar.cOg)) {
                eVar.cLy = c(eVar.cOg, str, z);
            } else {
                it.remove();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() == 9) {
            f.oR(18);
        } else if (arrayList.size() == 1) {
            boolean isWifi = com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext());
            f.oR(25);
            if (isWifi) {
                if (k.a((String) arrayList.get(0), str, z)) {
                    f.oR(23);
                } else {
                    f.oR(21);
                }
            }
        } else {
            f.oR(24);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (str2 == null || str2.equals(SQLiteDatabase.KeyEmpty) || !com.tencent.mm.a.e.aR(str2)) {
                v.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
            } else if (o.JZ(str2)) {
                v.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", str2, Integer.valueOf(com.tencent.mm.a.e.aQ(str2)));
            } else if (!iY(str2)) {
                arrayList2.add(str2);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            a(i, i2, (String) it3.next(), str, z, 2130837922);
        }
        ArrayList arrayList3 = new ArrayList();
        ak.yW();
        long er = com.tencent.mm.model.c.wE().er(Thread.currentThread().getId());
        ak.yW();
        com.tencent.mm.model.c.wJ().MC("SendImgSpeeder");
        Object obj = 1;
        int i3 = 0;
        while (i3 < this.cNS.size()) {
            Object obj2;
            eVar = (e) this.cNS.get(i3);
            if (o.JZ(eVar.cOg)) {
                v.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
                obj2 = obj;
            } else {
                bx atVar = new at();
                atVar.setType(com.tencent.mm.model.m.fq(str));
                atVar.cH(str);
                atVar.di(1);
                atVar.dh(1);
                atVar.cI(eVar.cOk.value);
                atVar.dt(eVar.cOl.value);
                atVar.du(eVar.cOm.value);
                String zr = ax.zr();
                if (!(zr == null || zr.equals(atVar.bNo)) || (zr == null && atVar.bNo != null)) {
                    atVar.cN(zr);
                }
                if (com.tencent.mm.modelbiz.e.hC(atVar.field_talker)) {
                    atVar.cN(com.tencent.mm.modelbiz.a.e.zr());
                }
                atVar.z(aw.fN(atVar.field_talker));
                arrayList3.add(atVar);
                ak.yW();
                long R = com.tencent.mm.model.c.wJ().R(atVar);
                Assert.assertTrue(R >= 0);
                eVar.bao = R;
                this.cNQ.put(Long.valueOf(eVar.bao), eVar);
                this.cNR.add(Long.valueOf(eVar.bao));
                obj2 = null;
            }
            i3++;
            obj = obj2;
        }
        this.cNS.clear();
        if (er > 0) {
            ak.yW();
            com.tencent.mm.model.c.wE().es(er);
        }
        if (obj != null) {
            ak.yW();
            com.tencent.mm.model.c.wJ().MD("SendImgSpeeder");
        }
    }

    private boolean iY(String str) {
        Iterator it = this.cNS.iterator();
        while (it.hasNext()) {
            if (((e) it.next()).cOg.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean Gz() {
        if (this.cNS.size() <= 0 || com.tencent.mm.plugin.report.service.f.a.aKC().iud > 2) {
            return true;
        }
        v.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
        return false;
    }

    public final void a(int i, int i2, String str, String str2, boolean z, int i3) {
        if (!iY(str)) {
            com.tencent.mm.a.b bVar;
            com.tencent.mm.a.b bVar2;
            String str3;
            String str4;
            int c = c(str, str2, z);
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            if (Gz()) {
                b fJ = this.cNO.fJ(1);
                b fJ2 = this.cNO.fJ(2);
                com.tencent.mm.a.b bVar3 = fJ.cOa;
                bVar = fJ2.cOa;
                bVar2 = bVar3;
                str3 = fJ2.cOb;
                str4 = fJ.cOb;
            } else {
                bVar = null;
                bVar2 = null;
                str3 = null;
                str4 = null;
            }
            f GH = n.GH();
            if (FileOp.aR(str)) {
                String str5 = "THUMBNAIL_DIRPATH://th_" + (be.kS(str3) ? f.Gs() : str3);
                String a = GH.a(str5, "th_", SQLiteDatabase.KeyEmpty, false);
                pString.value = str5;
                long Nj = be.Nj();
                Bitmap a2 = GH.a(str, c, i2, pInt, pInt2, false, null, null);
                str5 = (String) GH.cMc.get(str);
                Object obj = str5 != null ? (Bitmap) GH.cMb.get(str5) : null;
                if (obj == null || obj.isRecycled()) {
                    obj = GH.a(str, true, com.tencent.mm.bd.a.getDensity(aa.getContext()), false, false, true, 2130837922, true, a2);
                    GH.cMc.put(str, a);
                }
                if (obj != null) {
                    GH.cMb.k(a, obj);
                }
                v.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", Long.valueOf(be.az(Nj)));
            } else {
                v.e("MicroMsg.ImgInfoStorage", "file not exit:%s", str);
            }
            e eVar = new e();
            eVar.cOg = str;
            eVar.cLy = c;
            eVar.bbT = i;
            eVar.bha = i2;
            eVar.cOh = str3;
            eVar.cOk = pString;
            eVar.cOm = pInt2;
            eVar.cOl = pInt;
            eVar.cOi = str4;
            eVar.cOo = bVar;
            eVar.cOn = bVar2;
            if (cNP.Gz()) {
                a.a(eVar);
            }
            this.cNS.add(eVar);
            v.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild", str);
        }
    }

    private static int c(String str, String str2, boolean z) {
        return k.a(str, str2, z) ? 1 : 0;
    }
}

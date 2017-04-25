package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.g;
import com.tencent.mm.storage.h;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.n;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.LinkedList;

public final class c {
    private static HashMap<Integer, com.tencent.mm.bg.g.c> bXq;
    public bh cqW;
    public bg cqX;
    public m cqY;
    private h cqZ;
    public n cra;
    private p crb;
    private am crc;
    private as crd;
    private com.tencent.mm.model.b.b cre;
    private com.tencent.mm.model.b.c crf;
    private g crg;
    private ao crh;
    private l cri;
    private j crj;

    public interface a {
        void a(c cVar, boolean z);

        void aH(boolean z);

        void xC();
    }

    static class b implements Runnable {
        String bmm;
        String crl;

        public b(String str, String str2) {
            this.bmm = str;
            this.crl = str2;
        }

        public final void run() {
            if (!be.kS(this.bmm) && !be.kS(this.crl)) {
                v.d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.bmm + " to :" + this.crl);
                if (f.sj() && this.crl.substring(0, e.cnj.length()).equals(e.cnj)) {
                    com.tencent.mm.sdk.platformtools.j.n(this.bmm + "image/", this.crl + "image/", true);
                    com.tencent.mm.sdk.platformtools.j.n(this.bmm + "image2/", this.crl + "image2/", true);
                    com.tencent.mm.sdk.platformtools.j.n(this.bmm + "avatar/", this.crl + "avatar/", true);
                    com.tencent.mm.sdk.platformtools.j.n(this.bmm + "video/", this.crl + "video/", true);
                    com.tencent.mm.sdk.platformtools.j.n(this.bmm + "voice/", this.crl + "voice/", true);
                    com.tencent.mm.sdk.platformtools.j.n(this.bmm + "voice2/", this.crl + "voice2/", true);
                    com.tencent.mm.sdk.platformtools.j.n(this.bmm + "package/", this.crl + "package/", true);
                    com.tencent.mm.sdk.platformtools.j.n(this.bmm + "emoji/", this.crl + "emoji/", true);
                    com.tencent.mm.sdk.platformtools.j.n(this.bmm + "mailapp/", this.crl + "mailapp/", true);
                    com.tencent.mm.sdk.platformtools.j.n(this.bmm + "brandicon/", this.crl + "brandicon/", true);
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, com.tencent.mm.bg.g gVar) {
        au azI = ((d) com.tencent.mm.kernel.g.f(d.class)).azI();
        azI.a(new aj(azI));
        com.tencent.mm.storage.e mVar = new m(azI);
        cVar.cqY = mVar;
        azI.a(mVar);
        mVar = new h(azI);
        cVar.cqZ = mVar;
        azI.a(mVar);
        ac wK = ((d) com.tencent.mm.kernel.g.f(d.class)).wK();
        cVar.cra = new n(wK);
        cVar.cqW = new bh(gVar, wK);
        cVar.cqX = new bg(gVar, ((d) com.tencent.mm.kernel.g.f(d.class)).wH());
        cVar.crc = new am(gVar);
        cVar.crd = new as(gVar);
        cVar.crb = new p(gVar);
        cVar.cre = new com.tencent.mm.model.b.b();
        cVar.crf = new com.tencent.mm.model.b.c();
        cVar.crg = new g(gVar);
        cVar.crh = new ao(gVar);
        cVar.cri = new l(gVar);
        cVar.crj = new j(gVar);
    }

    static /* synthetic */ String xA() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cjZ).append("locallog").toString();
    }

    public c() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.e vw = com.tencent.mm.kernel.g.vw();
        vw.cjV.ay(new com.tencent.mm.bg.g.a(this) {
            final /* synthetic */ c crk;

            {
                this.crk = r1;
            }

            public final void vl() {
                com.tencent.mm.modelstat.l Km = com.tencent.mm.modelstat.p.Km();
                if (Km != null) {
                    v.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: " + Km);
                    long currentTimeMillis = System.currentTimeMillis();
                    Km.ddn.iy(true);
                    v.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
            }

            public final void vm() {
            }

            public final void vn() {
            }
        });
        com.tencent.mm.kernel.g.vx();
        vw = com.tencent.mm.kernel.g.vw();
        vw.cjU.ay(new com.tencent.mm.kernel.api.d(this) {
            final /* synthetic */ c crk;

            {
                this.crk = r1;
            }

            public final void aM(boolean z) {
                if (z) {
                    com.tencent.mm.p.c.us().s(262145, false);
                    com.tencent.mm.p.c.us().s(262146, true);
                }
            }

            public final void a(com.tencent.mm.bg.g gVar, com.tencent.mm.bg.g gVar2) {
                c.a(this.crk, gVar);
            }

            public final void vo() {
                ak.yP().aH(f.sj());
                ak.yV();
            }

            public final void dU(String str) {
                String[] strArr = new String[]{str, c.wP(), c.xa(), c.wQ(), c.wR(), c.wY(), c.xA(), c.wZ(), c.wT(), c.wU(), c.getAccVideoPath(), c.xb(), c.xc(), c.xd(), c.xe(), c.xm(), c.wS()};
                for (int i = 0; i < 17; i++) {
                    File file = new File(strArr[i]);
                    if (!(file.exists() || (file.mkdirs() && file.isDirectory()))) {
                        v.e("MicroMsg.FileOperation", "batchMkDirs mkdir error. %s", r3);
                    }
                }
                if (f.sj()) {
                    com.tencent.mm.kernel.g.vx();
                    if (com.tencent.mm.kernel.g.vw().cjZ.equals(e.cnj)) {
                        com.tencent.mm.kernel.g.vx();
                        com.tencent.mm.sdk.i.e.a(new b(com.tencent.mm.kernel.g.vw().cachePath, str), "AccountStorage_moveDataFiles");
                    }
                }
            }
        });
        com.tencent.mm.kernel.g vx = com.tencent.mm.kernel.g.vx();
        vx.ckL.ay(new com.tencent.mm.kernel.api.b(this) {
            final /* synthetic */ c crk;

            {
                this.crk = r1;
            }

            public final void th() {
                ak.yP().zU();
            }
        });
        com.tencent.mm.kernel.g.vx();
        vw = com.tencent.mm.kernel.g.vw();
        AnonymousClass10 anonymousClass10 = new com.tencent.mm.kernel.api.a(this) {
            final /* synthetic */ c crk;

            {
                this.crk = r1;
            }

            public final HashMap<Integer, com.tencent.mm.bg.g.c> vD() {
                HashMap<Integer, com.tencent.mm.bg.g.c> hashMap = new HashMap();
                hashMap.putAll(c.bXq);
                hashMap.putAll(ak.yP().zV());
                return hashMap;
            }
        };
        synchronized (vw.cjX) {
            vw.cjX.add(anonymousClass10);
        }
    }

    public static int ww() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vu().uin;
    }

    public static String wx() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vw().cjZ;
    }

    public static void vh() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vw().vh();
    }

    public static boolean wy() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.e vw = com.tencent.mm.kernel.g.vw();
        if (vw.ckj == null) {
            vw.ckj = Boolean.valueOf(vw.isSDCardAvailable());
        } else {
            long currentTimeMillis = System.currentTimeMillis() - vw.ckl;
            if (currentTimeMillis <= 0 || currentTimeMillis >= 1000) {
                if (vw.cki == null) {
                    vw.cki = new com.tencent.mm.sdk.platformtools.ac(com.tencent.mm.kernel.g.vA().htb.getLooper());
                }
                vw.cki.removeCallbacksAndMessages(null);
                vw.cki.postDelayed(vw.ckk, 1000);
                vw.ckl = System.currentTimeMillis();
            }
        }
        return vw.ckj.booleanValue();
    }

    public static boolean isSDCardAvailable() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vw().isSDCardAvailable();
    }

    public static boolean wz() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.e vw = com.tencent.mm.kernel.g.vw();
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        Object obj = (be.ma((String) vw.ckd.get(8195, null)).length() <= 0 || be.f((Integer) vw.ckd.get(15, null)) == 0) ? 1 : null;
        return (obj == null || vw.vd() == null) ? false : true;
    }

    public static String vd() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vw().vd();
    }

    public static void wA() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.e vw = com.tencent.mm.kernel.g.vw();
        File file = new File(vw.cachePath, "EnMicroMsg.db~");
        if (file.isFile()) {
            file.renameTo(new File(vw.cachePath, "EnMicroMsg.db~~"));
        }
        file = new File(vw.cachePath, "EnMicroMsg.db.sm");
        if (file.isFile()) {
            file.delete();
        }
        for (File delete : new File(vw.cachePath).listFiles(new FilenameFilter(vw) {
            final /* synthetic */ e ckm;

            {
                this.ckm = r1;
            }

            public final boolean accept(File file, String str) {
                return str.startsWith("EnMicroMsg.dberr");
            }
        })) {
            delete.delete();
        }
    }

    public static void wB() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vw().cQ(null);
    }

    public static void a(af afVar) {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.a vu = com.tencent.mm.kernel.g.vu();
        if (vu.cju == null) {
            vu.cju = new LinkedList();
        } else {
            vu.cju.add(afVar);
        }
    }

    public static void b(af afVar) {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.a vu = com.tencent.mm.kernel.g.vu();
        if (vu.cju == null) {
            v.w("MMKernel.CoreAccount", "userStatusChangeListeners == null");
        } else {
            vu.cju.remove(afVar);
        }
    }

    public static void uI() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uI();
    }

    public static boolean wC() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.a.eB(com.tencent.mm.kernel.g.vu().cjs);
    }

    public static boolean eB(int i) {
        return com.tencent.mm.kernel.a.eB(i);
    }

    public static int wD() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vu().cjt;
    }

    public static com.tencent.mm.bg.g wE() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vw().ckb;
    }

    public static com.tencent.mm.bg.g wF() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vw().ckc;
    }

    public static SharedPreferences dT(String str) {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vw().dT(str);
    }

    public static r vf() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vw().vf();
    }

    public static az vg() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vw().vg();
    }

    public static com.tencent.mm.ak.r wG() {
        return ((d) com.tencent.mm.kernel.g.f(d.class)).wG();
    }

    public static aa wH() {
        return ((d) com.tencent.mm.kernel.g.f(d.class)).wH();
    }

    public static bb wI() {
        return ((d) com.tencent.mm.kernel.g.f(d.class)).wI();
    }

    public static au wJ() {
        return ((d) com.tencent.mm.kernel.g.f(d.class)).azI();
    }

    public static ac wK() {
        return ((d) com.tencent.mm.kernel.g.f(d.class)).wK();
    }

    public final am wL() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return this.crc;
    }

    public final as wM() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return this.crd;
    }

    public static ay wN() {
        return ((d) com.tencent.mm.kernel.g.f(d.class)).wN();
    }

    public final p wO() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return this.crb;
    }

    public static String wP() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("image/").toString();
    }

    public static String wQ() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("image2/").toString();
    }

    public static String wR() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("avatar/").toString();
    }

    public static String wS() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("remark/").toString();
    }

    public static String wT() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("voice/").toString();
    }

    public static String wU() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("voice2/").toString();
    }

    public static String wV() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("recbiz/").toString();
    }

    public static String wW() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("favorite/").toString();
    }

    public static String wX() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("speextemp/").toString();
    }

    public static String wY() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("emoji/").toString();
    }

    public static String wZ() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("mailapp/").toString();
    }

    public static String getAccVideoPath() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("video/").toString();
    }

    public static String xa() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("image/shakeTranImg/").toString();
    }

    public static String xb() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("package/").toString();
    }

    public static String xc() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("openapi/").toString();
    }

    public static String xd() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("attachment/").toString();
    }

    public static String xe() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("brandicon/").toString();
    }

    public static String xf() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("record/").toString();
    }

    public static String xg() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cka).append("draft/").toString();
    }

    public static String xh() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(xq()).append("sns/").toString();
    }

    public static String xi() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(xq()).append("sns/temp/").toString();
    }

    public static String xj() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(xq()).append("sfs").toString();
    }

    public static String xk() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(xq()).append("voiceremind/").toString();
    }

    public static String xl() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(xq()).append("wenote/").toString();
    }

    public static String xm() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cachePath).append("logcat/").toString();
    }

    public static String xn() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cachePath).append("MicroMsg.db").toString();
    }

    public static String xo() {
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.vx();
        return stringBuilder.append(com.tencent.mm.kernel.g.vw().cachePath).append("EnMicroMsg.db").toString();
    }

    public static String xp() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vw().cachePath;
    }

    public static String xq() {
        com.tencent.mm.kernel.g.vx();
        return com.tencent.mm.kernel.g.vw().cka;
    }

    public final void xr() {
        StringBuilder stringBuilder = new StringBuilder("mm");
        com.tencent.mm.kernel.g.vx();
        String m = com.tencent.mm.a.g.m(stringBuilder.append(com.tencent.mm.kernel.g.vu().uin).toString().getBytes());
        String str = t.cng + m + "/";
        String str2 = e.cnj + m + "/";
        for (String str3 : new File(str).list(new FilenameFilter(this) {
            final /* synthetic */ c crk;

            {
                this.crk = r1;
            }

            public final boolean accept(File file, String str) {
                return str.equals("EnMicroMsg.db") || str.startsWith("EnMicroMsg.dberr") || str.equals("IndexMicroMsg.db");
            }
        })) {
            String str4 = str2 + str3 + ".dump";
            FileOp.deleteFile(str4);
            FileOp.p(str + str3, str4);
            v.i("MicroMsg.AccountStorage", "Exported: " + str4);
        }
    }

    public static void xs() {
        StringBuilder stringBuilder = new StringBuilder("mm");
        com.tencent.mm.kernel.g.vx();
        String m = com.tencent.mm.a.g.m(stringBuilder.append(com.tencent.mm.kernel.g.vu().uin).toString().getBytes());
        String str = t.cng + m + "/";
        m = e.cnj + m + "/dump_logcat/";
        com.tencent.mm.a.e.e(new File(m));
        com.tencent.mm.sdk.platformtools.j.n(str + "logcat/", m, false);
    }

    public static void ed(int i) {
        ak.yP().eW(i);
        if ((i & 16) != 0) {
            aw.a("medianote", null);
            ak.yW();
            wK().Mf("medianote");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return aj.cic;
            }
        });
        bXq.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return m.cic;
            }
        });
        bXq.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return h.cic;
            }
        });
        bXq.put(Integer.valueOf("CHATROOM_MEMBERS_TABLE".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return p.cic;
            }
        });
        bXq.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return as.cic;
            }
        });
        bXq.put(Integer.valueOf("FILEDOWNLOAD_TABLE".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return am.cic;
            }
        });
        bXq.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return g.cic;
            }
        });
        bXq.put(Integer.valueOf("GetSysCmdMsgInfo".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return ao.cic;
            }
        });
        bXq.put(Integer.valueOf("BackupPcRecoverTagInfo".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return l.cic;
            }
        });
        bXq.put(Integer.valueOf("BackupPcRecoverSessionInfo".hashCode()), new com.tencent.mm.bg.g.c() {
            public final String[] pS() {
                return j.cic;
            }
        });
    }

    public final com.tencent.mm.model.b.b xt() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return this.cre;
    }

    public final com.tencent.mm.model.b.c xu() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return this.crf;
    }

    public final g xv() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return this.crg;
    }

    public static af xw() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return ((d) com.tencent.mm.kernel.g.f(d.class)).xw();
    }

    public final ao xx() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return this.crh;
    }

    public final l xy() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return this.cri;
    }

    public final j xz() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vu().uH();
        return this.crj;
    }
}

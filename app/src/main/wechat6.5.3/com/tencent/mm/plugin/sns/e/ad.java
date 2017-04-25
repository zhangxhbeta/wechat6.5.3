package com.tencent.mm.plugin.sns.e;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Point;
import android.os.Looper;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.bg.g;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.aw;
import com.tencent.mm.e.a.bq;
import com.tencent.mm.e.a.br;
import com.tencent.mm.e.a.bs;
import com.tencent.mm.e.a.ga;
import com.tencent.mm.e.a.gq;
import com.tencent.mm.e.a.ic;
import com.tencent.mm.e.a.je;
import com.tencent.mm.e.a.jx;
import com.tencent.mm.e.a.lf;
import com.tencent.mm.e.a.lk;
import com.tencent.mm.e.a.lq;
import com.tencent.mm.e.a.ni;
import com.tencent.mm.e.a.nl;
import com.tencent.mm.e.a.nt;
import com.tencent.mm.e.a.oa;
import com.tencent.mm.e.a.or;
import com.tencent.mm.e.a.pl;
import com.tencent.mm.e.a.px;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.a.i;
import com.tencent.mm.plugin.sns.e.ak.a;
import com.tencent.mm.plugin.sns.f.e;
import com.tencent.mm.plugin.sns.lucky.b.o;
import com.tencent.mm.plugin.sns.lucky.b.s;
import com.tencent.mm.plugin.sns.lucky.b.u;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.ui.af;
import com.tencent.mm.pluginsdk.j.q.f;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ad implements ag, f {
    private static Point jgb = new Point();
    private static int jlB;
    private static int jlC;
    private static String jlX = "";
    protected static HashMap<Integer, c> jlY = new HashMap();
    private static ad jlt = null;
    public static boolean jlu = true;
    private static int jlv = 0;
    private static int jlw = 0;
    private static int jmg = 103;
    private byte[] cGJ = new byte[0];
    private g ckb;
    private String cyY;
    private boolean fKp = false;
    private com.tencent.mm.sdk.c.c hDj = new com.tencent.mm.sdk.c.c<ic>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = ic.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ic icVar = (ic) bVar;
            if (icVar instanceof ic) {
                switch (icVar.bhZ.action) {
                    case -6:
                        List<k> ap = ad.aSE().ap(icVar.bhZ.bib.mKm, com.tencent.mm.model.k.xF().equals(icVar.bhZ.bib.mKm));
                        icVar.bia.bed = new ArrayList();
                        for (k aUp : ap) {
                            icVar.bia.bed.add(com.tencent.mm.ai.b.a(ad.xq(), aUp.aUp(), 8));
                        }
                        break;
                    case -5:
                        l aSE = ad.aSE();
                        Cursor rawQuery = aSE.cie.rawQuery("select *,rowid from SnsInfo where type = 4 AND  (sourceType & 2 != 0 ) " + l.jBY, null);
                        List<k> arrayList = new ArrayList();
                        while (rawQuery != null && rawQuery.moveToNext()) {
                            k kVar = new k();
                            kVar.b(rawQuery);
                            arrayList.add(kVar);
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        icVar.bia.bed = new ArrayList();
                        for (k aUp2 : arrayList) {
                            icVar.bia.bed.add(com.tencent.mm.ai.b.a(ad.xq(), aUp2.aUp(), 1));
                        }
                        break;
                }
            }
            return false;
        }
    };
    private ac handler = new ac(Looper.getMainLooper());
    private ac jlA = null;
    private p jlD;
    private l jlE;
    private d jlF;
    private g jlG;
    private j jlH;
    private h jlI;
    private r jlJ;
    private aa jlK;
    private a jlL;
    private b jlM;
    private at jlN;
    private af jlO;
    private com.tencent.mm.plugin.sns.f.c jlP;
    private com.tencent.mm.plugin.sns.f.g jlQ;
    private n jlR;
    private i jlS;
    private boolean jlT = true;
    private t jlU = new t();
    private boolean jlV = false;
    private byte[] jlW = new byte[0];
    private com.tencent.mm.plugin.sns.c jlZ;
    private ac[] jlx = new ac[3];
    private ac[] jly = new ac[1];
    private ac jlz = null;
    private com.tencent.mm.sdk.c.c jmA = new com.tencent.mm.sdk.c.c<lf>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = lf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            SnsAdClick snsAdClick = ((lf) bVar).bmA.bmB;
            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(snsAdClick.cZv, snsAdClick.cZy, snsAdClick.scene, "", snsAdClick.cZA), 0);
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmB = new com.tencent.mm.sdk.c.c<bs>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = bs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ad.aSQ();
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmC = new com.tencent.mm.sdk.c.c<bq>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = bq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            e.AV("100004");
            e.AV("100007");
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmD = new com.tencent.mm.sdk.c.c<pl>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = pl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            v.i("MicroMsg.SnsCore", "triger snslogmgr try report");
            this.jmK.jlS.aQW();
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmE = new com.tencent.mm.sdk.c.c<ni>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = ni.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ah.aSW();
            ad.aSE().cie.dF("SnsInfo", "delete from SnsInfo");
            ad.aSG().Br("@__weixintimtline");
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmF = new com.tencent.mm.sdk.c.c<lk>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = lk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            lk lkVar = (lk) bVar;
            SnsAdClick snsAdClick = lkVar.bmN.bmB;
            if (lkVar.bmN.bmO == 1) {
                com.tencent.mm.modelsns.a gi;
                if (snsAdClick.cZB == 1) {
                    ad.aSy().h(13155, com.tencent.mm.plugin.sns.data.i.cE(snsAdClick.cZw), snsAdClick.cZx, Integer.valueOf(snsAdClick.scene), Long.valueOf(snsAdClick.cZz), Long.valueOf(System.currentTimeMillis()));
                    gi = com.tencent.mm.modelsns.a.gi(750);
                    gi.kj(com.tencent.mm.plugin.sns.data.i.cE(snsAdClick.cZw)).kj(snsAdClick.cZx).gk(snsAdClick.scene).kj(snsAdClick.cZz).kj(System.currentTimeMillis());
                    gi.JF();
                } else {
                    i aSy = ad.aSy();
                    Object[] objArr = new Object[1];
                    objArr[0] = com.tencent.mm.plugin.sns.a.a.f.a(snsAdClick.cZw, com.tencent.mm.plugin.sns.data.i.cE(snsAdClick.cZw), snsAdClick.cZx, Integer.valueOf(snsAdClick.scene), Long.valueOf(snsAdClick.cZz), Long.valueOf(System.currentTimeMillis()));
                    aSy.h(12013, objArr);
                    gi = com.tencent.mm.modelsns.a.gi(733);
                    gi.kj(com.tencent.mm.plugin.sns.data.i.cE(snsAdClick.cZw)).kj(snsAdClick.cZx).gk(snsAdClick.scene).kj(snsAdClick.cZz).kj(System.currentTimeMillis());
                    gi.JF();
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmG = new com.tencent.mm.sdk.c.c<oa>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = oa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return AnonymousClass25.aSR();
        }

        private static boolean aSR() {
            o.aRh();
            com.tencent.mm.storage.t.a aVar = com.tencent.mm.storage.t.a.nrV;
            com.tencent.mm.plugin.sns.g.i iVar = new com.tencent.mm.plugin.sns.g.i();
            try {
                ak.yW();
                com.tencent.mm.model.c.vf().a(aVar, new String(iVar.toByteArray(), Charset.forName("ISO-8859-1")));
            } catch (IOException e) {
                v.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + e.getLocalizedMessage());
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmH = new com.tencent.mm.sdk.c.c<aw>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = aw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            j aSG = ad.aSG();
            System.currentTimeMillis();
            boolean dF = aSG.cie.dF("snsExtInfo3", "update snsExtInfo3 set md5 = '', faults = '';");
            v.i("MicroMsg.SnsExtStorage", "clean Error sql %s ret  %s", new Object[]{"update snsExtInfo3 set md5 = '', faults = '';", Boolean.valueOf(dF)});
            return false;
        }
    };
    private boolean jmI = false;
    private com.tencent.mm.sdk.c.c jmJ = new com.tencent.mm.sdk.c.c<nt>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = nt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nt ntVar = (nt) bVar;
            if (ntVar instanceof nt) {
                com.tencent.mm.plugin.sns.lucky.b.b.kZ(ntVar.boO.key);
            }
            return false;
        }
    };
    private com.tencent.mm.plugin.sns.d.a jma;
    private ao jmb;
    private com.tencent.mm.plugin.sns.lucky.b.n jmc = new com.tencent.mm.plugin.sns.lucky.b.n();
    private s jmd = new s();
    private com.tencent.mm.plugin.sns.lucky.b.l jme = new com.tencent.mm.plugin.sns.lucky.b.l();
    private u jmf = new u();
    private com.tencent.mm.plugin.sns.k jmh;
    private com.tencent.mm.plugin.sns.j jmi;
    private com.tencent.mm.plugin.sns.h jmj;
    private com.tencent.mm.plugin.sns.d jmk;
    private com.tencent.mm.plugin.sns.f jml;
    private com.tencent.mm.plugin.sns.i jmm;
    private com.tencent.mm.plugin.sns.g jmn;
    private com.tencent.mm.plugin.sns.a jmo;
    private com.tencent.mm.plugin.sns.b jmp;
    private com.tencent.mm.plugin.sns.e jmq;
    private com.tencent.mm.sdk.c.c jmr = new com.tencent.mm.sdk.c.c<jx>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = jx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            boolean z = true;
            int i = com.tencent.mm.h.j.sU().getInt("SnsHEVCSwitch", 0);
            int i2 = com.tencent.mm.h.j.sU().getInt("SnsWXPCSwitch", 0);
            boolean z2 = i == 1;
            if (i2 != 1) {
                z = false;
            }
            Editor edit = aj.aX(aa.getContext(), "sp_sns_dynswitch_stg").edit();
            edit.putBoolean("sw_use_vcodec_img", z2);
            edit.putBoolean("sw_use_wxpc_img", z);
            edit.commit();
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jms = new com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.f>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = com.tencent.mm.e.a.f.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            String str = ((com.tencent.mm.e.a.f) bVar).aWs.aWt;
            if (!be.kS(str)) {
                a.Ae(str);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmt = new com.tencent.mm.sdk.c.c<br>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = br.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ak.yW();
            String xp = com.tencent.mm.model.c.xp();
            ak.yW();
            String wx = com.tencent.mm.model.c.wx();
            v.i("MicroMsg.SnsCore", "dump %s", new Object[]{wx});
            xp = xp + "SnsMicroMsg.db";
            FileOp.deleteFile(wx + "sns.dump");
            FileOp.p(xp, wx + "sns.dump");
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmu = new com.tencent.mm.sdk.c.c<or>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = or.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final or orVar = (or) bVar;
            if (orVar.bpY.bdf != 9 && orVar.bpY.bdf == 7) {
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass11 jmN;

                    public final void run() {
                        int i = (int) orVar.bpY.bqa;
                        h aSH = ad.aSH();
                        String str = " update SnsComment set isRead = 1 where isRead = 0 and  createTime <= " + i;
                        v.i("MicroMsg.SnsCommentStorage", "updateToread " + str);
                        v.i("MicroMsg.SnsCore", "update msg read " + aSH.cuX.dF("SnsComment", str));
                        r.aSa();
                    }
                });
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmv = new com.tencent.mm.sdk.c.c<gq>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = gq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ((gq) bVar).bgh.bgi = ad.aSJ().aWl();
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmw = new com.tencent.mm.sdk.c.c<ga>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = ga.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ((ga) bVar).bfB.bfC = ad.aSE().aVa();
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmx = new com.tencent.mm.sdk.c.c<je>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = je.class.getName().hashCode();
        }

        private static boolean a(je jeVar) {
            ArrayList arrayList = jeVar.bjK.bfC;
            l aSE = ad.aSE();
            g wE = ad.wE();
            long auU = wE.auU();
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    long longValue = ((Long) it.next()).longValue();
                    k qG = aSE.qG((int) longValue);
                    if (qG != null) {
                        qG.field_localFlag |= 64;
                        v.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[]{Long.valueOf(longValue)});
                        aSE.b((int) longValue, qG);
                    }
                }
                return false;
            } finally {
                wE.es(auU);
            }
        }
    };
    private com.tencent.mm.sdk.c.c jmy = new com.tencent.mm.sdk.c.c<lq>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = lq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final long j = (long) ((lq) bVar).bmT.bmU;
            v.d("MicroMsg.SnsCore", "try resend msg for SnsInfoId:%d", new Object[]{Long.valueOf(j)});
            com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass16 jmP;

                public final void run() {
                    ah.qf((int) j);
                    ad.aSA().aTe();
                    com.tencent.mm.sdk.c.a.nhr.z(new px());
                }
            });
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jmz = new com.tencent.mm.sdk.c.c<nl>(this) {
        final /* synthetic */ ad jmK;

        {
            this.jmK = r2;
            this.nhz = nl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ad.c(this.jmK);
            return false;
        }
    };

    class AnonymousClass5 extends com.tencent.mm.memory.e.a {
        final /* synthetic */ ad jmK;
        final int jmL = 120;

        AnonymousClass5(ad adVar, com.tencent.mm.memory.c cVar) {
            this.jmK = adVar;
            cVar.getClass();
            super(cVar);
        }

        public final /* synthetic */ Comparable wf() {
            return Integer.valueOf(com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 120) * com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 120));
        }

        public final long wg() {
            return 10485760;
        }

        public final int wh() {
            return -1;
        }
    }

    class AnonymousClass6 extends com.tencent.mm.memory.e.a {
        final /* synthetic */ ad jmK;

        AnonymousClass6(ad adVar, com.tencent.mm.memory.o oVar) {
            this.jmK = adVar;
            oVar.getClass();
            super(oVar);
        }

        public final /* synthetic */ Comparable wf() {
            return new com.tencent.mm.memory.o.b(320, 240);
        }

        public final long wg() {
            return -1;
        }

        public final int wh() {
            return 3;
        }
    }

    class AnonymousClass7 extends com.tencent.mm.memory.e.a {
        final /* synthetic */ ad jmK;

        AnonymousClass7(ad adVar, com.tencent.mm.memory.g gVar) {
            this.jmK = adVar;
            gVar.getClass();
            super(gVar);
        }

        public final /* synthetic */ Comparable wf() {
            return Integer.valueOf(1024);
        }

        public final long wg() {
            return 0;
        }

        public final int wh() {
            return 5;
        }
    }

    static /* synthetic */ void aSQ() {
        v.i("MicroMsg.SnsCore", "dumptable");
        StringBuffer stringBuffer = new StringBuffer();
        l aSE = aSE();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = aSE.cie.rawQuery("select count(*) from SnsInfo", null);
        int i = rawQuery.moveToFirst() ? rawQuery.getInt(0) : 0;
        rawQuery.close();
        v.i("MicroMsg.SnsInfoStorage", "sns table count %d passed %d", new Object[]{Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        p aSt = aSt();
        long currentTimeMillis2 = System.currentTimeMillis();
        Cursor rawQuery2 = aSt.cuX.rawQuery("select count(*) from SnsMedia", null);
        int i2 = rawQuery2.moveToFirst() ? rawQuery2.getInt(0) : 0;
        rawQuery2.close();
        v.i("MicroMsg.snsMediaStorage", "media table count %d passed %d", new Object[]{Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        j aSG = aSG();
        currentTimeMillis2 = System.currentTimeMillis();
        rawQuery = aSG.cie.rawQuery("select count(*) from snsExtInfo3", null);
        int i3 = rawQuery.moveToFirst() ? rawQuery.getInt(0) : 0;
        rawQuery.close();
        v.i("MicroMsg.SnsExtStorage", "ext table count %d passed %d", new Object[]{Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        stringBuffer.append(" snscount " + i);
        stringBuffer.append(" mediacount " + i2);
        stringBuffer.append(" extcount " + i3);
        v.i("MicroMsg.SnsCore", "dump table " + stringBuffer.toString());
    }

    static /* synthetic */ void c(ad adVar) {
        if (!adVar.jmI) {
            aSm().jlA.post(new Runnable(adVar) {
                final /* synthetic */ ad jmK;

                {
                    this.jmK = r1;
                }

                public final void run() {
                    ad.e(this.jmK);
                }
            });
        }
    }

    static /* synthetic */ String e(ad adVar) {
        if (adVar.jmI) {
            return "";
        }
        adVar.jmI = true;
        ak.yW();
        File[] listFiles = new File(com.tencent.mm.model.c.xh()).listFiles();
        v.i("MicroMsg.SnsCore", "snscheckfile start");
        long j = 0;
        for (File listFiles2 : listFiles) {
            File[] listFiles3 = listFiles2.listFiles();
            if (listFiles3 != null) {
                for (int i = 0; i < listFiles3.length; i++) {
                    String[] list = listFiles3[i].list();
                    if (list != null) {
                        File[] listFiles4 = listFiles3[i].listFiles();
                        if (listFiles4 != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            long j2 = j;
                            for (File file : listFiles4) {
                                j2 += file.length();
                                String str = file.getAbsolutePath() + " " + file.length() + " " + file.lastModified() + " " + ((String) DateFormat.format("yyyy-M-d kk:mm", file.lastModified()));
                                stringBuffer.append(str + "\r\n");
                                v.i("MicroMsg.SnsCore", str);
                            }
                            int length = list.length;
                            v.i("MicroMsg.SnsCore", "filepath %s %d", new Object[]{listFiles3[i].getAbsolutePath(), Integer.valueOf(length)});
                            j = j2;
                        }
                    }
                }
            }
        }
        v.i("MicroMsg.SnsCore", "snscheckfile end " + j);
        adVar.jmI = false;
        return "";
    }

    static {
        jlY.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return p.cic;
            }
        });
        jlY.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return l.cic;
            }
        });
        jlY.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return l.cic;
            }
        });
        jlY.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return d.cic;
            }
        });
        jlY.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return j.cic;
            }
        });
        jlY.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return h.cic;
            }
        });
        jlY.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return r.cic;
            }
        });
        jlY.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return n.cic;
            }
        });
    }

    public static String xq() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        ak.yW();
        return com.tencent.mm.model.c.xq();
    }

    public static String aSk() {
        ak.yW();
        return (String) com.tencent.mm.model.c.vf().get(2, null);
    }

    public static int aSl() {
        ak.yW();
        return com.tencent.mm.model.c.ww();
    }

    public static g wE() {
        return aSm().ckb;
    }

    private static ad aSm() {
        ad adVar = (ad) ak.yP().fY("plugin.sns");
        jlt = adVar;
        if (adVar == null) {
            jlt = new ad();
            ak.yP().a("plugin.sns", jlt);
        }
        if (!jlt.jlV) {
            synchronized (jlt.jlW) {
                if (!jlt.jlV) {
                    v.i("MicroMsg.SnsCore", "onAccInit because bug!");
                    jlt.aG(true);
                }
            }
        }
        if (jlt.fKp) {
            synchronized (jlt.cGJ) {
                v.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + jlt.hashCode());
                if (jlt.fKp) {
                    jlt.jlT = false;
                    t tVar = jlt.jlU;
                    HashMap hashMap = jlY;
                    if (tVar.jCu) {
                        v.i("MicroMsg.TrimSnsDb", "pass hasTrim");
                    } else if (ak.uz()) {
                        int i = be.getInt(com.tencent.mm.h.j.sU().getValue("AndroidCleanSnsDb"), 0);
                        v.i("MicroMsg.TrimSnsDb", "pass dynamic? " + i);
                        if (i <= 0) {
                            ak.yW();
                            String xp = com.tencent.mm.model.c.xp();
                            if (FileOp.aR(xp + "SnsMicroMsg2.db.ini")) {
                                t.BO(xp);
                                FileOp.deleteFile(xp + "SnsMicroMsg2.db.ini");
                            }
                            SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences(aa.bti(), 0);
                            if (be.ax(sharedPreferences.getLong("check_trim_time", 0)) < 604800) {
                                v.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
                            } else {
                                sharedPreferences.edit().putLong("check_trim_time", be.Nh()).commit();
                                tVar.jCu = true;
                                long currentTimeMillis = System.currentTimeMillis();
                                int tX = com.tencent.mm.l.a.tX();
                                if (tX == 1 || tX == 2) {
                                    v.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
                                } else {
                                    if (FileOp.aR(xp + "sns_mark.ini")) {
                                        if (be.ay(FileOp.jQ(xp + "sns_mark.ini")) < 2592000000L) {
                                            v.i("MicroMsg.TrimSnsDb", "mark file exist and return");
                                            t.BO(xp);
                                        } else {
                                            FileOp.deleteFile(xp + "sns_mark.ini");
                                        }
                                    }
                                    long jP = FileOp.jP(xp + "SnsMicroMsg.db");
                                    v.i("MicroMsg.TrimSnsDb", "trim sns " + jP);
                                    if (jP < 52428800) {
                                        v.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                    } else {
                                        FileOp.jT(xp + "sns_mark.ini");
                                        String str = xp + "SnsMicroMsg2.db";
                                        g gVar = new g();
                                        if (gVar.b(str, null, true, false)) {
                                            g gVar2 = new g();
                                            if (gVar2.b(xp + "SnsMicroMsg.db", hashMap, true, true)) {
                                                long currentTimeMillis2;
                                                long currentTimeMillis3 = System.currentTimeMillis();
                                                if (t.b(gVar2, gVar)) {
                                                    currentTimeMillis2 = System.currentTimeMillis();
                                                    str = "snsExtInfo3";
                                                    t.a(gVar2, gVar, str);
                                                    v.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + gVar.dF("", "insert into " + str + " select * from old." + str) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                    str = "SnsComment";
                                                    t.a(gVar2, gVar, str);
                                                    v.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + gVar.dF("", "insert into " + str + " select * from old." + str) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                    str = "SnsInfo";
                                                    t.a(gVar2, gVar, str);
                                                    v.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + gVar.dF("", "insert into " + str + " select * from old." + str + " where  (sourceType & 2 != 0 ) " + l.jBY + " limit 200") + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                    boolean dF = gVar.dF("", "update snsExtinfo3 set md5 = '', faults = '';");
                                                    v.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Boolean.valueOf(dF)});
                                                    gVar.dF("", "DETACH DATABASE old");
                                                    tX = 1;
                                                } else {
                                                    tX = -1;
                                                }
                                                currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis3;
                                                v.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:" + tX, new Object[]{Long.valueOf(currentTimeMillis2)});
                                                gVar2.wB();
                                                gVar.wB();
                                                if (tX >= 0) {
                                                    ak.yW();
                                                    String xp2 = com.tencent.mm.model.c.xp();
                                                    FileOp.deleteFile(xp2 + "SnsMicroMsg.db");
                                                    v.i("MicroMsg.TrimSnsDb", "rename file " + FileOp.n(xp2, "SnsMicroMsg2.db", "SnsMicroMsg.db"));
                                                    FileOp.deleteFile(xp2 + "SnsMicroMsg.db-shm");
                                                    FileOp.deleteFile(xp2 + "SnsMicroMsg.db-wal");
                                                    FileOp.deleteFile(xp2 + "SnsMicroMsg.db.ini");
                                                    FileOp.p("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
                                                    FileOp.deleteFile(xp2 + "SnsMicroMsg2.db.ini");
                                                    FileOp.deleteFile(xp2 + "SnsMicroMsg2.db");
                                                    FileOp.deleteFile(xp2 + "sns_mark.ini");
                                                }
                                                currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis3;
                                                v.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[]{Integer.valueOf(tX), Long.valueOf(currentTimeMillis3), Long.valueOf(currentTimeMillis3 - currentTimeMillis2)});
                                                v.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                            } else {
                                                throw new com.tencent.mm.model.b((byte) 0);
                                            }
                                        }
                                        throw new com.tencent.mm.model.b((byte) 0);
                                    }
                                }
                            }
                        }
                    }
                    adVar = jlt;
                    if (adVar.ckb == null) {
                        adVar.ckb = new g();
                        ak.yW();
                        if (!adVar.ckb.b(com.tencent.mm.model.c.xp() + "SnsMicroMsg.db", jlY, true, true)) {
                            throw new SQLiteException("sns db init failed");
                        }
                    }
                    jlt.fKp = false;
                    v.i("MicroMsg.SnsCore", "resetdb done");
                }
            }
        }
        return jlt;
    }

    public static boolean aSn() {
        aSm();
        ak.yW();
        return !(com.tencent.mm.model.c.ww() != 0);
    }

    public ad() {
        v.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
        aSO();
        if (this.jlz == null) {
            com.tencent.mm.sdk.i.e.d(new Runnable(this) {
                final /* synthetic */ ad jmK;

                {
                    this.jmK = r1;
                }

                public final void run() {
                    Looper.prepare();
                    this.jmK.jlz = new ac();
                    Looper.loop();
                }
            }, "SnsCore_fileTask_handler", 1).start();
        }
        if (this.jlA == null) {
            com.tencent.mm.sdk.i.e.d(new Runnable(this) {
                final /* synthetic */ ad jmK;

                {
                    this.jmK = r1;
                }

                public final void run() {
                    Looper.prepare();
                    this.jmK.jlA = new ac();
                    Looper.loop();
                }
            }, "SnsCore_task_handler", 10).start();
        }
        com.tencent.mm.kiss.a.b.vH().a("R.layout.sns_timeline_item_photo_one3", 2130904512, new int[]{2131759497, 0});
        com.tencent.mm.kiss.a.b.vH().a("R.layout.sns_timeline_imagesline_one", 2130904512, new int[]{2131759294, 2130904510, 2131759497, 0});
        com.tencent.mm.kiss.a.b.vH().a("R.layout.sns_timeline_imagesline1", 2130904512, new int[]{2131759294, 2130904507, 2131759497, 0});
        com.tencent.mm.kiss.a.b.vH().a("R.layout.sns_timeline_imagesline2", 2130904512, new int[]{2131759294, 2130904508, 2131759497, 0});
        com.tencent.mm.kiss.a.b.vH().a("R.layout.sns_timeline_imagesline3", 2130904512, new int[]{2131759294, 2130904509, 2131759497, 0});
        com.tencent.mm.kiss.a.b.vH().a("R.layout.sns_media_sub_item2", 2130904512, new int[]{2131759294, 2130904476, 2131759497, 0});
        com.tencent.mm.kiss.a.b.vH().a("R.layout.sns_media_sight_item", 2130904512, new int[]{2131759294, 2130904474, 2131759497, 0});
        com.tencent.mm.kiss.a.b.vH().a("R.layout.sns_hb_reward_item", 2130904512, new int[]{2131759294, 2130904453, 2131759497, 0});
        com.tencent.mm.kiss.a.b.vH().a("R.layout.sns_timeline_imagesline_one_ad", 2130904511, new int[]{2131759294, 2130904510, 2131759497, 0});
        com.tencent.mm.kiss.a.b.vH().a("R.layout.sns_timeline_imagesline_one_ad_sight", 2130904511, new int[]{2131759294, 2130904474, 2131759497, 0});
    }

    public static ac aSo() {
        return ak.vA().btx();
    }

    public static ac aSp() {
        if (jlv >= com.tencent.mm.storage.s.noe || jlv >= 3) {
            jlv = 0;
        }
        ac[] acVarArr = aSm().jlx;
        int i = jlv;
        jlv = i + 1;
        return acVarArr[i];
    }

    public static ac aqy() {
        if (jlw > 0) {
            jlw = 0;
        }
        ac[] acVarArr = aSm().jly;
        int i = jlw;
        jlw = i + 1;
        return acVarArr[i];
    }

    protected static ac aSq() {
        return aSm().jlz;
    }

    public static ac aSr() {
        return aSm().jlA;
    }

    public static ac aqz() {
        return aSm().handler;
    }

    public static String xh() {
        ak.yW();
        return com.tencent.mm.model.c.xh();
    }

    public static String xi() {
        ak.yW();
        return com.tencent.mm.model.c.xi();
    }

    public static com.tencent.mm.storage.aa aSs() {
        ak.yW();
        return com.tencent.mm.model.c.wH();
    }

    public static p aSt() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlD == null) {
            aSm().jlD = new p(aSm().ckb);
        }
        return aSm().jlD;
    }

    public static a aSu() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlL == null) {
            aSm().jlL = new a();
            com.tencent.mm.pluginsdk.j.ak.lyj = aSm().jlL;
        }
        return aSm().jlL;
    }

    public static com.tencent.mm.plugin.sns.f.c aSv() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlP == null) {
            aSm().jlP = new com.tencent.mm.plugin.sns.f.c();
        }
        return aSm().jlP;
    }

    public static com.tencent.mm.plugin.sns.f.g aSw() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlQ == null) {
            aSm().jlQ = new com.tencent.mm.plugin.sns.f.g();
        }
        return aSm().jlQ;
    }

    public static n aSx() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlR == null) {
            aSm().jlR = new n(aSm().ckb);
        }
        return aSm().jlR;
    }

    public static i aSy() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlS == null) {
            aSm().jlS = new i();
        }
        return aSm().jlS;
    }

    public static b aSz() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlM == null) {
            aSm().jlM = new b();
        }
        return aSm().jlM;
    }

    public static at aSA() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlN == null) {
            aSm().jlN = new at();
            com.tencent.mm.pluginsdk.j.ak.lyd = aSm().jlN;
        }
        return aSm().jlN;
    }

    public static g aSB() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlG == null) {
            aSm().jlG = new g();
            com.tencent.mm.pluginsdk.j.ak.lye = aSm().jlG;
        }
        return aSm().jlG;
    }

    public static ao aSC() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jmb == null) {
            aSm().jmb = new ao();
        }
        return aSm().jmb;
    }

    public static aa aSD() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlK == null) {
            ad aSm = aSm();
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            aSm.jlK = new aa(stringBuilder.append(com.tencent.mm.model.c.xp()).append("snsAsyncQueue.data").toString());
        }
        return aSm().jlK;
    }

    public static l aSE() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlE == null) {
            aSm().jlE = new l(aSm().ckb);
            com.tencent.mm.pluginsdk.j.ak.lyk = aSm().jlE;
        }
        return aSm().jlE;
    }

    public static d aSF() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlF == null) {
            aSm().jlF = new d(aSm().ckb);
        }
        return aSm().jlF;
    }

    public static j aSG() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlH == null) {
            aSm().jlH = new j(aSm().ckb, new af());
            com.tencent.mm.pluginsdk.j.ak.lyf = aSm().jlH;
        }
        return aSm().jlH;
    }

    public static h aSH() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlI == null) {
            aSm().jlI = new h(aSm().ckb);
            com.tencent.mm.pluginsdk.j.ak.lyg = aSm().jlI;
        }
        return aSm().jlI;
    }

    public static r aSI() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlJ == null) {
            aSm().jlJ = new r(aSm().ckb);
            com.tencent.mm.pluginsdk.j.ak.lyh = aSm().jlJ;
        }
        return aSm().jlJ;
    }

    public static af aSJ() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aSm().jlO == null) {
            aSm().jlO = new af();
        }
        return aSm().jlO;
    }

    public static int aSK() {
        int fromDPToPix = (azJ().y < azJ().x ? azJ().y : azJ().x - com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), jmg)) / 3;
        jlB = fromDPToPix;
        if (fromDPToPix > 10) {
            return jlB;
        }
        v.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
        return com.tencent.mm.plugin.appbrand.jsapi.br.CTRL_INDEX;
    }

    public static int aSL() {
        if (jlC <= 0) {
            if (azJ().x <= 720) {
                jlC = 200;
            } else {
                jlC = 100;
            }
            jlC = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), jlC);
        }
        return jlC;
    }

    private static Point azJ() {
        WindowManager windowManager = (WindowManager) aa.getContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        jgb.x = displayMetrics.widthPixels;
        jgb.y = displayMetrics.heightPixels;
        return jgb;
    }

    public static boolean aSM() {
        SharedPreferences aX = aj.aX(aa.getContext(), "sp_sns_dynswitch_stg");
        if (aX.contains("st_sw_use_vcodec_img")) {
            v.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", new Object[]{Boolean.valueOf(aX.getBoolean("st_sw_use_vcodec_img", false))});
            return aX.getBoolean("st_sw_use_vcodec_img", false);
        }
        v.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", new Object[]{Boolean.valueOf(aX.getBoolean("sw_use_vcodec_img", false))});
        return aX.getBoolean("sw_use_vcodec_img", false);
    }

    public static boolean aSN() {
        SharedPreferences aX = aj.aX(aa.getContext(), "sp_sns_dynswitch_stg");
        if (aX.contains("st_sw_use_wxpc_img")) {
            v.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", new Object[]{Boolean.valueOf(aX.getBoolean("st_sw_use_wxpc_img", false))});
            return aX.getBoolean("st_sw_use_wxpc_img", false);
        }
        v.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", new Object[]{Boolean.valueOf(aX.getBoolean("sw_use_wxpc_img", false))});
        return aX.getBoolean("sw_use_wxpc_img", false);
    }

    private void aSO() {
        int i;
        for (i = 0; i < 3; i++) {
            if (this.jlx[i] == null) {
                com.tencent.mm.sdk.i.e.d(new Runnable(this) {
                    final /* synthetic */ ad jmK;

                    public final void run() {
                        Looper.prepare();
                        this.jmK.jlx[i] = new ac();
                        Looper.loop();
                    }
                }, "SnsCore_CDNDownload_handler", 1).start();
            }
        }
        for (i = 0; i <= 0; i++) {
            if (this.jly[0] == null) {
                com.tencent.mm.sdk.i.e.d(new Runnable(this) {
                    final /* synthetic */ ad jmK;
                    final /* synthetic */ int qw = 0;

                    {
                        this.jmK = r2;
                    }

                    public final void run() {
                        Looper.prepare();
                        this.jmK.jly[this.qw] = new ac();
                        Looper.loop();
                    }
                }, "SnsCore_thumbDecode_handler", 1).start();
            }
        }
    }

    public final void th() {
        ak.vy().b(1802, aSy());
        com.tencent.mm.sdk.c.a.nhr.f(this.jmH);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmG);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmF);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmv);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmt);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmu);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmw);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmx);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmy);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmA);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmB);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmh);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmi);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmj);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmk);
        com.tencent.mm.sdk.c.a.nhr.f(this.jml);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmm);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmn);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmo);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmp);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmq);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmz);
        com.tencent.mm.sdk.c.a.nhr.f(this.jlZ);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmC);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmD);
        com.tencent.mm.sdk.c.a.nhr.f(this.hDj);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmJ);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmE);
        com.tencent.mm.sdk.c.a.nhr.f(this.jmr);
        com.tencent.mm.sdk.c.a.nhr.f(this.jms);
        ak.yU().b("NewYearSNSCtrl2016", this.jmc, true);
        ak.yU().b("NewYearSNSTips2016", this.jmd, true);
        ak.yU().b("NewYearSNSAmountLevelCtrl2016", this.jme, true);
        ak.yU().b("SnsAd", this.jmf, true);
        at aSA = aSA();
        ak.vy().b(207, aSA);
        ak.vy().b(209, aSA);
        if (jlt != null) {
            int i;
            v.d("MicroMsg.SnsCore", "SnsCore close db");
            ad adVar = jlt;
            if (adVar.ckb != null) {
                adVar.ckb.wB();
                adVar.ckb = null;
            }
            for (i = 0; i < 3; i++) {
                if (jlt.jlx[i] != null) {
                    jlt.jlx[i].getLooper().quit();
                }
            }
            for (i = 0; i <= 0; i++) {
                if (jlt.jly[0] != null) {
                    jlt.jly[0].getLooper().quit();
                }
            }
            if (jlt.jlz != null) {
                jlt.jlz.getLooper().quit();
            }
            if (jlt.jlA != null) {
                jlt.jlA.getLooper().quit();
            }
        }
        if (this.cyY != null) {
            FileOp.jJ(this.cyY);
            this.cyY = null;
        }
        b.b bVar = this.jma;
        aSz().b(bVar);
        com.tencent.mm.sdk.c.a.nhr.f(bVar.jeg);
        am.Ny();
        com.tencent.mm.memory.g.cnv.wc();
        com.tencent.mm.memory.c.cno.wc();
        com.tencent.mm.memory.o.cnL.wc();
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.jlV);
        if (!this.jlV) {
            this.jlV = true;
            this.fKp = true;
            FileOp.jS(xq() + "sfs");
            ak.yW();
            this.cyY = com.tencent.mm.model.c.xh();
            String str = this.cyY;
            String[] strArr = new String[]{"sight_*", "sns_tmp*", "sightad_*", "sns_tmpsad_*"};
            Builder builder = new Builder();
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            builder = builder.setDBDirectory(stringBuilder.append(com.tencent.mm.model.c.xp()).append("sfs").toString());
            ak.yW();
            FileOp.a(str, strArr, builder.setStoragePath(com.tencent.mm.model.c.xj()).setName("sns"));
            ak.yW();
            FileOp.jS(com.tencent.mm.model.c.xh());
            ak.yW();
            FileOp.jS(com.tencent.mm.model.c.xi());
            ak.yU().a("NewYearSNSCtrl2016", this.jmc, true);
            ak.yU().a("NewYearSNSTips2016", this.jmd, true);
            ak.yU().a("NewYearSNSAmountLevelCtrl2016", this.jme, true);
            ak.yU().a("SnsAd", this.jmf, true);
            com.tencent.mm.pluginsdk.j.ak.lyd = aSA();
            com.tencent.mm.pluginsdk.j.ak.lye = aSB();
            com.tencent.mm.pluginsdk.j.ak.lyf = aSG();
            com.tencent.mm.pluginsdk.j.ak.lyg = aSH();
            com.tencent.mm.pluginsdk.j.ak.lyh = aSI();
            com.tencent.mm.pluginsdk.j.ak.lyj = aSu();
            com.tencent.mm.pluginsdk.j.ak.lyi = this;
            com.tencent.mm.pluginsdk.j.ak.lyk = aSE();
            com.tencent.mm.sdk.c.a.nhr.e(this.jmH);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmv);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmt);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmu);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmw);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmx);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmy);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmz);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmA);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmB);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmC);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmD);
            this.jmh = new com.tencent.mm.plugin.sns.k();
            this.jmi = new com.tencent.mm.plugin.sns.j();
            this.jmj = new com.tencent.mm.plugin.sns.h();
            this.jmk = new com.tencent.mm.plugin.sns.d();
            this.jml = new com.tencent.mm.plugin.sns.f();
            this.jmm = new com.tencent.mm.plugin.sns.i();
            this.jmn = new com.tencent.mm.plugin.sns.g();
            this.jmo = new com.tencent.mm.plugin.sns.a();
            this.jmp = new com.tencent.mm.plugin.sns.b();
            this.jmq = new com.tencent.mm.plugin.sns.e();
            com.tencent.mm.sdk.c.a.nhr.e(this.jmG);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmF);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmh);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmi);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmj);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmk);
            com.tencent.mm.sdk.c.a.nhr.e(this.jml);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmm);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmn);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmo);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmp);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmq);
            com.tencent.mm.sdk.c.a.nhr.e(this.hDj);
            this.jlZ = new com.tencent.mm.plugin.sns.c();
            com.tencent.mm.sdk.c.a.nhr.e(this.jlZ);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmJ);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmr);
            com.tencent.mm.sdk.c.a.nhr.e(this.jms);
            com.tencent.mm.sdk.c.a.nhr.e(this.jmE);
            i aSy = aSy();
            i.jcE = com.tencent.mm.h.j.sU().getInt("MMUxAdLog2GSendSize", 20480);
            i.jcF = com.tencent.mm.h.j.sU().getInt("MMUxAdLog3GSendSize", 30720);
            i.jcG = com.tencent.mm.h.j.sU().getInt("MMUxAdLogWifiSendSize", 51200);
            i.jcH = com.tencent.mm.h.j.sU().getInt("MMUxAdLogMinRandTime", 60);
            i.jcI = com.tencent.mm.h.j.sU().getInt("MMUxAdLogMaxRandTime", 1800);
            i.jcJ = com.tencent.mm.h.j.sU().getInt("MMUxAdLogMaxExceptionTime", 43200);
            v.i("MicroMsg.SnsLogMgr", "init " + i.jcE + ";" + i.jcF + ";" + i.jcG + ";" + i.jcH + ";" + i.jcI + ";" + i.jcJ);
            if (i.jcI - i.jcH < 0) {
                i.jcI = i.jcH;
            }
            ak.vy().a(1802, aSy);
            at aSA = aSA();
            ak.vy().a(207, aSA);
            ak.vy().a(209, aSA);
            this.jma = new com.tencent.mm.plugin.sns.d.a();
            am.init();
            com.tencent.mm.modelsns.b bVar = com.tencent.mm.modelsns.b.cZP;
            com.tencent.mm.modelsns.b.JG();
            if (com.tencent.mm.memory.l.wl()) {
                com.tencent.mm.memory.c cVar = com.tencent.mm.memory.c.cno;
                com.tencent.mm.memory.c cVar2 = com.tencent.mm.memory.c.cno;
                cVar2.getClass();
                cVar.a(new AnonymousClass5(this, cVar2));
            }
            com.tencent.mm.memory.o oVar = com.tencent.mm.memory.o.cnL;
            com.tencent.mm.memory.o oVar2 = com.tencent.mm.memory.o.cnL;
            oVar2.getClass();
            oVar.a(new AnonymousClass6(this, oVar2));
            com.tencent.mm.memory.g gVar = com.tencent.mm.memory.g.cnv;
            com.tencent.mm.memory.g gVar2 = com.tencent.mm.memory.g.cnv;
            gVar2.getClass();
            gVar.a(new AnonymousClass7(this, gVar2));
        }
    }

    public final void aH(boolean z) {
        if (this.cyY != null) {
            FileOp.jJ(this.cyY);
            ak.yW();
            this.cyY = com.tencent.mm.model.c.xh();
            String str = this.cyY;
            String[] strArr = new String[]{"sight_*", "sns_tmp*", "sightad_*", "sns_tmpsad_*"};
            Builder builder = new Builder();
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            builder = builder.setDBDirectory(stringBuilder.append(com.tencent.mm.model.c.xp()).append("sfs").toString());
            ak.yW();
            FileOp.a(str, strArr, builder.setStoragePath(com.tencent.mm.model.c.xj()).setName("sns"));
        }
    }

    public final void a(ae aeVar) {
        r.a(aeVar);
    }

    public final void b(ae aeVar) {
        r.b(aeVar);
    }

    public static String aSP() {
        if (be.kS(jlX)) {
            Iterator it = at.btT().iterator();
            while (it.hasNext()) {
                at.a aVar = (at.a) it.next();
                if (com.tencent.mm.compatible.util.e.cni.equals(aVar.nkX)) {
                    jlX = aVar.nkY;
                    break;
                }
            }
            v.i("MicroMsg.SnsCore", "get filesys " + jlX);
        }
        return be.ah(jlX, "");
    }
}

package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mm.booter.f;
import com.tencent.mm.e.a.ob;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ae;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.i;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import java.util.LinkedList;
import junit.framework.Assert;

public final class k extends com.tencent.mm.v.k implements j {
    protected static int cQR = 7;
    private static boolean cRG = false;
    private static int cRJ = 0;
    public String TAG;
    private String biS;
    private int cQS;
    private com.tencent.mm.compatible.util.g.a cQT;
    private long cQV;
    private boolean cQW;
    public q cRF;
    private boolean cRH;
    private ah cRI;
    private int cRK;
    private boolean cRL;
    private String cRM;
    public b cRN;
    private long cRO;
    private boolean cRi;
    private e cii;
    private ah cxS;
    private int errCode;
    private int errType;

    public static class a extends i {
        private final com.tencent.mm.protocal.x.a cQZ;
        private final b cRa;
        private final boolean cRb;

        public a() {
            this.cQZ = new com.tencent.mm.protocal.x.a();
            this.cRa = new b();
            this.cRb = false;
        }

        public a(b bVar) {
            this.cQZ = new com.tencent.mm.protocal.x.a();
            this.cRa = bVar;
            this.cRb = true;
        }

        public final c zd() {
            return this.cQZ;
        }

        public final d ze() {
            return this.cRa;
        }

        public final int getType() {
            return 138;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }
    }

    public k(int i) {
        this.TAG = "MicroMsg.NetSceneSync";
        this.errType = 0;
        this.errCode = 0;
        this.biS = SQLiteDatabase.KeyEmpty;
        this.cRF = null;
        this.cRH = false;
        this.cQS = 0;
        this.cxS = null;
        this.cRI = null;
        this.cQV = -1;
        this.cQW = false;
        this.cRL = false;
        this.cRi = false;
        this.cRM = SQLiteDatabase.KeyEmpty;
        this.cRN = null;
        this.cRO = 0;
        this.TAG += "[" + hashCode() + "]";
        v.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", Integer.valueOf(i), be.bur());
        this.cRM = af.btz();
        this.cQT = new com.tencent.mm.compatible.util.g.a();
        if (this.cRF == null) {
            this.cRF = new q();
        }
        this.cRF.cSM = i;
        g.vx();
        if (g.vw() != null && g.uz()) {
            g.vx();
            if (!(g.vw().vf() == null || com.tencent.mm.kernel.a.uG())) {
                g.vx();
                long a = be.a((Long) g.vw().vf().get(8196, null), 0);
                if (a != 0) {
                    g.vx();
                    g.vw().vf().set(8196, Long.valueOf(0));
                    int i2 = (int) (a | ((long) cQR));
                    cQR = i2;
                    cQR = i2 & 95;
                }
            }
        }
        if (i == 1) {
            cRG = true;
        }
        if (i == 1010) {
            cQR |= 16;
            cRG = true;
            this.cRK = 7;
        } else if (i == 1011) {
            cQR |= 64;
            cRG = true;
            this.cRK = 7;
        } else if (i == 3) {
            cQR |= 262144;
            cRG = true;
            this.cRK = 3;
            v.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", Integer.valueOf(i), Integer.valueOf(cQR), Integer.valueOf(this.cRK));
        } else {
            this.cRK = i;
        }
        if (cRJ == 0) {
            Hk();
        }
    }

    public k(final b bVar, int i, long j) {
        this(8);
        this.cRM = af.btz();
        v.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", Long.valueOf(bVar.lWT), Integer.valueOf(i), Long.valueOf(j));
        this.cQS = i;
        this.cQV = j;
        this.cxS = new ah(g.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ k cRP;

            public final boolean oU() {
                this.cRP.cQW = true;
                p aVar = new a(bVar);
                com.tencent.mm.plugin.report.b.itm.a(99, 230, 1, false);
                this.cRP.a(-1, 0, 0, SQLiteDatabase.KeyEmpty, aVar, null);
                return false;
            }
        }, false);
        if (cRJ == 0) {
            Hk();
        }
    }

    protected final boolean a(com.tencent.mm.v.k kVar) {
        boolean z = true;
        if (!(kVar instanceof k)) {
            return false;
        }
        k kVar2 = (k) kVar;
        if (kVar2.cRH || !cRG) {
            return false;
        }
        v.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", Long.valueOf(kVar2.czF));
        if (be.az(kVar2.czF) <= 360000) {
            z = false;
        }
        if (z) {
            Runnable findTaskByRunTime = g.vA().btx().findTaskByRunTime(0);
            if (findTaskByRunTime != null) {
                v.e(this.TAG, "summerworker worker is just blocked by task: " + ac.dump(findTaskByRunTime, false));
                return false;
            }
        }
        return z;
    }

    public final boolean Bz() {
        return true;
    }

    protected final int ul() {
        return 100;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    public final boolean BA() {
        int i = 1;
        boolean BA = super.BA();
        if (BA) {
            com.tencent.mm.plugin.report.b.itm.a(99, 228, 1, false);
            com.tencent.mm.plugin.report.b bVar = com.tencent.mm.plugin.report.b.itm;
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(0);
            objArr[6] = Integer.valueOf(0);
            if (!com.tencent.mm.sdk.b.b.foreground) {
                i = 2;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "9999";
            bVar.h(12063, objArr);
        }
        return BA;
    }

    public final int getType() {
        return 138;
    }

    protected final void cancel() {
        super.cancel();
        com.tencent.mm.plugin.report.b.itm.a(99, 229, 1, false);
        this.cRi = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (l.Hm()) {
            cRJ = 0;
            v.e(this.TAG, "dkinit never do sync before init done");
            return -1;
        }
        this.cii = eVar2;
        if (this.cRF == null) {
            this.cRF = new q();
        }
        this.cRF.cSL = com.tencent.mm.sdk.b.b.foreground;
        if (this.cRI != null) {
            v.i(this.TAG, "pushSyncRespHandler not null");
            c(eVar);
            this.cRI.ea(0);
            return 0;
        } else if (cRJ > 0) {
            v.w(this.TAG, "other sync is dealing with resp data :%d", Integer.valueOf(cRJ));
            return -1;
        } else if (this.cxS != null) {
            v.i(this.TAG, "pusher not null");
            c(eVar);
            this.cxS.ea(0);
            return 0;
        } else {
            p aVar = new a();
            ake com_tencent_mm_protocal_c_ake = ((com.tencent.mm.protocal.x.a) aVar.Bx()).lXs;
            if (this.cRK == 3) {
                com_tencent_mm_protocal_c_ake.mLg = 1;
            } else {
                com_tencent_mm_protocal_c_ake.mLg = 0;
            }
            this.cRK = this.cRL ? 6 : this.cRK;
            com_tencent_mm_protocal_c_ake.mkE = cQR;
            g.vx();
            com_tencent_mm_protocal_c_ake.mkF = m.H(be.KG(be.ma((String) g.vw().vf().get(8195, new byte[0]))));
            com_tencent_mm_protocal_c_ake.maG = this.cRK;
            com_tencent_mm_protocal_c_ake.mLf = new la();
            com_tencent_mm_protocal_c_ake.meq = com.tencent.mm.protocal.d.cmW;
            v.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", Integer.valueOf(com_tencent_mm_protocal_c_ake.mkE), Integer.valueOf(com_tencent_mm_protocal_c_ake.maG), ae.aZ(r0));
            cRG = false;
            return a(eVar, aVar, this);
        }
    }

    private boolean Hk() {
        PInt pInt = new PInt();
        g.vx();
        byte[] a = f.a(pInt, g.vu().uin);
        String str = this.TAG;
        String str2 = "dealWithRespData index:%d, hashcode:%d, buf.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = Integer.valueOf(a != null ? a.length : 0);
        v.i(str, str2, objArr);
        cRJ = pInt.value;
        if (pInt.value == 0 || be.bl(a)) {
            cRJ = 0;
            return false;
        }
        b bVar = new b();
        try {
            bVar.y(a);
            final a aVar = new a(bVar);
            this.cRI = new ah(g.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ k cRP;

                public final boolean oU() {
                    this.cRP.cQW = true;
                    com.tencent.mm.plugin.report.b.itm.a(99, 231, 1, false);
                    this.cRP.a(-1, 0, 0, SQLiteDatabase.KeyEmpty, aVar, null);
                    return false;
                }
            }, false);
            return true;
        } catch (Exception e) {
            com.tencent.mm.plugin.report.b.itm.a(99, 226, 1, false);
            v.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
            int i = cRJ;
            g.vx();
            f.at(i, g.vu().uin);
            cRJ = 0;
            return false;
        } catch (Error e2) {
            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
            v.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory));
            Assert.assertTrue("dealWithRespData error", false);
            return false;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (pVar == null || pVar.getType() != 138) {
            int i4;
            String str2 = this.TAG;
            String str3 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            if (pVar == null) {
                i4 = -2;
            } else {
                i4 = pVar.getType();
            }
            objArr[0] = Integer.valueOf(i4);
            v.e(str2, str3, objArr);
            return;
        }
        boolean z;
        b bVar = (b) pVar.ze();
        str3 = this.TAG;
        String str4 = "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ";
        Object[] objArr2 = new Object[8];
        objArr2[0] = Integer.valueOf(i2);
        objArr2[1] = Integer.valueOf(i3);
        objArr2[2] = str;
        objArr2[3] = Long.valueOf(this.cQT.sn());
        objArr2[4] = Boolean.valueOf(this.cQW);
        objArr2[5] = Integer.valueOf(bVar.lXt.mkI == null ? -1 : bVar.lXt.mkI.eet);
        objArr2[6] = this.cxS;
        objArr2[7] = this.cRI;
        v.i(str3, str4, objArr2);
        Object obj = (bVar.lXt.mkI == null ? -1 : bVar.lXt.mkI.eet) > 0 ? 1 : null;
        if (!Hl()) {
            com.tencent.mm.plugin.report.b.itm.a(99, obj != null ? 221 : 218, 1, false);
        } else if (com.tencent.mm.sdk.b.b.foreground) {
            com.tencent.mm.plugin.report.b.itm.a(99, obj != null ? 219 : 216, 1, false);
        } else {
            com.tencent.mm.plugin.report.b.itm.a(99, obj != null ? 220 : 217, 1, false);
        }
        this.cxS = null;
        this.cRH = true;
        if (i2 == 4 && i3 == -2006) {
            z = true;
            i2 = 0;
            i3 = 0;
            com.tencent.mm.plugin.report.b.itm.a(99, 227, 1, false);
        } else {
            z = false;
        }
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.report.b.itm.a(99, 233, 1, false);
            byte[] a = m.a(((com.tencent.mm.protocal.x.a) pVar.Bx()).lXs.mkF);
            byte[] a2 = m.a(bVar.lXt.mkF);
            v.i(this.TAG, "onGYNetEnd replace key:%b req :%s", Boolean.valueOf(z), ae.aZ(a));
            v.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", Boolean.valueOf(z), ae.aZ(a2));
            if (!z) {
                if (be.bl(a)) {
                    g.vx();
                    a = be.KG(be.ma((String) g.vw().vf().get(8195, new byte[0])));
                    v.d(this.TAG, "dkpush userinfo key : %d[%s]", Integer.valueOf(a.length), be.bk(a));
                }
                a = ae.i(a, a2);
                if (a == null || a.length <= 0) {
                    v.w(this.TAG, "merge key failed, use server side instead");
                    a = a2;
                }
                bVar.lXt.mkF = m.H(a);
            }
            g.vx();
            g.vu().aA(bVar.lXt.eeO, bVar.lXt.mLh);
            g.vx();
            g.vu();
            com.tencent.mm.kernel.a.eA(bVar.lXt.eeO);
            Assert.assertTrue(this.cRN == null);
            this.cRN = bVar;
            this.cRO = be.Ni();
            new ah(g.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ k cRP;
                private int cRR = 0;
                private long cRS = 0;
                private int cRT = 0;

                {
                    this.cRP = r4;
                }

                public final boolean oU() {
                    com.tencent.mm.plugin.zero.c cVar = new com.tencent.mm.plugin.zero.c();
                    if (!g.uz()) {
                        v.e(this.cRP.TAG, "syncRespHandler acc is not ready STOP :%s", this.cRP.cRN);
                        this.cRP.cRN = null;
                        return false;
                    } else if (this.cRP.cRi) {
                        cVar.aM(this.cRP);
                        this.cRP.cRN = null;
                        return false;
                    } else if (this.cRP.cRN == null || this.cRP.cRN.lXt.mkI == null || this.cRP.cRN.lXt.mkI.eeu == null) {
                        v.e(this.cRP.TAG, "syncRespHandler CmdList is null! Stop Processing :%s", this.cRP.cRN);
                        cVar.aM(this.cRP);
                        this.cRP.cRN = null;
                        return false;
                    } else {
                        LinkedList linkedList = this.cRP.cRN.lXt.mkI.eeu;
                        cVar.aK(this.cRP);
                        this.cRT++;
                        long Ni = be.Ni();
                        for (int i = 0; i < 5; i++) {
                            if (this.cRR < linkedList.size()) {
                                v.v(this.cRP.TAG, "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", Integer.valueOf(i), Integer.valueOf(this.cRR), Integer.valueOf(linkedList.size()), Integer.valueOf(((kz) linkedList.get(this.cRR)).bkM), Integer.valueOf(((kz) linkedList.get(this.cRR)).mnB.mQu));
                                if (!cVar.a(this.cRP, this.cRR, linkedList.size(), (kz) linkedList.get(this.cRR), false)) {
                                    v.w(this.cRP.TAG, "DoCmd Failed index:%d", Integer.valueOf(this.cRR));
                                }
                                this.cRR++;
                            }
                            if (this.cRR >= linkedList.size()) {
                                this.cRS += be.ay(Ni);
                                v.i(this.cRP.TAG, "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", Integer.valueOf(this.cRR), Integer.valueOf(linkedList.size()), Long.valueOf(be.ay(this.cRP.cRO)), Long.valueOf(this.cRS), Integer.valueOf(this.cRT), this.cRP.cRN);
                                this.cRP.a(this.cRP.cRN);
                                cVar.aL(this.cRP);
                                com.tencent.mm.plugin.report.b.itm.a(99, (long) be.f((Integer) com.tencent.mm.plugin.report.b.a((int) this.cRS, new int[]{100, SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD, 1000, 3000}, new Integer[]{Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(238), Integer.valueOf(237), Integer.valueOf(236)})), 1, false);
                                com.tencent.mm.plugin.report.b.itm.a(99, (long) be.f((Integer) com.tencent.mm.plugin.report.b.a(linkedList.size(), new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243)})), 1, false);
                                com.tencent.mm.plugin.report.b.itm.a(99, com.tencent.mm.sdk.b.b.foreground ? 241 : 242, 1, false);
                                com.tencent.mm.plugin.report.b.itm.a(99, (long) this.cRP.cRK, 1, false);
                                com.tencent.mm.plugin.report.b.itm.a(99, 0, 1, false);
                                com.tencent.mm.plugin.report.b bVar = com.tencent.mm.plugin.report.b.itm;
                                Object[] objArr = new Object[8];
                                objArr[0] = Integer.valueOf(linkedList.size());
                                objArr[1] = Long.valueOf(Ni);
                                objArr[2] = Integer.valueOf(this.cRP.cRK);
                                objArr[3] = Integer.valueOf(this.cRP.cRN.lXt.miR);
                                objArr[4] = Long.valueOf(this.cRS);
                                objArr[5] = Integer.valueOf(this.cRT);
                                objArr[6] = this.cRP.cRM;
                                objArr[7] = Integer.valueOf(com.tencent.mm.sdk.b.b.foreground ? 1 : 2);
                                bVar.h(12063, objArr);
                                this.cRP.cRN = null;
                                return false;
                            }
                            if (be.ay(Ni) > 500) {
                                v.d(this.cRP.TAG, "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", Long.valueOf(be.ay(Ni)), Integer.valueOf(i), Integer.valueOf(this.cRR), this.cRP.cRN);
                                this.cRS += be.ay(Ni);
                                return true;
                            }
                        }
                        this.cRS += be.ay(Ni);
                        return true;
                    }
                }
            }, true).ea(50);
            return;
        }
        if (this.cRN != null) {
            v.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
            this.errType = i2;
            this.errCode = i3;
            this.biS = str;
            ((b) pVar.ze()).lXt.miR = 0;
        } else {
            this.cii.a(i2, i3, str, this);
        }
        com.tencent.mm.plugin.report.b.itm.a(99, 232, 1, false);
    }

    protected final void a(b bVar) {
        g.vx();
        g.vw().vf().set(8195, be.bn(m.a(bVar.lXt.mkF)));
        aa.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", be.bn(m.a(bVar.lXt.mkF))).commit();
        g.vx();
        g.vw().vf().set(8196, Long.valueOf((long) bVar.lXt.miR));
        boolean z = ((bVar.lXt.miR & cQR) == 0 || super.BA()) ? false : true;
        v.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", Boolean.valueOf(z), Integer.valueOf(bVar.lXt.miR), Integer.valueOf(cQR), Boolean.valueOf(super.BA()));
        if (!(z || (bVar.lXt.miR & FileUtils.S_IRUSR) == 0)) {
            com.tencent.mm.sdk.c.a.nhr.z(new ob());
        }
        com.tencent.mm.plugin.report.b.itm.a(99, z ? 234 : 235, 1, false);
        v.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", Integer.valueOf(bVar.lXt.miR), Boolean.valueOf(this.cQW), Boolean.valueOf(z), Boolean.valueOf(cRG), Integer.valueOf(this.cQS), Boolean.valueOf(this.cRL), this.cRI);
        if (!this.cQW && z) {
            this.cRL = true;
            a(this.czE, this.cii);
        } else if (cRG) {
            v.i(this.TAG, "dkpush new notify pending, sync now");
            if (cRJ != 0) {
                r0 = cRJ;
                g.vx();
                f.at(r0, g.vu().uin);
            }
            cRJ = 0;
            this.cRI = null;
            cRG = false;
            this.cRL = true;
            a(this.czE, this.cii);
        } else if (this.cRI != null) {
            r0 = cRJ;
            g.vx();
            f.at(r0, g.vu().uin);
            this.cRI = null;
            Hk();
            a(this.czE, this.cii);
        } else {
            if ((this.cQS & 1) > 0) {
                g.vx();
                g.vy().a(new g(this.cQV, be.KG(be.ma((String) g.vw().vf().get(8195, null)))), 0);
            }
            v.d(this.TAG, "sync or init end: reset selector : now = " + cQR + " default = 7");
            cQR = 7;
            this.cii.a(this.errType, this.errCode, this.biS, this);
        }
    }

    private boolean Hl() {
        try {
            return ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) aa.getContext().getSystemService("power"), new Object[0])).booleanValue();
        } catch (Throwable e) {
            v.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.valueOf(true), be.e(e));
            return true;
        }
    }
}

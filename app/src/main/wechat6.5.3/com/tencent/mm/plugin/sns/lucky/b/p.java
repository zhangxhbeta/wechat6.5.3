package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.gmtrace.Constants;
import com.tencent.mm.ba.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.akh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.LinkedList;

public final class p implements e {
    private static int jfb = 0;
    private static int jfc = 1;
    private static int jfd = 2;
    private static int jfe = 3;
    private static int jff = 4;
    private static p jfh = null;
    public int jfg = 0;
    public HashMap<String, e> jfi = new HashMap();
    public HashMap<String, akh> jfj = new HashMap();
    public HashMap<String, Long> jfk = new HashMap();
    public LinkedList<String> jfl = new LinkedList();
    public LinkedList<String> jfm = new LinkedList();
    public b jfn;
    public long jfo;
    public long jfp;
    public long jfq;
    public c jfr;

    public static p aRk() {
        if (jfh == null) {
            jfh = new p();
        }
        return jfh;
    }

    public p() {
        ak.yW();
        this.jfn = new b(((String) c.vf().get(a.nse, "")).getBytes());
        this.jfq = 0;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.NewYearSnsFlowControlMgr", "onSceneEnd in NewYearSnsFlowControlMgr end");
        if (kVar == null) {
            v.e("MicroMsg.NewYearSnsFlowControlMgr", "onSceneEnd in NewYearSnsFlowControlMgr the scene is null");
            aRl();
            b.kZ(86);
            Ab(null);
        } else if (kVar instanceof e) {
            e eVar = (e) kVar;
            String cE = i.cE(eVar.jei);
            this.jfi.remove(cE);
            if (eVar.jei == 0) {
                v.e("MicroMsg.NewYearSnsFlowControlMgr", "netSceneSnsLuckyMoneyFlowControl.mFeedId is 0");
                aRl();
                b.kZ(86);
                Ab(null);
            } else if (i != 0 || i2 != 0) {
                v.e("MicroMsg.NewYearSnsFlowControlMgr", "[NetSceneSnsLuckyMoneyFlowControl] errType、errCode not ok, countDown");
                aRl();
                b.kZ(86);
                Ab(cE);
            } else if (eVar.BD() == null || !(eVar.BD() instanceof e.a)) {
                v.e("MicroMsg.NewYearSnsFlowControlMgr", "NewYearSNS2016AmountCheckResp.getReqResp is not a NewYearSNS2016AmountCheckResp");
                aRl();
                b.kZ(86);
                Ab(cE);
            } else {
                akh com_tencent_mm_protocal_c_akh = ((e.a) eVar.BD()).jek.jep;
                this.jfj.put(cE, com_tencent_mm_protocal_c_akh);
                this.jfn = com_tencent_mm_protocal_c_akh.jen;
                Object obj = "";
                if (this.jfn.lVU.length != 0) {
                    obj = new String(this.jfn.lVU);
                }
                ak.yW();
                c.vf().a(a.nse, obj);
                this.jfk.put(cE, Long.valueOf(System.currentTimeMillis()));
                if (com_tencent_mm_protocal_c_akh.aXy == 3) {
                    b.kZ(88);
                    aRl();
                    Ab(null);
                    return;
                }
                if (com_tencent_mm_protocal_c_akh.aXy == 0) {
                    b.kZ(82);
                    a(cE, com_tencent_mm_protocal_c_akh);
                } else if (com_tencent_mm_protocal_c_akh.aXy == 1) {
                    if (com_tencent_mm_protocal_c_akh.mLj == 0) {
                        b.kZ(96);
                    } else if (com_tencent_mm_protocal_c_akh.mLj == 1) {
                        b.kZ(97);
                    } else if (com_tencent_mm_protocal_c_akh.mLj == 2) {
                        b.kZ(98);
                    } else if (com_tencent_mm_protocal_c_akh.mLj == 3) {
                        b.kZ(99);
                    } else if (com_tencent_mm_protocal_c_akh.mLj == 4) {
                        b.kZ(100);
                    } else {
                        b.kZ(101);
                    }
                    b.kZ(83);
                    a(cE, com_tencent_mm_protocal_c_akh);
                } else if (com_tencent_mm_protocal_c_akh.aXy == 2) {
                    b.kZ(84);
                    a(cE, com_tencent_mm_protocal_c_akh);
                } else {
                    b.kZ(85);
                    a(cE, com_tencent_mm_protocal_c_akh);
                }
                this.jfo = 0;
                this.jfp = 0;
            }
        } else {
            v.e("MicroMsg.NewYearSnsFlowControlMgr", "the scene is not a NetSceneSnsLuckyMoneyFlowControl");
            aRl();
            b.kZ(86);
            Ab(null);
        }
    }

    public static int pV(int i) {
        if (i == jfb) {
            return Downloads.MIN_RETYR_AFTER;
        }
        if (i == jfc) {
            return Constants.THREAD_BITSET_SIZE;
        }
        if (i == jfd) {
            return 20000;
        }
        if (i == jfe) {
            return 30000;
        }
        return i == jff ? 60000 : 60000;
    }

    public final void aRl() {
        this.jfo = System.currentTimeMillis();
        this.jfp = 5000;
        this.jfg = 1;
        v.i("MicroMsg.NewYearSnsFlowControlMgr", "markSvrDown! start=%d, waittime=%d, _amountCheckTime=%d", new Object[]{Long.valueOf(this.jfo), Long.valueOf(this.jfp), Long.valueOf(this.jfq)});
    }

    public final void Ab(String str) {
        if (str != null && str.length() > 0) {
            this.jfl.remove(str);
        }
        if (this.jfr != null) {
            this.jfr.aRd();
        }
    }

    public final void a(String str, akh com_tencent_mm_protocal_c_akh) {
        this.jfg = 2;
        if (str != null && str.length() > 0) {
            this.jfl.remove(str);
        }
        if (this.jfr != null) {
            switch (com_tencent_mm_protocal_c_akh.aXy) {
                case 0:
                    this.jfr.b(com_tencent_mm_protocal_c_akh.mLm);
                    return;
                case 1:
                    this.jfr.f(com_tencent_mm_protocal_c_akh.mLj, new LinkedList());
                    return;
                case 2:
                    this.jfr.f(com_tencent_mm_protocal_c_akh.mLj, com_tencent_mm_protocal_c_akh.mLk);
                    return;
                default:
                    v.e("MicroMsg.NewYearSnsFlowControlMgr", "error type");
                    return;
            }
        }
    }
}

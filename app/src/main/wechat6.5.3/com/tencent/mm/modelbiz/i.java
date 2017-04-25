package com.tencent.mm.modelbiz;

import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class i {
    private a bYl;
    int cCQ;
    private c cCR;
    private int cCS;
    int cCT;
    boolean cCU;
    b cCV;
    String userName;

    protected i() {
        this.userName = null;
        this.cCQ = 0;
        this.cCS = 2;
        this.cCT = 10;
        this.cCU = false;
        this.cCV = new b(this) {
            final /* synthetic */ i cCW;

            {
                this.cCW = r1;
            }

            public final void a(int i, j jVar, Object obj) {
                if (obj == null || !(obj instanceof String)) {
                    v.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), jVar, obj);
                } else if (this.cCW.userName.equals((String) obj) && this.cCW.cCQ == 1) {
                    v.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", this.cCW.userName);
                    this.cCW.hK(this.cCW.userName);
                    ak.yW();
                    com.tencent.mm.model.c.wH().b(this.cCW.cCV);
                }
            }
        };
        this.bYl = new a(this) {
            final /* synthetic */ i cCW;
            long ctO = 0;

            {
                this.cCW = r3;
            }

            public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
                if (!z) {
                    return true;
                }
                v.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", Float.valueOf(f2), Float.valueOf(f));
                if (be.Nh() >= this.ctO + ((long) this.cCW.cCT)) {
                    i.a(this.cCW.userName, 11, 0, f2, f, (int) d2);
                    this.ctO = be.Nh();
                }
                if (this.cCW.cCQ == 2) {
                    this.cCW.Dr();
                }
                if (!this.cCW.cCU) {
                    this.cCW.cCU = true;
                    n.a(2013, f, f2, (int) d2);
                }
                return true;
            }
        };
        this.cCT = be.getInt(com.tencent.mm.h.j.sV().z("BrandService", "continueLocationReportInterval"), 5);
        if (this.cCT < this.cCS) {
            this.cCT = this.cCS;
        }
        v.i("MicroMsg.ReportLocation", "reportLocation interval %d", Integer.valueOf(this.cCT));
    }

    public static void hI(String str) {
        a(str, 10, 0, 0.0f, 0.0f, 0);
    }

    public static void hJ(String str) {
        a(str, 12, 0, 0.0f, 0.0f, 0);
    }

    public final void hK(String str) {
        v.i("MicroMsg.ReportLocation", "Start report");
        this.userName = str;
        BizInfo hw = e.hw(str);
        if (hw != null) {
            if (this.cCQ != 0) {
                Dr();
            }
            this.cCQ = 0;
            if (hw.Ct()) {
                v.i("MicroMsg.ReportLocation", "need update contact %s", str);
                com.tencent.mm.u.b.gC(str);
            }
            ExtInfo aX = hw.aX(false);
            if (aX == null) {
                return;
            }
            if (aX.Cv() && hw.Cs()) {
                this.cCR = c.FY();
                aX = hw.aX(false);
                if (aX.cBx != null) {
                    boolean z;
                    if (be.getInt(aX.cBx.optString("ReportLocationType"), 0) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aX.cBK = z;
                }
                this.cCQ = aX.cBK ? 3 : 2;
                if (c.FZ() || c.Ga()) {
                    this.cCR.a(this.bYl, true);
                } else {
                    a(str, 11, 2, 0.0f, 0.0f, 0);
                }
            } else if (aX.Cv() && !hw.Cs()) {
                a(str, 11, 1, 0.0f, 0.0f, 0);
            }
        }
    }

    public final void Dr() {
        v.i("MicroMsg.ReportLocation", "Stop report");
        this.cCQ = 0;
        if (this.cCR != null) {
            this.cCR.c(this.bYl);
        }
        if (ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.wH().b(this.cCV);
        }
    }

    static void a(String str, int i, int i2, float f, float f2, int i3) {
        String str2;
        if (i2 == 3) {
            str2 = "<event></event>";
        } else {
            str2 = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[]{Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i3)});
        }
        v.i("MicroMsg.ReportLocation", "doScene, info: %s", str2);
        ak.vy().a(new n(str, i, str2), 0);
    }
}

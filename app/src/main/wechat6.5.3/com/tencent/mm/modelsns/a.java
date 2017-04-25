package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.axw;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    private static boolean cXI = false;
    private static AtomicInteger cZM = new AtomicInteger(0);
    public Object cZC = null;
    public int cZD = 1;
    public long cZE;
    public int cZF;
    public int cZG;
    public int cZH;
    public StringBuffer cZI = new StringBuffer();
    public StringBuffer cZJ = new StringBuffer();
    public StringBuffer cZK = new StringBuffer();
    public StringBuffer cZL = new StringBuffer();
    public int opType = 0;

    static /* synthetic */ void a(a aVar) {
        c cVar = new c();
        cVar.n("\n\nmodel", aVar.cZD + ",");
        cVar.n("opType", aVar.opType + ",");
        cVar.n("timeStamp", aVar.cZE + ",");
        cVar.n("seq", aVar.cZF + ",");
        cVar.n("netWork", aVar.cZG + ",");
        cVar.n("page", aVar.cZH + ",");
        cVar.n("StatusDesc1", aVar.cZI.toString() + ",");
        cVar.n("DataFlowSourceInfo", aVar.cZJ.toString() + ",");
        cVar.n("DataFlowResultInfo", aVar.cZK.toString() + ",");
        cVar.n("StatusDesc2", aVar.cZL.toString() + ", ");
        cVar.cZQ.append("bindkey: " + aVar.cZC);
        v.d("MicroMsg.StatisticsOplog", "report logbuffer: " + cVar.JH());
        g.iuh.h(12645, cVar);
    }

    public static a gh(int i) {
        return new a(i, 1);
    }

    public static a gi(int i) {
        return new a(i, 4);
    }

    public final boolean JB() {
        int i = b.cZO;
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            if (this.opType >= 501 && this.opType <= 700) {
                return true;
            }
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
        }
        if (i == 2 && this.opType >= 701 && this.opType <= 1000) {
            return true;
        }
        if (i == 3 && this.opType >= 501 && this.opType <= 700) {
            return true;
        }
        if (i == 4) {
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
            if (this.opType >= 501 && this.opType <= 700) {
                return true;
            }
        }
        return false;
    }

    public a(int i, int i2) {
        this.opType = i;
        this.cZH = i2;
        if (JB()) {
            this.cZE = System.currentTimeMillis();
            if (ak.isWifi(aa.getContext())) {
                this.cZG = 4;
            } else if (ak.is4G(aa.getContext())) {
                this.cZG = 3;
            } else if (ak.is3G(aa.getContext())) {
                this.cZG = 2;
            } else if (ak.is2G(aa.getContext())) {
                this.cZG = 1;
            } else {
                this.cZG = 0;
            }
            this.cZF = cZM.incrementAndGet();
        }
    }

    public final boolean gj(int i) {
        this.cZC = Integer.valueOf(i);
        return true;
    }

    public final void update() {
        if (JB()) {
            this.cZE = System.currentTimeMillis();
            this.cZF = cZM.incrementAndGet();
        }
    }

    public final a kj(String str) {
        if (JB()) {
            if (this.cZI.length() != 0) {
                this.cZI.append("||" + str);
            } else if (be.kS(str)) {
                this.cZI.append(" ");
            } else {
                this.cZI.append(str);
            }
        }
        return this;
    }

    public final a gk(int i) {
        return kj(String.valueOf(i));
    }

    public final a kk(String str) {
        if (JB()) {
            if (this.cZJ.length() == 0) {
                this.cZJ.append(str);
            } else {
                this.cZJ.append("||" + str);
            }
        }
        return this;
    }

    public final a JC() {
        this.cZJ = new StringBuffer();
        return this;
    }

    public final a JD() {
        this.cZI = new StringBuffer();
        return this;
    }

    public final a kl(String str) {
        if (JB()) {
            if (this.cZK.length() == 0) {
                this.cZK.append(str);
            } else {
                this.cZK.append("||" + str);
            }
        }
        return this;
    }

    public final a bg(boolean z) {
        return kj(z ? "1" : "0");
    }

    public final a gl(int i) {
        if (JB()) {
            if (this.cZJ.length() == 0) {
                this.cZJ.append(i);
            } else {
                this.cZJ.append("||" + i);
            }
        }
        return this;
    }

    public static void JE() {
        v.i("MicroMsg.StatisticsOplog", "wait op");
    }

    public final boolean JF() {
        if (!JB()) {
            return false;
        }
        e.a(new Runnable(this) {
            final /* synthetic */ a cZN;

            {
                this.cZN = r1;
            }

            public final void run() {
                a.a(this.cZN);
            }
        }, "StatisticsOplog");
        return true;
    }

    public final byte[] BX() {
        axw com_tencent_mm_protocal_c_axw = new axw();
        com_tencent_mm_protocal_c_axw.opType = this.opType;
        com_tencent_mm_protocal_c_axw.cZH = this.cZH;
        com_tencent_mm_protocal_c_axw.cZD = this.cZD;
        com_tencent_mm_protocal_c_axw.cZE = this.cZE;
        com_tencent_mm_protocal_c_axw.cZF = this.cZF;
        com_tencent_mm_protocal_c_axw.cZG = this.cZG;
        com_tencent_mm_protocal_c_axw.mVo = this.cZI.toString();
        com_tencent_mm_protocal_c_axw.mVp = this.cZL.toString();
        com_tencent_mm_protocal_c_axw.mVq = this.cZJ.toString();
        com_tencent_mm_protocal_c_axw.mVr = this.cZK.toString();
        try {
            return com_tencent_mm_protocal_c_axw.toByteArray();
        } catch (Exception e) {
            v.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            return null;
        }
    }

    public final void b(Intent intent, String str) {
        byte[] BX = BX();
        if (BX != null) {
            intent.putExtra(str, BX);
        }
    }

    public static a m(Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("intent_key_StatisticsOplog");
        return byteArray == null ? null : C(byteArray);
    }

    public static a m(Intent intent) {
        return c(intent, "intent_key_StatisticsOplog");
    }

    public static a c(Intent intent, String str) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return C(byteArrayExtra);
    }

    private static a C(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        axw com_tencent_mm_protocal_c_axw = new axw();
        try {
            com_tencent_mm_protocal_c_axw.az(bArr);
            a aVar = new a(com_tencent_mm_protocal_c_axw.opType, com_tencent_mm_protocal_c_axw.cZH);
            aVar.cZD = com_tencent_mm_protocal_c_axw.cZD;
            aVar.cZE = com_tencent_mm_protocal_c_axw.cZE;
            aVar.cZF = com_tencent_mm_protocal_c_axw.cZF;
            aVar.cZG = com_tencent_mm_protocal_c_axw.cZG;
            aVar.cZI = new StringBuffer(com_tencent_mm_protocal_c_axw.mVo);
            aVar.cZL = new StringBuffer(com_tencent_mm_protocal_c_axw.mVp);
            aVar.cZJ = new StringBuffer(com_tencent_mm_protocal_c_axw.mVq);
            aVar.cZK = new StringBuffer(com_tencent_mm_protocal_c_axw.mVr);
            return aVar;
        } catch (Exception e) {
            v.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            return null;
        }
    }
}

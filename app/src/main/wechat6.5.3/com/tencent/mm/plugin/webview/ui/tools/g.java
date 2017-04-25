package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.modelsns.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class g {
    public static g pRr = new g();
    String aZj;
    boolean cvW = false;
    String juo;
    int networkType;
    String pRs;

    private g() {
    }

    public final void zT(int i) {
        if (!be.kS(this.juo)) {
            e(3, "", i);
        }
    }

    public final void close() {
        this.cvW = true;
        if (!be.kS(this.juo)) {
            kZ(4);
            this.juo = null;
        }
    }

    final void kZ(int i) {
        e(i, "", 0);
    }

    final void e(int i, String str, int i2) {
        c cVar = new c();
        cVar.n("20adInfo", this.juo + ",");
        cVar.n("21optype", i + ",");
        cVar.n("22sessionId", this.aZj + ",");
        cVar.n("23currURL", this.pRs + ",");
        cVar.n("24referURL", str + ",");
        cVar.n("25errCode", i2 + ",");
        cVar.n("26networkType", this.networkType + ",");
        cVar.n("27timeStamp", be.Ni() + ",");
        v.d("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[]{Integer.valueOf(i), this.aZj, this.pRs, str, Integer.valueOf(i2), Integer.valueOf(this.networkType)});
        com.tencent.mm.plugin.report.service.g.iuh.h(13791, new Object[]{cVar});
    }
}

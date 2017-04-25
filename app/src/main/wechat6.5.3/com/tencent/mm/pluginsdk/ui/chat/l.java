package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.as.u;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.e.a.lj;
import com.tencent.mm.e.a.oq;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class l implements OnClickListener {
    private Context context;

    public static class a {
        public String aRm;
        public String appId;
        public String bmE;
        public long bmL;
        public String bmm;
        public int lNV;
        public String lNW;
        public int scene;
    }

    public static class b {
        public String appId;
        public String bmm;
    }

    public l(Context context) {
        this.context = context;
    }

    public final void onClick(View view) {
        boolean z = true;
        Object tag = view.getTag();
        com.tencent.mm.sdk.c.b oqVar;
        if (tag instanceof b) {
            String e;
            b bVar = (b) tag;
            if (bVar == null || view == null) {
                v.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
            } else {
                Intent intent;
                if ("wx485a97c844086dc9".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_music", true);
                    c.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                } else if ("wxfbc915ff7c30e335".equals(bVar.appId)) {
                    if (!com.tencent.mm.af.b.Hd()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 1);
                        if (!(u.bi(this.context) || com.tencent.mm.ah.a.aT(this.context))) {
                            c.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx482a4001c37e2b74".equals(bVar.appId)) {
                    if (!com.tencent.mm.af.b.Hd()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 2);
                        if (!(u.bi(this.context) || com.tencent.mm.ah.a.aT(this.context))) {
                            c.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx751a1acca5688ba3".equals(bVar.appId)) {
                    if (!com.tencent.mm.af.b.Hd()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 5);
                        if (!(u.bi(this.context) || com.tencent.mm.ah.a.aT(this.context))) {
                            c.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wxaf060266bfa9a35c".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    c.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                }
                if (!z) {
                    e = p.e(this.context, bVar.appId, bVar.bmm);
                    oqVar = new oq();
                    oqVar.bpW.bpX = e;
                    oqVar.bpW.context = this.context;
                    com.tencent.mm.sdk.c.a.nhr.z(oqVar);
                }
            }
            z = false;
            if (!z) {
                e = p.e(this.context, bVar.appId, bVar.bmm);
                oqVar = new oq();
                oqVar.bpW.bpX = e;
                oqVar.bpW.context = this.context;
                com.tencent.mm.sdk.c.a.nhr.z(oqVar);
            }
        } else if (tag instanceof a) {
            a aVar = (a) tag;
            oqVar = new fq();
            oqVar.beY.actionCode = 2;
            oqVar.beY.scene = aVar.scene;
            oqVar.beY.beZ = "chatting_src=" + aVar.scene;
            oqVar.beY.appId = aVar.appId;
            oqVar.beY.context = this.context;
            com.tencent.mm.sdk.c.a.nhr.z(oqVar);
            oqVar = new lj();
            oqVar.bmI.context = this.context;
            oqVar.bmI.scene = aVar.scene;
            oqVar.bmI.bmJ = aVar.appId;
            oqVar.bmI.packageName = aVar.aRm;
            oqVar.bmI.msgType = aVar.lNV;
            oqVar.bmI.bhM = aVar.bmE;
            oqVar.bmI.bmK = 5;
            oqVar.bmI.mediaTagName = aVar.lNW;
            oqVar.bmI.bmL = aVar.bmL;
            oqVar.bmI.bmM = SQLiteDatabase.KeyEmpty;
            com.tencent.mm.sdk.c.a.nhr.z(oqVar);
        }
    }
}

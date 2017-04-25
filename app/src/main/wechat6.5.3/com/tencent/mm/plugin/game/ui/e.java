package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.at;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.j;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.c.t;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.pluginsdk.model.downloader.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.i;
import java.util.Set;

public final class e {
    int gjl = 0;
    String gpa = null;
    private g gpr = null;
    private u gps = null;
    private p gpt = null;
    private t gpu = null;
    OnClickListener gpv = null;
    Dialog gpw;
    private int gpx = 3000;
    private ah gpy = new ah(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ e gpz;

        {
            this.gpz = r1;
        }

        public final boolean oU() {
            if (this.gpz.gpw != null) {
                this.gpz.gpw.cancel();
            }
            return true;
        }
    }, false);
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public final void a(c cVar, j jVar) {
        if (cVar == null || jVar == null) {
            v.e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
            return;
        }
        View view = new View(this.mContext);
        view.setTag(cVar);
        v.i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", new Object[]{Integer.valueOf(cVar.status), Integer.valueOf(jVar.mode), Integer.valueOf(jVar.status)});
        if (g.o(this.mContext, cVar.field_appId)) {
            jVar.mode = 1;
        }
        if (jVar.mode == 3) {
            at.arX();
            int e = at.e(this.mContext, "com.tencent.android.qqdownloader", cVar.bxD);
            v.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", new Object[]{Integer.valueOf(e), Integer.valueOf(cVar.bxD)});
            if (e == -1 || e == 1 || e == 2) {
                jVar.mode = 1;
            }
        }
        f GN;
        switch (cVar.status) {
            case 0:
            case 3:
            case 4:
                n ue = au.asc().ue(cVar.field_appId);
                if (ue != null) {
                    v.i("MicroMsg.GameActionBtnHandler", "delete msg, appid = " + ue.field_appId);
                    au.asc().c(ue, new String[0]);
                }
                switch (jVar.mode) {
                    case 3:
                        GN = d.bnK().GN(cVar.field_appId);
                        if (GN != null && GN.id > 0) {
                            d.bnK().dm(GN.id);
                        }
                        if (this.gps == null) {
                            this.gps = new u(this.mContext);
                        }
                        u uVar = this.gps;
                        int i = this.gjl;
                        String str = this.gpa;
                        uVar.gjl = i;
                        uVar.gpa = str;
                        this.gps.onClick(view);
                        break;
                    case 4:
                        if (!be.kS(cVar.bxu)) {
                            v.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
                            p.aO(this.mContext, cVar.bxu);
                            af.a(this.mContext, cVar.scene, cVar.bmG, cVar.position, 25, cVar.field_appId, this.gjl, cVar.bln, this.gpa);
                            break;
                        }
                        break;
                    default:
                        v.d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", new Object[]{Integer.valueOf(jVar.mode)});
                        if (this.gpr == null) {
                            this.gpr = new g(this.mContext);
                        }
                        this.gpr.lu(this.gjl);
                        this.gpr.bJ(this.gpa, "");
                        this.gpr.onClick(view);
                        break;
                }
                if (cVar.ghy) {
                    Set bT = com.tencent.mm.plugin.game.c.e.bT(this.mContext);
                    if (!a(bT, cVar.field_appId)) {
                        if (jVar.mode != 3) {
                            View inflate = LayoutInflater.from(this.mContext).inflate(2130903722, null);
                            ((LinearLayout) inflate.findViewById(2131757307)).setGravity(17);
                            TextView textView = (TextView) inflate.findViewById(2131758207);
                            TextView textView2 = (TextView) inflate.findViewById(2131756402);
                            ((ImageView) inflate.findViewById(2131756400)).setBackgroundResource(2130838129);
                            textView.setText(2131233085);
                            textView2.setText(2131233084);
                            this.gpw = new i(this.mContext, 2131558757);
                            this.gpw.setContentView(inflate);
                            this.gpw.setCancelable(true);
                            this.gpw.setCanceledOnTouchOutside(true);
                            this.gpw.show();
                            this.gpy.ea((long) this.gpx);
                        }
                        au.asf();
                        t.a(cVar.field_appId, 1, 0, null, null);
                        bT.add(cVar.field_appId);
                        this.mContext.getSharedPreferences("game_center_pref", 0).edit().putStringSet("show_download_gift_tips", bT).commit();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (this.gpu == null) {
                    this.gpu = new t(this.mContext);
                    this.gpu.gyJ = this.gpv;
                }
                this.gpu.gjl = this.gjl;
                this.gpu.onClick(view);
                af.a(this.mContext, cVar.scene, cVar.bmG, cVar.position, 9, cVar.field_appId, this.gjl, cVar.bln, this.gpa);
                return;
            case 2:
                GN = d.bnK().GN(cVar.field_appId);
                if (GN != null && GN.id > 0) {
                    d.bnK().dm(GN.id);
                }
                if (this.gpt == null) {
                    this.gpt = new p(this.mContext);
                }
                this.gpt.exT = this.gjl;
                this.gpt.gwm = cVar.bxy;
                this.gpt.onClick(view);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.widget.ProgressBar r8, android.widget.Button r9, com.tencent.mm.plugin.game.c.c r10, com.tencent.mm.plugin.game.c.j r11) {
        /*
        r7 = this;
        r4 = 3;
        r6 = 1;
        r3 = 12;
        r2 = 8;
        r5 = 0;
        if (r8 == 0) goto L_0x000b;
    L_0x0009:
        if (r9 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r9.setEnabled(r6);
        r9.setVisibility(r5);
        r0 = r7.mContext;
        r0 = com.tencent.mm.pluginsdk.model.app.g.a(r0, r10);
        if (r0 == 0) goto L_0x0082;
    L_0x001a:
        r0 = r10.field_packageName;
        r0 = com.tencent.mm.plugin.game.e.c.ut(r0);
        r1 = r10.versionCode;
        if (r1 <= r0) goto L_0x006a;
    L_0x0024:
        r1 = r11.status;
        if (r1 != r6) goto L_0x0052;
    L_0x0028:
        r8.setVisibility(r5);
        r1 = r11.progress;
        r8.setProgress(r1);
        r9.setVisibility(r2);
    L_0x0033:
        r1 = "MicroMsg.GameActionBtnHandler";
        r2 = "AppId: %s installed, local: %d, server: %d";
        r3 = new java.lang.Object[r4];
        r4 = r10.field_appId;
        r3[r5] = r4;
        r0 = java.lang.Integer.valueOf(r0);
        r3[r6] = r0;
        r0 = 2;
        r4 = r10.versionCode;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r0] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
        goto L_0x000b;
    L_0x0052:
        r1 = r10.scene;
        if (r1 != r3) goto L_0x0063;
    L_0x0056:
        r1 = 2131233074; // 0x7f080932 float:1.8082275E38 double:1.052969045E-314;
        r9.setText(r1);
    L_0x005c:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x0033;
    L_0x0063:
        r1 = 2131233059; // 0x7f080923 float:1.8082245E38 double:1.0529690377E-314;
        r9.setText(r1);
        goto L_0x005c;
    L_0x006a:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        r1 = r10.scene;
        if (r1 != r3) goto L_0x007b;
    L_0x0074:
        r1 = 2131233072; // 0x7f080930 float:1.8082271E38 double:1.052969044E-314;
        r9.setText(r1);
        goto L_0x0033;
    L_0x007b:
        r1 = 2131233100; // 0x7f08094c float:1.8082328E38 double:1.052969058E-314;
        r9.setText(r1);
        goto L_0x0033;
    L_0x0082:
        r0 = r10.status;
        switch(r0) {
            case 0: goto L_0x00ad;
            case 1: goto L_0x013b;
            case 2: goto L_0x015e;
            case 3: goto L_0x016c;
            case 4: goto L_0x01d9;
            default: goto L_0x0087;
        };
    L_0x0087:
        r9.setVisibility(r2);
        r8.setVisibility(r2);
    L_0x008d:
        r0 = "MicroMsg.GameActionBtnHandler";
        r1 = "updateBtnStateAndText: %s, Status: %d, Text: %s";
        r2 = new java.lang.Object[r4];
        r3 = r10.field_appId;
        r2[r5] = r3;
        r3 = r10.status;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r6] = r3;
        r3 = 2;
        r4 = r9.getText();
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        goto L_0x000b;
    L_0x00ad:
        if (r11 != 0) goto L_0x00b7;
    L_0x00af:
        r9.setVisibility(r2);
        r8.setVisibility(r2);
        goto L_0x000b;
    L_0x00b7:
        r0 = r11.status;
        switch(r0) {
            case 0: goto L_0x00bd;
            case 1: goto L_0x00ee;
            case 2: goto L_0x0110;
            case 3: goto L_0x0129;
            default: goto L_0x00bc;
        };
    L_0x00bc:
        goto L_0x008d;
    L_0x00bd:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x00e7;
    L_0x00c1:
        r0 = r10.ghy;
        if (r0 == 0) goto L_0x00e0;
    L_0x00c5:
        r0 = r10.field_appId;
        r1 = r7.mContext;
        r1 = com.tencent.mm.plugin.game.c.e.bT(r1);
        r0 = a(r1, r0);
        if (r0 != 0) goto L_0x00e0;
    L_0x00d3:
        r0 = 2131233079; // 0x7f080937 float:1.8082285E38 double:1.0529690476E-314;
        r9.setText(r0);
    L_0x00d9:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x008d;
    L_0x00e0:
        r0 = 2131233096; // 0x7f080948 float:1.808232E38 double:1.052969056E-314;
        r9.setText(r0);
        goto L_0x00d9;
    L_0x00e7:
        r0 = 2131233095; // 0x7f080947 float:1.8082318E38 double:1.0529690555E-314;
        r9.setText(r0);
        goto L_0x00d9;
    L_0x00ee:
        r0 = r11.mode;
        if (r0 != r4) goto L_0x00ff;
    L_0x00f2:
        r0 = 2131233098; // 0x7f08094a float:1.8082324E38 double:1.052969057E-314;
        r9.setText(r0);
    L_0x00f8:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x008d;
    L_0x00ff:
        r0 = r11.mode;
        if (r0 != r6) goto L_0x008d;
    L_0x0103:
        r0 = r11.progress;
        r8.setProgress(r0);
        r9.setVisibility(r2);
        r8.setVisibility(r5);
        goto L_0x008d;
    L_0x0110:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x0122;
    L_0x0114:
        r0 = 2131233078; // 0x7f080936 float:1.8082283E38 double:1.052969047E-314;
        r9.setText(r0);
    L_0x011a:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x008d;
    L_0x0122:
        r0 = 2131233097; // 0x7f080949 float:1.8082322E38 double:1.0529690565E-314;
        r9.setText(r0);
        goto L_0x011a;
    L_0x0129:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x0134;
    L_0x012d:
        r0 = 2131233094; // 0x7f080946 float:1.8082316E38 double:1.052969055E-314;
        r9.setText(r0);
        goto L_0x00f8;
    L_0x0134:
        r0 = 2131233093; // 0x7f080945 float:1.8082314E38 double:1.0529690545E-314;
        r9.setText(r0);
        goto L_0x00f8;
    L_0x013b:
        r0 = r10.ghr;
        if (r0 == 0) goto L_0x0150;
    L_0x013f:
        r9.setEnabled(r5);
        r0 = 2131233057; // 0x7f080921 float:1.808224E38 double:1.0529690367E-314;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x008d;
    L_0x0150:
        r0 = 2131233056; // 0x7f080920 float:1.8082239E38 double:1.0529690363E-314;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x008d;
    L_0x015e:
        r0 = 2131233055; // 0x7f08091f float:1.8082237E38 double:1.052969036E-314;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x008d;
    L_0x016c:
        if (r11 != 0) goto L_0x017c;
    L_0x016e:
        r0 = 2131233054; // 0x7f08091e float:1.8082235E38 double:1.0529690353E-314;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x000b;
    L_0x017c:
        r0 = r11.status;
        switch(r0) {
            case 0: goto L_0x0183;
            case 1: goto L_0x0191;
            case 2: goto L_0x01ae;
            case 3: goto L_0x01c7;
            default: goto L_0x0181;
        };
    L_0x0181:
        goto L_0x008d;
    L_0x0183:
        r0 = 2131233054; // 0x7f08091e float:1.8082235E38 double:1.0529690353E-314;
        r9.setText(r0);
    L_0x0189:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x008d;
    L_0x0191:
        r0 = r11.mode;
        if (r0 != r4) goto L_0x019d;
    L_0x0195:
        r0 = 2131233098; // 0x7f08094a float:1.8082324E38 double:1.052969057E-314;
        r9.setText(r0);
        goto L_0x008d;
    L_0x019d:
        r0 = r11.mode;
        if (r0 != r6) goto L_0x008d;
    L_0x01a1:
        r0 = r11.progress;
        r8.setProgress(r0);
        r9.setVisibility(r2);
        r8.setVisibility(r5);
        goto L_0x008d;
    L_0x01ae:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x01c0;
    L_0x01b2:
        r0 = 2131233078; // 0x7f080936 float:1.8082283E38 double:1.052969047E-314;
        r9.setText(r0);
    L_0x01b8:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x008d;
    L_0x01c0:
        r0 = 2131233097; // 0x7f080949 float:1.8082322E38 double:1.0529690565E-314;
        r9.setText(r0);
        goto L_0x01b8;
    L_0x01c7:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x01d2;
    L_0x01cb:
        r0 = 2131233094; // 0x7f080946 float:1.8082316E38 double:1.052969055E-314;
        r9.setText(r0);
        goto L_0x0189;
    L_0x01d2:
        r0 = 2131233093; // 0x7f080945 float:1.8082314E38 double:1.0529690545E-314;
        r9.setText(r0);
        goto L_0x0189;
    L_0x01d9:
        r0 = 2131233058; // 0x7f080922 float:1.8082243E38 double:1.052969037E-314;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x008d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.e.a(android.widget.ProgressBar, android.widget.Button, com.tencent.mm.plugin.game.c.c, com.tencent.mm.plugin.game.c.j):void");
    }

    private static boolean a(Set<String> set, String str) {
        if (set == null || set.isEmpty() || !set.contains(str)) {
            return false;
        }
        return true;
    }
}

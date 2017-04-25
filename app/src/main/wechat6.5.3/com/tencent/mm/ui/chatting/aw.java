package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.gy;
import com.tencent.mm.e.a.jo;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.n;
import com.tencent.mm.modelappbrand.AppBrandExportUrlParams;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

final class aw extends c {
    private com.tencent.mm.ae.a.a.c fzb;
    a onG;
    private com.tencent.mm.ae.a.a.c onQ;

    public aw(int i) {
        super(i);
        com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
        this.fzb = aVar.GU();
        aVar = new com.tencent.mm.ae.a.a.c.a();
        aVar.cPH = 2131165252;
        aVar.aI(com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 10), com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 10)).cPq = true;
        this.onQ = aVar.GU();
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof m) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903339);
        view.setTag(new m(this.eKg).p(view, false));
        return view;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.ui.chatting.ad.a r23, int r24, com.tencent.mm.ui.chatting.ChattingUI.a r25, com.tencent.mm.storage.at r26, java.lang.String r27) {
        /*
        r22 = this;
        r19 = r23;
        r19 = (com.tencent.mm.ui.chatting.m) r19;
        r0 = r25;
        r1 = r22;
        r1.onG = r0;
        r25.ay(r26);
        r19.reset();
        r0 = r26;
        r0 = r0.field_content;
        r21 = r0;
        r25.aw(r26);
        r4 = 0;
        if (r21 == 0) goto L_0x1212;
    L_0x001c:
        r0 = r26;
        r4 = r0.field_reserved;
        r0 = r21;
        r4 = com.tencent.mm.q.a.a.B(r0, r4);
        r20 = r4;
    L_0x0028:
        r4 = new com.tencent.mm.ui.chatting.dl;
        r0 = r25;
        r6 = r0.nQK;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r5 = r26;
        r7 = r24;
        r4.<init>(r5, r6, r7, r8, r9, r10);
        if (r20 == 0) goto L_0x02a4;
    L_0x003a:
        r0 = r20;
        r5 = r0.appId;
        r0 = r20;
        r6 = r0.bpy;
        r7 = com.tencent.mm.pluginsdk.model.app.g.bA(r5, r6);
        r0 = r19;
        r5 = r0.dtY;
        r0 = r20;
        r6 = r0.title;
        r5.setText(r6);
        r0 = r19;
        r5 = r0.dtZ;
        r0 = r20;
        r6 = r0.description;
        r5.setText(r6);
        r0 = r19;
        r5 = r0.okC;
        r6 = 1;
        r5.setMaxLines(r6);
        r0 = r19;
        r5 = r0.dtY;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = r6.getResources();
        r8 = 2131689909; // 0x7f0f01b5 float:1.9008847E38 double:1.0531947516E-314;
        r6 = r6.getColor(r8);
        r5.setTextColor(r6);
        r0 = r19;
        r5 = r0.dtZ;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = r6.getResources();
        r8 = 2131689792; // 0x7f0f0140 float:1.900861E38 double:1.053194694E-314;
        r6 = r6.getColor(r8);
        r5.setTextColor(r6);
        r0 = r19;
        r5 = r0.okQ;
        r6 = 2130837939; // 0x7f0201b3 float:1.7280846E38 double:1.0527738225E-314;
        r5.setBackgroundResource(r6);
        r0 = r19;
        r5 = r0.okQ;
        r6 = 0;
        r0 = r25;
        r8 = r0.nDR;
        r8 = r8.nEl;
        r8 = r8.getResources();
        r9 = 2131493152; // 0x7f0c0120 float:1.8609776E38 double:1.0530975407E-314;
        r8 = r8.getDimensionPixelSize(r9);
        r9 = 0;
        r10 = 0;
        r5.setPadding(r6, r8, r9, r10);
        r0 = r19;
        r5 = r0.okd;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okO;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.dtZ;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okS;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okT;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okG;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okF;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okD;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okA;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.olb;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okU;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okQ;
        r6 = 0;
        r5.setVisibility(r6);
        if (r7 == 0) goto L_0x0133;
    L_0x0123:
        r5 = r7.field_appName;
        if (r5 == 0) goto L_0x0133;
    L_0x0127:
        r5 = r7.field_appName;
        r5 = r5.trim();
        r5 = r5.length();
        if (r5 > 0) goto L_0x02e5;
    L_0x0133:
        r0 = r20;
        r5 = r0.appName;
    L_0x0137:
        r6 = 1;
        r0 = r25;
        r8 = r0.nDR;
        r8 = r8.nEl;
        r9 = 12;
        com.tencent.mm.bd.a.fromDPToPix(r8, r9);
        r0 = r20;
        r8 = r0.type;
        r9 = 20;
        if (r8 == r9) goto L_0x0158;
    L_0x014b:
        r8 = "wxaf060266bfa9a35c";
        r0 = r20;
        r9 = r0.appId;
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0160;
    L_0x0158:
        r6 = com.tencent.mm.pluginsdk.j.a.bmq();
        r6 = r6.aNM();
    L_0x0160:
        if (r6 == 0) goto L_0x02f8;
    L_0x0162:
        r0 = r20;
        r6 = r0.appId;
        if (r6 == 0) goto L_0x02f8;
    L_0x0168:
        r0 = r20;
        r6 = r0.appId;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x02f8;
    L_0x0172:
        r6 = com.tencent.mm.pluginsdk.model.app.g.bo(r5);
        if (r6 == 0) goto L_0x02f8;
    L_0x0178:
        r0 = r19;
        r6 = r0.fSs;
        r0 = r25;
        r8 = r0.nDR;
        r8 = r8.nEl;
        r5 = com.tencent.mm.pluginsdk.model.app.g.a(r8, r7, r5);
        r6.setText(r5);
        r0 = r19;
        r5 = r0.okB;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.fSs;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.fSs;
        r6 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r5.setCompoundDrawables(r6, r8, r9, r10);
        r0 = r19;
        r5 = r0.okz;
        r6 = 0;
        r5.setVisibility(r6);
        if (r7 == 0) goto L_0x02e9;
    L_0x01ae:
        r5 = r7.bnk();
        if (r5 == 0) goto L_0x02e9;
    L_0x01b4:
        r0 = r19;
        r6 = r0.fSs;
        r9 = r7.field_packageName;
        r0 = r26;
        r10 = r0.field_msgSvrId;
        r5 = r25;
        r7 = r26;
        r8 = r20;
        com.tencent.mm.ui.chatting.ad.a(r5, r6, r7, r8, r9, r10);
    L_0x01c7:
        r0 = r19;
        r5 = r0.okz;
        r0 = r20;
        r6 = r0.appId;
        r0 = r25;
        com.tencent.mm.ui.chatting.ad.a(r0, r5, r6);
    L_0x01d4:
        r5 = 0;
        r0 = r19;
        r6 = r0.okd;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r22;
        r6 = r0.lVu;
        if (r6 == 0) goto L_0x0382;
    L_0x01e3:
        r6 = 0;
        r0 = r20;
        r7 = r0.type;
        r8 = 33;
        if (r7 == r8) goto L_0x0203;
    L_0x01ec:
        r6 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r7 = r0.field_imgPath;
        r0 = r25;
        r8 = r0.nDR;
        r8 = r8.nEl;
        r8 = com.tencent.mm.bd.a.getDensity(r8);
        r9 = 0;
        r6 = r6.a(r7, r8, r9);
    L_0x0203:
        if (r6 == 0) goto L_0x037f;
    L_0x0205:
        r7 = r6.isRecycled();
        if (r7 != 0) goto L_0x037f;
    L_0x020b:
        r0 = r19;
        r7 = r0.okd;
        r7.setImageBitmap(r6);
    L_0x0212:
        r0 = r20;
        r7 = r0.type;
        r8 = 3;
        if (r7 != r8) goto L_0x022f;
    L_0x0219:
        r0 = r19;
        r7 = r0.okQ;
        r7 = r7.getViewTreeObserver();
        r8 = new com.tencent.mm.ui.chatting.aw$1;
        r0 = r22;
        r1 = r19;
        r2 = r25;
        r8.<init>(r0, r1, r2, r6);
        r7.addOnPreDrawListener(r8);
    L_0x022f:
        r0 = r19;
        r6 = r0.okH;
        r7 = 0;
        r6.setOnClickListener(r7);
        r0 = r20;
        r6 = r0.type;
        switch(r6) {
            case 0: goto L_0x0ad2;
            case 1: goto L_0x023e;
            case 2: goto L_0x023e;
            case 3: goto L_0x0396;
            case 4: goto L_0x0559;
            case 5: goto L_0x05e8;
            case 6: goto L_0x04c4;
            case 7: goto L_0x0875;
            case 8: goto L_0x023e;
            case 9: goto L_0x023e;
            case 10: goto L_0x092a;
            case 11: goto L_0x023e;
            case 12: goto L_0x023e;
            case 13: goto L_0x09e5;
            case 14: goto L_0x023e;
            case 15: goto L_0x0b50;
            case 16: goto L_0x0df5;
            case 17: goto L_0x023e;
            case 18: goto L_0x023e;
            case 19: goto L_0x0f62;
            case 20: goto L_0x0a58;
            case 21: goto L_0x023e;
            case 22: goto L_0x023e;
            case 23: goto L_0x023e;
            case 24: goto L_0x0e88;
            case 25: goto L_0x0c06;
            case 26: goto L_0x0cba;
            case 27: goto L_0x0cba;
            case 28: goto L_0x023e;
            case 29: goto L_0x023e;
            case 30: goto L_0x023e;
            case 31: goto L_0x023e;
            case 32: goto L_0x023e;
            case 33: goto L_0x06da;
            case 34: goto L_0x1034;
            default: goto L_0x023e;
        };
    L_0x023e:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x11fb;
    L_0x0244:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x11fb;
    L_0x024e:
        r0 = r19;
        r6 = r0.okC;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 2;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okC;
        r0 = r20;
        r7 = r0.title;
        r6.setText(r7);
    L_0x0269:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0299;
    L_0x0274:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = r5.a(r6, r7);
        if (r5 == 0) goto L_0x1206;
    L_0x028c:
        r6 = r5.isRecycled();
        if (r6 != 0) goto L_0x1206;
    L_0x0292:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
    L_0x0299:
        r0 = r20;
        r5 = r0.cob;
        r0 = r19;
        r1 = r21;
        com.tencent.mm.ui.chatting.m.a(r0, r1, r5);
    L_0x02a4:
        r0 = r19;
        r5 = r0.okP;
        r5.setTag(r4);
        r0 = r19;
        r4 = r0.okP;
        r0 = r25;
        r5 = r0.onh;
        r5 = r5.oqh;
        r4.setOnClickListener(r5);
        r0 = r22;
        r4 = r0.lVu;
        if (r4 == 0) goto L_0x02cb;
    L_0x02be:
        r0 = r19;
        r4 = r0.okP;
        r0 = r25;
        r5 = r0.onh;
        r5 = r5.oqj;
        r4.setOnLongClickListener(r5);
    L_0x02cb:
        r0 = r25;
        r4 = r0.onh;
        r7 = r4.cyO;
        r0 = r25;
        r8 = r0.nQK;
        r0 = r25;
        r4 = r0.onh;
        r9 = r4.oqh;
        r4 = r24;
        r5 = r19;
        r6 = r26;
        com.tencent.mm.ui.chatting.ad.a(r4, r5, r6, r7, r8, r9);
        return;
    L_0x02e5:
        r5 = r7.field_appName;
        goto L_0x0137;
    L_0x02e9:
        r0 = r19;
        r5 = r0.fSs;
        r0 = r20;
        r6 = r0.appId;
        r0 = r25;
        com.tencent.mm.ui.chatting.ad.a(r0, r5, r6);
        goto L_0x01c7;
    L_0x02f8:
        r0 = r20;
        r5 = r0.type;
        r6 = 24;
        if (r5 != r6) goto L_0x032d;
    L_0x0300:
        r0 = r19;
        r5 = r0.fSs;
        r6 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r7 = 2131232638; // 0x7f08077e float:1.808139E38 double:1.0529688297E-314;
        r6 = r6.getString(r7);
        r5.setText(r6);
        r0 = r19;
        r5 = r0.okB;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.fSs;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okz;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x01d4;
    L_0x032d:
        r0 = r20;
        r5 = r0.type;
        r6 = 19;
        if (r5 != r6) goto L_0x0362;
    L_0x0335:
        r0 = r19;
        r5 = r0.fSs;
        r6 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r7 = 2131231816; // 0x7f080448 float:1.8079724E38 double:1.0529684236E-314;
        r6 = r6.getString(r7);
        r5.setText(r6);
        r0 = r19;
        r5 = r0.okB;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.fSs;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okz;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x01d4;
    L_0x0362:
        r0 = r19;
        r5 = r0.okB;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.fSs;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okz;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x01d4;
    L_0x037f:
        r5 = 1;
        goto L_0x0212;
    L_0x0382:
        r0 = r19;
        r6 = r0.okd;
        r7 = r25.getResources();
        r8 = 2130838790; // 0x7f020506 float:1.7282572E38 double:1.052774243E-314;
        r7 = android.graphics.BitmapFactory.decodeResource(r7, r8);
        r6.setImageBitmap(r7);
        goto L_0x022f;
    L_0x0396:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0486;
    L_0x039c:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0486;
    L_0x03a6:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtY;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = r7.getResources();
        r8 = 2131690127; // 0x7f0f028f float:1.9009289E38 double:1.0531948593E-314;
        r7 = r7.getColor(r8);
        r6.setTextColor(r7);
    L_0x03c6:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtZ;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = r7.getResources();
        r8 = 2131690127; // 0x7f0f028f float:1.9009289E38 double:1.0531948593E-314;
        r7 = r7.getColor(r8);
        r6.setTextColor(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 2;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r23;
        r6 = r0.onE;
        r0 = r26;
        r8 = r0.field_msgId;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 != 0) goto L_0x0491;
    L_0x0413:
        r0 = r19;
        r6 = r0.okH;
        r7 = 2130838733; // 0x7f0204cd float:1.7282457E38 double:1.052774215E-314;
        r6.setImageResource(r7);
    L_0x041d:
        r6 = new com.tencent.mm.ui.chatting.cp$b;
        r6.<init>();
        r0 = r26;
        r8 = r0.field_msgId;
        r6.bao = r8;
        r0 = r26;
        r7 = r0.field_content;
        r6.blq = r7;
        r0 = r26;
        r7 = r0.field_imgPath;
        r6.bhr = r7;
        r0 = r19;
        r7 = r0.okH;
        r7.setTag(r6);
        r0 = r19;
        r6 = r0.okH;
        r0 = r25;
        r7 = r0.onh;
        r7 = r7.oqp;
        r6.setOnClickListener(r7);
        if (r5 == 0) goto L_0x046f;
    L_0x044a:
        r0 = r20;
        r5 = r0.appId;
        r6 = 1;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = com.tencent.mm.pluginsdk.model.app.g.b(r5, r6, r7);
        if (r5 == 0) goto L_0x0465;
    L_0x045f:
        r6 = r5.isRecycled();
        if (r6 == 0) goto L_0x049c;
    L_0x0465:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165232; // 0x7f070030 float:1.7944675E38 double:1.0529355267E-314;
        r5.setImageResource(r6);
    L_0x046f:
        r5 = com.tencent.mm.ui.chatting.ad.bEA();
        if (r5 == 0) goto L_0x04a4;
    L_0x0475:
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x047b:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x0486:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x03c6;
    L_0x0491:
        r0 = r19;
        r6 = r0.okH;
        r7 = 2130838735; // 0x7f0204cf float:1.728246E38 double:1.052774216E-314;
        r6.setImageResource(r7);
        goto L_0x041d;
    L_0x049c:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x046f;
    L_0x04a4:
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x04aa:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r26;
        r5 = r0.field_status;
        r6 = 2;
        if (r5 < r6) goto L_0x0299;
    L_0x04b9:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x04c4:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x054f;
    L_0x04ca:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x054f;
    L_0x04d4:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtY;
        r7 = 2;
        r6.setMaxLines(r7);
    L_0x04e4:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 2;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.dtZ;
        r0 = r20;
        r7 = r0.cob;
        r8 = (long) r7;
        r7 = com.tencent.mm.sdk.platformtools.be.aw(r8);
        r6.setText(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        r6 = 0;
        r6 = java.lang.Boolean.valueOf(r6);
        r0 = r20;
        r7 = r0.aXa;
        r0 = r20;
        r8 = r0.title;
        r0 = r19;
        r1 = r26;
        com.tencent.mm.ui.chatting.m.a(r0, r6, r1, r7, r8);
        if (r5 == 0) goto L_0x0299;
    L_0x0534:
        r0 = r20;
        r5 = r0.coc;
        r5 = com.tencent.mm.sdk.platformtools.be.KY(r5);
        if (r5 != 0) goto L_0x1206;
    L_0x053e:
        r0 = r19;
        r5 = r0.okd;
        r0 = r20;
        r6 = r0.coc;
        r6 = com.tencent.mm.pluginsdk.model.p.Gt(r6);
        r5.setImageResource(r6);
        goto L_0x0299;
    L_0x054f:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x04e4;
    L_0x0559:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x05d6;
    L_0x055f:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x05d6;
    L_0x0569:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0571:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 2;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 2130839370; // 0x7f02074a float:1.7283749E38 double:1.0527745295E-314;
        r6.setImageResource(r7);
        if (r5 == 0) goto L_0x0299;
    L_0x05a6:
        r0 = r20;
        r5 = r0.appId;
        r6 = 1;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = com.tencent.mm.pluginsdk.model.app.g.b(r5, r6, r7);
        if (r5 == 0) goto L_0x05c1;
    L_0x05bb:
        r6 = r5.isRecycled();
        if (r6 == 0) goto L_0x05e0;
    L_0x05c1:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165244; // 0x7f07003c float:1.79447E38 double:1.0529355327E-314;
        r5.setImageResource(r6);
    L_0x05cb:
        r0 = r19;
        r5 = r0.okH;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x05d6:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0571;
    L_0x05e0:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x05cb;
    L_0x05e8:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x068c;
    L_0x05f7:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x068c;
    L_0x0601:
        r0 = r19;
        r6 = r0.okC;
        r7 = 2;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r0 = r20;
        r7 = r0.title;
        r6.setText(r7);
    L_0x061c:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 3;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x066a;
    L_0x0637:
        r0 = r20;
        r5 = r0.appId;
        r6 = 1;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = com.tencent.mm.pluginsdk.model.app.g.b(r5, r6, r7);
        if (r5 != 0) goto L_0x06a1;
    L_0x064c:
        r5 = new com.tencent.mm.pluginsdk.model.r;
        r0 = r20;
        r6 = r0.thumburl;
        r0 = r26;
        r7 = r0.field_type;
        r8 = "@S";
        r9 = 0;
        r5.<init>(r6, r7, r8, r9);
        r5 = com.tencent.mm.platformtools.j.a(r5);
        if (r5 == 0) goto L_0x0696;
    L_0x0663:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
    L_0x066a:
        r5 = com.tencent.mm.ui.chatting.ad.bEA();
        if (r5 == 0) goto L_0x06ba;
    L_0x0670:
        r0 = r25;
        r5 = r0.onh;
        r0 = r19;
        r1 = r26;
        a(r0, r5, r1);
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x0681:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x068c:
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x061c;
    L_0x0696:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x066a;
    L_0x06a1:
        r6 = r5.isRecycled();
        if (r6 == 0) goto L_0x06b2;
    L_0x06a7:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x066a;
    L_0x06b2:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x066a;
    L_0x06ba:
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x06c0:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r26;
        r5 = r0.field_status;
        r6 = 2;
        if (r5 < r6) goto L_0x0299;
    L_0x06cf:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x06da:
        r6 = new com.tencent.mm.e.a.m;
        r6.<init>();
        r5 = r6.aWJ;
        r0 = r20;
        r7 = r0.cqp;
        r5.aWH = r7;
        r5 = com.tencent.mm.sdk.c.a.nhr;
        r5.z(r6);
        r5 = r6.aWK;
        r5 = r5.aWL;
        if (r5 == 0) goto L_0x0729;
    L_0x06f2:
        r5 = r6.aWK;
        r5 = r5.appName;
    L_0x06f6:
        r7 = r6.aWK;
        r7 = r7.aWL;
        if (r7 == 0) goto L_0x072e;
    L_0x06fc:
        r6 = r6.aWK;
        r6 = r6.aWM;
    L_0x0700:
        r0 = r20;
        r7 = r0.cqr;
        switch(r7) {
            case 1: goto L_0x0821;
            case 2: goto L_0x0733;
            default: goto L_0x0707;
        };
    L_0x0707:
        r5 = com.tencent.mm.ui.chatting.ad.bEA();
        if (r5 == 0) goto L_0x0855;
    L_0x070d:
        r0 = r25;
        r5 = r0.onh;
        r0 = r19;
        r1 = r26;
        a(r0, r5, r1);
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x071e:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x0729:
        r0 = r20;
        r5 = r0.bnS;
        goto L_0x06f6;
    L_0x072e:
        r0 = r20;
        r6 = r0.cqv;
        goto L_0x0700;
    L_0x0733:
        r0 = r19;
        r7 = r0.okQ;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r19;
        r7 = r0.olb;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r19;
        r7 = r0.okU;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r19;
        r8 = r0.okX;
        r0 = r20;
        r7 = r0.description;
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 == 0) goto L_0x07e3;
    L_0x075b:
        r7 = 8;
    L_0x075d:
        r8.setVisibility(r7);
        r0 = r19;
        r7 = r0.old;
        r0 = r20;
        r8 = r0.title;
        r7.setText(r8);
        r0 = r19;
        r7 = r0.okX;
        r0 = r20;
        r8 = r0.description;
        r7.setText(r8);
        r0 = r19;
        r7 = r0.okZ;
        r7.setText(r5);
        r0 = r20;
        r5 = r0.cqt;
        switch(r5) {
            case 1: goto L_0x07e6;
            case 2: goto L_0x0803;
            default: goto L_0x0784;
        };
    L_0x0784:
        r0 = r19;
        r5 = r0.okY;
        r7 = 0;
        r5.setVisibility(r7);
        r0 = r19;
        r5 = r0.okZ;
        r7 = 0;
        r5.setVisibility(r7);
        r0 = r19;
        r5 = r0.ola;
        r7 = 2131230936; // 0x7f0800d8 float:1.8077939E38 double:1.052967989E-314;
        r5.setText(r7);
    L_0x079e:
        r5 = com.tencent.mm.ae.n.GL();
        r0 = r19;
        r7 = r0.okY;
        r0 = r22;
        r8 = r0.onQ;
        r5.a(r6, r7, r8);
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r7 = 1;
        r7 = r5.x(r6, r7);
        r0 = r19;
        r5 = r0.olc;
        r6 = 0;
        r5.setImageBitmap(r6);
        r5 = com.tencent.mm.t.a.b.AL();
        r0 = r19;
        r6 = r0.olc;
        r8 = new java.lang.StringBuilder;
        r9 = "file://";
        r8.<init>(r9);
        r7 = r8.append(r7);
        r7 = r7.toString();
        r8 = 0;
        r9 = 0;
        r10 = com.tencent.mm.ui.chatting.m.a.fVO;
        r5.a(r6, r7, r8, r9, r10);
        goto L_0x0707;
    L_0x07e3:
        r7 = 0;
        goto L_0x075d;
    L_0x07e6:
        r0 = r19;
        r5 = r0.okY;
        r7 = 8;
        r5.setVisibility(r7);
        r0 = r19;
        r5 = r0.okZ;
        r7 = 8;
        r5.setVisibility(r7);
        r0 = r19;
        r5 = r0.ola;
        r7 = 2131230999; // 0x7f080117 float:1.8078067E38 double:1.05296802E-314;
        r5.setText(r7);
        goto L_0x079e;
    L_0x0803:
        r0 = r19;
        r5 = r0.okY;
        r7 = 8;
        r5.setVisibility(r7);
        r0 = r19;
        r5 = r0.okZ;
        r7 = 8;
        r5.setVisibility(r7);
        r0 = r19;
        r5 = r0.ola;
        r7 = 2131230998; // 0x7f080116 float:1.8078065E38 double:1.0529680195E-314;
        r5.setText(r7);
        goto L_0x079e;
    L_0x0821:
        r0 = r19;
        r7 = r0.okQ;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r19;
        r7 = r0.olb;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r19;
        r7 = r0.okU;
        r8 = 0;
        r7.setVisibility(r8);
        r0 = r19;
        r7 = r0.okW;
        r7.setText(r5);
        r5 = com.tencent.mm.t.a.b.AL();
        r0 = r19;
        r7 = r0.okV;
        r8 = com.tencent.mm.t.a.a.AK();
        r9 = com.tencent.mm.t.a.c.cxH;
        r5.a(r7, r6, r8, r9);
        goto L_0x0707;
    L_0x0855:
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x085b:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r26;
        r5 = r0.field_status;
        r6 = 2;
        if (r5 < r6) goto L_0x0299;
    L_0x086a:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x0875:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x08f8;
    L_0x0884:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x08f8;
    L_0x088e:
        r0 = r19;
        r6 = r0.okC;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r0 = r20;
        r7 = r0.title;
        r6.setText(r7);
    L_0x08a1:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 3;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x08e1;
    L_0x08bc:
        r0 = r20;
        r5 = r0.appId;
        r6 = 1;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = com.tencent.mm.pluginsdk.model.app.g.b(r5, r6, r7);
        if (r5 == 0) goto L_0x08d7;
    L_0x08d1:
        r6 = r5.isRecycled();
        if (r6 == 0) goto L_0x0902;
    L_0x08d7:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
    L_0x08e1:
        r5 = com.tencent.mm.ui.chatting.ad.bEA();
        if (r5 == 0) goto L_0x090a;
    L_0x08e7:
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x08ed:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x08f8:
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x08a1;
    L_0x0902:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x08e1;
    L_0x090a:
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x0910:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r26;
        r5 = r0.field_status;
        r6 = 2;
        if (r5 < r6) goto L_0x0299;
    L_0x091f:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x092a:
        r0 = r19;
        r6 = r0.okC;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.cox;
        r7 = 1;
        if (r6 != r7) goto L_0x09a8;
    L_0x0939:
        r0 = r19;
        r6 = r0.okC;
        r7 = 2131234775; // 0x7f080fd7 float:1.8085725E38 double:1.0529698855E-314;
        r6.setText(r7);
    L_0x0943:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0966;
    L_0x0949:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0966;
    L_0x0953:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtY;
        r0 = r20;
        r7 = r0.title;
        r6.setText(r7);
    L_0x0966:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 4;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0299;
    L_0x0981:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = r5.a(r6, r7);
        if (r5 == 0) goto L_0x09d9;
    L_0x0999:
        r6 = r5.isRecycled();
        if (r6 != 0) goto L_0x09d9;
    L_0x099f:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0299;
    L_0x09a8:
        r0 = r20;
        r6 = r0.cox;
        r7 = 2;
        if (r6 != r7) goto L_0x09ba;
    L_0x09af:
        r0 = r19;
        r6 = r0.okC;
        r7 = 2131234777; // 0x7f080fd9 float:1.808573E38 double:1.0529698865E-314;
        r6.setText(r7);
        goto L_0x0943;
    L_0x09ba:
        r0 = r20;
        r6 = r0.cox;
        r7 = 3;
        if (r6 != r7) goto L_0x09cd;
    L_0x09c1:
        r0 = r19;
        r6 = r0.okC;
        r7 = 2131234776; // 0x7f080fd8 float:1.8085727E38 double:1.052969886E-314;
        r6.setText(r7);
        goto L_0x0943;
    L_0x09cd:
        r0 = r19;
        r6 = r0.okC;
        r7 = 2131234778; // 0x7f080fda float:1.8085731E38 double:1.052969887E-314;
        r6.setText(r7);
        goto L_0x0943;
    L_0x09d9:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0299;
    L_0x09e5:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtY;
        r0 = r20;
        r7 = r0.title;
        r6.setText(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 2131233764; // 0x7f080be4 float:1.8083675E38 double:1.052969386E-314;
        r6.setText(r7);
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 4;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0299;
    L_0x0a25:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = r5.a(r6, r7);
        if (r5 == 0) goto L_0x0a4c;
    L_0x0a3d:
        r6 = r5.isRecycled();
        if (r6 != 0) goto L_0x0a4c;
    L_0x0a43:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0299;
    L_0x0a4c:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0299;
    L_0x0a58:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0a84;
    L_0x0a5e:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0a84;
    L_0x0a68:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtY;
        r0 = r20;
        r7 = r0.title;
        r6.setText(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
    L_0x0a84:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 4;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0299;
    L_0x0a9f:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = r5.a(r6, r7);
        if (r5 == 0) goto L_0x0ac6;
    L_0x0ab7:
        r6 = r5.isRecycled();
        if (r6 != 0) goto L_0x0ac6;
    L_0x0abd:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0299;
    L_0x0ac6:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0299;
    L_0x0ad2:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0b3d;
    L_0x0ad8:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0b3d;
    L_0x0ae2:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0aea:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 2;
        r6.setMaxLines(r7);
        if (r5 == 0) goto L_0x0299;
    L_0x0b16:
        r0 = r20;
        r5 = r0.appId;
        r6 = 1;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = com.tencent.mm.pluginsdk.model.app.g.b(r5, r6, r7);
        if (r5 == 0) goto L_0x0b31;
    L_0x0b2b:
        r6 = r5.isRecycled();
        if (r6 == 0) goto L_0x0b47;
    L_0x0b31:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0299;
    L_0x0b3d:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0aea;
    L_0x0b47:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0299;
    L_0x0b50:
        r0 = r20;
        r4 = r0.title;
        if (r4 == 0) goto L_0x0bf3;
    L_0x0b56:
        r0 = r20;
        r4 = r0.title;
        r4 = r4.length();
        if (r4 <= 0) goto L_0x0bf3;
    L_0x0b60:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 0;
        r4.setVisibility(r6);
    L_0x0b68:
        r0 = r19;
        r4 = r0.dtZ;
        r6 = 0;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.okC;
        r6 = 8;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.okH;
        r6 = 8;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.okD;
        r6 = 4;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.dtZ;
        r6 = 2;
        r4.setMaxLines(r6);
        if (r5 == 0) goto L_0x0bbc;
    L_0x0b94:
        r4 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r5 = r0.field_imgPath;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = com.tencent.mm.bd.a.getDensity(r6);
        r4 = r4.a(r5, r6);
        if (r4 == 0) goto L_0x0bb2;
    L_0x0bac:
        r5 = r4.isRecycled();
        if (r5 == 0) goto L_0x0bfe;
    L_0x0bb2:
        r0 = r19;
        r4 = r0.okd;
        r5 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r4.setImageResource(r5);
    L_0x0bbc:
        r4 = new com.tencent.mm.ui.chatting.dl;
        r6 = 0;
        r8 = "";
        r9 = 8;
        r10 = 0;
        r11 = r25.bFU();
        r0 = r20;
        r12 = r0.bnR;
        r0 = r20;
        r13 = r0.bnS;
        r0 = r20;
        r14 = r0.title;
        r0 = r20;
        r15 = r0.coF;
        r0 = r20;
        r0 = r0.url;
        r16 = r0;
        r17 = 0;
        r18 = 0;
        r5 = r26;
        r7 = r24;
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
        r0 = r19;
        r5 = r0.okP;
        r5.setTag(r4);
        goto L_0x0299;
    L_0x0bf3:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 8;
        r4.setVisibility(r6);
        goto L_0x0b68;
    L_0x0bfe:
        r0 = r19;
        r5 = r0.okd;
        r5.setImageBitmap(r4);
        goto L_0x0bbc;
    L_0x0c06:
        r0 = r20;
        r4 = r0.title;
        if (r4 == 0) goto L_0x0ca7;
    L_0x0c0c:
        r0 = r20;
        r4 = r0.title;
        r4 = r4.length();
        if (r4 <= 0) goto L_0x0ca7;
    L_0x0c16:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 0;
        r4.setVisibility(r6);
    L_0x0c1e:
        r0 = r19;
        r4 = r0.dtZ;
        r6 = 0;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.okC;
        r6 = 8;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.okH;
        r6 = 8;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.okD;
        r6 = 4;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.dtZ;
        r6 = 2;
        r4.setMaxLines(r6);
        if (r5 == 0) goto L_0x0c72;
    L_0x0c4a:
        r4 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r5 = r0.field_imgPath;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = com.tencent.mm.bd.a.getDensity(r6);
        r4 = r4.a(r5, r6);
        if (r4 == 0) goto L_0x0c68;
    L_0x0c62:
        r5 = r4.isRecycled();
        if (r5 == 0) goto L_0x0cb2;
    L_0x0c68:
        r0 = r19;
        r4 = r0.okd;
        r5 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r4.setImageResource(r5);
    L_0x0c72:
        r4 = new com.tencent.mm.ui.chatting.dl;
        r7 = "";
        r8 = r25.bFU();
        r0 = r20;
        r9 = r0.bnR;
        r0 = r20;
        r10 = r0.bnS;
        r0 = r20;
        r11 = r0.title;
        r0 = r20;
        r12 = r0.cqd;
        r0 = r20;
        r13 = r0.designerName;
        r0 = r20;
        r14 = r0.designerRediretctUrl;
        r0 = r20;
        r15 = r0.url;
        r5 = r26;
        r6 = r24;
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        r0 = r19;
        r5 = r0.okP;
        r5.setTag(r4);
        goto L_0x0299;
    L_0x0ca7:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 8;
        r4.setVisibility(r6);
        goto L_0x0c1e;
    L_0x0cb2:
        r0 = r19;
        r5 = r0.okd;
        r5.setImageBitmap(r4);
        goto L_0x0c72;
    L_0x0cba:
        r0 = r20;
        r4 = r0.title;
        if (r4 == 0) goto L_0x0d7b;
    L_0x0cc0:
        r0 = r20;
        r4 = r0.title;
        r4 = r4.length();
        if (r4 <= 0) goto L_0x0d7b;
    L_0x0cca:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 0;
        r4.setVisibility(r6);
    L_0x0cd2:
        r0 = r19;
        r4 = r0.dtZ;
        r6 = 0;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.okC;
        r6 = 8;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.okH;
        r6 = 8;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.okD;
        r6 = 4;
        r4.setVisibility(r6);
        r0 = r19;
        r4 = r0.dtZ;
        r6 = 2;
        r4.setMaxLines(r6);
        if (r5 == 0) goto L_0x0d17;
    L_0x0cfe:
        r0 = r26;
        r4 = r0.field_imgPath;
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r4 == 0) goto L_0x0d86;
    L_0x0d08:
        r4 = com.tencent.mm.ae.n.GL();
        r0 = r20;
        r5 = r0.thumburl;
        r0 = r19;
        r6 = r0.okd;
        r4.a(r5, r6);
    L_0x0d17:
        r4 = new com.tencent.mm.ui.chatting.dl;
        r4.<init>();
        r0 = r26;
        r4.bmk = r0;
        r5 = 0;
        r4.nQK = r5;
        r0 = r24;
        r4.position = r0;
        r5 = 0;
        r4.oxP = r5;
        r5 = r25.bFU();
        r4.title = r5;
        r0 = r20;
        r5 = r0.bnR;
        r4.bnR = r5;
        r0 = r20;
        r5 = r0.bnS;
        r4.bnS = r5;
        r0 = r20;
        r5 = r0.title;
        r4.oxQ = r5;
        r0 = r20;
        r5 = r0.type;
        r6 = 26;
        if (r5 != r6) goto L_0x0db9;
    L_0x0d4a:
        r5 = 12;
        r4.eKg = r5;
        r0 = r20;
        r5 = r0.tid;
        r4.tid = r5;
        r0 = r20;
        r5 = r0.cqe;
        r4.cqe = r5;
        r0 = r20;
        r5 = r0.desc;
        r4.desc = r5;
        r0 = r20;
        r5 = r0.iconUrl;
        r4.iconUrl = r5;
        r0 = r20;
        r5 = r0.secondUrl;
        r4.secondUrl = r5;
        r0 = r20;
        r5 = r0.pageType;
        r4.pageType = r5;
    L_0x0d72:
        r0 = r19;
        r5 = r0.okP;
        r5.setTag(r4);
        goto L_0x0299;
    L_0x0d7b:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 8;
        r4.setVisibility(r6);
        goto L_0x0cd2;
    L_0x0d86:
        r4 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r5 = r0.field_imgPath;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = com.tencent.mm.bd.a.getDensity(r6);
        r4 = r4.a(r5, r6);
        if (r4 == 0) goto L_0x0da4;
    L_0x0d9e:
        r5 = r4.isRecycled();
        if (r5 == 0) goto L_0x0db0;
    L_0x0da4:
        r0 = r19;
        r4 = r0.okd;
        r5 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r4.setImageResource(r5);
        goto L_0x0d17;
    L_0x0db0:
        r0 = r19;
        r5 = r0.okd;
        r5.setImageBitmap(r4);
        goto L_0x0d17;
    L_0x0db9:
        r0 = r20;
        r5 = r0.type;
        r6 = 27;
        if (r5 != r6) goto L_0x0dea;
    L_0x0dc1:
        r5 = 13;
        r4.eKg = r5;
        r0 = r20;
        r5 = r0.tid;
        r4.tid = r5;
        r0 = r20;
        r5 = r0.cqe;
        r4.cqe = r5;
        r0 = r20;
        r5 = r0.desc;
        r4.desc = r5;
        r0 = r20;
        r5 = r0.iconUrl;
        r4.iconUrl = r5;
        r0 = r20;
        r5 = r0.secondUrl;
        r4.secondUrl = r5;
        r0 = r20;
        r5 = r0.pageType;
        r4.pageType = r5;
        goto L_0x0d72;
    L_0x0dea:
        r5 = "MicroMsg.ChattingItemAppMsgTo";
        r6 = "unknow view type";
        com.tencent.mm.sdk.platformtools.v.i(r5, r6);
        goto L_0x0d72;
    L_0x0df5:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtY;
        r0 = r20;
        r7 = r0.description;
        r6.setText(r7);
        r0 = r19;
        r6 = r0.dtZ;
        r0 = r20;
        r7 = r0.cpn;
        r6.setText(r7);
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0e72;
    L_0x0e19:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0e72;
    L_0x0e23:
        r0 = r19;
        r6 = r0.okC;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r0 = r20;
        r7 = r0.title;
        r6.setText(r7);
    L_0x0e36:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 4;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0299;
    L_0x0e51:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = r5.a(r6, r7);
        if (r5 == 0) goto L_0x0e7c;
    L_0x0e69:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0299;
    L_0x0e72:
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0e36;
    L_0x0e7c:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0299;
    L_0x0e88:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0f1a;
    L_0x0e9f:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0f1a;
    L_0x0ea9:
        r0 = r19;
        r6 = r0.okC;
        r0 = r19;
        r7 = r0.okC;
        r7 = r7.getContext();
        r0 = r20;
        r8 = r0.title;
        r0 = r19;
        r9 = r0.okC;
        r9 = r9.getTextSize();
        r9 = (int) r9;
        r7 = com.tencent.mm.pluginsdk.ui.d.e.a(r7, r8, r9);
        r6.setText(r7);
    L_0x0ec9:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 3;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0eed;
    L_0x0ee4:
        r0 = r19;
        r6 = r0.okd;
        r7 = 8;
        r6.setVisibility(r7);
    L_0x0eed:
        r0 = r25;
        r1 = r19;
        r2 = r20;
        r3 = r26;
        com.tencent.mm.ui.chatting.m.a(r0, r1, r2, r3, r5);
        r5 = com.tencent.mm.ui.chatting.ad.bEA();
        if (r5 == 0) goto L_0x0f42;
    L_0x0efe:
        r0 = r25;
        r5 = r0.onh;
        r0 = r19;
        r1 = r26;
        a(r0, r5, r1);
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x0f0f:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x0f1a:
        r0 = r19;
        r6 = r0.okC;
        r0 = r19;
        r7 = r0.okC;
        r7 = r7.getContext();
        r8 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r9 = 2131232755; // 0x7f0807f3 float:1.8081628E38 double:1.0529688875E-314;
        r8 = r8.getString(r9);
        r0 = r19;
        r9 = r0.okC;
        r9 = r9.getTextSize();
        r9 = (int) r9;
        r7 = com.tencent.mm.pluginsdk.ui.d.e.a(r7, r8, r9);
        r6.setText(r7);
        goto L_0x0ec9;
    L_0x0f42:
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x0f48:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r26;
        r5 = r0.field_status;
        r6 = 2;
        if (r5 < r6) goto L_0x0299;
    L_0x0f57:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x0f62:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x100a;
    L_0x0f71:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x100a;
    L_0x0f7b:
        r0 = r19;
        r6 = r0.okC;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 2;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okC;
        r0 = r19;
        r7 = r0.okC;
        r7 = r7.getContext();
        r0 = r20;
        r8 = r0.title;
        r0 = r19;
        r9 = r0.okC;
        r9 = r9.getTextSize();
        r9 = (int) r9;
        r7 = com.tencent.mm.pluginsdk.ui.d.e.a(r7, r8, r9);
        r6.setText(r7);
    L_0x0fab:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 4;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0fcf;
    L_0x0fc6:
        r0 = r19;
        r6 = r0.okd;
        r7 = 8;
        r6.setVisibility(r7);
    L_0x0fcf:
        r0 = r19;
        r1 = r20;
        com.tencent.mm.ui.chatting.m.a(r0, r1, r5);
        r0 = r19;
        r5 = r0.okd;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okO;
        r6 = 8;
        r5.setVisibility(r6);
        r5 = com.tencent.mm.ui.chatting.ad.bEA();
        if (r5 == 0) goto L_0x1014;
    L_0x0fee:
        r0 = r25;
        r5 = r0.onh;
        r0 = r19;
        r1 = r26;
        a(r0, r5, r1);
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x0fff:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x100a:
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0fab;
    L_0x1014:
        r0 = r19;
        r5 = r0.ieT;
        if (r5 == 0) goto L_0x0299;
    L_0x101a:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r26;
        r5 = r0.field_status;
        r6 = 2;
        if (r5 < r6) goto L_0x0299;
    L_0x1029:
        r0 = r19;
        r5 = r0.ieT;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0299;
    L_0x1034:
        r0 = r20;
        r5 = r0.title;
        if (r5 == 0) goto L_0x119e;
    L_0x103a:
        r0 = r20;
        r5 = r0.title;
        r5 = r5.length();
        if (r5 <= 0) goto L_0x119e;
    L_0x1044:
        r0 = r19;
        r5 = r0.dtY;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r20;
        r5 = r0.cpw;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r5 != 0) goto L_0x1184;
    L_0x1056:
        r0 = r20;
        r5 = r0.cpw;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r5 != 0) goto L_0x116a;
    L_0x1060:
        r0 = r19;
        r5 = r0.dtY;
        r0 = r20;
        r6 = r0.cpw;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = r7.getResources();
        r8 = 2131689547; // 0x7f0f004b float:1.9008112E38 double:1.053194573E-314;
        r7 = r7.getColor(r8);
        r6 = com.tencent.mm.sdk.platformtools.be.am(r6, r7);
        r5.setTextColor(r6);
    L_0x1080:
        r0 = r19;
        r5 = r0.dtZ;
        r6 = 2;
        r5.setMaxLines(r6);
        r0 = r19;
        r5 = r0.dtZ;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r20;
        r5 = r0.cpx;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r5 != 0) goto L_0x11a9;
    L_0x109a:
        r0 = r19;
        r5 = r0.dtZ;
        r0 = r20;
        r6 = r0.cpx;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = r7.getResources();
        r8 = 2131689769; // 0x7f0f0129 float:1.9008563E38 double:1.0531946825E-314;
        r7 = r7.getColor(r8);
        r6 = com.tencent.mm.sdk.platformtools.be.am(r6, r7);
        r5.setTextColor(r6);
    L_0x10ba:
        r0 = r19;
        r5 = r0.okC;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okD;
        r6 = 4;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okH;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okB;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.fSs;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r20;
        r5 = r0.cps;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r5 != 0) goto L_0x11c3;
    L_0x10ee:
        r0 = r19;
        r5 = r0.fSs;
        r0 = r20;
        r6 = r0.cps;
        r5.setText(r6);
    L_0x10f9:
        r0 = r22;
        r5 = r0.lVu;
        if (r5 == 0) goto L_0x11e7;
    L_0x10ff:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r8 = 0;
        r5 = r5.a(r6, r7, r8);
        if (r5 == 0) goto L_0x1131;
    L_0x1118:
        r6 = r5.isRecycled();
        if (r6 != 0) goto L_0x1131;
    L_0x111e:
        r6 = 0;
        r7 = r5.getWidth();
        r7 = r7 / 2;
        r7 = (float) r7;
        r6 = com.tencent.mm.sdk.platformtools.d.a(r5, r6, r7);
        r0 = r19;
        r7 = r0.okd;
        r7.setImageBitmap(r6);
    L_0x1131:
        r0 = r20;
        r6 = r0.cpv;
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r6);
        if (r6 != 0) goto L_0x11cf;
    L_0x113b:
        r5 = com.tencent.mm.ae.n.GL();
        r0 = r20;
        r6 = r0.cpv;
        r7 = new android.widget.ImageView;
        r0 = r25;
        r8 = r0.nDR;
        r8 = r8.nEl;
        r7.<init>(r8);
        r8 = new com.tencent.mm.ae.a.a.c$a;
        r8.<init>();
        r9 = 1;
        r8.cPs = r9;
        r8 = r8.GU();
        r9 = new com.tencent.mm.ui.chatting.aw$2;
        r0 = r22;
        r1 = r19;
        r2 = r25;
        r9.<init>(r0, r1, r2);
        r5.a(r6, r7, r8, r9);
        goto L_0x0299;
    L_0x116a:
        r0 = r19;
        r5 = r0.dtY;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = r6.getResources();
        r7 = 2131689547; // 0x7f0f004b float:1.9008112E38 double:1.053194573E-314;
        r6 = r6.getColor(r7);
        r5.setTextColor(r6);
        goto L_0x1080;
    L_0x1184:
        r0 = r19;
        r5 = r0.dtY;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = r6.getResources();
        r7 = 2131689547; // 0x7f0f004b float:1.9008112E38 double:1.053194573E-314;
        r6 = r6.getColor(r7);
        r5.setTextColor(r6);
        goto L_0x1080;
    L_0x119e:
        r0 = r19;
        r5 = r0.dtY;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x1080;
    L_0x11a9:
        r0 = r19;
        r5 = r0.dtZ;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = r6.getResources();
        r7 = 2131689769; // 0x7f0f0129 float:1.9008563E38 double:1.0531946825E-314;
        r6 = r6.getColor(r7);
        r5.setTextColor(r6);
        goto L_0x10ba;
    L_0x11c3:
        r0 = r19;
        r5 = r0.fSs;
        r6 = 2131231814; // 0x7f080446 float:1.807972E38 double:1.0529684226E-314;
        r5.setText(r6);
        goto L_0x10f9;
    L_0x11cf:
        r0 = r19;
        r6 = r0.okQ;
        r6 = r6.getViewTreeObserver();
        r7 = new com.tencent.mm.ui.chatting.aw$3;
        r0 = r22;
        r1 = r19;
        r2 = r25;
        r7.<init>(r0, r1, r2, r5);
        r6.addOnPreDrawListener(r7);
        goto L_0x0299;
    L_0x11e7:
        r0 = r19;
        r5 = r0.okd;
        r6 = r25.getResources();
        r7 = 2130838790; // 0x7f020506 float:1.7282572E38 double:1.052774243E-314;
        r6 = android.graphics.BitmapFactory.decodeResource(r6, r7);
        r5.setImageBitmap(r6);
        goto L_0x0299;
    L_0x11fb:
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0269;
    L_0x1206:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2130837666; // 0x7f0200a2 float:1.7280293E38 double:1.0527736876E-314;
        r5.setImageResource(r6);
        goto L_0x0299;
    L_0x1212:
        r20 = r4;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.aw.a(com.tencent.mm.ui.chatting.ad$a, int, com.tencent.mm.ui.chatting.ChattingUI$a, com.tencent.mm.storage.at, java.lang.String):void");
    }

    private static void a(m mVar, cp cpVar, at atVar) {
        if (atVar.field_status == 2 && ad.a(cpVar, atVar.field_msgId)) {
            if (mVar.okm != null) {
                mVar.okm.setVisibility(0);
            }
        } else if (mVar.okm != null) {
            mVar.okm.setVisibility(8);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        String str = atVar.field_content;
        if (str == null) {
            return true;
        }
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.onG.cf(str, atVar.field_isSend));
        if (dV == null) {
            return true;
        }
        boolean De;
        f aC = g.aC(dV.appId, false);
        if (g.i(aC)) {
            contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_READABLE, 0, this.onG.getString(2131234555));
        }
        if ((atVar.field_status == 2 || atVar.bNs == 1) && ad.bEz() && ad.OI(atVar.field_talker)) {
            contextMenu.add(i, 123, 0, view.getContext().getString(2131231836));
        }
        switch (dV.type) {
            case 1:
                De = e.De();
                break;
            case 2:
                De = e.Dg();
                break;
            case 3:
                De = e.Dp();
                break;
            case 4:
                De = e.Dh();
                break;
            case 5:
                De = e.Dn();
                break;
            case 6:
                De = e.Do();
                break;
            case 8:
                De = e.Dl();
                break;
            case 16:
                if (dV.cpo != 5 && dV.cpo != 6 && dV.cpo != 2) {
                    De = false;
                    break;
                }
                if (dV.cpo != 2) {
                    contextMenu.clear();
                }
                contextMenu.add(i, 100, 0, this.onG.getString(2131231829));
                return false;
            case 34:
                contextMenu.clear();
                contextMenu.add(i, 100, 0, this.onG.getString(2131231829));
                return false;
            default:
                De = false;
                break;
        }
        if (De && !this.onG.bFL()) {
            contextMenu.add(i, 114, 0, view.getContext().getString(2131231825));
        }
        if (com.tencent.mm.ay.c.EH("favorite") && (aC == null || !aC.bnk())) {
            switch (dV.type) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 10:
                case 13:
                case 19:
                case 20:
                case 24:
                    contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
                    break;
            }
        }
        b cpVar = new cp();
        cpVar.bay.bao = atVar.field_msgId;
        com.tencent.mm.sdk.c.a.nhr.z(cpVar);
        if (cpVar.baz.aZW || c.a(this.onG.nDR.nEl, dV)) {
            contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(2131231834));
        }
        if (!this.onG.bFL()) {
            contextMenu.add(i, 100, 0, this.onG.getString(2131231829));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        com.tencent.mm.q.a.a aVar2;
        b kwVar;
        String str;
        switch (menuItem.getItemId()) {
            case 100:
                String str2 = atVar.field_content;
                aVar2 = null;
                if (str2 != null) {
                    aVar2 = com.tencent.mm.q.a.a.dV(str2);
                }
                if (aVar2 != null && 19 == aVar2.type) {
                    kwVar = new kw();
                    kwVar.bmf.type = 3;
                    kwVar.bmf.bao = atVar.field_msgId;
                    com.tencent.mm.sdk.c.a.nhr.z(kwVar);
                }
                com.tencent.mm.model.aw.L(atVar.field_msgId);
                f aC = g.aC(aVar2.appId, false);
                if (aC != null && aC.bnk()) {
                    ad.a(aVar, aVar2, atVar, aC);
                    break;
                }
            case MMGIFException.D_GIF_ERR_NOT_GIF_FILE /*103*/:
                str = atVar.field_content;
                if (str != null) {
                    aVar2 = com.tencent.mm.q.a.a.dV(str);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 16:
                                kwVar = new gy();
                                kwVar.bgC.bgD = aVar2.bgD;
                                kwVar.bgC.aYG = atVar.field_msgId;
                                kwVar.bgC.bgE = atVar.field_talker;
                                com.tencent.mm.sdk.c.a.nhr.z(kwVar);
                                break;
                            default:
                                break;
                        }
                    }
                }
                break;
            case MMGIFException.D_GIF_ERR_NOT_READABLE /*111*/:
                c.a(aVar, atVar, a(aVar, atVar));
                break;
            case 114:
                str = atVar.field_content;
                if (str != null) {
                    aVar2 = com.tencent.mm.q.a.a.dV(str);
                    if (aVar2 != null) {
                        switch (aVar2.type) {
                            case 1:
                                dy.k(aVar.cf(atVar.field_content, atVar.field_isSend), aVar.nDR.nEl);
                                break;
                            case 2:
                                dy.a(atVar, aVar.nDR.nEl);
                                break;
                            case 3:
                                dy.a(atVar, aVar.cf(atVar.field_content, atVar.field_isSend), aVar.nDR.nEl);
                                break;
                            case 4:
                                dy.b(atVar, aVar.nDR.nEl);
                                break;
                            case 5:
                                dy.c(atVar, aVar.cf(atVar.field_content, atVar.field_isSend), aVar.nDR.nEl);
                                break;
                            case 6:
                                dy.b(atVar, aVar.cf(atVar.field_content, atVar.field_isSend), aVar.nDR.nEl);
                                break;
                            case 8:
                                dy.c(atVar, aVar.nDR.nEl);
                                break;
                            default:
                                break;
                        }
                    }
                }
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        if (((dl) view.getTag()).eKg == 5 && atVar.field_isSend == 1) {
            if (atVar != null) {
                final at atVar2 = atVar;
                com.tencent.mm.ui.base.g.b(this.onG.nDR.nEl, this.onG.getString(2131231873), SQLiteDatabase.KeyEmpty, this.onG.getString(2131231143), this.onG.getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ aw oob;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dw.L(atVar2);
                        this.oob.onG.bFI();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ aw oob;

                    {
                        this.oob = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            return true;
        }
        String str = atVar.field_content;
        if (str == null) {
            return false;
        }
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str);
        if (dV == null) {
            return false;
        }
        String str2;
        f aC = g.aC(dV.appId, true);
        if (!(aC == null || be.kS(aC.field_appId) || !aC.bnk())) {
            ad.a(aVar, dV, k.xF(), aC, atVar.field_msgSvrId);
        }
        Intent intent;
        switch (dV.type) {
            case 3:
                com.tencent.mm.plugin.report.service.g.iuh.h(13043, Integer.valueOf(2), dV.description, dV.appId);
                break;
            case 4:
                break;
            case 5:
                if (be.kS(dV.canvasPageXml)) {
                    if (!(dV.url == null || dV.url.equals(SQLiteDatabase.KeyEmpty))) {
                        str = p.s(dV.url, aVar.onl ? "groupmessage" : "singlemessage");
                        str2 = dV.coa;
                        PackageInfo av = ad.av(aVar.nDR.nEl, dV.appId);
                        Intent intent2 = new Intent();
                        intent2.putExtra("rawUrl", str);
                        intent2.putExtra("webpageTitle", dV.title);
                        Bundle bundle = new Bundle();
                        bundle.putString("key_snsad_statextstr", dV.bnY);
                        if (dV.appId != null && ("wx751a1acca5688ba3".equals(dV.appId) || "wxfbc915ff7c30e335".equals(dV.appId) || "wx482a4001c37e2b74".equals(dV.appId))) {
                            bundle.putString("jsapi_args_appid", dV.appId);
                        }
                        intent2.putExtra("jsapiargs", bundle);
                        if (be.kS(str2)) {
                            intent2.putExtra("shortUrl", dV.url);
                        } else {
                            intent2.putExtra("shortUrl", str2);
                        }
                        intent2.putExtra("version_name", av == null ? null : av.versionName);
                        intent2.putExtra("version_code", av == null ? 0 : av.versionCode);
                        if (!be.kS(dV.bnR)) {
                            intent2.putExtra("srcUsername", dV.bnR);
                            intent2.putExtra("srcDisplayname", dV.bnS);
                        }
                        intent2.putExtra("msg_id", atVar.field_msgId);
                        intent2.putExtra("KPublisherId", "msg_" + Long.toString(atVar.field_msgSvrId));
                        intent2.putExtra("KAppId", dV.appId);
                        intent2.putExtra("geta8key_username", aVar.bEn());
                        intent2.putExtra("pre_username", a(aVar, atVar));
                        intent2.putExtra("from_scence", 2);
                        intent2.putExtra("prePublishId", "msg_" + Long.toString(atVar.field_msgSvrId));
                        intent2.putExtra("preUsername", a(aVar, atVar));
                        intent2.putExtra("preChatName", aVar.bEn());
                        intent2.putExtra("preChatTYPE", n.F(a(aVar, atVar), aVar.bEn()));
                        intent2.putExtra("preMsgIndex", 0);
                        com.tencent.mm.ay.c.b(aVar.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent2);
                    }
                    return true;
                }
                intent = new Intent();
                intent.putExtra("sns_landig_pages_from_source", 5);
                intent.putExtra("msg_id", atVar.field_msgId);
                intent.putExtra("sns_landing_pages_xml", dV.canvasPageXml);
                intent.putExtra("sns_landing_pages_share_thumb_url", atVar.field_imgPath);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                return true;
            case 6:
                ak.yW();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    if (be.KY(dV.coc)) {
                        Object obj;
                        long j = atVar.field_msgId;
                        com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(dV.aXa);
                        if (Gu == null || !Gu.bnj()) {
                            obj = null;
                        } else {
                            ak.yW();
                            if (com.tencent.mm.model.c.wJ().ek(j).bwv()) {
                                v.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", str, Long.valueOf(j), Long.valueOf(com.tencent.mm.model.c.wJ().ek(j).field_msgSvrId), com.tencent.mm.model.c.wJ().ek(j).field_imgPath);
                                intent = new Intent(this.onG.nDR.nEl, ResourcesExceedUI.class);
                                intent.putExtra("clean_view_type", 1);
                                this.onG.startActivity(intent);
                                obj = 1;
                            } else {
                                intent = new Intent(this.onG.nDR.nEl, ShowImageUI.class);
                                intent.putExtra("key_image_path", Gu.field_fileFullPath);
                                intent.putExtra("key_message_id", j);
                                intent.putExtra("key_favorite", true);
                                this.onG.startActivity(intent);
                                obj = 1;
                            }
                        }
                        if (obj != null) {
                            return true;
                        }
                    }
                    intent = new Intent(aVar.nDR.nEl, AppAttachDownloadUI.class);
                    intent.putExtra("app_msg_id", atVar.field_msgId);
                    aVar.startActivity(intent);
                    return true;
                }
                s.ey(aVar.nDR.nEl);
                return true;
            case 7:
                if (aC != null && aC.bnk() && ad.a(aVar, aC)) {
                    return true;
                }
                aVar.an(atVar);
                return true;
            case 10:
                if (be.kS(dV.coy)) {
                    return false;
                }
                intent = new Intent();
                intent.setFlags(65536);
                intent.putExtra("key_Product_xml", dV.coy);
                intent.putExtra("key_ProductUI_getProductInfoScene", 1);
                if (atVar.field_imgPath == null) {
                    intent.putExtra("key_ProductUI_chatting_msgId", atVar.field_msgId);
                }
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "scanner", ".ui.ProductUI", intent);
                return true;
            case 13:
                if (be.kS(dV.coE)) {
                    return false;
                }
                intent = new Intent();
                intent.setFlags(65536);
                intent.putExtra("key_product_info", dV.coE);
                intent.putExtra("key_product_scene", 1);
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "product", ".ui.MallProductUI", intent);
                return true;
            case 16:
                if (be.kS(dV.bgD)) {
                    return false;
                }
                intent = new Intent();
                intent.setFlags(65536);
                intent.putExtra("key_card_app_msg", dV.bgD);
                intent.putExtra("key_from_scene", dV.cpo);
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "card", ".ui.CardDetailUI", intent);
                return true;
            case 19:
                intent = new Intent();
                intent.putExtra("message_id", atVar.field_msgId);
                intent.putExtra("record_xml", dV.coC);
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "record", ".ui.RecordMsgDetailUI", intent);
                return true;
            case 20:
                if (be.kS(dV.coB)) {
                    return false;
                }
                intent = new Intent();
                intent.setFlags(65536);
                intent.putExtra("key_TV_xml", dV.coB);
                intent.putExtra("key_TV_getProductInfoScene", 1);
                if (atVar.field_imgPath == null) {
                    intent.putExtra("key_TVInfoUI_chatting_msgId", atVar.field_msgId);
                }
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "shake", ".ui.TVInfoUI", intent);
                return true;
            case 24:
                b joVar = new jo();
                joVar.bjY.context = aVar.nDR.nEl;
                joVar.bjY.bao = atVar.field_msgId;
                joVar.bjY.bjZ = dV.coC;
                com.tencent.mm.sdk.c.a.nhr.z(joVar);
                return true;
            case 33:
                v.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", dV.cqp, dV.cqo, dV.cqq, dV.url, Integer.valueOf(dV.cqt), dV.cqs);
                switch (dV.cqr) {
                    case 1:
                        Intent intent3 = new Intent();
                        intent3.putExtra("key_username", dV.cqp);
                        if (aVar.onl) {
                            intent3.putExtra("key_from_scene", 1);
                            intent3.putExtra("key_scene_note", aVar.bEn() + ":" + a(aVar, atVar));
                        } else {
                            intent3.putExtra("key_from_scene", 2);
                            intent3.putExtra("key_scene_note", aVar.bEn());
                        }
                        intent3.putExtra("key_scene_export_url_params", new AppBrandExportUrlParams(dV.cqq, 6, SQLiteDatabase.KeyEmpty, dV.cqt, dV.hsN));
                        com.tencent.mm.ay.c.b(aVar.nDR.nEl, "appbrand", ".ui.AppBrandProfileUI", intent3);
                        break;
                    case 2:
                        b okVar = new ok();
                        okVar.bpu.appId = dV.cqq;
                        okVar.bpu.userName = dV.cqp;
                        okVar.bpu.bpw = dV.cqo;
                        okVar.bpu.bpx = dV.cqt;
                        okVar.bpu.bpz = dV.cqs;
                        okVar.bpu.bpy = dV.cqu;
                        okVar.bpu.bpA = dV.cqt != 0;
                        if (aVar.onl) {
                            okVar.bpu.scene = MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE;
                            okVar.bpu.aWP = aVar.bEn() + ":" + a(aVar, atVar);
                        } else {
                            okVar.bpu.scene = MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE;
                            okVar.bpu.aWP = a(aVar, atVar);
                        }
                        com.tencent.mm.sdk.c.a.nhr.z(okVar);
                        break;
                }
                return true;
            case 34:
                intent = new Intent();
                intent.putExtra("key_biz_uin", dV.cpq);
                intent.putExtra("key_order_id", dV.cpr);
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "card", ".ui.CardGiftAcceptUI", intent);
                return true;
            default:
                return false;
        }
        if (a(aVar, dV, atVar)) {
            return true;
        }
        str2 = p.s(dV.url, "message");
        String s = p.s(dV.coa, "message");
        PackageInfo av2 = ad.av(aVar.nDR.nEl, dV.appId);
        a(aVar, str2, s, av2 == null ? null : av2.versionName, av2 == null ? 0 : av2.versionCode, dV.appId, true, atVar.field_msgId, atVar.field_msgSvrId, atVar);
        return true;
    }
}

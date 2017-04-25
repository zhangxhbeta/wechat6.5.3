package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.as.u;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.jo;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.n;
import com.tencent.mm.modelappbrand.AppBrandExportUrlParams;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

final class ao extends b {
    private c fzb;
    private a onG;
    private boolean onP;
    private c onQ;

    public ao(int i) {
        super(i);
        c.a aVar = new c.a();
        this.fzb = aVar.GU();
        aVar = new c.a();
        aVar.cPH = 2131165252;
        aVar.aI(com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 10), com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 10)).cPq = true;
        this.onQ = aVar.GU();
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof m) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903308);
        view.setTag(new m(this.eKg).p(view, true));
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
        r19.reset();
        r0 = r26;
        r4 = r0.field_content;
        r25.aw(r26);
        r25.ax(r26);
        r25.ay(r26);
        r0 = r22;
        r5 = r0.onP;
        if (r5 == 0) goto L_0x118d;
    L_0x0020:
        r0 = r26;
        r5 = r0.field_content;
        r6 = 58;
        r5 = r5.indexOf(r6);
        r6 = -1;
        if (r5 == r6) goto L_0x118d;
    L_0x002d:
        r0 = r26;
        r4 = r0.field_content;
        r5 = r5 + 1;
        r4 = r4.substring(r5);
        r12 = r4;
    L_0x0038:
        r4 = 0;
        if (r12 == 0) goto L_0x03b0;
    L_0x003b:
        r0 = r26;
        r4 = r0.field_reserved;
        r4 = com.tencent.mm.q.a.a.B(r12, r4);
        r20 = r4;
    L_0x0045:
        r4 = new com.tencent.mm.ui.chatting.dl;
        r0 = r25;
        r6 = r0.nQK;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r5 = r26;
        r7 = r24;
        r4.<init>(r5, r6, r7, r8, r9, r10);
        if (r20 == 0) goto L_0x0388;
    L_0x0057:
        r0 = r19;
        r5 = r0.dtY;
        r6 = r20.getTitle();
        r5.setText(r6);
        r0 = r19;
        r6 = r0.dtZ;
        r0 = r20;
        r5 = r0.cnY;
        if (r5 == 0) goto L_0x03ce;
    L_0x006c:
        r0 = r20;
        r5 = r0.cnY;
        r5 = r5.cqA;
        if (r5 == 0) goto L_0x03ce;
    L_0x0074:
        r0 = r20;
        r5 = r0.cnY;
        r5 = r5.desc;
    L_0x007a:
        r6.setText(r5);
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
        r7 = 2131689909; // 0x7f0f01b5 float:1.9008847E38 double:1.0531947516E-314;
        r6 = r6.getColor(r7);
        r5.setTextColor(r6);
        r0 = r19;
        r5 = r0.dtZ;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = r6.getResources();
        r7 = 2131689792; // 0x7f0f0140 float:1.900861E38 double:1.053194694E-314;
        r6 = r6.getColor(r7);
        r5.setTextColor(r6);
        r0 = r19;
        r5 = r0.okQ;
        r6 = 2130837914; // 0x7f02019a float:1.7280796E38 double:1.05277381E-314;
        r5.setBackgroundResource(r6);
        r0 = r19;
        r5 = r0.okQ;
        r6 = 0;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = r7.getResources();
        r8 = 2131493152; // 0x7f0c0120 float:1.8609776E38 double:1.0530975407E-314;
        r7 = r7.getDimensionPixelSize(r8);
        r8 = 0;
        r9 = 0;
        r5.setPadding(r6, r7, r8, r9);
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
        r5 = r0.okE;
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
        r5 = r0.okS;
        r6 = 8;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okT;
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
        r0 = r19;
        r5 = r0.okI;
        r0 = r20;
        r6 = r0.cou;
        r0 = r26;
        r7 = r0.field_talker;
        r8 = 0;
        r5 = r5.b(r6, r7, r8);
        if (r5 == 0) goto L_0x03d4;
    L_0x0155:
        r0 = r19;
        r5 = r0.okP;
        r6 = 2130837962; // 0x7f0201ca float:1.7280893E38 double:1.052773834E-314;
        r5.setBackgroundResource(r6);
    L_0x015f:
        r0 = r20;
        r5 = r0.appId;
        r0 = r20;
        r6 = r0.bpy;
        r21 = com.tencent.mm.pluginsdk.model.app.g.bA(r5, r6);
        if (r21 == 0) goto L_0x017c;
    L_0x016d:
        r5 = r21.bnk();
        if (r5 == 0) goto L_0x017c;
    L_0x0173:
        r0 = r25;
        r1 = r20;
        r2 = r26;
        com.tencent.mm.ui.chatting.ad.b(r0, r1, r2);
    L_0x017c:
        if (r21 == 0) goto L_0x0192;
    L_0x017e:
        r0 = r21;
        r5 = r0.field_appName;
        if (r5 == 0) goto L_0x0192;
    L_0x0184:
        r0 = r21;
        r5 = r0.field_appName;
        r5 = r5.trim();
        r5 = r5.length();
        if (r5 > 0) goto L_0x03e0;
    L_0x0192:
        r0 = r20;
        r5 = r0.appName;
    L_0x0196:
        r6 = 1;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r8 = 12;
        com.tencent.mm.bd.a.fromDPToPix(r7, r8);
        r0 = r20;
        r7 = r0.type;
        r8 = 20;
        if (r7 == r8) goto L_0x01b7;
    L_0x01aa:
        r7 = "wxaf060266bfa9a35c";
        r0 = r20;
        r8 = r0.appId;
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x01bf;
    L_0x01b7:
        r6 = com.tencent.mm.pluginsdk.j.a.bmq();
        r6 = r6.aNM();
    L_0x01bf:
        if (r6 == 0) goto L_0x03f5;
    L_0x01c1:
        r0 = r20;
        r6 = r0.appId;
        if (r6 == 0) goto L_0x03f5;
    L_0x01c7:
        r0 = r20;
        r6 = r0.appId;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x03f5;
    L_0x01d1:
        r6 = com.tencent.mm.pluginsdk.model.app.g.bo(r5);
        if (r6 == 0) goto L_0x03f5;
    L_0x01d7:
        r0 = r19;
        r6 = r0.fSs;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r0 = r21;
        r5 = com.tencent.mm.pluginsdk.model.app.g.a(r7, r0, r5);
        r6.setText(r5);
        r0 = r19;
        r5 = r0.fSs;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.fSs;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r5.setCompoundDrawables(r6, r7, r8, r9);
        r0 = r19;
        r5 = r0.okB;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okz;
        r6 = 0;
        r5.setVisibility(r6);
        if (r21 == 0) goto L_0x03e6;
    L_0x020f:
        r5 = r21.bnk();
        if (r5 == 0) goto L_0x03e6;
    L_0x0215:
        r0 = r19;
        r6 = r0.fSs;
        r0 = r21;
        r9 = r0.field_packageName;
        r0 = r26;
        r10 = r0.field_msgSvrId;
        r5 = r25;
        r7 = r26;
        r8 = r20;
        com.tencent.mm.ui.chatting.ad.a(r5, r6, r7, r8, r9, r10);
    L_0x022a:
        r0 = r19;
        r5 = r0.okz;
        r0 = r20;
        r6 = r0.appId;
        r0 = r25;
        com.tencent.mm.ui.chatting.ad.a(r0, r5, r6);
    L_0x0237:
        r0 = r20;
        r5 = r0.cnY;
        if (r5 == 0) goto L_0x047c;
    L_0x023d:
        r0 = r20;
        r5 = r0.cnY;
        r5 = r5.cqB;
        if (r5 == 0) goto L_0x047c;
    L_0x0245:
        r5 = 1;
    L_0x0246:
        if (r5 == 0) goto L_0x0251;
    L_0x0248:
        r0 = r19;
        r5 = r0.okB;
        r6 = 8;
        r5.setVisibility(r6);
    L_0x0251:
        r5 = 0;
        r0 = r19;
        r6 = r0.okd;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.cnY;
        if (r6 == 0) goto L_0x047f;
    L_0x0260:
        r0 = r20;
        r6 = r0.cnY;
        r6 = r6.cqy;
        r7 = 1;
        if (r6 != r7) goto L_0x047f;
    L_0x0269:
        r6 = 1;
    L_0x026a:
        if (r6 != 0) goto L_0x0485;
    L_0x026c:
        r0 = r22;
        r6 = r0.lVu;
        if (r6 == 0) goto L_0x0485;
    L_0x0272:
        r6 = 0;
        r0 = r20;
        r7 = r0.type;
        r8 = 33;
        if (r7 == r8) goto L_0x0292;
    L_0x027b:
        r6 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r7 = r0.field_imgPath;
        r0 = r25;
        r8 = r0.nDR;
        r8 = r8.nEl;
        r8 = com.tencent.mm.bd.a.getDensity(r8);
        r9 = 0;
        r6 = r6.a(r7, r8, r9);
    L_0x0292:
        if (r6 == 0) goto L_0x0482;
    L_0x0294:
        r7 = r6.isRecycled();
        if (r7 != 0) goto L_0x0482;
    L_0x029a:
        r0 = r19;
        r7 = r0.okd;
        r7.setImageBitmap(r6);
    L_0x02a1:
        r0 = r20;
        r7 = r0.type;
        r8 = 3;
        if (r7 != r8) goto L_0x02be;
    L_0x02a8:
        r0 = r19;
        r7 = r0.okQ;
        r7 = r7.getViewTreeObserver();
        r8 = new com.tencent.mm.ui.chatting.ao$1;
        r0 = r22;
        r1 = r19;
        r2 = r25;
        r8.<init>(r0, r1, r2, r6);
        r7.addOnPreDrawListener(r8);
    L_0x02be:
        r0 = r20;
        r6 = r0.bNm;
        if (r6 == 0) goto L_0x02ce;
    L_0x02c4:
        r0 = r20;
        r6 = r0.bNm;
        r6 = r6.length();
        if (r6 != 0) goto L_0x0499;
    L_0x02ce:
        r0 = r19;
        r6 = r0.oks;
        r7 = 8;
        r6.setVisibility(r7);
    L_0x02d7:
        r0 = r19;
        r6 = r0.okH;
        r7 = 0;
        r6.setOnClickListener(r7);
        r0 = r19;
        r6 = r0.okK;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okN;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okL;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.type;
        switch(r6) {
            case 0: goto L_0x0af4;
            case 1: goto L_0x0308;
            case 2: goto L_0x0308;
            case 3: goto L_0x04b4;
            case 4: goto L_0x064b;
            case 5: goto L_0x06da;
            case 6: goto L_0x05ad;
            case 7: goto L_0x08c7;
            case 8: goto L_0x0308;
            case 9: goto L_0x0308;
            case 10: goto L_0x094c;
            case 11: goto L_0x0308;
            case 12: goto L_0x0308;
            case 13: goto L_0x0a07;
            case 14: goto L_0x0308;
            case 15: goto L_0x0b72;
            case 16: goto L_0x0df0;
            case 17: goto L_0x0308;
            case 18: goto L_0x0308;
            case 19: goto L_0x0f28;
            case 20: goto L_0x0a7a;
            case 21: goto L_0x0308;
            case 22: goto L_0x0308;
            case 23: goto L_0x0308;
            case 24: goto L_0x0e83;
            case 25: goto L_0x0c28;
            case 26: goto L_0x0cdc;
            case 27: goto L_0x0cdc;
            case 28: goto L_0x0308;
            case 29: goto L_0x0308;
            case 30: goto L_0x0308;
            case 31: goto L_0x0308;
            case 32: goto L_0x0308;
            case 33: goto L_0x0763;
            case 34: goto L_0x0fbd;
            default: goto L_0x0308;
        };
    L_0x0308:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x1160;
    L_0x030e:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x1160;
    L_0x0318:
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
    L_0x0333:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0363;
    L_0x033e:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = r5.a(r6, r7);
        if (r5 == 0) goto L_0x116b;
    L_0x0356:
        r6 = r5.isRecycled();
        if (r6 != 0) goto L_0x116b;
    L_0x035c:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
    L_0x0363:
        r0 = r25;
        r5 = r0.nQK;
        if (r5 != 0) goto L_0x1182;
    L_0x0369:
        r5 = com.tencent.mm.pluginsdk.model.app.g.h(r21);
        if (r5 == 0) goto L_0x1177;
    L_0x036f:
        r0 = r19;
        r5 = r0.okJ;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r19;
        r5 = r0.okJ;
        r0 = r20;
        r1 = r26;
        r6 = com.tencent.mm.ui.chatting.dl.a(r0, r1);
        r0 = r25;
        com.tencent.mm.ui.chatting.ad.c(r0, r5, r6);
    L_0x0388:
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
        if (r4 == 0) goto L_0x03af;
    L_0x03a2:
        r0 = r19;
        r4 = r0.okP;
        r0 = r25;
        r5 = r0.onh;
        r5 = r5.oqj;
        r4.setOnLongClickListener(r5);
    L_0x03af:
        return;
    L_0x03b0:
        r5 = "MicroMsg.ChattingItemAppMsgFrom";
        r6 = "amessage, msgid:%s, user:%s";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r0 = r26;
        r10 = r0.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r7[r8] = r9;
        r8 = 1;
        r7[r8] = r27;
        com.tencent.mm.sdk.platformtools.v.e(r5, r6, r7);
        r20 = r4;
        goto L_0x0045;
    L_0x03ce:
        r0 = r20;
        r5 = r0.description;
        goto L_0x007a;
    L_0x03d4:
        r0 = r19;
        r5 = r0.okP;
        r6 = 2130837950; // 0x7f0201be float:1.7280869E38 double:1.052773828E-314;
        r5.setBackgroundResource(r6);
        goto L_0x015f;
    L_0x03e0:
        r0 = r21;
        r5 = r0.field_appName;
        goto L_0x0196;
    L_0x03e6:
        r0 = r19;
        r5 = r0.fSs;
        r0 = r20;
        r6 = r0.appId;
        r0 = r25;
        com.tencent.mm.ui.chatting.ad.a(r0, r5, r6);
        goto L_0x022a;
    L_0x03f5:
        r0 = r20;
        r5 = r0.type;
        r6 = 24;
        if (r5 != r6) goto L_0x042a;
    L_0x03fd:
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
        goto L_0x0237;
    L_0x042a:
        r0 = r20;
        r5 = r0.type;
        r6 = 19;
        if (r5 != r6) goto L_0x045f;
    L_0x0432:
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
        goto L_0x0237;
    L_0x045f:
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
        goto L_0x0237;
    L_0x047c:
        r5 = 0;
        goto L_0x0246;
    L_0x047f:
        r6 = 0;
        goto L_0x026a;
    L_0x0482:
        r5 = 1;
        goto L_0x02a1;
    L_0x0485:
        r0 = r19;
        r6 = r0.okd;
        r7 = r25.getResources();
        r8 = 2130838790; // 0x7f020506 float:1.7282572E38 double:1.052774243E-314;
        r7 = android.graphics.BitmapFactory.decodeResource(r7, r8);
        r6.setImageBitmap(r7);
        goto L_0x02be;
    L_0x0499:
        r0 = r19;
        r6 = r0.oks;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.oks;
        r0 = r20;
        r7 = r0.bNm;
        r7 = com.tencent.mm.ui.chatting.dl.Pa(r7);
        r0 = r25;
        com.tencent.mm.ui.chatting.ad.b(r0, r6, r7);
        goto L_0x02d7;
    L_0x04b4:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x058f;
    L_0x04ba:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x058f;
    L_0x04c4:
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
    L_0x04e4:
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
        r6 = r0.okH;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r23;
        r6 = r0.onE;
        r0 = r26;
        r8 = r0.field_msgId;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 != 0) goto L_0x059a;
    L_0x0529:
        r0 = r19;
        r6 = r0.okH;
        r7 = 2130838733; // 0x7f0204cd float:1.7282457E38 double:1.052774215E-314;
        r6.setImageResource(r7);
    L_0x0533:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 2;
        r6.setMaxLines(r7);
        if (r5 == 0) goto L_0x0562;
    L_0x053d:
        r0 = r20;
        r5 = r0.appId;
        r6 = 1;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = com.tencent.mm.pluginsdk.model.app.g.b(r5, r6, r7);
        if (r5 == 0) goto L_0x0558;
    L_0x0552:
        r6 = r5.isRecycled();
        if (r6 == 0) goto L_0x05a5;
    L_0x0558:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165232; // 0x7f070030 float:1.7944675E38 double:1.0529355267E-314;
        r5.setImageResource(r6);
    L_0x0562:
        r5 = new com.tencent.mm.ui.chatting.cp$b;
        r5.<init>();
        r0 = r26;
        r6 = r0.field_msgId;
        r5.bao = r6;
        r0 = r26;
        r6 = r0.field_content;
        r5.blq = r6;
        r0 = r26;
        r6 = r0.field_imgPath;
        r5.bhr = r6;
        r0 = r19;
        r6 = r0.okH;
        r6.setTag(r5);
        r0 = r19;
        r5 = r0.okH;
        r0 = r25;
        r6 = r0.onh;
        r6 = r6.oqp;
        r5.setOnClickListener(r6);
        goto L_0x0363;
    L_0x058f:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x04e4;
    L_0x059a:
        r0 = r19;
        r6 = r0.okH;
        r7 = 2130838735; // 0x7f0204cf float:1.728246E38 double:1.052774216E-314;
        r6.setImageResource(r7);
        goto L_0x0533;
    L_0x05a5:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0562;
    L_0x05ad:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0641;
    L_0x05b3:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0641;
    L_0x05bd:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtY;
        r7 = 2;
        r6.setMaxLines(r7);
    L_0x05cd:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
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
        r0 = r20;
        r6 = r0.cob;
        r0 = r19;
        com.tencent.mm.ui.chatting.m.a(r0, r12, r6);
        r6 = 1;
        r6 = java.lang.Boolean.valueOf(r6);
        r0 = r20;
        r7 = r0.aXa;
        r0 = r20;
        r8 = r0.title;
        r0 = r19;
        r1 = r26;
        com.tencent.mm.ui.chatting.m.a(r0, r6, r1, r7, r8);
        if (r5 == 0) goto L_0x0363;
    L_0x0626:
        r0 = r20;
        r5 = r0.coc;
        r5 = com.tencent.mm.sdk.platformtools.be.KY(r5);
        if (r5 != 0) goto L_0x116b;
    L_0x0630:
        r0 = r19;
        r5 = r0.okd;
        r0 = r20;
        r6 = r0.coc;
        r6 = com.tencent.mm.pluginsdk.model.p.Gt(r6);
        r5.setImageResource(r6);
        goto L_0x0363;
    L_0x0641:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x05cd;
    L_0x064b:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x06c8;
    L_0x0651:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x06c8;
    L_0x065b:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0663:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 2130839370; // 0x7f02074a float:1.7283749E38 double:1.0527745295E-314;
        r6.setImageResource(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 2;
        r6.setMaxLines(r7);
        if (r5 == 0) goto L_0x0363;
    L_0x0698:
        r0 = r20;
        r5 = r0.appId;
        r6 = 1;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = com.tencent.mm.pluginsdk.model.app.g.b(r5, r6, r7);
        if (r5 == 0) goto L_0x06b3;
    L_0x06ad:
        r6 = r5.isRecycled();
        if (r6 == 0) goto L_0x06d2;
    L_0x06b3:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165244; // 0x7f07003c float:1.79447E38 double:1.0529355327E-314;
        r5.setImageResource(r6);
    L_0x06bd:
        r0 = r19;
        r5 = r0.okH;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0363;
    L_0x06c8:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0663;
    L_0x06d2:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x06bd;
    L_0x06da:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0750;
    L_0x06e9:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0750;
    L_0x06f3:
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
        r7 = r20.getTitle();
        r6.setText(r7);
    L_0x070e:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 3;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0363;
    L_0x0729:
        r0 = r20;
        r5 = r0.appId;
        r6 = 1;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = com.tencent.mm.pluginsdk.model.app.g.b(r5, r6, r7);
        if (r5 == 0) goto L_0x0744;
    L_0x073e:
        r6 = r5.isRecycled();
        if (r6 == 0) goto L_0x075a;
    L_0x0744:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0363;
    L_0x0750:
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x070e;
    L_0x075a:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0363;
    L_0x0763:
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
        if (r5 == 0) goto L_0x07cf;
    L_0x077b:
        r5 = r6.aWK;
        r5 = r5.appName;
    L_0x077f:
        r7 = r6.aWK;
        r7 = r7.aWL;
        if (r7 == 0) goto L_0x07d4;
    L_0x0785:
        r6 = r6.aWK;
        r6 = r6.aWM;
    L_0x0789:
        r0 = r19;
        r7 = r0.okQ;
        r8 = 8;
        r7.setVisibility(r8);
        r0 = r20;
        r7 = r0.cqr;
        switch(r7) {
            case 1: goto L_0x079b;
            case 2: goto L_0x07d9;
            default: goto L_0x0799;
        };
    L_0x0799:
        goto L_0x0363;
    L_0x079b:
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
        goto L_0x0363;
    L_0x07cf:
        r0 = r20;
        r5 = r0.bnS;
        goto L_0x077f;
    L_0x07d4:
        r0 = r20;
        r6 = r0.cqv;
        goto L_0x0789;
    L_0x07d9:
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
        if (r7 == 0) goto L_0x0889;
    L_0x0801:
        r7 = 8;
    L_0x0803:
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
            case 1: goto L_0x088c;
            case 2: goto L_0x08a9;
            default: goto L_0x082a;
        };
    L_0x082a:
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
    L_0x0844:
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
        goto L_0x0363;
    L_0x0889:
        r7 = 0;
        goto L_0x0803;
    L_0x088c:
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
        goto L_0x0844;
    L_0x08a9:
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
        goto L_0x0844;
    L_0x08c7:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0939;
    L_0x08d6:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.trim();
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0939;
    L_0x08e4:
        r0 = r19;
        r6 = r0.okC;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = r20.getTitle();
        r6.setText(r7);
    L_0x08f7:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 3;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 0;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0363;
    L_0x0912:
        r0 = r20;
        r5 = r0.appId;
        r6 = 1;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = com.tencent.mm.pluginsdk.model.app.g.b(r5, r6, r7);
        if (r5 == 0) goto L_0x092d;
    L_0x0927:
        r6 = r5.isRecycled();
        if (r6 == 0) goto L_0x0943;
    L_0x092d:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0363;
    L_0x0939:
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x08f7;
    L_0x0943:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0363;
    L_0x094c:
        r0 = r19;
        r6 = r0.okC;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.cox;
        r7 = 1;
        if (r6 != r7) goto L_0x09ca;
    L_0x095b:
        r0 = r19;
        r6 = r0.okC;
        r7 = 2131234775; // 0x7f080fd7 float:1.8085725E38 double:1.0529698855E-314;
        r6.setText(r7);
    L_0x0965:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0988;
    L_0x096b:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0988;
    L_0x0975:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtY;
        r7 = r20.getTitle();
        r6.setText(r7);
    L_0x0988:
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
        if (r5 == 0) goto L_0x0363;
    L_0x09a3:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = r5.a(r6, r7);
        if (r5 == 0) goto L_0x09fb;
    L_0x09bb:
        r6 = r5.isRecycled();
        if (r6 != 0) goto L_0x09fb;
    L_0x09c1:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0363;
    L_0x09ca:
        r0 = r20;
        r6 = r0.cox;
        r7 = 2;
        if (r6 != r7) goto L_0x09dc;
    L_0x09d1:
        r0 = r19;
        r6 = r0.okC;
        r7 = 2131234777; // 0x7f080fd9 float:1.808573E38 double:1.0529698865E-314;
        r6.setText(r7);
        goto L_0x0965;
    L_0x09dc:
        r0 = r20;
        r6 = r0.cox;
        r7 = 3;
        if (r6 != r7) goto L_0x09ef;
    L_0x09e3:
        r0 = r19;
        r6 = r0.okC;
        r7 = 2131234776; // 0x7f080fd8 float:1.8085727E38 double:1.052969886E-314;
        r6.setText(r7);
        goto L_0x0965;
    L_0x09ef:
        r0 = r19;
        r6 = r0.okC;
        r7 = 2131234778; // 0x7f080fda float:1.8085731E38 double:1.052969887E-314;
        r6.setText(r7);
        goto L_0x0965;
    L_0x09fb:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0363;
    L_0x0a07:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtY;
        r7 = r20.getTitle();
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
        if (r5 == 0) goto L_0x0363;
    L_0x0a47:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = r5.a(r6, r7);
        if (r5 == 0) goto L_0x0a6e;
    L_0x0a5f:
        r6 = r5.isRecycled();
        if (r6 != 0) goto L_0x0a6e;
    L_0x0a65:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0363;
    L_0x0a6e:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0363;
    L_0x0a7a:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0aa6;
    L_0x0a80:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0aa6;
    L_0x0a8a:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.dtY;
        r7 = r20.getTitle();
        r6.setText(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
    L_0x0aa6:
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
        if (r5 == 0) goto L_0x0363;
    L_0x0ac1:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = r5.a(r6, r7);
        if (r5 == 0) goto L_0x0ae8;
    L_0x0ad9:
        r6 = r5.isRecycled();
        if (r6 != 0) goto L_0x0ae8;
    L_0x0adf:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0363;
    L_0x0ae8:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0363;
    L_0x0af4:
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0b5f;
    L_0x0afa:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0b5f;
    L_0x0b04:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 0;
        r6.setVisibility(r7);
    L_0x0b0c:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okH;
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
        if (r5 == 0) goto L_0x0363;
    L_0x0b38:
        r0 = r20;
        r5 = r0.appId;
        r6 = 1;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = com.tencent.mm.pluginsdk.model.app.g.b(r5, r6, r7);
        if (r5 == 0) goto L_0x0b53;
    L_0x0b4d:
        r6 = r5.isRecycled();
        if (r6 == 0) goto L_0x0b69;
    L_0x0b53:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0363;
    L_0x0b5f:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0b0c;
    L_0x0b69:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0363;
    L_0x0b72:
        r0 = r20;
        r4 = r0.title;
        if (r4 == 0) goto L_0x0c15;
    L_0x0b78:
        r0 = r20;
        r4 = r0.title;
        r4 = r4.length();
        if (r4 <= 0) goto L_0x0c15;
    L_0x0b82:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 0;
        r4.setVisibility(r6);
    L_0x0b8a:
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
        if (r5 == 0) goto L_0x0bde;
    L_0x0bb6:
        r4 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r5 = r0.field_imgPath;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = com.tencent.mm.bd.a.getDensity(r6);
        r4 = r4.a(r5, r6);
        if (r4 == 0) goto L_0x0bd4;
    L_0x0bce:
        r5 = r4.isRecycled();
        if (r5 == 0) goto L_0x0c20;
    L_0x0bd4:
        r0 = r19;
        r4 = r0.okd;
        r5 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r4.setImageResource(r5);
    L_0x0bde:
        r4 = new com.tencent.mm.ui.chatting.dl;
        r6 = 0;
        r8 = "";
        r9 = 8;
        r10 = 0;
        r0 = r20;
        r11 = r0.title;
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
        goto L_0x0363;
    L_0x0c15:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 8;
        r4.setVisibility(r6);
        goto L_0x0b8a;
    L_0x0c20:
        r0 = r19;
        r5 = r0.okd;
        r5.setImageBitmap(r4);
        goto L_0x0bde;
    L_0x0c28:
        r0 = r20;
        r4 = r0.title;
        if (r4 == 0) goto L_0x0cc9;
    L_0x0c2e:
        r0 = r20;
        r4 = r0.title;
        r4 = r4.length();
        if (r4 <= 0) goto L_0x0cc9;
    L_0x0c38:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 0;
        r4.setVisibility(r6);
    L_0x0c40:
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
        if (r5 == 0) goto L_0x0c94;
    L_0x0c6c:
        r4 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r5 = r0.field_imgPath;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = com.tencent.mm.bd.a.getDensity(r6);
        r4 = r4.a(r5, r6);
        if (r4 == 0) goto L_0x0c8a;
    L_0x0c84:
        r5 = r4.isRecycled();
        if (r5 == 0) goto L_0x0cd4;
    L_0x0c8a:
        r0 = r19;
        r4 = r0.okd;
        r5 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r4.setImageResource(r5);
    L_0x0c94:
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
        goto L_0x0363;
    L_0x0cc9:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 8;
        r4.setVisibility(r6);
        goto L_0x0c40;
    L_0x0cd4:
        r0 = r19;
        r5 = r0.okd;
        r5.setImageBitmap(r4);
        goto L_0x0c94;
    L_0x0cdc:
        r0 = r20;
        r4 = r0.title;
        if (r4 == 0) goto L_0x0dac;
    L_0x0ce2:
        r0 = r20;
        r4 = r0.title;
        r4 = r4.length();
        if (r4 <= 0) goto L_0x0dac;
    L_0x0cec:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 0;
        r4.setVisibility(r6);
    L_0x0cf4:
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
        if (r5 == 0) goto L_0x0d48;
    L_0x0d20:
        r4 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r5 = r0.field_imgPath;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = com.tencent.mm.bd.a.getDensity(r6);
        r4 = r4.a(r5, r6);
        if (r4 == 0) goto L_0x0d3e;
    L_0x0d38:
        r5 = r4.isRecycled();
        if (r5 == 0) goto L_0x0db7;
    L_0x0d3e:
        r0 = r19;
        r4 = r0.okd;
        r5 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r4.setImageResource(r5);
    L_0x0d48:
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
        if (r5 != r6) goto L_0x0dbf;
    L_0x0d7b:
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
    L_0x0da3:
        r0 = r19;
        r5 = r0.okP;
        r5.setTag(r4);
        goto L_0x0363;
    L_0x0dac:
        r0 = r19;
        r4 = r0.dtY;
        r6 = 8;
        r4.setVisibility(r6);
        goto L_0x0cf4;
    L_0x0db7:
        r0 = r19;
        r5 = r0.okd;
        r5.setImageBitmap(r4);
        goto L_0x0d48;
    L_0x0dbf:
        r0 = r20;
        r5 = r0.type;
        r6 = 27;
        if (r5 != r6) goto L_0x0da3;
    L_0x0dc7:
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
        goto L_0x0da3;
    L_0x0df0:
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
        if (r6 == 0) goto L_0x0e6d;
    L_0x0e14:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0e6d;
    L_0x0e1e:
        r0 = r19;
        r6 = r0.okC;
        r7 = 0;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okC;
        r0 = r20;
        r7 = r0.title;
        r6.setText(r7);
    L_0x0e31:
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
        if (r5 == 0) goto L_0x0363;
    L_0x0e4c:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r5 = r5.a(r6, r7);
        if (r5 == 0) goto L_0x0e77;
    L_0x0e64:
        r0 = r19;
        r6 = r0.okd;
        r6.setImageBitmap(r5);
        goto L_0x0363;
    L_0x0e6d:
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0e31;
    L_0x0e77:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2131165247; // 0x7f07003f float:1.7944706E38 double:1.052935534E-314;
        r5.setImageResource(r6);
        goto L_0x0363;
    L_0x0e83:
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
        if (r6 == 0) goto L_0x0f01;
    L_0x0e9a:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.trim();
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0f01;
    L_0x0ea8:
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
        r7 = com.tencent.mm.pluginsdk.ui.d.e.a(r7, r8, r9);
        r6.setText(r7);
    L_0x0ec7:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 3;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0ef4;
    L_0x0ee2:
        r0 = r19;
        r6 = r0.okd;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okO;
        r7 = 8;
        r6.setVisibility(r7);
    L_0x0ef4:
        r0 = r25;
        r1 = r19;
        r2 = r20;
        r3 = r26;
        com.tencent.mm.ui.chatting.m.a(r0, r1, r2, r3, r5);
        goto L_0x0363;
    L_0x0f01:
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
        r7 = com.tencent.mm.pluginsdk.ui.d.e.a(r7, r8, r9);
        r6.setText(r7);
        goto L_0x0ec7;
    L_0x0f28:
        r0 = r19;
        r6 = r0.dtY;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r20;
        r6 = r0.title;
        if (r6 == 0) goto L_0x0fb3;
    L_0x0f37:
        r0 = r20;
        r6 = r0.title;
        r6 = r6.trim();
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0fb3;
    L_0x0f45:
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
        r7 = com.tencent.mm.pluginsdk.ui.d.e.a(r7, r8, r9);
        r6.setText(r7);
    L_0x0f74:
        r0 = r19;
        r6 = r0.dtZ;
        r7 = 4;
        r6.setMaxLines(r7);
        r0 = r19;
        r6 = r0.okH;
        r7 = 8;
        r6.setVisibility(r7);
        r0 = r19;
        r6 = r0.okD;
        r7 = 4;
        r6.setVisibility(r7);
        if (r5 == 0) goto L_0x0f98;
    L_0x0f8f:
        r0 = r19;
        r6 = r0.okd;
        r7 = 8;
        r6.setVisibility(r7);
    L_0x0f98:
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
        goto L_0x0363;
    L_0x0fb3:
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0f74;
    L_0x0fbd:
        r0 = r20;
        r5 = r0.title;
        if (r5 == 0) goto L_0x1103;
    L_0x0fc3:
        r0 = r20;
        r5 = r0.title;
        r5 = r5.length();
        if (r5 <= 0) goto L_0x1103;
    L_0x0fcd:
        r0 = r19;
        r5 = r0.dtY;
        r6 = 0;
        r5.setVisibility(r6);
        r0 = r20;
        r5 = r0.cpw;
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r5);
        if (r5 != 0) goto L_0x10e9;
    L_0x0fdf:
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
    L_0x0fff:
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
        if (r5 != 0) goto L_0x110e;
    L_0x1019:
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
    L_0x1039:
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
        if (r5 != 0) goto L_0x1128;
    L_0x106d:
        r0 = r19;
        r5 = r0.fSs;
        r0 = r20;
        r6 = r0.cps;
        r5.setText(r6);
    L_0x1078:
        r0 = r22;
        r5 = r0.lVu;
        if (r5 == 0) goto L_0x114c;
    L_0x107e:
        r5 = com.tencent.mm.ae.n.GH();
        r0 = r26;
        r6 = r0.field_imgPath;
        r0 = r25;
        r7 = r0.nDR;
        r7 = r7.nEl;
        r7 = com.tencent.mm.bd.a.getDensity(r7);
        r8 = 0;
        r5 = r5.a(r6, r7, r8);
        if (r5 == 0) goto L_0x10b0;
    L_0x1097:
        r6 = r5.isRecycled();
        if (r6 != 0) goto L_0x10b0;
    L_0x109d:
        r6 = 0;
        r7 = r5.getWidth();
        r7 = r7 / 2;
        r7 = (float) r7;
        r6 = com.tencent.mm.sdk.platformtools.d.a(r5, r6, r7);
        r0 = r19;
        r7 = r0.okd;
        r7.setImageBitmap(r6);
    L_0x10b0:
        r0 = r20;
        r6 = r0.cpv;
        r6 = com.tencent.mm.sdk.platformtools.be.kS(r6);
        if (r6 != 0) goto L_0x1134;
    L_0x10ba:
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
        r9 = new com.tencent.mm.ui.chatting.ao$2;
        r0 = r22;
        r1 = r19;
        r2 = r25;
        r9.<init>(r0, r1, r2);
        r5.a(r6, r7, r8, r9);
        goto L_0x0363;
    L_0x10e9:
        r0 = r19;
        r5 = r0.dtY;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = r6.getResources();
        r7 = 2131689547; // 0x7f0f004b float:1.9008112E38 double:1.053194573E-314;
        r6 = r6.getColor(r7);
        r5.setTextColor(r6);
        goto L_0x0fff;
    L_0x1103:
        r0 = r19;
        r5 = r0.dtY;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0fff;
    L_0x110e:
        r0 = r19;
        r5 = r0.dtZ;
        r0 = r25;
        r6 = r0.nDR;
        r6 = r6.nEl;
        r6 = r6.getResources();
        r7 = 2131689769; // 0x7f0f0129 float:1.9008563E38 double:1.0531946825E-314;
        r6 = r6.getColor(r7);
        r5.setTextColor(r6);
        goto L_0x1039;
    L_0x1128:
        r0 = r19;
        r5 = r0.fSs;
        r6 = 2131231814; // 0x7f080446 float:1.807972E38 double:1.0529684226E-314;
        r5.setText(r6);
        goto L_0x1078;
    L_0x1134:
        r0 = r19;
        r6 = r0.okQ;
        r6 = r6.getViewTreeObserver();
        r7 = new com.tencent.mm.ui.chatting.ao$3;
        r0 = r22;
        r1 = r19;
        r2 = r25;
        r7.<init>(r0, r1, r2, r5);
        r6.addOnPreDrawListener(r7);
        goto L_0x0363;
    L_0x114c:
        r0 = r19;
        r5 = r0.okd;
        r6 = r25.getResources();
        r7 = 2130838790; // 0x7f020506 float:1.7282572E38 double:1.052774243E-314;
        r6 = android.graphics.BitmapFactory.decodeResource(r6, r7);
        r5.setImageBitmap(r6);
        goto L_0x0363;
    L_0x1160:
        r0 = r19;
        r6 = r0.okC;
        r7 = 8;
        r6.setVisibility(r7);
        goto L_0x0333;
    L_0x116b:
        r0 = r19;
        r5 = r0.okd;
        r6 = 2130837666; // 0x7f0200a2 float:1.7280293E38 double:1.0527736876E-314;
        r5.setImageResource(r6);
        goto L_0x0363;
    L_0x1177:
        r0 = r19;
        r5 = r0.okJ;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0388;
    L_0x1182:
        r0 = r19;
        r5 = r0.okJ;
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x0388;
    L_0x118d:
        r12 = r4;
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ao.a(com.tencent.mm.ui.chatting.ad$a, int, com.tencent.mm.ui.chatting.ChattingUI$a, com.tencent.mm.storage.at, java.lang.String):void");
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        int GC = l.GC(this.onG.cf(atVar.field_content, atVar.field_isSend));
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.onG.cf(atVar.field_content, atVar.field_isSend));
        f aC = g.aC(dV.appId, false);
        if (g.i(aC)) {
            contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_READABLE, 0, this.onG.getString(2131234555));
        }
        if (dV.cob <= 0 || (dV.cob > 0 && GC >= 100)) {
            boolean De;
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
        com.tencent.mm.sdk.c.b cpVar = new cp();
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
        switch (menuItem.getItemId()) {
            case 100:
                String str = atVar.field_content;
                aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.q.a.a.dV(str);
                }
                if (aVar2 != null) {
                    l.GB(aVar2.aXa);
                    if (19 == aVar2.type) {
                        com.tencent.mm.sdk.c.b kwVar = new kw();
                        kwVar.bmf.type = 3;
                        kwVar.bmf.bao = atVar.field_msgId;
                        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
                    }
                }
                aw.L(atVar.field_msgId);
                f aC = g.aC(aVar2.appId, false);
                if (aC != null && aC.bnk()) {
                    ad.a(aVar, aVar2, atVar, aC);
                    break;
                }
            case MMGIFException.D_GIF_ERR_NOT_READABLE /*111*/:
                c.a(aVar, atVar, a(aVar, atVar));
                break;
            case 114:
                String str2 = atVar.field_content;
                if (str2 != null) {
                    aVar2 = com.tencent.mm.q.a.a.dV(str2);
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
        com.tencent.mm.modelstat.a.a(atVar, com.tencent.mm.modelstat.a.a.Click);
        String str = atVar.field_content;
        if (str == null) {
            return false;
        }
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(aVar.cf(str, atVar.field_isSend));
        if (dV == null) {
            return false;
        }
        String str2;
        f aC = g.aC(dV.appId, false);
        if (aC != null && aC.bnk()) {
            ad.a(aVar, dV, ad.c(aVar, atVar), aC, atVar.field_msgSvrId);
        }
        Intent intent;
        switch (dV.type) {
            case 3:
                com.tencent.mm.plugin.report.service.g.iuh.h(13043, Integer.valueOf(2), dV.description, dV.appId);
                break;
            case 4:
                break;
            case 6:
                if (this.lVu) {
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
                if (dV.aXa == null || dV.aXa.length() == 0) {
                    aVar.an(atVar);
                } else if (this.lVu) {
                    intent = new Intent(aVar.nDR.nEl, AppAttachDownloadUI.class);
                    intent.putExtra("app_msg_id", atVar.field_msgId);
                    aVar.startActivityForResult(intent, 210);
                } else {
                    s.ey(aVar.nDR.nEl);
                    return true;
                }
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
                com.tencent.mm.sdk.c.b joVar = new jo();
                joVar.bjY.context = aVar.nDR.nEl;
                joVar.bjY.bao = atVar.field_msgId;
                joVar.bjY.bjZ = dV.coC;
                com.tencent.mm.sdk.c.a.nhr.z(joVar);
                return true;
            case 33:
                v.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", dV.cqp, dV.cqo, dV.cqq, dV.url, Integer.valueOf(dV.cqt), dV.cqs);
                switch (dV.cqr) {
                    case 1:
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_username", dV.cqp);
                        if (aVar.onl) {
                            intent2.putExtra("key_from_scene", 1);
                            intent2.putExtra("key_scene_note", aVar.bEn() + ":" + a(aVar, atVar));
                        } else {
                            intent2.putExtra("key_from_scene", 2);
                            intent2.putExtra("key_scene_note", aVar.bEn());
                        }
                        intent2.putExtra("key_scene_export_url_params", new AppBrandExportUrlParams(dV.cqq, 6, SQLiteDatabase.KeyEmpty, dV.cqt, dV.hsN));
                        com.tencent.mm.ay.c.b(aVar.nDR.nEl, "appbrand", ".ui.AppBrandProfileUI", intent2);
                        break;
                    case 2:
                        com.tencent.mm.sdk.c.b okVar = new ok();
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
                intent.putExtra("key_from_user_name", a(aVar, atVar));
                intent.putExtra("key_biz_uin", dV.cpq);
                intent.putExtra("key_order_id", dV.cpr);
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "card", ".ui.CardGiftAcceptUI", intent);
                return true;
            default:
                if (!(dV.url == null || dV.url.equals(SQLiteDatabase.KeyEmpty))) {
                    if (be.kS(dV.canvasPageXml)) {
                        str = p.s(dV.url, aVar.onl ? "groupmessage" : "singlemessage");
                        str2 = dV.url;
                        PackageInfo av = ad.av(aVar.nDR.nEl, dV.appId);
                        Intent intent3 = new Intent();
                        intent3.putExtra("rawUrl", str);
                        intent3.putExtra("webpageTitle", dV.title);
                        if (dV.appId != null && ("wx751a1acca5688ba3".equals(dV.appId) || "wxfbc915ff7c30e335".equals(dV.appId) || "wx482a4001c37e2b74".equals(dV.appId))) {
                            Bundle bundle = new Bundle();
                            bundle.putString("jsapi_args_appid", dV.appId);
                            intent3.putExtra("jsapiargs", bundle);
                        }
                        if (be.kS(str2)) {
                            intent3.putExtra("shortUrl", dV.url);
                        } else {
                            intent3.putExtra("shortUrl", str2);
                        }
                        intent3.putExtra("version_name", av == null ? null : av.versionName);
                        intent3.putExtra("version_code", av == null ? 0 : av.versionCode);
                        if (!be.kS(dV.bnR)) {
                            intent3.putExtra("srcUsername", dV.bnR);
                            intent3.putExtra("srcDisplayname", dV.bnS);
                        }
                        intent3.putExtra("msg_id", atVar.field_msgId);
                        intent3.putExtra("KPublisherId", "msg_" + Long.toString(atVar.field_msgSvrId));
                        intent3.putExtra("KAppId", dV.appId);
                        intent3.putExtra("geta8key_username", aVar.bEn());
                        intent3.putExtra("pre_username", a(aVar, atVar));
                        intent3.putExtra("from_scence", 2);
                        intent3.putExtra("expid_str", atVar.bNx);
                        intent3.putExtra("prePublishId", "msg_" + Long.toString(atVar.field_msgSvrId));
                        intent3.putExtra("preUsername", a(aVar, atVar));
                        intent3.putExtra("preChatName", aVar.bEn());
                        intent3.putExtra("preChatTYPE", n.F(a(aVar, atVar), aVar.bEn()));
                        intent3.putExtra("preMsgIndex", 0);
                        com.tencent.mm.ay.c.b(aVar.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent3);
                    } else {
                        intent = new Intent();
                        intent.putExtra("sns_landig_pages_from_source", 5);
                        intent.putExtra("msg_id", atVar.field_msgId);
                        intent.putExtra("sns_landing_pages_xml", dV.canvasPageXml);
                        intent.putExtra("sns_landing_pages_share_thumb_url", atVar.field_imgPath);
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        com.tencent.mm.ay.c.b(aVar.nDR.nEl, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                        return true;
                    }
                }
                return true;
        }
        if (u.bj(aVar.nDR.nEl) || com.tencent.mm.ah.a.aT(aVar.nDR.nEl)) {
            v.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
            return true;
        } else if (a(aVar, dV, atVar)) {
            return true;
        } else {
            str2 = p.s(dV.url, "message");
            String s = p.s(dV.coa, "message");
            PackageInfo av2 = ad.av(aVar.nDR.nEl, dV.appId);
            a(aVar, str2, s, av2 == null ? null : av2.versionName, av2 == null ? 0 : av2.versionCode, dV.appId, true, atVar.field_msgId, atVar.field_msgSvrId, atVar);
            return true;
        }
    }
}

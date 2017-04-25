package com.tencent.mm.ui.chatting;

import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class cs implements OnLongClickListener {
    private OnCreateContextMenuListener ima;
    private a onG;

    public cs(OnCreateContextMenuListener onCreateContextMenuListener, a aVar) {
        this.onG = aVar;
        this.ima = onCreateContextMenuListener;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onLongClick(android.view.View r10) {
        /*
        r9 = this;
        r8 = 10976; // 0x2ae0 float:1.538E-41 double:5.423E-320;
        r4 = 3;
        r7 = 2;
        r6 = 0;
        r5 = 1;
        r0 = r10.getTag();
        r0 = r0 instanceof com.tencent.mm.ui.chatting.dl;
        if (r0 == 0) goto L_0x0173;
    L_0x000e:
        r0 = r10.getTag();
        r0 = (com.tencent.mm.ui.chatting.dl) r0;
        r1 = r9.onG;
        r1 = r1.hjH;
        r1 = r1.hhK;
        r2 = r1.getSelectionStart();
        r1 = r0.eKg;
        if (r1 != r5) goto L_0x016d;
    L_0x0022:
        r1 = r9.onG;
        r1 = r1.otQ;
        if (r1 != 0) goto L_0x0032;
    L_0x0028:
        r0 = "MicroMsg.ChattingListLongClickListener";
        r1 = "ChattingUI disable Touch NOW!!!";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
    L_0x0031:
        return r5;
    L_0x0032:
        r1 = r0.userName;
        r3 = com.tencent.mm.model.k.xF();
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x0031;
    L_0x003e:
        r1 = r9.onG;
        r1 = r1.bEn();
        r1 = com.tencent.mm.model.m.dE(r1);
        if (r1 != 0) goto L_0x0050;
    L_0x004a:
        r1 = r9.onG;
        r1 = r1.otJ;
        if (r1 == 0) goto L_0x00e7;
    L_0x0050:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;
        r3 = new java.lang.Object[r4];
        r4 = java.lang.Integer.valueOf(r6);
        r3[r6] = r4;
        r4 = java.lang.Integer.valueOf(r5);
        r3[r5] = r4;
        r4 = java.lang.Integer.valueOf(r6);
        r3[r7] = r4;
        r1.h(r8, r3);
        r1 = com.tencent.mm.model.ak.yW();
        r1 = r1.wO();
        r3 = r0.biB;
        r1 = r1.LC(r3);
        r3 = r9.onG;
        r3 = r3.otJ;
        if (r3 == 0) goto L_0x00d4;
    L_0x007d:
        r1 = r9.onG;
        r0 = r0.userName;
        r0 = r1.er(r0);
    L_0x0085:
        r1 = new java.lang.StringBuffer;
        r3 = r9.onG;
        r3 = r3.hjH;
        r3 = r3.bpJ();
        r1.<init>(r3);
        r3 = new java.lang.StringBuilder;
        r4 = "@";
        r3.<init>(r4);
        r3 = r3.append(r0);
        r4 = 8197; // 0x2005 float:1.1486E-41 double:4.05E-320;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1.insert(r2, r3);
        r3 = r9.onG;
        r3 = r3.hjH;
        r1 = r1.toString();
        r0 = r0.length();
        r0 = r0 + r2;
        r0 = r0 + 2;
        r3.l(r1, r0, r5);
        r0 = r9.onG;
        r0.otQ = r6;
        r0 = r9.onG;
        r0 = r0.hjH;
        r0.R(r5, r5);
        r0 = new com.tencent.mm.ui.chatting.cs$1;
        r0.<init>(r9);
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r10.postDelayed(r0, r2);
        goto L_0x0031;
    L_0x00d4:
        r3 = r0.userName;
        r1 = com.tencent.mm.ui.chatting.AtSomeoneUI.a(r1, r3);
        r3 = com.tencent.mm.platformtools.t.kS(r1);
        if (r3 == 0) goto L_0x017f;
    L_0x00e0:
        r0 = r0.userName;
        r0 = com.tencent.mm.model.l.ep(r0);
        goto L_0x0085;
    L_0x00e7:
        r1 = r9.onG;
        r1 = r1.bEn();
        r1 = com.tencent.mm.model.m.eC(r1);
        if (r1 == 0) goto L_0x0031;
    L_0x00f3:
        r1 = r9.onG;
        r1 = r1.bEn();
        r3 = "@";
        r1 = r1.contains(r3);
        if (r1 != 0) goto L_0x0031;
    L_0x0102:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;
        r3 = new java.lang.Object[r4];
        r4 = java.lang.Integer.valueOf(r6);
        r3[r6] = r4;
        r4 = java.lang.Integer.valueOf(r5);
        r3[r5] = r4;
        r4 = java.lang.Integer.valueOf(r5);
        r3[r7] = r4;
        r1.h(r8, r3);
        r1 = r9.onG;
        r1 = r1.lKa;
        if (r1 == 0) goto L_0x0166;
    L_0x0121:
        r1 = r9.onG;
        r1 = r1.otJ;
        if (r1 != 0) goto L_0x0166;
    L_0x0127:
        r1 = r9.onG;
        r0 = r0.userName;
        r0 = r1.er(r0);
    L_0x012f:
        r1 = new java.lang.StringBuffer;
        r3 = r9.onG;
        r3 = r3.hjH;
        r3 = r3.bpJ();
        r1.<init>(r3);
        r1.insert(r2, r0);
        r3 = r9.onG;
        r3 = r3.hjH;
        r1 = r1.toString();
        r0 = r0.length();
        r0 = r0 + r2;
        r3.l(r1, r0, r5);
        r0 = r9.onG;
        r0.otQ = r6;
        r0 = r9.onG;
        r0 = r0.hjH;
        r0.R(r5, r5);
        r0 = new com.tencent.mm.ui.chatting.cs$2;
        r0.<init>(r9);
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r10.postDelayed(r0, r2);
        goto L_0x0031;
    L_0x0166:
        r0 = r0.userName;
        r0 = com.tencent.mm.model.l.ep(r0);
        goto L_0x012f;
    L_0x016d:
        r0 = r0.eKg;
        r1 = 9;
        if (r0 == r1) goto L_0x0031;
    L_0x0173:
        r0 = r9.ima;
        r10.setOnCreateContextMenuListener(r0);
        r0 = r9.onG;
        r0.openContextMenu(r10);
        goto L_0x0031;
    L_0x017f:
        r0 = r1;
        goto L_0x0085;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.cs.onLongClick(android.view.View):boolean");
    }
}

package com.tencent.mm.plugin.wear.model.e;

import java.util.ArrayList;
import java.util.List;

public final class g extends a {
    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11005));
        arrayList.add(Integer.valueOf(11006));
        arrayList.add(Integer.valueOf(11007));
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final byte[] l(int r10, byte[] r11) {
        /*
        r9 = this;
        r8 = -1;
        r1 = 0;
        r6 = 1;
        r7 = 0;
        r0 = 11005; // 0x2afd float:1.5421E-41 double:5.437E-320;
        if (r10 != r0) goto L_0x006c;
    L_0x0008:
        r0 = new com.tencent.mm.protocal.c.bgy;
        r0.<init>();
        r0.az(r11);	 Catch:{ IOException -> 0x0042 }
    L_0x0010:
        r2 = new com.tencent.mm.protocal.c.bgz;
        r2.<init>();
        r3 = r0.mdw;
        r3 = com.tencent.mm.plugin.wear.model.h.DL(r3);
        if (r3 == 0) goto L_0x005c;
    L_0x001d:
        r4 = java.lang.System.currentTimeMillis();
        r2.nco = r4;
        r3 = com.tencent.mm.plugin.wear.model.h.A(r3);
        r4 = "MicroMsg.Wear.HttpImageServer";
        r5 = "return avatar data username=%s";
        r6 = new java.lang.Object[r6];
        r0 = r0.mdw;
        r6[r7] = r0;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        r0 = new com.tencent.mm.ba.b;
        r0.<init>(r3);
        r2.eew = r0;
        r1 = r2.toByteArray();	 Catch:{ IOException -> 0x004f }
    L_0x0041:
        return r1;
    L_0x0042:
        r2 = move-exception;
        r3 = "MicroMsg.Wear.HttpImageServer";
        r4 = "";
        r5 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0010;
    L_0x004f:
        r0 = move-exception;
        r2 = "MicroMsg.Wear.HttpImageServer";
        r3 = "";
        r4 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r3, r4);
        goto L_0x0041;
    L_0x005c:
        r2 = "MicroMsg.Wear.HttpImageServer";
        r3 = "get avatar fail, %s";
        r4 = new java.lang.Object[r6];
        r0 = r0.mdw;
        r4[r7] = r0;
        com.tencent.mm.sdk.platformtools.v.w(r2, r3, r4);
        goto L_0x0041;
    L_0x006c:
        r0 = 11006; // 0x2afe float:1.5423E-41 double:5.4377E-320;
        if (r10 != r0) goto L_0x00e6;
    L_0x0070:
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0095 }
        r2 = "utf8";
        r0.<init>(r11, r2);	 Catch:{ UnsupportedEncodingException -> 0x0095 }
        r2 = com.tencent.mm.pluginsdk.j.a.bmr();
        r0 = r2.rg(r0);
        if (r0 == 0) goto L_0x0041;
    L_0x0082:
        r2 = r0.bnk();
        if (r2 == 0) goto L_0x00a2;
    L_0x0088:
        r1 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r0 = r0.eh(r1);
        r1 = com.tencent.mm.plugin.wear.model.h.A(r0);
        goto L_0x0041;
    L_0x0095:
        r0 = move-exception;
        r2 = "MicroMsg.Wear.HttpImageServer";
        r3 = "";
        r4 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r3, r4);
        goto L_0x0041;
    L_0x00a2:
        r2 = r0.field_catalog;
        r3 = com.tencent.mm.storage.a.a.nwJ;
        if (r2 != r3) goto L_0x00dc;
    L_0x00a8:
        r2 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ Exception -> 0x00bc, all -> 0x00d6 }
        r0 = r0.getName();	 Catch:{ Exception -> 0x00bc, all -> 0x00d6 }
        r2 = com.tencent.mm.storage.a.c.ba(r2, r0);	 Catch:{ Exception -> 0x00bc, all -> 0x00d6 }
        r1 = com.tencent.mm.loader.stub.b.d(r2);	 Catch:{ Exception -> 0x01f9 }
        com.tencent.mm.a.e.c(r2);
        goto L_0x0041;
    L_0x00bc:
        r0 = move-exception;
        r2 = r1;
    L_0x00be:
        r3 = "MicroMsg.Wear.HttpImageServer";
        r4 = "exception:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x01f6 }
        r6 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.e(r0);	 Catch:{ all -> 0x01f6 }
        r5[r6] = r0;	 Catch:{ all -> 0x01f6 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);	 Catch:{ all -> 0x01f6 }
        com.tencent.mm.a.e.c(r2);
        goto L_0x0041;
    L_0x00d6:
        r0 = move-exception;
        r2 = r1;
    L_0x00d8:
        com.tencent.mm.a.e.c(r2);
        throw r0;
    L_0x00dc:
        r1 = com.tencent.mm.pluginsdk.j.a.bmr();
        r1 = r1.g(r0);
        goto L_0x0041;
    L_0x00e6:
        r0 = 11007; // 0x2aff float:1.5424E-41 double:5.438E-320;
        if (r10 != r0) goto L_0x0041;
    L_0x00ea:
        r0 = new com.tencent.mm.protocal.c.bhq;
        r0.<init>();
        r0.az(r11);	 Catch:{ IOException -> 0x012f }
    L_0x00f2:
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.wJ();
        r4 = r0.ncz;
        r2 = r2.ek(r4);
        r0 = r0.ncD;
        if (r0 != 0) goto L_0x013c;
    L_0x0103:
        r0 = com.tencent.mm.ae.n.GH();
        r2 = r2.field_imgPath;
        r0 = r0.iW(r2);
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r2 != 0) goto L_0x0041;
    L_0x0113:
        r2 = new com.tencent.mm.protocal.c.bhr;
        r2.<init>();
        r4 = java.lang.System.currentTimeMillis();
        r2.nco = r4;
        r3 = new com.tencent.mm.ba.b;
        r0 = com.tencent.mm.modelsfs.FileOp.c(r0, r7, r8);
        r3.<init>(r0);
        r2.eew = r3;
        r1 = r2.toByteArray();	 Catch:{ IOException -> 0x01f0 }
        goto L_0x0041;
    L_0x012f:
        r2 = move-exception;
        r3 = "MicroMsg.Wear.HttpImageServer";
        r4 = "";
        r5 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x00f2;
    L_0x013c:
        r3 = new com.tencent.mm.protocal.c.bhr;
        r3.<init>();
        r4 = java.lang.System.currentTimeMillis();
        r3.nco = r4;
        r0 = r2.field_isSend;
        if (r0 != r6) goto L_0x01a0;
    L_0x014b:
        r0 = com.tencent.mm.ae.n.GH();
        r4 = r2.field_msgId;
        r2 = r0.ai(r4);
        r0 = com.tencent.mm.ae.n.GH();
        r4 = com.tencent.mm.ae.n.GH();
        r4 = r4.d(r2);
        r5 = "";
        r6 = "";
        r0 = r0.l(r4, r5, r6);
        r4 = com.tencent.mm.modelsfs.FileOp.aR(r0);
        if (r4 == 0) goto L_0x0188;
    L_0x0171:
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r2 != 0) goto L_0x0041;
    L_0x0177:
        r2 = new com.tencent.mm.ba.b;
        r0 = com.tencent.mm.modelsfs.FileOp.c(r0, r7, r8);
        r2.<init>(r0);
        r3.eew = r2;
        r1 = r3.toByteArray();	 Catch:{ IOException -> 0x01f3 }
        goto L_0x0041;
    L_0x0188:
        r0 = com.tencent.mm.ae.n.GH();
        r2 = r2.cLv;
        r4 = "";
        r5 = "";
        r0 = r0.l(r2, r4, r5);
        r2 = com.tencent.mm.modelsfs.FileOp.aR(r0);
        if (r2 != 0) goto L_0x0171;
    L_0x019e:
        r0 = r1;
        goto L_0x0171;
    L_0x01a0:
        r0 = com.tencent.mm.ae.n.GH();
        r4 = r2.field_msgSvrId;
        r2 = r0.ah(r4);
        r0 = r2.Go();
        if (r0 == 0) goto L_0x019e;
    L_0x01b0:
        r0 = r2.Gp();
        if (r0 == 0) goto L_0x01fc;
    L_0x01b6:
        r0 = com.tencent.mm.ae.n.GH();
        r4 = com.tencent.mm.ae.n.GH();
        r4 = r4.d(r2);
        r5 = "";
        r6 = "";
        r0 = r0.l(r4, r5, r6);
        r4 = com.tencent.mm.modelsfs.FileOp.aR(r0);
        if (r4 == 0) goto L_0x01fc;
    L_0x01d2:
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r4 == 0) goto L_0x0171;
    L_0x01d8:
        r4 = com.tencent.mm.ae.n.GH();
        r2 = r2.cLv;
        r5 = "";
        r6 = "";
        r2 = r4.l(r2, r5, r6);
        r4 = com.tencent.mm.modelsfs.FileOp.aR(r2);
        if (r4 == 0) goto L_0x0171;
    L_0x01ee:
        r0 = r2;
        goto L_0x0171;
    L_0x01f0:
        r0 = move-exception;
        goto L_0x0041;
    L_0x01f3:
        r0 = move-exception;
        goto L_0x0041;
    L_0x01f6:
        r0 = move-exception;
        goto L_0x00d8;
    L_0x01f9:
        r0 = move-exception;
        goto L_0x00be;
    L_0x01fc:
        r0 = r1;
        goto L_0x01d2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wear.model.e.g.l(int, byte[]):byte[]");
    }
}

package com.tencent.mm.plugin.sns.e.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.h.j;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.appbrand.jsapi.map.g;
import com.tencent.mm.plugin.sns.e.a.b.a;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.lucky.b.b;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public abstract class e extends b {
    protected boolean joL = false;
    protected boolean joM = false;
    protected boolean joN = false;
    protected boolean joO = false;

    protected abstract int aTm();

    public e(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String AS(String str) {
        String str2;
        Exception e;
        int i = 2;
        Object obj = null;
        try {
            int i2;
            Object obj2;
            Object obj3;
            int i3;
            String value = j.sU().getValue("SnsCloseDownloadWebp");
            if (be.kS(value)) {
                i2 = 0;
            } else {
                i2 = be.KL(value);
            }
            if (i2 != 0) {
                obj2 = null;
            } else if (VERSION.SDK_INT < 14) {
                obj2 = null;
            } else if (p.ceJ.cej == 2) {
                obj2 = null;
            } else if (be.kS(q.dqZ)) {
                int i4 = 1;
            } else {
                obj2 = null;
            }
            if (!m.rE()) {
                obj3 = null;
            } else if (!ad.aSN()) {
                obj3 = null;
            } else if (be.kS(q.dqZ)) {
                i2 = 1;
            } else {
                obj3 = null;
            }
            if (m.rE() && ad.aSM() && be.kS(q.dqZ)) {
                i3 = 1;
            }
            if (!be.kS(q.dqY) || !be.kS(q.dqZ)) {
                if (!be.kS(q.dqY)) {
                    String[] split = str.split("(//?)");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split[0]).append("//").append(q.dqY);
                    while (i < split.length) {
                        stringBuilder.append("/").append(split[i]);
                        i++;
                    }
                    str = stringBuilder.toString();
                    v.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
                }
                if (!be.kS(q.dqZ)) {
                    str = e(str, "tp=" + q.dqZ);
                    v.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  " + str);
                }
            } else if (obj3 != null) {
                str = e(str, "tp=wxpc");
                v.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            } else if (obj != null) {
                str = e(str, "tp=hevc");
                v.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            } else if (obj2 != null) {
                str = e(str, "tp=webp");
                v.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            }
            if (!(this.jow == null || this.jow.jfX.mIb == 0)) {
                str = e(str, "enc=1");
                v.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.jow.jfX.mIc + " " + this.jow.jfX.mIb + " " + str);
                b.kZ(g.CTRL_INDEX);
                this.joO = true;
            }
            str2 = str;
            try {
                if (!(this.jow == null || this.jow.jfX == null)) {
                    Object obj4;
                    aib com_tencent_mm_protocal_c_aib = this.jow.jfX;
                    if (this.jow.joq) {
                        obj4 = com_tencent_mm_protocal_c_aib.mIh;
                    } else {
                        String str3 = com_tencent_mm_protocal_c_aib.mIe;
                    }
                    i3 = this.jow.joq ? com_tencent_mm_protocal_c_aib.mIi : com_tencent_mm_protocal_c_aib.mIf;
                    if (!TextUtils.isEmpty(obj4)) {
                        str2 = e(str2, "token=" + obj4, "idx=" + i3);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
            v.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
            return str2;
        }
        return str2;
    }

    private static String e(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(str.contains("?") ? "&" : "?");
        Object obj = 1;
        for (String str2 : strArr) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("&");
            }
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.InputStream r14, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r15) {
        /*
        r13 = this;
        r2 = 0;
        r1 = 1;
        r9 = 0;
        r0 = "Content-Type";
        r0 = r15.get(r0);
        r0 = (java.util.List) r0;
        if (r0 == 0) goto L_0x0030;
    L_0x000e:
        r3 = r0.size();
        if (r3 <= 0) goto L_0x0030;
    L_0x0014:
        r0 = r0.get(r9);
        r0 = (java.lang.String) r0;
        r3 = "";
        r0 = com.tencent.mm.sdk.platformtools.be.ah(r0, r3);
        r3 = r0.toLowerCase();
        r4 = "webp";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x0115;
    L_0x002e:
        r13.joL = r1;
    L_0x0030:
        r0 = "X-Enc";
        r0 = r15.get(r0);
        r0 = (java.util.List) r0;
        if (r0 == 0) goto L_0x005d;
    L_0x003b:
        r3 = r0.size();
        if (r3 <= 0) goto L_0x005d;
    L_0x0041:
        r0 = r0.get(r9);
        r0 = (java.lang.String) r0;
        r3 = "";
        r0 = com.tencent.mm.sdk.platformtools.be.ah(r0, r3);
        r0 = r0.toLowerCase();
        r3 = "1";
        r0 = r0.contains(r3);
        if (r0 == 0) goto L_0x005d;
    L_0x005b:
        r13.joN = r1;
    L_0x005d:
        r0 = r13.joO;
        if (r0 == 0) goto L_0x006a;
    L_0x0061:
        r0 = r13.joN;
        if (r0 != 0) goto L_0x006a;
    L_0x0065:
        r0 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        com.tencent.mm.plugin.sns.lucky.b.b.kZ(r0);
    L_0x006a:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r8 = new byte[r0];	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = "MicroMsg.SnsDownloadImageBase";
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = "isEnc ";
        r3.<init>(r4);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = r13.joN;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = " ";
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4.<init>();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r5 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r5 = r5.getPath();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r5 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r5 = r5.aTi();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = com.tencent.mm.modelsfs.f.jX(r4);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        com.tencent.mm.sdk.platformtools.v.i(r0, r3);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r13.joN;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        if (r0 == 0) goto L_0x013e;
    L_0x00b6:
        r0 = "";
        r3 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.jfX;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        if (r3 == 0) goto L_0x00cb;
    L_0x00bf:
        r0 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.joq;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        if (r0 == 0) goto L_0x0137;
    L_0x00c5:
        r0 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.jfX;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.mIj;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
    L_0x00cb:
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3.<init>();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = r4.getPath();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = r4.aTi();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = com.tencent.mm.modelsfs.FileOp.Z(r3, r0);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
    L_0x00ec:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r10 = new com.tencent.mm.pointers.PString;	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r10.<init>();	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r4 = r6;
        r0 = r9;
    L_0x00f7:
        r11 = r14.read(r8);	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r12 = -1;
        if (r11 == r12) goto L_0x01d1;
    L_0x00fe:
        r0 = com.tencent.mm.plugin.sns.e.ad.xq();	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r0 = com.tencent.mm.plugin.sns.data.i.zV(r0);	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        if (r0 != 0) goto L_0x01b9;
    L_0x0108:
        r3.close();	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r14.close();	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        if (r3 == 0) goto L_0x0113;
    L_0x0110:
        r3.close();	 Catch:{ IOException -> 0x01ab }
    L_0x0113:
        r0 = r9;
    L_0x0114:
        return r0;
    L_0x0115:
        r3 = r0.toLowerCase();
        r4 = "hevc";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x0126;
    L_0x0122:
        r13.joM = r1;
        goto L_0x0030;
    L_0x0126:
        r0 = r0.toLowerCase();
        r3 = "wxpc";
        r0 = r0.contains(r3);
        if (r0 == 0) goto L_0x0030;
    L_0x0133:
        r13.joM = r1;
        goto L_0x0030;
    L_0x0137:
        r0 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.jfX;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.mIg;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        goto L_0x00cb;
    L_0x013e:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0.<init>();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.getPath();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.append(r3);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.aTi();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.append(r3);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = com.tencent.mm.modelsfs.f.jW(r0);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        if (r0 == 0) goto L_0x0184;
    L_0x0161:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0.<init>();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.getPath();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.append(r3);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.aTi();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.append(r3);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = com.tencent.mm.modelsfs.FileOp.gt(r0);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        goto L_0x00ec;
    L_0x0184:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0.<init>();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.getPath();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.append(r3);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r13.jow;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r3.aTi();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.append(r3);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = com.tencent.mm.modelsfs.f.jX(r0);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = com.tencent.mm.modelsfs.FileOp.gt(r0);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        goto L_0x00ec;
    L_0x01ab:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = "";
        r3 = new java.lang.Object[r9];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        goto L_0x0113;
    L_0x01b9:
        r0 = 0;
        r3.write(r8, r0, r11);	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r0 = r13.joI;	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r0 = r0 + r11;
        r13.joI = r0;	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r0 = r13.joI;	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r0 = com.tencent.mm.plugin.sns.e.a.b.a(r0, r4, r10);	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        if (r0 == 0) goto L_0x02b7;
    L_0x01ca:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r0 = r9;
        goto L_0x00f7;
    L_0x01d1:
        r3.close();	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        r14.close();	 Catch:{ IOException -> 0x02b3, Exception -> 0x02b0, all -> 0x02aa }
        if (r0 == 0) goto L_0x01e0;
    L_0x01d9:
        r0 = r13.joI;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = 0;
        com.tencent.mm.plugin.sns.e.a.b.a(r0, r4, r10);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
    L_0x01e0:
        r0 = r13.joI;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r4 = com.tencent.mm.sdk.platformtools.be.ay(r6);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r3 = r13.aTm();	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r6 = r10.value;	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        com.tencent.mm.plugin.sns.e.a.b.a(r0, r4, r3, r6);	 Catch:{ IOException -> 0x01f2, Exception -> 0x0244, all -> 0x0296 }
        r0 = r1;
        goto L_0x0114;
    L_0x01f2:
        r0 = move-exception;
        r10 = r2;
    L_0x01f4:
        r1 = r13.jow;	 Catch:{ all -> 0x02ad }
        r1 = r1.joq;	 Catch:{ all -> 0x02ad }
        if (r1 == 0) goto L_0x0206;
    L_0x01fa:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x02ad }
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r4 = 17;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ all -> 0x02ad }
    L_0x0206:
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02ad }
        r3 = "snscdndownload IOException fail : ";
        r2.<init>(r3);	 Catch:{ all -> 0x02ad }
        r3 = r0.getMessage();	 Catch:{ all -> 0x02ad }
        r2 = r2.append(r3);	 Catch:{ all -> 0x02ad }
        r2 = r2.toString();	 Catch:{ all -> 0x02ad }
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02ad }
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);	 Catch:{ all -> 0x02ad }
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02ad }
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);	 Catch:{ all -> 0x02ad }
        if (r10 == 0) goto L_0x0234;
    L_0x0231:
        r10.close();	 Catch:{ IOException -> 0x0237 }
    L_0x0234:
        r0 = r9;
        goto L_0x0114;
    L_0x0237:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = "";
        r3 = new java.lang.Object[r9];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        goto L_0x0234;
    L_0x0244:
        r0 = move-exception;
        r10 = r2;
    L_0x0246:
        r1 = r13.jow;	 Catch:{ all -> 0x02ad }
        r1 = r1.joq;	 Catch:{ all -> 0x02ad }
        if (r1 == 0) goto L_0x0258;
    L_0x024c:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ all -> 0x02ad }
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r4 = 20;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ all -> 0x02ad }
    L_0x0258:
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02ad }
        r3 = "snscdndownload Exception fail : ";
        r2.<init>(r3);	 Catch:{ all -> 0x02ad }
        r3 = r0.getMessage();	 Catch:{ all -> 0x02ad }
        r2 = r2.append(r3);	 Catch:{ all -> 0x02ad }
        r2 = r2.toString();	 Catch:{ all -> 0x02ad }
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02ad }
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);	 Catch:{ all -> 0x02ad }
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02ad }
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);	 Catch:{ all -> 0x02ad }
        if (r10 == 0) goto L_0x0286;
    L_0x0283:
        r10.close();	 Catch:{ IOException -> 0x0289 }
    L_0x0286:
        r0 = r9;
        goto L_0x0114;
    L_0x0289:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = "";
        r3 = new java.lang.Object[r9];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        goto L_0x0286;
    L_0x0296:
        r0 = move-exception;
    L_0x0297:
        if (r2 == 0) goto L_0x029c;
    L_0x0299:
        r2.close();	 Catch:{ IOException -> 0x029d }
    L_0x029c:
        throw r0;
    L_0x029d:
        r1 = move-exception;
        r2 = "MicroMsg.SnsDownloadImageBase";
        r3 = "";
        r4 = new java.lang.Object[r9];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x029c;
    L_0x02aa:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0297;
    L_0x02ad:
        r0 = move-exception;
        r2 = r10;
        goto L_0x0297;
    L_0x02b0:
        r0 = move-exception;
        r10 = r3;
        goto L_0x0246;
    L_0x02b3:
        r0 = move-exception;
        r10 = r3;
        goto L_0x01f4;
    L_0x02b7:
        r0 = r1;
        goto L_0x00f7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.e.a.e.a(java.io.InputStream, java.util.Map):boolean");
    }
}

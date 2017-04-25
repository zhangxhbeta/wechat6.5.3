package com.tencent.mm.plugin.sns.e.a;

import com.tencent.mm.as.j;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.a.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;

public final class f extends b {
    private long endTime;
    private long startTime;

    public f(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String AS(String str) {
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.InputStream r14, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r15) {
        /*
        r13 = this;
        r3 = 0;
        r1 = 1;
        r0 = 0;
        r2 = "MicroMsg.SnsDownloadSight";
        r4 = "download sight. %s ";
        r5 = new java.lang.Object[r1];
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r13.jow;
        r7 = r7.getPath();
        r6 = r6.append(r7);
        r7 = r13.jow;
        r7 = r7.aTi();
        r6 = r6.append(r7);
        r6 = r6.toString();
        r6 = com.tencent.mm.modelsfs.f.jX(r6);
        r5[r0] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r2, r4, r5);
        r4 = com.tencent.mm.sdk.platformtools.be.Ni();
        r13.startTime = r4;
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r10 = new byte[r2];	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r2.<init>();	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r4 = r13.jow;	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r4 = r4.getPath();	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r4 = r13.jow;	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r4 = r4.aTi();	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r2 = com.tencent.mm.modelsfs.f.jX(r2);	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r2 = com.tencent.mm.modelsfs.FileOp.gt(r2);	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0123 }
        r11 = new com.tencent.mm.pointers.PString;	 Catch:{ Exception -> 0x0123 }
        r11.<init>();	 Catch:{ Exception -> 0x0123 }
        r4 = r0;
        r6 = r8;
    L_0x006b:
        r5 = r14.read(r10);	 Catch:{ Exception -> 0x0123 }
        r12 = -1;
        if (r5 == r12) goto L_0x00ad;
    L_0x0072:
        r4 = com.tencent.mm.plugin.sns.e.ad.xq();	 Catch:{ Exception -> 0x0123 }
        r4 = com.tencent.mm.plugin.sns.data.i.zV(r4);	 Catch:{ Exception -> 0x0123 }
        if (r4 != 0) goto L_0x0095;
    L_0x007c:
        r2.close();	 Catch:{ Exception -> 0x0123 }
        r14.close();	 Catch:{ Exception -> 0x0123 }
        if (r2 == 0) goto L_0x0087;
    L_0x0084:
        r2.close();	 Catch:{ IOException -> 0x0088 }
    L_0x0087:
        return r0;
    L_0x0088:
        r1 = move-exception;
        r2 = "MicroMsg.SnsDownloadSight";
        r3 = "";
        r4 = new java.lang.Object[r0];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x0087;
    L_0x0095:
        r4 = 0;
        r2.write(r10, r4, r5);	 Catch:{ Exception -> 0x0123 }
        r4 = r13.joI;	 Catch:{ Exception -> 0x0123 }
        r4 = r4 + r5;
        r13.joI = r4;	 Catch:{ Exception -> 0x0123 }
        r4 = r13.joI;	 Catch:{ Exception -> 0x0123 }
        r4 = com.tencent.mm.plugin.sns.e.a.b.a(r4, r6, r11);	 Catch:{ Exception -> 0x0123 }
        if (r4 == 0) goto L_0x0125;
    L_0x00a6:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0123 }
        r6 = r4;
        r4 = r0;
        goto L_0x006b;
    L_0x00ad:
        r2.close();	 Catch:{ Exception -> 0x0123 }
        if (r4 == 0) goto L_0x00b9;
    L_0x00b2:
        r2 = r13.joI;	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r4 = 0;
        com.tencent.mm.plugin.sns.e.a.b.a(r2, r4, r11);	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
    L_0x00b9:
        r2 = r13.joI;	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r4 = com.tencent.mm.sdk.platformtools.be.ay(r8);	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r6 = 2;
        r7 = r11.value;	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        com.tencent.mm.plugin.sns.e.a.b.a(r2, r4, r6, r7);	 Catch:{ Exception -> 0x00cd, all -> 0x010c }
        r2 = com.tencent.mm.sdk.platformtools.be.Ni();
        r13.endTime = r2;
        r0 = r1;
        goto L_0x0087;
    L_0x00cd:
        r1 = move-exception;
        r2 = r3;
    L_0x00cf:
        r3 = "MicroMsg.SnsDownloadSight";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0121 }
        r5 = "snscdndownload fail : ";
        r4.<init>(r5);	 Catch:{ all -> 0x0121 }
        r5 = r1.getMessage();	 Catch:{ all -> 0x0121 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0121 }
        r4 = r4.toString();	 Catch:{ all -> 0x0121 }
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0121 }
        com.tencent.mm.sdk.platformtools.v.a(r3, r1, r4, r5);	 Catch:{ all -> 0x0121 }
        r3 = "MicroMsg.SnsDownloadSight";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0121 }
        com.tencent.mm.sdk.platformtools.v.a(r3, r1, r4, r5);	 Catch:{ all -> 0x0121 }
        if (r2 == 0) goto L_0x0087;
    L_0x00fa:
        r2.close();	 Catch:{ IOException -> 0x00fe }
        goto L_0x0087;
    L_0x00fe:
        r1 = move-exception;
        r2 = "MicroMsg.SnsDownloadSight";
        r3 = "";
        r4 = new java.lang.Object[r0];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x0087;
    L_0x010c:
        r1 = move-exception;
        r2 = r3;
    L_0x010e:
        if (r2 == 0) goto L_0x0113;
    L_0x0110:
        r2.close();	 Catch:{ IOException -> 0x0114 }
    L_0x0113:
        throw r1;
    L_0x0114:
        r2 = move-exception;
        r3 = "MicroMsg.SnsDownloadSight";
        r4 = "";
        r0 = new java.lang.Object[r0];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r0);
        goto L_0x0113;
    L_0x0121:
        r1 = move-exception;
        goto L_0x010e;
    L_0x0123:
        r1 = move-exception;
        goto L_0x00cf;
    L_0x0125:
        r4 = r1;
        goto L_0x006b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.e.a.f.a(java.io.InputStream, java.util.Map):boolean");
    }

    public final boolean aTk() {
        String i = i.i(this.boL);
        FileOp.n(this.jow.getPath(), this.jow.aTi(), i);
        ak.getNetType(aa.getContext());
        String str = this.jow.getPath() + i;
        j.KT().a("", "", 0, "", this.jow.url, this.jow.aZy, this.startTime, this.endTime, str, new String[]{this.joF});
        return true;
    }
}

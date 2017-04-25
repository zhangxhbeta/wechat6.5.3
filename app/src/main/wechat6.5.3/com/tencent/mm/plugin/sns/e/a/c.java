package com.tencent.mm.plugin.sns.e.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.a.b.a;
import com.tencent.mm.sdk.platformtools.v;

public final class c extends b {
    private long joJ = 0;
    private int joK = 0;

    public c(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String AS(String str) {
        return str;
    }

    public final boolean aTj() {
        return false;
    }

    public final t b(t tVar) {
        this.joJ = FileOp.jP(this.jow.getPath() + this.jow.aTi());
        if (this.joJ > 0) {
            v.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.joJ);
            tVar.setRequestProperty("RANGE", "bytes=" + this.joJ + "-");
        }
        return tVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.InputStream r14, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r15) {
        /*
        r13 = this;
        r1 = 0;
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r7 = new byte[r0];	 Catch:{ Exception -> 0x0117 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0117 }
        r0.<init>();	 Catch:{ Exception -> 0x0117 }
        r2 = r13.jow;	 Catch:{ Exception -> 0x0117 }
        r2 = r2.getPath();	 Catch:{ Exception -> 0x0117 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x0117 }
        r2 = r13.jow;	 Catch:{ Exception -> 0x0117 }
        r2 = r2.aTi();	 Catch:{ Exception -> 0x0117 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x0117 }
        r8 = r0.toString();	 Catch:{ Exception -> 0x0117 }
        r0 = com.tencent.mm.modelsfs.f.jX(r8);	 Catch:{ Exception -> 0x0117 }
        r2 = com.tencent.mm.modelsfs.FileOp.jP(r0);	 Catch:{ Exception -> 0x0117 }
        r0 = "MicroMsg.SnsDownloadAdSight";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0117 }
        r5 = "getdatabegin ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0117 }
        r2 = r4.append(r2);	 Catch:{ Exception -> 0x0117 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0117 }
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);	 Catch:{ Exception -> 0x0117 }
        r1 = com.tencent.mm.modelsfs.FileOp.jN(r8);	 Catch:{ Exception -> 0x0117 }
        r2 = 1;
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0117 }
        r9 = new com.tencent.mm.pointers.PString;	 Catch:{ Exception -> 0x0117 }
        r9.<init>();	 Catch:{ Exception -> 0x0117 }
        r0 = 0;
        r6 = r0;
        r0 = r2;
        r2 = r4;
    L_0x0052:
        r10 = r14.read(r7);	 Catch:{ Exception -> 0x0117 }
        r11 = -1;
        if (r10 == r11) goto L_0x00c4;
    L_0x0059:
        r6 = com.tencent.mm.plugin.sns.e.ad.xq();	 Catch:{ Exception -> 0x0117 }
        r6 = com.tencent.mm.plugin.sns.data.i.zV(r6);	 Catch:{ Exception -> 0x0117 }
        if (r6 != 0) goto L_0x0087;
    L_0x0063:
        r0 = "MicroMsg.SnsDownloadAdSight";
        r2 = "read data";
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);	 Catch:{ Exception -> 0x0117 }
        r1.close();	 Catch:{ Exception -> 0x0117 }
        r14.close();	 Catch:{ Exception -> 0x0117 }
        if (r1 == 0) goto L_0x0077;
    L_0x0074:
        r1.close();	 Catch:{ IOException -> 0x0079 }
    L_0x0077:
        r0 = 0;
    L_0x0078:
        return r0;
    L_0x0079:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadAdSight";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        goto L_0x0077;
    L_0x0087:
        r6 = 0;
        r1.write(r7, r6, r10);	 Catch:{ Exception -> 0x0117 }
        r6 = r13.joI;	 Catch:{ Exception -> 0x0117 }
        r6 = r6 + r10;
        r13.joI = r6;	 Catch:{ Exception -> 0x0117 }
        r6 = r13.joI;	 Catch:{ Exception -> 0x0117 }
        r10 = r13.joK;	 Catch:{ Exception -> 0x0117 }
        r6 = r6 - r10;
        r10 = 409600; // 0x64000 float:5.73972E-40 double:2.023693E-318;
        r10 = r10 * r0;
        if (r6 <= r10) goto L_0x00b5;
    L_0x009b:
        r6 = com.tencent.mm.plugin.sns.e.ad.aSz();	 Catch:{ Exception -> 0x0117 }
        r10 = r13.jow;	 Catch:{ Exception -> 0x0117 }
        r10 = r10.mediaId;	 Catch:{ Exception -> 0x0117 }
        r11 = com.tencent.mm.plugin.sns.e.ad.aqz();	 Catch:{ Exception -> 0x0117 }
        r12 = new com.tencent.mm.plugin.sns.e.b$3;	 Catch:{ Exception -> 0x0117 }
        r12.<init>(r6, r10, r8);	 Catch:{ Exception -> 0x0117 }
        r11.post(r12);	 Catch:{ Exception -> 0x0117 }
        r6 = r13.joI;	 Catch:{ Exception -> 0x0117 }
        r13.joK = r6;	 Catch:{ Exception -> 0x0117 }
        r0 = r0 + 1;
    L_0x00b5:
        r6 = 1;
        r10 = r13.joI;	 Catch:{ Exception -> 0x0117 }
        r10 = com.tencent.mm.plugin.sns.e.a.b.a(r10, r2, r9);	 Catch:{ Exception -> 0x0117 }
        if (r10 == 0) goto L_0x0052;
    L_0x00be:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0117 }
        r6 = 0;
        goto L_0x0052;
    L_0x00c4:
        r1.close();	 Catch:{ Exception -> 0x0117 }
        r1 = 0;
        if (r6 == 0) goto L_0x00d1;
    L_0x00ca:
        r0 = r13.joI;	 Catch:{ Exception -> 0x0117 }
        r2 = 0;
        com.tencent.mm.plugin.sns.e.a.b.a(r0, r2, r9);	 Catch:{ Exception -> 0x0117 }
    L_0x00d1:
        r0 = r13.joI;	 Catch:{ Exception -> 0x0117 }
        r2 = com.tencent.mm.sdk.platformtools.be.ay(r4);	 Catch:{ Exception -> 0x0117 }
        r4 = 4;
        r5 = r9.value;	 Catch:{ Exception -> 0x0117 }
        com.tencent.mm.plugin.sns.e.a.b.a(r0, r2, r4, r5);	 Catch:{ Exception -> 0x0117 }
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r13.jow;
        r1 = r1.getPath();
        r0 = r0.append(r1);
        r1 = r13.jow;
        r1 = r1.aTi();
        r0 = r0.append(r1);
        r0 = r0.toString();
        r0 = com.tencent.mm.modelsfs.FileOp.jP(r0);
        r2 = "MicroMsg.SnsDownloadAdSight";
        r3 = new java.lang.StringBuilder;
        r4 = "getdataend2  ";
        r3.<init>(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.v.i(r2, r0);
        r0 = 1;
        goto L_0x0078;
    L_0x0117:
        r0 = move-exception;
        r2 = "MicroMsg.SnsDownloadAdSight";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0157 }
        r4 = "snscdndownload fail : ";
        r3.<init>(r4);	 Catch:{ all -> 0x0157 }
        r4 = r0.getMessage();	 Catch:{ all -> 0x0157 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0157 }
        r3 = r3.toString();	 Catch:{ all -> 0x0157 }
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0157 }
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r3, r4);	 Catch:{ all -> 0x0157 }
        r2 = "MicroMsg.SnsDownloadAdSight";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0157 }
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r3, r4);	 Catch:{ all -> 0x0157 }
        if (r1 == 0) goto L_0x0146;
    L_0x0143:
        r1.close();	 Catch:{ IOException -> 0x0149 }
    L_0x0146:
        r0 = 0;
        goto L_0x0078;
    L_0x0149:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadAdSight";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        goto L_0x0146;
    L_0x0157:
        r0 = move-exception;
        if (r1 == 0) goto L_0x015d;
    L_0x015a:
        r1.close();	 Catch:{ IOException -> 0x015e }
    L_0x015d:
        throw r0;
    L_0x015e:
        r1 = move-exception;
        r2 = "MicroMsg.SnsDownloadAdSight";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x015d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.e.a.c.a(java.io.InputStream, java.util.Map):boolean");
    }

    public final boolean aTk() {
        long jP = FileOp.jP(this.jow.getPath() + this.jow.aTi());
        v.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + jP + " " + this.joG);
        if (jP < ((long) this.joG) + this.joJ) {
            return false;
        }
        FileOp.n(this.jow.getPath(), this.jow.aTi(), i.j(this.boL));
        return true;
    }
}

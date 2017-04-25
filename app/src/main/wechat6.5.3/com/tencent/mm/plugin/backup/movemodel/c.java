package com.tencent.mm.plugin.backup.movemodel;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class c implements f {
    boolean beg = false;
    boolean cAv = false;
    private Random ciF = new Random();
    private long ece = 0;
    private long ecf = 0;
    List<String> efQ = new LinkedList();
    HashSet<String> efR = new HashSet();
    e efT;
    boolean efU = false;
    long efV;
    long efW;
    int efX;
    long ekA = 0;
    f ekw;
    int ekx = 0;
    int eky = 0;
    int ekz = 0;
    Object lock = new Object();

    static /* synthetic */ void a(c cVar) {
        if (cVar.efU && !cVar.cAv) {
            synchronized (cVar.lock) {
                if (cVar.efR.isEmpty()) {
                    b.b(6, cVar.efT);
                    if (cVar.ekw != null) {
                        cVar.ekw.UB();
                    } else {
                        v.i("MicroMsg.BakUploadPackerMove", "operatorCallback is null");
                    }
                    cVar.cancel();
                    v.i("MicroMsg.BakUploadPackerMove", "send backup finish cmd");
                }
            }
        }
    }

    public final void cancel() {
        v.i("MicroMsg.BakUploadPackerMove", "cancel");
        this.cAv = true;
        b.b(6, this.efT);
        this.ekw = null;
        this.efU = false;
        this.efX = 0;
        this.ekz = 0;
        this.ekA = 0;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(java.lang.String r21, java.lang.String r22, int r23) {
        /*
        r20 = this;
        r5 = new com.tencent.mm.pointers.PLong;
        r5.<init>();
        r2 = java.lang.System.currentTimeMillis();
        r4 = com.tencent.mm.plugin.backup.g.b.Vd();
        r4 = r4.wJ();
        r0 = r21;
        r14 = r4.MQ(r0);
        r0 = r20;
        r4 = r0.ekx;
        r6 = (long) r4;
        r8 = java.lang.System.currentTimeMillis();
        r2 = r8 - r2;
        r2 = r2 + r6;
        r2 = (int) r2;
        r0 = r20;
        r0.ekx = r2;
        r9 = new java.util.LinkedList;
        r9.<init>();
        r6 = new java.util.LinkedList;
        r6.<init>();
        r2 = r14.moveToFirst();	 Catch:{ all -> 0x0092 }
        if (r2 == 0) goto L_0x01e2;
    L_0x0038:
        r13 = r9;
        r9 = r23;
    L_0x003b:
        r2 = r14.isAfterLast();	 Catch:{ all -> 0x0092 }
        if (r2 != 0) goto L_0x01e1;
    L_0x0041:
        r0 = r20;
        r3 = r0.lock;	 Catch:{ all -> 0x0092 }
        monitor-enter(r3);	 Catch:{ all -> 0x0092 }
        r0 = r20;
        r2 = r0.efR;	 Catch:{ all -> 0x008f }
        r2 = r2.size();	 Catch:{ all -> 0x008f }
        r4 = 8;
        if (r2 <= r4) goto L_0x0059;
    L_0x0052:
        r0 = r20;
        r2 = r0.lock;	 Catch:{ InterruptedException -> 0x024b }
        r2.wait();	 Catch:{ InterruptedException -> 0x024b }
    L_0x0059:
        r0 = r20;
        r2 = r0.beg;	 Catch:{ all -> 0x008f }
        if (r2 == 0) goto L_0x006c;
    L_0x005f:
        r0 = r20;
        r2 = r0.cAv;	 Catch:{ all -> 0x008f }
        if (r2 != 0) goto L_0x006c;
    L_0x0065:
        r0 = r20;
        r2 = r0.lock;	 Catch:{ InterruptedException -> 0x0081 }
        r2.wait();	 Catch:{ InterruptedException -> 0x0081 }
    L_0x006c:
        r0 = r20;
        r2 = r0.cAv;	 Catch:{ all -> 0x008f }
        if (r2 == 0) goto L_0x0097;
    L_0x0072:
        r2 = "MicroMsg.BakUploadPackerMove";
        r4 = "backupImp cancel";
        com.tencent.mm.sdk.platformtools.v.i(r2, r4);	 Catch:{ all -> 0x008f }
        monitor-exit(r3);	 Catch:{ all -> 0x008f }
        r14.close();
        r2 = 0;
    L_0x0080:
        return r2;
    L_0x0081:
        r2 = move-exception;
        r4 = "MicroMsg.BakUploadPackerMove";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x008f }
        com.tencent.mm.sdk.platformtools.v.a(r4, r2, r7, r8);	 Catch:{ all -> 0x008f }
        goto L_0x006c;
    L_0x008f:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x008f }
        throw r2;	 Catch:{ all -> 0x0092 }
    L_0x0092:
        r2 = move-exception;
        r14.close();
        throw r2;
    L_0x0097:
        monitor-exit(r3);	 Catch:{ all -> 0x008f }
        r2 = new com.tencent.mm.storage.at;	 Catch:{ all -> 0x0092 }
        r2.<init>();	 Catch:{ all -> 0x0092 }
        r2.b(r14);	 Catch:{ all -> 0x0092 }
        r8 = 0;
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0137 }
        r3 = 0;
        if (r9 <= 0) goto L_0x0134;
    L_0x00a8:
        r7 = 1;
    L_0x00a9:
        r4 = r22;
        r3 = com.tencent.mm.plugin.backup.g.d.a(r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0137 }
        r0 = r20;
        r2 = r0.eky;	 Catch:{ Exception -> 0x0248 }
        r0 = (long) r2;	 Catch:{ Exception -> 0x0248 }
        r16 = r0;
        r18 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0248 }
        r10 = r18 - r10;
        r10 = r10 + r16;
        r2 = (int) r10;	 Catch:{ Exception -> 0x0248 }
        r0 = r20;
        r0.eky = r2;	 Catch:{ Exception -> 0x0248 }
        r2 = r9 + -1;
        r4 = r2;
    L_0x00c6:
        if (r3 == 0) goto L_0x00cb;
    L_0x00c8:
        r13.add(r3);	 Catch:{ all -> 0x0092 }
    L_0x00cb:
        r0 = r20;
        r2 = r0.ekz;	 Catch:{ all -> 0x0092 }
        r3 = r6.size();	 Catch:{ all -> 0x0092 }
        r2 = r2 + r3;
        r0 = r20;
        r0.ekz = r2;	 Catch:{ all -> 0x0092 }
        r3 = r6.iterator();	 Catch:{ all -> 0x0092 }
    L_0x00dc:
        r2 = r3.hasNext();	 Catch:{ all -> 0x0092 }
        if (r2 == 0) goto L_0x015e;
    L_0x00e2:
        r2 = r3.next();	 Catch:{ all -> 0x0092 }
        r2 = (com.tencent.mm.plugin.backup.f.g) r2;	 Catch:{ all -> 0x0092 }
        r7 = new com.tencent.mm.plugin.backup.movemodel.k;	 Catch:{ all -> 0x0092 }
        r8 = r2.mediaId;	 Catch:{ all -> 0x0092 }
        r9 = 2;
        r10 = 0;
        r11 = r2.path;	 Catch:{ all -> 0x0092 }
        r12 = r20;
        r7.<init>(r8, r9, r10, r11, r12);	 Catch:{ all -> 0x0092 }
        r0 = r20;
        r8 = r0.ekA;	 Catch:{ all -> 0x0092 }
        r10 = r7.eda;	 Catch:{ all -> 0x0092 }
        r10 = r10.efq;	 Catch:{ all -> 0x0092 }
        r10 = (long) r10;	 Catch:{ all -> 0x0092 }
        r8 = r8 + r10;
        r0 = r20;
        r0.ekA = r8;	 Catch:{ all -> 0x0092 }
        r0 = r20;
        r8 = r0.lock;	 Catch:{ all -> 0x0092 }
        monitor-enter(r8);	 Catch:{ all -> 0x0092 }
        r7.Uh();	 Catch:{ all -> 0x0131 }
        r0 = r20;
        r7 = r0.efR;	 Catch:{ all -> 0x0131 }
        r2 = r2.mediaId;	 Catch:{ all -> 0x0131 }
        r7.add(r2);	 Catch:{ all -> 0x0131 }
        r2 = "MicroMsg.BakUploadPackerMove";
        r7 = "backupChatMsg now: size:%d";
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x0131 }
        r10 = 0;
        r0 = r20;
        r11 = r0.efR;	 Catch:{ all -> 0x0131 }
        r11 = r11.size();	 Catch:{ all -> 0x0131 }
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x0131 }
        r9[r10] = r11;	 Catch:{ all -> 0x0131 }
        com.tencent.mm.sdk.platformtools.v.i(r2, r7, r9);	 Catch:{ all -> 0x0131 }
        monitor-exit(r8);	 Catch:{ all -> 0x0131 }
        goto L_0x00dc;
    L_0x0131:
        r2 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0131 }
        throw r2;	 Catch:{ all -> 0x0092 }
    L_0x0134:
        r7 = 0;
        goto L_0x00a9;
    L_0x0137:
        r2 = move-exception;
        r3 = r8;
    L_0x0139:
        r4 = "MicroMsg.BakUploadPackerMove";
        r7 = "";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x0092 }
        com.tencent.mm.sdk.platformtools.v.a(r4, r2, r7, r8);	 Catch:{ all -> 0x0092 }
        r4 = "MicroMsg.BakUploadPackerMove";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0092 }
        r8 = "backupChatMsg %s";
        r7.<init>(r8);	 Catch:{ all -> 0x0092 }
        r2 = r7.append(r2);	 Catch:{ all -> 0x0092 }
        r2 = r2.toString();	 Catch:{ all -> 0x0092 }
        com.tencent.mm.sdk.platformtools.v.f(r4, r2);	 Catch:{ all -> 0x0092 }
        r4 = r9;
        goto L_0x00c6;
    L_0x015e:
        r6.clear();	 Catch:{ all -> 0x0092 }
        r2 = r5.value;	 Catch:{ all -> 0x0092 }
        r8 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x01d8;
    L_0x016a:
        r2 = "MicroMsg.BakUploadPackerMove";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0092 }
        r7 = "limitSize ";
        r3.<init>(r7);	 Catch:{ all -> 0x0092 }
        r8 = r5.value;	 Catch:{ all -> 0x0092 }
        r3 = r3.append(r8);	 Catch:{ all -> 0x0092 }
        r3 = r3.toString();	 Catch:{ all -> 0x0092 }
        com.tencent.mm.sdk.platformtools.v.d(r2, r3);	 Catch:{ all -> 0x0092 }
        r0 = r20;
        r2 = r0.ciF;	 Catch:{ all -> 0x0092 }
        r8 = a(r2);	 Catch:{ all -> 0x0092 }
        r7 = new com.tencent.mm.plugin.backup.movemodel.k;	 Catch:{ all -> 0x0092 }
        r9 = 1;
        r11 = "";
        r10 = r13;
        r12 = r20;
        r7.<init>(r8, r9, r10, r11, r12);	 Catch:{ all -> 0x0092 }
        r0 = r20;
        r2 = r0.ekA;	 Catch:{ all -> 0x0092 }
        r9 = r7.eda;	 Catch:{ all -> 0x0092 }
        r9 = r9.efq;	 Catch:{ all -> 0x0092 }
        r10 = (long) r9;	 Catch:{ all -> 0x0092 }
        r2 = r2 + r10;
        r0 = r20;
        r0.ekA = r2;	 Catch:{ all -> 0x0092 }
        r0 = r20;
        r3 = r0.lock;	 Catch:{ all -> 0x0092 }
        monitor-enter(r3);	 Catch:{ all -> 0x0092 }
        r7.Uh();	 Catch:{ all -> 0x01de }
        r0 = r20;
        r2 = r0.efR;	 Catch:{ all -> 0x01de }
        r2.add(r8);	 Catch:{ all -> 0x01de }
        r2 = "MicroMsg.BakUploadPackerMove";
        r7 = "backupChatMsg now: size:%d";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x01de }
        r9 = 0;
        r0 = r20;
        r10 = r0.efR;	 Catch:{ all -> 0x01de }
        r10 = r10.size();	 Catch:{ all -> 0x01de }
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x01de }
        r8[r9] = r10;	 Catch:{ all -> 0x01de }
        com.tencent.mm.sdk.platformtools.v.i(r2, r7, r8);	 Catch:{ all -> 0x01de }
        monitor-exit(r3);	 Catch:{ all -> 0x01de }
        r13 = new java.util.LinkedList;	 Catch:{ all -> 0x0092 }
        r13.<init>();	 Catch:{ all -> 0x0092 }
        r2 = 0;
        r5.value = r2;	 Catch:{ all -> 0x0092 }
    L_0x01d8:
        r14.moveToNext();	 Catch:{ all -> 0x0092 }
        r9 = r4;
        goto L_0x003b;
    L_0x01de:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x01de }
        throw r2;	 Catch:{ all -> 0x0092 }
    L_0x01e1:
        r9 = r13;
    L_0x01e2:
        r2 = r5.value;	 Catch:{ all -> 0x0092 }
        r6 = 0;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x023f;
    L_0x01ea:
        r0 = r20;
        r2 = r0.ciF;	 Catch:{ all -> 0x0092 }
        r7 = a(r2);	 Catch:{ all -> 0x0092 }
        r6 = new com.tencent.mm.plugin.backup.movemodel.k;	 Catch:{ all -> 0x0092 }
        r8 = 1;
        r10 = "";
        r11 = r20;
        r6.<init>(r7, r8, r9, r10, r11);	 Catch:{ all -> 0x0092 }
        r0 = r20;
        r2 = r0.ekA;	 Catch:{ all -> 0x0092 }
        r4 = r6.eda;	 Catch:{ all -> 0x0092 }
        r4 = r4.efq;	 Catch:{ all -> 0x0092 }
        r8 = (long) r4;	 Catch:{ all -> 0x0092 }
        r2 = r2 + r8;
        r0 = r20;
        r0.ekA = r2;	 Catch:{ all -> 0x0092 }
        r0 = r20;
        r3 = r0.lock;	 Catch:{ all -> 0x0092 }
        monitor-enter(r3);	 Catch:{ all -> 0x0092 }
        r6.Uh();	 Catch:{ all -> 0x0245 }
        r0 = r20;
        r2 = r0.efR;	 Catch:{ all -> 0x0245 }
        r2.add(r7);	 Catch:{ all -> 0x0245 }
        r2 = "MicroMsg.BakUploadPackerMove";
        r4 = "backupChatMsg now: size:%d";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0245 }
        r7 = 0;
        r0 = r20;
        r8 = r0.efR;	 Catch:{ all -> 0x0245 }
        r8 = r8.size();	 Catch:{ all -> 0x0245 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0245 }
        r6[r7] = r8;	 Catch:{ all -> 0x0245 }
        com.tencent.mm.sdk.platformtools.v.i(r2, r4, r6);	 Catch:{ all -> 0x0245 }
        monitor-exit(r3);	 Catch:{ all -> 0x0245 }
        r2 = 0;
        r5.value = r2;	 Catch:{ all -> 0x0092 }
        r2 = new java.util.LinkedList;	 Catch:{ all -> 0x0092 }
        r2.<init>();	 Catch:{ all -> 0x0092 }
    L_0x023f:
        r14.close();
        r2 = 1;
        goto L_0x0080;
    L_0x0245:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0245 }
        throw r2;	 Catch:{ all -> 0x0092 }
    L_0x0248:
        r2 = move-exception;
        goto L_0x0139;
    L_0x024b:
        r2 = move-exception;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.movemodel.c.j(java.lang.String, java.lang.String, int):boolean");
    }

    private static String a(Random random) {
        return g.m((be.Nj() + random.nextDouble()).getBytes());
    }

    public final void a(int i, int i2, k kVar) {
        this.efW += (long) i;
        int i3 = this.efV == 0 ? 0 : (int) ((this.efW * 100) / this.efV);
        if (i3 > this.efX) {
            this.efX = i3;
            com.tencent.mm.plugin.backup.e.b.setProgress(this.efX);
        }
        if (this.ece == 0 || be.az(this.ece) >= 100) {
            this.ece = be.Nj();
            if (this.ecf == 0) {
                this.ecf = be.Nj();
            }
            if (this.efW > this.efV) {
                this.efW = this.efV;
            }
            if (this.efW == 0) {
                this.efW = 1;
            }
            int i4 = ((int) (((this.ece - this.ecf) * (this.efV - this.efW)) / this.efW)) / 1000;
            if (!this.beg && !this.cAv && this.ekw != null && this.efX >= 0 && this.efX <= 100) {
                this.ekw.b(this.efW, this.efV, i4);
            }
        }
    }
}

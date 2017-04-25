package com.tencent.mm.plugin.backup.bakpcmodel;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.backup.bakpcmodel.c.d;
import com.tencent.mm.plugin.backup.e.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class b implements f {
    private boolean beg = false;
    private boolean cAv = false;
    private Random ciF = new Random();
    List<String> efQ = new LinkedList();
    HashSet<String> efR = new HashSet();
    d efS;
    e efT;
    boolean efU = false;
    private long efV;
    private long efW;
    int efX;
    int efY = 0;
    Object lock = new Object();

    public final void pause() {
        v.i("MicroMsg.BakPCServer", "pause");
        this.beg = true;
    }

    public final void resume() {
        v.i("MicroMsg.BakPCServer", "resume");
        this.beg = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public final void cancel() {
        v.i("MicroMsg.BakPCServer", "cancel");
        this.cAv = true;
        com.tencent.mm.plugin.backup.b.b.b(5, this.efT);
        this.efS = null;
        this.efU = false;
        this.efX = 0;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(java.lang.String r14, java.lang.String r15, int r16) {
        /*
        r13 = this;
        r3 = new com.tencent.mm.pointers.PLong;
        r3.<init>();
        r0 = com.tencent.mm.plugin.backup.g.b.Vd();
        r0 = r0.wJ();
        r12 = r0.MQ(r14);
        r7 = new java.util.LinkedList;
        r7.<init>();
        r4 = new java.util.LinkedList;
        r4.<init>();
        r0 = r12.moveToFirst();	 Catch:{ all -> 0x006d }
        if (r0 == 0) goto L_0x0168;
    L_0x0021:
        r11 = r7;
        r7 = r16;
    L_0x0024:
        r0 = r12.isAfterLast();	 Catch:{ all -> 0x006d }
        if (r0 != 0) goto L_0x0167;
    L_0x002a:
        r1 = r13.lock;	 Catch:{ all -> 0x006d }
        monitor-enter(r1);	 Catch:{ all -> 0x006d }
        r0 = r13.efR;	 Catch:{ all -> 0x006a }
        r0 = r0.size();	 Catch:{ all -> 0x006a }
        r2 = 10;
        if (r0 <= r2) goto L_0x003c;
    L_0x0037:
        r0 = r13.lock;	 Catch:{ InterruptedException -> 0x01b7 }
        r0.wait();	 Catch:{ InterruptedException -> 0x01b7 }
    L_0x003c:
        r0 = r13.beg;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0049;
    L_0x0040:
        r0 = r13.cAv;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0049;
    L_0x0044:
        r0 = r13.lock;	 Catch:{ InterruptedException -> 0x005c }
        r0.wait();	 Catch:{ InterruptedException -> 0x005c }
    L_0x0049:
        r0 = r13.cAv;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0072;
    L_0x004d:
        r0 = "MicroMsg.BakPCServer";
        r2 = "backupImp cancel";
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);	 Catch:{ all -> 0x006a }
        monitor-exit(r1);	 Catch:{ all -> 0x006a }
        r12.close();
        r0 = 0;
    L_0x005b:
        return r0;
    L_0x005c:
        r0 = move-exception;
        r2 = "MicroMsg.BakPCServer";
        r5 = "";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x006a }
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r5, r6);	 Catch:{ all -> 0x006a }
        goto L_0x0049;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x006a }
        throw r0;	 Catch:{ all -> 0x006d }
    L_0x006d:
        r0 = move-exception;
        r12.close();
        throw r0;
    L_0x0072:
        monitor-exit(r1);	 Catch:{ all -> 0x006a }
        r0 = new com.tencent.mm.storage.at;	 Catch:{ all -> 0x006d }
        r0.<init>();	 Catch:{ all -> 0x006d }
        r0.b(r12);	 Catch:{ all -> 0x006d }
        r6 = 0;
        r1 = 0;
        if (r7 <= 0) goto L_0x00d3;
    L_0x007f:
        r5 = 1;
    L_0x0080:
        r2 = r15;
        r0 = com.tencent.mm.plugin.backup.g.d.a(r0, r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x00d5 }
        r1 = r7 + -1;
    L_0x0087:
        if (r0 == 0) goto L_0x008c;
    L_0x0089:
        r11.add(r0);	 Catch:{ all -> 0x006d }
    L_0x008c:
        r2 = r4.iterator();	 Catch:{ all -> 0x006d }
    L_0x0090:
        r0 = r2.hasNext();	 Catch:{ all -> 0x006d }
        if (r0 == 0) goto L_0x00fb;
    L_0x0096:
        r0 = r2.next();	 Catch:{ all -> 0x006d }
        r0 = (com.tencent.mm.plugin.backup.f.g) r0;	 Catch:{ all -> 0x006d }
        r5 = new com.tencent.mm.plugin.backup.e.b;	 Catch:{ all -> 0x006d }
        r6 = r0.mediaId;	 Catch:{ all -> 0x006d }
        r7 = 2;
        r8 = 0;
        r9 = r0.path;	 Catch:{ all -> 0x006d }
        r10 = r13;
        r5.<init>(r6, r7, r8, r9, r10);	 Catch:{ all -> 0x006d }
        r6 = r13.lock;	 Catch:{ all -> 0x006d }
        monitor-enter(r6);	 Catch:{ all -> 0x006d }
        r5.Uh();	 Catch:{ all -> 0x00d0 }
        r5 = r13.efR;	 Catch:{ all -> 0x00d0 }
        r0 = r0.mediaId;	 Catch:{ all -> 0x00d0 }
        r5.add(r0);	 Catch:{ all -> 0x00d0 }
        r0 = "MicroMsg.BakPCServer";
        r5 = "backupChatMsg now: size:%d";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x00d0 }
        r8 = 0;
        r9 = r13.efR;	 Catch:{ all -> 0x00d0 }
        r9 = r9.size();	 Catch:{ all -> 0x00d0 }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x00d0 }
        r7[r8] = r9;	 Catch:{ all -> 0x00d0 }
        com.tencent.mm.sdk.platformtools.v.i(r0, r5, r7);	 Catch:{ all -> 0x00d0 }
        monitor-exit(r6);	 Catch:{ all -> 0x00d0 }
        goto L_0x0090;
    L_0x00d0:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x00d0 }
        throw r0;	 Catch:{ all -> 0x006d }
    L_0x00d3:
        r5 = 0;
        goto L_0x0080;
    L_0x00d5:
        r0 = move-exception;
        r1 = "MicroMsg.BakPCServer";
        r2 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x006d }
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r5);	 Catch:{ all -> 0x006d }
        r1 = "MicroMsg.BakPCServer";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006d }
        r5 = "backupChatMsg %s";
        r2.<init>(r5);	 Catch:{ all -> 0x006d }
        r0 = r2.append(r0);	 Catch:{ all -> 0x006d }
        r0 = r0.toString();	 Catch:{ all -> 0x006d }
        com.tencent.mm.sdk.platformtools.v.f(r1, r0);	 Catch:{ all -> 0x006d }
        r0 = r6;
        r1 = r7;
        goto L_0x0087;
    L_0x00fb:
        r4.clear();	 Catch:{ all -> 0x006d }
        r6 = r3.value;	 Catch:{ all -> 0x006d }
        r8 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x015e;
    L_0x0107:
        r0 = "MicroMsg.BakPCServer";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006d }
        r5 = "limitSize ";
        r2.<init>(r5);	 Catch:{ all -> 0x006d }
        r6 = r3.value;	 Catch:{ all -> 0x006d }
        r2 = r2.append(r6);	 Catch:{ all -> 0x006d }
        r2 = r2.toString();	 Catch:{ all -> 0x006d }
        com.tencent.mm.sdk.platformtools.v.d(r0, r2);	 Catch:{ all -> 0x006d }
        r0 = r13.ciF;	 Catch:{ all -> 0x006d }
        r6 = a(r0);	 Catch:{ all -> 0x006d }
        r5 = new com.tencent.mm.plugin.backup.e.b;	 Catch:{ all -> 0x006d }
        r7 = 1;
        r9 = "";
        r8 = r11;
        r10 = r13;
        r5.<init>(r6, r7, r8, r9, r10);	 Catch:{ all -> 0x006d }
        r2 = r13.lock;	 Catch:{ all -> 0x006d }
        monitor-enter(r2);	 Catch:{ all -> 0x006d }
        r5.Uh();	 Catch:{ all -> 0x0164 }
        r0 = r13.efR;	 Catch:{ all -> 0x0164 }
        r0.add(r6);	 Catch:{ all -> 0x0164 }
        r0 = "MicroMsg.BakPCServer";
        r5 = "backupChatMsg now: size:%d";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0164 }
        r7 = 0;
        r8 = r13.efR;	 Catch:{ all -> 0x0164 }
        r8 = r8.size();	 Catch:{ all -> 0x0164 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0164 }
        r6[r7] = r8;	 Catch:{ all -> 0x0164 }
        com.tencent.mm.sdk.platformtools.v.i(r0, r5, r6);	 Catch:{ all -> 0x0164 }
        monitor-exit(r2);	 Catch:{ all -> 0x0164 }
        r11 = new java.util.LinkedList;	 Catch:{ all -> 0x006d }
        r11.<init>();	 Catch:{ all -> 0x006d }
        r6 = 0;
        r3.value = r6;	 Catch:{ all -> 0x006d }
    L_0x015e:
        r12.moveToNext();	 Catch:{ all -> 0x006d }
        r7 = r1;
        goto L_0x0024;
    L_0x0164:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0164 }
        throw r0;	 Catch:{ all -> 0x006d }
    L_0x0167:
        r7 = r11;
    L_0x0168:
        r0 = r3.value;	 Catch:{ all -> 0x006d }
        r4 = 0;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x01ae;
    L_0x0170:
        r0 = r13.ciF;	 Catch:{ all -> 0x006d }
        r5 = a(r0);	 Catch:{ all -> 0x006d }
        r4 = new com.tencent.mm.plugin.backup.e.b;	 Catch:{ all -> 0x006d }
        r6 = 1;
        r8 = "";
        r9 = r13;
        r4.<init>(r5, r6, r7, r8, r9);	 Catch:{ all -> 0x006d }
        r1 = r13.lock;	 Catch:{ all -> 0x006d }
        monitor-enter(r1);	 Catch:{ all -> 0x006d }
        r4.Uh();	 Catch:{ all -> 0x01b4 }
        r0 = r13.efR;	 Catch:{ all -> 0x01b4 }
        r0.add(r5);	 Catch:{ all -> 0x01b4 }
        r0 = "MicroMsg.BakPCServer";
        r2 = "backupChatMsg now: size:%d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x01b4 }
        r5 = 0;
        r6 = r13.efR;	 Catch:{ all -> 0x01b4 }
        r6 = r6.size();	 Catch:{ all -> 0x01b4 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x01b4 }
        r4[r5] = r6;	 Catch:{ all -> 0x01b4 }
        com.tencent.mm.sdk.platformtools.v.i(r0, r2, r4);	 Catch:{ all -> 0x01b4 }
        monitor-exit(r1);	 Catch:{ all -> 0x01b4 }
        r0 = 0;
        r3.value = r0;	 Catch:{ all -> 0x006d }
        r0 = new java.util.LinkedList;	 Catch:{ all -> 0x006d }
        r0.<init>();	 Catch:{ all -> 0x006d }
    L_0x01ae:
        r12.close();
        r0 = 1;
        goto L_0x005b;
    L_0x01b4:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01b4 }
        throw r0;	 Catch:{ all -> 0x006d }
    L_0x01b7:
        r0 = move-exception;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakpcmodel.b.j(java.lang.String, java.lang.String, int):boolean");
    }

    final void Uu() {
        if (this.efU && !this.cAv) {
            synchronized (this.lock) {
                if (this.efR.isEmpty()) {
                    com.tencent.mm.plugin.backup.g.b.UK().egj = d.egD;
                    com.tencent.mm.plugin.backup.g.b.UK().egk = d.egt;
                    com.tencent.mm.plugin.backup.b.b.b(5, this.efT);
                    new a(5).Uh();
                    a UO = com.tencent.mm.plugin.backup.g.b.UO();
                    UO.efM++;
                    if (this.efS != null) {
                        this.efS.UB();
                    } else {
                        v.i("MicroMsg.BakPCServer", "operatorCallback is null");
                    }
                    cancel();
                    v.i("MicroMsg.BakPCServer", "send backup finish cmd");
                }
            }
        }
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
            if (!this.beg && !this.cAv && this.efS != null && this.efX >= 0 && this.efX <= 100) {
                this.efS.ic(this.efX);
            }
        }
    }
}

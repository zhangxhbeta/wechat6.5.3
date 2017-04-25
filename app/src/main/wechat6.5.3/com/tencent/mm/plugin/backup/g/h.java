package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.backup.f.c;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.List;

public final class h {
    private c ejq;
    private long ejr = 0;
    boolean ejs;
    final String path = (b.Vj() + "bakchatDownload.info");

    public h() {
        if (this.ejq != null) {
            return;
        }
        if (e.aR(this.path)) {
            try {
                this.ejq = (c) new c().az(e.d(this.path, 0, -1));
                this.ejq.ehv = 0;
                return;
            } catch (Throwable e) {
                v.a("MicroMsg.BckDownloadInfoMgr", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                this.ejq = new c();
                this.ejq.ehq = 1;
                return;
            }
        }
        this.ejq = new c();
        this.ejq.ehq = 1;
    }

    public final synchronized int VB() {
        return this.ejq.eho;
    }

    public final synchronized String VC() {
        return this.ejq.ehp;
    }

    public final synchronized int VD() {
        return this.ejq.ehq;
    }

    public final synchronized void ih(int i) {
        this.ejq.ehq = i;
        bT(true);
    }

    public final synchronized int VE() {
        return this.ejq.ehr;
    }

    public final synchronized void ii(int i) {
        this.ejq.ehr = i;
        bT(false);
    }

    public final synchronized void pg(String str) {
        this.ejq.ehs.add(str);
        bT(false);
    }

    public final synchronized void ph(String str) {
        this.ejq.ehs.remove(str);
        bT(false);
    }

    public final synchronized List<String> VF() {
        return this.ejq.ehs;
    }

    public final synchronized void pi(String str) {
        this.ejq.eht.add(str);
        bT(false);
    }

    public final synchronized List<String> VG() {
        return this.ejq.eht;
    }

    public final synchronized int getItemCount() {
        int i;
        Iterator it = this.ejq.eht.iterator();
        i = 0;
        while (it.hasNext()) {
            try {
                i = ((dy) new dy().az(e.d((String) it.next(), 0, -1))).eeu.size() + i;
            } catch (Throwable e) {
                v.a("MicroMsg.BckDownloadInfoMgr", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return i;
    }

    public final synchronized void ij(int i) {
        this.ejq.ehu = i;
        bT(false);
    }

    public final synchronized int VH() {
        return this.ejq.ehu;
    }

    public final synchronized int VI() {
        return this.ejq.eha;
    }

    public final synchronized boolean VJ() {
        return this.ejq.ehv == 0;
    }

    public final synchronized void bS(boolean z) {
        int i = 1;
        synchronized (this) {
            c cVar = this.ejq;
            if (z) {
                i = 0;
            }
            cVar.ehv = i;
            if (z) {
                bT(true);
            }
        }
    }

    public final synchronized void reset() {
        b.deleteFile(this.path);
        this.ejq = new c();
        this.ejq.ehq = 1;
        this.ejs = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean bT(boolean r7) {
        /*
        r6 = this;
        r1 = 1;
        r0 = 0;
        r2 = r6.ejq;
        r2 = r2.eho;
        if (r2 != 0) goto L_0x000e;
    L_0x0008:
        r1 = r6.path;
        com.tencent.mm.loader.stub.b.deleteFile(r1);
    L_0x000d:
        return r0;
    L_0x000e:
        if (r7 != 0) goto L_0x0027;
    L_0x0010:
        r2 = r6.ejr;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0024;
    L_0x0018:
        r2 = r6.ejr;
        r2 = com.tencent.mm.sdk.platformtools.be.az(r2);
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0044;
    L_0x0024:
        r2 = r1;
    L_0x0025:
        if (r2 == 0) goto L_0x0042;
    L_0x0027:
        r2 = com.tencent.mm.sdk.platformtools.be.Nj();	 Catch:{ Exception -> 0x0046 }
        r6.ejr = r2;	 Catch:{ Exception -> 0x0046 }
        r2 = r6.ejq;	 Catch:{ Exception -> 0x0046 }
        r2 = r2.toByteArray();	 Catch:{ Exception -> 0x0046 }
        r3 = 0;
        r6.ejs = r3;	 Catch:{ Exception -> 0x0046 }
        r3 = com.tencent.mm.model.ak.vA();	 Catch:{ Exception -> 0x0046 }
        r4 = new com.tencent.mm.plugin.backup.g.h$1;	 Catch:{ Exception -> 0x0046 }
        r4.<init>(r6, r2);	 Catch:{ Exception -> 0x0046 }
        r3.x(r4);	 Catch:{ Exception -> 0x0046 }
    L_0x0042:
        r0 = r1;
        goto L_0x000d;
    L_0x0044:
        r2 = r0;
        goto L_0x0025;
    L_0x0046:
        r1 = move-exception;
        r2 = "MicroMsg.BckDownloadInfoMgr";
        r3 = "";
        r4 = new java.lang.Object[r0];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.g.h.bT(boolean):boolean");
    }
}

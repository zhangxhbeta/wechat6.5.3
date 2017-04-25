package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.backup.f.d;
import com.tencent.mm.plugin.backup.f.e;
import com.tencent.mm.plugin.backup.f.g;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;

public final class i {
    private long ejr = 0;
    boolean ejs;
    private e eju;
    final String path = (b.Vj() + "bakchatUpload.info");

    public i() {
        v.i("MicroMsg.BckUploadInfoMgr", "init path %s", this.path);
        VU();
    }

    public final synchronized int VB() {
        return this.eju.eho;
    }

    public final synchronized String VC() {
        return this.eju.ehp;
    }

    public final synchronized void ik(int i) {
        this.eju.eho = i;
        bT(true);
    }

    public final synchronized int VD() {
        return this.eju.ehq;
    }

    public final synchronized void ih(int i) {
        this.eju.ehq = i;
        bT(true);
    }

    public final synchronized void a(g gVar) {
        this.eju.ehA.add(gVar);
        bT(false);
    }

    public final synchronized void pj(String str) {
        Iterator it = this.eju.ehA.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (str.equals(gVar.mediaId)) {
                this.eju.ehA.remove(gVar);
                break;
            }
        }
        bT(false);
    }

    public final synchronized void aH(long j) {
        Iterator it;
        Object obj;
        do {
            it = this.eju.ehA.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (gVar.ehN == j) {
                    this.eju.ehA.remove(gVar);
                    obj = 1;
                    continue;
                    break;
                }
            }
            obj = null;
            continue;
        } while (obj != null);
        it = this.eju.ehz.iterator();
        loop2:
        while (it.hasNext()) {
            d dVar = (d) it.next();
            Iterator it2 = dVar.ehx.iterator();
            while (it2.hasNext()) {
                dx dxVar = (dx) it2.next();
                if (dxVar.mcb == j) {
                    dVar.ehx.remove(dxVar);
                    bT(false);
                    break loop2;
                }
            }
        }
        bT(false);
    }

    public final synchronized LinkedList<g> VK() {
        return this.eju.ehA;
    }

    public final synchronized void a(d dVar) {
        this.eju.ehz.add(dVar);
        bT(false);
    }

    public final synchronized void pk(String str) {
        Iterator it = this.eju.ehz.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.bNv)) {
                this.eju.ehz.remove(dVar);
                break;
            }
        }
        bT(false);
    }

    public final synchronized LinkedList<d> VL() {
        return this.eju.ehz;
    }

    public final synchronized int VM() {
        return this.eju.ehz.size() + this.eju.ehA.size();
    }

    public final synchronized LinkedList<String> VN() {
        return this.eju.ehB;
    }

    public final synchronized void n(String str, long j) {
        this.eju.ehC = str;
        this.eju.ehH = j;
        bT(false);
    }

    public final synchronized String VO() {
        return this.eju.ehC;
    }

    public final synchronized long VP() {
        return this.eju.ehH;
    }

    public final synchronized void bm(int i, int i2) {
        this.eju.ehE = i;
        this.eju.eha = i2;
        bT(false);
    }

    public final synchronized int VQ() {
        return this.eju.ehE;
    }

    public final synchronized boolean VJ() {
        return this.eju.ehv == 0;
    }

    public final synchronized void VR() {
        this.eju.ehv = 0;
        bT(true);
    }

    public final synchronized boolean VS() {
        return this.eju.ehF != 0;
    }

    public final synchronized int VT() {
        return this.eju.ehG;
    }

    public final synchronized void reset() {
        this.eju = new e();
        b.deleteFile(this.path);
        this.ejs = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean bT(boolean r7) {
        /*
        r6 = this;
        r1 = 1;
        r0 = 0;
        r2 = r6.eju;
        r2 = r2.ehB;
        r2 = r2.isEmpty();
        if (r2 == 0) goto L_0x0012;
    L_0x000c:
        r1 = r6.path;
        com.tencent.mm.loader.stub.b.deleteFile(r1);
    L_0x0011:
        return r0;
    L_0x0012:
        if (r7 != 0) goto L_0x002b;
    L_0x0014:
        r2 = r6.ejr;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0028;
    L_0x001c:
        r2 = r6.ejr;
        r2 = com.tencent.mm.sdk.platformtools.be.az(r2);
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0048;
    L_0x0028:
        r2 = r1;
    L_0x0029:
        if (r2 == 0) goto L_0x0046;
    L_0x002b:
        r2 = com.tencent.mm.sdk.platformtools.be.Nj();	 Catch:{ Exception -> 0x004a }
        r6.ejr = r2;	 Catch:{ Exception -> 0x004a }
        r2 = r6.eju;	 Catch:{ Exception -> 0x004a }
        r2 = r2.toByteArray();	 Catch:{ Exception -> 0x004a }
        r3 = 0;
        r6.ejs = r3;	 Catch:{ Exception -> 0x004a }
        r3 = com.tencent.mm.model.ak.vA();	 Catch:{ Exception -> 0x004a }
        r4 = new com.tencent.mm.plugin.backup.g.i$1;	 Catch:{ Exception -> 0x004a }
        r4.<init>(r6, r2);	 Catch:{ Exception -> 0x004a }
        r3.x(r4);	 Catch:{ Exception -> 0x004a }
    L_0x0046:
        r0 = r1;
        goto L_0x0011;
    L_0x0048:
        r2 = r0;
        goto L_0x0029;
    L_0x004a:
        r1 = move-exception;
        r2 = "MicroMsg.BckUploadInfoMgr";
        r3 = "";
        r4 = new java.lang.Object[r0];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.g.i.bT(boolean):boolean");
    }

    private boolean VU() {
        if (this.eju != null) {
            return true;
        }
        if (com.tencent.mm.a.e.aR(this.path)) {
            try {
                this.eju = (e) new e().az(com.tencent.mm.a.e.d(this.path, 0, -1));
                this.eju.ehv = 0;
                return true;
            } catch (Throwable e) {
                v.a("MicroMsg.BckUploadInfoMgr", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                this.eju = new e();
                return false;
            }
        }
        this.eju = new e();
        return false;
    }
}

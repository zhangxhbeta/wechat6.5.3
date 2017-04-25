package com.tencent.mm.ao;

import com.tencent.map.a.a.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class c implements a, e {
    private float bhs;
    private float biH;
    private int biI;
    private int biJ;
    private String biK;
    private String biL;
    a cXB;
    byte[] cXC;
    private ah cXD = new ah(ak.vA().htb.getLooper(), new ah.a(this) {
        final /* synthetic */ c cXF;

        {
            this.cXF = r1;
        }

        public final boolean oU() {
            v.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
            if (this.cXF.cXB != null) {
                ak.vy().c(this.cXF.cXB);
            }
            this.cXF.cXB = null;
            this.cXF.cXC = null;
            synchronized (this.cXF.lock) {
                this.cXF.lock.notifyAll();
            }
            return false;
        }
    }, false);
    private int cXE;
    Object lock = new Object();
    private int scene;

    public c(float f, float f2, int i, int i2, String str, String str2, int i3, int i4) {
        this.biH = f;
        this.bhs = f2;
        this.biI = i;
        this.biJ = i2;
        this.biK = str;
        this.biL = str2;
        this.cXE = i3;
        this.scene = i4;
        ak.vy().a(752, (e) this);
    }

    public final void finish() {
        this.cXD.QI();
        if (this.cXB != null) {
            ak.vy().c(this.cXB);
        }
        this.cXB = null;
        this.cXC = null;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        ak.vy().b(752, (e) this);
    }

    public final byte[] l(byte[] bArr) {
        try {
            String str = new String(bArr, "UTF-8");
            v.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : " + str);
            this.cXC = null;
            this.cXB = new a(this.biH, this.bhs, this.biI, this.biJ, this.biK, this.biL, this.cXE, this.scene, str);
            ak.vy().a(this.cXB, 0);
            this.cXD.ea(60000);
            synchronized (this.lock) {
                this.lock.wait();
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SenseWhereHttpUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + e.toString());
        }
        v.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", Boolean.valueOf(be.bl(this.cXC)));
        return this.cXC;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.cXD.QI();
        if (i == 0 && i2 == 0) {
            if (kVar instanceof a) {
                String ah = be.ah(((a) kVar).cXb, SQLiteDatabase.KeyEmpty);
                v.d("MicroMsg.SenseWhereHttpUtil", "senseWhereResp: " + ah);
                try {
                    this.cXC = ah.getBytes("UTF-8");
                } catch (Throwable e) {
                    v.a("MicroMsg.SenseWhereHttpUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.e("MicroMsg.SenseWhereHttpUtil", "string to byte[] error. " + e.toString());
                }
            } else {
                this.cXC = null;
            }
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
        } else {
            v.w("MicroMsg.SenseWhereHttpUtil", "upload sense where info error. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            this.cXC = null;
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
            b.IA().IC();
            g.iuh.a(345, 4, 1, false);
        }
        this.cXB = null;
    }
}

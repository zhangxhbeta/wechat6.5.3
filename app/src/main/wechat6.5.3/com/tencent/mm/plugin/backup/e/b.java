package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.a.e;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.d.q;
import com.tencent.mm.plugin.backup.d.r;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.f;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public class b extends com.tencent.mm.plugin.backup.b.b {
    private static int progress;
    private int cyu = 0;
    public q eda = new q();
    private r edb = new r();
    private f egV = null;
    private byte[] egW;
    private String filePath;
    private int offset = 0;
    private int start = 0;
    private int type;

    public b(String str, int i, LinkedList<dx> linkedList, String str2, f fVar) {
        this.eda.efo = str;
        this.eda.efp = i;
        this.type = i;
        if (i == 1) {
            dy dyVar = new dy();
            dyVar.eeu = linkedList;
            dyVar.eet = linkedList.size();
            try {
                this.egW = dyVar.toByteArray();
                this.cyu = this.egW.length;
            } catch (Throwable e) {
                v.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
                v.a("MicroMsg.BakSceneDataPush", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        } else {
            this.filePath = str2;
            this.cyu = e.aQ(str2);
        }
        int i2 = this.cyu % 16;
        this.eda.efq = (16 - i2) + this.cyu;
        v.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", this.eda.efo, Integer.valueOf(this.eda.efp), Integer.valueOf(this.cyu), Integer.valueOf(this.eda.efq));
        this.egV = fVar;
    }

    public static void setProgress(int i) {
        v.i("MicroMsg.BakSceneDataPush", "setProgress %d", Integer.valueOf(i));
        progress = i;
    }

    public final boolean Uh() {
        int i;
        byte[] bArr;
        long j = 524288;
        if (this.type == 1) {
            i = this.cyu;
            bArr = this.egW;
        } else {
            if (((long) (this.cyu - this.offset)) <= 524288) {
                j = (long) (this.cyu - this.offset);
            }
            i = (int) j;
            bArr = null;
            int i2 = 3;
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0 && bArr == null) {
                    if (!be.kS(this.filePath)) {
                        String str = this.filePath;
                        ak.yW();
                        if (str.startsWith(c.wY())) {
                            v.i("MicroMsg.BakSceneDataPush", "md5:%s", this.filePath.substring(this.filePath.lastIndexOf("/") + 1));
                            com.tencent.mm.storage.a.c rg = a.bmr().rg(str);
                            if (rg == null || (rg.field_reserved4 & com.tencent.mm.storage.a.c.nxh) != com.tencent.mm.storage.a.c.nxh) {
                                bArr = e.c(this.filePath, this.offset, i);
                                i2 = i3;
                            } else {
                                Object g = a.bmr().g(rg);
                                bArr = new byte[i];
                                System.arraycopy(g, this.offset, bArr, 0, i);
                                i2 = i3;
                            }
                        }
                    }
                    bArr = e.c(this.filePath, this.offset, i);
                    i2 = i3;
                } else if (bArr == null) {
                    v.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", Integer.valueOf(this.offset), Integer.valueOf(i));
                }
            }
            if (bArr == null) {
                v.e("MicroMsg.BakSceneDataPush", "read file error, offset%d, len:%d", Integer.valueOf(this.offset), Integer.valueOf(i));
            }
        }
        this.start = this.offset;
        this.offset = i + this.start;
        if (com.tencent.mm.plugin.backup.g.b.UX() != null) {
            boolean z;
            byte[] UX = com.tencent.mm.plugin.backup.g.b.UX();
            if (this.offset == this.cyu) {
                z = true;
            } else {
                z = false;
            }
            bArr = AesEcb.aesCryptEcb(bArr, UX, true, z);
        }
        this.eda.efr = this.start;
        this.eda.efs = this.start + bArr.length;
        this.eda.eew = new com.tencent.mm.ba.b(bArr);
        this.eda.efu = progress;
        v.i("MicroMsg.BakSceneDataPush", "doSecne %s---total:%d, start:%d, offset:%d, data.len:%d", this.eda.efo, Integer.valueOf(this.cyu), Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(bArr.length));
        return super.Uh();
    }

    public final com.tencent.mm.ba.a Ud() {
        return this.edb;
    }

    public final com.tencent.mm.ba.a Ue() {
        return this.eda;
    }

    public final void Uf() {
        v.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", this.edb.efo, Integer.valueOf(this.edb.efp), Integer.valueOf(this.edb.efr), Integer.valueOf(this.edb.efs), Integer.valueOf(this.edb.eeO));
        if (this.edb.eeO != 0) {
            v.e("MicroMsg.BakSceneDataPush", "status:%d", Integer.valueOf(this.edb.eeO));
            e(4, this.edb.eeO, "error");
            return;
        }
        this.egV.a(this.eda.efs - this.eda.efr, this.cyu, this);
        if (this.offset == this.cyu) {
            v.i("MicroMsg.BakSceneDataPush", "back cmoplete: %s,  %d", this.eda.efo, Integer.valueOf(this.cyu));
            e(0, 0, "success");
            return;
        }
        Uh();
    }

    public int getType() {
        return 5;
    }
}

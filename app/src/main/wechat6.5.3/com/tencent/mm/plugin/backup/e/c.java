package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.a.e;
import com.tencent.mm.ba.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.d.w;
import com.tencent.mm.plugin.backup.d.x;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.f;
import java.io.File;

public final class c extends b {
    private static int progress;
    private int cyu;
    private f egV = null;
    private w egX = new w();
    private x egY = new x();
    private String egZ;
    public String id;
    private int offset = 0;
    private int start = 0;

    public c(String str, String str2, int i, int i2, f fVar) {
        if (i == 1) {
            this.egZ = str + "mmbakItem/" + g.pd(str2);
        } else {
            this.egZ = str + "mmbakMeida/" + g.pd(str2);
        }
        this.id = str2;
        this.egX.efo = str2;
        this.egX.efp = i;
        this.cyu = i2;
        v.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", this.egX.efo, Integer.valueOf(this.egX.efp), Integer.valueOf(this.cyu));
        this.egV = fVar;
    }

    public final boolean Uh() {
        int i;
        long j = 524288;
        v.i("MicroMsg.BakSceneRestoreData", "doSecne");
        int i2 = this.cyu;
        if (this.egX.efp == 2) {
            if (((long) (this.cyu - this.offset)) <= 524288) {
                j = (long) (this.cyu - this.offset);
            }
            i = (int) j;
        } else {
            i = i2;
        }
        this.start = this.offset;
        this.offset = i + this.start;
        this.egX.efr = this.start;
        this.egX.efs = this.offset;
        this.egX.efu = progress;
        return super.Uh();
    }

    public static void setProgress(int i) {
        v.i("MicroMsg.BakSceneRestoreData", "setProgress %d", Integer.valueOf(i));
        progress = i;
    }

    public final a Ud() {
        return this.egY;
    }

    public final a Ue() {
        return this.egX;
    }

    public final void Uf() {
        v.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", this.egY.efo, Integer.valueOf(this.egY.efp), Integer.valueOf(this.egY.efr), Integer.valueOf(this.egY.efs), Integer.valueOf(this.egY.eeO));
        if (this.egY.eeO != 0 && this.egY.eeO != 10) {
            e(4, this.egY.eeO, "error");
        } else if (this.egY.efr == this.start && this.egY.efs == this.offset) {
            byte[] aesCryptEcb;
            this.egV.a(this.egX.efs - this.egX.efr, this.cyu, this);
            byte[] bArr = this.egY.eew.lVU;
            if (com.tencent.mm.plugin.backup.g.b.UX() != null) {
                aesCryptEcb = AesEcb.aesCryptEcb(bArr, com.tencent.mm.plugin.backup.g.b.UX(), false, this.offset == this.cyu);
            } else {
                aesCryptEcb = bArr;
            }
            String str = this.egZ;
            String str2 = this.id;
            File file = new File(str + str2);
            long length = file.exists() ? file.length() : 0;
            e.a(str, str2, aesCryptEcb);
            File file2 = new File(str + str2);
            if (length == (file2.exists() ? file2.length() : 0)) {
                v.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", str + str2);
                e.a(str, str2, aesCryptEcb);
            }
            str = "MicroMsg.BakSceneRestoreData";
            String str3 = "onSceneEnd appendbuf len:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aesCryptEcb == null ? 0 : aesCryptEcb.length);
            v.i(str, str3, objArr);
            if (this.offset == this.cyu) {
                v.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", this.id, Integer.valueOf(this.cyu));
                e(0, 0, "success");
                return;
            }
            Uh();
        } else {
            v.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.egY.efr), Integer.valueOf(this.egY.efs));
            e(3, -1, "error");
        }
    }

    public final int getType() {
        return 7;
    }
}

package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.e;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.v;

public final class f extends ad {
    private int esS;
    private e fyj;
    private a fyk;

    public f(int i, long j, int i2, int i3, byte[] bArr) {
        this.fyj = new e(j, i2, i3, bArr);
        this.esS = i;
    }

    public final boolean a(m mVar, d dVar) {
        if (!u.ajV().bk(this.fyj.esP)) {
            v.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", new Object[]{Long.valueOf(this.fyj.esP)});
            this.fyj.a(-2, "", new byte[0], new byte[0], 0, 0);
            this.fyk = new a(this.fyj, dVar);
            v.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.fyk.b(mVar))});
            return this.fyk.b(mVar);
        } else if (-5 == this.esS || -3 == this.esS || -4 == this.esS) {
            v.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[]{Integer.valueOf(this.esS)});
            this.fyj.a(-1, "", new byte[0], new byte[0], 0, 0);
            this.fyk = new a(this.fyj, dVar);
            v.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.fyk.b(mVar))});
            return this.fyk.b(mVar);
        } else {
            com.tencent.mm.plugin.exdevice.e.f fVar = (com.tencent.mm.plugin.exdevice.e.f) this.fyj.aiu();
            if (fVar == null) {
                v.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
                this.fyj.a(-4, "", new byte[0], new byte[0], 0, 0);
                this.fyk = new a(this.fyj, dVar);
                v.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.fyk.b(mVar))});
                return this.fyk.b(mVar);
            }
            byte[] toByteArray;
            byte[] toByteArray2;
            if (fVar.fvF != null) {
                toByteArray = fVar.fvF.toByteArray();
            } else {
                toByteArray = null;
            }
            if (fVar.fvE != null) {
                toByteArray2 = fVar.fvE.toByteArray();
            } else {
                toByteArray2 = null;
            }
            ac.ajx();
            int aiM = d.aiM();
            switch (aiM) {
                case 1:
                case 2:
                    break;
                default:
                    v.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", new Object[]{Integer.valueOf(aiM)});
                    break;
            }
            this.fyj.a(0, null, toByteArray2, toByteArray, aiM, (int) (b.akI() / 1000));
            this.fyk = new a(this.fyj, dVar);
            return this.fyk.b(mVar);
        }
    }
}

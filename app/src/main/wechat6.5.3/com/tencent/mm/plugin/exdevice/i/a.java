package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public class a implements c {
    private long fwR = -1;
    protected c fyd = null;
    protected d fye = null;
    private m fyf = null;

    public a(c cVar, d dVar) {
        this.fyd = cVar;
        this.fye = dVar;
    }

    public final void a(d dVar) {
        this.fye = dVar;
    }

    public final boolean b(m mVar) {
        if (mVar == null) {
            v.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
            return false;
        } else if (this.fyf != null) {
            v.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
            return false;
        } else {
            v.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", new Object[]{Short.valueOf(this.fyd.air()), Short.valueOf(this.fyd.frc), Long.valueOf(this.fyd.esP)});
            p mVar2 = new m(this.fyd, this);
            long a = mVar.a(mVar2);
            if (-1 == a) {
                v.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
                return false;
            }
            this.fyf = mVar2;
            this.fwR = a;
            m mVar3 = this.fyf;
            Assert.assertNotNull(mVar3.fyA);
            l lVar = mVar3.fyA;
            lVar.fyt = false;
            lVar.fyu = false;
            ak.vA().btx().postDelayed(lVar.fyv, 15000);
            return true;
        }
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        int i3 = 1;
        v.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(this.fyd.esP), Short.valueOf(this.fyd.air()), Short.valueOf(this.fyd.frc)});
        com.tencent.mm.plugin.exdevice.g.a.g(this.fyd.esP, i == 0 ? 1 : 0);
        if (pVar == null || pVar == this.fyf) {
            if (-1 == i && -2 == i2) {
                v.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
            }
            int i4 = this.fyd.frd != null ? this.fyd.frd.fvC : 0;
            if (-5 == i4 || -3 == i4 || -4 == i4) {
                v.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", new Object[]{Integer.valueOf(this.fyd.frd.fvC), Long.valueOf(this.fyd.esP)});
                if (u.ajW().frL == null || !u.ajW().frL.bm(this.fyd.esP)) {
                    i3 = 0;
                }
                if (i3 == 0) {
                    v.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
                }
            }
            if (this.fye != null) {
                this.fye.a(j, i, i2, str);
            }
            this.fyf = null;
            return;
        }
        v.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
    }
}

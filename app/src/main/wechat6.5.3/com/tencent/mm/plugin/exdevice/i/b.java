package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends a implements d {
    private final d fyg;

    public b(c cVar, d dVar) {
        super(cVar, dVar);
        a(this);
        this.fyg = dVar;
    }

    public final void a(long j, int i, int i2, String str) {
        v.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (2 == ((h) this.fyd).aiv()) {
            v.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
            com.tencent.mm.plugin.exdevice.h.b sp = ac.ajq().sp(this.fyd.esP);
            if (sp != null) {
                switch (sp.field_closeStrategy) {
                    case 1:
                        v.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", new Object[]{Integer.valueOf(sp.field_closeStrategy), Long.valueOf(this.fyd.esP)});
                        if (u.ajW().frL != null) {
                            u.ajW().frL.bm(this.fyd.esP);
                            break;
                        }
                        break;
                    case 2:
                        v.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", new Object[]{Integer.valueOf(sp.field_closeStrategy), Long.valueOf(this.fyd.esP)});
                        if (!a.q("shut_down_device", this.fyd.esP)) {
                            v.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
                            break;
                        }
                        break;
                    default:
                        v.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", new Object[]{Integer.valueOf(sp.field_closeStrategy)});
                        break;
                }
            }
            v.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", new Object[]{Long.valueOf(this.fyd.esP)});
            if (this.fyg != null) {
                this.fyg.a(j, i, i2, str);
                return;
            }
            return;
        }
        if (this.fyg != null) {
            this.fyg.a(j, i, i2, str);
        }
    }
}

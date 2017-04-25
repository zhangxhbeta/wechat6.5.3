package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class d implements com.tencent.mm.sdk.platformtools.SensorController.a {
    private boolean evD = false;
    public SensorController evt = new SensorController(aa.getContext());
    public av evx = new av(aa.getContext());
    public long evy = -1;
    public a gGL = null;

    public interface a {
        void dF(boolean z);
    }

    public final void bZ(final boolean z) {
        boolean z2 = true;
        v.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + z + "  hasSkip:" + this.evD + " tick:" + be.az(this.evy) + "  lt:" + this.evy);
        if (this.evD) {
            if (z) {
                z2 = false;
            }
            this.evD = z2;
        } else if (z || this.evy == -1 || be.az(this.evy) <= 400) {
            this.evD = false;
            v.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", new Object[]{Boolean.valueOf(z)});
            new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ d gGM;

                public final boolean oU() {
                    if (z) {
                        v.i("MicroMsg.IPCallSensorManager", "light screen");
                        if (this.gGM.gGL != null) {
                            this.gGM.gGL.dF(false);
                        }
                    } else {
                        v.i("MicroMsg.IPCallSensorManager", "off screen");
                        if (this.gGM.gGL != null) {
                            this.gGM.gGL.dF(true);
                        }
                    }
                    return false;
                }
            }, false).ea(50);
        } else {
            this.evD = true;
        }
    }
}

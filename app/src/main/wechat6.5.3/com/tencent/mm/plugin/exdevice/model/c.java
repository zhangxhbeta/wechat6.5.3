package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.plugin.exdevice.i.d;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c implements d {
    public static c frK;
    private byte[] bXX = new byte[0];
    private final Map<Integer, Set<d>> cAd = new HashMap();
    public m frL;
    a frM = new a(this) {
        final /* synthetic */ d frZ;

        {
            this.frZ = r1;
        }

        public final void aiL() {
            if (this.frZ.frR == null) {
                this.frZ.frR = new c();
                this.frZ.frR.fxm = null;
            }
            this.frZ.frR.bD(aa.getContext());
        }
    };
    Vector<ad> frN = new Vector();
    private ad frO = new ad("ExdeviceHandlerThread");

    public interface a {
        void aiL();
    }

    public final boolean a(final ad adVar) {
        this.frO.x(new Runnable(this) {
            final /* synthetic */ c frP;

            public final void run() {
                boolean z = true;
                Object obj = this.frP;
                ad adVar = adVar;
                if (obj.frL == null) {
                    v.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
                    if (obj.frM != null) {
                        v.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
                        obj.frM.aiL();
                        new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(obj) {
                            private long cAo = 10;
                            final /* synthetic */ c frP;

                            {
                                this.frP = r3;
                            }

                            public final boolean oU() {
                                if (this.frP.frL == null) {
                                    long j = this.cAo;
                                    this.cAo = j - 1;
                                    if (j > 0) {
                                        return true;
                                    }
                                }
                                v.i("MicroMsg.exdevice.ExDeviceTaskService", "now retry count = %d", new Object[]{Long.valueOf(this.cAo)});
                                if (this.cAo > 0) {
                                    this.frP.aiK();
                                }
                                return false;
                            }
                        }, true).ea(100);
                    } else {
                        v.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
                    }
                    z = false;
                }
                if (z) {
                    adVar.a(obj.frL, obj);
                } else {
                    obj.frN.add(adVar);
                }
            }
        });
        return true;
    }

    final void aiK() {
        v.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[]{Integer.valueOf(this.frN.size())});
        if (!this.frN.isEmpty()) {
            a((ad) this.frN.remove(0));
        }
    }

    public final void a(long j, int i, int i2, String str) {
        v.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(this.frN.size())});
        synchronized (this.bXX) {
            aiK();
        }
    }
}

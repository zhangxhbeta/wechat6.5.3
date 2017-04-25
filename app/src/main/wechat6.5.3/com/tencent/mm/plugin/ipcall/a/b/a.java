package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public boolean bhY = false;
    public b gGm = null;
    public final Object gGn = new Object();
    public int gGo = 0;
    public boolean gGp = false;

    class a implements Runnable {
        final /* synthetic */ a gGq;
        private b gGr = null;

        public a(a aVar, b bVar) {
            this.gGq = aVar;
            this.gGr = bVar;
        }

        public final void run() {
            if (this.gGr != null) {
                this.gGr.bbs();
                this.gGr.bbp();
                this.gGr = null;
                this.gGq.gGp = false;
            }
            ak.yX().setMode(0);
        }
    }

    public final void dE(boolean z) {
        v.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[]{Boolean.valueOf(this.gGp), Boolean.valueOf(z)});
        ak.yX().au(z);
        com.tencent.mm.plugin.ipcall.a.c.a aun = i.aun();
        if ((z ? aun.gGO.nl(401) : aun.gGO.nl(402)) < 0) {
            v.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[]{Integer.valueOf(z ? aun.gGO.nl(401) : aun.gGO.nl(402))});
        }
        if (z != this.gGp) {
            this.gGp = z;
            if (this.gGm != null && this.gGm.kqF) {
                this.gGm.gL(z);
            }
        }
    }

    public static boolean qZ() {
        return ak.yX().cba.isSpeakerphoneOn();
    }
}

package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public final class b implements com.tencent.mm.compatible.b.d.a, com.tencent.mm.plugin.ipcall.a.b.d.a, com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a {
    public MMActivity aWn;
    public com.tencent.mm.compatible.util.b djL = new com.tencent.mm.compatible.util.b(aa.getContext());
    public boolean gGA = false;
    public long gGB = 0;
    public a gGs = new a();
    public c gGt = new c();
    public d gGu = new d();
    public HeadsetPlugReceiver gGv = new HeadsetPlugReceiver();
    public j gGw;
    private boolean gGx = false;
    public a gGy;
    public boolean gGz = false;

    public interface a {
        void dH(boolean z);

        void dI(boolean z);
    }

    public final void auD() {
        c cVar = this.gGt;
        if (cVar.bhY) {
            v.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
            return;
        }
        v.i("MicroMsg.IPCallRecorder", "start record");
        cVar.bhY = true;
        cVar.gGE = i.aup().gGs.gGo;
        if (cVar.gGE <= 10) {
            if (cVar.gGE <= 0) {
                v.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
                i.auo().auL();
            }
            cVar.gGE = 92;
        }
        synchronized (cVar.gGD) {
            e.a(new Runnable(cVar) {
                final /* synthetic */ c gGJ;

                {
                    this.gGJ = r1;
                }

                public final void run() {
                    try {
                        c cVar = this.gGJ;
                        cVar.gGC = new com.tencent.mm.c.b.c(v2protocal.hyT, 6);
                        cVar.gGC.cL(20);
                        cVar.gGC.am(true);
                        cVar.gGC.pi();
                        cVar.gGC.aUc = -19;
                        cVar.gGC.r(1, false);
                        cVar.gGC.al(true);
                        cVar.gGC.aUn = cVar.gGI;
                        if (cVar.gGC.pj()) {
                            cVar.gGC.an(cVar.eJx);
                            return;
                        }
                        v.e("MicroMsg.IPCallRecorder", "start record failed");
                        if (cVar.gGC.aTS != 13) {
                            i.auo().auL();
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.IPCallRecorder", "start record error: %s", new Object[]{e.getMessage()});
                        i.auo().auL();
                    }
                }
            }, "IPCallRecorder_startRecord");
        }
    }

    public final void dE(boolean z) {
        this.gGs.dE(z);
    }

    public final void dF(boolean z) {
        boolean z2 = true;
        v.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[]{Boolean.valueOf(z)});
        if (this.aWn != null) {
            MMActivity mMActivity = this.aWn;
            if (z) {
                z2 = false;
            }
            mMActivity.ca(z2);
        }
        if (!i.auq().auh()) {
            return;
        }
        if (z) {
            this.gGx = a.qZ();
            this.gGs.dE(false);
            return;
        }
        this.gGs.dE(this.gGx);
    }

    public final void cK(int i) {
        v.i("MicroMsg.IPCallDeviceManager", "onAudioStatChange, status: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.gGz = true;
                if (this.gGy != null && !this.gGA) {
                    this.gGy.dI(true);
                    return;
                }
                return;
            case 2:
            case 4:
                this.gGz = false;
                if (this.gGy != null && !this.gGA) {
                    this.gGy.dI(false);
                    return;
                }
                return;
            case 3:
                ak.yX().qS();
                if (ak.yX().qU() && this.gGy != null) {
                    this.gGy.dH(true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void dG(boolean z) {
        v.i("MicroMsg.IPCallDeviceManager", "onHeadsetState, on: %b", new Object[]{Boolean.valueOf(z)});
        if (this.gGy != null && z != this.gGA) {
            this.gGA = z;
            if (!this.gGz) {
                this.gGy.dH(z);
            }
        }
    }

    public final int auE() {
        a aVar = this.gGs;
        return (aVar.gGm == null || !aVar.bhY) ? -1 : aVar.gGm.bbu();
    }
}

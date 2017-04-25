package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.c.b.c.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class c {
    private a gGI = new a(this) {
        final /* synthetic */ c kEL;

        {
            this.kEL = r1;
        }

        public final void d(byte[] bArr, int i) {
            if (i <= 0) {
                v.e("MicroMsg.cs.VoipCsAudioManager", "pcm data len <= 0");
                return;
            }
            v.d("MicroMsg.cs.VoipCsAudioManager", "onRecPcmDataReady,pcm data len:" + bArr.length);
            v.d("MicroMsg.cs.VoipCsAudioManager", "recordCallback,ret:" + b.beb().gGO.recordCallback(bArr, i, 200));
        }

        public final void as(int i, int i2) {
            v.i("MicroMsg.cs.VoipCsAudioManager", "OnPcmRecListener onRecError %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    };
    public com.tencent.mm.c.b.c hza = new com.tencent.mm.c.b.c(v2protocal.hyT, 1);
    private com.tencent.mm.plugin.voip.model.a hzd = new com.tencent.mm.plugin.voip.model.a(this) {
        final /* synthetic */ c kEL;

        {
            this.kEL = r1;
        }

        public final int x(byte[] bArr, int i) {
            v.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack,pcm data len:" + bArr.length);
            int playCallback = b.beb().gGO.playCallback(bArr, i);
            if (playCallback != 0) {
                v.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + bArr.length + ",ret:" + playCallback);
            }
            return playCallback != 0 ? 1 : 0;
        }
    };
    public com.tencent.mm.plugin.voip.model.b ksw;

    public c() {
        this.hza.cL(20);
        this.hza.am(true);
        this.hza.pi();
        this.hza.r(1, false);
        this.hza.al(true);
        this.hza.aUn = this.gGI;
        this.ksw = new com.tencent.mm.plugin.voip.model.b();
        this.ksw.L(v2protocal.hyT, 20, 0);
        this.ksw.i(aa.getContext(), false);
        this.ksw.kqQ = this.hzd;
    }

    private boolean gL(boolean z) {
        if (this.ksw != null) {
            return this.ksw.gL(z);
        }
        return false;
    }

    public final void gN(boolean z) {
        v.h("MicroMsg.cs.VoipCsAudioManager", "enableSpeaker: " + z, new Object[0]);
        v.d("MicroMsg.cs.VoipCsAudioManager", "MMCore.getAudioManager() " + ak.yX().qY());
        if (ak.yX().qU()) {
            z = false;
        }
        if (p.ceB.cbr) {
            p.ceB.dump();
            if (p.ceB.cbs > 0) {
                gL(z);
            }
        }
        if (p.ceB.cbT >= 0 || p.ceB.cbU >= 0) {
            gL(z);
        }
        if (this.ksw != null) {
            ak.yX().a(z, this.ksw.bbu());
            com.tencent.mm.plugin.voip_cs.b.b.a beb = b.beb();
            int nl = z ? beb.gGO.nl(401) : beb.gGO.nl(402);
            if (nl < 0) {
                com.tencent.mm.plugin.voip.b.a.cT("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:" + nl);
            }
        }
    }
}

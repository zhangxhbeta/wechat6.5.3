package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class b implements com.tencent.mm.compatible.b.d.a, com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a {
    boolean bhY = false;
    com.tencent.mm.compatible.util.b djL = new com.tencent.mm.compatible.util.b(aa.getContext());
    boolean gGA = false;
    com.tencent.mm.plugin.voip.model.b gGm = null;
    final Object gGn = new Object();
    HeadsetPlugReceiver gGv = new HeadsetPlugReceiver();
    boolean gGz = false;

    class a implements Runnable {
        private com.tencent.mm.plugin.voip.model.b gGr = null;
        final /* synthetic */ b hyX;

        public a(b bVar, com.tencent.mm.plugin.voip.model.b bVar2) {
            this.hyX = bVar;
            this.gGr = bVar2;
        }

        public final void run() {
            if (this.gGr != null) {
                this.gGr.bbs();
                this.gGr.bbp();
                this.gGr = null;
                ak.yX().re();
            }
        }
    }

    public final void dE(boolean z) {
        v.i("MicroMsg.MT.MultiTalkAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[]{Boolean.valueOf(z)});
        ak.yX().au(z);
        if (this.gGm != null && this.gGm.kqF) {
            this.gGm.gL(z);
        }
    }

    public final void dG(boolean z) {
        if (this.gGA != z) {
            this.gGA = z;
            v.d("MicroMsg.MT.MultiTalkAudioPlayer", "onHeadsetState: on");
            dE(!this.gGA);
        }
    }

    public final void cK(int i) {
        v.i("MicroMsg.MT.MultiTalkAudioPlayer", "onBluetoothHeadsetStateChange, status: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                if (!this.gGz) {
                    this.gGz = true;
                    dE(false);
                    return;
                }
                return;
            case 2:
            case 4:
                if (this.gGz) {
                    this.gGz = false;
                    dE(true);
                }
                ak.yX().qT();
                return;
            case 3:
                ak.yX().qS();
                return;
            default:
                return;
        }
    }
}

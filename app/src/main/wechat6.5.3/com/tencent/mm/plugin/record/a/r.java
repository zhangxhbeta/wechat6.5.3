package com.tencent.mm.plugin.record.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.g;
import com.tencent.mm.v.g.b;
import java.util.LinkedList;
import java.util.List;

public final class r implements com.tencent.mm.sdk.platformtools.SensorController.a, com.tencent.mm.v.g.a, b {
    private static SensorController evt;
    public List<a> bXt = new LinkedList();
    private int bdW;
    private boolean evD = false;
    private boolean evw = true;
    private av evx;
    long evy = -1;
    private boolean evz;
    public g fLu = com.tencent.mm.plugin.record.a.drq.ox();
    public String path;

    public interface a {
        void onFinish();

        void yz(String str);
    }

    public r() {
        ak.yW();
        Boolean bool = (Boolean) c.vf().get(26, Boolean.valueOf(false));
        this.evz = bool.booleanValue();
        this.evw = !bool.booleanValue();
        if (this.fLu != null) {
            this.fLu.a(this);
            this.fLu.a(this);
            this.fLu.ak(this.evw);
        } else {
            v.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
        }
        if (evt == null) {
            evt = new SensorController(aa.getContext());
        }
        if (this.evx == null) {
            this.evx = new av(aa.getContext());
        }
    }

    public final boolean au(String str, int i) {
        if (this.fLu == null) {
            v.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.fLu.stop();
        for (a yz : this.bXt) {
            yz.yz(str);
        }
        if (!(evt == null || evt.nll)) {
            evt.a(this);
            if (this.evx.F(new Runnable(this) {
                final /* synthetic */ r ipJ;

                {
                    this.ipJ = r1;
                }

                public final void run() {
                    this.ipJ.evy = be.Nj();
                }
            })) {
                this.evy = 0;
            } else {
                this.evy = -1;
            }
        }
        this.path = str;
        this.bdW = i;
        if (be.kS(str) || !this.fLu.a(str, this.evw, true, i)) {
            return false;
        }
        ab.Ki("keep_app_silent");
        return true;
    }

    public final boolean alM() {
        if (this.fLu != null) {
            return this.fLu.isPlaying();
        }
        v.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
        return false;
    }

    public final void XV() {
        v.d("MicroMsg.RecordVoiceHelper", "stop play");
        ab.Kj("keep_app_silent");
        if (this.fLu != null) {
            this.fLu.stop();
        }
        if (evt != null) {
            evt.btX();
        }
        if (this.evx != null) {
            this.evx.btY();
        }
    }

    public final void onError() {
        v.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
        XV();
        for (a onFinish : this.bXt) {
            onFinish.onFinish();
        }
    }

    public final void pa() {
        v.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
        XV();
        for (a onFinish : this.bXt) {
            onFinish.onFinish();
        }
    }

    public final void bZ(boolean z) {
        boolean z2 = true;
        if (!be.kS(this.path)) {
            if (this.evD) {
                if (z) {
                    z2 = false;
                }
                this.evD = z2;
            } else if (z || this.evy == -1 || be.az(this.evy) <= 400) {
                this.evD = false;
                if (this.fLu != null && this.fLu.oW()) {
                    return;
                }
                if (this.evz) {
                    if (this.fLu != null) {
                        this.fLu.ak(false);
                    }
                    this.evw = false;
                } else if (this.fLu == null || this.fLu.isPlaying()) {
                    if (this.fLu != null) {
                        this.fLu.ak(z);
                    }
                    this.evw = z;
                    if (!z) {
                        au(this.path, this.bdW);
                    }
                } else {
                    this.fLu.ak(true);
                    this.evw = true;
                }
            } else {
                this.evD = true;
            }
        }
    }
}

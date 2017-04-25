package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.c;
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

public final class u implements com.tencent.mm.sdk.platformtools.SensorController.a, com.tencent.mm.v.g.a, b {
    public static SensorController evt;
    private List<a> bXt = new LinkedList();
    private int bdW;
    private boolean evD = false;
    private boolean evw = true;
    public av evx;
    long evy = -1;
    private boolean evz;
    private g fLu = c.drq.ox();
    public boolean fLv;
    private int fLw;
    public String path;

    public interface a {
        void av(String str, int i);

        void onFinish();

        void onPause();
    }

    public u() {
        ak.yW();
        Boolean bool = (Boolean) com.tencent.mm.model.c.vf().get(26, Boolean.valueOf(false));
        this.evz = bool.booleanValue();
        this.evw = !bool.booleanValue();
        if (this.fLu != null) {
            this.fLu.a(this);
            this.fLu.a(this);
            this.fLu.ak(this.evw);
        } else {
            v.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
        }
        if (evt == null) {
            evt = new SensorController(aa.getContext());
        }
        if (this.evx == null) {
            this.evx = new av(aa.getContext());
        }
    }

    public final void a(a aVar) {
        for (a aVar2 : this.bXt) {
            if (aVar == aVar2) {
                return;
            }
        }
        this.bXt.add(aVar);
    }

    public final void destroy() {
        pause();
        XT();
        evt = null;
        this.bXt.clear();
    }

    public final void pause() {
        if (this.fLu == null) {
            v.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
            return;
        }
        if (this.fLu.isPlaying()) {
            alO();
        }
        for (a onPause : this.bXt) {
            onPause.onPause();
        }
    }

    public final boolean au(String str, int i) {
        if (this.fLu == null) {
            v.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.fLu.stop();
        for (a av : this.bXt) {
            av.av(str, 0);
        }
        if (!(evt == null || evt.nll)) {
            evt.a(this);
            if (this.evx.F(new Runnable(this) {
                final /* synthetic */ u fLx;

                {
                    this.fLx = r1;
                }

                public final void run() {
                    this.fLx.evy = be.Nj();
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

    public final boolean x(String str, int i, int i2) {
        if (this.fLu == null) {
            v.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        this.fLu.stop();
        for (a av : this.bXt) {
            av.av(str, i2);
        }
        if (!(evt == null || evt.nll)) {
            evt.a(this);
            if (this.evx.F(new Runnable(this) {
                final /* synthetic */ u fLx;

                {
                    this.fLx = r1;
                }

                public final void run() {
                    this.fLx.evy = be.Nj();
                }
            })) {
                this.evy = 0;
            } else {
                this.evy = -1;
            }
        }
        this.path = str;
        this.bdW = i;
        if (be.kS(str) || !this.fLu.a(str, this.evw, i, i2)) {
            return false;
        }
        ab.Ki("keep_app_silent");
        ak.yX().d(this.evw, false);
        return true;
    }

    public final boolean alM() {
        if (this.fLu != null) {
            return this.fLu.isPlaying();
        }
        v.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
        return false;
    }

    public final boolean oZ() {
        if (this.fLu != null) {
            return this.fLu.oZ();
        }
        v.w("MicroMsg.FavVoiceLogic", "check is pause, but player is null");
        return false;
    }

    public final double oY() {
        if (this.fLu != null) {
            return this.fLu.oY();
        }
        v.w("MicroMsg.FavVoiceLogic", "get now progress error, player is null");
        return 0.0d;
    }

    public final boolean alN() {
        v.i("MicroMsg.FavVoiceLogic", "resume play");
        ab.Ki("keep_app_silent");
        if (this.fLu != null) {
            return this.fLu.oV();
        }
        v.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
        return false;
    }

    public final boolean alO() {
        v.i("MicroMsg.FavVoiceLogic", "pause play");
        ab.Kj("keep_app_silent");
        if (this.fLu != null) {
            return this.fLu.pause();
        }
        v.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
        return false;
    }

    public final void XV() {
        v.d("MicroMsg.FavVoiceLogic", "stop play");
        ab.Kj("keep_app_silent");
        if (this.fLu != null) {
            this.fLu.stop();
        }
        XT();
    }

    public final void onError() {
        v.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
        XV();
        for (a onFinish : this.bXt) {
            onFinish.onFinish();
        }
    }

    public final void pa() {
        v.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
        XV();
        for (a onFinish : this.bXt) {
            onFinish.onFinish();
        }
    }

    private void XT() {
        if (evt != null) {
            evt.btX();
        }
        if (this.evx != null) {
            this.evx.btY();
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
                    ak.yX().d(false, false);
                    this.evw = false;
                } else if (this.fLu == null || this.fLu.isPlaying() || this.fLv) {
                    if (this.fLu != null) {
                        this.fLu.ak(z);
                    }
                    this.evw = z;
                    if (this.fLv && !z) {
                        x(this.path, this.bdW, this.fLw);
                    } else if (!z) {
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

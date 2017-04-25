package com.tencent.mm.plugin.mmsight.segment.mp;

import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.mp.a.b;
import com.tencent.mm.plugin.mmsight.segment.mp.a.d;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;

public final class c implements a {
    private ah cSA;
    public a hsI;
    private a hta;
    private HandlerThread htb = e.bJ("check auto job", 10);
    int htc;
    int htd;
    private com.tencent.mm.plugin.mmsight.segment.mp.a.c hte = null;
    boolean htf;
    private com.tencent.mm.plugin.mmsight.segment.mp.a.c htg = new com.tencent.mm.plugin.mmsight.segment.mp.a.c(this) {
        final /* synthetic */ c hti;

        {
            this.hti = r1;
        }
    };
    private com.tencent.mm.sdk.platformtools.ah.a hth = new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c hti;

        {
            this.hti = r1;
        }

        public final boolean oU() {
            if (this.hti.htf) {
                return false;
            }
            try {
                if (!this.hti.isPlaying()) {
                    return true;
                }
                int currentPosition = this.hti.getCurrentPosition();
                if (this.hti.hsI != null) {
                    this.hti.hsI.ne(currentPosition);
                }
                if (currentPosition < this.hti.htd) {
                    return true;
                }
                this.hti.seekTo(this.hti.htc);
                return true;
            } catch (IllegalStateException e) {
                v.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", new Object[]{e.getMessage()});
                if (this.hti.htf) {
                    return false;
                }
                return true;
            }
        }
    };

    public interface a {
        void ne(int i);
    }

    public c() {
        int intValue = ((Integer) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.t.a.ntL, Integer.valueOf(-1))).intValue();
        if (intValue == 1) {
            this.hta = new d();
        } else if (intValue == 2) {
            this.hta = new b();
        } else {
            this.hta = new d();
        }
        this.hte = this.htg;
        this.htb.start();
        this.cSA = new ah(this.htb.getLooper(), this.hth, true);
    }

    public final void setLoop(int i, int i2) {
        this.htc = i;
        this.htd = i2;
    }

    public final void setDataSource(String str) {
        this.hta.setDataSource(str);
    }

    public final void release() {
        this.htf = true;
        this.hta.release();
        if (this.cSA != null) {
            this.cSA.QI();
        }
        if (this.htb != null) {
            this.htb.quit();
        }
    }

    public final void start() {
        this.hta.start();
        this.cSA.ea(30);
    }

    public final void pause() {
        this.hta.pause();
        this.cSA.QI();
    }

    public final void stop() {
        this.hta.stop();
        this.cSA.QI();
    }

    public final void setAudioStreamType(int i) {
        this.hta.setAudioStreamType(i);
    }

    public final int getCurrentPosition() {
        return this.hta.getCurrentPosition();
    }

    public final void setSurface(Surface surface) {
        this.hta.setSurface(surface);
    }

    public final boolean isPlaying() {
        return this.hta.isPlaying();
    }

    public final void seekTo(int i) {
        this.hta.seekTo(i);
    }

    public final void prepareAsync() {
        this.hta.prepareAsync();
    }

    public final void setLooping(boolean z) {
        this.hta.setLooping(z);
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.mp.a.a aVar) {
        this.hta.a(aVar);
    }

    public final void a(d dVar) {
        this.hta.a(dVar);
    }

    public final void a(b bVar) {
        this.hta.a(bVar);
    }
}

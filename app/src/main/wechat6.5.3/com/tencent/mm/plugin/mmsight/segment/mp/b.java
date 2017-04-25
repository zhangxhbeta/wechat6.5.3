package com.tencent.mm.plugin.mmsight.segment.mp;

import android.view.Surface;
import com.tencent.mm.plugin.mmsight.segment.mp.a.a;
import com.tencent.mm.plugin.mmsight.segment.mp.a.d;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.c;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.f;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.i;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.m;
import java.io.File;

public final class b implements a {
    private h hsV;

    public b() {
        this.hsV = new h();
        this.hsV.hug = k.huY;
    }

    public final void setSurface(Surface surface) {
        h hVar = this.hsV;
        hVar.huh = surface;
        hVar.hui = null;
        if (hVar.huq == null) {
            hVar.a(m.hvn);
            hVar.aBj();
            return;
        }
        hVar.huq.setSurface(hVar.huh);
    }

    public final void setDataSource(String str) {
        this.hsV.a(new c(new File(str)));
    }

    public final void prepareAsync() {
        this.hsV.prepareAsync();
    }

    public final void start() {
        this.hsV.start();
    }

    public final void stop() {
        this.hsV.stop();
    }

    public final void pause() {
        this.hsV.pause();
    }

    public final boolean isPlaying() {
        return this.hsV.isPlaying();
    }

    public final void seekTo(int i) {
        this.hsV.seekTo(i);
    }

    public final int getCurrentPosition() {
        return this.hsV.getCurrentPosition();
    }

    public final void release() {
        this.hsV.release();
    }

    public final void setAudioStreamType(int i) {
        this.hsV.htt = i;
    }

    public final void setLooping(boolean z) {
        this.hsV.huI = z;
    }

    public final void a(final com.tencent.mm.plugin.mmsight.segment.mp.a.b bVar) {
        if (bVar == null) {
            this.hsV.hux = null;
            return;
        }
        this.hsV.hux = new f(this) {
            final /* synthetic */ b hsX;

            public final void a(h hVar) {
                bVar.aN(hVar);
            }
        };
    }

    public final void a(final d dVar) {
        if (dVar == null) {
            this.hsV.huD = null;
            return;
        }
        this.hsV.huD = new i(this) {
            final /* synthetic */ b hsX;

            public final void bU(int i, int i2) {
                dVar.bS(i, i2);
            }
        };
    }

    public final void a(final a aVar) {
        if (aVar == null) {
            this.hsV.huB = null;
            return;
        }
        this.hsV.huB = new h.d(this) {
            final /* synthetic */ b hsX;

            public final boolean a(h hVar, int i, int i2) {
                return aVar.bT(i, i2);
            }
        };
    }
}

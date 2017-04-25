package com.tencent.mm.plugin.music.a.c;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;

public abstract class a {
    protected com.tencent.mm.ai.a big;
    protected d hDq;
    protected e hDr = new e();

    public abstract boolean aDh();

    public abstract int aDi();

    public abstract int getDuration();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void play();

    public abstract void seek(long j);

    public abstract void stop();

    public abstract void xd(String str);

    public final void a(d dVar) {
        this.hDq = dVar;
    }

    public final void f(com.tencent.mm.ai.a aVar) {
        this.big = aVar;
    }

    protected void eF(final boolean z) {
        if (this.hDq != null) {
            ad.o(new Runnable(this) {
                final /* synthetic */ a hDt;

                public final void run() {
                    v.i("MicroMsg.Music.BasePlayer", "onError");
                    this.hDt.hDq.c(this.hDt.big, z);
                }
            });
        }
    }

    protected final void onStart() {
        if (this.hDq != null) {
            ad.o(new Runnable(this) {
                final /* synthetic */ a hDt;

                {
                    this.hDt = r1;
                }

                public final void run() {
                    v.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[]{Boolean.valueOf(this.hDt.isPlaying())});
                    this.hDt.hDq.c(this.hDt.big);
                }
            });
        }
    }

    protected final void nw(final int i) {
        if (this.hDq != null) {
            ad.o(new Runnable(this) {
                final /* synthetic */ a hDt;

                public final void run() {
                    if (this.hDt.aDh()) {
                        this.hDt.hDq.d(this.hDt.big);
                    }
                }
            });
        }
    }

    protected void eG(final boolean z) {
        if (this.hDq != null) {
            ad.o(new Runnable(this) {
                final /* synthetic */ a hDt;

                public final void run() {
                    v.i("MicroMsg.Music.BasePlayer", "onStop");
                    this.hDt.hDq.b(this.hDt.big, z);
                }
            });
        }
    }
}

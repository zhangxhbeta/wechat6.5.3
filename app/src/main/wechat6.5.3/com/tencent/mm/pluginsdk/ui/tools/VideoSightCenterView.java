package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class VideoSightCenterView extends VideoSightView {
    private boolean bhY = false;
    private int jyD = 0;
    private volatile boolean lUu = false;
    private MediaMetadataRetriever lUv;

    public VideoSightCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VideoSightCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void pv(int i) {
        super.pv(i);
        bqX();
    }

    public final void co(int i, int i2) {
        super.co(i, i2);
        bqX();
    }

    private void bqX() {
        if (getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
        }
    }

    protected final void init() {
        if (be.ah(p.ceJ.cef, "").equals("other")) {
            v.i("MicroMsg.VideoSightCenterView", "init::use other player");
        } else {
            fB(true);
        }
        a(new e(this) {
            final /* synthetic */ VideoSightCenterView lUw;

            {
                this.lUw = r1;
            }

            public final void d(b bVar, int i) {
                if (-1 == i) {
                    v.i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", new Object[]{Boolean.valueOf(this.lUw.lUu)});
                    if (this.lUw.iVc != null && !this.lUw.lUu) {
                        this.lUw.iVc.bp(0, 0);
                    }
                } else if (i == 0) {
                    v.i("MicroMsg.VideoSightCenterView", "normal stop");
                    this.lUw.lUu = true;
                    if (this.lUw.iVc != null) {
                        this.lUw.iVc.pa();
                    }
                }
            }
        });
    }

    public final void fE(boolean z) {
        if (z) {
            a(new f(this) {
                final /* synthetic */ VideoSightCenterView lUw;

                {
                    this.lUw = r1;
                }

                public final void b(b bVar, long j) {
                    if (this.lUw.duration == 0) {
                        this.lUw.duration = this.lUw.getDuration();
                    }
                    if (this.lUw.iVc != null) {
                        v.v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", new Object[]{Long.valueOf(j), Integer.valueOf(this.lUw.duration)});
                        this.lUw.jyD = (int) (1000 * j);
                        this.lUw.iVc.bq((int) j, this.lUw.duration);
                    }
                }
            });
        } else {
            a(null);
        }
    }

    public final int getDuration() {
        v.i("MicroMsg.VideoSightCenterView", "getDuration");
        if (!be.kS(this.iTJ)) {
            try {
                if (this.lUv == null) {
                    this.lUv = new MediaMetadataRetriever();
                    this.lUv.setDataSource(this.iTJ);
                }
                v.i("MicroMsg.VideoSightCenterView", "getDuration: %s", new Object[]{Integer.valueOf(Integer.valueOf(this.lUv.extractMetadata(9)).intValue())});
                return Integer.valueOf(this.lUv.extractMetadata(9)).intValue();
            } catch (Exception e) {
                v.e("MicroMsg.VideoSightCenterView", "getDuration error: %s", new Object[]{e.getMessage()});
            }
        }
        return super.getDuration();
    }

    public final int getCurrentPosition() {
        v.v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", new Object[]{Integer.valueOf(this.jyD)});
        return this.jyD;
    }

    public final boolean start() {
        v.v("MicroMsg.VideoSightCenterView", "start");
        this.bhY = true;
        return super.start();
    }

    public final void stop() {
        v.v("MicroMsg.VideoSightCenterView", "stop");
        super.stop();
        this.jyD = 0;
        this.bhY = false;
    }

    public final void pause() {
        v.v("MicroMsg.VideoSightCenterView", "pause");
        super.pause();
    }

    public final double aPB() {
        return super.aPB();
    }

    public final void i(double d) {
        v.v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", new Object[]{Double.valueOf(d), Boolean.valueOf(this.bhY), Integer.valueOf(this.jyD), Double.valueOf(super.aPB())});
        if (this.bhY && super.aPB() > 0.0d) {
            super.i(d / 1000.0d);
        }
    }

    public final boolean isPlaying() {
        v.v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", new Object[]{Boolean.valueOf(this.bhY), Integer.valueOf(this.jyD)});
        return this.bhY;
    }
}

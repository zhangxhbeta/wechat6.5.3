package com.tencent.mm.plugin.mmsight.segment.mp.inner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.b;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.c;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.d;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.e;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.f;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.g;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.h;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.i;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.m;
import java.io.IOException;

public class VideoView extends SurfaceView implements Callback, MediaPlayerControl {
    private static final String TAG = VideoView.class.getSimpleName();
    private int cfd;
    private int cfe;
    private int fq = 0;
    private int gEK = 0;
    private g huA;
    private d huB;
    private e huC;
    private b huE;
    private SurfaceHolder hui;
    private f hux;
    private c huy;
    private h huz;
    private e hvA = new e(this) {
        final /* synthetic */ VideoView hvC;

        {
            this.hvC = r1;
        }

        public final boolean b(h hVar, int i, int i2) {
            if (this.hvC.huC != null) {
                return this.hvC.huC.b(hVar, i, i2);
            }
            return true;
        }
    };
    private b hvB = new b(this) {
        final /* synthetic */ VideoView hvC;

        {
            this.hvC = r1;
        }

        public final void a(h hVar, int i) {
            if (this.hvC.huE != null) {
                this.hvC.huE.a(hVar, i);
            }
        }
    };
    private i hvq;
    h hvr;
    private int hvs;
    float hvt;
    private f hvu = new f(this) {
        final /* synthetic */ VideoView hvC;

        {
            this.hvC = r1;
        }

        public final void a(h hVar) {
            this.hvC.gEK = 2;
            VideoView videoView = this.hvC;
            float d = this.hvC.hvt;
            if (d < 0.0f) {
                throw new IllegalArgumentException("speed cannot be negative");
            }
            if (videoView.aBq()) {
                h hVar2 = videoView.hvr;
                if (d < 0.0f) {
                    throw new IllegalArgumentException("speed cannot be negative");
                }
                hVar2.huv.aIr = (double) d;
                hVar2.huv.ci(hVar2.hur);
            }
            videoView.hvt = d;
            if (this.hvC.hux != null) {
                this.hvC.hux.a(hVar);
            }
            int f = this.hvC.hvs;
            if (f != 0) {
                this.hvC.seekTo(f);
            }
            if (this.hvC.fq == 3) {
                this.hvC.start();
            }
        }
    };
    private i hvv = new i(this) {
        final /* synthetic */ VideoView hvC;

        {
            this.hvC = r1;
        }

        public final void bU(int i, int i2) {
            this.hvC.cfd = i;
            this.hvC.cfe = i2;
            this.hvC.requestLayout();
        }
    };
    private h hvw = new h(this) {
        final /* synthetic */ VideoView hvC;

        {
            this.hvC = r1;
        }

        public final void d(h hVar) {
            if (this.hvC.huz != null) {
                this.hvC.huz.d(hVar);
            }
        }
    };
    private g hvx = new g(this) {
        final /* synthetic */ VideoView hvC;

        {
            this.hvC = r1;
        }

        public final void c(h hVar) {
            if (this.hvC.huA != null) {
                this.hvC.huA.c(hVar);
            }
        }
    };
    private c hvy = new c(this) {
        final /* synthetic */ VideoView hvC;

        {
            this.hvC = r1;
        }

        public final void b(h hVar) {
            this.hvC.gEK = 5;
            this.hvC.fq = 5;
            if (this.hvC.huy != null) {
                this.hvC.huy.b(hVar);
            }
        }
    };
    private d hvz = new d(this) {
        final /* synthetic */ VideoView hvC;

        {
            this.hvC = r1;
        }

        public final boolean a(h hVar, int i, int i2) {
            this.hvC.gEK = -1;
            this.hvC.fq = -1;
            if (this.hvC.huB != null) {
                return this.hvC.huB.a(hVar, i, i2);
            }
            Toast.makeText(this.hvC.getContext(), "Cannot play the video", 1).show();
            return true;
        }
    };

    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aBp();
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aBp();
    }

    private void aBp() {
        getHolder().addCallback(this);
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.cfd, i);
        int defaultSize2 = getDefaultSize(this.cfe, i2);
        if (this.cfd > 0 && this.cfe > 0) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            defaultSize2 = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.cfd * defaultSize2 < this.cfe * size) {
                    defaultSize = (this.cfd * defaultSize2) / this.cfe;
                } else if (this.cfd * defaultSize2 > this.cfe * size) {
                    defaultSize2 = (this.cfe * size) / this.cfd;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.cfe * size) / this.cfd;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.cfd * defaultSize2) / this.cfe;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i3 = this.cfd;
                defaultSize = this.cfe;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i3;
                } else {
                    defaultSize = (this.cfd * defaultSize2) / this.cfe;
                }
                if (mode == Integer.MIN_VALUE && r1 > size) {
                    defaultSize2 = (this.cfe * size) / this.cfd;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    private void release() {
        if (this.hvr != null) {
            this.hvr.release();
            this.hvr = null;
        }
        this.gEK = 0;
        this.fq = 0;
    }

    public void start() {
        if (aBq()) {
            this.hvr.start();
        } else {
            this.fq = 3;
        }
    }

    public void pause() {
        if (aBq()) {
            this.hvr.pause();
        }
        this.fq = 4;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.hui = surfaceHolder;
        if (this.hvq != null && this.hui != null) {
            release();
            this.hvr = new h();
            h hVar = this.hvr;
            SurfaceHolder surfaceHolder2 = this.hui;
            hVar.hui = surfaceHolder2;
            if (surfaceHolder2 != null) {
                hVar.huh = surfaceHolder2.getSurface();
            } else {
                hVar.huh = null;
            }
            if (hVar.huJ != null) {
                f fVar = hVar.huJ.htF;
            }
            if (hVar.huq == null) {
                hVar.a(m.AUTO);
                hVar.aBj();
            } else {
                hVar.huq.setSurface(hVar.huh);
            }
            hVar = this.hvr;
            if (!hVar.huG) {
                hVar.huG = true;
                hVar.aBj();
            }
            this.hvr.hux = this.hvu;
            this.hvr.huz = this.hvw;
            this.hvr.huA = this.hvx;
            this.hvr.huy = this.hvy;
            this.hvr.huD = this.hvv;
            this.hvr.huB = this.hvz;
            this.hvr.huC = this.hvA;
            this.hvr.huE = this.hvB;
            final Handler handler = new Handler(new Handler.Callback(this) {
                final /* synthetic */ VideoView hvC;

                {
                    this.hvC = r1;
                }

                public final boolean handleMessage(Message message) {
                    this.hvC.gEK = -1;
                    this.hvC.fq = -1;
                    this.hvC.hvz.a(this.hvC.hvr, 1, 0);
                    return true;
                }
            });
            new Thread(new Runnable(this) {
                final /* synthetic */ VideoView hvC;

                public final void run() {
                    try {
                        this.hvC.gEK = 1;
                        this.hvC.hvr.a(this.hvC.hvq);
                        if (this.hvC.hvr != null) {
                            this.hvC.hvr.prepareAsync();
                            VideoView.TAG;
                        }
                    } catch (IOException e) {
                        VideoView.TAG;
                        handler.sendEmptyMessage(0);
                    } catch (NullPointerException e2) {
                        VideoView.TAG;
                    }
                }
            }).start();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.hui = null;
        release();
    }

    public int getDuration() {
        return this.hvr != null ? this.hvr.getDuration() : 0;
    }

    public int getCurrentPosition() {
        if (aBq()) {
            return this.hvr.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (aBq()) {
            this.hvr.seekTo(i);
            this.hvs = 0;
            return;
        }
        this.hvs = i;
    }

    final boolean aBq() {
        return this.hvr != null && this.gEK >= 2;
    }

    public boolean isPlaying() {
        return this.hvr != null && this.hvr.isPlaying();
    }

    public int getBufferPercentage() {
        return this.hvr != null ? this.hvr.huu : 0;
    }

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    public int getAudioSessionId() {
        return this.hvr != null ? this.hvr.hts : 0;
    }
}

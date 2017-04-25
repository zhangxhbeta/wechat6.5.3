package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.pluginsdk.ui.tools.g.a;
import com.tencent.mm.sdk.platformtools.v;

public class VideoSurfaceView extends SurfaceView implements g {
    private int cfd;
    private int cfe;
    private boolean eJx;
    private SurfaceHolder hui;
    private a iVc;
    private MediaPlayer iZA;
    private String lUD;
    private boolean lUE;
    private boolean lUF;
    OnVideoSizeChangedListener lUG;
    OnPreparedListener lUH;
    private OnCompletionListener lUI;
    private OnErrorListener lUJ;
    Callback lUK;
    private int lr;

    static /* synthetic */ void c(VideoSurfaceView videoSurfaceView) {
        if (videoSurfaceView.cfe != 0 && videoSurfaceView.cfd != 0) {
            int i = videoSurfaceView.cfd;
            int i2 = videoSurfaceView.cfe;
            v.v("MicroMsg.VideoSurfaceView", "video size before:" + i + "   " + i2);
            v.v("MicroMsg.VideoSurfaceView", "layout size before:" + videoSurfaceView.getWidth() + "   " + videoSurfaceView.getHeight());
            int width = videoSurfaceView.getWidth();
            int height = videoSurfaceView.getHeight();
            int i3 = width <= 0 ? i : width;
            width = height <= 0 ? i2 : height;
            float f = (((float) i3) * 1.0f) / ((float) i);
            float f2 = (((float) width) * 1.0f) / ((float) i2);
            LayoutParams layoutParams = (LayoutParams) videoSurfaceView.getLayoutParams();
            if (f > f2) {
                layoutParams.width = (int) (((float) i) * f2);
                layoutParams.height = width;
            } else {
                layoutParams.width = i3;
                layoutParams.height = (int) (((float) i2) * f);
            }
            layoutParams.addRule(13);
            videoSurfaceView.setLayoutParams(layoutParams);
            v.v("MicroMsg.VideoSurfaceView", "video size after:" + videoSurfaceView.iZA.getVideoWidth() + "   " + videoSurfaceView.iZA.getVideoHeight());
            v.v("MicroMsg.VideoSurfaceView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        }
    }

    public VideoSurfaceView(Context context) {
        this(context, null);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hui = null;
        this.iZA = null;
        this.lUG = new OnVideoSizeChangedListener(this) {
            final /* synthetic */ VideoSurfaceView lUL;

            {
                this.lUL = r1;
            }

            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                this.lUL.cfd = mediaPlayer.getVideoWidth();
                this.lUL.cfe = mediaPlayer.getVideoHeight();
                v.v("MicroMsg.VideoSurfaceView", "on size change size:( " + this.lUL.cfd + " , " + this.lUL.cfe + " )");
                VideoSurfaceView.c(this.lUL);
            }
        };
        this.lUH = new OnPreparedListener(this) {
            final /* synthetic */ VideoSurfaceView lUL;

            {
                this.lUL = r1;
            }

            public final void onPrepared(MediaPlayer mediaPlayer) {
                this.lUL.lUE = true;
                if (this.lUL.iVc != null) {
                    this.lUL.iVc.abH();
                }
                this.lUL.cfd = mediaPlayer.getVideoWidth();
                this.lUL.cfe = mediaPlayer.getVideoHeight();
                VideoSurfaceView.c(this.lUL);
                if (this.lUL.cfd == 0 || this.lUL.cfe == 0) {
                    if (this.lUL.lUF) {
                        this.lUL.iZA.start();
                        this.lUL.lUF = false;
                    }
                } else if (this.lUL.lUF) {
                    this.lUL.iZA.start();
                    this.lUL.lUF = false;
                }
            }
        };
        this.lUI = new OnCompletionListener(this) {
            final /* synthetic */ VideoSurfaceView lUL;

            {
                this.lUL = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (this.lUL.iVc != null) {
                    this.lUL.iVc.bq(this.lUL.iZA.getCurrentPosition(), this.lUL.iZA.getDuration());
                    this.lUL.iVc.pa();
                }
            }
        };
        this.lUJ = new OnErrorListener(this) {
            final /* synthetic */ VideoSurfaceView lUL;

            {
                this.lUL = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                v.d("MicroMsg.VideoSurfaceView", "Error: " + i + "," + i2);
                if (this.lUL.iVc != null) {
                    this.lUL.iVc.bp(i, i2);
                }
                return true;
            }
        };
        this.lUK = new Callback(this) {
            final /* synthetic */ VideoSurfaceView lUL;

            {
                this.lUL = r1;
            }

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                v.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (this.lUL.iZA != null && this.lUL.lUE && this.lUL.cfd == i2 && this.lUL.cfe == i3) {
                    this.lUL.iZA.start();
                }
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                v.i("MicroMsg.VideoSurfaceView", "on surface created");
                this.lUL.hui = surfaceHolder;
                this.lUL.bqY();
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                v.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
                this.lUL.hui = null;
                if (this.lUL.iZA != null) {
                    this.lUL.iVc.bq(this.lUL.iZA.getCurrentPosition(), this.lUL.iZA.getDuration());
                    this.lUL.iZA.reset();
                    this.lUL.iZA.release();
                    this.lUL.iZA = null;
                }
            }
        };
        this.eJx = false;
        this.cfd = 0;
        this.cfe = 0;
        getHolder().addCallback(this.lUK);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public final void setVideoPath(String str) {
        this.lUD = str;
        this.lUF = false;
        bqY();
        requestLayout();
    }

    public final String aOV() {
        return this.lUD;
    }

    public final void stop() {
        if (this.iZA != null) {
            this.iZA.stop();
            this.iZA.release();
            this.iZA = null;
        }
    }

    private void bqY() {
        if (this.lUD != null && this.hui != null) {
            if (this.iZA != null) {
                this.iZA.stop();
                this.iZA.release();
                this.iZA = null;
            }
            try {
                this.iZA = new MediaPlayer();
                this.iZA.setOnPreparedListener(this.lUH);
                this.iZA.setOnVideoSizeChangedListener(this.lUG);
                this.lUE = false;
                v.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
                this.lr = -1;
                this.iZA.setOnCompletionListener(this.lUI);
                this.iZA.setOnErrorListener(this.lUJ);
                this.iZA.setDataSource(this.lUD);
                this.iZA.setDisplay(this.hui);
                this.iZA.setAudioStreamType(3);
                this.iZA.setScreenOnWhilePlaying(true);
                this.iZA.prepareAsync();
                this.cfe = this.iZA.getVideoHeight();
                this.cfd = this.iZA.getVideoWidth();
                dJ(this.eJx);
            } catch (Throwable e) {
                v.a("MicroMsg.VideoSurfaceView", e, "prepare async error %s", e.getMessage());
                if (this.iVc != null) {
                    this.iVc.bp(-1, -1);
                }
            }
        }
    }

    public final void pause() {
        if (this.iZA != null && this.lUE && this.iZA.isPlaying()) {
            this.iZA.pause();
        }
        this.lUF = false;
    }

    public final int getDuration() {
        if (this.iZA == null || !this.lUE) {
            this.lr = -1;
            return this.lr;
        } else if (this.lr > 0) {
            return this.lr;
        } else {
            this.lr = this.iZA.getDuration();
            return this.lr;
        }
    }

    public final int getCurrentPosition() {
        if (this.iZA == null || !this.lUE) {
            return 0;
        }
        return this.iZA.getCurrentPosition();
    }

    public final boolean isPlaying() {
        if (this.iZA == null || !this.lUE) {
            return false;
        }
        return this.iZA.isPlaying();
    }

    public final void fD(boolean z) {
        if (this.iZA != null) {
            this.iZA.setLooping(z);
        }
    }

    public final void a(a aVar) {
        this.iVc = aVar;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        if (this.iZA == null || !this.lUE) {
            this.lUF = true;
        } else {
            this.iZA.start();
            this.lUF = false;
        }
        return true;
    }

    public final boolean h(Context context, boolean z) {
        return start();
    }

    public final double aPB() {
        return 0.0d;
    }

    public final void i(double d) {
        if (this.iZA != null) {
            v.d("MicroMsg.VideoSurfaceView", "seek to time: " + d);
            this.iZA.seekTo((int) d);
            start();
        }
    }

    public final void fE(boolean z) {
    }

    public final long aPC() {
        return 0;
    }

    public final void dJ(boolean z) {
        this.eJx = z;
        if (this.iZA == null) {
            return;
        }
        if (this.eJx) {
            this.iZA.setVolume(0.0f, 0.0f);
        } else {
            this.iZA.setVolume(0.5f, 0.5f);
        }
    }
}

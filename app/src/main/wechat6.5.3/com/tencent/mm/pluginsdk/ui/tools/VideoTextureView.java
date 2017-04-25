package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mmdb.database.SQLiteDatabase;

@TargetApi(14)
public class VideoTextureView extends MMTextureView implements g {
    private int cfd;
    private int cfe;
    private boolean eJx;
    private int eww;
    private int ewx;
    private boolean gFD;
    private Surface huh;
    public com.tencent.mm.pluginsdk.ui.tools.g.a iVc;
    private MediaPlayer iZA;
    public String lUD;
    private boolean lUE;
    private boolean lUF;
    OnVideoSizeChangedListener lUG;
    OnPreparedListener lUH;
    private OnCompletionListener lUI;
    private OnErrorListener lUJ;
    public a lUM;
    private long lUN;
    public boolean lUO;
    private OnSeekCompleteListener lUP;
    private long lUQ;
    SurfaceTextureListener lUR;
    private b lUS;
    private int lr;
    private long startTime;

    public interface a {
        void aBK();
    }

    private class b {
        int eww;
        int ewx;
        int gef;
        int geg;
        final /* synthetic */ VideoTextureView lUU;
        int lUV;
        int lUW;

        private b(VideoTextureView videoTextureView) {
            this.lUU = videoTextureView;
        }
    }

    static /* synthetic */ void d(VideoTextureView videoTextureView) {
        LayoutParams layoutParams = (LayoutParams) videoTextureView.getLayoutParams();
        layoutParams.addRule(13);
        videoTextureView.setLayoutParams(layoutParams);
    }

    public VideoTextureView(Context context) {
        this(context, null);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.huh = null;
        this.iZA = null;
        this.startTime = 0;
        this.lUN = 0;
        this.eww = 0;
        this.ewx = 0;
        this.gFD = false;
        this.lUO = false;
        this.lUG = new OnVideoSizeChangedListener(this) {
            final /* synthetic */ VideoTextureView lUU;

            {
                this.lUU = r1;
            }

            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                try {
                    if (mediaPlayer != this.lUU.iZA) {
                        v.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", mediaPlayer, this.lUU.iZA);
                        return;
                    }
                    this.lUU.cfd = mediaPlayer.getVideoWidth();
                    this.lUU.cfe = mediaPlayer.getVideoHeight();
                    v.v("MicroMsg.VideoTextureView", "on size change size:( " + this.lUU.cfd + " , " + this.lUU.cfe + " )");
                    VideoTextureView.d(this.lUU);
                } catch (Throwable e) {
                    v.a("MicroMsg.VideoTextureView", e, "on video size changed error[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
                }
            }
        };
        this.lUH = new OnPreparedListener(this) {
            final /* synthetic */ VideoTextureView lUU;

            {
                this.lUU = r1;
            }

            public final void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer == this.lUU.iZA || mediaPlayer == null) {
                    this.lUU.lUE = true;
                    this.lUU.cfd = mediaPlayer.getVideoWidth();
                    this.lUU.cfe = mediaPlayer.getVideoHeight();
                    v.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", Integer.valueOf(this.lUU.cfd), Integer.valueOf(this.lUU.cfe), Boolean.valueOf(this.lUU.lUF));
                    VideoTextureView.d(this.lUU);
                    if (this.lUU.cfd == 0 || this.lUU.cfe == 0) {
                        if (this.lUU.lUF) {
                            this.lUU.iZA.start();
                            this.lUU.lUF = false;
                            this.lUU.iZA.setLooping(this.lUU.gFD);
                        }
                    } else if (this.lUU.lUF) {
                        this.lUU.iZA.start();
                        this.lUU.iZA.setLooping(this.lUU.gFD);
                        this.lUU.lUF = false;
                    }
                    if (this.lUU.iVc != null) {
                        this.lUU.iVc.abH();
                        return;
                    }
                    return;
                }
                v.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", mediaPlayer, this.lUU.iZA);
                this.lUU.a(mediaPlayer);
            }
        };
        this.lUP = new OnSeekCompleteListener(this) {
            final /* synthetic */ VideoTextureView lUU;

            {
                this.lUU = r1;
            }

            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                if (mediaPlayer != null) {
                    v.i("MicroMsg.VideoTextureView", "video seek complete curPos:" + mediaPlayer.getCurrentPosition());
                }
                if (this.lUU.lUF) {
                    this.lUU.start();
                }
            }
        };
        this.lUI = new OnCompletionListener(this) {
            final /* synthetic */ VideoTextureView lUU;

            {
                this.lUU = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                v.i("MicroMsg.VideoTextureView", "video on completion");
                this.lUU.lUN = be.Nh();
                if (this.lUU.iVc != null) {
                    this.lUU.iVc.pa();
                }
            }
        };
        this.lUJ = new OnErrorListener(this) {
            final /* synthetic */ VideoTextureView lUU;

            {
                this.lUU = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                v.w("MicroMsg.VideoTextureView", "Error: " + i + "," + i2);
                if (this.lUU.iVc != null) {
                    this.lUU.iVc.bp(i, i2);
                }
                return true;
            }
        };
        this.lUQ = 0;
        this.lUR = new SurfaceTextureListener(this) {
            final /* synthetic */ VideoTextureView lUU;

            {
                this.lUU = r1;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (this.lUU.lUQ > 0 && this.lUU.lUM != null) {
                    this.lUU.lUM.aBK();
                    this.lUU.lUM = null;
                }
                this.lUU.lUQ = System.currentTimeMillis();
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                v.i("MicroMsg.VideoTextureView", "on texture size changed width : " + i + " height : " + i2);
                if (this.lUU.iZA != null && this.lUU.lUE && this.lUU.cfd == i && this.lUU.cfe == i2) {
                    this.lUU.iZA.start();
                }
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                v.i("MicroMsg.VideoTextureView", "on texture destroyed");
                this.lUU.huh = null;
                this.lUU.bqZ();
                return false;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                v.i("MicroMsg.VideoTextureView", "on texture available %d*%d", Integer.valueOf(i), Integer.valueOf(i2));
                this.lUU.eww = i;
                this.lUU.ewx = i2;
                this.lUU.bCE();
                this.lUU.huh = new Surface(surfaceTexture);
                this.lUU.bqY();
            }
        };
        this.eJx = false;
        this.lUS = new b();
        this.cfd = 0;
        this.cfe = 0;
        setSurfaceTextureListener(this.lUR);
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
        long j;
        long j2 = this.lUN > 0 ? this.lUN - this.startTime : 2147483647L;
        long Nh = be.Nh() - this.startTime;
        if (j2 > Nh) {
            j = Nh;
        } else {
            j = j2;
        }
        int i = ((int) j) * 1000;
        if (i > getDuration()) {
            i = getDuration();
        }
        v.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", Integer.valueOf(getDuration()), Long.valueOf(Nh), Long.valueOf(j2));
        if (this.iVc != null) {
            this.iVc.bq(i, getDuration());
        }
        bqZ();
        this.lUD = SQLiteDatabase.KeyEmpty;
        this.lUE = false;
        this.lUF = false;
        this.lUQ = 0;
    }

    private void bqZ() {
        boolean z = true;
        String str = "MicroMsg.VideoTextureView";
        String str2 = "%d release media player isPrepared[%b] player is null[%b] stack[%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.lUE);
        if (this.iZA != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = be.bur();
        v.i(str, str2, objArr);
        if (this.iZA != null) {
            if (this.lUE) {
                a(this.iZA);
            }
            this.iZA.setOnVideoSizeChangedListener(null);
        }
        this.iZA = null;
    }

    private void a(final MediaPlayer mediaPlayer) {
        new Thread(this) {
            final /* synthetic */ VideoTextureView lUU;

            public final void run() {
                try {
                    if (mediaPlayer != null) {
                        v.i("MicroMsg.VideoTextureView", "%d another thread to release player[%s]", Integer.valueOf(this.lUU.hashCode()), mediaPlayer);
                        mediaPlayer.stop();
                        mediaPlayer.release();
                    }
                } catch (Exception e) {
                }
            }
        }.start();
    }

    private void bqY() {
        v.i("MicroMsg.VideoTextureView", "open video");
        if (!be.kS(this.lUD)) {
            bqZ();
            try {
                this.iZA = new MediaPlayer();
                this.iZA.setOnPreparedListener(this.lUH);
                this.iZA.setOnVideoSizeChangedListener(this.lUG);
                this.lUE = false;
                v.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
                this.lr = -1;
                this.iZA.setOnCompletionListener(this.lUI);
                this.iZA.setOnErrorListener(this.lUJ);
                this.iZA.setOnSeekCompleteListener(this.lUP);
                this.iZA.setDataSource(this.lUD);
                this.iZA.setSurface(this.huh);
                this.iZA.setAudioStreamType(d.rh());
                this.iZA.setScreenOnWhilePlaying(true);
                this.iZA.prepareAsync();
                this.cfe = this.iZA.getVideoHeight();
                this.cfd = this.iZA.getVideoWidth();
                dJ(this.eJx);
            } catch (Throwable e) {
                v.a("MicroMsg.VideoTextureView", e, "prepare async error %s", e.getMessage());
                if (this.iVc != null) {
                    this.iVc.bp(-1, -1);
                }
            }
        }
    }

    public final void pause() {
        if (this.iZA != null && this.lUE && this.iZA.isPlaying()) {
            v.d("MicroMsg.VideoTextureView", "pause video.");
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
        if (this.iZA != null && this.lUE) {
            int currentPosition = this.iZA.getCurrentPosition();
            v.d("MicroMsg.VideoTextureView", "getCurrentPosition : " + currentPosition);
            return currentPosition;
        } else if (this.iZA == null) {
            return -1;
        } else {
            return 0;
        }
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
        this.gFD = true;
    }

    public final void a(com.tencent.mm.pluginsdk.ui.tools.g.a aVar) {
        this.iVc = aVar;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        this.startTime = this.startTime == 0 ? be.Nh() : this.startTime;
        v.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b", Long.valueOf(this.startTime), Boolean.valueOf(this.lUE));
        if (this.iZA != null && this.lUE) {
            this.iZA.start();
        } else if (this.iZA == null && this.lUE) {
            this.lUF = true;
            bqY();
            requestLayout();
            return true;
        }
        this.lUF = true;
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
            this.iZA.seekTo((int) d);
            this.lUF = true;
            v.d("MicroMsg.VideoTextureView", "seek to time: " + d + " curr pos : " + this.iZA.getCurrentPosition());
        }
    }

    public final void fE(boolean z) {
    }

    public final long aPC() {
        return this.lUQ;
    }

    public final void dJ(boolean z) {
        v.i("MicroMsg.VideoTextureView", "%d set mute %b", Integer.valueOf(hashCode()), Boolean.valueOf(z));
        this.eJx = z;
        if (this.iZA == null) {
            return;
        }
        if (this.eJx) {
            this.iZA.setVolume(0.0f, 0.0f);
        } else {
            this.iZA.setVolume(1.0f, 1.0f);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.cfd == 0 || this.cfe == 0) {
            setMeasuredDimension(1, 1);
            return;
        }
        int defaultSize = getDefaultSize(1, i);
        int defaultSize2 = getDefaultSize(1, i2);
        int i3 = this.cfd;
        int i4 = this.cfe;
        b bVar = this.lUS;
        if (!(bVar.eww == defaultSize && bVar.ewx == defaultSize2 && bVar.geg == i3 && bVar.gef == i4)) {
            bVar.eww = defaultSize;
            bVar.ewx = defaultSize2;
            bVar.geg = i3;
            bVar.gef = i4;
            float f = (((float) bVar.geg) * 1.0f) / ((float) bVar.gef);
            float f2 = (((float) bVar.eww) * 1.0f) / ((float) bVar.ewx);
            if (bVar.lUU.lUO) {
                if (((double) Math.abs(f - f2)) > 0.05d) {
                    if (bVar.eww < bVar.ewx) {
                        bVar.lUW = (int) (((float) bVar.eww) / f);
                        bVar.lUV = bVar.eww;
                    } else {
                        bVar.lUV = (int) (((float) bVar.ewx) * f);
                        bVar.lUW = bVar.ewx;
                    }
                } else if (bVar.eww > bVar.ewx) {
                    bVar.lUW = (int) (((float) bVar.eww) / f);
                    bVar.lUV = bVar.eww;
                } else {
                    bVar.lUV = (int) (((float) bVar.ewx) * f);
                    bVar.lUW = bVar.ewx;
                }
            } else if (bVar.eww < bVar.ewx) {
                bVar.lUW = (int) (((float) bVar.eww) / f);
                bVar.lUV = bVar.eww;
            } else {
                bVar.lUV = (int) (((float) bVar.ewx) * f);
                bVar.lUW = bVar.ewx;
            }
            v.d("MicroMsg.VideoTextureView", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(bVar.eww), Integer.valueOf(bVar.ewx), Integer.valueOf(bVar.geg), Integer.valueOf(bVar.gef), Integer.valueOf(bVar.lUV), Integer.valueOf(bVar.lUW), Float.valueOf(f2), Float.valueOf(f));
        }
        setMeasuredDimension(this.lUS.lUV, this.lUS.lUW);
    }
}

package com.tencent.mm.ui.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public class VideoView extends SurfaceView {
    private int cfd;
    private int cfe;
    public OnCompletionListener djc;
    public OnErrorListener djd;
    private SurfaceHolder hui;
    public int hvs;
    public MediaPlayer iZA;
    public String lUD;
    public boolean lUE;
    public boolean lUF;
    OnVideoSizeChangedListener lUG;
    OnPreparedListener lUH;
    private OnCompletionListener lUI;
    private OnErrorListener lUJ;
    Callback lUK;
    private int lr;
    private Context mContext;
    private int oYv;
    private int oYw;
    public OnPreparedListener oYx;
    private int oYy;
    private OnBufferingUpdateListener oYz;

    public final void bJT() {
        if (this.cfe != 0 && this.cfd != 0) {
            int i;
            int i2 = this.cfd;
            int i3 = this.cfe;
            v.v("MicroMsg.VideoView", "video size before:" + i2 + "   " + i3);
            v.v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
            int width = getWidth();
            int height = getHeight();
            if (width <= 0) {
                i = i2;
            } else {
                i = width;
            }
            if (height <= 0) {
                width = i3;
            } else {
                width = height;
            }
            float f = (((float) i) * 1.0f) / ((float) i2);
            float f2 = (((float) width) * 1.0f) / ((float) i3);
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            if (f > f2) {
                layoutParams.width = (int) (((float) i2) * f2);
                layoutParams.height = width;
            } else {
                layoutParams.width = i;
                layoutParams.height = (int) (((float) i3) * f);
            }
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
            invalidate();
            v.v("MicroMsg.VideoView", "video size after:" + this.iZA.getVideoWidth() + "   " + this.iZA.getVideoHeight());
            v.v("MicroMsg.VideoView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        }
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
        aBp();
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hui = null;
        this.iZA = null;
        this.lUG = new OnVideoSizeChangedListener(this) {
            final /* synthetic */ VideoView oYA;

            {
                this.oYA = r1;
            }

            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                this.oYA.cfd = mediaPlayer.getVideoWidth();
                this.oYA.cfe = mediaPlayer.getVideoHeight();
                v.v("MicroMsg.VideoView", "on size change size:( " + this.oYA.cfd + " , " + this.oYA.cfe + " )");
                this.oYA.bJT();
            }
        };
        this.lUH = new OnPreparedListener(this) {
            final /* synthetic */ VideoView oYA;

            {
                this.oYA = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onPrepared(android.media.MediaPlayer r3) {
                /*
                r2 = this;
                r0 = r2.oYA;
                r0.lUE = true;
                r0 = r2.oYA;
                r0 = r0.oYx;
                if (r0 == 0) goto L_0x001c;
            L_0x000d:
                r0 = r2.oYA;
                r0 = r0.oYx;
                r1 = r2.oYA;
                r1 = r1.iZA;
                r0.onPrepared(r1);
            L_0x001c:
                r0 = r2.oYA;
                r1 = r3.getVideoWidth();
                r0.cfd = r1;
                r0 = r2.oYA;
                r1 = r3.getVideoHeight();
                r0.cfe = r1;
                r0 = r2.oYA;
                r0.bJT();
                r0 = r2.oYA;
                r0 = r0.cfd;
                if (r0 == 0) goto L_0x00c7;
            L_0x003b:
                r0 = r2.oYA;
                r0 = r0.cfe;
                if (r0 == 0) goto L_0x00c7;
            L_0x0043:
                r0 = r2.oYA;
                r0 = r0.lUF;
                if (r0 == 0) goto L_0x0059;
            L_0x004b:
                r0 = r2.oYA;
                r0 = r0.iZA;
                r0.start();
                r0 = r2.oYA;
                r0.lUF = false;
            L_0x0059:
                r0 = r2.oYA;
                r0 = r0.oYv;
                r1 = r2.oYA;
                r1 = r1.cfd;
                if (r0 != r1) goto L_0x00bb;
            L_0x0067:
                r0 = r2.oYA;
                r0 = r0.oYw;
                r1 = r2.oYA;
                r1 = r1.cfe;
                if (r0 != r1) goto L_0x00bb;
            L_0x0075:
                r0 = r2.oYA;
                r0 = r0.hvs;
                if (r0 == 0) goto L_0x0091;
            L_0x007d:
                r0 = r2.oYA;
                r0 = r0.iZA;
                r1 = r2.oYA;
                r1 = r1.hvs;
                r0.seekTo(r1);
                r0 = r2.oYA;
                r0.hvs = 0;
            L_0x0091:
                r0 = r2.oYA;
                r0 = r0.lUF;
                if (r0 != 0) goto L_0x00bb;
            L_0x0099:
                r0 = r2.oYA;
                r0 = r0.isPlaying();
                if (r0 != 0) goto L_0x00bb;
            L_0x00a1:
                r0 = r2.oYA;
                r0 = r0.hvs;
                if (r0 != 0) goto L_0x00bb;
            L_0x00a9:
                r0 = r2.oYA;
                r1 = r0.iZA;
                if (r1 == 0) goto L_0x00c5;
            L_0x00af:
                r1 = r0.lUE;
                if (r1 == 0) goto L_0x00c5;
            L_0x00b3:
                r0 = r0.iZA;
                r0 = r0.getCurrentPosition();
            L_0x00b9:
                if (r0 <= 0) goto L_0x00bb;
            L_0x00bb:
                r0 = r2.oYA;
                r0 = r0.iZA;
                r0.isPlaying();
                return;
            L_0x00c5:
                r0 = 0;
                goto L_0x00b9;
            L_0x00c7:
                r0 = r2.oYA;
                r0 = r0.hvs;
                if (r0 == 0) goto L_0x00e3;
            L_0x00cf:
                r0 = r2.oYA;
                r0 = r0.iZA;
                r1 = r2.oYA;
                r1 = r1.hvs;
                r0.seekTo(r1);
                r0 = r2.oYA;
                r0.hvs = 0;
            L_0x00e3:
                r0 = r2.oYA;
                r0 = r0.lUF;
                if (r0 == 0) goto L_0x00bb;
            L_0x00eb:
                r0 = r2.oYA;
                r0 = r0.iZA;
                r0.start();
                r0 = r2.oYA;
                r0.lUF = false;
                goto L_0x00bb;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.video.VideoView.2.onPrepared(android.media.MediaPlayer):void");
            }
        };
        this.lUI = new OnCompletionListener(this) {
            final /* synthetic */ VideoView oYA;

            {
                this.oYA = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (this.oYA.djc != null) {
                    this.oYA.djc.onCompletion(this.oYA.iZA);
                }
            }
        };
        this.lUJ = new OnErrorListener(this) {
            final /* synthetic */ VideoView oYA;

            {
                this.oYA = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                v.d("MicroMsg.VideoView", "Error: " + i + "," + i2);
                if (this.oYA.djd == null || !this.oYA.djd.onError(this.oYA.iZA, i, i2)) {
                    this.oYA.getWindowToken();
                }
                return true;
            }
        };
        this.oYz = new OnBufferingUpdateListener(this) {
            final /* synthetic */ VideoView oYA;

            {
                this.oYA = r1;
            }

            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                this.oYA.oYy = i;
            }
        };
        this.lUK = new Callback(this) {
            final /* synthetic */ VideoView oYA;

            {
                this.oYA = r1;
            }

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                this.oYA.oYv = i2;
                this.oYA.oYw = i3;
                if (this.oYA.iZA != null && this.oYA.lUE && this.oYA.cfd == i2 && this.oYA.cfe == i3) {
                    if (this.oYA.hvs != 0) {
                        this.oYA.iZA.seekTo(this.oYA.hvs);
                        this.oYA.hvs = 0;
                    }
                    this.oYA.iZA.start();
                }
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                this.oYA.hui = surfaceHolder;
                this.oYA.bqY();
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                this.oYA.hui = null;
                if (this.oYA.iZA != null) {
                    this.oYA.iZA.reset();
                    this.oYA.iZA.release();
                    this.oYA.iZA = null;
                }
            }
        };
        this.mContext = context;
        aBp();
    }

    private void aBp() {
        this.cfd = 0;
        this.cfe = 0;
        getHolder().addCallback(this.lUK);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public final void stopPlayback() {
        if (this.iZA != null) {
            this.iZA.stop();
            this.iZA.release();
            this.iZA = null;
        }
    }

    public final void bqY() {
        if (this.lUD != null && this.hui != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            this.mContext.sendBroadcast(intent);
            if (this.iZA != null) {
                this.iZA.reset();
                this.iZA.release();
                this.iZA = null;
            }
            try {
                this.iZA = new MediaPlayer();
                this.iZA.setOnPreparedListener(this.lUH);
                this.iZA.setOnVideoSizeChangedListener(this.lUG);
                this.lUE = false;
                v.v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
                this.lr = -1;
                this.iZA.setOnCompletionListener(this.lUI);
                this.iZA.setOnErrorListener(this.lUJ);
                this.iZA.setOnBufferingUpdateListener(this.oYz);
                this.oYy = 0;
                this.iZA.setDataSource(this.lUD);
                this.iZA.setDisplay(this.hui);
                this.iZA.setAudioStreamType(3);
                this.iZA.setScreenOnWhilePlaying(true);
                this.iZA.prepareAsync();
                this.cfe = this.iZA.getVideoHeight();
                this.cfd = this.iZA.getVideoWidth();
            } catch (IOException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }

    public final boolean isPlaying() {
        if (this.iZA == null || !this.lUE) {
            return false;
        }
        return this.iZA.isPlaying();
    }
}

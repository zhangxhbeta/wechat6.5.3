package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMTextureView;

@TargetApi(14)
public class SightVideoTextureView extends SightCameraView {
    private String iTJ;
    private MediaPlayer iZA;
    SurfaceTexture iZK;
    private TextureView jag;
    private Surface jah;
    private boolean jai;
    private boolean jaj;

    public SightVideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jag = null;
        this.iZK = null;
        this.jah = null;
        this.jag = (TextureView) findViewById(2131759200);
        this.jag.setSurfaceTextureListener(new SurfaceTextureListener(this) {
            final /* synthetic */ SightVideoTextureView jak;

            {
                this.jak = r1;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                v.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureAvailable, [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.jak.iZS = b.jac;
                this.jak.iZK = surfaceTexture;
                ((MMTextureView) this.jak.jag).bCE();
                v.i("MicroMsg.SightVideoTextureView", "available texture %s, wantPlay %B", new Object[]{surfaceTexture, Boolean.valueOf(this.jak.jaj)});
                if (this.jak.jaj) {
                    this.jak.ah(this.jak.iTJ, this.jak.jai);
                }
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                v.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureSizeChanged, [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.jak.iZS = b.jad;
                v.i("MicroMsg.SightVideoTextureView", "changed texture %s", new Object[]{surfaceTexture});
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                v.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureDestroyed");
                this.jak.iZS = b.jae;
                this.jak.iZK = null;
                this.jak.iZT = false;
                v.i("MicroMsg.SightVideoTextureView", "destroyed texture %s", new Object[]{surfaceTexture});
                return true;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    public SightVideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected final void aQu() {
    }

    public final void aQw() {
    }

    protected final void fK(boolean z) {
        if (this.iZA != null) {
            try {
                if (!this.iZA.isPlaying()) {
                    return;
                }
                if (z) {
                    try {
                        this.iZA.setVolume(0.0f, 0.0f);
                        return;
                    } catch (Exception e) {
                        v.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 0, 0 Fail: %s", new Object[]{e.getMessage()});
                        return;
                    }
                }
                aQG();
                try {
                    this.iZA.setVolume(1.0f, 1.0f);
                } catch (Exception e2) {
                    v.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 1, 1 Fail: %s", new Object[]{e2.getMessage()});
                }
            } catch (Exception e22) {
                v.w("MicroMsg.SightVideoTextureView", "setIsMute %B, check MediaPlayer playing Fail: %s", new Object[]{Boolean.valueOf(z), e22.getMessage()});
            }
        }
    }

    public final void ah(final String str, final boolean z) {
        v.i("MicroMsg.SightVideoTextureView", "start play video, path %s, mute %B, wantPlay %B", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(this.jaj)});
        this.iTJ = str;
        this.jai = z;
        if (this.iZK == null) {
            v.w("MicroMsg.SightVideoTextureView", "play video fail, texture is null");
            this.jaj = true;
            return;
        }
        this.jaj = false;
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ SightVideoTextureView jak;

            public final void run() {
                if (this.jak.iZA != null) {
                    try {
                        this.jak.iZA.stop();
                        this.jak.iZA.release();
                    } catch (Throwable e) {
                        v.a("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
                        v.w("MicroMsg.SightVideoTextureView", "try to release mediaplayer error");
                    }
                }
                try {
                    this.jak.iZA = new MediaPlayer();
                    this.jak.iZA.setOnCompletionListener(new OnCompletionListener(this) {
                        final /* synthetic */ AnonymousClass2 jal;

                        {
                            this.jal = r1;
                        }

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            v.i("MicroMsg.SightVideoTextureView", "complete playing %s ", new Object[]{str});
                            this.jal.jak.aQH();
                        }
                    });
                    this.jak.iZA.setOnErrorListener(new OnErrorListener(this) {
                        final /* synthetic */ AnonymousClass2 jal;

                        {
                            this.jal = r1;
                        }

                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            v.i("MicroMsg.SightVideoTextureView", "play %s error", new Object[]{str});
                            return false;
                        }
                    });
                    this.jak.iZA.setDataSource(str);
                    SightVideoTextureView sightVideoTextureView = this.jak;
                    SightVideoTextureView sightVideoTextureView2 = this.jak;
                    sightVideoTextureView.jah = sightVideoTextureView2.iZK != null ? new Surface(sightVideoTextureView2.iZK) : null;
                    this.jak.iZA.setSurface(this.jak.jah);
                    this.jak.iZA.setAudioStreamType(3);
                    if (z) {
                        this.jak.iZA.setVolume(0.0f, 0.0f);
                    } else {
                        this.jak.aQG();
                    }
                    this.jak.iZA.setScreenOnWhilePlaying(true);
                    this.jak.iZA.setLooping(true);
                    this.jak.iZA.prepare();
                    this.jak.iZA.start();
                } catch (Throwable e2) {
                    v.e("MicroMsg.SightVideoTextureView", "play %s, error: %s, %s", new Object[]{str, e2.getMessage(), be.e(e2)});
                }
            }

            public final String toString() {
                return super.toString() + "|playVideo";
            }
        });
    }

    public final boolean isPlaying() {
        boolean z = false;
        try {
            if (this.iZA != null) {
                z = this.iZA.isPlaying();
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
        }
        return z;
    }

    public final void aQz() {
        v.i("MicroMsg.SightVideoTextureView", "stop play video, wantPlay %B", new Object[]{Boolean.valueOf(this.jaj)});
        if (this.iZA != null || this.jaj) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ SightVideoTextureView jak;

                {
                    this.jak = r1;
                }

                public final void run() {
                    try {
                        this.jak.aQH();
                        this.jak.iZA.stop();
                        this.jak.iZA.release();
                        if (this.jak.jah != null && this.jak.jah.isValid()) {
                            this.jak.jah.release();
                            this.jak.jah = null;
                        }
                    } catch (Throwable e) {
                        v.w("MicroMsg.SightVideoTextureView", "stop play video error: %s, %s", new Object[]{e.getMessage(), be.e(e)});
                    }
                    this.jak.iZA = null;
                }

                public final String toString() {
                    return super.toString() + "|stopPlayVideo";
                }
            });
        } else {
            v.w("MicroMsg.SightVideoTextureView", "mediaplayer is null, do nothing when stop play video");
        }
    }

    protected final void aQv() {
    }

    protected final int aQx() {
        if (this.jag != null) {
            return this.jag.getWidth();
        }
        return 0;
    }

    protected final int aQy() {
        if (this.jag != null) {
            return this.jag.getHeight();
        }
        return 0;
    }

    public final void Y(float f) {
        LayoutParams layoutParams = this.jag.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        v.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate [%f], dm[%d, %d]", new Object[]{Float.valueOf(f), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)});
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f);
        v.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate width:%d, height:%d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
        this.jag.setLayoutParams(layoutParams);
        super.Z(f);
    }
}

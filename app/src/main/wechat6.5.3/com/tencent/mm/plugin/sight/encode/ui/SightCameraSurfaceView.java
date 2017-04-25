package com.tencent.mm.plugin.sight.encode.ui;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public class SightCameraSurfaceView extends SightCameraView {
    private boolean cls;
    private SurfaceHolder hui;
    private MediaPlayer iZA;
    private SurfaceView iZB;
    private Callback iZC;

    public SightCameraSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iZB = null;
        this.hui = null;
        this.cls = false;
        this.iZC = new Callback(this) {
            final /* synthetic */ SightCameraSurfaceView iZD;

            {
                this.iZD = r1;
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                v.d("MicroMsg.SightCameraSurfaceView", "surfaceCreated");
                this.iZD.iZS = b.CREATE;
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                v.d("MicroMsg.SightCameraSurfaceView", "surfaceDestroyed");
                this.iZD.iZS = b.DESTORY;
                this.iZD.iZT = false;
                this.iZD.aQv();
                v.d("MicroMsg.SightCameraSurfaceView", "surfaceDestroyed end");
            }

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                v.d("MicroMsg.SightCameraSurfaceView", "surfaceChanged for:" + i + " w:" + i2 + " h:" + i3);
                this.iZD.iZS = b.CHANGED;
                if (this.iZD.getVisibility() == 0 && this.iZD.iYh) {
                    v.i("MicroMsg.SightCameraSurfaceView", "current view is visible, try preview camera");
                    this.iZD.aQu();
                }
                v.d("MicroMsg.SightCameraSurfaceView", "surfaceChanged end");
            }
        };
        long currentTimeMillis = System.currentTimeMillis();
        this.iZB = (SurfaceView) findViewById(2131759200);
        v.d("MicroMsg.SightCameraSurfaceView", "inflate view use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        long currentTimeMillis2 = System.currentTimeMillis();
        this.hui = this.iZB.getHolder();
        this.hui.addCallback(this.iZC);
        this.hui.setType(3);
        v.d("MicroMsg.SightCameraSurfaceView", "init surface holder use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
    }

    public SightCameraSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SightCameraSurfaceView(Context context) {
        this(context, null, 0);
    }

    protected final void aQu() {
        v.i("MicroMsg.SightCameraSurfaceView", "try preview camera");
        if (getVisibility() != 0) {
            v.w("MicroMsg.SightCameraSurfaceView", "error visibility");
        } else if (b.CHANGED != this.iZS) {
            v.w("MicroMsg.SightCameraSurfaceView", "error surfaceStatus %s", this.iZS.toString());
        } else {
            aQz();
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ SightCameraSurfaceView iZD;

                {
                    this.iZD = r1;
                }

                public final void run() {
                    if (!(this.iZD.getContext() instanceof Activity)) {
                        this.iZD.aQI();
                        v.e("MicroMsg.SightCameraSurfaceView", "bug???");
                    } else if (this.iZD.iZN.L((Activity) this.iZD.getContext()) != 0) {
                        this.iZD.iZT = false;
                        this.iZD.aQI();
                    } else if (this.iZD.iZN.a(this.iZD.hui) != 0) {
                        this.iZD.iZT = false;
                        this.iZD.aQJ();
                    } else {
                        this.iZD.iZT = true;
                        v.d("MicroMsg.SightCameraSurfaceView", "preview camera ok");
                        final LayoutParams layoutParams = this.iZD.iZB.getLayoutParams();
                        DisplayMetrics displayMetrics = this.iZD.getResources().getDisplayMetrics();
                        int i;
                        int i2;
                        if (d.dX(14)) {
                            i = this.iZD.iZN.hmu.lFq;
                            v.i("MicroMsg.SightCameraSurfaceView", "below 4.0, resizeLayout priveview[%d, %d], dm[%d, %d]", Integer.valueOf(this.iZD.iZN.hmu.lFr), Integer.valueOf(i), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
                            layoutParams.width = displayMetrics.widthPixels;
                            layoutParams.height = (displayMetrics.widthPixels * i) / i2;
                        } else {
                            i = this.iZD.iZN.hmu.lFr;
                            i2 = this.iZD.iZN.hmu.lFq;
                            v.i("MicroMsg.SightCameraSurfaceView", "resizeLayout priveview[%d, %d], dm[%d, %d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
                            layoutParams.width = (displayMetrics.widthPixels * i2) / this.iZD.hoQ;
                            layoutParams.height = (layoutParams.width * i) / i2;
                        }
                        v.i("MicroMsg.SightCameraSurfaceView", "resizeLayout width:%d, height:%d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                        if (!this.iZD.cls) {
                            this.iZD.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 iZF;

                                public final void run() {
                                    this.iZF.iZD.iZB.setLayoutParams(layoutParams);
                                    if (this.iZF.iZD.iZV != null) {
                                        this.iZF.iZD.iZV.aQb();
                                    }
                                    this.iZF.iZD.w((float) (this.iZF.iZD.getMeasuredWidth() / 2), (float) (this.iZF.iZD.getMeasuredHeight() / 2));
                                }
                            });
                            this.iZD.cls = true;
                        }
                    }
                }

                public final String toString() {
                    return super.toString() + "|tryPreviewCamera";
                }
            });
        }
    }

    protected final void aQv() {
        v.i("MicroMsg.SightCameraSurfaceView", "try close camera");
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ SightCameraSurfaceView iZD;

            {
                this.iZD = r1;
            }

            public final void run() {
                this.iZD.iZN.azR();
            }

            public final String toString() {
                return super.toString() + "|tryCloseCamera";
            }
        });
    }

    public final void aQw() {
        super.aQw();
        this.cls = false;
    }

    protected final int aQx() {
        if (this.iZB != null) {
            return this.iZB.getWidth();
        }
        return 0;
    }

    protected final int aQy() {
        if (this.iZB != null) {
            return this.iZB.getHeight();
        }
        return 0;
    }

    protected final void fK(boolean z) {
        if (this.iZA != null && this.iZA.isPlaying()) {
            if (z) {
                this.iZA.setVolume(0.0f, 0.0f);
                return;
            }
            aQG();
            this.iZA.setVolume(1.0f, 1.0f);
        }
    }

    public final void ah(final String str, final boolean z) {
        if (this.hui == null) {
            v.w("MicroMsg.SightCameraSurfaceView", "play video fail, surface holder is null");
            return;
        }
        super.aLn();
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ SightCameraSurfaceView iZD;

            public final void run() {
                if (this.iZD.iZA != null) {
                    try {
                        this.iZD.iZA.stop();
                        this.iZD.iZA.release();
                    } catch (Throwable e) {
                        v.a("MicroMsg.SightCameraSurfaceView", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.w("MicroMsg.SightCameraSurfaceView", "try to release mediaplayer error");
                    }
                }
                if (b.DESTORY == this.iZD.iZS) {
                    v.e("MicroMsg.SightCameraSurfaceView", "play video %s Error, surfaceStatus is destory", str);
                    return;
                }
                try {
                    this.iZD.iZA = new MediaPlayer();
                    this.iZD.iZA.setOnCompletionListener(new OnCompletionListener(this) {
                        final /* synthetic */ AnonymousClass4 iZI;

                        {
                            this.iZI = r1;
                        }

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            v.i("MicroMsg.SightCameraSurfaceView", "complete playing %s ", str);
                            this.iZI.iZD.aQH();
                        }
                    });
                    this.iZD.iZA.setOnErrorListener(new OnErrorListener(this) {
                        final /* synthetic */ AnonymousClass4 iZI;

                        {
                            this.iZI = r1;
                        }

                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            v.i("MicroMsg.SightCameraSurfaceView", "play %s error", str);
                            return false;
                        }
                    });
                    this.iZD.iZA.setDataSource(str);
                    this.iZD.iZA.setDisplay(this.iZD.hui);
                    this.iZD.iZA.setAudioStreamType(3);
                    if (z) {
                        this.iZD.iZA.setVolume(0.0f, 0.0f);
                    } else {
                        this.iZD.aQG();
                    }
                    this.iZD.iZA.setScreenOnWhilePlaying(true);
                    this.iZD.iZA.setLooping(true);
                    this.iZD.iZA.prepare();
                    this.iZD.iZA.start();
                } catch (Throwable e2) {
                    v.e("MicroMsg.SightCameraSurfaceView", "play %s, error: %s, %s", str, e2.getMessage(), be.e(e2));
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
            v.a("MicroMsg.SightCameraSurfaceView", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return z;
    }

    public final void aQz() {
        if (this.iZA == null) {
            v.w("MicroMsg.SightCameraSurfaceView", "mediaplayer is null, do nothing when stop play video");
        } else {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ SightCameraSurfaceView iZD;

                {
                    this.iZD = r1;
                }

                public final void run() {
                    try {
                        this.iZD.aQH();
                        this.iZD.iZA.stop();
                        this.iZD.iZA.release();
                    } catch (Throwable e) {
                        v.w("MicroMsg.SightCameraSurfaceView", "stop play video error: %s, %s", e.getMessage(), be.e(e));
                    }
                    this.iZD.iZA = null;
                }

                public final String toString() {
                    return super.toString() + "|stopPlayVideo";
                }
            });
        }
    }

    public final void Y(float f) {
        LayoutParams layoutParams = this.iZB.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        v.i("MicroMsg.SightCameraSurfaceView", "setFixPreviewRate [%f], dm[%d, %d]", Float.valueOf(f), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f);
        v.i("MicroMsg.SightCameraSurfaceView", "setFixPreviewRate width:%d, height:%d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        this.iZB.setLayoutParams(layoutParams);
        super.Z(f);
    }
}

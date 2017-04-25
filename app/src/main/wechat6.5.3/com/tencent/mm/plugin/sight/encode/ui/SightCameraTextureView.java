package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMTextureView;

@TargetApi(14)
public class SightCameraTextureView extends SightCameraView {
    private boolean cls;
    private MMTextureView iZJ;
    private SurfaceTexture iZK;

    public SightCameraTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iZJ = null;
        this.iZK = null;
        this.cls = false;
        this.iZJ = (MMTextureView) findViewById(2131759200);
        this.iZJ.setSurfaceTextureListener(new SurfaceTextureListener(this) {
            final /* synthetic */ SightCameraTextureView iZL;

            {
                this.iZL = r1;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                v.i("MicroMsg.SightCameraTextureView", "onSurfaceTextureAvailable, [%d, %d], input SurfaceTexture %s, get SurfaceTexture %s", Integer.valueOf(i), Integer.valueOf(i2), surfaceTexture, this.iZL.iZJ.getSurfaceTexture());
                this.iZL.iZS = b.CREATE;
                this.iZL.iZJ.bCE();
                this.iZL.iZK = surfaceTexture;
                if (this.iZL.getVisibility() == 0 && this.iZL.iYh) {
                    v.i("MicroMsg.SightCameraTextureView", "current view is visible, try preview camera");
                    this.iZL.aQu();
                }
                v.i("MicroMsg.SightCameraTextureView", "onSurfaceTextureAvailable end, sly texture %s", this.iZL.iZK);
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                v.i("MicroMsg.SightCameraTextureView", "onSurfaceTextureSizeChanged, [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
                this.iZL.iZS = b.CHANGED;
                v.i("MicroMsg.SightCameraTextureView", "changed texture %s", surfaceTexture);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                v.i("MicroMsg.SightCameraTextureView", "onSurfaceTextureDestroyed");
                this.iZL.iZS = b.DESTORY;
                this.iZL.iZK = null;
                this.iZL.iZT = false;
                this.iZL.aQv();
                v.i("MicroMsg.SightCameraTextureView", "destroyed texture %s", surfaceTexture);
                return true;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    public SightCameraTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SightCameraTextureView(Context context) {
        this(context, null, 0);
    }

    protected final void aQu() {
        v.i("MicroMsg.SightCameraTextureView", "try preview camera");
        if (getVisibility() != 0) {
            v.w("MicroMsg.SightCameraTextureView", "error visibility");
        } else if (b.DESTORY == this.iZS) {
            v.w("MicroMsg.SightCameraTextureView", "error surfaceStatus %s", this.iZS.toString());
        } else {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ SightCameraTextureView iZL;

                {
                    this.iZL = r1;
                }

                public final void run() {
                    if (!(this.iZL.getContext() instanceof Activity)) {
                        this.iZL.aQI();
                        v.e("MicroMsg.SightCameraTextureView", "bug???");
                    } else if (this.iZL.iZN.L((Activity) this.iZL.getContext()) != 0) {
                        this.iZL.iZT = false;
                        this.iZL.aQI();
                    } else if (this.iZL.iZN.c(this.iZL.iZK) != 0) {
                        this.iZL.iZT = false;
                        this.iZL.aQJ();
                    } else {
                        this.iZL.iZT = true;
                        v.d("MicroMsg.SightCameraTextureView", "preview camera ok");
                        final LayoutParams layoutParams = this.iZL.iZJ.getLayoutParams();
                        DisplayMetrics displayMetrics = this.iZL.getResources().getDisplayMetrics();
                        int i = this.iZL.iZN.hmu.lFr;
                        int i2 = this.iZL.iZN.hmu.lFq;
                        v.i("MicroMsg.SightCameraTextureView", "resizeLayout priveview[%d, %d], dm[%d, %d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
                        layoutParams.width = (displayMetrics.widthPixels * i2) / this.iZL.hoQ;
                        layoutParams.height = (layoutParams.width * i) / i2;
                        v.i("MicroMsg.SightCameraTextureView", "resizeLayout width:%d, height:%d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                        if (!this.iZL.cls) {
                            this.iZL.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 iZM;

                                public final void run() {
                                    this.iZM.iZL.iZJ.setLayoutParams(layoutParams);
                                    if (this.iZM.iZL.iZV != null) {
                                        this.iZM.iZL.iZV.aQb();
                                    }
                                    this.iZM.iZL.w((float) (this.iZM.iZL.getMeasuredWidth() / 2), (float) (this.iZM.iZL.getMeasuredHeight() / 2));
                                }
                            });
                            this.iZL.cls = true;
                        }
                    }
                }

                public final String toString() {
                    return super.toString() + "|tryPreviewCamera";
                }
            });
        }
    }

    public final void aQw() {
        super.aQw();
        this.cls = false;
    }

    protected final void fK(boolean z) {
    }

    public final void ah(String str, boolean z) {
    }

    public final boolean isPlaying() {
        return false;
    }

    public final void aQz() {
    }

    protected final void aQv() {
        v.i("MicroMsg.SightCameraTextureView", "try close camera");
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ SightCameraTextureView iZL;

            {
                this.iZL = r1;
            }

            public final void run() {
                this.iZL.iZN.azR();
            }

            public final String toString() {
                return super.toString() + "|tryCloseCamera";
            }
        });
    }

    protected final int aQx() {
        if (this.iZJ != null) {
            return this.iZJ.getWidth();
        }
        return 0;
    }

    protected final int aQy() {
        if (this.iZJ != null) {
            return this.iZJ.getHeight();
        }
        return 0;
    }

    public final void Y(float f) {
        LayoutParams layoutParams = this.iZJ.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        v.i("MicroMsg.SightCameraTextureView", "setFixPreviewRate [%f], dm[%d, %d]", Float.valueOf(f), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f);
        v.i("MicroMsg.SightCameraTextureView", "setFixPreviewRate width:%d, height:%d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        this.iZJ.setLayoutParams(layoutParams);
        super.Z(f);
    }
}

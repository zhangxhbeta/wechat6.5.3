package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMTextureView;

public class MultiTalkVideoView extends MMTextureView implements SurfaceTextureListener {
    private static final int[] hCb = new int[]{452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private SurfaceTexture hCc;
    private Paint hCd;
    a hCe = a.None;
    private int hxK;
    private int hxL;
    int index;
    public int position;
    public String username;

    public enum a {
        Avatar,
        Video,
        None
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        NI();
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        NI();
    }

    private void NI() {
        this.hCd = new Paint();
        this.hCd.setColor(-16777216);
        this.hCd.setFilterBitmap(false);
        this.hCd.setTextSize(40.0f);
        setSurfaceTextureListener(this);
    }

    public final synchronized void a(int[] iArr, int i, int i2, int i3, int i4) {
        if (aCT()) {
            o.aCH().a(this, iArr, i, i2, i3, i4);
        }
    }

    public final synchronized void a(Bitmap bitmap, int i, int i2) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (!(this.hCc == null || this.hxK == 0 || this.hxL == 0)) {
                    Canvas lockCanvas = lockCanvas(null);
                    if (lockCanvas == null) {
                        v.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", new Object[]{this.username});
                    } else {
                        Matrix matrix = new Matrix();
                        if (i == OpenGlRender.kBx) {
                            matrix.setRotate(270.0f, (float) (width / 2), (float) (height / 2));
                        } else if (i == OpenGlRender.kBw) {
                            matrix.setRotate(90.0f, (float) (width / 2), (float) (height / 2));
                        }
                        if (i2 == OpenGlRender.kBy) {
                            matrix.postScale(-1.0f, 1.0f);
                            matrix.postTranslate((float) width, 0.0f);
                        }
                        matrix.postScale(((float) lockCanvas.getWidth()) / ((float) height), ((float) lockCanvas.getHeight()) / ((float) width));
                        lockCanvas.drawColor(0, Mode.CLEAR);
                        if (!bitmap.isRecycled()) {
                            lockCanvas.drawBitmap(bitmap, matrix, this.hCd);
                        }
                        try {
                            unlockCanvasAndPost(lockCanvas);
                        } catch (Throwable e) {
                            v.a("MicroMsg.MT.MultiTalkVideoView", e, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                        }
                    }
                }
            }
        }
        v.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
    }

    public final void aCO() {
        if (aCS()) {
            o.aCH().a(this, true);
        }
    }

    public final void aCP() {
        if (!be.kS(this.username)) {
            v.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", new Object[]{this.username, this.hCe.name()});
            this.hCe = a.Avatar;
            aCO();
        }
    }

    public final void aCQ() {
        v.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", new Object[]{this.username, this.hCe.name()});
        this.hCe = a.Video;
    }

    final void aCR() {
        if (this.hCc != null && this.hxK != 0 && this.hxL != 0) {
            Canvas lockCanvas = lockCanvas(null);
            if (lockCanvas == null) {
                v.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
                return;
            }
            lockCanvas.drawColor(0, Mode.CLEAR);
            lockCanvas.drawColor(-14737113);
            lockCanvas.drawColor(hCb[this.index]);
            try {
                unlockCanvasAndPost(lockCanvas);
            } catch (Throwable e) {
                v.a("MicroMsg.MT.MultiTalkVideoView", e, "drawNone unlockCanvasAndPost crash", new Object[0]);
            }
        }
    }

    public final void acO() {
        if (aCS()) {
            o.aCH().a(this, false);
        } else if (aCT()) {
            a aVar = (a) o.aCH().hAm.get(this.username);
            Bitmap bitmap = aVar != null ? aVar.hAp : null;
            if (bitmap != null) {
                a(bitmap, aVar.hzX, aVar.angle);
            }
        } else {
            aCR();
        }
    }

    private boolean aCS() {
        return this.hCe == a.Avatar;
    }

    public final boolean aCT() {
        return this.hCe == a.Video;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureAvailable %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        v.i(str, str2, objArr);
        this.hCc = surfaceTexture;
        this.hxK = i;
        this.hxL = i2;
        bCE();
        e.a(new Runnable(this) {
            final /* synthetic */ MultiTalkVideoView hCf;

            {
                this.hCf = r1;
            }

            public final void run() {
                this.hCf.acO();
            }
        }, "onSurfaceTextureAvailable_refreshView");
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureSizeChanged %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        v.i(str, str2, objArr);
        this.hxK = i;
        this.hxL = i2;
        e.a(new Runnable(this) {
            final /* synthetic */ MultiTalkVideoView hCf;

            {
                this.hCf = r1;
            }

            public final void run() {
                this.hCf.acO();
            }
        }, "onSurfaceTextureSizeChanged_refreshView");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureDestroyed %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        this.hCc = null;
        this.hxL = 0;
        this.hxK = 0;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureUpdated %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        v.v(str, str2, objArr);
    }
}

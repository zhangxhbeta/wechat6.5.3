package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public class OpenGlView extends GLSurfaceView {
    private static String TAG = "OpenGlView";
    public boolean jvz;
    public boolean kBP;
    public boolean kBQ;
    public int kBR;
    WeakReference<OpenGlRender> kBS;

    public void cE(int i, int i2) {
        setLayoutParams(new LayoutParams(i, i2));
    }

    public OpenGlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kBP = false;
        this.kBQ = true;
        this.jvz = false;
        this.kBR = 1;
        this.kBR = OpenGlRender.bdM();
        getHolder().addCallback(this);
        try {
            getHolder().setType(2);
        } catch (Exception e) {
            try {
                getHolder().setType(1);
            } catch (Exception e2) {
                try {
                    getHolder().setType(0);
                } catch (Exception e3) {
                }
            }
        }
        if (this.kBR == 2) {
            setEGLContextFactory(new c());
            setEGLConfigChooser(new b());
        }
    }

    public final void a(OpenGlRender openGlRender) {
        this.kBS = new WeakReference(openGlRender);
        super.setRenderer(openGlRender);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        v.i(TAG, "surfaceCreated");
        super.surfaceCreated(surfaceHolder);
        OpenGlRender openGlRender = (OpenGlRender) this.kBS.get();
        v.i(OpenGlRender.TAG, "surfaceCreated");
        openGlRender.Init(OpenGlRender.bdM(), new WeakReference(openGlRender), openGlRender.kBB);
        openGlRender.setParam(openGlRender.kBc, openGlRender.kBd, openGlRender.kBe, openGlRender.kBB);
        openGlRender.setMode(((OpenGlView) openGlRender.kBm.get()).getWidth(), ((OpenGlView) openGlRender.kBm.get()).getHeight(), 0, openGlRender.kBB);
        openGlRender.kBj = true;
        openGlRender.kBf = true;
        openGlRender.requestRender();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        v.i(TAG, "surfaceDestroyed");
        OpenGlRender openGlRender = (OpenGlRender) this.kBS.get();
        v.i(OpenGlRender.TAG, "onSurfaceDestroyed");
        openGlRender.kBf = false;
        openGlRender.Uninit(openGlRender.kBB);
        v.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
        openGlRender.kBa = 0;
        openGlRender.kBk = 0;
        openGlRender.kBl = 0;
        super.surfaceDestroyed(surfaceHolder);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        v.i(TAG, "surfaceChanged, format: %s, w: %s, h: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void cF(int i, int i2) {
    }
}

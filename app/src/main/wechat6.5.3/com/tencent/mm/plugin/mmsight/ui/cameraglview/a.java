package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.mm.plugin.mmsight.model.c.b;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public b hxE = new b(this) {
        final /* synthetic */ a hxG;

        {
            this.hxG = r1;
        }

        public final boolean au(byte[] bArr) {
            if (this.hxG.hxF != null) {
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.hxG.hxF;
                if (bArr == null || mMSightCameraGLSurfaceView.hyc == null || mMSightCameraGLSurfaceView.hyc.fJu) {
                    v.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                } else {
                    mMSightCameraGLSurfaceView.hyc.a(bArr, mMSightCameraGLSurfaceView.hpW, mMSightCameraGLSurfaceView.hpX, mMSightCameraGLSurfaceView.hye, false);
                    mMSightCameraGLSurfaceView.requestRender();
                }
            }
            return false;
        }
    };
    public MMSightCameraGLSurfaceView hxF;

    public final void a(byte[] bArr, boolean z, int i) {
        if (this.hxF != null) {
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.hxF;
            if (bArr == null || mMSightCameraGLSurfaceView.hyc == null || mMSightCameraGLSurfaceView.hyc.fJu) {
                v.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                return;
            }
            mMSightCameraGLSurfaceView.hyc.a(bArr, mMSightCameraGLSurfaceView.hpW, mMSightCameraGLSurfaceView.hpX, i, z);
            mMSightCameraGLSurfaceView.requestRender();
        }
    }

    public a(MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView) {
        this.hxF = mMSightCameraGLSurfaceView;
    }

    public final void F(int i, int i2, int i3) {
        if (this.hxF != null) {
            int i4 = (i3 == 0 || i3 == 180) ? i : i2;
            if (i3 == 0 || i3 == 180) {
                i = i2;
            }
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.hxF;
            v.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3), mMSightCameraGLSurfaceView});
            mMSightCameraGLSurfaceView.hpW = i4;
            mMSightCameraGLSurfaceView.hpX = i;
            mMSightCameraGLSurfaceView.hye = i3;
        }
    }
}

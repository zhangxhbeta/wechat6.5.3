package com.tencent.mm.plugin.mmsight.model;

import android.app.Activity;
import android.hardware.Camera;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.c.a.a;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

final class k {
    boolean hnw = false;
    a hnx;
    Object lock = new byte[0];

    k() {
    }

    public final a b(Activity activity, int i) {
        if (activity == null) {
            return null;
        }
        final long Ni = be.Ni();
        final long id = Thread.currentThread().getId();
        this.hnw = false;
        this.hnx = null;
        synchronized (this.lock) {
            final Activity activity2 = activity;
            final int i2 = i;
            e.a(new Runnable(this) {
                final /* synthetic */ k hnA;

                public final void run() {
                    v.i("MicroMsg.SightCamera.OpenCameraThread", "Start Open Camera thread[parent:%d this:%d] time:%d", new Object[]{Long.valueOf(id), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(be.Ni() - Ni)});
                    try {
                        this.hnA.hnx = c.b(activity2, i2);
                    } catch (Exception e) {
                        v.e("MicroMsg.SightCamera.OpenCameraThread", "openCamera failed e:%s", new Object[]{e.getMessage()});
                    }
                    synchronized (this.hnA.lock) {
                        if (this.hnA.hnw && this.hnA.hnx != null) {
                            v.e("MicroMsg.SightCamera.OpenCameraThread", "thread time out now, release camera :%d ", new Object[]{Long.valueOf(be.Ni() - Ni)});
                            try {
                                Camera camera = this.hnA.hnx.cdl;
                                camera.setPreviewCallback(null);
                                camera.stopPreview();
                                camera.release();
                                this.hnA.hnx = null;
                            } catch (Exception e2) {
                                v.e("MicroMsg.SightCamera.OpenCameraThread", "realease Camera failed e:%s", new Object[]{e2.getMessage()});
                            }
                        }
                        this.hnA.lock.notify();
                    }
                }
            }, "SightCamera_openCamera");
            try {
                this.lock.wait(30000);
            } catch (InterruptedException e) {
                v.e("MicroMsg.SightCamera.OpenCameraThread", "Lock wait failed e:%s", new Object[]{e.getMessage()});
            }
            if (this.hnx == null || this.hnx.cdl == null) {
                this.hnw = true;
                v.e("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Timeout:%d", new Object[]{Long.valueOf(be.Ni() - Ni)});
                return null;
            }
            v.i("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Succ thread:%d Time:%d camera:%s", new Object[]{Long.valueOf(id), Long.valueOf(be.Ni() - Ni), this.hnx.cdl});
            a aVar = this.hnx;
            return aVar;
        }
    }
}

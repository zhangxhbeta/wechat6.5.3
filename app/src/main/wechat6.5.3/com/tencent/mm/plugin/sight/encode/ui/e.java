package com.tencent.mm.plugin.sight.encode.ui;

import android.app.Activity;
import android.hardware.Camera;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.c.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

final class e {
    boolean hnw = false;
    a hnx;
    Object lock = new byte[0];

    e() {
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
            com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                final /* synthetic */ e iZw;

                public final void run() {
                    v.i("MicroMsg.SightCamera.OpenCameraThread", "Start Open Camera thread[parent:%d this:%d] time:%d", Long.valueOf(id), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(be.Ni() - Ni));
                    try {
                        this.iZw.hnx = c.b(activity2, i2);
                    } catch (Exception e) {
                        v.e("MicroMsg.SightCamera.OpenCameraThread", "openCamera failed e:%s", e.getMessage());
                    }
                    synchronized (this.iZw.lock) {
                        if (this.iZw.hnw && this.iZw.hnx != null) {
                            v.e("MicroMsg.SightCamera.OpenCameraThread", "thread time out now, release camera :%d ", Long.valueOf(be.Ni() - Ni));
                            try {
                                Camera camera = this.iZw.hnx.cdl;
                                camera.setPreviewCallback(null);
                                camera.stopPreview();
                                camera.release();
                                this.iZw.hnx = null;
                            } catch (Exception e2) {
                                v.e("MicroMsg.SightCamera.OpenCameraThread", "realease Camera failed e:%s", e2.getMessage());
                            }
                        }
                        this.iZw.lock.notify();
                    }
                }
            }, "SightCamera_openCamera");
            try {
                this.lock.wait(30000);
            } catch (InterruptedException e) {
                v.e("MicroMsg.SightCamera.OpenCameraThread", "Lock wait failed e:%s", e.getMessage());
            }
            if (this.hnx == null || this.hnx.cdl == null) {
                this.hnw = true;
                v.e("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Timeout:%d", Long.valueOf(be.Ni() - Ni));
                return null;
            }
            v.i("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Succ thread:%d Time:%d camera:%s", Long.valueOf(id), Long.valueOf(be.Ni() - Ni), this.hnx.cdl);
            a aVar = this.hnx;
            return aVar;
        }
    }
}

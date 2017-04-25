package com.tencent.mm.pluginsdk.n;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    public Context context;
    public int dgq;
    public int fileSize;
    public String filename;
    public a hmu;
    private boolean hmv = false;
    public MediaRecorder iWO;
    public f lFE;
    public int lFF = 0;
    private final int lFG = 5;
    private a lFH = new a(Looper.getMainLooper());

    private static class a extends Handler {
        int eWn = 0;
        boolean hmv = false;

        public a(Looper looper) {
            super(looper);
        }

        @TargetApi(8)
        public final void handleMessage(Message message) {
            Camera camera = (Camera) message.obj;
            Parameters parameters = camera.getParameters();
            int zoom = parameters.getZoom() + this.eWn;
            if (this.hmv) {
                if (zoom >= parameters.getMaxZoom() / 2) {
                    zoom = parameters.getMaxZoom() / 2;
                } else {
                    sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
                }
            } else if (zoom <= 0) {
                zoom = 0;
            } else {
                sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
        }
    }

    @SuppressLint({"NewApi"})
    public final void a(Surface surface, int i, int i2) {
        while (this.lFE != null) {
            Camera camera = this.lFE.cdl;
            if (surface == null || camera == null) {
                v.e("MicroMsg.SceneVideo", "holder or cam is null ");
                return;
            }
            int i3 = p.ceJ.cdK == -1 ? i : p.ceJ.cdK;
            int bow = f.bow();
            try {
                camera.unlock();
            } catch (Exception e) {
                v.w("MicroMsg.SceneVideo", "exception in cam.unlock() [%s]", new Object[]{e.getMessage()});
            }
            this.iWO = new MediaRecorder();
            this.iWO.setCamera(camera);
            this.iWO.setAudioSource(5);
            this.iWO.setVideoSource(1);
            this.iWO.setOutputFormat(2);
            this.iWO.setVideoSize(this.hmu.lFr, this.hmu.lFq);
            this.iWO.setVideoEncoder(2);
            this.iWO.setAudioEncoder(3);
            if (VERSION.SDK_INT > 7) {
                this.iWO.setVideoEncodingBitRate(this.hmu.lFs);
            }
            try {
                if (p.ceC.cfc) {
                    this.iWO.setVideoFrameRate(p.ceC.cff);
                } else {
                    this.iWO.setVideoFrameRate(i3);
                }
            } catch (Exception e2) {
                v.d("MicroMsg.SceneVideo", "try set fps failed: " + i3);
            }
            this.iWO.setOutputFile(this.hmu.lFB);
            this.iWO.setPreviewDisplay(surface);
            v.d("MicroMsg.SceneVideo", "doStart camid[%s] params:\n%s", new Object[]{Integer.valueOf(bow), this.hmu.toString()});
            if (bow == 0) {
                setOrientationHint(p.ceJ.cdE == -1 ? 90 : p.ceJ.cdE);
            } else {
                if (p.ceJ.cdF == -1) {
                    i3 = 270;
                } else {
                    i3 = p.ceJ.cdF;
                }
                setOrientationHint(i3);
            }
            try {
                this.iWO.prepare();
                this.iWO.start();
                return;
            } catch (Throwable e3) {
                v.w("MicroMsg.SceneVideo", "exception in mediaRecorder[%s] doStartCount[%s]", new Object[]{e3.getMessage(), Integer.valueOf(this.lFF)});
                v.a("MicroMsg.SceneVideo", e3, "", new Object[0]);
                this.lFF++;
                if (this.lFF < 5) {
                    f fVar = this.lFE;
                    if (i2 < 0 || i2 >= fVar.lFQ.size()) {
                        v.d("MicroMsg.YuvReocrder", "ret fr " + i);
                    } else {
                        v.d("MicroMsg.YuvReocrder", "ret fr " + fVar.lFQ.get(i2));
                        i = ((Integer) fVar.lFQ.get(i2)).intValue();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
        v.e("MicroMsg.SceneVideo", "yuvRecoder is null");
    }

    @TargetApi(9)
    private void setOrientationHint(final int i) {
        com.tencent.mm.compatible.a.a.a(9, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ b lFJ;

            public final void run() {
                if (this.lFJ.iWO != null) {
                    this.lFJ.iWO.setOrientationHint(i);
                }
            }
        });
    }

    public final int g(Activity activity, boolean z) {
        int sk;
        this.context = activity;
        f fVar = this.lFE;
        a aVar = this.hmu;
        if (aVar == null) {
            sk = 0 - g.sk();
        } else {
            fVar.lFP = aVar;
            if (fVar.aHA == null && fVar.hmB == null) {
                fVar.aHA = (SensorManager) activity.getSystemService("sensor");
                fVar.hmB = fVar.aHA.getDefaultSensor(1);
            }
            if (z || fVar.cdl == null) {
                fVar.azR();
                if (z) {
                    f.hmy = (f.hmy ^ -1) & 1;
                }
                fVar.hmA = c.b(activity, f.hmy);
                if (fVar.hmA == null) {
                    v.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                    sk = 0 - g.sk();
                } else {
                    fVar.cdl = fVar.hmA.cdl;
                    fVar.lFP.cdi = fVar.hmA.cdi;
                    if (fVar.cdl == null) {
                        v.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                        sk = 0 - g.sk();
                    }
                }
            }
            sk = 0;
        }
        if (sk != 0) {
            return sk;
        }
        return 0;
    }

    public final int bor() {
        this.lFE.azR();
        return 0;
    }

    public final int c(SurfaceHolder surfaceHolder) {
        return this.lFE.c(surfaceHolder);
    }

    public final int azU() {
        if (this.lFE.cdl == null) {
            return 0;
        }
        return this.lFE.cdl.getParameters().getPreviewSize().width;
    }

    public final int azV() {
        if (this.lFE.cdl == null) {
            return 0;
        }
        return this.lFE.cdl.getParameters().getPreviewSize().height;
    }
}

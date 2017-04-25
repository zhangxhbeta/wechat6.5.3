package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.jv;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class f implements SensorEventListener {
    private static int hmz = Integer.MAX_VALUE;
    private SensorManager aHA;
    Camera cdl = null;
    com.tencent.mm.compatible.d.c.a.a hmA;
    private Sensor hmB;
    private float hmC = 0.0f;
    private float hmD = 0.0f;
    private float hmE = 0.0f;
    private boolean hmU = false;
    com.tencent.mm.pluginsdk.n.a hmu = com.tencent.mm.pluginsdk.n.a.bop();
    boolean hmv = false;
    boolean hmx = false;
    int hmy = 0;
    PreviewCallback iXa = null;
    private byte[] iZx;
    a iZy = new a(Looper.getMainLooper());
    private Context mContext = null;

    private static class a extends ac {
        static boolean hmV = true;
        static AutoFocusCallback hmW = new AutoFocusCallback() {
            public final void onAutoFocus(boolean z, Camera camera) {
                v.v("MicroMsg.SightCamera", "auto focus callback");
                a.hmV = true;
            }
        };
        float gLd;
        boolean hmv = false;
        int hne = 0;
        boolean hnf = false;
        boolean hng = false;
        float hnh;
        int hni;
        int hnj;

        private static Rect a(float f, float f2, float f3, int i, int i2) {
            int intValue = Float.valueOf(((float) com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 72)) * f3).intValue();
            RectF rectF = new RectF();
            rectF.set((((f - ((float) (intValue / 2))) * 2000.0f) / ((float) i)) - 1000.0f, (((f2 - ((float) (intValue / 2))) * 2000.0f) / ((float) i2)) - 1000.0f, (((((float) (intValue / 2)) + f) * 2000.0f) / ((float) i)) - 1000.0f, (((((float) (intValue / 2)) + f2) * 2000.0f) / ((float) i2)) - 1000.0f);
            return new Rect(mX(Math.round(rectF.left)), mX(Math.round(rectF.top)), mX(Math.round(rectF.right)), mX(Math.round(rectF.bottom)));
        }

        private static int mX(int i) {
            if (i > 1000) {
                return 1000;
            }
            if (i < -1000) {
                return -1000;
            }
            return i;
        }

        static void f(Camera camera) {
            if (camera == null) {
                v.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
            }
            if (hmV) {
                hmV = false;
                try {
                    camera.autoFocus(hmW);
                    return;
                } catch (Exception e) {
                    v.w("MicroMsg.SightCamera", "autofocus fail, exception %s", e.getMessage());
                    hmV = true;
                    return;
                }
            }
            v.w("MicroMsg.SightCamera", "auto focus not back");
        }

        public a(Looper looper) {
            super(looper);
        }

        private static int d(Parameters parameters) {
            if (parameters == null) {
                return 0;
            }
            int maxZoom;
            try {
                maxZoom = parameters.getMaxZoom() / 2;
                if (maxZoom <= 0) {
                    maxZoom = parameters.getMaxZoom();
                }
            } catch (Exception e) {
                v.e("MicroMsg.SightCamera", "get target zoom value error: %s", e.getMessage());
                maxZoom = 0;
            }
            return maxZoom;
        }

        static int e(Parameters parameters) {
            int d = d(parameters) / 6;
            if (d <= 0) {
                return 1;
            }
            return d;
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            Camera camera;
            switch (message.what) {
                case 4353:
                    if (!this.hng) {
                        int d;
                        camera = (Camera) message.obj;
                        Parameters parameters = camera.getParameters();
                        v.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", Boolean.valueOf(this.hmv), Integer.valueOf(this.hne), Integer.valueOf(parameters.getZoom()));
                        int zoom = parameters.getZoom() + this.hne;
                        if (this.hmv) {
                            d = d(parameters);
                            if (zoom < d) {
                                long j;
                                Message obtainMessage = obtainMessage(4353, message.obj);
                                if (this.hnf) {
                                    j = 10;
                                } else {
                                    j = 20;
                                }
                                sendMessageDelayed(obtainMessage, j);
                                z = false;
                                d = zoom;
                            }
                        } else if (zoom <= 0) {
                            d = 0;
                        } else {
                            sendMessageDelayed(obtainMessage(4353, message.obj), this.hnf ? 10 : 20);
                            z = false;
                            d = zoom;
                        }
                        parameters.setZoom(d);
                        try {
                            camera.setParameters(parameters);
                        } catch (Throwable e) {
                            v.a("MicroMsg.SightCamera", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                        if (z) {
                            this.hni = 0;
                            this.hnj = 0;
                            sendMessageDelayed(obtainMessage(4354, message.obj), 20);
                            return;
                        }
                        return;
                    }
                    return;
                case 4354:
                    camera = (Camera) message.obj;
                    if (this.hni == 0 || this.hni == 0 || d.dX(14)) {
                        f(camera);
                        return;
                    }
                    float f = this.hnh;
                    float f2 = this.gLd;
                    int i = this.hni;
                    int i2 = this.hnj;
                    if (camera == null) {
                        v.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
                    }
                    if (hmV) {
                        hmV = false;
                        try {
                            v.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2));
                            v.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", a(f, f2, 1.0f, i, i2), a(f, f2, 1.5f, i, i2));
                            Parameters parameters2 = camera.getParameters();
                            List supportedFocusModes = parameters2.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                                parameters2.setFocusMode("auto");
                            }
                            if (parameters2.getMaxNumFocusAreas() > 0) {
                                supportedFocusModes = new ArrayList(1);
                                supportedFocusModes.add(new Area(r7, 1000));
                                parameters2.setFocusAreas(supportedFocusModes);
                            }
                            if (parameters2.getMaxNumMeteringAreas() > 0) {
                                supportedFocusModes = new ArrayList(1);
                                supportedFocusModes.add(new Area(r2, 1000));
                                parameters2.setMeteringAreas(supportedFocusModes);
                            }
                            camera.setParameters(parameters2);
                            camera.autoFocus(hmW);
                            return;
                        } catch (Exception e2) {
                            v.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", e2.getMessage());
                            hmV = true;
                            return;
                        }
                    }
                    v.w("MicroMsg.SightCamera", "auto focus not back");
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void c(f fVar) {
        if (true != fVar.hmU && fVar.mContext != null) {
            if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || b.sf()) {
                com.tencent.mm.sdk.c.b jvVar = new jv();
                jvVar.bky.type = 2;
                com.tencent.mm.sdk.c.a.nhr.z(jvVar);
                if (jvVar.bkz.bkx) {
                    fVar.hmU = true;
                    return;
                }
                h f = g.f(fVar.mContext, 2131235313, 2131231164);
                if (f != null) {
                    f.setCancelable(false);
                    f.setCanceledOnTouchOutside(false);
                    f.show();
                    fVar.hmU = true;
                }
            }
        }
    }

    final void azR() {
        if (!(this.aHA == null || this.hmB == null)) {
            this.aHA.unregisterListener(this);
        }
        if (this.cdl != null) {
            long Nj = be.Nj();
            v.i("MicroMsg.SightCamera", "ashu::release camera beg, %s", Looper.myLooper());
            this.iZy.removeCallbacksAndMessages(null);
            this.iZy.hng = true;
            this.cdl.setPreviewCallback(null);
            this.cdl.stopPreview();
            this.cdl.release();
            this.cdl = null;
            this.hmx = false;
            v.i("MicroMsg.SightCamera", "ashu::release camera end, use %dms, %s", Long.valueOf(be.az(Nj)), Looper.myLooper());
        }
        this.hmv = false;
        this.hmC = 0.0f;
        this.hmD = 0.0f;
        this.hmE = 0.0f;
        a.hmV = true;
        this.mContext = null;
        this.hmU = false;
        this.iZx = null;
    }

    private boolean e(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            List a;
            Parameters parameters = camera.getParameters();
            com.tencent.mm.pluginsdk.n.a aVar = this.hmu;
            int i = Integer.MAX_VALUE;
            List b = c.b(parameters);
            if (b == null) {
                v.d("MicroMsg.SightCamera", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
                a = c.a(parameters);
            } else {
                a = b;
            }
            Size previewSize;
            if (a != null) {
                int i2 = 0;
                boolean z = false;
                while (i2 < a.size()) {
                    boolean z2;
                    int i3;
                    int i4 = ((Size) a.get(i2)).height;
                    int i5 = ((Size) a.get(i2)).width;
                    v.i("MicroMsg.SightCamera", "supp w:" + i5 + " h:" + i4);
                    int i6 = i4 * i5;
                    if (i5 < aVar.lFt || i4 < aVar.lFu || i6 >= i) {
                        z2 = z;
                        i3 = i;
                    } else {
                        aVar.lFr = i5;
                        aVar.lFq = i4;
                        i3 = i6;
                        z2 = true;
                    }
                    i2++;
                    i = i3;
                    z = z2;
                }
                if (!z) {
                    previewSize = parameters.getPreviewSize();
                    aVar.lFq = previewSize.height;
                    aVar.lFr = previewSize.width;
                }
            } else {
                previewSize = parameters.getPreviewSize();
                aVar.lFq = previewSize.height;
                aVar.lFr = previewSize.width;
            }
            v.i("MicroMsg.SightCamera", " rotate:" + aVar.cdi + " w:" + aVar.lFr + " h:" + aVar.lFq);
            if (com.tencent.mm.pluginsdk.n.a.lFp != aVar.lFr) {
                v.w("MicroMsg.SightCamera", "TARGET WIDTH %d, CURRENT WIDTH %d", Integer.valueOf(com.tencent.mm.pluginsdk.n.a.lFp), Integer.valueOf(aVar.lFr));
                com.tencent.mm.pluginsdk.n.a.lFp = aVar.lFr;
            }
            if (com.tencent.mm.pluginsdk.n.a.lFo != aVar.lFq) {
                v.w("MicroMsg.SightCamera", "TARGET HEIGHT %d, CURRENT HEIGHT %d", Integer.valueOf(com.tencent.mm.pluginsdk.n.a.lFo), Integer.valueOf(aVar.lFq));
                com.tencent.mm.pluginsdk.n.a.lFo = aVar.lFq;
            }
            parameters.setPreviewSize(this.hmu.lFr, this.hmu.lFq);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            v.i("MicroMsg.SightCamera", "setPreviewSize Exception, %s, %s", Looper.myLooper(), e.getMessage());
            return false;
        }
    }

    @TargetApi(14)
    private static boolean a(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            v.i("MicroMsg.SightCamera", "safeSetMetering");
            Parameters parameters = camera.getParameters();
            if (parameters.getMaxNumMeteringAreas() > 0) {
                List arrayList = new ArrayList();
                arrayList.add(new Area(new Rect(-500, -1000, 500, 1000), 600));
                parameters.setMeteringAreas(arrayList);
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            v.i("MicroMsg.SightCamera", "safeSetMetering Exception, %s, %s", Looper.myLooper(), e.getMessage());
            return false;
        }
    }

    private static boolean b(Camera camera, boolean z) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            int i;
            if (z) {
                if (p.ceA.ccR > 0) {
                    v.i("MicroMsg.SightCamera", "set frame rate > 0, do not try set preview frame rate");
                } else {
                    try {
                        parameters.setPreviewFrameRate(Math.min(30, ((Integer) Collections.max(parameters.getSupportedPreviewFrameRates())).intValue()));
                        v.i("MicroMsg.SightCamera", "set preview frame rate %d", Integer.valueOf(i));
                    } catch (Throwable e) {
                        v.a("MicroMsg.SightCamera", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.i("MicroMsg.SightCamera", "trySetPreviewFrameRateParameters Exception, %s, %s", Looper.myLooper(), e.getMessage());
                    }
                }
            } else if (p.ceA.ccR > 0) {
                v.i("MicroMsg.SightCamera", "set frame rate > 0, do not try set preview fps range");
            } else {
                List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                if (!(supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0)) {
                    int i2 = Integer.MIN_VALUE;
                    int i3 = Integer.MIN_VALUE;
                    Object obj = null;
                    int size = supportedPreviewFpsRange.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj2;
                        int i5;
                        int[] iArr = (int[]) supportedPreviewFpsRange.get(i4);
                        if (iArr != null && iArr.length > 1) {
                            int i6 = iArr[0];
                            i = iArr[1];
                            v.i("MicroMsg.SightCamera", "dkfps %d:[%d %d]", Integer.valueOf(i4), Integer.valueOf(i6), Integer.valueOf(i));
                            if (i6 >= 0 && i >= i6) {
                                if (i >= i3 && obj == null) {
                                    i3 = i;
                                    i2 = i6;
                                }
                                if (i >= 30000) {
                                    obj2 = 1;
                                    i5 = i3;
                                    i3 = i2;
                                    i4++;
                                    i2 = i3;
                                    i3 = i5;
                                    obj = obj2;
                                }
                            }
                        }
                        obj2 = obj;
                        i5 = i3;
                        i3 = i2;
                        i4++;
                        i2 = i3;
                        i3 = i5;
                        obj = obj2;
                    }
                    v.i("MicroMsg.SightCamera", "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(30));
                    if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
                        try {
                            parameters.setPreviewFpsRange(i2, i3);
                            v.i("MicroMsg.SightCamera", "set fps range %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        } catch (Throwable e2) {
                            v.a("MicroMsg.SightCamera", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                            v.i("MicroMsg.SightCamera", "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                        }
                    }
                }
            }
            List supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            v.i("MicroMsg.SightCamera", "use fix mode %B, supported preview frame rates %s", Boolean.valueOf(z), supportedPreviewFrameRates);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e3) {
            v.i("MicroMsg.SightCamera", "setPreviewFrameRate Exception, %s, %s", Looper.myLooper(), e3.getMessage());
            return false;
        }
    }

    private static boolean b(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            v.i("MicroMsg.SightCamera", "safeSetPreviewFormat");
            Parameters parameters = camera.getParameters();
            List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(Integer.valueOf(17))) {
                v.e("MicroMsg.SightCamera", "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            v.i("MicroMsg.SightCamera", "setPreviewFormat Exception, %s, %s", Looper.myLooper(), e.getMessage());
            return false;
        }
    }

    private static boolean c(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                v.i("MicroMsg.SightCamera", "support continuous video");
                parameters.setFocusMode("continuous-video");
            } else if (supportedFocusModes == null || !supportedFocusModes.contains("auto")) {
                v.i("MicroMsg.SightCamera", "not support continuous video or auto focus");
            } else {
                v.i("MicroMsg.SightCamera", "support auto focus");
                parameters.setFocusMode("auto");
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            v.i("MicroMsg.SightCamera", "setFocusMode Exception, %s, %s", Looper.myLooper(), e.getMessage());
            return false;
        }
    }

    public final int a(SurfaceHolder surfaceHolder) {
        long Nj = be.Nj();
        v.i("MicroMsg.SightCamera", "ashu::start preview, previewing %B, %s", Boolean.valueOf(this.hmx), Looper.myLooper());
        if (this.hmx) {
            return 0;
        }
        if (surfaceHolder == null) {
            return 0 - com.tencent.mm.compatible.util.g.sk();
        }
        try {
            e(this.cdl);
            ak.yW();
            Integer num = (Integer) com.tencent.mm.model.c.vf().get(344066, Integer.valueOf(0));
            String str = "MicroMsg.SightCamera";
            String str2 = "startPreview Holder:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B]";
            Object[] objArr = new Object[5];
            objArr[0] = num;
            String str3 = p.ceA.ccW == 1 ? "Range" : p.ceA.ccV == 1 ? "Fix" : "Error";
            objArr[1] = str3;
            objArr[2] = Boolean.valueOf(p.ceA.ccX == 1);
            objArr[3] = Boolean.valueOf(p.ceA.ccY == 1);
            objArr[4] = Boolean.valueOf(p.ceA.ccZ == 1);
            v.i(str, str2, objArr);
            if (p.ceA.ccW == 1 && (num.intValue() == 0 || num.intValue() == 1)) {
                b(this.cdl, false);
            } else if (p.ceA.ccV == 1 && (num.intValue() == 0 || num.intValue() == 5)) {
                b(this.cdl, true);
            }
            if (p.ceA.ccX == 1 && (num.intValue() == 0 || num.intValue() == 2)) {
                b(this.cdl);
            }
            if (p.ceA.ccY == 1 && ((num.intValue() == 0 || num.intValue() == 3) && d.dY(14))) {
                a(this.cdl);
            }
            if (p.ceA.ccZ == 1 && (num.intValue() == 0 || num.intValue() == 4)) {
                c(this.cdl);
            }
            Parameters parameters = this.cdl.getParameters();
            if (this.iXa != null) {
                this.iZx = new byte[((ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (this.hmu.lFr * this.hmu.lFq)) / 8)];
                this.cdl.addCallbackBuffer(this.iZx);
                this.cdl.setPreviewCallbackWithBuffer(new PreviewCallback(this) {
                    final /* synthetic */ f iZz;

                    {
                        this.iZz = r1;
                    }

                    public final void onPreviewFrame(byte[] bArr, Camera camera) {
                        this.iZz.iXa.onPreviewFrame(bArr, camera);
                        camera.addCallbackBuffer(this.iZz.iZx);
                        if (bArr == null || bArr.length <= 0) {
                            f.c(this.iZz);
                        }
                    }
                });
            }
            this.cdl.setPreviewDisplay(surfaceHolder);
            this.cdl.startPreview();
            if (!(p.ceA.ccZ != 0 || this.aHA == null || this.hmB == null)) {
                this.aHA.registerListener(this, this.hmB, 2);
            }
            this.hmx = true;
            v.i("MicroMsg.SightCamera", "ashu::start preview end, use %dms %s", Long.valueOf(be.az(Nj)), Looper.myLooper());
            return 0;
        } catch (Throwable e) {
            v.a("MicroMsg.SightCamera", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.i("MicroMsg.SightCamera", "ashu::start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
            return 0 - com.tencent.mm.compatible.util.g.sk();
        }
    }

    @TargetApi(11)
    public final int c(SurfaceTexture surfaceTexture) {
        long Nj = be.Nj();
        v.i("MicroMsg.SightCamera", "ashu::start preview, previewing %B, %s", Boolean.valueOf(this.hmx), Looper.myLooper());
        if (this.hmx) {
            return 0;
        }
        if (surfaceTexture == null) {
            return 0 - com.tencent.mm.compatible.util.g.sk();
        }
        v.i("MicroMsg.SightCamera", "this texture %s", surfaceTexture);
        try {
            e(this.cdl);
            ak.yW();
            Integer num = (Integer) com.tencent.mm.model.c.vf().get(344066, Integer.valueOf(0));
            String str = "MicroMsg.SightCamera";
            String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B]";
            Object[] objArr = new Object[5];
            objArr[0] = num;
            String str3 = p.ceA.ccW == 1 ? "Range" : p.ceA.ccV == 1 ? "Fix" : "Error";
            objArr[1] = str3;
            objArr[2] = Boolean.valueOf(p.ceA.ccX == 1);
            objArr[3] = Boolean.valueOf(p.ceA.ccY == 1);
            objArr[4] = Boolean.valueOf(p.ceA.ccZ == 1);
            v.i(str, str2, objArr);
            if (p.ceA.ccW == 1 && (num.intValue() == 0 || num.intValue() == 1)) {
                b(this.cdl, false);
            } else if (p.ceA.ccV == 1 && (num.intValue() == 0 || num.intValue() == 5)) {
                b(this.cdl, true);
            }
            if (p.ceA.ccX == 1 && (num.intValue() == 0 || num.intValue() == 2)) {
                b(this.cdl);
            }
            if (p.ceA.ccY == 1 && ((num.intValue() == 0 || num.intValue() == 3) && d.dY(14))) {
                a(this.cdl);
            }
            if (p.ceA.ccZ == 1 && (num.intValue() == 0 || num.intValue() == 4)) {
                c(this.cdl);
            }
            Parameters parameters = this.cdl.getParameters();
            if (this.iXa != null) {
                this.iZx = new byte[((ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (this.hmu.lFr * this.hmu.lFq)) / 8)];
                this.cdl.addCallbackBuffer(this.iZx);
                this.cdl.setPreviewCallbackWithBuffer(new PreviewCallback(this) {
                    final /* synthetic */ f iZz;

                    {
                        this.iZz = r1;
                    }

                    public final void onPreviewFrame(byte[] bArr, Camera camera) {
                        this.iZz.iXa.onPreviewFrame(bArr, camera);
                        camera.addCallbackBuffer(this.iZz.iZx);
                        if (bArr == null || bArr.length <= 0) {
                            f.c(this.iZz);
                        }
                    }
                });
            }
            this.cdl.setPreviewTexture(surfaceTexture);
            this.cdl.startPreview();
            if (!(p.ceA.ccZ != 0 || this.aHA == null || this.hmB == null)) {
                this.aHA.registerListener(this, this.hmB, 2);
            }
            this.hmx = true;
            v.i("MicroMsg.SightCamera", "ashu::start preview end, use %dms %s", Long.valueOf(be.az(Nj)), Looper.myLooper());
            return 0;
        } catch (Throwable e) {
            v.a("MicroMsg.SightCamera", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.i("MicroMsg.SightCamera", "ashu::start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
            return 0 - com.tencent.mm.compatible.util.g.sk();
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.hmC - f) > 3.0f || Math.abs(this.hmD - f2) > 3.0f || Math.abs(this.hmE - f3) > 3.0f) {
            v.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", Float.valueOf(3.0f));
            a.f(this.cdl);
            this.hmC = f;
            this.hmD = f2;
            this.hmE = f3;
        }
    }

    public final int L(Activity activity) {
        if (p.ceA.ccZ == 0 && this.aHA == null && this.hmB == null) {
            this.aHA = (SensorManager) activity.getSystemService("sensor");
            this.hmB = this.aHA.getDefaultSensor(1);
        }
        if (this.cdl == null) {
            azR();
            if (p.ceA.cdb >= 0) {
                this.hmy = p.ceA.cdb;
            } else if (Integer.MAX_VALUE != hmz) {
                this.hmy = hmz;
                v.i("MicroMsg.SightCamera", "ashu:: use last check camera id %d", Integer.valueOf(this.hmy));
            } else {
                try {
                    this.hmy = c.rs();
                    hmz = this.hmy;
                } catch (Throwable e) {
                    v.a("MicroMsg.SightCamera", e, "try to get back cameraid error %s", e.getMessage());
                    this.hmy = 0;
                }
            }
            v.i("MicroMsg.SightCamera", "ashu::use camera id %d, DeviceInfo id %d", Integer.valueOf(this.hmy), Integer.valueOf(p.ceA.cdb));
            this.hmU = false;
            this.mContext = activity;
            this.hmA = new e().b(activity, this.hmy);
            v.i("MicroMsg.SightCamera", "ashu::open camera end, %s", Looper.myLooper());
            if (this.hmA == null) {
                v.i("MicroMsg.SightCamera", "ashu::open camera FAILED, %s", Looper.myLooper());
                return 0 - com.tencent.mm.compatible.util.g.sk();
            }
            this.cdl = this.hmA.cdl;
            this.iZy.hng = false;
            this.hmu.cdi = this.hmA.cdi;
            if (this.cdl == null) {
                v.e("MicroMsg.SightCamera", "start camera FAILED!");
                return 0 - com.tencent.mm.compatible.util.g.sk();
            }
        }
        return 0;
    }
}

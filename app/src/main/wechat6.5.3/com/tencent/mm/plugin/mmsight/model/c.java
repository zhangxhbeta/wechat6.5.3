package com.tencent.mm.plugin.mmsight.model;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
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
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.jv;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.i;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c implements SensorEventListener {
    static boolean hmV = true;
    private static int hmz = Integer.MAX_VALUE;
    private SensorManager aHA;
    public Camera cdl = null;
    public com.tencent.mm.compatible.d.c.a.a hmA;
    private Sensor hmB;
    private float hmC = 0.0f;
    private float hmD = 0.0f;
    private float hmE = 0.0f;
    public Point hmF = null;
    public Point hmG = null;
    private int hmH = 0;
    private com.tencent.mm.plugin.base.a.b hmI = new com.tencent.mm.plugin.base.a.b();
    public List<b> hmJ = new ArrayList();
    private a hmK = a.Preview;
    private f hmL = new f("prevcameraCallback");
    private f hmM = new f("cameraCallback");
    private f hmN = new f("cameraPreviewCallback");
    private f hmO = new f("cameraCropCallback");
    private f hmP = new f("mirrorCameraCallback");
    private f hmQ = new f("finishCallbackTimeCallback");
    private VideoTransPara hmR;
    public byte[] hmS = null;
    public volatile boolean hmT = false;
    private boolean hmU = false;
    AutoFocusCallback hmW = new AutoFocusCallback(this) {
        final /* synthetic */ c hmZ;

        {
            this.hmZ = r1;
        }

        public final void onAutoFocus(boolean z, Camera camera) {
            v.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", new Object[]{Boolean.valueOf(z), this.hmZ.hmK});
            c.hmV = true;
        }
    };
    public d hmX = new d(this, Looper.getMainLooper());
    public boolean hmY = true;
    private int hms = -1;
    public int hmt = -1;
    public com.tencent.mm.pluginsdk.n.a hmu = com.tencent.mm.pluginsdk.n.a.boq();
    private boolean hmv = false;
    private boolean hmw = false;
    public boolean hmx = false;
    private int hmy = 0;
    private Context mContext = null;
    private int scene = 0;

    public enum a {
        Preview,
        Recording,
        Stoping
    }

    public interface b {
        boolean au(byte[] bArr);
    }

    public interface c {
        void a(byte[] bArr, int i, int i2, int i3, int i4);
    }

    private class d extends ac {
        public float gLd;
        final /* synthetic */ c hmZ;
        boolean hmv = false;
        int hne = 0;
        boolean hnf = false;
        boolean hng = false;
        public float hnh;
        public int hni;
        public int hnj;

        private static Rect a(float f, float f2, float f3, int i, int i2) {
            int intValue = Float.valueOf(((float) com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 72)) * f3).intValue();
            RectF rectF = new RectF();
            rectF.set((((f - ((float) (intValue / 2))) * 2000.0f) / ((float) i)) - 1000.0f, (((f2 - ((float) (intValue / 2))) * 2000.0f) / ((float) i2)) - 1000.0f, (((((float) (intValue / 2)) + f) * 2000.0f) / ((float) i)) - 1000.0f, (((((float) (intValue / 2)) + f2) * 2000.0f) / ((float) i2)) - 1000.0f);
            return new Rect(mX(Math.round(rectF.left)), mX(Math.round(rectF.top)), mX(Math.round(rectF.right)), mX(Math.round(rectF.bottom)));
        }

        private static int mX(int i) {
            if (i > BaseReportManager.MAX_READ_COUNT) {
                return BaseReportManager.MAX_READ_COUNT;
            }
            if (i < -1000) {
                return -1000;
            }
            return i;
        }

        final void d(Camera camera) {
            if (camera == null) {
                v.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
            }
            if (c.hmV) {
                c.hmV = false;
                try {
                    v.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
                    camera.autoFocus(this.hmZ.hmW);
                    return;
                } catch (Exception e) {
                    v.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[]{e.getMessage()});
                    c.hmV = true;
                    return;
                }
            }
            v.w("MicroMsg.MMSightCamera", "auto focus not back");
        }

        public d(c cVar, Looper looper) {
            this.hmZ = cVar;
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
                v.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", new Object[]{e.getMessage()});
                maxZoom = 0;
            }
            return maxZoom;
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            Camera camera;
            int zoom;
            switch (message.what) {
                case 4353:
                    if (!this.hng) {
                        int d;
                        camera = (Camera) message.obj;
                        Parameters parameters = camera.getParameters();
                        v.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[]{Boolean.valueOf(this.hmv), Integer.valueOf(this.hne), Integer.valueOf(parameters.getZoom())});
                        zoom = parameters.getZoom() + this.hne;
                        if (this.hmv) {
                            d = d(parameters);
                            if (zoom < d) {
                                sendMessageDelayed(obtainMessage(4353, message.obj), this.hnf ? 10 : 20);
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
                        } catch (Exception e) {
                        }
                        if (z) {
                            this.hni = 0;
                            this.hnj = 0;
                            return;
                        }
                        return;
                    }
                    return;
                case 4354:
                    camera = (Camera) message.obj;
                    if (this.hni == 0 || this.hni == 0 || com.tencent.mm.compatible.util.d.dX(14)) {
                        d(camera);
                        return;
                    }
                    float f = this.hnh;
                    float f2 = this.gLd;
                    zoom = this.hni;
                    int i = this.hnj;
                    if (camera == null) {
                        v.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
                    }
                    if (c.hmV) {
                        c.hmV = false;
                        try {
                            v.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(zoom), Integer.valueOf(i)});
                            v.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[]{a(f, f2, 1.0f, zoom, i), a(f, f2, DownloadHelper.SAVE_FATOR, zoom, i)});
                            Parameters parameters2 = camera.getParameters();
                            List supportedFocusModes = parameters2.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                                parameters2.setFocusMode("auto");
                            }
                            if (parameters2.getMaxNumFocusAreas() > 0) {
                                supportedFocusModes = new ArrayList(1);
                                supportedFocusModes.add(new Area(r7, BaseReportManager.MAX_READ_COUNT));
                                parameters2.setFocusAreas(supportedFocusModes);
                            }
                            if (parameters2.getMaxNumMeteringAreas() > 0) {
                                supportedFocusModes = new ArrayList(1);
                                supportedFocusModes.add(new Area(r2, BaseReportManager.MAX_READ_COUNT));
                                parameters2.setMeteringAreas(supportedFocusModes);
                            }
                            camera.setParameters(parameters2);
                            camera.autoFocus(this.hmZ.hmW);
                            return;
                        } catch (Exception e2) {
                            v.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[]{e2.getMessage()});
                            c.hmV = true;
                            return;
                        }
                    }
                    v.w("MicroMsg.MMSightCamera", "auto focus not back");
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void a(c cVar) {
        if (true != cVar.hmU && cVar.mContext != null) {
            if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.e.b.sf()) {
                jv jvVar = new jv();
                jvVar.bky.type = 2;
                com.tencent.mm.sdk.c.a.nhr.z(jvVar);
                if (jvVar.bkz.bkx) {
                    cVar.hmU = true;
                    return;
                }
                h f = g.f(cVar.mContext, 2131235313, 2131231164);
                if (f != null) {
                    f.setCancelable(false);
                    f.setCanceledOnTouchOutside(false);
                    f.show();
                    cVar.hmU = true;
                }
            }
        }
    }

    static /* synthetic */ boolean a(c cVar, byte[] bArr) {
        be.Nj();
        if (cVar.hmJ == null || cVar.hmJ.size() == 0) {
            return false;
        }
        boolean z = false;
        for (b au : cVar.hmJ) {
            z = au.au(bArr) | z;
        }
        return z;
    }

    public c(VideoTransPara videoTransPara, int i) {
        this.hmR = videoTransPara;
        this.scene = i;
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.hmJ.add(bVar);
        }
    }

    public final void a(a aVar) {
        this.hmK = aVar;
        if (aVar == a.Stoping) {
            a azP = a.azP();
            String bnP = this.hmM.bnP();
            String bnP2 = this.hmL.bnP();
            com.tencent.mm.plugin.base.a.b bVar = this.hmI;
            int i = bVar.eng == 0 ? 0 : bVar.enf / bVar.eng;
            azP.hma = (int) (be.KN(bnP) * 10.0d);
            azP.hmb = (int) (be.KN(bnP2) * 10.0d);
            azP.hmh = i;
        }
    }

    public final void azR() {
        if (!(this.aHA == null || this.hmB == null)) {
            this.aHA.unregisterListener(this);
        }
        v.i("MicroMsg.MMSightCamera", this.hmL.getValue());
        v.i("MicroMsg.MMSightCamera", this.hmM.getValue());
        v.i("MicroMsg.MMSightCamera", this.hmN.getValue());
        v.i("MicroMsg.MMSightCamera", this.hmO.getValue());
        v.i("MicroMsg.MMSightCamera", this.hmP.getValue());
        v.i("MicroMsg.MMSightCamera", this.hmQ.getValue());
        if (this.cdl != null) {
            long Nj = be.Nj();
            v.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[]{Looper.myLooper()});
            this.hmX.removeCallbacksAndMessages(null);
            this.hmX.hng = true;
            this.cdl.setPreviewCallback(null);
            this.cdl.stopPreview();
            this.cdl.release();
            this.cdl = null;
            this.hmx = false;
            v.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[]{Long.valueOf(be.az(Nj)), Looper.myLooper()});
        }
        this.hmv = false;
        this.hmC = 0.0f;
        this.hmD = 0.0f;
        this.hmE = 0.0f;
        hmV = true;
        this.mContext = null;
        this.hmU = false;
        this.hmF = null;
        this.hmG = null;
    }

    private boolean a(Camera camera, boolean z) {
        if (camera == null) {
            return false;
        }
        try {
            a azP;
            boolean z2;
            Parameters parameters = camera.getParameters();
            Point ch = com.tencent.mm.plugin.mmsight.b.ch(this.mContext);
            List supportedPreviewSizes;
            List supportedPictureSizes;
            int i;
            if (this.hmY) {
                azP = a.azP();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i = this.hmA.cdi;
                if (be.kS(azP.hlQ)) {
                    azP.hlQ = com.tencent.mm.plugin.mmsight.b.aM(supportedPreviewSizes);
                }
                if (be.kS(azP.hlR)) {
                    azP.hlR = com.tencent.mm.plugin.mmsight.b.aM(supportedPictureSizes);
                }
                azP.cdi = i;
                azP.hmm = 1;
            } else {
                azP = a.azP();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i = this.hmA.cdi;
                if (be.kS(azP.hlS)) {
                    azP.hlS = com.tencent.mm.plugin.mmsight.b.aM(supportedPreviewSizes);
                }
                if (be.kS(azP.hlT)) {
                    azP.hlT = com.tencent.mm.plugin.mmsight.b.aM(supportedPictureSizes);
                }
                azP.cdi = i;
                azP.hmm = 2;
            }
            if (z) {
                z2 = this.hmA.cdi == 90 || this.hmA.cdi == 270;
                g.a(parameters, z2);
            }
            i.aAw();
            int aAy = i.aAy();
            z2 = this.hmA.cdi == 90 || this.hmA.cdi == 270;
            com.tencent.mm.plugin.mmsight.model.d.b a = d.a(parameters, ch, aAy, 0, z2);
            g.a(a);
            Point point = a.hnk;
            if (point == null) {
                com.tencent.mm.plugin.report.service.g.iuh.a(440, 140, 0, false);
            }
            this.hmu.lFr = point.x;
            this.hmu.lFq = point.y;
            this.hmF = point;
            Context context = this.mContext;
            z2 = this.hmA.cdi == 90 || this.hmA.cdi == 270;
            v.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.mmsight.b.a(context, point, z2))});
            if (com.tencent.mm.plugin.mmsight.b.a(context, point, z2)) {
                if (g.hns.ceR == 2) {
                    this.hmG = a.hnm;
                } else {
                    this.hmG = a.hnl;
                }
                this.hmF = new Point(this.hmG.x, this.hmG.y);
                this.hmH = ((this.hmG.x * this.hmG.y) * 3) / 2;
                v.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[]{this.hmG});
            }
            if (g.hns.hnD) {
                Object obj = 1;
                if (this.hmA.cdi == 90 || this.hmA.cdi == 270) {
                    if (point.y < this.hmR.width || point.x < this.hmR.height) {
                        obj = null;
                        v.w("MicroMsg.MMSightCamera", "previewSize %s not support", new Object[]{point});
                    }
                    if (obj != null) {
                        int i2;
                        aAy = this.hmR.height;
                        if (this.hmG == null) {
                            i2 = point.x;
                        } else {
                            i2 = this.hmG.x;
                        }
                        aAy = com.tencent.mm.plugin.mmsight.b.bO(aAy, i2);
                        int i3 = this.hmR.width;
                        if (this.hmG == null) {
                            i2 = point.y;
                        } else {
                            i2 = this.hmG.y;
                        }
                        this.hmF = new Point(aAy, com.tencent.mm.plugin.mmsight.b.bO(i3, i2));
                    }
                } else {
                    if (point.x < this.hmR.width || point.y < this.hmR.height) {
                        obj = null;
                        v.w("MicroMsg.MMSightCamera", "previewSize %s not support", new Object[]{point});
                    }
                    if (obj != null) {
                        this.hmF = new Point(com.tencent.mm.plugin.mmsight.b.bO(this.hmR.width, this.hmG == null ? point.y : this.hmG.y), com.tencent.mm.plugin.mmsight.b.bO(this.hmR.height, this.hmG == null ? point.x : this.hmG.x));
                    }
                }
            }
            azP = a.azP();
            ch = this.hmG;
            Point point2 = this.hmF;
            azP.hlZ = -1;
            azP.hlY = -1;
            azP.hlV = -1;
            azP.hlU = -1;
            azP.hlX = -1;
            azP.hlW = -1;
            if (point != null) {
                azP.hlW = point.x;
                azP.hlX = point.y;
            }
            if (ch != null) {
                azP.hlU = ch.x;
                azP.hlV = ch.y;
            }
            if (point2 != null) {
                azP.hlY = point2.x;
                azP.hlZ = point2.y;
            }
            if (z) {
                g.b(this.hmF);
            }
            v.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[]{point, this.hmF, this.hmG});
            parameters.setPreviewSize(this.hmu.lFr, this.hmu.lFq);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            v.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    @TargetApi(14)
    private static boolean a(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            v.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
            Parameters parameters = camera.getParameters();
            if (parameters.getMaxNumMeteringAreas() > 0) {
                List arrayList = new ArrayList();
                arrayList.add(new Area(new Rect(-1000, -1000, BaseReportManager.MAX_READ_COUNT, BaseReportManager.MAX_READ_COUNT), 600));
                parameters.setMeteringAreas(arrayList);
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            v.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
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
                    v.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
                } else {
                    try {
                        parameters.setPreviewFrameRate(Math.min(30, ((Integer) Collections.max(parameters.getSupportedPreviewFrameRates())).intValue()));
                        v.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", new Object[]{Integer.valueOf(i)});
                    } catch (Exception e) {
                        v.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
                    }
                }
            } else if (p.ceA.ccR > 0) {
                v.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
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
                            v.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", new Object[]{Integer.valueOf(i4), Integer.valueOf(i6), Integer.valueOf(i)});
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
                    v.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(30)});
                    if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
                        try {
                            parameters.setPreviewFpsRange(i2, i3);
                            v.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                        } catch (Exception e2) {
                            v.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[]{Looper.myLooper(), e2.getMessage()});
                        }
                    }
                }
            }
            List supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            v.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", new Object[]{Boolean.valueOf(z), supportedPreviewFrameRates});
            camera.setParameters(parameters);
            return true;
        } catch (Exception e22) {
            v.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", new Object[]{Looper.myLooper(), e22.getMessage()});
            return false;
        }
    }

    private static boolean b(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            v.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
            Parameters parameters = camera.getParameters();
            List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(Integer.valueOf(17))) {
                v.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            v.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
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
            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                v.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                parameters.setFocusMode("continuous-picture");
            } else if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-video")) {
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("auto")) {
                        v.i("MicroMsg.MMSightCameraSetting", "support auto focus");
                        parameters.setFocusMode("auto");
                    }
                }
                v.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
            } else {
                v.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                parameters.setFocusMode("continuous-video");
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            v.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    @TargetApi(11)
    public final int a(SurfaceTexture surfaceTexture, boolean z) {
        long Nj = be.Nj();
        v.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[]{Boolean.valueOf(this.hmx), Looper.myLooper(), surfaceTexture, Boolean.valueOf(z)});
        if (this.hmx) {
            return 0;
        }
        if (surfaceTexture == null) {
            return 0 - com.tencent.mm.compatible.util.g.sk();
        }
        boolean z2;
        v.i("MicroMsg.MMSightCamera", "this texture %s", new Object[]{surfaceTexture});
        a(this.cdl, z);
        Integer valueOf = Integer.valueOf(i.aAw().hoH.lUm);
        String str = "MicroMsg.MMSightCamera";
        String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
        Object[] objArr = new Object[6];
        objArr[0] = valueOf;
        String str3 = p.ceA.ccW == 1 ? "Range" : p.ceA.ccV == 1 ? "Fix" : "Error";
        objArr[1] = str3;
        if (p.ceA.ccX == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        if (p.ceA.ccY == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[3] = Boolean.valueOf(z2);
        if (p.ceA.ccZ == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[4] = Boolean.valueOf(z2);
        if (p.ceA.cda == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[5] = Boolean.valueOf(z2);
        v.i(str, str2, objArr);
        if (p.ceA.ccW == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
            b(this.cdl, false);
        } else if (p.ceA.ccV == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
            b(this.cdl, true);
        }
        if (p.ceA.ccX == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
            b(this.cdl);
        }
        if (p.ceA.ccY == 1 && ((valueOf.intValue() == 0 || valueOf.intValue() == 3) && com.tencent.mm.compatible.util.d.dY(14))) {
            a(this.cdl);
        }
        if (p.ceA.ccZ == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
            c(this.cdl);
        }
        if (p.ceA.cda == 1 && valueOf.intValue() != 0) {
            valueOf.intValue();
        }
        Camera camera = this.cdl;
        try {
            Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                parameters.setZoom(0);
            }
            camera.setParameters(parameters);
        } catch (Exception e) {
            v.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", new Object[]{e.getMessage()});
        }
        try {
            if (this.cdl != null) {
                try {
                    Parameters parameters2 = this.cdl.getParameters();
                    if (this.hmJ != null && this.hmJ.size() > 0) {
                        int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters2.getPreviewFormat()) * (this.hmu.lFr * this.hmu.lFq)) / 8;
                        for (int i = 0; i < 5; i++) {
                            this.cdl.addCallbackBuffer(com.tencent.mm.plugin.mmsight.model.a.h.hoF.h(Integer.valueOf(bitsPerPixel)));
                        }
                        this.hmL.reset();
                        this.hmM.reset();
                        this.hmN.reset();
                        this.hmO.reset();
                        this.hmP.reset();
                        this.hmQ.reset();
                        this.hmI = new com.tencent.mm.plugin.base.a.b();
                        this.cdl.setPreviewCallbackWithBuffer(new PreviewCallback(this) {
                            final /* synthetic */ c hmZ;

                            {
                                this.hmZ = r1;
                            }

                            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                                boolean z = false;
                                if (bArr == null || bArr.length <= 0) {
                                    c.a(this.hmZ);
                                    return;
                                }
                                byte[] bArr2;
                                com.tencent.mm.plugin.base.a.b b = this.hmZ.hmI;
                                if (b.enh == 0) {
                                    b.eng++;
                                    b.enf = be.KL(l.rA());
                                }
                                b.enh++;
                                b.enh = b.enh >= 90 ? 0 : b.enh;
                                if (this.hmZ.hmT || this.hmZ.hmJ == null || this.hmZ.hmJ.size() <= 0) {
                                    bArr2 = bArr;
                                } else if (this.hmZ.hmG != null) {
                                    byte[] h = com.tencent.mm.plugin.mmsight.model.a.h.hoF.h(Integer.valueOf(((this.hmZ.hmG.x * this.hmZ.hmG.y) * 3) / 2));
                                    this.hmZ.hmN.dO(1);
                                    r4 = be.Nj();
                                    SightVideoJNI.cropCameraData(bArr, h, this.hmZ.hmu.lFr, this.hmZ.hmu.lFq, this.hmZ.hmG.y);
                                    this.hmZ.hmO.dO(be.az(r4));
                                    if (!this.hmZ.hmY) {
                                        r4 = be.Nj();
                                        r0 = this.hmZ.hmG.x;
                                        int i = this.hmZ.hmG.y;
                                        if (this.hmZ.hmA.cdi == 270 || this.hmZ.hmA.cdi == 90) {
                                            z = true;
                                        }
                                        SightVideoJNI.mirrorCameraData(h, r0, i, z);
                                        this.hmZ.hmP.dO(be.az(r4));
                                    }
                                    long j = r4;
                                    boolean a = c.a(this.hmZ, h);
                                    j = be.az(j);
                                    if (a) {
                                        this.hmZ.hmQ.dO(j);
                                    }
                                    bArr2 = h;
                                } else {
                                    r4 = be.Nj();
                                    if (!this.hmZ.hmY) {
                                        r0 = this.hmZ.hmu.lFr;
                                        int i2 = this.hmZ.hmu.lFq;
                                        if (this.hmZ.hmA.cdi == 270 || this.hmZ.hmA.cdi == 90) {
                                            z = true;
                                        }
                                        SightVideoJNI.mirrorCameraData(bArr, r0, i2, z);
                                        this.hmZ.hmP.dO(be.az(r4));
                                    }
                                    boolean a2 = c.a(this.hmZ, bArr);
                                    long az = be.az(r4);
                                    if (a2) {
                                        this.hmZ.hmQ.dO(az);
                                    }
                                    if (a2) {
                                        bArr2 = bArr;
                                        bArr = com.tencent.mm.plugin.mmsight.model.a.h.hoF.h(Integer.valueOf(bArr.length));
                                    } else {
                                        bArr2 = bArr;
                                    }
                                }
                                this.hmZ.hmS = bArr2;
                                if (this.hmZ.hmK == a.Preview) {
                                    this.hmZ.hmM.dO(1);
                                } else if (this.hmZ.hmK == a.Recording) {
                                    this.hmZ.hmL.dO(1);
                                }
                                this.hmZ.cdl.addCallbackBuffer(bArr);
                            }
                        });
                    }
                } catch (Exception e2) {
                    v.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", new Object[]{e2.getMessage()});
                }
            }
            this.cdl.setPreviewTexture(surfaceTexture);
            this.cdl.startPreview();
            if (!g.hns.hnE) {
                this.aHA.registerListener(this, this.hmB, 2);
            } else if (!(p.ceA.ccZ != 0 || this.aHA == null || this.hmB == null)) {
                this.aHA.registerListener(this, this.hmB, 2);
            }
            this.hmx = true;
            v.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[]{Long.valueOf(be.az(Nj)), Looper.myLooper()});
            return 0;
        } catch (Exception e22) {
            v.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[]{Looper.myLooper(), e22.getMessage()});
            return 0 - com.tencent.mm.compatible.util.g.sk();
        }
    }

    public final String azT() {
        if (this.cdl == null) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList c = com.tencent.mm.plugin.mmsight.b.c(this.cdl.getParameters());
            Point ch = com.tencent.mm.plugin.mmsight.b.ch(this.mContext);
            stringBuffer.append(String.format("Screen size %d %d r:%.4f\n", new Object[]{Integer.valueOf(ch.x), Integer.valueOf(ch.y), Double.valueOf((((double) ch.x) * 1.0d) / ((double) ch.y))}));
            Iterator it = c.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                if ((azU() == size.width && azV() == size.height) || (azU() == size.height && azV() == size.width)) {
                    stringBuffer.append(String.format("%s*%s √ r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                } else {
                    stringBuffer.append(String.format("%s*%s X r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                }
            }
            if (this.hmG != null) {
                stringBuffer.append("\n SIGHTCROPMODE:  " + this.hmG.x + " " + this.hmG.y + " from " + this.hmu.lFr + " " + this.hmu.lFq);
            }
            stringBuffer.append("\ngetOrientation:" + getOrientation());
            return stringBuffer.toString();
        } catch (Exception e) {
            v.e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.hmC - f) > 5.0f || Math.abs(this.hmD - f2) > 5.0f || Math.abs(this.hmE - f3) > 5.0f) {
            v.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[]{Float.valueOf(5.0f), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            this.hmX.d(this.cdl);
            this.hmC = f;
            this.hmD = f2;
            this.hmE = f3;
        }
    }

    public final void a(boolean z, boolean z2, int i) {
        if (this.cdl != null && this.hmx) {
            try {
                v.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[]{Boolean.valueOf(z)});
                if (this.hmw) {
                    v.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
                    return;
                }
                Parameters parameters = this.cdl.getParameters();
                if (parameters.isZoomSupported()) {
                    int i2;
                    this.hmw = true;
                    int zoom = parameters.getZoom();
                    int maxZoom = parameters.getMaxZoom();
                    if (!z2) {
                        if (this.hms <= 0) {
                            this.hms = Math.round(((float) maxZoom) / 15.0f);
                            if (this.hms > 5) {
                                this.hms = 5;
                            }
                        }
                        i2 = this.hms;
                    } else if (this.hmt <= 0) {
                        v.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[]{Integer.valueOf(this.hmt)});
                        this.hmw = false;
                        return;
                    } else {
                        i2 = this.hmt;
                    }
                    v.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[]{Integer.valueOf(zoom), Integer.valueOf(maxZoom), Integer.valueOf(this.hms), Integer.valueOf(this.hmt), Integer.valueOf(i)});
                    if (i > 0) {
                        i2 *= i;
                    }
                    if (z) {
                        if (zoom >= maxZoom) {
                            this.hmw = false;
                            return;
                        }
                        i2 += zoom;
                        if (i2 < maxZoom) {
                            maxZoom = i2;
                        }
                    } else if (zoom == 0) {
                        this.hmw = false;
                        return;
                    } else {
                        maxZoom = zoom - i2;
                        if (maxZoom <= 0) {
                            maxZoom = 0;
                        }
                    }
                    v.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[]{Integer.valueOf(maxZoom)});
                    parameters.setZoom(maxZoom);
                    this.cdl.setParameters(parameters);
                }
                this.hmw = false;
            } catch (Exception e) {
                v.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", new Object[]{e.getMessage()});
            } finally {
                this.hmw = false;
            }
        }
    }

    public final boolean f(Activity activity, boolean z) {
        if (!g.hns.hnE || (p.ceA.ccZ == 0 && this.aHA == null && this.hmB == null)) {
            this.aHA = (SensorManager) activity.getSystemService("sensor");
            this.hmB = this.aHA.getDefaultSensor(1);
        }
        if (this.cdl == null) {
            azR();
            this.hmY = z;
            if (z) {
                try {
                    this.hmy = com.tencent.mm.compatible.d.c.rs();
                } catch (Throwable e) {
                    v.a("MicroMsg.MMSightCamera", e, "try to get cameraid error %s, useBackCamera: %s", new Object[]{e.getMessage(), Boolean.valueOf(this.hmY)});
                    this.hmy = 0;
                }
            } else {
                int numberOfCameras = Camera.getNumberOfCameras();
                CameraInfo cameraInfo = new CameraInfo();
                int i = 0;
                while (i < numberOfCameras) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        v.d("MicroMsg.CameraUtil", "tigercam get fid %d", new Object[]{Integer.valueOf(i)});
                        break;
                    }
                    i++;
                }
                i = 0;
                v.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[]{Integer.valueOf(i)});
                this.hmy = i;
            }
            v.i("MicroMsg.MMSightCamera", "use camera id %d, DeviceInfo id %d", new Object[]{Integer.valueOf(this.hmy), Integer.valueOf(p.ceA.cdb)});
            this.hmU = false;
            this.mContext = activity;
            this.hmA = new k().b(activity, this.hmy);
            v.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[]{Looper.myLooper()});
            if (this.hmA == null) {
                v.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[]{Looper.myLooper()});
                return false;
            }
            this.cdl = this.hmA.cdl;
            this.hmX.hng = false;
            this.hmu.cdi = this.hmA.cdi;
            if (this.cdl == null) {
                v.e("MicroMsg.MMSightCamera", "start camera FAILED!");
                return false;
            }
        }
        return true;
    }

    public final boolean a(Activity activity, SurfaceTexture surfaceTexture, boolean z) {
        v.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[]{Boolean.valueOf(this.hmY)});
        try {
            azR();
            f(activity, !this.hmY);
            a(surfaceTexture, z);
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[]{e});
            return false;
        }
    }

    public final int azU() {
        if (this.cdl == null || this.hmA == null) {
            return 0;
        }
        try {
            return this.hmG == null ? (this.hmA.cdi == 0 || this.hmA.cdi == 180) ? this.hmu.lFr : this.hmu.lFq : (this.hmA.cdi == 0 || this.hmA.cdi == 180) ? this.hmG.x : this.hmG.y;
        } catch (Exception e) {
            v.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", new Object[]{e.getMessage()});
            return 0;
        }
    }

    public final int azV() {
        if (this.cdl == null || this.hmA == null) {
            return 0;
        }
        try {
            return this.hmG == null ? (this.hmA.cdi == 0 || this.hmA.cdi == 180) ? this.hmu.lFq : this.hmu.lFr : (this.hmA.cdi == 0 || this.hmA.cdi == 180) ? this.hmG.y : this.hmG.x;
        } catch (Exception e) {
            v.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", new Object[]{e.getMessage()});
            return 0;
        }
    }

    public final int getOrientation() {
        if (this.hmA == null || !this.hmx) {
            return -1;
        }
        return this.hmA.cdi;
    }
}

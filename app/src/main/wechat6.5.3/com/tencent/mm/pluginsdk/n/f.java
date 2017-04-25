package com.tencent.mm.pluginsdk.n;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.c.a.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class f implements SensorEventListener {
    static int hmy = 0;
    SensorManager aHA;
    Camera cdl = null;
    private SurfaceHolder dVL = null;
    a hmA;
    Sensor hmB;
    private float hmC = 0.0f;
    private float hmD = 0.0f;
    private float hmE = 0.0f;
    private boolean hmx = false;
    private PreviewCallback iXa = null;
    a lFP;
    List<Integer> lFQ = new ArrayList();
    private boolean lFR = true;
    private boolean lFS = true;
    private AutoFocusCallback lFT = new AutoFocusCallback(this) {
        final /* synthetic */ f lFU;

        {
            this.lFU = r1;
        }

        public final void onAutoFocus(boolean z, Camera camera) {
            v.d("MicroMsg.YuvReocrder", "auto focus callback");
            this.lFU.lFS = true;
        }
    };

    public static int bow() {
        return hmy;
    }

    public final void azR() {
        if (!(this.aHA == null || this.hmB == null)) {
            this.aHA.unregisterListener(this);
        }
        if (this.cdl != null) {
            v.d("MicroMsg.YuvReocrder", "release camera");
            this.cdl.setPreviewCallback(null);
            this.cdl.stopPreview();
            this.cdl.release();
            this.cdl = null;
            this.hmx = false;
        }
    }

    @TargetApi(9)
    private static void f(Parameters parameters) {
        int i = Integer.MIN_VALUE;
        if (p.ceA.ccR <= 0 && VERSION.SDK_INT >= 9) {
            List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            if (supportedPreviewFpsRange != null && supportedPreviewFpsRange.size() != 0) {
                int size = supportedPreviewFpsRange.size();
                int i2 = 0;
                int i3 = Integer.MIN_VALUE;
                while (i2 < size) {
                    int i4;
                    int[] iArr = (int[]) supportedPreviewFpsRange.get(i2);
                    if (iArr != null && iArr.length > 1) {
                        int i5 = iArr[0];
                        i4 = iArr[1];
                        v.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(i4)});
                        if (i5 >= 0 && i4 >= i5 && i4 >= i) {
                            i = i5;
                            i2++;
                            i3 = i;
                            i = i4;
                        }
                    }
                    i4 = i;
                    i = i3;
                    i2++;
                    i3 = i;
                    i = i4;
                }
                v.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", new Object[]{Integer.valueOf(i3), Integer.valueOf(i)});
                if (i3 != Integer.MAX_VALUE && i != Integer.MAX_VALUE) {
                    try {
                        parameters.setPreviewFpsRange(i3, i);
                    } catch (Throwable e) {
                        v.a("MicroMsg.YuvReocrder", e, "", new Object[0]);
                    }
                }
            }
        }
    }

    public final int c(SurfaceHolder surfaceHolder) {
        if (this.hmx) {
            return 0;
        }
        if (surfaceHolder == null) {
            return 0 - g.sk();
        }
        try {
            List a;
            this.dVL = surfaceHolder;
            Parameters parameters = this.cdl.getParameters();
            a aVar = this.lFP;
            v.d("MicroMsg.YuvReocrder", "getFitRecordSize");
            int i = Integer.MAX_VALUE;
            List b = c.b(parameters);
            if (b == null) {
                v.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
                a = c.a(parameters);
            } else {
                a = b;
            }
            Size previewSize;
            if (a != null) {
                int i2 = 0;
                boolean z = false;
                while (i2 < a.size()) {
                    int i3;
                    boolean z2;
                    int i4 = ((Size) a.get(i2)).height;
                    int i5 = ((Size) a.get(i2)).width;
                    v.d("MicroMsg.YuvReocrder", "supp w:" + i5 + " h:" + i4);
                    int i6 = i4 * i5;
                    if ((((aVar.cdi == 0 || aVar.cdi == 180) && i4 >= aVar.lFt && i5 >= aVar.lFu) || ((aVar.cdi == 90 || aVar.cdi == 270) && i5 >= aVar.lFt && i4 >= aVar.lFu)) && i6 < i) {
                        aVar.lFr = i5;
                        aVar.lFq = i4;
                        i3 = i6;
                        z2 = true;
                    } else {
                        z2 = z;
                        i3 = i;
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
            v.d("MicroMsg.YuvReocrder", " rotate:" + aVar.cdi + " w:" + aVar.lFr + " h:" + aVar.lFq);
            parameters.setPreviewSize(this.lFP.lFr, this.lFP.lFq);
            f(parameters);
            Collection supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            this.lFQ.clear();
            this.lFQ.addAll(supportedPreviewFrameRates);
            parameters.setPreviewFormat(17);
            b = parameters.getSupportedFocusModes();
            if (b != null) {
                if (d.dY(9) && true == b.contains("continuous-video")) {
                    v.i("MicroMsg.YuvReocrder", "support continous-video");
                    this.lFR = false;
                    parameters.setFocusMode("continuous-video");
                } else if (!b.contains("auto")) {
                    v.i("MicroMsg.YuvReocrder", "don't support auto");
                    this.lFR = false;
                }
            }
            this.cdl.setParameters(parameters);
            this.cdl.setPreviewDisplay(surfaceHolder);
            this.cdl.startPreview();
            if (!(this.aHA == null || this.hmB == null || !this.lFR)) {
                this.aHA.registerListener(this, this.hmB, 2);
            }
            this.hmx = true;
            return 0;
        } catch (Throwable e) {
            v.a("MicroMsg.YuvReocrder", e, "", new Object[0]);
            v.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + e.getMessage());
            return 0 - g.sk();
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if ((Math.abs(this.hmC - f) > 2.0f || Math.abs(this.hmD - f2) > 2.0f || Math.abs(this.hmE - f3) > 2.0f) && this.cdl != null && this.lFS && true == this.lFR) {
            try {
                v.d("MicroMsg.YuvReocrder", "auto focus");
                this.cdl.autoFocus(this.lFT);
                this.lFS = false;
            } catch (Exception e) {
                v.d("MicroMsg.YuvReocrder", "auto focus failed");
            }
        }
        this.hmC = f;
        this.hmD = f2;
        this.hmE = f3;
    }
}

package com.tencent.mm.plugin.scanner.b;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.w;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public final class h {
    private static final Pattern iDD = Pattern.compile(",");
    public Activity bij;
    public Camera cdl;
    public Point iAO = null;
    public boolean iDE = false;
    public int iDF = 0;
    public Point iDG = null;
    public Point iDH = null;
    public boolean iDI;
    public boolean iDJ;
    public Rect iDK;
    public Rect iDL;
    public int iDM;
    public Rect iDN;
    public boolean iDO = false;
    public String iDP = "";

    private static class a implements Comparator<Size> {
        private a() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            return i2 > i ? 1 : 0;
        }
    }

    public h(Activity activity, int i, boolean z) {
        Point point;
        this.bij = activity;
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            point = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        } else {
            point = w.ep(activity);
        }
        this.iDG = point;
        this.iDJ = z;
        this.iDF = i;
    }

    public final void b(SurfaceTexture surfaceTexture) {
        long Nj = be.Nj();
        if (this.cdl != null && !this.iDE) {
            if (surfaceTexture != null) {
                this.cdl.setPreviewTexture(surfaceTexture);
            }
            this.cdl.startPreview();
            this.iDE = true;
            v.d("MicroMsg.scanner.ScanCamera", "startPreview done costTime=[%s]", new Object[]{Long.valueOf(be.az(Nj))});
        }
    }

    public final void a(PreviewCallback previewCallback) {
        if (this.cdl != null && this.iDE) {
            try {
                this.cdl.setOneShotPreviewCallback(previewCallback);
            } catch (RuntimeException e) {
                v.w("MicroMsg.scanner.ScanCamera", "takeOneShot() " + e.getMessage());
            }
        }
    }

    public final boolean isOpen() {
        if (this.cdl != null) {
            return true;
        }
        return false;
    }

    public final void release() {
        v.d("MicroMsg.scanner.ScanCamera", "release(), previewing = [%s]", new Object[]{Boolean.valueOf(this.iDE)});
        if (this.cdl != null) {
            long Nj = be.Nj();
            if (this.iDE) {
                this.cdl.setPreviewCallback(null);
                this.cdl.stopPreview();
                this.iDE = false;
                v.d("MicroMsg.scanner.ScanCamera", "stopPreview costTime=[%s]", new Object[]{Long.valueOf(be.az(Nj))});
            }
            Nj = be.Nj();
            this.cdl.release();
            this.cdl = null;
            v.d("MicroMsg.scanner.ScanCamera", "camera.release() costTime=[%s]", new Object[]{Long.valueOf(be.az(Nj))});
        }
        this.iDO = false;
        this.iDF = 0;
    }

    public final float aLT() {
        if (!this.iDI || this.iDJ) {
            return ((float) this.iDH.x) / ((float) this.iAO.x);
        }
        return ((float) this.iDH.x) / ((float) this.iAO.y);
    }

    public final float aLU() {
        if (!this.iDI || this.iDJ) {
            return ((float) this.iDH.y) / ((float) this.iAO.y);
        }
        return ((float) this.iDH.y) / ((float) this.iAO.x);
    }

    public final void i(Rect rect) {
        if (this.cdl != null && !this.iDO) {
            try {
                List arrayList;
                Parameters parameters = this.cdl.getParameters();
                if (this.iDN == null) {
                    if (rect != null) {
                        this.iDN = new Rect();
                        this.iDN.left = ((int) ((((float) rect.left) / ((float) this.iDH.x)) * 2000.0f)) - 1000;
                        this.iDN.right = ((int) ((((float) rect.right) / ((float) this.iDH.x)) * 2000.0f)) - 1000;
                        this.iDN.top = ((int) ((((float) rect.top) / ((float) this.iDH.y)) * 2000.0f)) - 1000;
                        this.iDN.bottom = ((int) ((((float) rect.bottom) / ((float) this.iDH.y)) * 2000.0f)) - 1000;
                    } else {
                        return;
                    }
                }
                v.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, area: %s, scanDisplayRect: %s, visibleResolution: %s", new Object[]{this.iDN, rect, this.iDH});
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    arrayList = new ArrayList();
                    arrayList.add(new Area(this.iDN, BaseReportManager.MAX_READ_COUNT));
                    parameters.setMeteringAreas(arrayList);
                } else {
                    v.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, camera not support set metering area");
                }
                if (parameters.getMaxNumFocusAreas() > 0) {
                    arrayList = new ArrayList();
                    arrayList.add(new Area(this.iDN, BaseReportManager.MAX_READ_COUNT));
                    parameters.setFocusAreas(arrayList);
                    return;
                }
                v.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, camera not support area focus");
            } catch (Exception e) {
                v.e("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public static Point a(Parameters parameters, Point point, Point point2, boolean z) {
        String str;
        String str2 = parameters.get("preview-size-values");
        if (str2 == null) {
            str = parameters.get("preview-size-value");
        } else {
            str = str2;
        }
        Point point3 = null;
        if (str != null) {
            v.d("MicroMsg.scanner.ScanCamera", "preview-size-values parameter: " + str);
            point3 = a(parameters, point, z);
        }
        if (point3 == null) {
            return new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        return point3;
    }

    private static Point a(Parameters parameters, Point point, boolean z) {
        List<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        arrayList.remove(0);
        Point point2 = null;
        v.d("MicroMsg.scanner.ScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y))});
        v.i("MicroMsg.scanner.ScanCamera", "SCREEN_PIXELS: %s, MAX_PREVIEW_PIXELS_USE_BIGGER: %s", new Object[]{Integer.valueOf(point.x * point.y), Integer.valueOf(2073600)});
        float f = Float.POSITIVE_INFINITY;
        for (Size size : arrayList) {
            Size size2;
            int i = size2.width;
            int i2 = size2.height;
            v.i("MicroMsg.scanner.ScanCamera", "realWidth: %d, realHeight: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            int i3 = i * i2;
            if (i3 >= 150400 && i3 <= 2073600) {
                if (i3 <= r7 || Math.min(point.x, point.y) < 720) {
                    int i4;
                    Object obj = i > i2 ? 1 : null;
                    if (obj == null || z) {
                        i4 = i;
                    } else {
                        i4 = i2;
                    }
                    if (obj == null || z) {
                        i3 = i2;
                    } else {
                        i3 = i;
                    }
                    v.d("MicroMsg.scanner.ScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)});
                    if (i4 == point.x && i3 == point.y) {
                        point2 = new Point(i, i2);
                        v.i("MicroMsg.scanner.ScanCamera", "Found preview size exactly matching screen size: " + point2);
                        return point2;
                    }
                    Point point3;
                    float f2;
                    float abs = Math.abs((((float) i4) / ((float) i3)) - r6);
                    if (abs < f) {
                        point3 = new Point(i, i2);
                        f2 = abs;
                    } else {
                        f2 = f;
                        point3 = point2;
                    }
                    v.i("MicroMsg.scanner.ScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[]{Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i), Integer.valueOf(i2)});
                    point2 = point3;
                    f = f2;
                }
            }
        }
        if (point2 == null) {
            size2 = parameters.getPreviewSize();
            point2 = new Point(size2.width, size2.height);
            v.i("MicroMsg.scanner.ScanCamera", "No suitable preview sizes, using default: " + point2);
        }
        v.i("MicroMsg.scanner.ScanCamera", "Found best approximate preview size: " + point2);
        return point2;
    }

    public final void aLV() {
        try {
            v.i("MicroMsg.scanner.ScanCamera", "setToQbarZoomLevel, value: %s, camera: %s, previewing: %s", new Object[]{this.iDP, this.cdl, Boolean.valueOf(this.iDE)});
            if (this.cdl != null && this.iDE && !be.kS(this.iDP)) {
                Parameters parameters = this.cdl.getParameters();
                parameters.set("zoom", this.iDP);
                this.cdl.setParameters(parameters);
            }
        } catch (Exception e) {
            v.e("MicroMsg.scanner.ScanCamera", "setToQbarZoomLevel, error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void aLW() {
        try {
            v.i("MicroMsg.scanner.ScanCamera", "setToNormalZoomLevel camera: %s, previewing: %s", new Object[]{this.cdl, Boolean.valueOf(this.iDE)});
            if (this.cdl != null && this.iDE) {
                Parameters parameters = this.cdl.getParameters();
                parameters.set("zoom", 0);
                this.cdl.setParameters(parameters);
            }
        } catch (Exception e) {
            v.e("MicroMsg.scanner.ScanCamera", "setToNormalZoomLevel, error: %s", new Object[]{e.getMessage()});
        }
    }
}

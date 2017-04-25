package com.tencent.mm.plugin.voip.video;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.jv;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class a implements com.tencent.mm.plugin.video.a, b {
    private static final Pattern iDD = Pattern.compile(",");
    private static int kzV = 20;
    private static int kzW = 70;
    protected int QW = 240;
    protected int Zx = 320;
    protected boolean kAa = false;
    protected boolean kAb = false;
    protected long kAc = 0;
    protected long kAd = 30000;
    protected int kAe = 0;
    protected Camera kAf;
    protected Parameters kAg;
    protected Size kAh;
    protected int kAi;
    protected boolean kAj = false;
    protected boolean kAk = false;
    protected ObservableSurfaceView kAl = null;
    protected ObservableTextureView kAm;
    protected f kAn;
    protected boolean kAo = false;
    protected boolean kAp = false;
    protected byte[] kAq = null;
    protected int[] kAr = null;
    protected List<byte[]> kAs;
    protected boolean kAt = true;
    protected int kAu;
    protected int kAv = 0;
    protected int kAw = 0;
    protected int kAx = 0;
    PreviewCallback kAy = new PreviewCallback(this) {
        final /* synthetic */ a kAz;

        {
            this.kAz = r1;
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            if (bArr == null || bArr.length <= 0) {
                g.iuh.a(159, 0, 1, false);
                g.iuh.a(159, 3, 1, false);
                if (this.kAz.kAn != null) {
                    this.kAz.kAn.aCN();
                }
            } else if (this.kAz.kAh == null) {
                v.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
            } else if (this.kAz.kAn != null) {
                int i;
                int i2;
                boolean z;
                int i3;
                boolean z2;
                int i4;
                if (this.kAz.kzX) {
                    i4 = i.kCj;
                    if (p.ceA.ccH && p.ceA.ccG.cdi != 0) {
                        i = p.ceA.ccG.cdj;
                        i2 = i4;
                        z = true;
                    }
                    i2 = i4;
                    z = false;
                    i = 1;
                } else {
                    i4 = i.kCk;
                    if (p.ceA.ccJ && p.ceA.ccI.cdi != 0) {
                        i = p.ceA.ccI.cdj;
                        i2 = i4;
                        z = true;
                    }
                    i2 = i4;
                    z = false;
                    i = 1;
                }
                if (i2 > 0) {
                    i3 = 32;
                } else {
                    i3 = 0;
                }
                a aVar = this.kAz;
                if (z || i2 <= 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                aVar.kzY = z2;
                int i5 = this.kAz.kAh.width;
                int i6 = this.kAz.kAh.height;
                if (z) {
                    if (this.kAz.kAq == null) {
                        this.kAz.kAq = new byte[(((i5 * i6) * 3) / 2)];
                        this.kAz.kAq[0] = (byte) 90;
                    }
                    m bbw = d.bbw();
                    i2 = bArr.length;
                    int i7 = this.kAz.kAi;
                    byte[] bArr2 = this.kAz.kAq;
                    int length = this.kAz.kAq.length;
                    com.tencent.mm.plugin.voip.model.g gVar = bbw.kuO.kqI.kse;
                    if (gVar.ksy != com.tencent.mm.plugin.voip.model.g.ksx && gVar.kqI.ksc.hqt && gVar.kqI.bbI()) {
                        gVar.kqI.ksc.videoRorate90D(bArr, i2, i5, i6, i7, bArr2, length, i5, i6, i);
                    }
                    this.kAz.kAn.a(this.kAz.kAq, (long) this.kAz.kAq.length, i5, i6, this.kAz.kAi + i3);
                } else {
                    this.kAz.kAn.a(bArr, (long) bArr.length, this.kAz.kAh.width, this.kAz.kAh.height, this.kAz.kAi + i3);
                }
                if (com.tencent.mm.plugin.voip.b.d.bdw() >= 8) {
                    this.kAz.kAf.addCallbackBuffer(bArr);
                }
            }
        }
    };
    protected boolean kzX = false;
    protected boolean kzY = false;
    protected boolean kzZ = false;

    public a(int i, int i2) {
        this.Zx = i;
        this.QW = i2;
        i.cK(aa.getContext().getApplicationContext());
        v.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[]{Integer.valueOf(this.Zx), Integer.valueOf(this.QW)});
    }

    public final void a(ObservableSurfaceView observableSurfaceView) {
        if (observableSurfaceView != null) {
            this.kAl = observableSurfaceView;
            this.kAl.a(this);
            this.kAk = true;
        }
    }

    public final void a(ObservableTextureView observableTextureView) {
        v.d("MicroMsg.Voip.CaptureRender", "bindTextureView");
        if (observableTextureView != null) {
            this.kAm = observableTextureView;
            this.kAm.a(this);
            this.kAk = false;
        }
    }

    public final void b(SurfaceHolder surfaceHolder) {
        boolean z = false;
        v.d("MicroMsg.Voip.CaptureRender", "surfaceChange");
        if (!this.kAj || surfaceHolder.getSurface() == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "surfaceChange failed, CameraOpen: %b, surface: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.kAj);
            if (surfaceHolder.getSurface() == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            v.e(str, str2, objArr);
            return;
        }
        try {
            this.kAf.setPreviewCallback(null);
            this.kAf.stopPreview();
            this.kAf.setPreviewDisplay(surfaceHolder);
            bdC();
            this.kAf.startPreview();
        } catch (Exception e) {
            Exception exception = e;
            g.iuh.a(159, 0, 1, false);
            g.iuh.a(159, 2, 1, false);
            v.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.kAe = 1;
        }
        if (this.kAp) {
            bdE();
            this.kAp = false;
        }
        d.bbw().rN(this.kAe);
    }

    public final void a(SurfaceTexture surfaceTexture) {
        boolean z = false;
        v.d("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable");
        if (!this.kAj || surfaceTexture == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "onSurfaceTextureAvailable failed, CameraOpen: %b, surface: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.kAj);
            if (surfaceTexture == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            v.e(str, str2, objArr);
            return;
        }
        try {
            this.kAf.setPreviewCallback(null);
            this.kAf.stopPreview();
            this.kAf.setPreviewTexture(surfaceTexture);
            bdC();
            this.kAf.startPreview();
        } catch (Exception e) {
            Exception exception = e;
            g.iuh.a(159, 0, 1, false);
            g.iuh.a(159, 2, 1, false);
            v.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.kAe = 1;
        }
        if (this.kAp) {
            bdE();
            this.kAp = false;
        }
        d.bbw().rN(this.kAe);
    }

    public final int a(f fVar, boolean z) {
        if (i.kCg.ccA <= 0) {
            this.kAe = 1;
            return -1;
        }
        if (z) {
            if (!i.kCg.kAK) {
                z = false;
            }
        } else if (!i.kCg.kAL) {
            z = true;
        }
        this.kAn = fVar;
        if (d(z, this.Zx, this.QW) <= 0) {
            int d = d(z, 0, 0);
            if (d <= 0) {
                this.kAe = 1;
                return d;
            }
        }
        bdC();
        this.kAe = 0;
        return 1;
    }

    private void bdC() {
        if (this.kAh == null || this.kAh.height <= 0 || this.kAh.width <= 0) {
            this.kAf.setPreviewCallback(this.kAy);
            return;
        }
        int i;
        int i2 = ((this.kAh.height * this.kAh.width) * 3) / 2;
        if (this.kAs == null) {
            this.kAs = new ArrayList(3);
            for (i = 0; i < 3; i++) {
                this.kAs.add(new byte[i2]);
            }
        }
        for (i = 0; i < this.kAs.size(); i++) {
            this.kAf.addCallbackBuffer((byte[]) this.kAs.get(i));
        }
        this.kAf.setPreviewCallbackWithBuffer(this.kAy);
    }

    private static Camera gW(boolean z) {
        Camera camera = null;
        if (i.kCg.ccA > 0 && i.kCm) {
            if (z) {
                try {
                    camera = Camera.open(i.kCh);
                    v.i("Camera", "Use front");
                } catch (Exception e) {
                    Exception exception = e;
                    g.iuh.a(159, 0, 1, false);
                    g.iuh.a(159, 1, 1, false);
                    v.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + exception.toString());
                }
            } else {
                camera = Camera.open(i.kCi);
                v.i("Camera", "Use back");
            }
        }
        return camera;
    }

    private Camera gX(boolean z) {
        Camera gW = gW(z);
        if (gW == null) {
            try {
                gW = Camera.open();
                try {
                    Parameters parameters = gW.getParameters();
                    parameters.set("camera-id", z ? 2 : 1);
                    gW.setParameters(parameters);
                } catch (Exception e) {
                    Exception exception = e;
                    g.iuh.a(159, 0, 1, false);
                    v.e("MicroMsg.Voip.CaptureRender", "set camera-id error:" + exception.toString());
                }
            } catch (Exception e2) {
                v.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + e2.toString());
                g.iuh.a(159, 0, 1, false);
                g.iuh.a(159, 1, 1, false);
                if (this.kAn != null) {
                    this.kAn.aCN();
                }
                return null;
            }
        }
        this.kzX = z;
        i(gW);
        h(gW);
        return gW;
    }

    private static boolean a(Camera camera, int i, int i2) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            if (i > 0 && i2 > 0) {
                parameters.setPreviewSize(i, i2);
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            g.iuh.a(159, 0, 1, false);
            v.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + e.toString());
            return false;
        }
    }

    private static boolean g(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                v.d("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    v.d("MicroMsg.Voip.CaptureRender", "supported focus modes : " + str);
                }
                if (supportedFocusModes.contains("auto")) {
                    v.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                    parameters.setFocusMode("auto");
                } else if (supportedFocusModes.contains("continuous-video")) {
                    v.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                    parameters.setFocusMode("continuous-video");
                }
                camera.setParameters(parameters);
            }
            return true;
        } catch (Exception e) {
            g.iuh.a(159, 0, 1, false);
            v.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + e.toString());
            return false;
        }
    }

    private static Point a(CharSequence charSequence, Point point) {
        int indexOf;
        int parseInt;
        String[] split = iDD.split(charSequence);
        int length = split.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        while (i < length) {
            int i5;
            String trim = split[i].trim();
            indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                v.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + trim);
                i5 = i2;
                i2 = i3;
            } else {
                try {
                    parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    indexOf = Integer.parseInt(trim.substring(indexOf + 1));
                    i5 = Math.abs(parseInt - point.x) + Math.abs(indexOf - point.y);
                    if (i5 == 0) {
                        break;
                    } else if (i5 >= i4 || parseInt == indexOf) {
                        i5 = i2;
                        i2 = i3;
                    } else {
                        i4 = i5;
                        i2 = parseInt;
                        i5 = indexOf;
                    }
                } catch (NumberFormatException e) {
                    v.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + trim);
                    i5 = i2;
                    i2 = i3;
                }
            }
            i++;
            i3 = i2;
            i2 = i5;
        }
        indexOf = i2;
        parseInt = i3;
        if (parseInt <= 0 || indexOf <= 0) {
            return null;
        }
        return new Point(parseInt, indexOf);
    }

    private int d(boolean z, int i, int i2) {
        Exception e;
        Object obj;
        Size size;
        Size size2;
        Camera camera;
        v.i("MicroMsg.Voip.CaptureRender", "try open camera, face: " + z);
        Object obj2 = 1;
        if (this.kAf != null) {
            if (this.kzX != z) {
                this.kAf.release();
                this.kAf = null;
            } else {
                obj2 = null;
            }
        }
        if (obj2 != null) {
            this.kAf = gX(z);
            if (this.kAf == null) {
                this.kAj = false;
                return -1;
            }
        }
        try {
            Parameters parameters;
            boolean a;
            CameraInfo cameraInfo;
            int i3;
            if (this.kAf != null) {
                this.kAf.getParameters();
            }
            this.kAj = true;
            Camera camera2 = this.kAf;
            int i4 = i.kCg.kAJ;
            if (camera2 != null) {
                try {
                    parameters = camera2.getParameters();
                    parameters.setPreviewFrameRate(i4);
                    camera2.setParameters(parameters);
                } catch (Exception e2) {
                    v.e("MicroMsg.Voip.CaptureRender", "SafeSetFps error:" + e2.toString());
                }
            }
            v.i("MicroMsg.Voip.CaptureRender", "Camera Open Success, try set size: w,h:" + i + "," + i2);
            Point point = z ? i.kCg.kAO : i.kCg.kAP;
            if (point != null) {
                obj = 1;
            } else {
                obj = null;
            }
            Size size3 = null;
            if (point != null) {
                Camera camera3 = this.kAf;
                camera3.getClass();
                Size size4 = new Size(camera3, point.x, point.y);
                v.i("MicroMsg.Voip.CaptureRender", "getCameraSize from table:" + size4.width + "," + size4.height);
                size = size4;
            } else {
                size = null;
            }
            try {
                CharSequence charSequence;
                Camera camera4 = this.kAf;
                parameters = camera4.getParameters();
                Point point2 = new Point(i, i2);
                String str = parameters.get("preview-size-values");
                if (str == null) {
                    charSequence = parameters.get("preview-size-value");
                } else {
                    Object obj3 = str;
                }
                Point point3 = null;
                if (charSequence != null) {
                    v.i("MicroMsg.Voip.CaptureRender", "preview-size-values parameter: " + charSequence);
                    point3 = a(charSequence, point2);
                }
                if (point3 == null) {
                    point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
                }
                camera4.getClass();
                size2 = new Size(camera4, point3.x, point3.y);
                try {
                    v.i("MicroMsg.Voip.CaptureRender", "getCameraResolution:" + size2.width + "," + size2.height);
                } catch (Exception e3) {
                    e2 = e3;
                    size3 = size2;
                    v.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", new Object[]{e2.getMessage()});
                    size2 = size3;
                    if (obj != null) {
                        a = a(this.kAf, size.width, size.height);
                        v.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                        v.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                        if (!a(this.kAf, size2.width, size2.height)) {
                            v.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                            return -1;
                        }
                    }
                    v.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
                    if (size2 != null) {
                        v.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                        if (!a(this.kAf, size2.width, size2.height)) {
                            v.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                            return -1;
                        }
                    }
                    g(this.kAf);
                    this.kAg = this.kAf.getParameters();
                    this.kAh = this.kAg.getPreviewSize();
                    i4 = this.kAg.getPreviewFrameRate();
                    this.kAi = i.kCl;
                    if (this.kAi <= 0) {
                        this.kAi = 7;
                    }
                    try {
                        camera = this.kAf;
                        cameraInfo = new CameraInfo();
                        Camera.getCameraInfo(this.kzX ? i.kCh : i.kCi, cameraInfo);
                        i3 = 0;
                        switch (((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                            case 0:
                                i3 = 0;
                                break;
                            case 1:
                                i3 = 90;
                                break;
                            case 2:
                                i3 = 180;
                                break;
                            case 3:
                                i3 = 270;
                                break;
                        }
                        i3 = this.kzX ? (360 - ((i3 + cameraInfo.orientation) % 360)) % 360 : ((cameraInfo.orientation - i3) + 360) % 360;
                        camera.setDisplayOrientation(i3);
                        this.kAu = i3;
                    } catch (Exception e22) {
                        v.e("MicroMsg.Voip.CaptureRender", "setDisplayOrientation failed: %s", new Object[]{e22.getMessage()});
                    }
                    v.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.kAh.width), Integer.valueOf(this.kAh.height), Integer.valueOf(this.kAi), Integer.valueOf(i.kCj), Integer.valueOf(this.kAu)});
                    return 1;
                }
            } catch (Exception e4) {
                e22 = e4;
                v.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", new Object[]{e22.getMessage()});
                size2 = size3;
                if (obj != null) {
                    v.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
                    if (size2 != null) {
                        v.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                        if (a(this.kAf, size2.width, size2.height)) {
                            v.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                            return -1;
                        }
                    }
                }
                a = a(this.kAf, size.width, size.height);
                v.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                v.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                if (a(this.kAf, size2.width, size2.height)) {
                    v.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                    return -1;
                }
                g(this.kAf);
                this.kAg = this.kAf.getParameters();
                this.kAh = this.kAg.getPreviewSize();
                i4 = this.kAg.getPreviewFrameRate();
                this.kAi = i.kCl;
                if (this.kAi <= 0) {
                    this.kAi = 7;
                }
                camera = this.kAf;
                cameraInfo = new CameraInfo();
                if (this.kzX) {
                }
                Camera.getCameraInfo(this.kzX ? i.kCh : i.kCi, cameraInfo);
                i3 = 0;
                switch (((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        i3 = 0;
                        break;
                    case 1:
                        i3 = 90;
                        break;
                    case 2:
                        i3 = 180;
                        break;
                    case 3:
                        i3 = 270;
                        break;
                }
                if (this.kzX) {
                }
                camera.setDisplayOrientation(i3);
                this.kAu = i3;
                v.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.kAh.width), Integer.valueOf(this.kAh.height), Integer.valueOf(this.kAi), Integer.valueOf(i.kCj), Integer.valueOf(this.kAu)});
                return 1;
            }
            if (obj != null) {
                a = a(this.kAf, size.width, size.height);
                v.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                if (!(a || size2 == null)) {
                    v.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                    if (a(this.kAf, size2.width, size2.height)) {
                        v.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
            }
            v.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
            if (size2 != null) {
                v.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                if (a(this.kAf, size2.width, size2.height)) {
                    v.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                    return -1;
                }
            }
            g(this.kAf);
            try {
                this.kAg = this.kAf.getParameters();
                this.kAh = this.kAg.getPreviewSize();
                i4 = this.kAg.getPreviewFrameRate();
                this.kAi = i.kCl;
                if (this.kAi <= 0) {
                    this.kAi = 7;
                }
                camera = this.kAf;
                cameraInfo = new CameraInfo();
                if (this.kzX) {
                }
                Camera.getCameraInfo(this.kzX ? i.kCh : i.kCi, cameraInfo);
                i3 = 0;
                switch (((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        i3 = 0;
                        break;
                    case 1:
                        i3 = 90;
                        break;
                    case 2:
                        i3 = 180;
                        break;
                    case 3:
                        i3 = 270;
                        break;
                }
                if (this.kzX) {
                }
                camera.setDisplayOrientation(i3);
                this.kAu = i3;
                v.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.kAh.width), Integer.valueOf(this.kAh.height), Integer.valueOf(this.kAi), Integer.valueOf(i.kCj), Integer.valueOf(this.kAu)});
                return 1;
            } catch (Exception e222) {
                g.iuh.a(159, 0, 1, false);
                v.e("MicroMsg.Voip.CaptureRender", "try getParameters and getPreviewSize fail, error:%s", new Object[]{e222.getMessage()});
                return -1;
            }
        } catch (Exception e2222) {
            g.iuh.a(159, 0, 1, false);
            v.e("MicroMsg.Voip.CaptureRender", "Camera open failed, error:%s", new Object[]{e2222.getMessage()});
            if (this.kAn != null) {
                this.kAn.aCN();
            }
            return -1;
        }
    }

    public final void bdD() {
        if (i.kCg.ccA < 2) {
            v.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + i.kCg.ccA);
            return;
        }
        v.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + i.kCg.ccA);
        bdF();
        bdG();
        a(this.kAn, !this.kzX);
        bdE();
        d.bbw().rN(this.kAe);
        this.kAt = true;
    }

    public final int bdE() {
        if (!this.kAj) {
            v.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
            this.kAe = 1;
            return -1;
        } else if (this.kAo) {
            v.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
            return -1;
        } else if (this.kAl == null || this.kAl.baQ()) {
            v.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", new Object[]{Boolean.valueOf(this.kAk)});
            if (this.kAl != null && this.kAk) {
                try {
                    this.kAf.setPreviewDisplay(this.kAl.getSurfaceHolder());
                } catch (Exception e) {
                    g.iuh.a(159, 0, 1, false);
                    g.iuh.a(159, 2, 1, false);
                    this.kAe = 1;
                    v.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e.toString());
                }
            } else if (!(this.kAm == null || this.kAk)) {
                try {
                    this.kAf.setPreviewTexture(this.kAm.getSurfaceTexture());
                } catch (Exception e2) {
                    g.iuh.a(159, 0, 1, false);
                    g.iuh.a(159, 2, 1, false);
                    this.kAe = 1;
                    v.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e2.toString());
                }
            }
            try {
                this.kAf.startPreview();
            } catch (Exception e22) {
                g.iuh.a(159, 0, 1, false);
                g.iuh.a(159, 2, 1, false);
                this.kAe = 1;
                if (this.kAn != null) {
                    this.kAn.aCN();
                }
                v.e("MicroMsg.Voip.CaptureRender", "startPreview:error" + e22.toString());
            }
            this.kAo = true;
            return 1;
        } else {
            v.d("MicroMsg.Voip.CaptureRender", "StartCapture:surface not ready, try later.... ");
            this.kAp = true;
            return 0;
        }
    }

    public final void bdF() {
        v.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.kAo);
        if (this.kAo) {
            this.kAp = false;
            this.kAf.setPreviewCallback(null);
            try {
                this.kAf.stopPreview();
            } catch (Exception e) {
                v.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + e.toString());
            }
            this.kAo = false;
        }
    }

    public final void bdG() {
        if (1 == this.kAe) {
            jv jvVar = new jv();
            jvVar.bky.type = 2;
            com.tencent.mm.sdk.c.a.nhr.z(jvVar);
        }
        v.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.kAj);
        if (this.kAj) {
            this.kAe = 0;
            this.kAp = false;
            this.kAf.setPreviewCallback(null);
            this.kAf.release();
            this.kAf = null;
            this.kAj = false;
        }
        this.kAq = null;
        if (this.kAs != null) {
            this.kAs.clear();
        }
        this.kAs = null;
    }

    @TargetApi(14)
    public final void n(int[] iArr) {
        boolean z = true;
        if (p.ceA.cde > 2000) {
            this.kAd = (long) p.ceA.cde;
        }
        boolean z2;
        boolean z3;
        if (iArr == null) {
            v.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
            z2 = System.currentTimeMillis() - this.kAc > this.kAd;
            if (!this.kzZ || z2 || this.kAa != this.kzX) {
                String str = "MicroMsg.Voip.CaptureRender";
                StringBuilder stringBuilder = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
                if (this.kzZ) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                StringBuilder append = stringBuilder.append(z3).append(",isAutoFocusTimeout: ").append(z2).append(",mAutoFocusTimeOut:").append(this.kAd).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
                if (this.kAa == this.kzX) {
                    z = false;
                }
                v.i(str, append.append(z).append(",isClickScreen :false").toString());
                try {
                    if (this.kAf != null && this.kAf.getParameters() != null && this.kAf.getParameters().getFocusMode() != null && this.kAf.getParameters().getFocusMode().equals("auto")) {
                        this.kAf.autoFocus(null);
                        this.kAr = null;
                        this.kAc = System.currentTimeMillis();
                        this.kzZ = true;
                        this.kAa = this.kzX;
                        return;
                    }
                    return;
                } catch (Exception e) {
                    v.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + e.toString());
                    return;
                }
            }
            return;
        }
        Parameters parameters;
        if (this.kAr == null) {
            this.kAr = iArr;
            z2 = true;
        } else {
            z2 = false;
        }
        int[] iArr2 = this.kAr;
        int abs = Math.abs(iArr2[3] - iArr[3]) + ((Math.abs(iArr2[0] - iArr[0]) + Math.abs(iArr2[1] - iArr[1])) + Math.abs(iArr2[2] - iArr[2]));
        v.d("MicroMsg.Voip.CaptureRender", "face location diff:%d", new Object[]{Integer.valueOf(abs)});
        if (abs > kzW || abs > kzV) {
            this.kAr = iArr;
            if (abs > kzW) {
                z2 = true;
            }
            if (abs > kzV) {
                z3 = true;
                if (!z2 || z3) {
                    List arrayList;
                    Rect rect = new Rect(this.kAr[0], this.kAr[1], this.kAr[2], this.kAr[3]);
                    parameters = this.kAf.getParameters();
                    if (z3) {
                        if (com.tencent.mm.compatible.util.d.dW(14) || parameters.getMaxNumMeteringAreas() <= 0) {
                            v.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
                            z3 = false;
                        } else {
                            arrayList = new ArrayList();
                            arrayList.add(new Area(rect, BaseReportManager.MAX_READ_COUNT));
                            parameters.setMeteringAreas(arrayList);
                        }
                    }
                    if (z2) {
                        if (com.tencent.mm.compatible.util.d.dW(14) || parameters.getMaxNumFocusAreas() <= 0) {
                            v.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
                            z2 = false;
                        } else {
                            arrayList = new ArrayList();
                            arrayList.add(new Area(rect, BaseReportManager.MAX_READ_COUNT));
                            parameters.setFocusAreas(arrayList);
                        }
                    }
                    if (z2 || r3) {
                        this.kAf.setParameters(parameters);
                    }
                    if (z2) {
                        v.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", new Object[]{Boolean.valueOf(this.kAt)});
                        if (this.kAt) {
                            this.kzZ = false;
                            this.kAt = false;
                            this.kAf.autoFocus(new AutoFocusCallback(this) {
                                final /* synthetic */ a kAz;

                                {
                                    this.kAz = r1;
                                }

                                public final void onAutoFocus(boolean z, Camera camera) {
                                    v.d("MicroMsg.Voip.CaptureRender", "onAutoFocus, success:%b", new Object[]{Boolean.valueOf(z)});
                                    this.kAz.kAt = true;
                                }
                            });
                        }
                    }
                }
                return;
            }
        }
        z3 = false;
        if (z2) {
        }
        try {
            Rect rect2 = new Rect(this.kAr[0], this.kAr[1], this.kAr[2], this.kAr[3]);
            parameters = this.kAf.getParameters();
            if (z3) {
                if (com.tencent.mm.compatible.util.d.dW(14)) {
                }
                v.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
                z3 = false;
            }
            if (z2) {
                if (com.tencent.mm.compatible.util.d.dW(14)) {
                }
                v.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
                z2 = false;
            }
            this.kAf.setParameters(parameters);
            if (z2) {
                v.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", new Object[]{Boolean.valueOf(this.kAt)});
                if (this.kAt) {
                    this.kzZ = false;
                    this.kAt = false;
                    this.kAf.autoFocus(/* anonymous class already generated */);
                }
            }
        } catch (Exception e2) {
            v.e("MicroMsg.Voip.CaptureRender", "focusOnFace exception:%s", new Object[]{e2.getMessage()});
        }
    }

    private int h(Camera camera) {
        int i;
        int i2;
        Throwable th;
        if (camera == null) {
            return 0;
        }
        try {
            List<Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                i = 0;
            } else {
                i = 0;
                for (Size size : supportedPreviewSizes) {
                    try {
                        v.d("MicroMsg.Voip.CaptureRender", "support Size:" + size.width + "," + size.height);
                        if (i == 0) {
                            this.kAv = size.width;
                            this.kAw = size.height;
                        }
                        i++;
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        i2 = i;
                        th = th2;
                    }
                }
            }
            List<Integer> supportedPreviewFormats = camera.getParameters().getSupportedPreviewFormats();
            if (!(supportedPreviewFormats == null || supportedPreviewFormats.size() == 0)) {
                for (Integer intValue : supportedPreviewFormats) {
                    v.i("MicroMsg.Voip.CaptureRender", "support Format:" + intValue.intValue());
                }
            }
            return i;
        } catch (Throwable e2) {
            th = e2;
            i2 = 0;
            v.a("MicroMsg.Voip.CaptureRender", th, "", new Object[0]);
            return i2;
        }
    }

    private static void i(Camera camera) {
        List supportedPreviewFrameRates;
        String str;
        List list = null;
        try {
            supportedPreviewFrameRates = camera.getParameters().getSupportedPreviewFrameRates();
        } catch (Exception e) {
            v.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:" + e.toString());
            supportedPreviewFrameRates = list;
        }
        String str2 = "supportFps:";
        if (supportedPreviewFrameRates != null) {
            str = str2;
            for (int i = 0; i < supportedPreviewFrameRates.size(); i++) {
                str = str + ((Integer) supportedPreviewFrameRates.get(i)).intValue() + ",";
            }
        } else {
            str = str2;
        }
        v.i("MicroMsg.Voip.CaptureRender", str);
    }

    public final boolean bdH() {
        return this.kzX;
    }

    public final boolean bdI() {
        return this.kzY;
    }

    public final int bdJ() {
        return this.kAe;
    }

    public final void bdK() {
        try {
            if (this.kAg != null) {
                Size previewSize = this.kAg.getPreviewSize();
                c bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
                int i = this.kAj ? 1 : 0;
                this.kAg.getPreviewFrameRate();
                int i2 = this.kAv;
                int i3 = this.kAw;
                int i4 = previewSize.width;
                int i5 = previewSize.height;
                v.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
                bed.kDo = i;
                bed.kDk = i2;
                bed.kDl = i3;
                bed.kDm = i4;
                bed.kDn = i5;
            }
        } catch (Exception e) {
            v.e("MicroMsg.Voip.CaptureRender", "getCameraDataForVoipCS failed" + e.getMessage());
        }
    }
}

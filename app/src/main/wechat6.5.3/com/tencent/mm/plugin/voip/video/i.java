package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.v;

public final class i {
    public static g kCg;
    public static int kCh = -1;
    public static int kCi = -1;
    public static int kCj = 0;
    public static int kCk = 0;
    public static int kCl = 0;
    public static boolean kCm = true;

    public static boolean bdS() {
        if (p.ceA.ccD && p.ceA.ccC == 8) {
            return false;
        }
        return true;
    }

    private static boolean bdT() {
        try {
            if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) != null) {
                return true;
            }
            v.d("GetfcMethod", "GetfcMethod is null");
            return false;
        } catch (Exception e) {
            v.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + e.getMessage());
            return false;
        }
    }

    public static void cK(Context context) {
        if (kCg == null) {
            kCg = new g("*");
            boolean bdT = bdT();
            kCm = bdT;
            if (!bdT || p.ceA.ccB) {
                if (kCm && p.ceA.ccB) {
                    bdU();
                }
                if (p.ceA.ccB) {
                    kCg.ccA = p.ceA.ccA;
                }
                if (p.ceA.ccJ) {
                    if (p.ceA.ccI.cdf != 0) {
                        kCg.kAL = true;
                    } else {
                        kCg.kAL = false;
                    }
                }
                if (p.ceA.ccH) {
                    if (p.ceA.ccG.cdf != 0) {
                        kCg.kAK = true;
                    } else {
                        kCg.kAK = false;
                    }
                }
                if (p.ceA.ccH && p.ceA.ccG.cdh >= 0) {
                    kCg.kAM = p.ceA.ccG.cdh;
                    kCj = kCg.kAM;
                }
                if (p.ceA.ccJ && p.ceA.ccI.cdh >= 0) {
                    kCg.kAN = p.ceA.ccI.cdh;
                    kCk = kCg.kAN;
                }
                if (p.ceA.ccH) {
                    if (kCg.kAO == null) {
                        kCg.kAO = new Point(0, 0);
                    }
                    kCg.kAO = new Point(p.ceA.ccG.width, p.ceA.ccG.height);
                }
                if (p.ceA.ccJ) {
                    if (kCg.kAP == null) {
                        kCg.kAP = new Point(0, 0);
                    }
                    kCg.kAP = new Point(p.ceA.ccI.width, p.ceA.ccI.height);
                }
                if (p.ceA.ccJ && p.ceA.ccI.cdg != 0) {
                    kCg.kAJ = p.ceA.ccI.cdg;
                }
                if (p.ceA.ccH && p.ceA.ccG.cdg != 0) {
                    kCg.kAJ = p.ceA.ccG.cdg;
                }
                PackageManager packageManager = context.getPackageManager();
                if (!(p.ceA.ccB || packageManager.hasSystemFeature("android.hardware.camera"))) {
                    kCg.ccA = 0;
                    kCg.kAK = false;
                    kCg.kAL = false;
                }
            } else {
                bdU();
            }
            if (p.ceA.ccF) {
                kCl = p.ceA.ccE;
            }
            v.i("MicroMsg.CameraUtil", "gCameraNum:" + kCg.ccA + "\ngIsHasFrontCamera:" + kCg.kAK + "\ngIsHasBackCamera:" + kCg.kAL + "\ngFrontCameraId:" + kCh + "\ngBackCameraId:" + kCi + "\ngBackOrientation:" + kCg.kAN + "\ngFrontOrientation:" + kCg.kAM + "\ngBestFps:" + kCg.kAJ + "\ngFacePreviewSize:" + kCg.kAO + "\ngNonFacePreviewSize:" + kCg.kAP + "\ngFaceCameraIsRotate180:" + kCj + "\ngMainCameraIsRotate180:" + kCk + "\ngCameraFormat:" + kCl + "\ngFaceNotRotate:SDK:" + VERSION.SDK_INT + "\n");
        }
    }

    private static void bdU() {
        kCg.ccA = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < kCg.ccA) {
            try {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    kCh = i;
                    kCg.kAM = cameraInfo.orientation;
                    kCg.kAK = true;
                } else if (cameraInfo.facing == 0) {
                    kCi = i;
                    kCg.kAN = cameraInfo.orientation;
                    kCg.kAL = true;
                }
                i++;
            } catch (Exception e) {
                v.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[]{e.getMessage()});
            }
        }
        String property = System.getProperty("ro.media.enc.camera.platform", null);
        boolean equalsIgnoreCase = property == null ? false : property.equalsIgnoreCase("Mediatek");
        if (kCg.kAM == 270 || (equalsIgnoreCase && kCg.kAM == 0)) {
            kCj = 1;
        } else {
            kCj = 0;
        }
        if (kCg.kAN == 270 || (equalsIgnoreCase && kCg.kAN == 0)) {
            kCk = 1;
        } else {
            kCk = 0;
        }
    }
}

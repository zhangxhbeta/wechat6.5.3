package com.tencent.mm.compatible.d;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class c {

    public interface a {

        public static class a {
            public int cdi;
            public Camera cdl;
        }
    }

    public static int getNumberOfCameras() {
        if (p.ceA.ccK && p.ceA.ccQ) {
            h hVar = new h();
            return h.getNumberOfCameras();
        }
        f fVar = new f();
        return Camera.getNumberOfCameras();
    }

    public static int rs() {
        if (p.ceJ.cdJ == 1) {
            return 0;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < numberOfCameras) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                v.d("MicroMsg.CameraUtil", "tigercam get bid %d", Integer.valueOf(i));
                break;
            }
            i++;
        }
        i = 0;
        v.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", Integer.valueOf(i));
        return i;
    }

    public static boolean rt() {
        if (p.ceA.ccS == 1) {
            return true;
        }
        if (VERSION.SDK_INT == 10 && Build.MODEL.equals("GT-S5360")) {
            return true;
        }
        return false;
    }

    public static a b(Activity activity, int i) {
        if (p.ceA.ccS == 1) {
            v.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = " + i);
            d dVar = new d();
            return d.ru();
        } else if (p.ceA.ccK) {
            v.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = " + i);
            h hVar = new h();
            return h.dP(i);
        } else if (Build.MODEL.equals("M9")) {
            i iVar = new i();
            return i.ru();
        } else if (getNumberOfCameras() > 1) {
            v.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = " + i);
            f fVar = new f();
            return f.b(activity, i);
        } else {
            e eVar = new e();
            return e.dP(i);
        }
    }

    public static List<Size> a(Parameters parameters) {
        f fVar = new f();
        return parameters.getSupportedPreviewSizes();
    }

    public static List<Size> b(Parameters parameters) {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        g gVar = new g();
        return parameters.getSupportedVideoSizes();
    }
}

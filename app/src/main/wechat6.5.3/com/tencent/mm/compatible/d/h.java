package com.tencent.mm.compatible.d;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.mm.compatible.d.c.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

final class h implements a {
    h() {
    }

    public static int getNumberOfCameras() {
        int numberOfCameras;
        if (!p.ceA.ccQ || p.ceA.ccP == -1) {
            numberOfCameras = c.getNumberOfCameras();
            v.d("CameraUtilImplConfig", "getNumberOfCameras " + numberOfCameras);
            return numberOfCameras <= 1 ? 0 : numberOfCameras;
        } else {
            numberOfCameras = p.ceA.ccP;
            v.d("CameraUtilImplConfig", "mVRCameraNum " + numberOfCameras);
            return numberOfCameras;
        }
    }

    public static a.a dP(int i) {
        a.a aVar = new a.a();
        aVar.cdl = null;
        try {
            aVar.cdl = Camera.open(i);
            if (aVar.cdl == null) {
                return null;
            }
            aVar.cdi = 0;
            v.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.hasVRInfo " + p.ceA.ccK);
            v.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceRotate " + p.ceA.ccL);
            v.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + p.ceA.ccM);
            v.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackRotate " + p.ceA.ccN);
            v.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + p.ceA.ccO);
            if (getNumberOfCameras() > 1) {
                try {
                    CameraInfo cameraInfo = new CameraInfo();
                    Camera.getCameraInfo(i, cameraInfo);
                    v.d("CameraUtilImplConfig", "info.facing " + cameraInfo.facing);
                    if (cameraInfo.facing == 1) {
                        if (p.ceA.ccK && p.ceA.ccL != -1) {
                            aVar.cdi = p.ceA.ccL;
                        }
                        if (p.ceA.ccK && p.ceA.ccM != -1) {
                            aVar.cdl.setDisplayOrientation(p.ceA.ccM);
                        }
                    } else {
                        if (p.ceA.ccK && p.ceA.ccN != -1) {
                            aVar.cdi = p.ceA.ccN;
                        }
                        if (p.ceA.ccK && p.ceA.ccO != -1) {
                            aVar.cdl.setDisplayOrientation(p.ceA.ccO);
                        }
                    }
                } catch (Throwable e) {
                    v.a("CameraUtilImplConfig", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            } else {
                if (p.ceA.ccK && p.ceA.ccN != -1) {
                    aVar.cdi = p.ceA.ccN;
                }
                if (p.ceA.ccK && p.ceA.ccO != -1) {
                    aVar.cdl.setDisplayOrientation(p.ceA.ccO);
                }
            }
            return aVar;
        } catch (Exception e2) {
            return null;
        }
    }
}

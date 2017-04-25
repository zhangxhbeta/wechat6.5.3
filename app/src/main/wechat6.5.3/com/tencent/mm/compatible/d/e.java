package com.tencent.mm.compatible.d;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

final class e implements a {
    e() {
    }

    @TargetApi(8)
    public static a.a dP(int i) {
        a.a aVar = new a.a();
        try {
            aVar.cdl = Camera.open();
            aVar.cdi = 90;
            if (aVar.cdl == null) {
                return null;
            }
            int i2;
            int i3;
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            switch (((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                case 0:
                    i2 = 0;
                    break;
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = 180;
                    break;
                case 3:
                    i2 = 270;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (cameraInfo.facing == 1) {
                i3 = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
            } else {
                i3 = ((cameraInfo.orientation - i2) + 360) % 360;
            }
            v.d("MicroMsg.CameraUtil.CameraUtilImpl22", "CameraUtilImpl22, open camera, info.orientation: %d, degrees: %d, result:%d", Integer.valueOf(cameraInfo.orientation), Integer.valueOf(i2), Integer.valueOf(i3));
            aVar.cdl.setDisplayOrientation(i3);
            return aVar;
        } catch (Exception e) {
            return null;
        }
    }
}

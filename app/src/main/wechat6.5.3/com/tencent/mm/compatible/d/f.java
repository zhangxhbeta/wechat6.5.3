package com.tencent.mm.compatible.d;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.mm.compatible.d.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

final class f implements a {
    f() {
    }

    public static a.a b(Activity activity, int i) {
        a.a aVar = new a.a();
        aVar.cdl = null;
        try {
            long Nj = be.Nj();
            v.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", Integer.valueOf(i));
            aVar.cdl = Camera.open(i);
            v.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back, use %dms", Long.valueOf(be.az(Nj)));
            if (aVar.cdl == null) {
                v.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
                return null;
            }
            int i2;
            CameraInfo cameraInfo = new CameraInfo();
            Nj = be.Nj();
            v.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", Integer.valueOf(i));
            Camera.getCameraInfo(i, cameraInfo);
            v.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", Long.valueOf(be.az(Nj)));
            switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
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
                i2 = (360 - (cameraInfo.orientation % 360)) % 360;
            } else {
                i2 = ((cameraInfo.orientation - i2) + 360) % 360;
            }
            Nj = be.Nj();
            v.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", Integer.valueOf(i2));
            aVar.cdl.setDisplayOrientation(i2);
            v.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", Long.valueOf(be.az(Nj)));
            aVar.cdi = cameraInfo.orientation;
            return aVar;
        } catch (Throwable e) {
            v.e("MicroMsg.CameraUtil", "open camera error %s", e.getMessage());
            v.a("MicroMsg.CameraUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }
}

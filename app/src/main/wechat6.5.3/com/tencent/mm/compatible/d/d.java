package com.tencent.mm.compatible.d;

import android.hardware.Camera;
import com.tencent.mm.compatible.d.c.a;

final class d implements a {
    d() {
    }

    public static a.a ru() {
        a.a aVar = new a.a();
        try {
            aVar.cdl = Camera.open();
            aVar.cdi = 0;
            if (aVar.cdl == null) {
                return null;
            }
            return aVar;
        } catch (Exception e) {
            return null;
        }
    }
}

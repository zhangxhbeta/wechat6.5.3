package com.tencent.d;

import android.content.Context;
import com.tencent.d.b.b;
import com.tencent.d.b.d;
import com.tencent.pb.common.c.c;

public final class i {
    private static i pHw;
    private Context aHq;
    private boolean rm;

    private static i bPg() {
        if (pHw == null) {
            synchronized (i.class) {
                if (pHw == null) {
                    pHw = new i();
                }
            }
        }
        return pHw;
    }

    public static void gz(Context context) {
        i bPg = bPg();
        if (!bPg.rm) {
            bPg.aHq = context;
            try {
                b a = f.a(new d("EventCenter", com.tencent.d.a.b.class.getName()));
                if (a != null) {
                    a.start();
                }
            } catch (Throwable th) {
                c.i("service", th);
            }
        }
    }
}

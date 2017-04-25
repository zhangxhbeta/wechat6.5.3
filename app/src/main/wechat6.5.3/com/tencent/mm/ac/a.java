package com.tencent.mm.ac;

import android.os.HandlerThread;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class a implements ag {
    private static HandlerThread cKt = null;
    private static ac cKu = null;

    public static boolean a(Runnable runnable, long j) {
        boolean z = false;
        if (runnable == null) {
            return false;
        }
        if (cKu == null || cKt == null) {
            String str = "MicroMsg.GIF.SubCoreGIF";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(cKu != null);
            if (cKt != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = be.bur();
            v.w(str, str2, objArr);
            if (cKu != null) {
                cKu.removeCallbacksAndMessages(null);
            }
            if (cKt != null) {
                cKt.quit();
            }
            HandlerThread Lg = e.Lg("GIF-Decoder");
            cKt = Lg;
            Lg.start();
            cKu = new ac(cKt.getLooper());
        }
        if (j > 0) {
            cKu.postDelayed(runnable, j);
        } else {
            cKu.post(runnable);
        }
        return true;
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        if (cKu != null) {
            cKu.removeCallbacksAndMessages(null);
        }
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        if (cKu != null) {
            cKu.removeCallbacksAndMessages(null);
        }
    }
}

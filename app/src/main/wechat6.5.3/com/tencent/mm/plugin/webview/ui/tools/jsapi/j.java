package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.v;

public final class j {
    private static final SparseArray<i> lqV = new SparseArray();
    private static volatile i lqW = null;

    private j() {
    }

    @Deprecated
    public static i blE() {
        if (lqW == null) {
            lqW = new i(0);
        }
        return lqW;
    }

    public static i tl(int i) {
        i iVar;
        synchronized (j.class) {
            if (lqV.get(i) == null) {
                lqV.put(i, new i(i));
            }
            iVar = (i) lqV.get(i);
            lqW = iVar;
        }
        return iVar;
    }

    public static void detach() {
        v.i("MicroMsg.MsgHandlerHolder", "detach");
        synchronized (j.class) {
            for (int i = 0; i < lqV.size(); i++) {
                i iVar = (i) lqV.valueAt(i);
                int keyAt = lqV.keyAt(i);
                if (iVar != null) {
                    b.lgu.sL(keyAt);
                }
            }
            lqV.clear();
        }
        if (lqW != null) {
            b.lgu.sL(0);
            lqW = null;
        }
    }
}

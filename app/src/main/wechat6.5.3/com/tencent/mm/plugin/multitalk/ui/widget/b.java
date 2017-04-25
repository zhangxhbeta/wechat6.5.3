package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.aa;

public final class b {
    public static final int hAV = a.fromDPToPix(aa.getContext(), 3);
    public static final int hAW = a.fromDPToPix(aa.getContext(), 4);
    public static final int hAX = a.fromDPToPix(aa.getContext(), 8);
    public static final int hAY = a.fromDPToPix(aa.getContext(), 10);
    public static final int hAZ = a.fromDPToPix(aa.getContext(), 14);
    public static final int hBa = a.fromDPToPix(aa.getContext(), 30);
    public static final int hBb = a.fromDPToPix(aa.getContext(), 26);
    public static final int hBc = a.fromDPToPix(aa.getContext(), 32);
    public static final int hBd = a.fromDPToPix(aa.getContext(), 96);
    public static final int hBe = a.fromDPToPix(aa.getContext(), 76);
    public static final int hBf = a.fromDPToPix(aa.getContext(), 230);
    private static int hBg = 0;

    public static int cj(Context context) {
        if (hBg == 0) {
            hBg = a.dw(context) - hBf;
        }
        return hBg;
    }
}

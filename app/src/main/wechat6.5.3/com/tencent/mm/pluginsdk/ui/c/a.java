package com.tencent.mm.pluginsdk.ui.c;

import com.qq.taf.jce.JceStruct;
import com.tencent.mm.a.e;
import com.tencent.mm.as.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class a extends com.tencent.mm.ui.tools.a.a {
    public int hO = JceStruct.JCE_MAX_STRING_LENGTH;
    private String iTJ;
    private a lPe;

    public interface a {
    }

    private a(String str) {
        this.iTJ = str;
    }

    public static a HL(String str) {
        return new a(str);
    }

    public final int bqB() {
        return QH();
    }

    protected final int QH() {
        int shouldRemuxing;
        int i = 10485760;
        if (be.kS(this.iTJ)) {
            v.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
        }
        boolean is2G = ak.is2G(aa.getContext());
        if (d.kR(this.iTJ)) {
            double d;
            String str = this.iTJ;
            if (!is2G) {
                i = this.hO;
            }
            if (is2G) {
                d = 60000.0d;
            } else {
                d = (double) this.hO;
            }
            shouldRemuxing = SightVideoJNI.shouldRemuxing(str, 660, 500, i, d, 1000000);
        } else {
            if (e.aQ(this.iTJ) > (is2G ? 10485760 : 26214400)) {
                shouldRemuxing = -1;
            } else {
                shouldRemuxing = 1;
            }
        }
        v.i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", new Object[]{Integer.valueOf(shouldRemuxing), Boolean.valueOf(r10)});
        switch (shouldRemuxing) {
            case -6:
            case -5:
            case -4:
            case -3:
            case ai.CTRL_INDEX /*-2*/:
                return 1;
            case -1:
                return 2;
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return 0;
            default:
                v.e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", new Object[]{Integer.valueOf(shouldRemuxing)});
                return 1;
        }
    }

    protected final void bqC() {
        if (this.lPe == null) {
            v.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
        } else {
            QH();
        }
    }
}

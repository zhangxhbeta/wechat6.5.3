package com.tencent.mm.plugin.webview.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class z extends x {
    public z() {
        this.bcp = 1;
    }

    public final void bil() {
        if (new File(this.lel).exists()) {
            this.lek = ah.DX(System.currentTimeMillis());
            Bitmap a = d.a(this.lel, 640, 640, false, null, 0);
            if (a != null) {
                v.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
                a = d.b(a, (float) ExifHelper.JQ(this.lel));
                if (a != null) {
                    try {
                        d.a(a, 100, CompressFormat.JPEG, this.lek, true);
                    } catch (Exception e) {
                        v.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", new Object[]{e.getMessage()});
                    }
                }
            }
            v.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[]{this.lek});
            return;
        }
        v.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
    }

    public final x bih() {
        this.bde = ah.DZ(this.lel);
        bil();
        return this;
    }

    public final String bii() {
        return "jpeg";
    }

    public final String bij() {
        return SlookAirButtonRecentMediaAdapter.IMAGE_TYPE;
    }
}

package com.tencent.mm.plugin.scanner.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public final class o implements i {
    private String mPicUrl = null;

    public o(String str) {
        this.mPicUrl = str;
    }

    public final String MU() {
        return b.aKP().cr(this.mPicUrl, "@S");
    }

    public final String MV() {
        return this.mPicUrl;
    }

    public final String MW() {
        return this.mPicUrl;
    }

    public final String MX() {
        return this.mPicUrl;
    }

    public final boolean MY() {
        return false;
    }

    public final boolean MZ() {
        return false;
    }

    public final Bitmap a(Bitmap bitmap, a aVar) {
        if (a.doT == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, MU(), false);
            } catch (Throwable e) {
                v.a("MicroMsg.ScannerGetPicStrategy", e, "", new Object[0]);
            }
        }
        return bitmap;
    }

    public final void Nb() {
    }

    public final void H(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }

    public final Bitmap Na() {
        if (aa.getContext() == null) {
            return null;
        }
        return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
    }
}

package com.tencent.mm.plugin.shake.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.plugin.shake.b.k;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public final class b implements i {
    private a iTo = null;
    private String thumburl = "";

    public b(a aVar) {
        this.iTo = aVar;
    }

    public b(String str) {
        this.thumburl = str;
    }

    public final String MU() {
        if (this.iTo != null && this.iTo.field_thumburl != null) {
            return k.cr(this.iTo.field_thumburl, "@S");
        }
        if (this.thumburl != null) {
            return k.cr(this.thumburl, "@S");
        }
        return "";
    }

    public final String MV() {
        if (this.iTo == null || this.iTo.field_thumburl == null) {
            return this.thumburl;
        }
        return this.iTo.field_thumburl;
    }

    public final String MW() {
        return MV() + "_tv";
    }

    public final String MX() {
        return MV() + "_tv";
    }

    public final boolean MY() {
        return false;
    }

    public final boolean MZ() {
        return false;
    }

    public final Bitmap a(Bitmap bitmap, i.a aVar) {
        if (i.a.doT == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, MU(), false);
            } catch (Throwable e) {
                v.a("MicroMsg.TVImgGetStrategy", e, "", new Object[0]);
            }
        }
        return bitmap;
    }

    public final void Nb() {
    }

    public final void H(String str, boolean z) {
    }

    public final void a(i.a aVar, String str) {
    }

    public final Bitmap Na() {
        if (aa.getContext() == null) {
            return null;
        }
        return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
    }
}

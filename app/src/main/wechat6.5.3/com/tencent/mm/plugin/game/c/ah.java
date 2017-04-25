package com.tencent.mm.plugin.game.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class ah implements i {
    protected String mPicUrl;

    public ah(String str) {
        this.mPicUrl = str;
        File file = new File(e.cgj);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public final String MU() {
        return e.cgj + g.m(this.mPicUrl.getBytes());
    }

    public final String MV() {
        return this.mPicUrl;
    }

    public final String MW() {
        return this.mPicUrl.hashCode();
    }

    public final String MX() {
        return this.mPicUrl.hashCode();
    }

    public final boolean MY() {
        return true;
    }

    public final boolean MZ() {
        return false;
    }

    public final Bitmap Na() {
        return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
    }

    public final Bitmap a(Bitmap bitmap, a aVar) {
        if (a.doU != aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, MU(), false);
            } catch (Throwable e) {
                v.a("MicroMsg.GetGamePicStrategy", e, "", new Object[0]);
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
}

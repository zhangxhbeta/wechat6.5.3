package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.IOException;

public final class i implements com.tencent.mm.platformtools.i {
    public static final String eDd = (e.cnj + "card");
    public static final String eDe = (eDd + File.separator + "video");
    private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
    private String mPicUrl = null;

    public i(String str) {
        this.mPicUrl = str;
    }

    public final String MU() {
        return String.format("%s/%s", new Object[]{eDd, g.m(this.mPicUrl.getBytes())});
    }

    public static String pR(String str) {
        return String.format("%s/%s", new Object[]{eDd, g.m(str.getBytes())});
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
        return true;
    }

    public final boolean MZ() {
        return false;
    }

    public final Bitmap Na() {
        v.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
        return null;
    }

    public final Bitmap a(Bitmap bitmap, a aVar) {
        if (a.NET == aVar) {
            try {
                d.a(bitmap, 100, CompressFormat.PNG, MU(), false);
            } catch (IOException e) {
                try {
                    File file = new File(MU());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    v.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
                    d.a(bitmap, 100, CompressFormat.PNG, MU(), false);
                } catch (Throwable e2) {
                    v.a("MicroMsg.CardSimpleGetPicStrategy", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
                }
            }
        }
        v.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", aVar.toString());
        return bitmap;
    }

    public final void Nb() {
    }

    public final void H(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }
}

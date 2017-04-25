package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import org.json.JSONArray;

public final class g implements d {
    public final String getMethod() {
        return "drawImage";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 3) {
            return false;
        }
        String optString = jSONArray.optString(0);
        float b = d.b(jSONArray, 1);
        float b2 = d.b(jSONArray, 2);
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        Bitmap decodeFile;
        if (optString.startsWith("wxfile://")) {
            AppBrandLocalMediaObject az = c.az(fVar.dzg, optString);
            if (az == null) {
                return false;
            }
            decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(az.cvK, null);
        } else {
            WebResourceResponse ar = b.ar(fVar.dzg, optString);
            if (ar == null) {
                return false;
            }
            decodeFile = com.tencent.mm.sdk.platformtools.d.decodeStream(ar.getData());
        }
        if (decodeFile == null || decodeFile.isRecycled()) {
            return false;
        }
        float ht = (float) d.ht(decodeFile.getWidth());
        float ht2 = (float) d.ht(decodeFile.getHeight());
        if (jSONArray.length() >= 5) {
            ht = d.a(jSONArray, 3, ht);
            ht2 = d.a(jSONArray, 4, ht2);
        }
        canvas.drawBitmap(decodeFile, new Rect(0, 0, decodeFile.getWidth(), decodeFile.getHeight()), new RectF(b, b2, ht + b, ht2 + b2), null);
        return true;
    }
}

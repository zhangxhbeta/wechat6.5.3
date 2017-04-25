package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONArray;

public final class b implements d {
    public final String getMethod() {
        return "clearRect";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        float b = d.b(jSONArray, 0);
        float b2 = d.b(jSONArray, 1);
        float b3 = d.b(jSONArray, 2);
        float b4 = d.b(jSONArray, 3);
        if (canvas instanceof a) {
            a aVar = (a) canvas;
            float f = b + b3;
            float f2 = b2 + b4;
            Bitmap bitmap = aVar.mBitmap;
            RectF rectF = new RectF(b, b2, f, f2);
            RectF rectF2 = new RectF(0.0f, 0.0f, (float) aVar.mBitmap.getWidth(), (float) aVar.mBitmap.getHeight());
            Op op = Op.XOR;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            canvas2.clipRect(rectF);
            canvas2.clipRect(rectF2, op);
            canvas2.drawBitmap(bitmap, 0.0f, 0.0f, null);
            if (!(createBitmap == null || createBitmap.isRecycled())) {
                aVar.setBitmap(createBitmap);
            }
            v.v("MicroMsg.ClearRectAction", "AppBrandCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", new Object[]{Float.valueOf(b), Float.valueOf(b2), Float.valueOf(b3), Float.valueOf(b4)});
        } else {
            v.v("MicroMsg.ClearRectAction", "clearRect(x : %s, y : %s, w : %s, h : %s)", new Object[]{Float.valueOf(b), Float.valueOf(b2), Float.valueOf(b3), Float.valueOf(b4)});
        }
        return true;
    }
}

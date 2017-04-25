package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "canvasToTempFilePath";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        super.a(fVar, jSONObject, i);
        h a = d.a(fVar);
        if (a == null) {
            v.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
            fVar.y(i, c("fail", null));
            return;
        }
        try {
            int i2 = jSONObject.getInt("canvasId");
            View nF = e.Qp().nF(e.a(a, "canvas", i2));
            if (nF == null) {
                v.w("MicroMsg.JsApiCanvasToTempFilePath", "get view by viewId(%s) return null.", new Object[]{Integer.valueOf(i2)});
                fVar.y(i, c("fail:get canvas by canvasId failed", null));
                return;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(nF.getMeasuredWidth(), nF.getMeasuredHeight(), Config.ARGB_8888);
                nF.draw(new Canvas(createBitmap));
                String av = c.av(a.dzg, "canvas_" + i2);
                try {
                    d.a(createBitmap, 100, CompressFormat.PNG, av, true);
                    AppBrandLocalMediaObject b = c.b(a.dzg, av, "png", true);
                    if (b == null) {
                        v.w("MicroMsg.JsApiCanvasToTempFilePath", "gen temp file failed, canvasId : %s.", new Object[]{Integer.valueOf(i2)});
                        fVar.y(i, c("fail:gen temp file failed", null));
                        return;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("tempFilePath", b.bde);
                    fVar.y(i, c("ok", hashMap));
                    v.v("MicroMsg.JsApiCanvasToTempFilePath", "save file(id : %s) to path : %s", new Object[]{b.bde, b.cvK});
                } catch (IOException e) {
                    v.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", new Object[]{Integer.valueOf(i2), e});
                    fVar.y(i, c("fail:write file failed", null));
                }
            } catch (Exception e2) {
                v.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", new Object[]{Integer.valueOf(i2), e2});
                fVar.y(i, c("fail:create bitmap failed", null));
            }
        } catch (JSONException e3) {
            v.w("MicroMsg.JsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", new Object[]{e3});
            fVar.y(i, c("fail:canvasId do not exist", null));
        }
    }
}

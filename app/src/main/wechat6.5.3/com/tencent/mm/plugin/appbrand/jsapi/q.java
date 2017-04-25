package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Paint.Style;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.plugin.appbrand.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.AppBrandDrawableView;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q extends c {
    public static final int CTRL_INDEX = 69;
    public static final String NAME = "drawCanvas";

    protected final String Qd() {
        return "canvas";
    }

    protected final int d(JSONObject jSONObject) {
        return jSONObject.getInt("canvasId");
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            return null;
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final boolean Qe() {
        return true;
    }

    protected final boolean a(h hVar, int i, View view, JSONObject jSONObject) {
        v.d("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", new Object[]{Integer.valueOf(i)});
        if (view instanceof AppBrandDrawableView) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONArray optJSONArray = jSONObject.optJSONArray("actions");
            AppBrandDrawableView appBrandDrawableView = (AppBrandDrawableView) view;
            if (!jSONObject.optBoolean("reserve")) {
                appBrandDrawableView.dVk = optJSONArray;
                f fVar = appBrandDrawableView.dVm;
                fVar.dCo.clear();
                fVar.dCp.clear();
                fVar.dCm.reset();
                fVar.dCn.reset();
                fVar.dCm.setStyle(Style.STROKE);
                fVar.dCn.setStyle(Style.FILL);
                fVar.dCm.setAntiAlias(true);
                fVar.dCn.setAntiAlias(true);
            } else if (!(optJSONArray == null || optJSONArray.length() == 0)) {
                if (appBrandDrawableView.dVk == null) {
                    appBrandDrawableView.dVk = optJSONArray;
                } else {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        appBrandDrawableView.dVk.put(optJSONArray.opt(i2));
                    }
                }
            }
            appBrandDrawableView.postInvalidate();
            v.v("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return super.a(hVar, i, view, jSONObject);
        }
        v.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", new Object[]{Integer.valueOf(i)});
        return false;
    }
}

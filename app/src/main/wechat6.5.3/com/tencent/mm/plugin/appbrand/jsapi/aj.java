package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.AppBrandDrawableView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aj extends a {
    public static final int CTRL_INDEX = 67;
    public static final String NAME = "insertCanvas";

    protected final View a(h hVar, JSONObject jSONObject) {
        View appBrandDrawableView = new AppBrandDrawableView(hVar.getContext());
        appBrandDrawableView.dVm.dzg = hVar.dzg;
        return appBrandDrawableView;
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            Map hashMap = new HashMap();
            hashMap.put("canvasId", Integer.valueOf(i));
            return c("ok", hashMap);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final String Qd() {
        return "canvas";
    }

    protected final int d(JSONObject jSONObject) {
        return jSONObject.getInt("canvasId");
    }

    protected final boolean Qj() {
        return true;
    }

    protected final boolean Qk() {
        return true;
    }
}

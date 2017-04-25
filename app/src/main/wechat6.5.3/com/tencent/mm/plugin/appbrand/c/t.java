package com.tencent.mm.plugin.appbrand.c;

import android.graphics.Canvas;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONArray;
import org.json.JSONException;

public final class t implements d {
    public final String getMethod() {
        return "setGlobalAlpha";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        try {
            int i = jSONArray.getInt(0);
            fVar.dCm.setAlpha(i);
            fVar.dCn.setAlpha(i);
            return true;
        } catch (JSONException e) {
            v.e("MicroMsg.SetGlobalAlphaAction", "getGlobalAlpha value error. exception : %s", new Object[]{e});
            return z;
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import android.view.View;
import android.widget.VideoView;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

final class bz extends b {
    private static final int CTRL_INDEX = 7;
    public static final String NAME = "removeVideoPlayer";

    bz() {
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            return c("ok", null);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final int d(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId", 0);
    }

    protected final boolean a(h hVar, int i, View view) {
        o.b a = a(hVar, i);
        if (a == null) {
            v.i("MicroMsg.jsApiRemoveVideoPlayer", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        ((VideoView) a.a("video_view", VideoView.class)).stopPlayback();
        return true;
    }
}

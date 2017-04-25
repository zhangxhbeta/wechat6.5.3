package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.base.c {
    public static final int CTRL_INDEX = 140;
    public static final String NAME = "addMapControls";

    private static class a extends e {
        private static final int CTRL_INDEX = 143;
        private static final String NAME = "onMapControlClick";

        private a() {
        }
    }

    protected final int d(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            v.e("MicroMsg.JsApiAddMapControls", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            return c("ok", null);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean a(final com.tencent.mm.plugin.appbrand.page.h r14, final int r15, android.view.View r16, org.json.JSONObject r17) {
        /*
        r13 = this;
        r1 = 1;
        r2 = r13.a(r14, r15, r1);
        if (r2 != 0) goto L_0x001c;
    L_0x0007:
        r1 = "MicroMsg.JsApiAddMapControls";
        r2 = "KeyValueSet(%s) is null.";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Integer.valueOf(r15);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
        r1 = 0;
    L_0x001b:
        return r1;
    L_0x001c:
        r1 = "controls";
        r0 = r17;
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x0131 }
        if (r1 == 0) goto L_0x0144;
    L_0x0027:
        r1 = "map_controls";
        r3 = java.util.List.class;
        r1 = r2.a(r1, r3);	 Catch:{ Exception -> 0x0131 }
        r1 = (java.util.List) r1;	 Catch:{ Exception -> 0x0131 }
        if (r1 != 0) goto L_0x014b;
    L_0x0034:
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0131 }
        r1.<init>();	 Catch:{ Exception -> 0x0131 }
        r3 = "map_controls";
        r2.l(r3, r1);	 Catch:{ Exception -> 0x0131 }
        r5 = r1;
    L_0x0040:
        r1 = r5.size();	 Catch:{ Exception -> 0x0131 }
        if (r1 <= 0) goto L_0x0060;
    L_0x0046:
        r1 = 0;
        r2 = r1;
    L_0x0048:
        r1 = r5.size();	 Catch:{ Exception -> 0x0131 }
        if (r2 >= r1) goto L_0x005d;
    L_0x004e:
        r1 = r5.get(r2);	 Catch:{ Exception -> 0x0131 }
        r1 = (android.widget.ImageView) r1;	 Catch:{ Exception -> 0x0131 }
        r3 = 8;
        r1.setVisibility(r3);	 Catch:{ Exception -> 0x0131 }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0048;
    L_0x005d:
        r5.clear();	 Catch:{ Exception -> 0x0131 }
    L_0x0060:
        r6 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0131 }
        r1 = "controls";
        r0 = r17;
        r1 = r0.optString(r1);	 Catch:{ Exception -> 0x0131 }
        r6.<init>(r1);	 Catch:{ Exception -> 0x0131 }
        r1 = 0;
        r2 = r1;
    L_0x0070:
        r1 = r6.length();	 Catch:{ Exception -> 0x0131 }
        if (r2 >= r1) goto L_0x0144;
    L_0x0076:
        r1 = r6.get(r2);	 Catch:{ Exception -> 0x0131 }
        r1 = (org.json.JSONObject) r1;	 Catch:{ Exception -> 0x0131 }
        r3 = "iconPath";
        r4 = r1.optString(r3);	 Catch:{ Exception -> 0x0131 }
        r3 = "clickable";
        r7 = r1.optBoolean(r3);	 Catch:{ Exception -> 0x0131 }
        r3 = "data";
        r8 = r1.optString(r3);	 Catch:{ Exception -> 0x0131 }
        r3 = "position";
        r9 = r1.getJSONObject(r3);	 Catch:{ JSONException -> 0x011e }
        r3 = 0;
        r1 = 0;
        r10 = new android.widget.ImageView;	 Catch:{ Exception -> 0x0131 }
        r11 = r16.getContext();	 Catch:{ Exception -> 0x0131 }
        r10.<init>(r11);	 Catch:{ Exception -> 0x0131 }
        r11 = r14.dzg;	 Catch:{ Exception -> 0x0131 }
        r4 = com.tencent.mm.plugin.appbrand.appcache.b.ar(r11, r4);	 Catch:{ Exception -> 0x0131 }
        if (r4 == 0) goto L_0x00be;
    L_0x00ab:
        r1 = r4.getData();	 Catch:{ Exception -> 0x0131 }
        r3 = com.tencent.mm.sdk.platformtools.d.decodeStream(r1);	 Catch:{ Exception -> 0x0131 }
        r10.setImageBitmap(r3);	 Catch:{ Exception -> 0x0131 }
        r1 = r3.getHeight();	 Catch:{ Exception -> 0x0131 }
        r3 = r3.getWidth();	 Catch:{ Exception -> 0x0131 }
    L_0x00be:
        r4 = "width";
        r4 = r9.has(r4);	 Catch:{ Exception -> 0x0131 }
        if (r4 == 0) goto L_0x0149;
    L_0x00c7:
        r3 = "width";
        r3 = com.tencent.mm.plugin.appbrand.k.d.a(r9, r3);	 Catch:{ Exception -> 0x0131 }
        r4 = r3;
    L_0x00cf:
        r3 = "height";
        r3 = r9.has(r3);	 Catch:{ Exception -> 0x0131 }
        if (r3 == 0) goto L_0x0147;
    L_0x00d8:
        r1 = "height";
        r1 = com.tencent.mm.plugin.appbrand.k.d.a(r9, r1);	 Catch:{ Exception -> 0x0131 }
        r3 = r1;
    L_0x00e0:
        r1 = "top";
        r11 = com.tencent.mm.plugin.appbrand.k.d.a(r9, r1);	 Catch:{ Exception -> 0x0131 }
        r1 = "left";
        r9 = com.tencent.mm.plugin.appbrand.k.d.a(r9, r1);	 Catch:{ Exception -> 0x0131 }
        r0 = r16;
        r0 = (android.widget.FrameLayout) r0;	 Catch:{ Exception -> 0x0131 }
        r1 = r0;
        r12 = new android.widget.FrameLayout$LayoutParams;	 Catch:{ Exception -> 0x0131 }
        r12.<init>(r4, r3);	 Catch:{ Exception -> 0x0131 }
        r3 = 0;
        r4 = 0;
        r12.setMargins(r9, r11, r3, r4);	 Catch:{ Exception -> 0x0131 }
        r1.addView(r10, r12);	 Catch:{ Exception -> 0x0131 }
        r5.add(r10);	 Catch:{ Exception -> 0x0131 }
        if (r7 == 0) goto L_0x0119;
    L_0x0105:
        r1 = new com.tencent.mm.plugin.appbrand.jsapi.map.c$1;	 Catch:{ Exception -> 0x0131 }
        r1.<init>(r13, r10);	 Catch:{ Exception -> 0x0131 }
        r10.setOnTouchListener(r1);	 Catch:{ Exception -> 0x0131 }
        r1 = 1;
        r10.setClickable(r1);	 Catch:{ Exception -> 0x0131 }
        r1 = new com.tencent.mm.plugin.appbrand.jsapi.map.c$2;	 Catch:{ Exception -> 0x0131 }
        r1.<init>(r13, r15, r8, r14);	 Catch:{ Exception -> 0x0131 }
        r10.setOnClickListener(r1);	 Catch:{ Exception -> 0x0131 }
    L_0x0119:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0070;
    L_0x011e:
        r1 = move-exception;
        r2 = "MicroMsg.JsApiAddMapControls";
        r3 = "parse position error, exception : %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0131 }
        r5 = 0;
        r4[r5] = r1;	 Catch:{ Exception -> 0x0131 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ Exception -> 0x0131 }
        r1 = 0;
        goto L_0x001b;
    L_0x0131:
        r1 = move-exception;
        r2 = "MicroMsg.JsApiAddMapControls";
        r3 = "parse circles error, exception : %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r1;
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
        r1 = 0;
        goto L_0x001b;
    L_0x0144:
        r1 = 1;
        goto L_0x001b;
    L_0x0147:
        r3 = r1;
        goto L_0x00e0;
    L_0x0149:
        r4 = r3;
        goto L_0x00cf;
    L_0x014b:
        r5 = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.map.c.a(com.tencent.mm.plugin.appbrand.page.h, int, android.view.View, org.json.JSONObject):boolean");
    }

    protected final boolean Qe() {
        return true;
    }
}

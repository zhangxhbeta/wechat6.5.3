package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    public static final int CTRL_INDEX = 121;
    public static final String NAME = "insertShareButton";

    public static class a extends e {
        private static final int CTRL_INDEX = 121;
        private static final String NAME = "onShareAppMessage";
    }

    protected final View a(h hVar, JSONObject jSONObject) {
        View button = new Button(hVar.getContext());
        if ("default-light".equals(jSONObject.optString("buttonType", "default-dark"))) {
            button.setBackgroundResource(2131165276);
        } else {
            button.setBackgroundResource(2131165275);
        }
        return button;
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            Map hashMap = new HashMap();
            hashMap.put("shareButtonId", Integer.valueOf(i));
            return c("ok", hashMap);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final void b(final h hVar, final int i, View view, JSONObject jSONObject) {
        a(hVar, i, true).G("data", jSONObject.optString("data", ""));
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ak dHl;

            public final void onClick(View view) {
                String str = hVar.dNn.dOM;
                Object obj = "";
                Object obj2 = "";
                AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(hVar.dzg);
                if (mr != null) {
                    obj = mr.aZU;
                }
                b a = this.dHl.a(hVar, i, false);
                if (a != null) {
                    obj2 = a.getString("data", "");
                }
                a aVar = new a();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", obj);
                    jSONObject.put("desc", "");
                    jSONObject.put("path", str);
                    jSONObject.put("imgUrl", "");
                    jSONObject.put(Columns.TYPE, "page");
                    jSONObject.put("data", obj2);
                } catch (JSONException e) {
                    v.e("MicroMsg.JsApiInsertShareButton", "put JSON data error : %s", new Object[]{e});
                }
                JsApiShareAppMessage.Ql();
                e a2 = aVar.a(hVar);
                a2.mData = jSONObject.toString();
                a2.PX();
            }
        });
    }
}

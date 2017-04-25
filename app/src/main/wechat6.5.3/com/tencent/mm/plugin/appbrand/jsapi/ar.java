package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ar extends a {
    public static final int CTRL_INDEX = 30;
    public static final String NAME = "previewImage";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("current");
        List arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urls");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String optString2 = optJSONArray.optString(i2);
                if (!be.kS(optString2)) {
                    arrayList.add(optString2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            fVar.y(i, c("fail", null));
            return;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        String str = optString;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (be.ma(strArr[i3]).startsWith("wxfile://")) {
                AppBrandLocalMediaObject az = c.az(fVar.dzg, strArr[i3]);
                boolean equals = be.ma(str).equals(strArr[i3]);
                if (az != null) {
                    strArr[i3] = az.cvK;
                } else {
                    strArr[i3] = "";
                }
                if (equals) {
                    str = strArr[i3];
                }
            }
        }
        if (be.kS(str)) {
            str = strArr[0];
        }
        MMActivity nt = d.nt(fVar.dzg);
        if (nt == null) {
            fVar.y(i, c("fail", null));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("nowUrl", str);
        intent.putExtra("urlList", strArr);
        intent.putExtra(Columns.TYPE, -255);
        intent.putExtra("isFromWebView", true);
        com.tencent.mm.ay.c.b(nt, "subapp", ".ui.gallery.GestureGalleryUI", intent);
    }
}

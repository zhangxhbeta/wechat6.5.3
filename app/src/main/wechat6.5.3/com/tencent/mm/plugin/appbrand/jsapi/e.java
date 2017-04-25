package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;
import org.json.JSONObject;

public abstract class e extends b {
    private int dEY;
    String dzg;
    public String mData;

    public final e a(c cVar) {
        if (cVar != null) {
            this.dzg = cVar.getAppId();
            this.dEY = cVar.OI();
        }
        return this;
    }

    public final e aa(String str, int i) {
        this.dzg = str;
        this.dEY = i;
        return this;
    }

    public final e o(Map<String, Object> map) {
        a.p(map);
        this.mData = new JSONObject(map).toString();
        return this;
    }

    public final boolean PX() {
        if (b.b(this.dzg, this)) {
            com.tencent.mm.plugin.appbrand.a.a(this.dzg, getName(), this.mData, this.dEY);
            return true;
        }
        v.d("MicroMsg.AppBrandJsApiEvent", "event name = %s, ctrlIndex = %d, perm denied", new Object[]{getName(), Integer.valueOf(PS())});
        return false;
    }

    public final boolean k(int[] iArr) {
        if (b.b(this.dzg, this)) {
            com.tencent.mm.plugin.appbrand.a.a(this.dzg, getName(), this.mData, iArr);
            return true;
        }
        v.d("MicroMsg.AppBrandJsApiEvent", "event name = %s, ctrlIndex = %d, perm denied", new Object[]{getName(), Integer.valueOf(PS())});
        return false;
    }
}

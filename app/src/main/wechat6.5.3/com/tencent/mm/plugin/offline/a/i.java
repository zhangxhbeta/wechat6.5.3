package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.network.p;
import org.json.JSONObject;

public final class i extends e {
    public String hJU;

    public final int aed() {
        return 78;
    }

    public final void a(int i, JSONObject jSONObject) {
        this.hJU = jSONObject.optString("barcode");
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        super.a(i, i2, i3, str, pVar, bArr);
    }
}

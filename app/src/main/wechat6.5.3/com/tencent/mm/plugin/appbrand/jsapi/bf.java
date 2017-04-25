package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.g.j;
import com.tencent.mm.plugin.appbrand.l.a.b;
import com.tencent.mm.plugin.appbrand.l.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class bf extends a {
    public static final int CTRL_INDEX = 22;
    public static final String NAME = "sendSocketMessage";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        j nR = a.dMK.nR(fVar.dzg);
        if (nR != null) {
            String optString = jSONObject.optString("data");
            if (optString != null) {
                try {
                    c cVar;
                    if (jSONObject.optBoolean("isBuffer")) {
                        ByteBuffer wrap = ByteBuffer.wrap(Base64.decode(optString.getBytes(ProtocolPackage.ServerEncoding), 2));
                        cVar = nR.dMG.dTO;
                        if (wrap == null) {
                            v.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
                        } else {
                            cVar.d(cVar.dTE.a(wrap, cVar.dTF == b.dTr));
                        }
                        fVar.y(i, c("ok", null));
                        return;
                    }
                    cVar = nR.dMG.dTO;
                    if (optString == null) {
                        v.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
                    } else {
                        cVar.d(cVar.dTE.M(optString, cVar.dTF == b.dTr));
                    }
                    fVar.y(i, c("ok", null));
                    return;
                } catch (Exception e) {
                    v.e("MicroMsg.JsApiSendSocketMessage", "sendSocketMessage error : %s", new Object[]{e});
                    fVar.y(i, c("fail", null));
                }
            } else {
                fVar.y(i, c("fail", null));
                return;
            }
        }
        fVar.y(i, c("fail", null));
    }
}

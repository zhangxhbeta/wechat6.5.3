package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class y {
    private static y ler = new y();
    HashMap<String, x> les = new HashMap();

    public static final y bik() {
        return ler;
    }

    public final void b(x xVar) {
        if (xVar == null || be.kS(xVar.bde)) {
            v.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
            return;
        }
        v.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", new Object[]{xVar.bde, xVar.lel});
        this.les.put(xVar.bde, xVar);
    }

    public final x DW(String str) {
        if (!be.kS(str)) {
            return (x) this.les.get(str);
        }
        v.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
        return null;
    }
}

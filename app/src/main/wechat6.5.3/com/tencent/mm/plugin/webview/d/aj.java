package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class aj {
    private static Map<String, String> lfn = new HashMap();

    public static void cY(String str, String str2) {
        v.i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", new Object[]{str, str2});
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
        } else {
            lfn.put(str, str2);
        }
    }

    public static String Ec(String str) {
        v.i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", new Object[]{str});
        if (be.kS(str)) {
            v.e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
            return null;
        }
        String str2 = (String) lfn.get(str);
        return !be.kS(str2) ? str2 : str;
    }

    public static void clear() {
        lfn.clear();
    }
}

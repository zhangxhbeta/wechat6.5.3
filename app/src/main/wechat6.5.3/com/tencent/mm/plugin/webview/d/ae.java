package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class ae extends f<ad> {
    public static final String[] cic = new String[]{f.a(ad.chq, "WebviewLocalData")};

    public ae(d dVar) {
        super(dVar, ad.chq, "WebviewLocalData", null);
    }

    public static int R(String str, String str2, String str3) {
        return (str + str2 + str3).hashCode();
    }
}

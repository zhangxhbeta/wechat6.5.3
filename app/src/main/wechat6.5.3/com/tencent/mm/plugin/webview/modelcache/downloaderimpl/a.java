package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.h;

final class a {
    static final String lgv = (e.cnj + "wvtemp/");

    static String T(String str, String str2, String str3) {
        return String.format("%d.%d.%d.wvcache", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(str2.hashCode()), Integer.valueOf(str3.hashCode())});
    }

    static String Eu(String str) {
        h.JX(lgv);
        Uri parse = Uri.parse(str);
        return lgv + String.format("%d.%d", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(be.ma(parse.getLastPathSegment()).hashCode())});
    }
}

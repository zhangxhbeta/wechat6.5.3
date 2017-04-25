package com.tencent.mm.plugin.webview.d;

import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class u {
    private static final Set<String> lee;

    static {
        Set hashSet = new HashSet();
        lee = hashSet;
        hashSet.add("file:///android_asset/");
        String str = e.cnh;
        if (!be.kS(str)) {
            str = e.cnh.replace("/data/user/0", "/data/data");
        }
        lee.add("file://" + new File(str, "fts/res").getAbsolutePath());
        lee.add("file://" + new File(e.cnj, "fts/res").getAbsolutePath());
        lee.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        lee.add("file://" + new File(e.cnj, "wenote/res").getAbsolutePath());
        v.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r2.getAbsolutePath()});
        lee.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        lee.add("file://" + new File(e.cnj, "emoji/res").getAbsolutePath());
        v.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r0.getAbsolutePath()});
        Iterator it = lee.iterator();
        while (it.hasNext()) {
            v.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[]{(String) it.next()});
        }
    }

    public static boolean DQ(String str) {
        if (q.dqg) {
            v.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
            return true;
        } else if (be.kS(str)) {
            return true;
        } else {
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("about:blank")) {
                return false;
            }
            if (toLowerCase.startsWith("file://")) {
                for (String startsWith : lee) {
                    if (toLowerCase.startsWith(startsWith)) {
                        return true;
                    }
                }
                return false;
            }
            Uri parse = Uri.parse(toLowerCase);
            if (be.kS(parse.getHost())) {
                return true;
            }
            return !parse.getHost().contains(s.bre());
        }
    }
}

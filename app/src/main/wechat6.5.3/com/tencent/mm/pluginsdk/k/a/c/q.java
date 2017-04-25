package com.tencent.mm.pluginsdk.k.a.c;

import android.annotation.SuppressLint;
import com.tencent.mm.pluginsdk.k.a.a.b.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class q {
    private static final HashMap<Integer, h> lEE;
    private static volatile List<h> lEF = null;

    static {
        HashMap hashMap = new HashMap(2);
        lEE = hashMap;
        hashMap.put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new a());
        try {
            lEE.put(Integer.valueOf("WebViewCacheDownload".hashCode()), (h) Class.forName("com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper$ResDownloaderPlugin").newInstance());
        } catch (Throwable e) {
            v.a("MicroMsg.ResDownloaderPluginMap", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void init() {
    }

    public static Collection<h> boh() {
        if (lEF != null) {
            return lEF;
        }
        List linkedList = new LinkedList();
        for (Integer intValue : lEE.keySet()) {
            h hVar = (h) lEE.get(Integer.valueOf(intValue.intValue()));
            if (hVar != null) {
                linkedList.add(hVar);
            }
        }
        lEF = linkedList;
        return linkedList;
    }
}

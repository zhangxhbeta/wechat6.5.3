package com.tencent.mm.plugin.webview.modelcache;

import android.database.Cursor;
import com.tencent.mm.plugin.webview.modelcache.e.a;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import java.util.LinkedList;
import java.util.List;

public final class k extends f<j> {
    static final String[] cic = new String[]{f.a(j.chq, "WebViewCacheResConfigMap")};

    public static a biD() {
        return new a("WEBVIEW_RESOURCE_CACHE_CONFIG_MAP_TABLE".hashCode(), cic);
    }

    public k(d dVar) {
        super(dVar, j.chq, "WebViewCacheResConfigMap", null);
    }

    public final j Eh(String str) {
        j jVar = new j();
        jVar.field_configId = str;
        if (b(jVar, new String[0])) {
            return jVar;
        }
        return null;
    }

    final List<j> g(String str, String... strArr) {
        Cursor rawQuery = rawQuery(str, strArr);
        if (rawQuery == null) {
            return null;
        }
        List<j> linkedList = new LinkedList();
        if (rawQuery.moveToFirst()) {
            do {
                j jVar = new j();
                jVar.b(rawQuery);
                linkedList.add(jVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return linkedList;
    }

    public final boolean a(j jVar) {
        return super.a(jVar, new String[]{"configId"});
    }

    public final boolean b(j jVar) {
        return super.b(jVar);
    }
}

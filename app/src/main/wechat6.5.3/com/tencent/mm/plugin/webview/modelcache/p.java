package com.tencent.mm.plugin.webview.modelcache;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.webview.modelcache.e.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.util.LinkedList;
import java.util.List;

public final class p extends f<i> {
    private static volatile p lfR = null;
    private final d cie;
    public final boolean lfs;

    public final /* synthetic */ boolean b(c cVar) {
        return d((i) cVar);
    }

    public static List<a> biK() {
        List linkedList = new LinkedList();
        linkedList.add(new a("WEBVIEW_RESOURCE_CACHE_TABLE".hashCode(), new String[]{f.a(i.chq, "WebViewResourceCache")}));
        return linkedList;
    }

    public static p biL() {
        if (!ak.uz()) {
            return new p(null);
        }
        if (lfR == null) {
            synchronized (p.class) {
                if (lfR == null || !lfR.lfs) {
                    ak.yW();
                    lfR = new p(com.tencent.mm.model.c.wE());
                }
            }
        }
        return lfR;
    }

    private p(d dVar) {
        super(dVar, i.chq, "WebViewResourceCache", null);
        this.cie = dVar;
        this.lfs = dVar != null;
        if (!this.lfs) {
            v.e("MicroMsg.WebViewCacheResStorage", "storage can not work!!!");
        }
    }

    static String sJ(int i) {
        String str = "1=1";
        if (b.a.sF(i) && b.a.sE(i)) {
            return str;
        }
        return String.format(" %s=%s ", new Object[]{"protocol", Integer.valueOf(i)});
    }

    public final List<i> h(String str, String... strArr) {
        List<i> list = null;
        Cursor rawQuery = rawQuery(str, strArr);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                list = new LinkedList();
                do {
                    i iVar = new i();
                    iVar.b(rawQuery);
                    list.add(iVar);
                } while (rawQuery.moveToNext());
                rawQuery.close();
            } else {
                rawQuery.close();
            }
        }
        return list;
    }

    final i i(String str, String... strArr) {
        Cursor rawQuery = rawQuery(str, strArr);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.moveToFirst()) {
            i iVar = new i();
            iVar.b(rawQuery);
            rawQuery.close();
            return iVar;
        }
        rawQuery.close();
        return null;
    }

    public final boolean checkIsCached(String str, int i) {
        if (!this.lfs || be.kS(str)) {
            return false;
        }
        String sJ = sJ(i);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", sJ}), new String[]{String.valueOf(z.Kg(str).hashCode())});
        if (rawQuery == null) {
            return false;
        }
        if (rawQuery.getCount() > 0) {
            rawQuery.close();
            return true;
        }
        rawQuery.close();
        return false;
    }

    public final i b(String str, String str2, int i, String str3, String str4) {
        if (!this.lfs || be.kS(str) || be.kS(str2) || be.kS(str3) || be.kS(str4)) {
            return null;
        }
        i iVar = new i();
        iVar.field_appId = str;
        iVar.field_domain = str2;
        iVar.field_cacheType = i;
        iVar.field_urlMd5Hashcode = z.Kg(str3).hashCode();
        iVar.field_packageId = str4;
        if (b(iVar, new String[]{"appId", "domain", "cacheType", "urlMd5Hashcode", "packageId"})) {
            return iVar;
        }
        return null;
    }

    public final boolean d(i iVar) {
        if (!this.lfs) {
            return false;
        }
        if (be.kS(iVar.field_url)) {
            v.d("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, url is null or nil");
            return false;
        }
        String Kg = z.Kg(iVar.field_url);
        if (be.kS(Kg)) {
            v.e("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, get md5 is null or nil , url = %s", new Object[]{iVar.field_url});
            return false;
        }
        iVar.field_urlMd5Hashcode = Kg.hashCode();
        long Nh = be.Nh();
        iVar.field_accessTime = Nh;
        iVar.field_createTime = Nh;
        return a(iVar, false);
    }

    public final boolean insert(i iVar, int i, int i2) {
        return d(iVar);
    }

    public final boolean update(i iVar, int i, int i2) {
        return e(iVar);
    }

    public final boolean e(i iVar) {
        if (!this.lfs) {
            return false;
        }
        if (be.kS(iVar.field_url)) {
            v.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, url is null or nil");
            return false;
        }
        long Nh = be.Nh();
        iVar.field_accessTime = Nh;
        iVar.field_createTime = Nh;
        v.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, record = " + iVar);
        return b(iVar, false, new String[]{"urlMd5Hashcode", "appId", "domain", "cacheType", "packageId"});
    }
}

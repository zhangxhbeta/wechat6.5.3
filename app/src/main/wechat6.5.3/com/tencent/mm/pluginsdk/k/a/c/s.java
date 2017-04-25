package com.tencent.mm.pluginsdk.k.a.c;

import android.annotation.SuppressLint;
import com.tencent.mm.a.g;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class s extends f<r> {
    private static final String[] cic = new String[]{f.a(r.chq, "ResDownloaderRecordTable")};
    private static final String lEG = (t.cng + g.m(String.format("mm%d", new Object[]{Integer.valueOf(Integer.MIN_VALUE)}).getBytes()) + "/");
    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Integer, c> lEH;
    private final com.tencent.mm.bg.g cuX;
    private final HashMap<String, Object> lEI = new HashMap();

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.h.c cVar) {
        return g((r) cVar);
    }

    static {
        HashMap hashMap = new HashMap();
        lEH = hashMap;
        hashMap.put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return s.cic;
            }
        });
        Iterator it = q.boh().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private s(com.tencent.mm.bg.g gVar) {
        super(gVar, r.chq, "ResDownloaderRecordTable", null);
        this.cuX = gVar;
        Iterator it = q.boh().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    static s boi() {
        try {
            new File(lEG).mkdirs();
            com.tencent.mm.bg.g gVar = new com.tencent.mm.bg.g();
            if (gVar.a(lEG + "ResDown.db", lEG + "EnResDown.db", -2147483648L, p.rJ(), lEH)) {
                return new s(gVar);
            }
            v.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
            return null;
        } catch (Exception e) {
            v.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", e);
            return null;
        }
    }

    public final boolean hc(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
            return false;
        }
        com.tencent.mm.sdk.h.c rVar = new r();
        rVar.field_urlKey_hashcode = str.hashCode();
        return super.c(rVar, "urlKey_hashcode");
    }

    public final boolean f(r rVar) {
        if (be.kS(rVar.field_urlKey)) {
            return false;
        }
        rVar.field_urlKey_hashcode = rVar.field_urlKey.hashCode();
        return super.a((com.tencent.mm.sdk.h.c) rVar, "urlKey_hashcode");
    }

    public final boolean g(r rVar) {
        if (be.kS(rVar.field_urlKey)) {
            return false;
        }
        rVar.field_urlKey_hashcode = rVar.field_urlKey.hashCode();
        return super.b(rVar);
    }

    public final r Hg(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
            return null;
        }
        com.tencent.mm.sdk.h.c rVar = new r();
        rVar.field_urlKey_hashcode = str.hashCode();
        if (super.b(rVar, "urlKey_hashcode")) {
            return rVar;
        }
        return null;
    }
}

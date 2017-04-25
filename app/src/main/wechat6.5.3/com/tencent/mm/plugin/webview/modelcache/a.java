package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.b.dh;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import java.util.List;

public final class a {
    private static final SparseArray<a> lfp = new SparseArray();
    private static volatile b lfq = null;
    private static final byte[] lfr = new byte[0];
    final String appId;
    final b lfo = biE();
    final String path;

    private static final class b extends f<a> {
        final boolean lfs;

        static /* synthetic */ void a(b bVar, String str, long j) {
            if (bVar.lfs) {
                a aVar = new a();
                aVar.field_appId = str;
                if (bVar.b(aVar, new String[0])) {
                    aVar.field_occupation += j;
                    bVar.a(aVar, new String[0]);
                    return;
                }
                aVar.field_occupation = j;
                bVar.b(aVar);
            }
        }

        static /* synthetic */ void b(b bVar, String str, long j) {
            if (bVar.lfs) {
                a aVar = new a();
                aVar.field_appId = str;
                if (bVar.b(aVar, new String[0])) {
                    aVar.field_occupation = j;
                    bVar.a(aVar, new String[0]);
                    return;
                }
                aVar.field_occupation = j;
                bVar.b(aVar);
            }
        }

        public b(d dVar) {
            super(dVar, a.cxi, "WebViewCacheAppIdOccupation", null);
            this.lfs = dVar != null;
        }
    }

    private static final class a extends dh {
        private static final com.tencent.mm.sdk.h.c.a cxi = dh.pz();

        private a() {
        }

        protected final com.tencent.mm.sdk.h.c.a tl() {
            return cxi;
        }
    }

    public static com.tencent.mm.plugin.webview.modelcache.e.a biD() {
        return new com.tencent.mm.plugin.webview.modelcache.e.a("WEBVIEW_RESOURCE_CACHE_APPID_OCCUPATION_TABLE".hashCode(), new String[]{f.a(dh.pz(), "WebViewCacheAppIdOccupation")});
    }

    static a Ed(String str) {
        if (be.kS(str)) {
            return null;
        }
        int hashCode = str.hashCode();
        a aVar = (a) lfp.get(hashCode);
        if (aVar == null) {
            aVar = new a(str);
            lfp.put(hashCode, aVar);
            return aVar;
        }
        FileOp.jS(aVar.path);
        return aVar;
    }

    static void clearCache() {
        lfp.clear();
    }

    static long jP(String str) {
        if (be.kS(str)) {
            return 0;
        }
        return FileOp.jP(str);
    }

    private static b biE() {
        if (!ak.uz()) {
            return new b(null);
        }
        synchronized (lfr) {
            if (lfq == null || !lfq.lfs) {
                ak.yW();
                lfq = new b(c.wE());
            }
        }
        return lfq;
    }

    private a(String str) {
        this.appId = str;
        FileOp.jS(e.cgs + "sfs");
        this.path = e.cgs + String.valueOf(str.hashCode());
        FileOp.jS(this.path);
    }

    final void biF() {
        List<FileEntry> A = FileOp.A(this.path, true);
        if (be.bP(A)) {
            b.b(this.lfo, this.appId, 0);
        }
        long j = 0;
        for (FileEntry fileEntry : A) {
            if (!(fileEntry.size == 0 || fileEntry.timestamp == 0)) {
                j = Math.max(0, FileOp.jP(fileEntry.name)) + j;
            }
        }
        b.b(this.lfo, this.appId, j);
    }
}

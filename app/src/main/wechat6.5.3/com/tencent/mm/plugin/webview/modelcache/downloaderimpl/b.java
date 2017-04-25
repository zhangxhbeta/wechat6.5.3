package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.k.a.c.m;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.sdk.platformtools.v;

final class b {

    private static final class a {
        static void a(d dVar) {
            com.tencent.mm.pluginsdk.k.a.c.p.a.bog().d(new f(dVar.lCO, dVar.OZ(), dVar.lgE, dVar.url, dVar.lCY, dVar.networkType));
        }
    }

    static void c(String str, m mVar) {
        r Hg = com.tencent.mm.pluginsdk.k.a.c.p.a.bog().Hg(str);
        if (Hg == null) {
            v.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "networkRequest already completed, but get null record with urlKey = %s", new Object[]{str});
        } else if ("WebViewCache".equals(Hg.field_groupId1)) {
            Hg.field_contentType = mVar.bsL;
            com.tencent.mm.pluginsdk.k.a.c.p.a.bog().e(Hg);
            h hVar = new h(Hg.field_url, Hg.field_filePath, Hg.field_fileVersion, Hg.field_appId, Hg.field_groupId2, Hg.field_packageId, Hg.field_wvCacheType, mVar.bsL, mVar.bsM, mVar.lEv);
            WebViewCacheDownloadHelper.biQ();
            WebViewCacheDownloadHelper.a(hVar);
        } else {
            v.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "mismatch groupId, urlKey = %s, record.groupId = %s", new Object[]{str, Hg.field_groupId1});
        }
    }
}

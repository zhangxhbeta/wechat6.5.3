package com.tencent.mm.plugin.webview.modelcache;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.ay;
import com.tencent.mm.e.a.rb;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.d.d;
import com.tencent.mm.v.d.a;
import java.util.Map;

public final class t {
    public final b lfU = new b(this) {
        final /* synthetic */ t lfX;

        {
            this.lfX = r1;
        }

        public final void a(a aVar) {
            bm bmVar = aVar.czu;
            if (bmVar.mbW != null) {
                String a = m.a(bmVar.mbW);
                if (!be.kS(a)) {
                    if (c.biI()) {
                        v.i("MicroMsg.WebViewCacheSubCoreToolsExtension", "get content:\n%s", new Object[]{a});
                        w.cZ("webview_cache_res_pre_shared_preferences", a);
                        Map q = bf.q(a, "sysmsg");
                        if (q != null && q.size() > 0) {
                            String str = (String) q.get(".sysmsg.$type");
                            if (!be.kS(str) && str.equals("webcache")) {
                                a.c(q, ".sysmsg.cache", a);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    v.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
                }
            }
        }
    };
    public final c lfV = new c<rb>(this) {
        final /* synthetic */ t lfX;

        {
            this.lfX = r2;
            this.nhz = rb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            rb rbVar = (rb) bVar;
            if (rbVar != null && (rbVar instanceof rb)) {
                String str = rbVar.bsO.blq;
                if (!be.kS(str)) {
                    if (c.biI()) {
                        v.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "get appMsg node content:\n%s", new Object[]{str});
                        w.cZ("webview_cache_mp_pre_shared_preferences", str);
                        s.dv(12);
                        a.Eg(str);
                    } else {
                        v.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
                    }
                }
            }
            return false;
        }
    };
    public final c lfW = new c<ay>(this) {
        final /* synthetic */ t lfX;

        {
            this.lfX = r2;
            this.nhz = ay.class.getName().hashCode();
        }

        private boolean a(ay ayVar) {
            if (ayVar != null && (ayVar instanceof ay)) {
                if (aa.getContext() != null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    aa.getContext().sendBroadcast(intent);
                }
                FileOp.jJ(e.cgs);
                FileOp.B(e.cgs, false);
                WebViewCacheDownloadHelper.biR();
                t.biM();
            }
            return false;
        }
    };

    public static void biM() {
        com.tencent.mm.model.c yW;
        try {
            yW = ak.yW();
        } catch (Exception e) {
            v.e("MicroMsg.WebViewCacheSubCoreToolsExtension", "setupSFS, getAccStg, exception = %s", new Object[]{e});
            yW = null;
        }
        if (yW != null) {
            FileOp.jS(e.cgs + "sfs");
            FileOp.a(e.cgs, null, new Builder().setDBDirectory(com.tencent.mm.model.c.xp() + "sfs").setStoragePath(e.cgs + "sfs").setName("wvcache"));
        }
    }
}

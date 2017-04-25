package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;

final class c {
    ah cxS = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c liR;

        {
            this.liR = r1;
        }

        public final boolean oU() {
            if (this.liR.liQ.isFinishing()) {
                v.w("MicroMsg.OAuthSession", "onTimerExpired, context is finishing");
            } else {
                c cVar = this.liR;
                Object obj = this.liR.liQ;
                this.liR.liQ.getString(2131231164);
                cVar.gcy = g.a(obj, this.liR.liQ.getString(2131231182), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 liS;

                    {
                        this.liS = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        try {
                            dialogInterface.dismiss();
                        } catch (Exception e) {
                            v.e("MicroMsg.OAuthSession", "onCancel, ex = " + e.getMessage());
                        }
                    }
                });
            }
            return false;
        }
    }, false);
    p gcy;
    d liH;
    boolean liN = false;
    boolean liO = false;
    final a liP;
    OAuthUI liQ;

    public interface a {
        void a(c cVar, String str, boolean z);
    }

    private c(OAuthUI oAuthUI, a aVar, d dVar) {
        this.liQ = oAuthUI;
        this.liP = aVar;
        this.liH = dVar;
    }

    public static c a(OAuthUI oAuthUI, String str, com.tencent.mm.sdk.modelmsg.b.a aVar, a aVar2, d dVar) {
        c cVar = new c(oAuthUI, aVar2, dVar);
        String str2 = aVar.mEw;
        String str3 = aVar.cCl;
        if (cVar.liN) {
            v.e("MicroMsg.OAuthSession", "already getting");
        } else {
            cVar.liO = true;
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_appid", str);
            bundle.putString("geta8key_data_scope", str2);
            bundle.putString("geta8key_data_state", str3);
            try {
                cVar.liH.l(233, bundle);
                cVar.liN = true;
            } catch (Exception e) {
                v.w("MicroMsg.OAuthSession", "startGetA8Key, ex = " + e.getMessage());
            }
            cVar.cxS.ea(3000);
        }
        return cVar;
    }
}

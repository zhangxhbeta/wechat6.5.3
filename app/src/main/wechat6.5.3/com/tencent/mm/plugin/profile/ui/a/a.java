package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a implements e {
    Activity bij;
    p gcy;
    public com.tencent.mm.plugin.profile.a.a hXC;
    public ah hXD = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ a hXE;

        {
            this.hXE = r1;
        }

        public final boolean oU() {
            if (!this.hXE.bij.isFinishing()) {
                a aVar = this.hXE;
                Context context = this.hXE.bij;
                this.hXE.bij.getString(2131231164);
                aVar.gcy = g.a(context, this.hXE.bij.getString(2131231182), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 hXF;

                    {
                        this.hXF = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(this.hXF.hXE.hXC);
                        this.hXF.hXE.gcy = null;
                    }
                });
            }
            return false;
        }
    }, false);

    public a(Activity activity) {
        this.bij = activity;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ak.vy().b(205, this);
        com.tencent.mm.plugin.profile.a.a aVar = (com.tencent.mm.plugin.profile.a.a) kVar;
        if (i == 0 && i2 == 0) {
            xT(aVar.getURL());
            return;
        }
        if (i != 4) {
            v.e("MicroMsg.ViewTWeibo", "view weibo failed: " + i + ", " + i2);
        }
        xT("http://t.qq.com/" + aVar.hTx);
    }

    private void xT(String str) {
        this.hXD.QI();
        if (this.gcy != null) {
            this.gcy.dismiss();
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.putExtra("title", this.bij.getString(2131232207));
        intent.putExtra("zoom", true);
        intent.putExtra("vertical_scroll", false);
        c.b(this.bij, "webview", ".ui.tools.WebViewUI", intent);
    }
}

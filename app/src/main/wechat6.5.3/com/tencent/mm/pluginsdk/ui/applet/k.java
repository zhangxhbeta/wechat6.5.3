package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.a.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;

public final class k implements e {
    Context context;
    p gcy;
    private ah hXD = new ah(new a(this) {
        final /* synthetic */ k lKR;

        {
            this.lKR = r1;
        }

        public final boolean oU() {
            k kVar = this.lKR;
            Context context = this.lKR.context;
            this.lKR.context.getString(2131231164);
            kVar.gcy = g.a(context, this.lKR.context.getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass1 lKS;

                {
                    this.lKS = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(this.lKS.lKR.iCK);
                    this.lKS.lKR.gcy = null;
                }
            });
            return false;
        }
    }, false);
    l iCK;
    private String lKQ;

    public k(Context context) {
        this.context = context;
    }

    public final void HB(String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
            return;
        }
        this.lKQ = str;
        ak.yW();
        String str2 = (String) c.vf().get(46, null);
        ak.yW();
        v.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", str2, be.ma((String) c.vf().get(72, null)));
        if (be.kS(str2) && be.kS(r1)) {
            HC(str);
            return;
        }
        ak.vy().a(233, (e) this);
        this.iCK = new l(o.ba(str));
        ak.vy().a(this.iCK, 0);
        this.hXD.ea(3000);
    }

    private void HC(String str) {
        Intent intent = new Intent();
        String str2 = "rawUrl";
        intent.putExtra(str2, this.context.getString(2131232128, new Object[]{str}));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.ay.c.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        this.hXD.QI();
        if (this.gcy != null) {
            this.gcy.dismiss();
        }
        ak.vy().b(233, (e) this);
        if (i == 0 && i2 == 0) {
            String IT = ((l) kVar).IT();
            if (IT == null || IT.length() == 0) {
                HC(this.lKQ);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", IT);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("neverGetA8Key", true);
            com.tencent.mm.ay.c.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
            return;
        }
        v.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        HC(this.lKQ);
    }
}

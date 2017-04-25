package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class r implements e {
    Context context;
    p gcy;
    ah hXD = new ah(new a(this) {
        final /* synthetic */ r iCL;

        {
            this.iCL = r1;
        }

        public final boolean oU() {
            r rVar = this.iCL;
            Context context = this.iCL.context;
            this.iCL.context.getString(2131231164);
            rVar.gcy = g.a(context, this.iCL.context.getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass1 iCM;

                {
                    this.iCM = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(this.iCM.iCL.iCK);
                    this.iCM.iCL.gcy = null;
                }
            });
            return false;
        }
    }, false);
    l iCK;
    String url;

    public r(Context context) {
        this.context = context;
    }

    final void yX(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        com.tencent.mm.plugin.scanner.a.drp.j(intent, this.context);
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.hXD.QI();
        if (this.gcy != null) {
            this.gcy.dismiss();
        }
        ak.vy().b(233, this);
        if (i == 0 && i2 == 0) {
            String IT = ((l) kVar).IT();
            if (IT == null || IT.length() == 0) {
                yX(this.url);
                return;
            } else {
                yX(IT);
                return;
            }
        }
        v.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        yX(this.url);
    }
}

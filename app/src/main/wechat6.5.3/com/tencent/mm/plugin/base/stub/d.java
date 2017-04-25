package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.j.r;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.v;

public class d {
    protected String appId;
    protected String bfm;
    protected Context context;
    protected a enp;

    public interface a {
        void bV(boolean z);
    }

    public d(Context context, String str, String str2, a aVar) {
        this.context = context;
        this.appId = str;
        this.bfm = str2;
        this.enp = aVar;
    }

    public final void WK() {
        if (this.bfm == null || this.bfm.length() == 0) {
            v.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
            this.enp.bV(true);
            return;
        }
        f aC = g.aC(this.appId, false);
        if (aC == null) {
            v.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
            this.enp.bV(true);
        } else if (t.kS(aC.field_openId)) {
            v.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
            v.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
            am.bnF().Ez(this.appId);
            this.enp.bV(true);
        } else if (this.bfm.equalsIgnoreCase(aC.field_openId)) {
            v.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
            this.enp.bV(true);
        } else {
            v.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.bfm + ", localOpenId = " + aC.field_openId);
            MS();
        }
    }

    protected void MS() {
        com.tencent.mm.ui.base.g.b(this.context, 2131234139, 2131231164, new OnClickListener(this) {
            final /* synthetic */ d enq;

            {
                this.enq = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                r rVar = com.tencent.mm.pluginsdk.j.a.lxN;
                if (rVar != null) {
                    rVar.F(this.enq.bfm, k.xI(), this.enq.appId);
                }
                this.enq.enp.bV(true);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ d enq;

            {
                this.enq = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                r rVar = com.tencent.mm.pluginsdk.j.a.lxN;
                if (rVar != null) {
                    rVar.F(this.enq.bfm, k.xI(), this.enq.appId);
                }
                this.enq.enp.bV(false);
            }
        });
    }
}

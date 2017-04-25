package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.j.r;
import com.tencent.mm.ui.base.g;

public final class a extends d {
    public a(Context context, String str, String str2, com.tencent.mm.plugin.base.stub.d.a aVar) {
        super(context, str, str2, aVar);
    }

    protected final void MS() {
        g.a(this.context, 2131233116, 2131231164, false, new OnClickListener(this) {
            final /* synthetic */ a enl;

            {
                this.enl = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                r rVar = com.tencent.mm.pluginsdk.j.a.lxN;
                if (rVar != null) {
                    rVar.F(this.enl.bfm, k.xI(), this.enl.appId);
                }
                this.enl.enp.bV(false);
            }
        });
    }
}

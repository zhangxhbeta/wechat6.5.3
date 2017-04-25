package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.k;

public final class u implements s {
    k aZJ;
    public p dwg;
    public a lAC;
    public Context mContext;

    public interface a {
        void baK();
    }

    public u(Context context, a aVar) {
        this.mContext = context;
        this.lAC = aVar;
    }

    public final void a(int i, int i2, String str, v vVar) {
        v.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        am.ash().b(7, this);
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
            this.dwg = null;
        }
        if (this.lAC != null) {
            this.lAC.baK();
        }
        g.bno();
    }
}

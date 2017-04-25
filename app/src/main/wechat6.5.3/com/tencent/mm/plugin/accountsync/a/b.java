package com.tencent.mm.plugin.accountsync.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;

public final class b implements e, f {
    public k aZJ;
    public Context context;
    public p dwg;
    public a dwh;
    private ac handler = new ac(Looper.getMainLooper());

    public interface a {
        void Ob();
    }

    public b(Context context, a aVar) {
        this.context = context;
        this.dwh = aVar;
    }

    public final void a(int i, int i2, k kVar) {
        final int i3 = i2 != 0 ? (int) ((((long) i) * 100) / ((long) i2)) : 0;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ b dwi;

            public final void run() {
                if (this.dwi.dwg != null) {
                    this.dwi.dwg.setMessage(this.dwi.context.getString(2131231085) + i3 + "%");
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 139) {
            ak.vy().b(139, (e) this);
        } else if (kVar.getType() == 138) {
            ak.vy().b(138, (e) this);
        }
        if (i2 == 0 && i == 0) {
            this.dwh.Ob();
        } else {
            v.e("MicroMsg.DoInit", "do init failed, err=" + i + "," + i2);
            this.dwh.Ob();
        }
        if (this.dwg != null) {
            this.dwg.dismiss();
        }
    }
}

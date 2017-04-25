package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.mm.e.a.ie;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c implements e {
    private static long igk = 0;
    private Activity bij;
    private a igl;

    public static abstract class a {
        public abstract void aHJ();

        public abstract void aHK();
    }

    static /* synthetic */ void a(c cVar) {
        if (System.currentTimeMillis() - igk > 600000) {
            if (ak.uz()) {
                ak.vy().a(new ay(new com.tencent.mm.model.ay.a(cVar) {
                    final /* synthetic */ c igm;

                    {
                        this.igm = r1;
                    }

                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            eVar.BU().i(new byte[0], eVar.BU().ww());
                            com.tencent.mm.plugin.qqmail.a.a.drq.ow();
                        }
                    }
                }), 0);
            }
        } else if (cVar.igl != null) {
            cVar.igl.aHK();
        }
    }

    public c(Activity activity) {
        ak.vy().a(138, this);
        this.bij = activity;
    }

    public final void a(a aVar) {
        this.igl = aVar;
        final ie ieVar = new ie();
        ieVar.bih.bij = this.bij;
        ieVar.bih.bik = new Runnable(this) {
            final /* synthetic */ c igm;

            public final void run() {
                if (ieVar.bii.aYN) {
                    c.a(this.igm);
                } else if (this.igm.igl != null) {
                    this.igm.igl.aHK();
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.a(ieVar, Looper.myLooper());
    }

    public final void release() {
        ak.vy().b(138, this);
    }

    protected final void finalize() {
        release();
        super.finalize();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (this.igl != null) {
                this.igl.aHJ();
                this.igl = null;
            }
        } else if (this.igl != null) {
            this.igl.aHK();
            this.igl = null;
        }
        igk = System.currentTimeMillis();
    }
}

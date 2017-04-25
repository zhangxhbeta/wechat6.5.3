package com.c.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a extends d implements m {
    private final d[] aHi;
    private final Handler[] aHj = new Handler[this.aHi.length];
    private final a[] aHk = new a[this.aHj.length];

    abstract void a(Handler handler, Handler[] handlerArr);

    abstract void a(a aVar, a[] aVarArr);

    a(d... dVarArr) {
        this.aHi = dVarArr;
    }

    final void N(Context context) {
        for (d a : this.aHi) {
            try {
                a.a(context, this);
            } catch (Exception e) {
            }
        }
    }

    void a(Context context, Handler handler, a aVar) {
        a(handler, this.aHj);
        a(aVar, this.aHk);
        for (int i = 0; i < this.aHi.length; i++) {
            try {
                this.aHi[i].a(this.aHj[i], this.aHk[i]);
            } catch (Exception e) {
            }
        }
    }

    final void O(Context context) {
        for (d stop : this.aHi) {
            stop.stop();
        }
    }

    final void na() {
        for (d nd : this.aHi) {
            nd.nd();
        }
    }
}

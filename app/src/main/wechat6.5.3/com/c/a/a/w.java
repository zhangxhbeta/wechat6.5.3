package com.c.a.a;

import android.content.Context;
import android.os.Handler;

final class w extends n {
    private static w aNe;
    private boolean aNf;
    private int aNg;
    private long aNh;
    private long aNi;

    static w nH() {
        if (aNe == null) {
            aNe = new w();
        }
        return aNe;
    }

    w() {
    }

    final void a(Context context, Handler handler, a aVar) {
        if (this.aNf) {
            if (k.nh().isReady) {
                k.nh().nd();
            }
        } else if (!k.nh().isReady) {
            try {
                k.nh().a(context, this);
            } catch (Exception e) {
            }
        }
        super.a(context, handler, aVar);
    }

    final synchronized void a(Handler handler, a aVar) {
        this.aNf = false;
        super.a(handler, aVar);
    }

    public final void a(p pVar) {
        Object obj;
        long j = pVar.aKl;
        if (!this.aNf || j - this.aNi <= this.aNh) {
            obj = null;
        } else {
            stop();
            obj = 1;
        }
        if (obj == null) {
            super.a(pVar);
        }
    }

    final void a(x xVar, long j, long j2) {
        Object obj;
        if (xVar.aNn == null) {
            xVar.aNn = new a();
        }
        float f = xVar.aNn.aNq;
        if (!this.aNf || f < ((float) this.aNg)) {
            obj = null;
        } else {
            stop();
            obj = 1;
        }
        if (obj == null) {
            super.a(xVar, j, j2);
        }
    }

    final void a(int i, String str, long j, long j2) {
        if (this.aNf) {
            stop();
        }
        super.a(i, str, j, j2);
    }
}

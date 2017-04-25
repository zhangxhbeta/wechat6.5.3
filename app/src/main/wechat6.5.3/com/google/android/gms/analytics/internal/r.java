package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.common.internal.w;

public final class r {
    final Context agT;
    final Context agU;

    public r(Context context) {
        w.Z(context);
        Context applicationContext = context.getApplicationContext();
        w.h(applicationContext, "Application context can't be null");
        this.agT = applicationContext;
        this.agU = applicationContext;
    }

    protected static y a(q qVar) {
        return new y(qVar);
    }

    protected static ac b(q qVar) {
        return new ac(qVar);
    }

    public static t d(q qVar) {
        return new t(qVar);
    }

    public static ag e(q qVar) {
        return new ag(qVar);
    }

    public static i f(q qVar) {
        return new i(qVar);
    }

    final w c(q qVar) {
        return new w(qVar, this);
    }
}

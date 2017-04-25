package com.google.android.gms.analytics.internal;

import android.util.DisplayMetrics;
import com.google.android.gms.c.al;
import java.util.Locale;

public final class af extends o {
    af(q qVar) {
        super(qVar);
    }

    protected final void hm() {
    }

    public final al iO() {
        hX();
        DisplayMetrics displayMetrics = this.afY.ia().mContext.getResources().getDisplayMetrics();
        al alVar = new al();
        alVar.azq = k.c(Locale.getDefault());
        alVar.azs = displayMetrics.widthPixels;
        alVar.azt = displayMetrics.heightPixels;
        return alVar;
    }
}

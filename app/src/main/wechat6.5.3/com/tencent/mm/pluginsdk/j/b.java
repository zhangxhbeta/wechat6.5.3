package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import com.tencent.mm.v.e;
import java.util.HashSet;
import java.util.Set;

public abstract class b implements e {
    public Activity aXH;
    Set<Integer> lCE = new HashSet();

    public abstract boolean b(p pVar);

    public abstract boolean c(p pVar);

    public abstract boolean d(p pVar);

    public abstract boolean e(p pVar);

    public b(Activity activity) {
        this.aXH = activity;
    }

    public final boolean a(p pVar) {
        if (pVar.action == 0) {
            return false;
        }
        switch (pVar.action) {
            case 1:
                return b(pVar);
            case 2:
                return c(pVar);
            case 4:
                return d(pVar);
            case 5:
                return e(pVar);
            default:
                return false;
        }
    }
}

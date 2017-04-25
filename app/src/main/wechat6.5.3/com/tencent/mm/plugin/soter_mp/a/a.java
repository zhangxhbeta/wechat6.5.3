package com.tencent.mm.plugin.soter_mp.a;

import android.app.Activity;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.plugin.soter_mp.b.b;
import com.tencent.mm.plugin.soter_mp.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public final class a {
    public static final int kdQ = 1;
    private static final /* synthetic */ int[] kdR = new int[]{kdQ};

    public static c a(Activity activity, b bVar, c cVar) {
        if ((bVar.keh & 1) != 0 && k.cB(aa.getContext())) {
            return new b(new WeakReference(activity), bVar, cVar);
        }
        v.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", new Object[]{Byte.valueOf(bVar.keh)});
        return null;
    }
}

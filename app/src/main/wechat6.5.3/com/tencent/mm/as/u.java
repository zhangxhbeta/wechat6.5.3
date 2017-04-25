package com.tencent.mm.as;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.e.a.qh;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;

public final class u {
    public static boolean bi(Context context) {
        b qhVar = new qh();
        a.nhr.z(qhVar);
        if (qhVar.bry.brA) {
            Toast.makeText(context, e(context, qhVar.bry.brz), 0).show();
        }
        return qhVar.bry.brA;
    }

    public static boolean bj(Context context) {
        b qhVar = new qh();
        a.nhr.z(qhVar);
        if (qhVar.bry.brB) {
            Toast.makeText(context, e(context, qhVar.bry.brz), 0).show();
        }
        return qhVar.bry.brB;
    }

    private static String e(Context context, boolean z) {
        return z ? context.getString(2131231570) : context.getString(2131231571);
    }
}

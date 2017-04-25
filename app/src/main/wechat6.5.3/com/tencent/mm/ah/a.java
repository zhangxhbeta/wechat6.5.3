package com.tencent.mm.ah;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.e.a.ib;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.ui.base.h;

public final class a {
    public static boolean aT(Context context) {
        if (!Hv()) {
            return false;
        }
        Toast.makeText(context, 2131233934, 0).show();
        return true;
    }

    public static boolean Hv() {
        b ibVar = new ib();
        ibVar.bhW.action = 1;
        com.tencent.mm.sdk.c.a.nhr.z(ibVar);
        return ibVar.bhX.bhY;
    }

    public static boolean Hw() {
        return com.tencent.mm.pluginsdk.j.a.lxG != null && com.tencent.mm.pluginsdk.j.a.lxG.bad();
    }

    public static boolean Hx() {
        return com.tencent.mm.pluginsdk.j.a.lxQ != null && com.tencent.mm.pluginsdk.j.a.lxQ.awy();
    }

    public static h a(Context context, int i, final Runnable runnable) {
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.wm(2131231164);
        aVar.wn(i);
        aVar.wp(2131233930).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        aVar.jk(true);
        aVar.c(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        h RX = aVar.RX();
        RX.show();
        return RX;
    }
}

package com.tencent.mm.ui.snackbar;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.mm.ui.snackbar.b.c;

public final class a {
    private static boolean oPQ = false;

    public static void c(Activity activity, String str, String str2) {
        com.tencent.mm.ui.snackbar.b.a aVar = new com.tencent.mm.ui.snackbar.b.a(activity);
        aVar.mMessage = str;
        aVar.oPS = str2;
        aVar.oQf = 0;
        a(aVar.a(Short.valueOf((short) 2500)), null, null);
    }

    public static void a(int i, Activity activity, String str, String str2, c cVar) {
        com.tencent.mm.ui.snackbar.b.a aVar = new com.tencent.mm.ui.snackbar.b.a(activity);
        aVar.mMessage = str;
        aVar.oPS = str2;
        aVar = aVar.a(Short.valueOf((short) 2500));
        aVar.oQf = i;
        a(aVar, null, cVar);
    }

    public static void a(int i, Fragment fragment, String str, String str2, c cVar) {
        com.tencent.mm.ui.snackbar.b.a aVar = new com.tencent.mm.ui.snackbar.b.a(fragment.getContext(), fragment.mView);
        aVar.mMessage = str;
        aVar.oPS = str2;
        aVar = aVar.a(Short.valueOf((short) 2500));
        aVar.oQf = i;
        a(aVar, null, cVar);
    }

    public static void b(Context context, View view, String str) {
        com.tencent.mm.ui.snackbar.b.a aVar = new com.tencent.mm.ui.snackbar.b.a(context, view);
        aVar.mMessage = str;
        aVar.a(Short.valueOf((short) 1500)).bIP();
    }

    public static void f(Activity activity, String str) {
        com.tencent.mm.ui.snackbar.b.a aVar = new com.tencent.mm.ui.snackbar.b.a(activity);
        aVar.mMessage = str;
        a(aVar.a(Short.valueOf((short) 1500)), null, null);
    }

    private static void a(com.tencent.mm.ui.snackbar.b.a aVar, b bVar, c cVar) {
        aVar.oQe.oPY = new b() {
            public final void bkH() {
                com.tencent.mm.sdk.c.b ezVar = new ez();
                ezVar.bdQ.type = 35;
                com.tencent.mm.sdk.c.a.nhr.z(ezVar);
            }
        };
        if (cVar != null) {
            aVar.oQe.oPZ = cVar;
        }
        aVar.bIP();
    }

    public static boolean aQa() {
        return oPQ;
    }

    public static void kc(boolean z) {
        oPQ = z;
    }

    public static void a(final Context context, final OnClickListener onClickListener) {
        g.a(context, context.getString(2131232655), context.getString(2131232656), context.getString(2131232658), context.getString(2131231975), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.ay.c.b(context, "favorite", ".ui.FavCleanUI", new Intent());
                dialogInterface.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, -2);
                }
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, -1);
                }
            }
        }, 2131690123);
    }
}

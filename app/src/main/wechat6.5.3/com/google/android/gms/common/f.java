package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.g;
import android.support.v4.app.k;
import com.google.android.gms.common.internal.w;

public final class f extends g {
    private OnCancelListener akp = null;
    private Dialog oy = null;

    public static f b(Dialog dialog, OnCancelListener onCancelListener) {
        f fVar = new f();
        Dialog dialog2 = (Dialog) w.h(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        fVar.oy = dialog2;
        if (onCancelListener != null) {
            fVar.akp = onCancelListener;
        }
        return fVar;
    }

    public final void a(k kVar, String str) {
        super.a(kVar, str);
    }

    public final Dialog aF() {
        if (this.oy == null) {
            this.ow = false;
        }
        return this.oy;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.akp != null) {
            this.akp.onCancel(dialogInterface);
        }
    }
}

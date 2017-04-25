package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.mm.bd.a;
import junit.framework.Assert;

public final class r {
    private static r oVf = null;
    private boolean oVg = false;
    private ColorStateList[] ohl = new ColorStateList[2];

    private r(Context context) {
        this.ohl[0] = a.M(context, 2131690165);
        this.ohl[1] = a.M(context, 2131690166);
    }

    private static r eK(Context context) {
        Assert.assertTrue(context != null);
        if (oVf == null || !oVf.oVg) {
            oVf = new r(context);
        }
        return oVf;
    }

    public static ColorStateList eL(Context context) {
        return eK(context).ohl[0];
    }

    public static ColorStateList eM(Context context) {
        return eK(context).ohl[1];
    }
}

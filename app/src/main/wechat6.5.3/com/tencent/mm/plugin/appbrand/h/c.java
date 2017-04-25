package com.tencent.mm.plugin.appbrand.h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ui.a;

public enum c {
    ;

    public static boolean a(AppBrandSysConfig appBrandSysConfig, Context context) {
        if (appBrandSysConfig == null || context == null) {
            return true;
        }
        if ((appBrandSysConfig.PA() & 64) <= 0) {
            return false;
        }
        a aVar = new a(context);
        aVar.Oq(context.getString(2131230929));
        aVar.jk(false);
        aVar.wp(2131230918).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        aVar.RX().show();
        return true;
    }
}

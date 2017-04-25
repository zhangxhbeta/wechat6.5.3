package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.plugin.e.a;
import com.tencent.mm.plugin.e.c;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.plugin.location_soso.SoSoProxyUI;
import com.tencent.mm.sdk.platformtools.v;

public final class d implements c {
    public static Intent w(Activity activity) {
        return new Intent(activity, SoSoProxyUI.class);
    }

    public static View ce(Context context) {
        SoSoMapView soSoMapView = new SoSoMapView(context);
        soSoMapView.setId(2131755380);
        return soSoMapView;
    }

    public final a e(Activity activity, int i) {
        switch (i) {
            case 2:
                return new c(activity);
            case 4:
                return new h(activity);
            case 5:
                v.i("MicroMsg.MapFactoryImp", "share map");
                return new g(activity);
            default:
                return null;
        }
    }
}

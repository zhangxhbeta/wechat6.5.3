package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.widget.MMSimpleRoundCornerImageView;
import com.tencent.mm.t.a.b;
import com.tencent.mm.t.a.c;

public final class a extends LinearLayout {
    private MMSimpleRoundCornerImageView dMP = ((MMSimpleRoundCornerImageView) findViewById(2131755348));
    private TextView dMQ = ((TextView) findViewById(2131755359));
    private Button dMR = ((Button) findViewById(2131755360));
    private String dzg;

    public a(Context context, String str) {
        super(context);
        this.dzg = str;
        inflate(getContext(), 2130903100, this);
        AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(this.dzg);
        this.dMQ.setText(getResources().getString(2131230939, new Object[]{mr.aZU}));
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.dMP.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        b.AL().a(this.dMP, mr.dDo, com.tencent.mm.t.a.a.AK(), c.cxH);
        this.dMR.setVisibility(8);
        setBackgroundColor(-1);
        com.tencent.mm.plugin.appbrand.report.a.S(this.dzg, 27);
    }
}

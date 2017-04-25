package com.tencent.mapsdk.rastercore.e.a;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

final class b extends LinearLayout {
    public TextView a;
    public TextView b;

    public b(Context context, String str, String str2) {
        super(context);
        setOrientation(1);
        this.a = new TextView(context);
        this.a.setText(str);
        this.a.setTextColor(-16777216);
        addView(this.a);
        this.b = new TextView(context);
        this.b.setTextColor(-16777216);
        this.b.setText(str2);
        addView(this.b);
        try {
            setBackgroundDrawable(d.a(context, "infowindow_bg.9.png"));
        } catch (Exception e) {
        }
    }
}

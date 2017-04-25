package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NetStatGroup extends LinearLayout {
    LinearLayout iJH;
    final TextView ilO;

    public NetStatGroup(Context context) {
        this(context, null);
    }

    public NetStatGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, 2130904121, this);
        this.iJH = (LinearLayout) findViewById(2131758248);
        this.ilO = (TextView) findViewById(2131755150);
        this.ilO.setTextSize(0, (float) context.getResources().getDimensionPixelSize(2131493128));
    }
}

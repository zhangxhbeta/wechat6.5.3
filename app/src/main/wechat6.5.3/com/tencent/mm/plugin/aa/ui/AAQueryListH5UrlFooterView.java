package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.q;

public class AAQueryListH5UrlFooterView extends LinearLayout {
    TextView dtG;

    public AAQueryListH5UrlFooterView(Context context) {
        super(context);
        init(context);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.dtG = (TextView) q.em(context).inflate(2130903043, this, true).findViewById(2131755205);
    }
}

package com.tencent.mm.plugin.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.gesture.ui.widget.PatternLockView;

final class a {
    TextView gBA = null;
    TextView gBx = null;
    FrameLayout gBy = null;
    PatternLockView gBz = null;
    View mView = null;

    public a(Activity activity) {
        this.mView = View.inflate(activity, 2130903803, null);
        this.gBx = (TextView) this.mView.findViewById(2131757496);
        this.gBy = (FrameLayout) this.mView.findViewById(2131757498);
        this.gBz = (PatternLockView) this.mView.findViewById(2131757499);
        this.gBA = (TextView) this.mView.findViewById(2131757497);
    }
}

package com.tencent.mm.ui.friend;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.IconPreference;

public final class FriendSnsPreference extends IconPreference {
    private Context context;
    public Bitmap fgy;
    public String oNV;

    public FriendSnsPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FriendSnsPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oNV = null;
        this.fgy = null;
        this.context = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.oNV != null) {
            b.m(this.fgD, this.oNV);
        }
    }
}

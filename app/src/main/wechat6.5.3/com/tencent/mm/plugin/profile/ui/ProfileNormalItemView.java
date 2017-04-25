package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ProfileItemView;
import com.tencent.mm.sdk.platformtools.be;

public class ProfileNormalItemView extends ProfileItemView {
    private TextView eXB;
    TextView hRE;
    CharSequence hXs;
    OnClickListener hXt;
    private String mTitle;

    public ProfileNormalItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPy);
        this.mTitle = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
    }

    public ProfileNormalItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int aGY() {
        return 2130904200;
    }

    public final void init() {
        this.eXB = (TextView) findViewById(2131758666);
        this.hRE = (TextView) findViewById(2131758667);
    }

    public final ProfileNormalItemView oq(int i) {
        this.hXs = getContext().getString(i);
        return this;
    }

    public final ProfileNormalItemView or(int i) {
        this.hRE.setTextColor(i);
        return this;
    }

    public final boolean aGZ() {
        this.eXB.setText(this.mTitle);
        if (be.D(this.hXs)) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        this.hRE.setText(this.hXs);
        setOnClickListener(this.hXt);
        return true;
    }
}

package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class PreferenceInfoCategory extends Preference {
    public OnClickListener lPi;
    public int nEN;
    public OnClickListener odK;

    public PreferenceInfoCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceInfoCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lPi = null;
        this.odK = null;
        this.nEN = 0;
        setLayoutResource(2130904050);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            if (getTitle() == null || getTitle().length() <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(getTitle());
                textView.setOnClickListener(this.odK);
            }
            ImageView imageView = (ImageView) view.findViewById(2131758282);
            imageView.setOnClickListener(this.lPi);
            if (this.nEN > 0) {
                imageView.setImageResource(this.nEN);
                imageView.setVisibility(0);
                return;
            }
            imageView.setVisibility(8);
        }
    }
}

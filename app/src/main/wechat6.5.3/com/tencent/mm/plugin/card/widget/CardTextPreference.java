package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

public class CardTextPreference extends Preference {
    private TextView adN;
    private TextView eNA;
    public int eNB = 0;
    boolean eNC = true;
    Context mContext;

    public CardTextPreference(Context context) {
        super(context, null);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(2130903996);
        this.mContext = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.eNA = (TextView) view.findViewById(16908304);
        this.adN = (TextView) view.findViewById(16908310);
        acL();
        cl(this.eNC);
    }

    public final void acL() {
        if (this.eNA != null && this.eNB != 0) {
            this.eNA.setTextColor(this.eNB);
        }
    }

    public final void acM() {
        cl(false);
        this.eNC = false;
    }

    private void cl(boolean z) {
        if (this.adN != null) {
            View view = this.adN;
            Rect rect = new Rect();
            rect.left = view.getPaddingLeft();
            rect.right = view.getPaddingRight();
            rect.top = view.getPaddingTop();
            rect.bottom = view.getPaddingBottom();
            this.adN.setSingleLine(z);
            if (!z) {
                rect.top = this.mContext.getResources().getDimensionPixelOffset(2131493135);
                rect.bottom = this.mContext.getResources().getDimensionPixelOffset(2131493135);
                view = this.adN;
                if (view != null) {
                    view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                }
            }
        }
    }
}

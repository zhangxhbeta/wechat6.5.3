package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LuckyTimelineTip extends LinearLayout {
    private TextView jim;
    private View jin;

    public LuckyTimelineTip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LuckyTimelineTip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = View.inflate(getContext(), 2130903911, this);
        inflate.findViewById(2131757971).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyTimelineTip jio;

            {
                this.jio = r1;
            }

            public final void onClick(View view) {
            }
        });
        this.jim = (TextView) inflate.findViewById(2131757972);
        this.jin = inflate.findViewById(2131757973);
    }
}

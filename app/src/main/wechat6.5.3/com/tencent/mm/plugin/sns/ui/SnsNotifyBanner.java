package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SnsNotifyBanner extends RelativeLayout {
    private LayoutInflater CE;
    private View Hq;
    private TextView jRg;
    private ImageView jRh;
    int jRi = 0;

    public SnsNotifyBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SnsNotifyBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.CE = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.Hq = this.CE.inflate(2130904481, this, true);
        this.jRg = (TextView) this.Hq.findViewById(2131759429);
        this.jRh = (ImageView) this.Hq.findViewById(2131759430);
        this.jRh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsNotifyBanner jRj;

            {
                this.jRj = r1;
            }

            public final void onClick(View view) {
                this.jRj.setVisibility(8);
            }
        });
    }
}

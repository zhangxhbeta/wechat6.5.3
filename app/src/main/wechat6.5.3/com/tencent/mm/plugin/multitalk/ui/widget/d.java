package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.bd.a;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class d implements OnClickListener {
    private Context context;
    private int hAW = b.hAW;
    private int hBc = b.hBc;
    private View hBo;
    private LinearLayout hBp;
    public LinearLayout hBq;
    public LinearLayout hBr;
    private int hBs;
    private int hBt;
    private int hBu = (b.hAW + b.hAV);
    private int hBv = ((b.hAW * 2) + b.hAV);
    private int hBw = (b.hAW * 4);
    public int hBx;
    public int size = 0;

    public d(Activity activity) {
        this.context = activity.getBaseContext();
        int dv = a.dv(this.context) - (this.hBw * 2);
        this.hBs = (dv - (this.hBu * 10)) / 5;
        this.hBt = (dv - (this.hBv * 10)) / 5;
        dv = (this.hBt * 2) + (this.hAW * 12);
        this.hBo = activity.findViewById(2131755206);
        this.hBo.getLayoutParams().height = dv;
        this.hBp = (LinearLayout) activity.findViewById(2131758367);
        LayoutParams layoutParams = (LayoutParams) this.hBp.getLayoutParams();
        layoutParams.topMargin = this.hAW * 2;
        layoutParams.bottomMargin = this.hAW * 2;
        layoutParams.leftMargin = this.hBw;
        layoutParams.rightMargin = this.hBw;
        this.hBp.setLayoutParams(layoutParams);
        this.hBq = new LinearLayout(this.context);
        this.hBr = new LinearLayout(this.context);
        this.hBq.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        this.hBr.setLayoutParams(layoutParams2);
        layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        View relativeLayout = new RelativeLayout(this.context);
        relativeLayout.addView(this.hBr);
        relativeLayout.setLayoutParams(layoutParams2);
        this.hBp.addView(this.hBq);
        this.hBp.addView(relativeLayout);
    }

    public final void setVisible(boolean z) {
        if (z) {
            this.hBo.setVisibility(0);
        } else {
            this.hBo.setVisibility(8);
        }
    }

    public final void wV(String str) {
        this.size++;
        View imageView = new ImageView(this.context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setTag(str);
        imageView.setOnClickListener(this);
        b.a(imageView, str, 0.1f, false);
        if (this.size <= 5) {
            this.hBq.addView(imageView);
        } else {
            this.hBr.addView(imageView);
        }
        nr(this.size);
        ns(this.size);
    }

    public final void nr(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hBq.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.hBr.getLayoutParams();
        if (i <= 5) {
            layoutParams.height = this.hBs;
            this.hBr.setVisibility(8);
            return;
        }
        layoutParams.height = this.hBt;
        layoutParams.topMargin = this.hAW * 2;
        layoutParams.bottomMargin = this.hAW * 2;
        this.hBr.setVisibility(0);
        layoutParams2.height = this.hBt;
        layoutParams2.topMargin = this.hAW * 2;
        layoutParams2.bottomMargin = this.hAW * 2;
    }

    public final void ns(int i) {
        int i2 = 0;
        int i3;
        LinearLayout.LayoutParams layoutParams;
        if (i <= 5) {
            for (i3 = 0; i3 < this.hBq.getChildCount(); i3++) {
                layoutParams = (LinearLayout.LayoutParams) this.hBq.getChildAt(i3).getLayoutParams();
                layoutParams.width = this.hBs;
                layoutParams.height = this.hBs;
                layoutParams.rightMargin = this.hBu;
                layoutParams.leftMargin = this.hBu;
            }
            while (i2 < this.hBr.getChildCount()) {
                layoutParams = (LinearLayout.LayoutParams) this.hBr.getChildAt(i2).getLayoutParams();
                layoutParams.width = this.hBt;
                layoutParams.height = this.hBt;
                layoutParams.rightMargin = this.hBu;
                layoutParams.leftMargin = this.hBu;
                i2++;
            }
            return;
        }
        for (i3 = 0; i3 < this.hBq.getChildCount(); i3++) {
            layoutParams = (LinearLayout.LayoutParams) this.hBq.getChildAt(i3).getLayoutParams();
            layoutParams.width = this.hBt;
            layoutParams.height = this.hBt;
            layoutParams.rightMargin = this.hBv;
            layoutParams.leftMargin = this.hBv;
        }
        while (i2 < this.hBr.getChildCount()) {
            layoutParams = (LinearLayout.LayoutParams) this.hBr.getChildAt(i2).getLayoutParams();
            layoutParams.width = this.hBt;
            layoutParams.height = this.hBt;
            layoutParams.rightMargin = this.hBv;
            layoutParams.leftMargin = this.hBv;
            i2++;
        }
    }

    public final void onClick(View view) {
        this.hBx++;
    }
}

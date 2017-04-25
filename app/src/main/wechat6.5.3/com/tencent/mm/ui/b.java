package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public final class b {
    public TextView dtY;
    private View nzn;
    private ImageView nzo;
    public TextView nzp;
    private ImageView nzq;
    public ImageView nzr;
    private ImageView nzs;
    public ImageView nzt;
    private View nzu;

    public b(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -1);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
        this.dtY = (TextView) view.findViewById(2131755270);
        this.nzp = (TextView) view.findViewById(2131755271);
        this.nzq = (ImageView) view.findViewById(2131755272);
        this.nzr = (ImageView) view.findViewById(2131755273);
        this.nzs = (ImageView) view.findViewById(2131755274);
        this.nzn = view.findViewById(2131755268);
        this.nzo = (ImageView) view.findViewById(2131755269);
        this.nzt = (ImageView) view.findViewById(2131755275);
        this.nzu = view;
    }

    public final void setTitle(CharSequence charSequence) {
        this.dtY.setText(charSequence);
    }

    public final void iE(boolean z) {
        this.nzq.setVisibility(z ? 0 : 8);
    }

    public final void iF(boolean z) {
        this.nzs.setVisibility(z ? 0 : 8);
    }

    public final void i(OnClickListener onClickListener) {
        this.nzn.setOnClickListener(onClickListener);
    }
}

package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

public class NearLifeErrorContent extends FrameLayout {
    private View dtW;
    ListView dyx;
    private TextView hHF;
    private View hHG;
    private Context mContext;

    public NearLifeErrorContent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public NearLifeErrorContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        this.dtW = View.inflate(this.mContext, 2130904110, this);
        this.hHF = (TextView) this.dtW.findViewById(2131758397);
        this.hHG = this.dtW.findViewById(2131758398);
    }

    public final void nD(int i) {
        switch (i) {
            case 0:
                this.hHF.setVisibility(8);
                this.hHG.setVisibility(8);
                this.dyx.setVisibility(0);
                return;
            case 1:
                this.hHF.setVisibility(0);
                this.hHG.setVisibility(8);
                this.dyx.setVisibility(8);
                return;
            case 2:
                this.hHF.setVisibility(8);
                this.hHG.setVisibility(0);
                this.dyx.setVisibility(8);
                return;
            default:
                return;
        }
    }
}

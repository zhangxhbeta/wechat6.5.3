package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MMCollapsibleTextView extends LinearLayout {
    private Context context;
    private TextView dyL;
    private Runnable fNf = new Runnable(this) {
        final /* synthetic */ MMCollapsibleTextView nUJ;

        {
            this.nUJ = r1;
        }

        public final void run() {
            this.nUJ.dyL.setMaxLines(10);
            this.nUJ.jEN.setVisibility(0);
            this.nUJ.jEN.setText(this.nUJ.jEP);
        }
    };
    private TextView jEN;
    private boolean jEO = true;
    private String jEP;
    private String jEQ;
    private int jdV;
    private SparseIntArray nUI = new SparseIntArray();

    static /* synthetic */ void c(MMCollapsibleTextView mMCollapsibleTextView) {
        mMCollapsibleTextView.jEO = true;
        switch (mMCollapsibleTextView.nUI.get(mMCollapsibleTextView.jdV, -1)) {
            case 0:
                mMCollapsibleTextView.jEN.setVisibility(8);
                return;
            case 1:
                mMCollapsibleTextView.dyL.setMaxLines(10);
                mMCollapsibleTextView.jEN.setVisibility(0);
                mMCollapsibleTextView.jEN.setText(mMCollapsibleTextView.jEP);
                return;
            case 2:
                mMCollapsibleTextView.dyL.setMaxLines(Integer.MAX_VALUE);
                mMCollapsibleTextView.jEN.setVisibility(0);
                mMCollapsibleTextView.jEN.setText(mMCollapsibleTextView.jEQ);
                return;
            default:
                mMCollapsibleTextView.jEO = false;
                mMCollapsibleTextView.jEN.setVisibility(8);
                mMCollapsibleTextView.dyL.setMaxLines(11);
                return;
        }
    }

    public MMCollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.jEP = this.context.getString(2131235588);
        this.jEQ = this.context.getString(2131235330);
        View inflate = inflate(this.context, 2130903982, this);
        inflate.setPadding(0, -3, 0, 0);
        this.dyL = (TextView) inflate.findViewById(2131755458);
        this.jEN = (TextView) inflate.findViewById(2131756359);
        this.jEN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MMCollapsibleTextView nUJ;

            {
                this.nUJ = r1;
            }

            public final void onClick(View view) {
                switch (this.nUJ.nUI.get(this.nUJ.jdV, -1)) {
                    case 1:
                        this.nUJ.nUI.put(this.nUJ.jdV, 2);
                        break;
                    case 2:
                        this.nUJ.nUI.put(this.nUJ.jdV, 1);
                        break;
                    default:
                        return;
                }
                MMCollapsibleTextView.c(this.nUJ);
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.jEO) {
            this.jEO = true;
            if (this.dyL.getLineCount() <= 10) {
                this.nUI.put(this.jdV, 0);
                return;
            }
            this.nUI.put(this.jdV, 1);
            post(this.fNf);
        }
    }
}

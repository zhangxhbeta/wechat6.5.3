package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MallProductSelectAmountView extends LinearLayout {
    TextView dtD = null;
    a hSA = null;
    private ImageView hSu = null;
    private ImageView hSv = null;
    int hSw = Integer.MAX_VALUE;
    int hSx = 1;
    private int hSy = 1;
    int hSz = this.hSy;

    public interface a {
        void cf(int i, int i2);

        void dV(int i);
    }

    public MallProductSelectAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130904187, this, true);
        this.dtD = (TextView) inflate.findViewById(2131758614);
        this.hSu = (ImageView) inflate.findViewById(2131758615);
        this.hSv = (ImageView) inflate.findViewById(2131758613);
        this.dtD.setText(this.hSz);
        this.hSu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSelectAmountView hSB;

            {
                this.hSB = r1;
            }

            public final void onClick(View view) {
                if (this.hSB.hSz + 1 <= this.hSB.hSw) {
                    this.hSB.hSz = this.hSB.hSz + 1;
                    if (this.hSB.aGy()) {
                        this.hSB.dtD.setText(this.hSB.hSz);
                    }
                    if (this.hSB.hSA != null) {
                        this.hSB.hSA.dV(this.hSB.hSz);
                    }
                } else if (this.hSB.hSA != null) {
                    this.hSB.hSA.cf(this.hSB.hSz, this.hSB.hSx);
                }
            }
        });
        this.hSv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSelectAmountView hSB;

            {
                this.hSB = r1;
            }

            public final void onClick(View view) {
                if (this.hSB.hSz - 1 >= this.hSB.hSy) {
                    this.hSB.hSz = this.hSB.hSz - 1;
                    if (this.hSB.aGy()) {
                        this.hSB.dtD.setText(this.hSB.hSz);
                    }
                    this.hSB.aGy();
                    if (this.hSB.hSA != null) {
                        this.hSB.hSA.dV(this.hSB.hSz);
                    }
                } else if (this.hSB.hSA != null) {
                    this.hSB.hSA.cf(this.hSB.hSz, 2);
                }
            }
        });
    }

    final boolean aGy() {
        if (this.hSz > this.hSw) {
            this.hSz = this.hSw;
            if (this.hSA != null) {
                this.hSA.dV(this.hSz);
            }
            if (this.hSA != null) {
                this.hSA.cf(this.hSz, this.hSx);
            }
            this.dtD.setText(this.hSz);
            return false;
        }
        if (this.hSz > this.hSy) {
            this.hSv.setEnabled(true);
        } else if (this.hSz == this.hSy) {
            this.hSv.setEnabled(false);
        } else {
            this.hSv.setEnabled(false);
            this.hSz = this.hSy;
            if (this.hSA != null) {
                this.hSA.dV(this.hSz);
            }
            if (this.hSA != null) {
                this.hSA.cf(this.hSz, 2);
            }
            this.dtD.setText(this.hSz);
            return false;
        }
        return true;
    }
}

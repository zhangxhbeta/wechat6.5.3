package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.v;

public class MMKeyBoardView extends LinearLayout implements OnClickListener, OnLongClickListener {
    private ColorStateList eb;
    private float gzZ;
    private Button hYQ;
    private Button hYR;
    private Button hYS;
    private Button hYT;
    private Button hYU;
    private Button hYV;
    private Button hYW;
    private Button hYX;
    private Button hYY;
    private Button hYZ;
    public a hYy;
    private ImageButton hZa;
    private View hZb;
    private View hZc;
    private View hZd;
    private View hZe;
    private View hZf;
    private View hZg;
    private boolean hZh;
    private int hZi;
    private int hZj;
    private int hZk;
    private int hZl;
    private int hZm;
    private int hZn;
    private int hZo;
    private int hZp;
    private int hZq;
    private Context mContext;

    public interface a {
        void Kz();

        void delete();

        void input(String str);
    }

    public MMKeyBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMKeyBoardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.hZh = true;
        this.mContext = context;
        this.hZi = getResources().getDimensionPixelSize(2131492890);
        this.hZj = getResources().getDimensionPixelSize(2131492891);
        this.gzZ = (float) getResources().getDimensionPixelSize(2131492892);
        this.eb = getResources().getColorStateList(2131690151);
        this.hZk = getResources().getColor(2131689810);
        this.hYQ = new Button(this.mContext);
        this.hYR = new Button(this.mContext);
        this.hYS = new Button(this.mContext);
        this.hYT = new Button(this.mContext);
        this.hYU = new Button(this.mContext);
        this.hYV = new Button(this.mContext);
        this.hYW = new Button(this.mContext);
        this.hYX = new Button(this.mContext);
        this.hYY = new Button(this.mContext);
        this.hYZ = new Button(this.mContext);
        this.hZa = new ImageButton(this.mContext);
        this.hZb = new View(this.mContext);
        this.hZb = new View(this.mContext);
        this.hZc = new View(this.mContext);
        this.hZd = new View(this.mContext);
        this.hZe = new View(this.mContext);
        this.hZf = new View(this.mContext);
        this.hZg = new View(this.mContext);
        this.hYQ.setBackgroundResource(2130838444);
        this.hYR.setBackgroundResource(2130838444);
        this.hYS.setBackgroundResource(2130838444);
        this.hYT.setBackgroundResource(2130838444);
        this.hYU.setBackgroundResource(2130838444);
        this.hYV.setBackgroundResource(2130838444);
        this.hYW.setBackgroundResource(2130838444);
        this.hYX.setBackgroundResource(2130838444);
        this.hYY.setBackgroundResource(2130838444);
        this.hYV.setBackgroundResource(2130838444);
        this.hYZ.setBackgroundResource(2130838444);
        this.hZa.setBackgroundResource(2130838444);
        this.hZa.setImageResource(2130838445);
        this.hYQ.setText("0");
        this.hYR.setText("1");
        this.hYS.setText("2");
        this.hYT.setText("3");
        this.hYU.setText("4");
        this.hYV.setText("5");
        this.hYW.setText("6");
        this.hYX.setText("7");
        this.hYY.setText("8");
        this.hYZ.setText("9");
        this.hYQ.setGravity(17);
        this.hYR.setGravity(17);
        this.hYS.setGravity(17);
        this.hYT.setGravity(17);
        this.hYU.setGravity(17);
        this.hYV.setGravity(17);
        this.hYW.setGravity(17);
        this.hYX.setGravity(17);
        this.hYY.setGravity(17);
        this.hYZ.setGravity(17);
        this.hYQ.setTextSize(0, this.gzZ);
        this.hYR.setTextSize(0, this.gzZ);
        this.hYS.setTextSize(0, this.gzZ);
        this.hYT.setTextSize(0, this.gzZ);
        this.hYU.setTextSize(0, this.gzZ);
        this.hYV.setTextSize(0, this.gzZ);
        this.hYW.setTextSize(0, this.gzZ);
        this.hYX.setTextSize(0, this.gzZ);
        this.hYY.setTextSize(0, this.gzZ);
        this.hYZ.setTextSize(0, this.gzZ);
        this.hYQ.setTextColor(this.eb);
        this.hYR.setTextColor(this.eb);
        this.hYS.setTextColor(this.eb);
        this.hYT.setTextColor(this.eb);
        this.hYU.setTextColor(this.eb);
        this.hYV.setTextColor(this.eb);
        this.hYW.setTextColor(this.eb);
        this.hYX.setTextColor(this.eb);
        this.hYY.setTextColor(this.eb);
        this.hYZ.setTextColor(this.eb);
        this.hYQ.setOnClickListener(this);
        this.hYR.setOnClickListener(this);
        this.hYS.setOnClickListener(this);
        this.hYT.setOnClickListener(this);
        this.hYU.setOnClickListener(this);
        this.hYV.setOnClickListener(this);
        this.hYW.setOnClickListener(this);
        this.hYX.setOnClickListener(this);
        this.hYY.setOnClickListener(this);
        this.hYZ.setOnClickListener(this);
        this.hZa.setOnClickListener(this);
        this.hZa.setOnLongClickListener(this);
        this.hZb.setBackgroundColor(this.hZk);
        this.hZb.setBackgroundColor(this.hZk);
        this.hZc.setBackgroundColor(this.hZk);
        this.hZd.setBackgroundColor(this.hZk);
        this.hZe.setBackgroundColor(this.hZk);
        this.hZf.setBackgroundColor(this.hZk);
        this.hZg.setBackgroundColor(this.hZk);
        addView(this.hYQ);
        addView(this.hYR);
        addView(this.hYS);
        addView(this.hYT);
        addView(this.hYU);
        addView(this.hYV);
        addView(this.hYW);
        addView(this.hYX);
        addView(this.hYY);
        addView(this.hYZ);
        addView(this.hZa);
        addView(this.hZb);
        addView(this.hZc);
        addView(this.hZd);
        addView(this.hZe);
        addView(this.hZf);
        addView(this.hZg);
        post(new Runnable(this) {
            final /* synthetic */ MMKeyBoardView hZr;

            {
                this.hZr = r1;
            }

            public final void run() {
                this.hZr.requestLayout();
            }
        });
    }

    protected void onDraw(Canvas canvas) {
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.hZl = getWidth();
        this.hZm = getHeight();
        int i5 = -this.hZj;
        int i6 = (this.hZp - this.hZj) + 1;
        int i7 = ((this.hZp * 2) - this.hZj) + 2;
        int i8 = this.hZq + 2;
        int i9 = (this.hZq * 2) + 3;
        int i10 = (this.hZq * 3) + 4;
        this.hYR.layout(i5, 1, this.hZn + i5, this.hZo + 1);
        this.hYS.layout(i6, 1, this.hZn + i6, this.hZo + 1);
        this.hYT.layout(i7, 1, this.hZn + i7, this.hZo + 1);
        this.hYU.layout(i5, i8, this.hZn + i5, this.hZo + i8);
        this.hYV.layout(i6, i8, this.hZn + i6, this.hZo + i8);
        this.hYW.layout(i7, i8, this.hZn + i7, this.hZo + i8);
        this.hYX.layout(i5, i9, this.hZn + i5, this.hZo + i9);
        this.hYY.layout(i6, i9, this.hZn + i6, this.hZo + i9);
        this.hYZ.layout(i7, i9, this.hZn + i7, this.hZo + i9);
        this.hYQ.layout(i6, i10, this.hZn + i6, this.hZo + i10);
        this.hZa.layout(i7, i10, this.hZn + i7, this.hZo + i10);
        this.hZb.layout(0, this.hZi + 1, this.hZl, (this.hZi + 1) + 1);
        this.hZc.layout(0, this.hZi + i8, this.hZl, (i8 + this.hZi) + 1);
        this.hZd.layout(0, this.hZi + i9, this.hZl, (i9 + this.hZi) + 1);
        this.hZe.layout(0, this.hZi + i10, this.hZl, (this.hZi + i10) + 1);
        this.hZf.layout(this.hZp + 1, this.hZi, this.hZp + 2, this.hZm);
        this.hZg.layout((this.hZp * 2) + 2, this.hZi, (this.hZp * 2) + 3, this.hZm);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.hZl = getWidth();
        this.hZm = getHeight();
        if (!(this.hZl == 0 || this.hZm == 0)) {
            this.hZp = (this.hZl - 2) / 3;
            this.hZq = ((this.hZm - this.hZi) - 4) / 4;
            this.hZn = this.hZp + (this.hZj * 2);
            this.hZo = this.hZq + (this.hZi * 2);
        }
        this.hYR.measure(MeasureSpec.makeMeasureSpec(this.hZn, 1073741824), MeasureSpec.makeMeasureSpec(this.hZo, 1073741824));
        this.hYS.measure(MeasureSpec.makeMeasureSpec(this.hZn, 1073741824), MeasureSpec.makeMeasureSpec(this.hZo, 1073741824));
        this.hYT.measure(MeasureSpec.makeMeasureSpec(this.hZn, 1073741824), MeasureSpec.makeMeasureSpec(this.hZo, 1073741824));
        this.hYU.measure(MeasureSpec.makeMeasureSpec(this.hZn, 1073741824), MeasureSpec.makeMeasureSpec(this.hZo, 1073741824));
        this.hYV.measure(MeasureSpec.makeMeasureSpec(this.hZn, 1073741824), MeasureSpec.makeMeasureSpec(this.hZo, 1073741824));
        this.hYW.measure(MeasureSpec.makeMeasureSpec(this.hZn, 1073741824), MeasureSpec.makeMeasureSpec(this.hZo, 1073741824));
        this.hYX.measure(MeasureSpec.makeMeasureSpec(this.hZn, 1073741824), MeasureSpec.makeMeasureSpec(this.hZo, 1073741824));
        this.hYY.measure(MeasureSpec.makeMeasureSpec(this.hZn, 1073741824), MeasureSpec.makeMeasureSpec(this.hZo, 1073741824));
        this.hYZ.measure(MeasureSpec.makeMeasureSpec(this.hZn, 1073741824), MeasureSpec.makeMeasureSpec(this.hZo, 1073741824));
        this.hYQ.measure(MeasureSpec.makeMeasureSpec(this.hZn, 1073741824), MeasureSpec.makeMeasureSpec(this.hZo, 1073741824));
        this.hZa.measure(MeasureSpec.makeMeasureSpec(this.hZn, 1073741824), MeasureSpec.makeMeasureSpec(this.hZo, 1073741824));
        this.hZb.measure(MeasureSpec.makeMeasureSpec(this.hZl, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.hZc.measure(MeasureSpec.makeMeasureSpec(this.hZl, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.hZd.measure(MeasureSpec.makeMeasureSpec(this.hZl, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.hZe.measure(MeasureSpec.makeMeasureSpec(this.hZl, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.hZf.measure(MeasureSpec.makeMeasureSpec(1, 1073741824), MeasureSpec.makeMeasureSpec(this.hZm, 1073741824));
        this.hZg.measure(MeasureSpec.makeMeasureSpec(1, 1073741824), MeasureSpec.makeMeasureSpec(this.hZm, 1073741824));
    }

    public void onClick(View view) {
        if (!this.hZh) {
            v.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
        } else if (view == this.hYQ) {
            input("0");
        } else if (view == this.hYR) {
            input("1");
        } else if (view == this.hYS) {
            input("2");
        } else if (view == this.hYT) {
            input("3");
        } else if (view == this.hYU) {
            input("4");
        } else if (view == this.hYV) {
            input("5");
        } else if (view == this.hYW) {
            input("6");
        } else if (view == this.hYX) {
            input("7");
        } else if (view == this.hYY) {
            input("8");
        } else if (view == this.hYZ) {
            input("9");
        } else if (view == this.hZa && this.hYy != null && this.hZh) {
            this.hYy.delete();
        }
    }

    public boolean onLongClick(View view) {
        if (view == this.hZa && this.hYy != null && this.hZh) {
            this.hYy.Kz();
        }
        return false;
    }

    public final void eQ(boolean z) {
        this.hZh = z;
        this.hYQ.setEnabled(z);
        this.hYR.setEnabled(z);
        this.hYS.setEnabled(z);
        this.hYT.setEnabled(z);
        this.hYU.setEnabled(z);
        this.hYV.setEnabled(z);
        this.hYW.setEnabled(z);
        this.hYX.setEnabled(z);
        this.hYY.setEnabled(z);
        this.hYZ.setEnabled(z);
        this.hZa.setEnabled(z);
    }

    private void input(String str) {
        if (this.hYy != null && this.hZh) {
            this.hYy.input(str);
        }
    }
}

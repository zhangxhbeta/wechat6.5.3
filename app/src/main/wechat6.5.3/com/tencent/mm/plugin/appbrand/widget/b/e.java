package com.tencent.mm.plugin.appbrand.widget.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class e extends RelativeLayout {
    private static final int dVM = Color.parseColor("#F9F9F9");
    private final int dZs;
    private final int dZt;
    public g dZu;
    private FrameLayout dZv;
    public a dZw;
    private boolean dZx;

    public interface a {
        void c(boolean z, String str);
    }

    private void d(boolean z, String str) {
        if (!this.dZx && this.dZw != null) {
            this.dZx = true;
            this.dZw.c(z, str);
            this.dZx = false;
        }
    }

    public e(Context context) {
        super(context);
        this.dZs = com.tencent.mm.bd.a.fromDPToPix(context, 48);
        this.dZt = com.tencent.mm.bd.a.fromDPToPix(context, 240);
        setClickable(true);
        setLongClickable(true);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dZt);
        layoutParams.addRule(12);
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setId(2131755018);
        frameLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e dZy;

            {
                this.dZy = r1;
            }

            public final void onClick(View view) {
            }
        });
        frameLayout.setBackgroundColor(dVM);
        this.dZv = frameLayout;
        addView(frameLayout, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams(-1, this.dZs);
        layoutParams.addRule(2, 2131755018);
        frameLayout = new RelativeLayout(getContext());
        View bj = bj(2131231977, 2131689767);
        bj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e dZy;

            {
                this.dZy = r1;
            }

            public final void onClick(View view) {
                this.dZy.d(true, this.dZy.dZu == null ? null : this.dZy.dZu.To());
            }
        });
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        frameLayout.addView(bj, layoutParams2);
        bj = bj(2131231975, 2131689585);
        bj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e dZy;

            {
                this.dZy = r1;
            }

            public final void onClick(View view) {
                this.dZy.d(false, null);
            }
        });
        layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(9);
        frameLayout.addView(bj, layoutParams2);
        frameLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e dZy;

            {
                this.dZy = r1;
            }

            public final void onClick(View view) {
            }
        });
        frameLayout.setBackgroundColor(dVM);
        addView(frameLayout, layoutParams);
    }

    public final void a(g gVar) {
        if (this.dZu == null || gVar.getClass() != this.dZu.getClass()) {
            this.dZu = gVar;
            if (this.dZv != null && this.dZu != null && this.dZu.getView() != null) {
                this.dZv.removeAllViews();
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                this.dZv.addView(this.dZu.getView(), layoutParams);
            }
        }
    }

    public void show() {
        setVisibility(0);
        if (this.dZu != null) {
            this.dZu.aEU();
        }
    }

    public void hide() {
        super.setVisibility(8);
        d(false, null);
    }

    public void setVisibility(int i) {
        if (i != 0) {
            hide();
        } else {
            super.setVisibility(i);
        }
    }

    @SuppressLint({"WrongCall"})
    protected final void bi(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onMeasure(int i, int i2) {
        if (isShown()) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.dZs + this.dZt, 1073741824));
        } else {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
        }
    }

    private View bj(int i, int i2) {
        View textView = new TextView(new ContextThemeWrapper(getContext(), 2131559154));
        textView.setTextColor(getResources().getColor(i2));
        textView.setText(i);
        textView.setGravity(17);
        return textView;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dZw = null;
        removeAllViews();
    }
}

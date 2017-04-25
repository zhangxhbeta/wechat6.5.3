package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.ui.a.c;
import com.tenpay.android.wechat.MyKeyboardWindow;

public final class g extends LinearLayout {
    private boolean dYc = false;
    public b dYd;
    a dYe;
    private EditText kL;

    public interface b {
        void onDone();
    }

    private static final class a extends MyKeyboardWindow {
        a(Context context) {
            super(context);
            if (VERSION.SDK_INT >= 14) {
                setAccessibilityDelegate(new c());
            }
        }

        protected final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            setInputEditText(null);
        }
    }

    public static g bI(View view) {
        return (g) view.getRootView().findViewById(2131755014);
    }

    public g(Context context) {
        super(context);
        super.setId(2131755014);
        setOrientation(1);
        setBackgroundResource(2131689900);
        LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bd.a.fromDPToPix(getContext(), 30));
        View relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g dYf;

            {
                this.dYf = r1;
            }

            public final void onClick(View view) {
                this.dYf.onDone();
                this.dYf.setVisibility(8);
            }
        });
        relativeLayout.setBackgroundResource(2130839330);
        View imageView = new ImageView(getContext());
        imageView.setImageResource(2130839329);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        relativeLayout.addView(imageView, layoutParams2);
        addView(relativeLayout, layoutParams);
        layoutParams = new LayoutParams(-1, com.tencent.mm.bd.a.fromDPToPix(getContext(), 240));
        relativeLayout = new a(getContext());
        this.dYe = relativeLayout;
        addView(relativeLayout, layoutParams);
    }

    private void onDone() {
        if (!this.dYc && this.dYd != null) {
            this.dYc = true;
            this.dYd.onDone();
            this.dYc = false;
        }
    }

    public final void setId(int i) {
    }

    public final void setVisibility(int i) {
        if (getVisibility() != i || (getVisibility() != 0 && getVisibility() != 8)) {
            if (i != 0) {
                super.setVisibility(8);
                onDone();
            }
            super.setVisibility(i);
        }
    }

    public final void setInputEditText(EditText editText) {
        this.kL = editText;
        this.dYe.setInputEditText(editText);
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            i2 = MeasureSpec.makeMeasureSpec(com.tencent.mm.bd.a.fromDPToPix(getContext(), 270), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllViews();
    }
}

package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.kiss.widget.textview.f;

public class SnsPostDescPreloadTextView extends PLTextView {
    private static int hitCount = 0;
    private static int missCount = 0;
    private boolean kch = false;
    public int kci = 0;

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final a vO() {
        this.kch = true;
        return c.aYt().aYs();
    }

    public final void setMaxLines(int i) {
        boolean z = true;
        if (getText() == null) {
            super.setMaxLines(i);
        }
        if (i <= 6) {
            if (this.kch) {
                b(c.aYt().aYu());
                this.kch = false;
            }
            z = false;
        } else {
            if (!this.kch) {
                b(c.aYt().aYs());
                this.kch = true;
            }
            z = false;
        }
        if (z) {
            f a = c.clL.a(vN(), getText());
            if (a == null) {
                int aYv = this.kci > 0 ? this.kci : c.aYt().aYv();
                if (aYv > 0) {
                    a = d.a(getText(), aYv, vN()).vL();
                }
            }
            if (a != null) {
                b(a);
            }
        }
    }

    protected final void p(CharSequence charSequence) {
        super.p(charSequence);
        hitCount++;
    }

    protected final void o(CharSequence charSequence) {
        if (charSequence != null) {
            setText(d.a(getContext(), charSequence.toString(), vN().cmK), true);
        }
        missCount++;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}

package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import java.util.ArrayList;

public class AutoResizeTextView extends TextView {
    private a gzV;

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(attributeSet);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(attributeSet);
    }

    private void e(AttributeSet attributeSet) {
        a aVar = new a(this);
        if (attributeSet != null) {
            int i = (int) aVar.gAb;
            float f = aVar.gAd;
            float f2 = (float) i;
            Context context = aVar.kG.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            float applyDimension = TypedValue.applyDimension(0, f2, system.getDisplayMetrics());
            if (applyDimension != aVar.gAb) {
                aVar.gAb = applyDimension;
                aVar.asM();
            }
            if (aVar.gAd != f) {
                aVar.gAd = f;
                aVar.asM();
            }
        }
        if (!aVar.zU) {
            aVar.zU = true;
            aVar.kG.addTextChangedListener(aVar.abU);
            aVar.asM();
        }
        if (aVar.mListeners == null) {
            aVar.mListeners = new ArrayList();
        }
        aVar.mListeners.add(this);
        this.gzV = aVar;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gzV != null) {
            this.gzV.asM();
        }
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        if (this.gzV != null) {
            a aVar = this.gzV;
            if (!aVar.gAe) {
                Context context = aVar.kG.getContext();
                Resources system = Resources.getSystem();
                if (context != null) {
                    system = context.getResources();
                }
                aVar.O(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
            }
        }
    }

    public void setLines(int i) {
        super.setLines(i);
        if (this.gzV != null) {
            this.gzV.lG(i);
        }
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        if (this.gzV != null) {
            this.gzV.lG(i);
        }
    }
}

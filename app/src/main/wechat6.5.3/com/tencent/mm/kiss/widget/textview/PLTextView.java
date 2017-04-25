package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class PLTextView extends StaticTextView {
    private static long clN = 0;
    private static int clO = 0;
    private static long clP = -2147483648L;
    private static long clQ = 0;
    private static int clR = 0;
    private static long clS = -2147483648L;
    private static long clT = 0;
    private static int clU = 0;
    private static long clV = -2147483648L;
    private static boolean clW = false;

    public PLTextView(Context context) {
        super(context);
    }

    public PLTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setText(CharSequence charSequence) {
        long j = 0;
        if (!be.D(charSequence)) {
            long currentTimeMillis;
            boolean z;
            if (h.DEBUG) {
                currentTimeMillis = System.currentTimeMillis();
            } else {
                currentTimeMillis = 0;
            }
            if (vR() != null && vR().cmn) {
                c.clL.a(vN(), vR());
            }
            f a = c.clL.a(vN(), charSequence);
            if (a != null) {
                p(charSequence);
                b(a);
                z = true;
            } else {
                o(charSequence);
                z = false;
            }
            if (h.DEBUG) {
                j = System.currentTimeMillis();
                v.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", Double.valueOf(((double) (j - currentTimeMillis)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence, Boolean.valueOf(z));
            }
            if (clW) {
                currentTimeMillis = j - currentTimeMillis;
                clN += currentTimeMillis;
                clO++;
                if (currentTimeMillis > clP) {
                    clP = currentTimeMillis;
                }
            }
        } else if (h.DEBUG) {
            v.d("MicroMsg.PLTextView", "set null text");
        }
    }

    public void onMeasure(int i, int i2) {
        long j = 0;
        if (clW) {
            j = System.currentTimeMillis();
        }
        super.onMeasure(i, i2);
        if (clW) {
            j = System.currentTimeMillis() - j;
            clQ += j;
            clR++;
            if (j > clS) {
                clS = j;
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        long j = 0;
        if (clW) {
            j = System.currentTimeMillis();
        }
        super.onDraw(canvas);
        if (clW) {
            j = System.currentTimeMillis() - j;
            clT += j;
            clU++;
            if (j > clV) {
                clV = j;
            }
        }
    }

    public void o(CharSequence charSequence) {
        super.setText(charSequence, false);
    }

    public void p(CharSequence charSequence) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (vR() != null) {
            vR().cmn = false;
        }
    }
}

package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class SnsTextView extends TextView {
    public String gVC = "";
    private char jUc = '\u0000';

    public SnsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTextContextMenuItem(int i) {
        return super.onTextContextMenuItem(i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        if (p.ceJ.cdM == 1 || p.ceJ.cdM == -1) {
            try {
                super.onMeasure(i, i2);
                this.jUc = '\u0000';
                return;
            } catch (IndexOutOfBoundsException e) {
                if (this.jUc < '\u0003') {
                    try {
                        CharSequence spannableStringBuilder = new SpannableStringBuilder(getText());
                        MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                        if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                            this.jUc = 'd';
                        } else {
                            spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, " ");
                            this.jUc = (char) (this.jUc + 1);
                        }
                        setText(spannableStringBuilder);
                        onMeasure(i, i2);
                        return;
                    } catch (IndexOutOfBoundsException e2) {
                        v.i("MicroMsg.SnsTextView", "tryToFix error set origintext " + be.kS(this.gVC));
                        setText(this.gVC);
                        onMeasure(i, i2);
                        this.jUc = (char) (this.jUc + 1);
                        return;
                    }
                } else if (this.jUc == '\u0003') {
                    v.i("MicroMsg.SnsTextView", "fix error set origintext " + be.kS(this.gVC));
                    setText(this.gVC);
                    onMeasure(i, i2);
                    this.jUc = (char) (this.jUc + 1);
                    return;
                } else {
                    throw e;
                }
            }
        }
        super.onMeasure(i, i2);
    }
}

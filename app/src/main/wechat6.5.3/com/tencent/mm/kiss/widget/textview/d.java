package com.tencent.mm.kiss.widget.textview;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.InputFilter.LengthFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class d {
    private static e clX = new e();
    private static final SpannableString clY = new SpannableString(SQLiteDatabase.KeyEmpty);
    CharSequence clZ = null;
    CharSequence cma = null;
    int cmb = 0;
    int cmc = 0;
    TextPaint cmd = null;
    Alignment cme = Alignment.ALIGN_NORMAL;
    TruncateAt cmf = null;
    int cmg = -1;
    TextDirectionHeuristic cmh = null;
    float cmi = 0.0f;
    float cmj = 1.0f;
    boolean cmk = false;
    LengthFilter cml = null;
    int gravity = 51;
    int maxLength = -1;
    int maxLines = Integer.MAX_VALUE;
    int width = 0;

    public static d a(CharSequence charSequence, int i, a aVar) {
        boolean z = false;
        if (charSequence == null) {
            charSequence = SQLiteDatabase.KeyEmpty;
        }
        int length = charSequence.length();
        if (charSequence == null) {
            charSequence = SQLiteDatabase.KeyEmpty;
        }
        d vM = clX.vM();
        if (vM == null) {
            vM = new d();
        }
        vM.clZ = charSequence.toString();
        vM.cma = charSequence;
        vM.cmb = 0;
        vM.cmc = length;
        vM.width = i;
        vM.cmd = new TextPaint();
        if (aVar.maxLines != -1) {
            length = aVar.maxLines;
            if (length >= 0) {
                vM.maxLines = length;
            }
        }
        if (aVar.maxLength != -1) {
            length = aVar.maxLength;
            if (length >= 0) {
                vM.maxLength = length;
                vM.cml = new LengthFilter(vM.maxLength);
            }
        }
        Alignment alignment = aVar.cme;
        if (alignment != null) {
            vM.cme = alignment;
        }
        if (aVar.cmf != null) {
            TruncateAt truncateAt = aVar.cmf;
            if (truncateAt != null) {
                vM.cmf = truncateAt;
            }
        }
        vM.gravity = aVar.gravity;
        if (aVar.cmH != -1) {
            length = aVar.cmH;
            if (length >= 0) {
                vM.cmg = length;
            }
        }
        if (aVar.cmh != null) {
            TextDirectionHeuristic textDirectionHeuristic = aVar.cmh;
            if (VERSION.SDK_INT >= 18) {
                vM.cmh = textDirectionHeuristic;
            }
        }
        float f = aVar.cmi;
        float f2 = aVar.cmj;
        vM.cmi = f;
        vM.cmj = f2;
        vM.cmk = aVar.cmk;
        if (aVar.cmI != null) {
            if (aVar.cmJ != -1) {
                Typeface typeface = aVar.cmI;
                int i2 = aVar.cmJ;
                if (i2 > 0) {
                    typeface = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
                    vM.a(typeface);
                    length = ((typeface != null ? typeface.getStyle() : 0) ^ -1) & i2;
                    TextPaint textPaint = vM.cmd;
                    if ((length & 1) != 0) {
                        z = true;
                    }
                    textPaint.setFakeBoldText(z);
                    vM.cmd.setTextSkewX((length & 2) != 0 ? -0.25f : 0.0f);
                } else {
                    vM.cmd.setFakeBoldText(false);
                    vM.cmd.setTextSkewX(0.0f);
                    vM.a(typeface);
                }
            } else {
                vM.a(aVar.cmI);
            }
        }
        if (aVar.cmK != -1.0f) {
            vM.cmd.setTextSize(aVar.cmK);
        }
        if (aVar.textColor != -1) {
            vM.cmd.setColor(aVar.textColor);
        }
        if (aVar.linkColor != -1) {
            vM.cmd.linkColor = aVar.linkColor;
        }
        if (aVar.cmp != null) {
            vM.cmd = aVar.cmp;
        }
        return vM;
    }

    private d a(Typeface typeface) {
        this.cmd.setTypeface(typeface);
        return this;
    }

    @TargetApi(18)
    public final f vL() {
        int i;
        boolean z;
        StaticLayout a;
        if (this.cmf == null || this.cmg <= 0) {
            i = this.width;
        } else {
            i = this.cmg;
        }
        if (this.cmf == null && this.maxLines == 1) {
            this.cmf = TruncateAt.END;
        }
        if (this.maxLength > 0 && this.cml != null) {
            CharSequence filter = this.cml.filter(this.cma, 0, this.cma.length(), clY, 0, 0);
            if (filter != null) {
                this.cma = filter;
                if (this.cmc > this.cma.length()) {
                    this.cmc = this.cma.length();
                }
            }
        }
        if (h.DEBUG) {
            v.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.cma + " " + this.width);
        }
        if (this.cme == Alignment.ALIGN_NORMAL) {
            switch (this.gravity & 8388615) {
                case 1:
                    this.cme = Alignment.ALIGN_CENTER;
                    break;
                case 3:
                case 8388611:
                    this.cme = Alignment.ALIGN_NORMAL;
                    break;
                case 5:
                case 8388613:
                    this.cme = Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    this.cme = Alignment.ALIGN_NORMAL;
                    break;
            }
        }
        this.cmd.setAntiAlias(true);
        StaticLayout staticLayout = null;
        if ((this.cmh == null || (com.tencent.mm.compatible.util.d.dW(18) && this.cmh == TextDirectionHeuristics.FIRSTSTRONG_LTR)) && (this.maxLines == Integer.MAX_VALUE || this.maxLines == -1)) {
            z = true;
        } else {
            z = false;
        }
        try {
            a = a(this.cma, z, i);
        } catch (Exception e) {
            v.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", e.getMessage());
            int i2 = 0;
            while (i2 < 3) {
                try {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(this.cma);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                    if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                        i2 = 100;
                    } else {
                        spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, " ");
                        i2++;
                    }
                    this.cma = spannableStringBuilder;
                    staticLayout = a(this.cma, z, i);
                    v.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", Integer.valueOf(i2));
                    a = staticLayout;
                } catch (Exception e2) {
                    v.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", e2.getMessage(), Integer.valueOf(i2));
                }
            }
            a = staticLayout;
        }
        if (a == null) {
            this.cma = this.cma.toString();
            a = a(this.cma, z, i);
        }
        f fVar = new f(a);
        fVar.cmo = this.clZ;
        fVar.text = this.cma;
        fVar.maxLength = this.maxLength;
        fVar.maxLines = this.maxLines;
        fVar.cme = this.cme;
        fVar.cmf = this.cmf;
        fVar.cmp = this.cmd;
        fVar.gravity = this.gravity;
        clX.a(this);
        return fVar;
    }

    private StaticLayout a(CharSequence charSequence, boolean z, int i) {
        if (z) {
            return new StaticLayout(charSequence, this.cmb, this.cmc, this.cmd, this.width, this.cme, this.cmj, this.cmi, this.cmk, this.cmf, i);
        } else if (VERSION.SDK_INT >= 18) {
            if (this.cmh == null) {
                this.cmh = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            return com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.cmb, this.cmc, this.cmd, this.width, this.cme, this.cmh, this.cmj, this.cmi, this.cmk, this.cmf, i, this.maxLines);
        } else {
            return com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.cmb, this.cmc, this.cmd, this.width, this.cme, this.cmj, this.cmi, this.cmk, this.cmf, i, this.maxLines);
        }
    }
}

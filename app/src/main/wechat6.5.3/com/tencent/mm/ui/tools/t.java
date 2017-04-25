package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class t {
    String dVK;
    List<b> oVj;
    WeakReference<EditText> oVk;
    ArrayList<String> oVl;
    boolean oVm;

    public static class a extends Drawable {
        private static int oVn;
        private String dVK;
        private RectF fv;
        private Paint oVo = new Paint(1);
        private Paint oVp;
        private float oVq;
        private float oVr;
        private float oVs;
        private float oVt;

        public a(Context context, String str, Paint paint) {
            this.oVo.setColor(-7829368);
            this.oVp = paint;
            oVn = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 2.0f);
            this.oVq = (float) oVn;
            this.oVr = (float) oVn;
            this.dVK = str;
            this.oVs = this.oVp.measureText(this.dVK);
            FontMetrics fontMetrics = this.oVp.getFontMetrics();
            this.oVt = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) ((this.oVs + ((float) (oVn * 2))) + ((float) (oVn * 2))), (int) this.oVt);
            v.i("MicroMsg.TextDrawable", "setText(%s).", str);
        }

        public final void draw(Canvas canvas) {
            canvas.drawRoundRect(this.fv, this.oVq, this.oVr, this.oVo);
            Rect bounds = getBounds();
            int i = (int) (((((float) (bounds.right - bounds.left)) - (this.fv.right - this.fv.left)) + ((float) (oVn * 2))) / 2.0f);
            FontMetricsInt fontMetricsInt = this.oVp.getFontMetricsInt();
            canvas.drawText(this.dVK, (float) i, (float) ((((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2) + bounds.top) - fontMetricsInt.top), this.oVp);
        }

        public final void setAlpha(int i) {
            if (i != this.oVo.getAlpha()) {
                this.oVo.setAlpha(i);
                invalidateSelf();
            }
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            this.oVo.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public final int getOpacity() {
            return this.oVo.getAlpha() < WebView.NORMAL_MODE_ALPHA ? -3 : -1;
        }

        public final void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            FontMetrics fontMetrics = this.oVp.getFontMetrics();
            this.fv = new RectF((float) (oVn + i), (fontMetrics.ascent - fontMetrics.top) + ((float) i2), (float) (i3 - oVn), (float) i4);
            invalidateSelf();
        }
    }

    private static class b {
        int length;
        boolean oVu;
        int start;

        b(int i, int i2, boolean z) {
            this.start = i;
            this.length = i2;
            this.oVu = z;
        }
    }

    public t(EditText editText) {
        this.oVk = new WeakReference(editText);
    }

    final b yf(int i) {
        if (this.oVj != null) {
            for (b bVar : this.oVj) {
                if (i <= bVar.start + bVar.length && i > bVar.start) {
                    return bVar;
                }
            }
        }
        return null;
    }

    static boolean a(EditText editText, ArrayList<String> arrayList) {
        String obj = editText.getText().toString();
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        List<b> h = h(obj, arrayList);
        if (h == null || h.size() <= 0) {
            return false;
        }
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        Context context = editText.getContext();
        Paint paint = editText.getPaint();
        for (b bVar : h) {
            int i = bVar.start;
            int i2 = bVar.length;
            if (i < 0 || i2 <= 0 || i + i2 > obj.length()) {
                v.i("MicroMsg.WordsChecker", "start : %d, length : %d.", Integer.valueOf(i), Integer.valueOf(i2));
            } else if (bVar.oVu) {
                String substring = obj.substring(i, i + i2);
                CharSequence spannableString = new SpannableString(substring);
                spannableString.setSpan(new ImageSpan(new a(context, substring, paint), 0), 0, substring.length(), 33);
                spannableStringBuilder.append(spannableString);
            } else {
                spannableStringBuilder.append(obj.substring(i, i + i2));
            }
        }
        if (spannableStringBuilder.length() > 0) {
            editText.setText(spannableStringBuilder);
            editText.setTextKeepState(spannableStringBuilder);
            if (selectionStart == selectionEnd && selectionStart >= 0) {
                editText.setSelection(selectionStart);
            }
        }
        return true;
    }

    static List<b> h(String str, ArrayList<String> arrayList) {
        if (be.kS(str) || arrayList == null || arrayList.size() == 0) {
            return null;
        }
        List<b> arrayList2 = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i <= length) {
            Iterator it = arrayList.iterator();
            int i2 = 0;
            int i3 = length;
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!be.kS(str2)) {
                    int i4;
                    int indexOf = str.indexOf(str2, i);
                    if (indexOf < 0 || (indexOf >= i3 && (indexOf != i3 || str2.length() <= i2))) {
                        i4 = i2;
                        i2 = i3;
                    } else {
                        i4 = str2.length();
                        i2 = indexOf;
                    }
                    i3 = i2;
                    i2 = i4;
                }
            }
            if (i3 < length) {
                if (i3 > i) {
                    arrayList2.add(new b(i, i3 - i, false));
                }
                arrayList2.add(new b(i3, i2, true));
                i = i3 + i2;
            } else {
                if (i3 > i) {
                    arrayList2.add(new b(i, i3 - i, false));
                }
                return arrayList2;
            }
        }
        return arrayList2;
    }
}

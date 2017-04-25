package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QTextView extends View {
    private static HashMap<String, a> jJe = new HashMap();
    private Context context;
    private String dVK = "";
    int gAa;
    private TextPaint gl;
    private int jIX;
    String jIY;
    String jIZ;
    private boolean jJa;
    private int jJb;
    private boolean jJc;
    boolean jJd;
    private a jJf;
    private a jJg;
    int jJh = 0;
    private int textSize = -1;

    private static class a {
        private static HashMap<String, Integer> jJn = new HashMap();
        private String apU = "";
        private int jJh = 0;
        boolean jJi = false;
        ArrayList<int[]> jJj = new ArrayList();
        float jJk;
        float jJl;
        float jJm;

        public final int a(String str, String str2, String str3, int i, int i2, TextPaint textPaint) {
            String str4 = str + str2 + str3 + i + i2;
            if (str4.equals(this.apU)) {
                return this.jJh;
            }
            this.apU = str4;
            this.jJj.clear();
            this.jJi = false;
            this.jJk = 0.0f;
            this.jJl = 0.0f;
            this.jJm = 0.0f;
            if (i2 == -1) {
                this.jJj.add(new int[]{null, str.length()});
                this.jJh = (int) (textPaint.measureText(str) + 0.5f);
                return this.jJh;
            }
            if (str2 != null) {
                this.jJl = textPaint.measureText(str2);
            }
            if (str3 != null) {
                this.jJm = textPaint.measureText(str3);
            }
            int i3 = -1;
            float f = 0.0f;
            Object obj = 1;
            int i4 = 0;
            while (i4 < str.length()) {
                if (i3 == -1) {
                    i3 = i4;
                }
                if (this.jJj.size() == i) {
                    this.jJi = true;
                    break;
                }
                int i5;
                Object obj2;
                float measureText = textPaint.measureText(str.charAt(i4));
                Object obj3 = null;
                if (str.charAt(i4) == '\n') {
                    this.jJj.add(new int[]{i3, i4 - 1});
                    i5 = i4;
                    obj2 = 1;
                } else {
                    if (f + measureText >= ((float) i2)) {
                        obj3 = 1;
                        if (str.charAt(i4) == ' ' || r2 == null) {
                            i4--;
                            this.jJj.add(new int[]{i3, i4});
                            i5 = i4;
                            i4 = 1;
                        } else {
                            while (str.charAt(i4) != ' ') {
                                i4--;
                                if (i4 == 0) {
                                    break;
                                }
                            }
                            this.jJj.add(new int[]{i3, i4});
                        }
                    }
                    Object obj4 = obj3;
                    i5 = i4;
                    obj2 = obj4;
                }
                if (obj2 != null) {
                    i3 = -1;
                    f = 0.0f;
                    if (this.jJj.size() == i - 1) {
                        i2 = (int) (((float) i2) - (this.jJl + this.jJm));
                        obj = null;
                    }
                } else {
                    f += measureText;
                    if (i5 == str.length() - 1) {
                        this.jJj.add(new int[]{i3, i5});
                    }
                }
                i4 = i5 + 1;
            }
            if (this.jJi) {
                int[] iArr = (int[]) this.jJj.get(this.jJj.size() - 1);
                this.jJk = textPaint.measureText(str.substring(iArr[0], iArr[1] + 1));
            }
            if (this.jJj.size() == 0) {
                this.jJh = 0;
                return this.jJh;
            } else if (this.jJj.size() == 1) {
                this.jJh = (int) (textPaint.measureText(str) + 0.5f);
                return this.jJh;
            } else {
                this.jJh = i2;
                return this.jJh;
            }
        }
    }

    public QTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public QTextView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        this.jJd = false;
        this.jJa = true;
        this.jJc = false;
        this.gAa = -1;
        this.jIY = "...";
        this.jIZ = "";
        this.jJb = -16776961;
        this.jJf = new a();
        this.jJg = new a();
        this.gl = new TextPaint();
        this.gl.setAntiAlias(true);
        if (this.textSize == -1) {
            this.textSize = b.a(this.context, 12.0f);
            this.gl.setTextSize((float) this.textSize);
        } else {
            this.gl.setTextSize(13.0f);
        }
        this.gl.setColor(-16777216);
        this.gl.setTextAlign(Align.LEFT);
    }

    public final void setText(String str) {
        if (be.kS(this.dVK)) {
            this.dVK = "";
        }
        this.dVK = str;
        this.jJf.apU = "";
        this.jJg.apU = "";
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            qS(size);
        } else if (mode == Integer.MIN_VALUE) {
            size = Math.min(qS(size), size);
        } else {
            qS(size);
            size = 0;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        this.jIX = (int) this.gl.ascent();
        if (mode2 == 1073741824) {
            i3 = mode;
        } else {
            i3 = (((this.jJd ? this.jJf.jJj.size() : this.jJg.jJj.size()) * ((int) (((float) (-this.jIX)) + this.gl.descent()))) + getPaddingTop()) + getPaddingBottom();
            if (mode2 == Integer.MIN_VALUE) {
                i3 = Math.min(i3, mode);
            }
        }
        setMeasuredDimension(size, i3);
    }

    protected void onDraw(Canvas canvas) {
        a aVar;
        super.onDraw(canvas);
        a aVar2;
        if (this.jJd) {
            aVar2 = this.jJf;
            List list = this.jJf.jJj;
            aVar = aVar2;
        } else {
            aVar2 = this.jJg;
            Object obj = this.jJg.jJj;
            aVar = aVar2;
        }
        float paddingLeft = (float) getPaddingLeft();
        float paddingTop = (float) (getPaddingTop() + (-this.jIX));
        int i = 0;
        while (i < list.size()) {
            int[] iArr = (int[]) list.get(i);
            canvas.drawText(this.dVK, iArr[0], iArr[1] + 1, paddingLeft, paddingTop, this.gl);
            if (i == list.size() - 1 && aVar.jJi) {
                canvas.drawText(this.jIY, aVar.jJk + paddingLeft, paddingTop, this.gl);
                if (this.jJa) {
                    int color = this.gl.getColor();
                    this.gl.setColor(this.jJb);
                    if (this.jJc) {
                        canvas.drawText(this.jIZ, ((float) canvas.getWidth()) - ((aVar.jJm + ((float) getPaddingRight())) + ((float) getPaddingLeft())), paddingTop, this.gl);
                    } else {
                        canvas.drawText(this.jIZ, (aVar.jJk + aVar.jJl) + paddingLeft, paddingTop, this.gl);
                    }
                    this.gl.setColor(color);
                }
            }
            paddingTop += ((float) (-this.jIX)) + this.gl.descent();
            if (paddingTop <= ((float) canvas.getHeight())) {
                i++;
            } else {
                return;
            }
        }
    }

    private int qS(int i) {
        if (this.jJd) {
            if (be.kS(this.jJf.apU)) {
                this.jJh = this.jJf.a(this.dVK, null, null, -1, (i - getPaddingLeft()) - getPaddingRight(), this.gl);
            }
        } else if (be.kS(this.jJg.apU)) {
            this.jJh = this.jJg.a(this.dVK, this.jIY, this.jIZ, this.gAa, (i - getPaddingLeft()) - getPaddingRight(), this.gl);
        }
        return (this.jJh + getPaddingLeft()) + getPaddingRight();
    }
}

package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class g {
    private boolean cmA = false;
    private boolean cmB = false;
    View cmC;
    private int cmD = 0;
    private int cmE = 0;
    protected f cms;
    public a cmt;
    protected StaticLayout cmu;
    protected boolean cmv = false;
    int cmw;
    int cmx;
    private boolean cmy = false;
    boolean cmz = false;
    protected CharSequence text = null;

    public g(View view, a aVar) {
        this.cmC = view;
        this.cmt = aVar;
    }

    public final void init() {
        this.text = SQLiteDatabase.KeyEmpty;
        this.cmC.setWillNotDraw(false);
    }

    public final void setSingleLine(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = Integer.MAX_VALUE;
        }
        if (this.cmt.maxLines != i) {
            this.cmt.maxLines = i;
            this.cmv = true;
            vS();
            this.cmC.requestLayout();
            this.cmC.invalidate();
        }
    }

    public final void setLines(int i) {
        if (this.cmt.maxLines != i || this.cmt.minLines != i) {
            this.cmv = true;
            vS();
            this.cmt.maxLines = i;
            this.cmt.minLines = i;
            this.cmC.requestLayout();
            this.cmC.invalidate();
            if (h.DEBUG) {
                v.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
            }
        }
    }

    public final void setTextSize(int i, float f) {
        Resources system;
        Context context = aa.getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
        if (applyDimension != 0.0f && this.cmt != null && applyDimension != this.cmt.cmK) {
            this.cmt.cmK = applyDimension;
            this.cmv = true;
            if (h.DEBUG) {
                v.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
            }
        }
    }

    public final void b(f fVar) {
        if (fVar == null || fVar.cmq == null) {
            this.cms = null;
            return;
        }
        if (this.cmt == null) {
            b bVar = new b();
            bVar.cmt = new a();
            bVar.cmt.maxLines = fVar.maxLines;
            bVar.cmt.maxLength = fVar.maxLength;
            bVar.cmt.cmp = fVar.cmp;
            bVar.cmt.cme = fVar.cme;
            bVar.cmt.cmf = fVar.cmf;
            bVar.cmt.gravity = fVar.gravity;
            bVar.cmt.cmK = fVar.cmp.getTextSize();
            bVar.cmt.textColor = fVar.cmp.getColor();
            this.cmt = bVar.cmt;
        }
        vS();
        this.cmC.setWillNotDraw(false);
        this.cms = fVar;
        this.cmu = fVar.cmq;
        this.text = fVar.text;
        this.cmy = this.text instanceof Spannable;
        if (this.cmy) {
            this.text = this.cms.text;
            com.tencent.mm.kiss.widget.textview.b.b.vV();
            com.tencent.mm.kiss.widget.textview.b.b.a((Spannable) this.text);
        }
        this.cmC.requestLayout();
        this.cmC.invalidate();
    }

    public final void setTextColor(int i) {
        if (this.cmt != null && i != this.cmt.textColor) {
            this.cmt.textColor = i;
            this.cmv = true;
            if (h.DEBUG) {
                v.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
            }
        }
    }

    public final void setGravity(int i) {
        if (this.cmt != null && i != this.cmt.gravity) {
            this.cmt.gravity = i;
            this.cmv = true;
            if (h.DEBUG) {
                v.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
            }
        }
    }

    public final void setMaxLines(int i) {
        if (this.cmt != null && i != this.cmt.maxLines) {
            this.cmt.maxLines = i;
            this.cmv = true;
            vS();
            if (h.DEBUG) {
                v.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
            }
            this.cmC.requestLayout();
            this.cmC.invalidate();
        }
    }

    public final int getLineHeight() {
        TextPaint paint = this.cms.cmq.getPaint();
        if (paint == null) {
            paint = this.cmt.cmp;
        }
        return Math.round((((float) paint.getFontMetricsInt(null)) * this.cmt.cmj) + this.cmt.cmi);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        if (charSequence != null) {
            if (this.text == null || !this.text.equals(charSequence) || z) {
                this.text = charSequence;
                this.cmv = true;
                this.cmC.requestLayout();
                this.cmC.invalidate();
                if (h.DEBUG) {
                    v.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + charSequence + " hashcode " + hashCode() + " " + new af().toString());
                }
            }
        }
    }

    final void vS() {
        this.cmE = 0;
        this.cmD = 0;
        this.cmw = 0;
        this.cmx = 0;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final float getTextSize() {
        if (this.cms != null) {
            return this.cms.cmp.getTextSize();
        }
        if (this.cmt != null) {
            return this.cmt.cmK;
        }
        return 0.0f;
    }

    public final Layout vQ() {
        return this.cmu;
    }

    public final f vR() {
        return this.cms;
    }

    public final int getLineCount() {
        if (this.cmu == null) {
            return 0;
        }
        return this.cmu.getLineCount();
    }

    public final boolean n(MotionEvent motionEvent) {
        int i = -1;
        boolean z = motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
        if (!this.cmC.isEnabled() || !this.cmy) {
            return false;
        }
        com.tencent.mm.kiss.widget.textview.b.b.vV();
        boolean a = com.tencent.mm.kiss.widget.textview.b.b.a(this.cmC, this.cmu, (Spannable) this.text, motionEvent);
        this.cmB = a;
        if (this.cmA && z) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            boolean z2 = (x < ((float) this.cmw) || x > ((float) (this.cmu.getWidth() + this.cmw))) ? false : y >= ((float) this.cmx) && y <= ((float) (this.cmu.getHeight() + this.cmx));
            if (z2) {
                Spannable spannable = (Spannable) this.text;
                int selectionStart = this.text == null ? -1 : Selection.getSelectionStart(this.text);
                if (this.text != null) {
                    i = Selection.getSelectionEnd(this.text);
                }
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(selectionStart, i, ClickableSpan.class);
                if (clickableSpanArr.length > 0) {
                    v.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
                    clickableSpanArr[0].onClick(this.cmC);
                    return true;
                }
            }
        }
        return a;
    }

    public final boolean performClick() {
        if (this.cmB || !this.cmz) {
            return false;
        }
        return true;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.cmu == null || this.cms == null) {
            boolean eC = eC(this.cmC.getMeasuredWidth());
            if (h.DEBUG) {
                v.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", this.cmu, this.cms, Boolean.valueOf(eC));
            }
            if (eC) {
                this.cmC.requestLayout();
                this.cmC.invalidate();
                return;
            }
            return;
        }
        long j = 0;
        if (h.DEBUG) {
            j = System.nanoTime();
        }
        canvas.save();
        canvas.clipRect(this.cmC.getPaddingLeft(), this.cmC.getPaddingTop(), (this.cmC.getRight() - this.cmC.getLeft()) - this.cmC.getPaddingRight(), (this.cmC.getBottom() - this.cmC.getTop()) - this.cmC.getPaddingBottom());
        if (this.cmw == 0 || this.cmx == 0) {
            int paddingLeft = this.cmC.getPaddingLeft();
            int right = ((this.cmC.getRight() - this.cmC.getLeft()) - this.cmC.getPaddingLeft()) - this.cmC.getPaddingRight();
            int width = this.cmu.getWidth();
            if (width > right) {
                right = paddingLeft;
            } else {
                switch (this.cms.gravity & 8388615) {
                    case 1:
                    case 17:
                        right = (right / 2) - (width / 2);
                        break;
                    case 3:
                    case 8388611:
                        right = 0;
                        break;
                    case 5:
                    case 8388613:
                        right -= width;
                        break;
                    default:
                        right = 0;
                        break;
                }
                right += paddingLeft;
            }
            this.cmw = right;
            paddingLeft = this.cmC.getPaddingTop();
            width = ((this.cmC.getBottom() - this.cmC.getTop()) - this.cmC.getPaddingTop()) - this.cmC.getPaddingBottom();
            right = 0;
            int height = this.cmu.getHeight();
            if (height > width) {
                right = paddingLeft;
            } else {
                switch (this.cms.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                    case 16:
                        right = (width / 2) - (height / 2);
                        break;
                    case 48:
                        right = 0;
                        break;
                    case 80:
                        right = width - height;
                        break;
                }
                right += paddingLeft;
            }
            this.cmx = right;
        }
        canvas.translate((float) this.cmw, (float) this.cmx);
        this.cmu.draw(canvas, null, null, 0);
        canvas.restore();
        if (h.DEBUG) {
            v.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d), Integer.valueOf(hashCode()), this.text, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7));
        }
    }

    private boolean eC(int i) {
        if (this.cmv || this.cms == null || this.cmu == null) {
            if (this.cmt == null) {
                return false;
            }
            if (i > 0) {
                vS();
                long j = 0;
                if (h.DEBUG) {
                    j = System.nanoTime();
                }
                this.cms = d.a(this.text, i, this.cmt).vL();
                this.cmu = this.cms.cmq;
                this.cmv = false;
                if (h.DEBUG) {
                    long nanoTime = System.nanoTime();
                    v.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", Integer.valueOf(i), Integer.valueOf(hashCode()), Double.valueOf(((double) (nanoTime - j)) / 1000000.0d), this.text);
                }
                return true;
            }
        }
        return false;
    }

    public final Point aB(int i, int i2) {
        Point point;
        long j = 0;
        if (h.DEBUG) {
            j = System.nanoTime();
        }
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        eC(size);
        if (this.cmu != null) {
            int i3;
            int i4;
            if (mode != 1073741824) {
                i3 = 0;
                if (this.cmt.cmf == null) {
                    Layout layout = this.cmu;
                    if (this.cmD != 0) {
                        i3 = this.cmD;
                    } else {
                        int lineCount = layout.getLineCount();
                        CharSequence text = layout.getText();
                        float f = 0.0f;
                        for (i4 = 0; i4 < lineCount - 1; i4++) {
                            if (text.charAt(layout.getLineEnd(i4) - 1) != '\n') {
                                i3 = -1;
                                break;
                            }
                        }
                        for (i4 = 0; i4 < lineCount; i4++) {
                            f = Math.max(f, layout.getLineWidth(i4));
                        }
                        this.cmD = (int) Math.ceil((double) f);
                        this.cmD += this.cmC.getPaddingLeft() + this.cmC.getPaddingRight();
                        i3 = this.cmD;
                    }
                }
                i4 = (int) Math.ceil((double) Layout.getDesiredWidth(this.cmu.getText(), this.cmu.getPaint()));
                if (i4 > i3) {
                    i3 = i4;
                }
                if (h.DEBUG) {
                    v.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", Integer.valueOf(hashCode()), Integer.valueOf(i3), Integer.valueOf(i4));
                }
                if (mode == Integer.MIN_VALUE) {
                    size = Math.min(size, i3);
                } else {
                    size = i3;
                }
            }
            if (mode2 == 1073741824) {
                i3 = size2;
            } else {
                Layout layout2 = this.cmu;
                if (this.cmE != 0) {
                    i3 = this.cmE;
                } else {
                    i3 = layout2.getLineCount();
                    if (this.cms.maxLines > 0 && this.cms.maxLines < i3) {
                        i3 = this.cms.maxLines;
                    }
                    mode = this.cmC.getPaddingTop() + this.cmC.getPaddingBottom();
                    i4 = layout2.getLineTop(i3);
                    if (this.cmt.minLines <= 0 || i3 >= this.cmt.minLines) {
                        i3 = i4;
                    } else {
                        i3 = ((this.cmt.minLines - i3) * getLineHeight()) + i4;
                    }
                    this.cmE = i3 + mode;
                    i3 = this.cmE;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    i3 = Math.min(i3, size2);
                }
            }
            point = new Point(size, i3);
        } else {
            point = null;
        }
        if (h.DEBUG) {
            String str = "MicroMsg.StaticTextViewHolder";
            String str2 = "onMeasure used: %fms, hashCode: %d, text: %s result: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d);
            objArr[1] = Integer.valueOf(hashCode());
            objArr[2] = this.text;
            objArr[3] = point == null ? SQLiteDatabase.KeyEmpty : point.toString();
            v.d(str, str2, objArr);
        }
        return point;
    }
}

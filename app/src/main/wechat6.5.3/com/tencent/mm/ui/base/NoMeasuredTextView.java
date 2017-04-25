package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Editable.Factory;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView extends View {
    private static final Metrics oaZ = new Metrics();
    private int OT;
    private boolean dYL;
    private ColorStateList eb;
    public TextPaint gl;
    private int iN;
    private CharSequence mText;
    private float oaA;
    private float oaB;
    private int oaC;
    private int oaD;
    private int oaE;
    private int oaF;
    private boolean oaG;
    private boolean oaH;
    private int oaI;
    private boolean oaJ;
    private BoringLayout oaK;
    private boolean oaL;
    private int oaM;
    private FontMetricsInt oaN;
    private boolean oaO;
    public boolean oaP;
    private b oaQ;
    private boolean oaR;
    private boolean oaS;
    private boolean oaT;
    private boolean oaU;
    private int oaV;
    private int oaW;
    private int oaX;
    private int oaY;
    private int oas;
    private Factory oat;
    private Spannable.Factory oau;
    private TruncateAt oav;
    private CharSequence oaw;
    private int oax;
    private KeyListener oay;
    private Layout oaz;
    private int tD;

    public enum a {
        ;

        static {
            oba = 1;
            obb = 2;
            obc = 3;
            obd = new int[]{oba, obb, obc};
        }
    }

    class b {
        final Rect obe = new Rect();
        Drawable obf;
        Drawable obg;
        Drawable obh;
        Drawable obi;
        int obk;
        int obl;
        int obm;
        int obn;
        int obo;
        int obp;
        int obq;
        int obr;
        int obs;
        final /* synthetic */ NoMeasuredTextView obt;

        b(NoMeasuredTextView noMeasuredTextView) {
            this.obt = noMeasuredTextView;
        }
    }

    public final void jv(boolean z) {
        if (this.oaR != z) {
            invalidate();
        }
        this.oaR = z;
    }

    public final void jw(boolean z) {
        if (this.oaS != z) {
            invalidate();
        }
        this.oaS = z;
    }

    static {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.measureText("H");
    }

    public NoMeasuredTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oat = Factory.getInstance();
        this.oau = Spannable.Factory.getInstance();
        this.oav = null;
        this.oax = a.oba;
        this.tD = 51;
        this.oaA = 1.0f;
        this.oaB = 0.0f;
        this.oaC = Integer.MAX_VALUE;
        this.oaD = 1;
        this.oaE = 0;
        this.oaF = 1;
        this.iN = Integer.MAX_VALUE;
        this.oaG = false;
        this.OT = 0;
        this.oaH = false;
        this.oaI = -1;
        this.oaJ = true;
        this.oaL = false;
        this.oaO = false;
        this.oaP = false;
        this.oaR = false;
        this.oaS = false;
        this.oaT = false;
        this.oaU = false;
        this.oaV = -1;
        this.oaW = -1;
        this.oaX = -1;
        this.oaY = -1;
        this.mText = SQLiteDatabase.KeyEmpty;
        this.oaw = SQLiteDatabase.KeyEmpty;
        this.gl = new TextPaint(1);
        this.gl.density = getResources().getDisplayMetrics().density;
        setDrawingCacheEnabled(false);
        this.oaN = this.gl.getFontMetricsInt();
        bCY();
        bCo();
        setEllipsize(null);
    }

    private void a(Drawable drawable, Drawable drawable2) {
        b bVar = this.oaQ;
        int i = (drawable == null && drawable2 == null) ? 0 : 1;
        if (i != 0) {
            if (bVar == null) {
                bVar = new b(this);
                this.oaQ = bVar;
            }
            if (!(bVar.obh == drawable || bVar.obh == null)) {
                bVar.obh.setCallback(null);
            }
            bVar.obh = drawable;
            if (!(bVar.obf == null || bVar.obf == null)) {
                bVar.obf.setCallback(null);
            }
            bVar.obf = null;
            if (!(bVar.obi == drawable2 || bVar.obi == null)) {
                bVar.obi.setCallback(null);
            }
            bVar.obi = drawable2;
            if (!(bVar.obg == null || bVar.obg == null)) {
                bVar.obg.setCallback(null);
            }
            bVar.obg = null;
            Rect rect = bVar.obe;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                bVar.obm = rect.width();
                bVar.obq = rect.height();
            } else {
                bVar.obq = 0;
                bVar.obm = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                bVar.obn = rect.width();
                bVar.obr = rect.height();
                bVar.obo = 0;
                bVar.obk = 0;
                bVar.obp = 0;
                bVar.obl = 0;
            }
            bVar.obr = 0;
            bVar.obn = 0;
            bVar.obo = 0;
            bVar.obk = 0;
            bVar.obp = 0;
            bVar.obl = 0;
        } else if (bVar != null) {
            if (bVar.obs == 0) {
                this.oaQ = null;
            } else {
                if (bVar.obh != null) {
                    bVar.obh.setCallback(null);
                }
                bVar.obh = null;
                if (bVar.obf != null) {
                    bVar.obf.setCallback(null);
                }
                bVar.obf = null;
                if (bVar.obi != null) {
                    bVar.obi.setCallback(null);
                }
                bVar.obi = null;
                if (bVar.obg != null) {
                    bVar.obg.setCallback(null);
                }
                bVar.obg = null;
                bVar.obq = 0;
                bVar.obm = 0;
                bVar.obr = 0;
                bVar.obn = 0;
                bVar.obo = 0;
                bVar.obk = 0;
                bVar.obp = 0;
                bVar.obl = 0;
            }
        }
        invalidate();
    }

    public final void wC(int i) {
        if (i != this.oaV) {
            this.oaV = i;
            Drawable drawable = getResources().getDrawable(i);
            if (drawable == null) {
                return;
            }
            if (this.oaQ == null || this.oaQ.obh != drawable) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                a(drawable, null);
            }
        }
    }

    public final void bCU() {
        if (2130838410 != this.oaW) {
            this.oaW = 2130838410;
            Drawable drawable = getResources().getDrawable(2130838410);
            if (drawable == null) {
                return;
            }
            if (this.oaQ == null || this.oaQ.obi != drawable) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                a(null, drawable);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.eb != null && this.eb.isStateful()) {
            updateTextColors();
        }
        b bVar = this.oaQ;
        if (bVar != null) {
            int[] drawableState = getDrawableState();
            if (bVar.obf != null && bVar.obf.isStateful()) {
                bVar.obf.setState(drawableState);
            }
            if (bVar.obg != null && bVar.obg.isStateful()) {
                bVar.obg.setState(drawableState);
            }
            if (bVar.obh != null && bVar.obh.isStateful()) {
                bVar.obh.setState(drawableState);
            }
            if (bVar.obi != null && bVar.obi.isStateful()) {
                bVar.obi.setState(drawableState);
            }
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean verifyDrawable = super.verifyDrawable(drawable);
        if (verifyDrawable || this.oaQ == null) {
            return verifyDrawable;
        }
        return drawable == this.oaQ.obh || drawable == this.oaQ.obf || drawable == this.oaQ.obi || drawable == this.oaQ.obg;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            b bVar = this.oaQ;
            if (bVar != null) {
                int compoundPaddingTop;
                if (drawable == bVar.obh) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += getPaddingLeft();
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.obq) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.obi) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += ((getRight() - getLeft()) - getPaddingRight()) - bVar.obn;
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.obr) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.obf) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.obo) / 2) + compoundPaddingTop;
                    scrollY += getPaddingTop();
                } else if (drawable == bVar.obg) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += compoundPaddingTop + (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.obp) / 2);
                    scrollY += ((getBottom() - getTop()) - getPaddingBottom()) - bVar.obl;
                }
            }
            invalidate(bounds.left + scrollX, bounds.top + scrollY, scrollX + bounds.right, scrollY + bounds.bottom);
        }
    }

    private int getCompoundPaddingTop() {
        b bVar = this.oaQ;
        if (bVar == null || bVar.obf == null || !this.oaT) {
            return getPaddingTop();
        }
        return bVar.obk + (getPaddingTop() + bVar.obs);
    }

    private int getCompoundPaddingBottom() {
        b bVar = this.oaQ;
        if (bVar == null || bVar.obg == null || !this.oaU) {
            return getPaddingBottom();
        }
        return bVar.obl + (getPaddingBottom() + bVar.obs);
    }

    private int getCompoundPaddingLeft() {
        b bVar = this.oaQ;
        if (bVar == null || bVar.obh == null || !this.oaR) {
            return getPaddingLeft();
        }
        return bVar.obm + (getPaddingLeft() + bVar.obs);
    }

    private int getCompoundPaddingRight() {
        b bVar = this.oaQ;
        if (bVar == null || bVar.obi == null || !this.oaS) {
            return getPaddingRight();
        }
        return bVar.obn + (getPaddingRight() + bVar.obs);
    }

    private int getExtendedPaddingTop() {
        if (this.oaz == null || this.oaD != 1) {
            return getCompoundPaddingTop();
        }
        if (this.oaz.getLineCount() <= this.oaC) {
            return getCompoundPaddingTop();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int height = (getHeight() - compoundPaddingTop) - getCompoundPaddingBottom();
        int lineTop = this.oaz.getLineTop(this.oaC);
        if (lineTop >= height) {
            return compoundPaddingTop;
        }
        int i = this.tD & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        if (i == 48) {
            return compoundPaddingTop;
        }
        if (i == 80) {
            return (compoundPaddingTop + height) - lineTop;
        }
        return compoundPaddingTop + ((height - lineTop) / 2);
    }

    private int getExtendedPaddingBottom() {
        if (this.oaz == null || this.oaD != 1) {
            return getCompoundPaddingBottom();
        }
        if (this.oaz.getLineCount() <= this.oaC) {
            return getCompoundPaddingBottom();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        compoundPaddingTop = (getHeight() - compoundPaddingTop) - compoundPaddingBottom;
        int lineTop = this.oaz.getLineTop(this.oaC);
        if (lineTop >= compoundPaddingTop) {
            return compoundPaddingBottom;
        }
        int i = this.tD & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        if (i == 48) {
            return (compoundPaddingBottom + compoundPaddingTop) - lineTop;
        }
        return i != 80 ? compoundPaddingBottom + ((compoundPaddingTop - lineTop) / 2) : compoundPaddingBottom;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (!(i == getPaddingLeft() && i3 == getPaddingRight() && i2 == getPaddingTop() && i4 == getPaddingBottom())) {
            bCW();
        }
        super.setPadding(i, i2, i3, i4);
        invalidate();
    }

    public final void G(float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(0, f, system.getDisplayMetrics());
        if (applyDimension != this.gl.getTextSize()) {
            this.gl.setTextSize(applyDimension);
            this.oaN = this.gl.getFontMetricsInt();
            this.oaM = (int) (Math.ceil((double) (this.oaN.descent - this.oaN.ascent)) + 2.0d);
            if (this.oaz != null) {
                bCW();
                requestLayout();
                invalidate();
            }
        }
    }

    public final void setTextColor(int i) {
        this.eb = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public final void setTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            throw new NullPointerException();
        } else if (this.eb != colorStateList) {
            this.eb = colorStateList;
            updateTextColors();
        }
    }

    public final void vP() {
        Object obj = null;
        if (5 != (this.tD & 7)) {
            obj = 1;
        }
        if (53 != this.tD) {
            invalidate();
        }
        this.tD = 53;
        if (this.oaz != null && r0 != null) {
            dj(this.oaz.getWidth(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight());
        }
    }

    private void updateTextColors() {
        int i = 0;
        int colorForState = this.eb.getColorForState(getDrawableState(), 0);
        if (colorForState != this.oas) {
            this.oas = colorForState;
            i = 1;
        }
        if (i != 0) {
            invalidate();
        }
    }

    public final void setText(CharSequence charSequence) {
        int i = this.oax;
        if (charSequence == null) {
            charSequence = SQLiteDatabase.KeyEmpty;
        }
        if (!charSequence.equals(this.mText)) {
            int i2;
            if (charSequence instanceof Spanned) {
                this.oaL = false;
            } else {
                this.oaL = true;
            }
            if (i == a.obc || this.oay != null) {
                charSequence = this.oat.newEditable(charSequence);
            } else if (i == a.obb) {
                charSequence = this.oau.newSpannable(charSequence);
            }
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.oaP) {
                if (this.oaG) {
                    i2 = this.iN;
                    if (getMeasuredWidth() > 0) {
                        i2 = Math.min(this.iN, getMeasuredWidth());
                    }
                    charSequence = TextUtils.ellipsize(charSequence, this.gl, (float) (i2 - compoundPaddingLeft), TruncateAt.END);
                } else if (getMeasuredWidth() > 0) {
                    charSequence = TextUtils.ellipsize(charSequence, this.gl, (float) (getMeasuredWidth() - compoundPaddingLeft), TruncateAt.END);
                } else {
                    this.oaO = true;
                }
            }
            this.oax = i;
            this.mText = charSequence;
            this.oaw = charSequence;
            if (this.oaL) {
                bCY();
                invalidate();
                return;
            }
            if (getWidth() != 0) {
                if (this.oaz == null) {
                    bCX();
                    if (this.oaz.getHeight() != getHeight()) {
                        requestLayout();
                    }
                    invalidate();
                    return;
                }
                i2 = this.oaz.getHeight();
                i = this.oaz.getWidth();
                dj(i, i - compoundPaddingLeft);
                if (this.oav != TruncateAt.MARQUEE) {
                    if (getLayoutParams().height == -2 || getLayoutParams().height == -1) {
                        i = this.oaz.getHeight();
                        if (i == i2 && i == getHeight()) {
                            invalidate();
                            return;
                        }
                    }
                    invalidate();
                    return;
                }
            }
            requestLayout();
            invalidate();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.oaO && getMeasuredWidth() > 0) {
            setText(TextUtils.ellipsize(this.mText, this.gl, (float) ((getMeasuredWidth() - getCompoundPaddingRight()) - getCompoundPaddingLeft()), TruncateAt.END));
            this.oaO = false;
        }
    }

    private int bCV() {
        int i = this.tD & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        Layout layout = this.oaz;
        if (i == 48) {
            return 0;
        }
        int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
        int height = layout.getHeight();
        if (height >= measuredHeight) {
            return 0;
        }
        if (i == 80) {
            return measuredHeight - height;
        }
        return (measuredHeight - height) >> 1;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int right = getRight();
        int left = getLeft();
        int bottom = getBottom();
        int top = getTop();
        int width = getWidth();
        int height = getHeight();
        b bVar = this.oaQ;
        float f = -1.0f;
        if (bVar != null) {
            int i = ((bottom - top) - compoundPaddingBottom) - compoundPaddingTop;
            int i2 = ((right - left) - compoundPaddingRight) - compoundPaddingLeft;
            if (this.oaR && bVar.obh != null) {
                canvas.save();
                canvas.translate((float) (getPaddingLeft() + scrollX), (float) ((scrollY + compoundPaddingTop) + ((i - bVar.obq) / 2)));
                bVar.obh.draw(canvas);
                canvas.restore();
            }
            if (this.oaS && bVar.obi != null) {
                float measureText;
                canvas.save();
                if (this.oaL) {
                    measureText = this.gl.measureText(this.mText, 0, this.mText.length());
                    f = measureText;
                } else {
                    measureText = (float) Math.ceil((double) Layout.getDesiredWidth(this.oaw, this.gl));
                }
                canvas.translate((measureText + ((float) scrollX)) - ((float) getPaddingRight()), (float) ((compoundPaddingTop + scrollY) + ((i - bVar.obr) / 2)));
                bVar.obi.draw(canvas);
                canvas.restore();
            }
            if (this.oaT && bVar.obf != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.obo) / 2)), (float) (getPaddingTop() + scrollY));
                bVar.obf.draw(canvas);
                canvas.restore();
            }
            if (this.oaU && bVar.obg != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.obp) / 2)), (float) ((((scrollY + bottom) - top) - getPaddingBottom()) - bVar.obl));
                bVar.obg.draw(canvas);
                canvas.restore();
            }
        }
        this.gl.setColor(this.oas);
        this.gl.drawableState = getDrawableState();
        canvas.save();
        int extendedPaddingTop = getExtendedPaddingTop();
        Canvas canvas2 = canvas;
        float f2 = (float) (extendedPaddingTop + scrollY);
        canvas2.clipRect((float) (compoundPaddingLeft + scrollX), f2, (float) (((right - left) - compoundPaddingRight) + scrollX), (float) (((bottom - top) - getExtendedPaddingBottom()) + scrollY));
        compoundPaddingTop = 0;
        compoundPaddingBottom = 0;
        if ((this.tD & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            compoundPaddingTop = bCV();
            compoundPaddingBottom = bCV();
        }
        canvas.translate((float) compoundPaddingLeft, (float) (extendedPaddingTop + compoundPaddingTop));
        if (this.oaL) {
            float f3 = (float) (((height - (this.oaN.bottom - this.oaN.top)) / 2) - this.oaN.top);
            compoundPaddingBottom = 0;
            if ((this.tD & 7) != 3) {
                switch (this.tD & 7) {
                    case 1:
                        if (f == -1.0f) {
                            f = this.gl.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = ((int) (((float) (width - getPaddingRight())) - f)) / 2;
                        break;
                    case 5:
                        if (f == -1.0f) {
                            f = this.gl.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = (int) (((float) (width - getPaddingRight())) - f);
                        break;
                }
            }
            canvas.drawText(this.mText, 0, this.mText.length(), (float) compoundPaddingBottom, f3, this.gl);
        } else {
            if (this.oaz == null) {
                bCX();
            }
            this.oaz.draw(canvas, null, null, compoundPaddingBottom - compoundPaddingTop);
        }
        canvas.restore();
    }

    public void getFocusedRect(Rect rect) {
        if (this.oaz == null) {
            super.getFocusedRect(rect);
            return;
        }
        int selectionEnd = Selection.getSelectionEnd(this.mText);
        if (selectionEnd < 0) {
            super.getFocusedRect(rect);
            return;
        }
        int lineForOffset = this.oaz.getLineForOffset(selectionEnd);
        rect.top = this.oaz.getLineTop(lineForOffset);
        rect.bottom = this.oaz.getLineBottom(lineForOffset);
        rect.left = (int) this.oaz.getPrimaryHorizontal(selectionEnd);
        rect.right = rect.left + 1;
        lineForOffset = getCompoundPaddingLeft();
        selectionEnd = getExtendedPaddingTop();
        if ((this.tD & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            selectionEnd += bCV();
        }
        rect.offset(lineForOffset, selectionEnd);
    }

    public int getBaseline() {
        if (this.oaz == null) {
            return super.getBaseline();
        }
        int bCV;
        if ((this.tD & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            bCV = bCV();
        } else {
            bCV = 0;
        }
        return (bCV + getExtendedPaddingTop()) + this.oaz.getLineBaseline(0);
    }

    private void bCW() {
        if ((this.oaz instanceof BoringLayout) && this.oaK == null) {
            this.oaK = (BoringLayout) this.oaz;
        }
        this.oaz = null;
    }

    private void bCX() {
        int compoundPaddingLeft;
        if (this.oaG) {
            compoundPaddingLeft = (this.iN - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        } else {
            compoundPaddingLeft = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        }
        if (compoundPaddingLeft <= 0) {
            compoundPaddingLeft = 0;
        }
        dj(compoundPaddingLeft, compoundPaddingLeft);
    }

    private void dj(int i, int i2) {
        int i3;
        Alignment alignment;
        int i4;
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        switch (this.tD & 7) {
            case 1:
                alignment = Alignment.ALIGN_CENTER;
                break;
            case 5:
                alignment = Alignment.ALIGN_OPPOSITE;
                break;
            default:
                alignment = Alignment.ALIGN_NORMAL;
                break;
        }
        if (this.oav == null || this.oay != null) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (i4 != 0) {
            this.oaz = new StaticLayout(this.oaw, 0, this.oaw.length(), this.gl, i3, alignment, this.oaA, this.oaB, this.oaJ, this.oav, i2);
        } else {
            this.oaz = new StaticLayout(this.oaw, this.gl, i3, alignment, this.oaA, this.oaB, this.oaJ);
        }
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpec.getMode(i);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (size == 0) {
            setMeasuredDimension(size, this.oaM);
        } else if (this.oaL) {
            if (this.oaM == 0) {
                bCY();
            }
            setMeasuredDimension(size, this.oaM);
        } else {
            int i3;
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.oaG) {
                compoundPaddingLeft = this.iN - compoundPaddingLeft;
            } else {
                compoundPaddingLeft = size - compoundPaddingLeft;
            }
            if (this.oaz == null) {
                dj(compoundPaddingLeft, compoundPaddingLeft);
            } else {
                if (this.oaz.getWidth() != compoundPaddingLeft) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    dj(compoundPaddingLeft, compoundPaddingLeft);
                }
            }
            if (mode == 1073741824) {
                this.oaI = -1;
                compoundPaddingLeft = size2;
            } else {
                Layout layout = this.oaz;
                if (layout == null) {
                    compoundPaddingLeft = 0;
                } else {
                    i3 = layout.getLineCount();
                    int compoundPaddingBottom = getCompoundPaddingBottom() + getCompoundPaddingTop();
                    compoundPaddingLeft = layout.getLineTop(i3) + compoundPaddingBottom;
                    if (this.oaD != 1) {
                        compoundPaddingLeft = Math.min(compoundPaddingLeft, this.oaC);
                    } else if (i3 > this.oaC) {
                        compoundPaddingLeft = (layout.getLineTop(this.oaC) + layout.getBottomPadding()) + compoundPaddingBottom;
                        i3 = this.oaC;
                    }
                    if (this.oaF != 1) {
                        compoundPaddingLeft = Math.max(compoundPaddingLeft, this.oaE);
                    } else if (i3 < this.oaE) {
                        compoundPaddingLeft += (this.oaE - i3) * Math.round((((float) this.gl.getFontMetricsInt(null)) * this.oaA) + this.oaB);
                    }
                    compoundPaddingLeft = Math.max(compoundPaddingLeft, getSuggestedMinimumHeight());
                }
                this.oaI = compoundPaddingLeft;
                if (mode == Integer.MIN_VALUE) {
                    compoundPaddingLeft = Math.min(compoundPaddingLeft, size2);
                }
            }
            scrollTo(0, 0);
            setMeasuredDimension(size, compoundPaddingLeft);
        }
    }

    private void bCY() {
        if (this.oaM == 0) {
            this.oaM = (int) (Math.ceil((double) (this.oaN.descent - this.oaN.ascent)) + 2.0d);
        }
    }

    public final void bCo() {
        this.dYL = true;
        this.oaE = 1;
        this.oaC = 1;
        this.oaF = 1;
        this.oaD = 1;
        requestLayout();
        invalidate();
    }

    public final void setEllipsize(TruncateAt truncateAt) {
        this.oav = truncateAt;
        if (this.oaz != null) {
            bCW();
            requestLayout();
            invalidate();
        }
    }

    protected int computeHorizontalScrollRange() {
        if (this.oaz != null) {
            return this.oaz.getWidth();
        }
        return super.computeHorizontalScrollRange();
    }

    protected int computeVerticalScrollRange() {
        if (this.oaz != null) {
            return this.oaz.getHeight();
        }
        return super.computeVerticalScrollRange();
    }

    protected int computeVerticalScrollExtent() {
        return (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence contentDescription = getContentDescription();
        if (be.kS((String) contentDescription)) {
            contentDescription = this.mText;
        }
        accessibilityNodeInfo.setText(contentDescription);
    }
}

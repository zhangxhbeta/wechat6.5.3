package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RemoteViews.RemoteView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

@RemoteView
public class QImageView extends View {
    private static final a[] peb = new a[]{a.MATRIX, a.FIT_XY, a.FIT_START, a.FIT_CENTER, a.FIT_END, a.CENTER, a.CENTER_CROP, a.CENTER_INSIDE};
    private static final ScaleToFit[] pec = new ScaleToFit[]{ScaleToFit.FILL, ScaleToFit.START, ScaleToFit.CENTER, ScaleToFit.END};
    private int Cc;
    private boolean Wg;
    private int iN;
    private int lNf;
    private Context mContext;
    public Drawable mDrawable;
    public Matrix mMatrix;
    private Uri mUri;
    private ColorFilter mm;
    private int pdM;
    private a pdN;
    private boolean pdO;
    private boolean pdP;
    private int pdQ;
    private boolean pdR;
    private int[] pdS;
    private boolean pdT;
    private int pdU;
    private int pdV;
    private int pdW;
    private Matrix pdX;
    private final RectF pdY;
    private final RectF pdZ;
    private boolean pea;

    public enum a {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);
        
        final int pel;

        private a(int i) {
            this.pel = i;
        }
    }

    public QImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
        bKq();
    }

    public QImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pdM = 0;
        this.pdO = false;
        this.pdP = false;
        this.iN = Integer.MAX_VALUE;
        this.lNf = Integer.MAX_VALUE;
        this.Cc = WebView.NORMAL_MODE_ALPHA;
        this.pdQ = FileUtils.S_IRUSR;
        this.pdR = false;
        this.mDrawable = null;
        this.pdS = null;
        this.pdT = false;
        this.pdU = 0;
        this.pdX = null;
        this.pdY = new RectF();
        this.pdZ = new RectF();
        this.Wg = false;
        this.mContext = context;
        bKq();
        this.Wg = false;
        this.pdP = false;
        this.iN = Integer.MAX_VALUE;
        this.lNf = Integer.MAX_VALUE;
        this.pea = false;
    }

    private void bKq() {
        this.mMatrix = new Matrix();
        this.pdN = a.FIT_CENTER;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return this.mDrawable == drawable || super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.mDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected boolean onSetAlpha(int i) {
        if (getBackground() != null) {
            return false;
        }
        int i2 = (i >> 7) + i;
        if (this.pdQ == i2) {
            return true;
        }
        this.pdQ = i2;
        this.pdR = true;
        bKt();
        return true;
    }

    public final void setImageResource(int i) {
        if (this.mUri != null || this.pdM != i) {
            u(null);
            this.pdM = i;
            this.mUri = null;
            bKr();
            invalidate();
        }
    }

    @TargetApi(11)
    public void setLayerType(int i, Paint paint) {
        if (!(this.mDrawable instanceof PictureDrawable) || i == 1) {
            super.setLayerType(i, paint);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mDrawable != drawable) {
            this.pdM = 0;
            this.mUri = null;
            u(drawable);
            invalidate();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new BitmapDrawable(this.mContext.getResources(), bitmap));
    }

    private void bKr() {
        Drawable drawable = null;
        if (this.mDrawable == null) {
            Resources resources = getResources();
            if (resources != null) {
                if (this.pdM != 0) {
                    try {
                        drawable = resources.getDrawable(this.pdM);
                    } catch (Exception e) {
                        v.w("ImageView", "Unable to find resource: " + this.pdM, e);
                        this.mUri = drawable;
                    }
                } else if (this.mUri == null) {
                    return;
                }
                u(drawable);
            }
        }
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth < 0) {
                intrinsicWidth = this.pdV;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight < 0) {
                intrinsicHeight = this.pdW;
            }
            if (intrinsicWidth != this.pdV || intrinsicHeight != this.pdW) {
                this.pdV = intrinsicWidth;
                this.pdW = intrinsicHeight;
                requestLayout();
            }
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        } else if (this.pdN != aVar) {
            this.pdN = aVar;
            setWillNotCacheDrawing(this.pdN == a.CENTER);
            requestLayout();
            invalidate();
        }
    }

    public int[] onCreateDrawableState(int i) {
        if (this.pdS == null) {
            return super.onCreateDrawableState(i);
        }
        if (this.pdT) {
            return mergeDrawableStates(super.onCreateDrawableState(this.pdS.length + i), this.pdS);
        }
        return this.pdS;
    }

    private void u(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
            unscheduleDrawable(this.mDrawable);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            drawable.setLevel(this.pdU);
            this.pdV = drawable.getIntrinsicWidth();
            this.pdW = drawable.getIntrinsicHeight();
            bKt();
            bKs();
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        bKr();
        float f = 0.0f;
        Object obj = null;
        Object obj2;
        if (this.mDrawable == null) {
            this.pdV = -1;
            this.pdW = -1;
            i3 = 0;
            obj2 = null;
            i4 = 0;
        } else {
            i5 = this.pdV;
            i3 = this.pdW;
            if (i5 <= 0) {
                i5 = 1;
            }
            if (i3 <= 0) {
                i3 = 1;
            }
            if (this.pdP) {
                i4 = MeasureSpec.getMode(i);
                int mode = MeasureSpec.getMode(i2);
                obj = i4 != 1073741824 ? 1 : null;
                Object obj3 = mode != 1073741824 ? 1 : null;
                f = ((float) i5) / ((float) i3);
                i6 = i5;
                obj2 = obj3;
                i4 = i3;
                i3 = i6;
            } else {
                i6 = i5;
                obj2 = null;
                i4 = i3;
                i3 = i6;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (obj == null && r4 == null) {
            i4 += paddingTop + paddingBottom;
            i3 = Math.max(i3 + (paddingLeft + paddingRight), getSuggestedMinimumWidth());
            i5 = Math.max(i4, getSuggestedMinimumHeight());
            i4 = resolveSize(i3, i);
            i3 = resolveSize(i5, i2);
        } else {
            i3 = V((i3 + paddingLeft) + paddingRight, this.iN, i);
            i4 = V((i4 + paddingTop) + paddingBottom, this.lNf, i2);
            if (f == 0.0f || ((double) Math.abs((((float) ((i3 - paddingLeft) - paddingRight)) / ((float) ((i4 - paddingTop) - paddingBottom))) - f)) <= 1.0E-7d) {
                i6 = i4;
                i4 = i3;
                i3 = i6;
            } else {
                int i7;
                Object obj4;
                if (obj != null) {
                    i7 = (((int) (((float) ((i4 - paddingTop) - paddingBottom)) * f)) + paddingLeft) + paddingRight;
                    if (i7 <= i3) {
                        obj4 = 1;
                        if (obj4 == null && r4 != null) {
                            i3 = (((int) (((float) ((i7 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                            if (i3 <= i4) {
                                i4 = i7;
                            }
                        }
                        i3 = i4;
                        i4 = i7;
                    }
                }
                i7 = i3;
                obj4 = null;
                i3 = (((int) (((float) ((i7 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                if (i3 <= i4) {
                    i4 = i7;
                }
                i3 = i4;
                i4 = i7;
            }
        }
        setMeasuredDimension(i4, i3);
    }

    private static int V(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(Math.min(i, size), i2);
            case 0:
                return Math.min(i, i2);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.pdO = true;
        bKs();
    }

    private void bKs() {
        float f = 0.0f;
        if (this.mDrawable != null && this.pdO) {
            int i = this.pdV;
            int i2 = this.pdW;
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int i3 = ((i < 0 || width == i) && (i2 < 0 || height == i2)) ? 1 : 0;
            if (i <= 0 || i2 <= 0 || a.FIT_XY == this.pdN) {
                this.mDrawable.setBounds(0, 0, width, height);
                this.pdX = null;
                return;
            }
            this.mDrawable.setBounds(0, 0, i, i2);
            if (a.MATRIX == this.pdN) {
                if (this.mMatrix.isIdentity()) {
                    this.pdX = null;
                } else {
                    this.pdX = this.mMatrix;
                }
            } else if (i3 != 0) {
                this.pdX = null;
            } else if (a.CENTER == this.pdN) {
                this.pdX = this.mMatrix;
                this.pdX.setTranslate((float) ((int) ((((float) (width - i)) * 0.5f) + 0.5f)), (float) ((int) ((((float) (height - i2)) * 0.5f) + 0.5f)));
            } else if (a.CENTER_CROP == this.pdN) {
                this.pdX = this.mMatrix;
                if (i * height > width * i2) {
                    r0 = ((float) height) / ((float) i2);
                    r2 = (((float) width) - (((float) i) * r0)) * 0.5f;
                } else {
                    r0 = ((float) width) / ((float) i);
                    r2 = 0.0f;
                    f = (((float) height) - (((float) i2) * r0)) * 0.5f;
                }
                this.pdX.setScale(r0, r0);
                this.pdX.postTranslate((float) ((int) (r2 + 0.5f)), (float) ((int) (f + 0.5f)));
            } else if (a.CENTER_INSIDE == this.pdN) {
                this.pdX = this.mMatrix;
                if (i > width || i2 > height) {
                    r0 = Math.min(((float) width) / ((float) i), ((float) height) / ((float) i2));
                } else {
                    r0 = 1.0f;
                }
                f = (float) ((int) (((((float) width) - (((float) i) * r0)) * 0.5f) + 0.5f));
                r2 = (float) ((int) (((((float) height) - (((float) i2) * r0)) * 0.5f) + 0.5f));
                this.pdX.setScale(r0, r0);
                this.pdX.postTranslate(f, r2);
            } else {
                this.pdY.set(0.0f, 0.0f, (float) i, (float) i2);
                this.pdZ.set(0.0f, 0.0f, (float) width, (float) height);
                this.pdX = this.mMatrix;
                this.pdX.setRectToRect(this.pdY, this.pdZ, pec[this.pdN.pel - 1]);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        super.onDraw(canvas);
        if (this.mDrawable != null && this.pdV != 0 && this.pdW != 0) {
            if (this.pdX == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
                this.mDrawable.draw(canvas);
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            if (this.pea) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
            }
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            if (this.pdX != null) {
                canvas.concat(this.pdX);
            }
            this.mDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    public int getBaseline() {
        return this.Wg ? getMeasuredHeight() : -1;
    }

    public final void setAlpha(int i) {
        int i2 = i & WebView.NORMAL_MODE_ALPHA;
        if (this.Cc != i2) {
            this.Cc = i2;
            this.pdR = true;
            bKt();
            invalidate();
        }
    }

    private void bKt() {
        if (this.mDrawable != null && this.pdR) {
            this.mDrawable = this.mDrawable.mutate();
            this.mDrawable.setColorFilter(this.mm);
            this.mDrawable.setAlpha((this.Cc * this.pdQ) >> 8);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}

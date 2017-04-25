package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.tencent.mm.R;

public class CircularImageView extends ImageView {
    private static final String TAG = CircularImageView.class.getSimpleName();
    private Paint evR;
    private boolean gxa;
    private int hrT;
    private boolean jAF;
    private boolean jAG;
    private int jAH;
    private int jAI;
    private boolean jAJ;
    private float jAK;
    private float jAL;
    private float jAM;
    private BitmapShader jAN;
    private Bitmap jAO;
    private Paint jAP;
    private Paint jAQ;
    private ColorFilter jAR;
    private int shadowColor;

    public CircularImageView(Context context) {
        this(context, null, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i) {
        int dimensionPixelOffset;
        float f = 0.0f;
        super(context, attributeSet, i);
        this.evR = new Paint();
        this.evR.setAntiAlias(true);
        this.jAP = new Paint();
        this.jAP.setAntiAlias(true);
        this.jAP.setStyle(Style.STROKE);
        this.jAQ = new Paint();
        this.jAQ.setAntiAlias(true);
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aOY, i, 0);
        this.jAF = obtainStyledAttributes.getBoolean(0, false);
        this.jAG = obtainStyledAttributes.getBoolean(3, false);
        this.jAJ = obtainStyledAttributes.getBoolean(7, false);
        if (this.jAF) {
            dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(2, (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f));
            this.hrT = dimensionPixelOffset;
            if (this.jAP != null) {
                this.jAP.setStrokeWidth((float) dimensionPixelOffset);
            }
            requestLayout();
            invalidate();
            dimensionPixelOffset = obtainStyledAttributes.getColor(1, -1);
            if (this.jAP != null) {
                this.jAP.setColor(dimensionPixelOffset);
            }
            invalidate();
        }
        if (this.jAG) {
            dimensionPixelOffset = (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
            this.jAR = new PorterDuffColorFilter(obtainStyledAttributes.getColor(4, 0), Mode.SRC_ATOP);
            invalidate();
            this.jAI = obtainStyledAttributes.getDimensionPixelOffset(6, dimensionPixelOffset);
            requestLayout();
            invalidate();
            dimensionPixelOffset = obtainStyledAttributes.getColor(5, -16776961);
            if (this.jAQ != null) {
                this.jAQ.setColor(dimensionPixelOffset);
            }
            invalidate();
        }
        if (this.jAJ) {
            this.jAK = obtainStyledAttributes.getFloat(8, 4.0f);
            this.jAL = obtainStyledAttributes.getFloat(9, 0.0f);
            this.jAM = obtainStyledAttributes.getFloat(10, 2.0f);
            this.shadowColor = obtainStyledAttributes.getColor(11, -16777216);
            this.jAJ = true;
            if (this.jAJ) {
                f = this.jAK;
            }
            this.jAP.setShadowLayer(f, this.jAL, this.jAM, this.shadowColor);
            this.jAQ.setShadowLayer(f, this.jAL, this.jAM, this.shadowColor);
        }
        obtainStyledAttributes.recycle();
    }

    public void onDraw(Canvas canvas) {
        int i = 0;
        if (this.jAO != null && this.jAO.getHeight() != 0 && this.jAO.getWidth() != 0) {
            int i2 = this.jAH;
            this.jAH = getWidth() < getHeight() ? getWidth() : getHeight();
            if (i2 != this.jAH) {
                aUh();
            }
            this.evR.setShader(this.jAN);
            int i3 = this.jAH / 2;
            if (this.jAG && this.gxa) {
                i = this.jAI;
                i3 = (this.jAH - (i * 2)) / 2;
                this.evR.setColorFilter(this.jAR);
                canvas.drawCircle((float) (i3 + i), (float) (i3 + i), ((float) (((this.jAH - (i * 2)) / 2) + i)) - 4.0f, this.jAQ);
            } else if (this.jAF) {
                int i4 = this.hrT;
                int i5 = (this.jAH - (i4 * 2)) / 2;
                this.evR.setColorFilter(null);
                canvas.drawArc(new RectF((float) ((i4 / 2) + 0), (float) ((i4 / 2) + 0), (float) (this.jAH - (i4 / 2)), (float) (this.jAH - (i4 / 2))), 360.0f, 360.0f, false, this.jAP);
                i3 = i5;
                i = i4;
            } else {
                this.evR.setColorFilter(null);
            }
            canvas.drawCircle((float) (i3 + i), (float) (i3 + i), (float) ((this.jAH - (i * 2)) / 2), this.evR);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.gxa = true;
                    break;
                case 1:
                case 3:
                case 4:
                case 8:
                    this.gxa = false;
                    break;
            }
            invalidate();
            return super.dispatchTouchEvent(motionEvent);
        }
        this.gxa = false;
        return super.onTouchEvent(motionEvent);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.jAO = r(getDrawable());
        if (this.jAH > 0) {
            aUh();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.jAO = r(getDrawable());
        if (this.jAH > 0) {
            aUh();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.jAO = r(getDrawable());
        if (this.jAH > 0) {
            aUh();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.jAO = bitmap;
        if (this.jAH > 0) {
            aUh();
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (!(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            size = this.jAH;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        if (!(mode2 == 1073741824 || mode2 == Integer.MIN_VALUE)) {
            mode = this.jAH;
        }
        setMeasuredDimension(size, mode + 2);
    }

    private static Bitmap r(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private void aUh() {
        if (this.jAO != null) {
            this.jAN = new BitmapShader(this.jAO, TileMode.CLAMP, TileMode.CLAMP);
            if (this.jAH != this.jAO.getWidth() || this.jAH != this.jAO.getHeight()) {
                Matrix matrix = new Matrix();
                float width = ((float) this.jAH) / ((float) this.jAO.getWidth());
                matrix.setScale(width, width);
                this.jAN.setLocalMatrix(matrix);
            }
        }
    }

    public boolean isSelected() {
        return this.gxa;
    }
}

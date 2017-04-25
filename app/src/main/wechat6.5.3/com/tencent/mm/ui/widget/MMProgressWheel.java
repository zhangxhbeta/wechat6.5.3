package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.tencent.mm.bi.a.g;

public class MMProgressWheel extends View {
    private static final String TAG = MMProgressWheel.class.getSimpleName();
    private float nUN = 0.0f;
    private final int pcC = 16;
    private final int pcD = 270;
    private final long pcE = 200;
    private int pcF = 28;
    private int pcG = 4;
    private int pcH = 4;
    private boolean pcI = false;
    private double pcJ = 0.0d;
    private double pcK = 460.0d;
    private float pcL = 0.0f;
    private boolean pcM = true;
    private long pcN = 0;
    private int pcO = -1442840576;
    private int pcP = 16777215;
    private Paint pcQ = new Paint();
    private Paint pcR = new Paint();
    private RectF pcS = new RectF();
    private float pcT = 230.0f;
    private long pcU = 0;
    private boolean pcV;
    private float pcW = 0.0f;
    private boolean pcX = false;
    private a pcY;
    private boolean pcZ;

    static class WheelSavedState extends BaseSavedState {
        public static final Creator<WheelSavedState> CREATOR = new Creator<WheelSavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WheelSavedState[i];
            }
        };
        float nUN;
        int pcF;
        int pcG;
        int pcH;
        boolean pcI;
        int pcO;
        int pcP;
        float pcT;
        boolean pcV;
        float pcW;
        boolean pcX;

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            super(parcel);
            this.nUN = parcel.readFloat();
            this.pcW = parcel.readFloat();
            this.pcX = parcel.readByte() != (byte) 0;
            this.pcT = parcel.readFloat();
            this.pcG = parcel.readInt();
            this.pcO = parcel.readInt();
            this.pcH = parcel.readInt();
            this.pcP = parcel.readInt();
            this.pcF = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.pcV = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.pcI = z2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.nUN);
            parcel.writeFloat(this.pcW);
            parcel.writeByte((byte) (this.pcX ? 1 : 0));
            parcel.writeFloat(this.pcT);
            parcel.writeInt(this.pcG);
            parcel.writeInt(this.pcO);
            parcel.writeInt(this.pcH);
            parcel.writeInt(this.pcP);
            parcel.writeInt(this.pcF);
            if (this.pcV) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            if (!this.pcI) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
        }
    }

    public interface a {
    }

    public MMProgressWheel(Context context, AttributeSet attributeSet) {
        boolean z = true;
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.aPp);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.pcG = (int) TypedValue.applyDimension(1, (float) this.pcG, displayMetrics);
        this.pcH = (int) TypedValue.applyDimension(1, (float) this.pcH, displayMetrics);
        this.pcF = (int) TypedValue.applyDimension(1, (float) this.pcF, displayMetrics);
        this.pcF = (int) obtainStyledAttributes.getDimension(g.pfN, (float) this.pcF);
        this.pcI = obtainStyledAttributes.getBoolean(g.pfO, false);
        this.pcG = (int) obtainStyledAttributes.getDimension(g.pfM, (float) this.pcG);
        this.pcH = (int) obtainStyledAttributes.getDimension(g.pfS, (float) this.pcH);
        this.pcT = obtainStyledAttributes.getFloat(g.pfT, this.pcT / 360.0f) * 360.0f;
        this.pcK = (double) obtainStyledAttributes.getInt(g.pfL, (int) this.pcK);
        this.pcO = obtainStyledAttributes.getColor(g.pfK, this.pcO);
        this.pcP = obtainStyledAttributes.getColor(g.pfR, this.pcP);
        this.pcV = obtainStyledAttributes.getBoolean(g.pfP, false);
        if (obtainStyledAttributes.getBoolean(g.pfQ, false)) {
            this.pcU = SystemClock.uptimeMillis();
            this.pcX = true;
            invalidate();
        }
        obtainStyledAttributes.recycle();
        if ((VERSION.SDK_INT >= 17 ? Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) : System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f)) == 0.0f) {
            z = false;
        }
        this.pcZ = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = (this.pcF + getPaddingLeft()) + getPaddingRight();
        int paddingTop = (this.pcF + getPaddingTop()) + getPaddingBottom();
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(size, paddingTop);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.pcI) {
            this.pcS = new RectF((float) (paddingLeft + this.pcG), (float) (paddingTop + this.pcG), (float) ((i - paddingRight) - this.pcG), (float) ((i2 - paddingBottom) - this.pcG));
        } else {
            int min = Math.min(Math.min((i - paddingLeft) - paddingRight, (i2 - paddingBottom) - paddingTop), (this.pcF * 2) - (this.pcG * 2));
            paddingLeft += (((i - paddingLeft) - paddingRight) - min) / 2;
            paddingTop += (((i2 - paddingTop) - paddingBottom) - min) / 2;
            this.pcS = new RectF((float) (this.pcG + paddingLeft), (float) (this.pcG + paddingTop), (float) ((paddingLeft + min) - this.pcG), (float) ((paddingTop + min) - this.pcG));
        }
        this.pcQ.setColor(this.pcO);
        this.pcQ.setAntiAlias(true);
        this.pcQ.setStyle(Style.STROKE);
        this.pcQ.setStrokeWidth((float) this.pcG);
        this.pcR.setColor(this.pcP);
        this.pcR.setAntiAlias(true);
        this.pcR.setStyle(Style.STROKE);
        this.pcR.setStrokeWidth((float) this.pcH);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        boolean z = true;
        super.onDraw(canvas);
        canvas.drawArc(this.pcS, 360.0f, 360.0f, false, this.pcR);
        if (this.pcZ) {
            float f;
            float cos;
            if (this.pcX) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.pcU;
                f = (((float) uptimeMillis) * this.pcT) / 1000.0f;
                if (this.pcN >= 200) {
                    this.pcJ = ((double) uptimeMillis) + this.pcJ;
                    if (this.pcJ > this.pcK) {
                        this.pcJ -= this.pcK;
                        this.pcN = 0;
                        this.pcM = !this.pcM;
                    }
                    cos = (((float) Math.cos(((this.pcJ / this.pcK) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
                    if (this.pcM) {
                        this.pcL = cos * 254.0f;
                    } else {
                        cos = (1.0f - cos) * 254.0f;
                        this.nUN += this.pcL - cos;
                        this.pcL = cos;
                    }
                } else {
                    this.pcN = uptimeMillis + this.pcN;
                }
                this.nUN += f;
                if (this.nUN > 360.0f) {
                    this.nUN -= 360.0f;
                }
                this.pcU = SystemClock.uptimeMillis();
                float f2 = this.nUN - 90.0f;
                f = 16.0f + this.pcL;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f = 135.0f;
                }
                canvas.drawArc(this.pcS, f2, f, false, this.pcQ);
            } else {
                float f3;
                cos = this.nUN;
                if (this.nUN != this.pcW) {
                    this.nUN = Math.min(((((float) (SystemClock.uptimeMillis() - this.pcU)) / 1000.0f) * this.pcT) + this.nUN, this.pcW);
                    this.pcU = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                if (!(cos == this.nUN || this.pcY == null)) {
                    Math.round((this.nUN * 100.0f) / 360.0f);
                }
                cos = this.nUN;
                if (this.pcV) {
                    f3 = 0.0f;
                } else {
                    cos = ((float) (1.0d - Math.pow((double) (1.0f - (this.nUN / 360.0f)), 2.0d))) * 360.0f;
                    f3 = ((float) (1.0d - Math.pow((double) (1.0f - (this.nUN / 360.0f)), 4.0d))) * 360.0f;
                }
                if (isInEditMode()) {
                    f = 360.0f;
                } else {
                    f = cos;
                }
                canvas.drawArc(this.pcS, f3 - 90.0f, f, false, this.pcQ);
            }
            if (z) {
                invalidate();
            }
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.pcU = SystemClock.uptimeMillis();
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.nUN = this.nUN;
        wheelSavedState.pcW = this.pcW;
        wheelSavedState.pcX = this.pcX;
        wheelSavedState.pcT = this.pcT;
        wheelSavedState.pcG = this.pcG;
        wheelSavedState.pcO = this.pcO;
        wheelSavedState.pcH = this.pcH;
        wheelSavedState.pcP = this.pcP;
        wheelSavedState.pcF = this.pcF;
        wheelSavedState.pcV = this.pcV;
        wheelSavedState.pcI = this.pcI;
        return wheelSavedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof WheelSavedState) {
            WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
            super.onRestoreInstanceState(wheelSavedState.getSuperState());
            this.nUN = wheelSavedState.nUN;
            this.pcW = wheelSavedState.pcW;
            this.pcX = wheelSavedState.pcX;
            this.pcT = wheelSavedState.pcT;
            this.pcG = wheelSavedState.pcG;
            this.pcO = wheelSavedState.pcO;
            this.pcH = wheelSavedState.pcH;
            this.pcP = wheelSavedState.pcP;
            this.pcF = wheelSavedState.pcF;
            this.pcV = wheelSavedState.pcV;
            this.pcI = wheelSavedState.pcI;
            this.pcU = SystemClock.uptimeMillis();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}

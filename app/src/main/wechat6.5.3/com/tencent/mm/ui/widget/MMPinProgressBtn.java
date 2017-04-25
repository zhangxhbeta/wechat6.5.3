package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.CompoundButton;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.v;

public class MMPinProgressBtn extends CompoundButton {
    private Paint Cd;
    private Runnable pcA = new Runnable(this) {
        final /* synthetic */ MMPinProgressBtn pcB;

        {
            this.pcB = r1;
        }

        public final void run() {
            if (this.pcB.getVisibility() != 0) {
                v.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
                return;
            }
            MMPinProgressBtn.a(this.pcB);
            if (this.pcB.rT >= this.pcB.pcv) {
                MMPinProgressBtn.d(this.pcB);
                v.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
                return;
            }
            this.pcB.invalidate();
            this.pcB.postDelayed(this.pcB.pcA, 200);
        }
    };
    public int pcv;
    private Paint pcw;
    private RectF pcx = new RectF();
    private int pcy;
    private final float pcz = 4.0f;
    private int rT;
    private int style;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private int pcv;
        private int rT;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.rT = parcel.readInt();
            this.pcv = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.rT);
            parcel.writeInt(this.pcv);
        }
    }

    static /* synthetic */ int a(MMPinProgressBtn mMPinProgressBtn) {
        int i = mMPinProgressBtn.rT + 1;
        mMPinProgressBtn.rT = i;
        return i;
    }

    static /* synthetic */ int d(MMPinProgressBtn mMPinProgressBtn) {
        int i = mMPinProgressBtn.rT - 1;
        mMPinProgressBtn.rT = i;
        return i;
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet, 0);
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        this.pcv = 100;
        this.rT = 0;
        Resources resources = getResources();
        int color = resources.getColor(2131689920);
        int color2 = resources.getColor(2131689921);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPo, i, 0);
            this.pcv = obtainStyledAttributes.getInteger(2, this.pcv);
            this.rT = obtainStyledAttributes.getInteger(1, this.rT);
            color = obtainStyledAttributes.getColor(3, color);
            color2 = obtainStyledAttributes.getColor(4, color2);
            this.style = obtainStyledAttributes.getInteger(6, 0);
            this.pcy = obtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelSize(2131493545));
            obtainStyledAttributes.recycle();
        }
        this.Cd = new Paint();
        this.Cd.setColor(color);
        this.Cd.setStyle(Style.STROKE);
        this.Cd.setStrokeWidth(4.0f);
        this.Cd.setAntiAlias(true);
        this.pcw = new Paint();
        this.pcw.setColor(color2);
        this.pcw.setAntiAlias(true);
        setClickable(false);
    }

    public final void setMax(int i) {
        this.pcv = Math.max(0, i);
        invalidate();
    }

    public final void setProgress(int i) {
        this.rT = Math.max(0, i);
        this.rT = Math.min(i, this.pcv);
        invalidate();
    }

    public final void bKj() {
        removeCallbacks(this.pcA);
        post(this.pcA);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(this.pcy, i), resolveSize(this.pcy, i2));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.pcx.set(2.0f, 2.0f, ((float) this.pcy) - 2.0f, ((float) this.pcy) - 2.0f);
        this.pcx.offset((float) ((getWidth() - this.pcy) / 2), (float) ((getHeight() - this.pcy) / 2));
        canvas.drawArc(this.pcx, 0.0f, 360.0f, true, this.Cd);
        switch (this.style) {
            case 0:
                this.pcx.set(8.0f, 8.0f, ((float) this.pcy) - 8.0f, ((float) this.pcy) - 8.0f);
                this.pcx.offset((float) ((getWidth() - this.pcy) / 2), (float) ((getHeight() - this.pcy) / 2));
                canvas.drawArc(this.pcx, -90.0f, (float) ((this.rT * 360) / this.pcv), true, this.pcw);
                return;
            case 1:
                this.pcx.set(2.0f, 2.0f, ((float) this.pcy) - 2.0f, ((float) this.pcy) - 2.0f);
                this.pcx.offset((float) ((getWidth() - this.pcy) / 2), (float) ((getHeight() - this.pcy) / 2));
                canvas.drawArc(this.pcx, 270.0f, (float) (((this.rT * 360) / this.pcv) - 360), true, this.pcw);
                return;
            default:
                return;
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (!isSaveEnabled()) {
            return onSaveInstanceState;
        }
        Parcelable savedState = new SavedState(onSaveInstanceState);
        savedState.pcv = this.pcv;
        savedState.rT = this.rT;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.pcv = savedState.pcv;
            this.rT = savedState.rT;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}

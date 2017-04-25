package com.tencent.mm.plugin.gesture.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView extends View {
    private static Bitmap gBR = null;
    private static Bitmap gBS = null;
    private static Bitmap gBT = null;
    private static Bitmap gBU = null;
    private int fEG;
    private Paint gBB = new Paint();
    private Paint gBC = new Paint();
    private Path gBD = new Path();
    private Matrix gBE = new Matrix();
    private Rect gBF = new Rect();
    private Rect gBG = new Rect();
    private ArrayList<com.tencent.mm.plugin.gesture.a.c> gBH = new ArrayList(9);
    private boolean[][] gBI = ((boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{3, 3}));
    private int gBJ = c.gCj;
    private int gBK = 6;
    private int gBL = 200;
    private float gBM = 0.66f;
    private boolean gBN = false;
    private boolean gBO = true;
    public boolean gBP = false;
    private b gBQ;
    private float gBV;
    private float gBW;
    private boolean gBX;
    private long gBY;
    private float gBZ;
    private float gCa;
    public a gCb;
    private int tK;
    private int tL;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean gBN;
        boolean gBO;
        boolean gBP;
        String gCh;
        int gCi;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.gCh = parcel.readString();
            this.gCi = parcel.readInt();
            this.gBO = ((Boolean) parcel.readValue(null)).booleanValue();
            this.gBP = ((Boolean) parcel.readValue(null)).booleanValue();
            this.gBN = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3) {
            super(parcelable);
            this.gCh = str;
            this.gCi = i;
            this.gBO = z;
            this.gBP = z2;
            this.gBN = z3;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.gCh);
            parcel.writeInt(this.gCi);
            parcel.writeValue(Boolean.valueOf(this.gBO));
            parcel.writeValue(Boolean.valueOf(this.gBP));
            parcel.writeValue(Boolean.valueOf(this.gBN));
        }
    }

    public interface a {
        void a(PatternLockView patternLockView);

        void a(PatternLockView patternLockView, List<com.tencent.mm.plugin.gesture.a.c> list);
    }

    public enum b {
        Correct,
        Wrong,
        Animate
    }

    public enum c {
        ;

        static {
            gCj = 1;
            gCk = 2;
            gCl = new int[]{gCj, gCk};
        }
    }

    public PatternLockView(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        if (isInEditMode()) {
            i = -1;
        } else {
            i = getResources().getColor(2131689763);
        }
        this.fEG = i;
        this.gBQ = b.Correct;
        this.gBV = -1.0f;
        this.gBW = -1.0f;
        this.gBX = false;
        this.gBY = 0;
        this.tK = 0;
        this.tL = 0;
        this.gBZ = 0.0f;
        this.gCa = 0.0f;
        this.gCb = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPF);
        this.gBO = obtainStyledAttributes.getBoolean(4, this.gBO);
        this.gBL = obtainStyledAttributes.getInt(1, this.gBL);
        this.gBK = obtainStyledAttributes.getInt(2, this.gBK);
        this.gBN = obtainStyledAttributes.getBoolean(3, this.gBN);
        switch (obtainStyledAttributes.getInt(0, this.gBJ - 1)) {
            case 0:
                this.gBJ = c.gCj;
                break;
            case 1:
                this.gBJ = c.gCk;
                break;
            default:
                this.gBJ = c.gCj;
                break;
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
        this.gBC.setStyle(Style.STROKE);
        this.gBC.setStrokeJoin(Join.ROUND);
        this.gBC.setStrokeCap(Cap.ROUND);
        this.gBC.setAntiAlias(true);
        this.gBC.setDither(false);
        this.gBC.setAlpha(this.gBL);
        this.gBB.setAntiAlias(true);
        this.gBB.setDither(true);
        if (!isInEditMode()) {
            if (gBR == null) {
                gBR = p(com.tencent.mm.bd.a.a(getContext(), 2130838350));
                Bitmap p = p(com.tencent.mm.bd.a.a(getContext(), 2130838351));
                gBS = p;
                gBT = p;
                gBU = p(com.tencent.mm.bd.a.a(getContext(), 2130838352));
            }
            this.gBK = (int) (((float) this.gBK) * d.bsM().density);
            Bitmap[] bitmapArr = new Bitmap[]{gBR, gBS, gBT, gBU};
            for (i = 0; i < 4; i++) {
                Bitmap bitmap = bitmapArr[i];
                this.tK = Math.max(bitmap.getWidth(), this.tK);
                this.tL = Math.max(bitmap.getHeight(), this.tL);
            }
        }
    }

    private static Bitmap p(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static String aB(List<com.tencent.mm.plugin.gesture.a.c> list) {
        if (list == null) {
            throw new IllegalArgumentException("pattern is null");
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            com.tencent.mm.plugin.gesture.a.c cVar = (com.tencent.mm.plugin.gesture.a.c) list.get(i);
            bArr[i] = (byte) (cVar.fkR + (cVar.fkQ * 3));
        }
        return new String(bArr);
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), aB(this.gBH), this.gBQ.ordinal(), this.gBO, this.gBP, this.gBN);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        b bVar = b.Correct;
        String str = savedState.gCh;
        if (str == null) {
            throw new IllegalArgumentException("Serialized pattern is null");
        }
        List arrayList = new ArrayList();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            arrayList.add(com.tencent.mm.plugin.gesture.a.c.bJ(b / 3, b % 3));
        }
        a(bVar, arrayList);
        this.gBQ = b.values()[savedState.gCi];
        this.gBO = savedState.gBO;
        this.gBP = savedState.gBP;
        this.gBN = savedState.gBN;
    }

    protected int getSuggestedMinimumWidth() {
        return (int) ((3.0d * ((double) ((float) this.tK))) / ((double) getResources().getDisplayMetrics().density));
    }

    protected int getSuggestedMinimumHeight() {
        return (int) ((3.0d * ((double) ((float) this.tL))) / ((double) getResources().getDisplayMetrics().density));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.gBZ = ((float) ((i - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.gCa = ((float) ((i2 - getPaddingTop()) - getPaddingBottom())) / 3.0f;
    }

    private static int bK(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                return Math.max(size, i2);
            case 0:
                return i2;
            default:
                return size;
        }
    }

    protected void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int bK = bK(i, suggestedMinimumWidth);
        suggestedMinimumWidth = bK(i2, suggestedMinimumHeight);
        if (this.gBJ == c.gCj) {
            suggestedMinimumWidth = Math.min(bK, suggestedMinimumWidth);
            bK = suggestedMinimumWidth;
        }
        setMeasuredDimension(bK, suggestedMinimumWidth);
    }

    protected void onDraw(Canvas canvas) {
        int elapsedRealtime;
        int i;
        com.tencent.mm.plugin.gesture.a.c cVar;
        Object obj;
        ArrayList arrayList = this.gBH;
        int size = arrayList.size();
        boolean[][] zArr = this.gBI;
        if (this.gBQ == b.Animate) {
            elapsedRealtime = ((int) (SystemClock.elapsedRealtime() - this.gBY)) % ((size + 1) * 700);
            i = elapsedRealtime / 700;
            att();
            for (int i2 = 0; i2 < i; i2++) {
                cVar = (com.tencent.mm.plugin.gesture.a.c) arrayList.get(i2);
                zArr[cVar.fkQ][cVar.fkR] = true;
            }
            obj = (i <= 0 || i >= size) ? null : 1;
            if (obj != null) {
                float f = ((float) (elapsedRealtime % 700)) / 700.0f;
                cVar = (com.tencent.mm.plugin.gesture.a.c) arrayList.get(i - 1);
                float lK = lK(cVar.fkR);
                float lL = lL(cVar.fkQ);
                cVar = (com.tencent.mm.plugin.gesture.a.c) arrayList.get(i);
                float lK2 = (lK(cVar.fkR) - lK) * f;
                float lL2 = (lL(cVar.fkQ) - lL) * f;
                this.gBV = lK + lK2;
                this.gBW = lL2 + lL;
            }
            invalidate();
        }
        this.gBC.setColor(this.fEG);
        this.gBC.setStrokeWidth((float) this.gBK);
        Path path = this.gBD;
        path.rewind();
        obj = (this.gBO || this.gBQ == b.Wrong) ? 1 : null;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        float f2 = this.gBZ;
        float f3 = this.gCa;
        boolean z = (this.gBB.getFlags() & 2) != 0;
        this.gBB.setFilterBitmap(true);
        for (i = 0; i < 3; i++) {
            float f4 = (((float) i) * f3) + ((float) paddingTop);
            for (elapsedRealtime = 0; elapsedRealtime < 3; elapsedRealtime++) {
                float f5 = ((float) paddingLeft) + (((float) elapsedRealtime) * f2);
                if (!zArr[i][elapsedRealtime]) {
                    a(canvas, (int) f5, (int) f4, zArr[i][elapsedRealtime]);
                }
            }
        }
        if (obj != null) {
            Object obj2 = null;
            for (elapsedRealtime = 0; elapsedRealtime < size; elapsedRealtime++) {
                cVar = (com.tencent.mm.plugin.gesture.a.c) arrayList.get(elapsedRealtime);
                if (!zArr[cVar.fkQ][cVar.fkR]) {
                    break;
                }
                obj2 = 1;
                f4 = lK(cVar.fkR);
                lL2 = lL(cVar.fkQ);
                if (elapsedRealtime == 0) {
                    path.moveTo(f4, lL2);
                } else {
                    path.lineTo(f4, lL2);
                }
            }
            if ((this.gBX || this.gBQ == b.Animate) && r9 != null) {
                path.lineTo(this.gBV, this.gBW);
            }
            canvas.drawPath(path, this.gBC);
        }
        for (elapsedRealtime = 0; elapsedRealtime < 3; elapsedRealtime++) {
            lK2 = (((float) elapsedRealtime) * f3) + ((float) paddingTop);
            for (int i3 = 0; i3 < 3; i3++) {
                float f6 = ((float) paddingLeft) + (((float) i3) * f2);
                if (zArr[elapsedRealtime][i3]) {
                    a(canvas, (int) f6, (int) lK2, zArr[elapsedRealtime][i3]);
                }
            }
        }
        this.gBB.setFilterBitmap(z);
    }

    private void a(Canvas canvas, int i, int i2, boolean z) {
        Bitmap bitmap;
        if (!z || (!this.gBO && this.gBQ != b.Wrong)) {
            bitmap = gBR;
        } else if (this.gBX) {
            bitmap = gBS;
        } else if (this.gBQ == b.Wrong) {
            bitmap = gBU;
        } else if (this.gBQ == b.Correct || this.gBQ == b.Animate) {
            bitmap = gBT;
        } else {
            throw new IllegalStateException("unknown display mode " + this.gBQ);
        }
        int i3 = this.tK;
        int i4 = this.tL;
        i3 = (int) ((this.gBZ - ((float) i3)) * 0.5f);
        i4 = (int) ((this.gCa - ((float) i4)) * 0.5f);
        float f = getResources().getDisplayMetrics().density;
        float min = Math.min((this.gBZ - (33.0f * f)) / ((float) this.tK), 1.0f);
        f = Math.min((this.gCa - (f * 33.0f)) / ((float) this.tL), 1.0f);
        this.gBE.setTranslate((float) (i3 + i), (float) (i4 + i2));
        this.gBE.preTranslate((float) (this.tK / 2), (float) (this.tL / 2));
        this.gBE.preScale(min, f);
        this.gBE.preTranslate((float) ((-this.tK) / 2), (float) ((-this.tL) / 2));
        if (!isInEditMode()) {
            canvas.drawBitmap(bitmap, this.gBE, this.gBB);
        }
    }

    private com.tencent.mm.plugin.gesture.a.c o(float f, float f2) {
        int i = 0;
        com.tencent.mm.plugin.gesture.a.c cVar = null;
        float f3 = this.gCa;
        float f4 = f3 * this.gBM;
        float paddingTop = ((f3 - f4) / 2.0f) + ((float) getPaddingTop());
        int i2 = 0;
        while (i2 < 3) {
            float f5 = (((float) i2) * f3) + paddingTop;
            if (f2 >= f5 && f2 <= f5 + f4) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 >= 0) {
            f3 = this.gBZ;
            f4 = this.gBM * f3;
            paddingTop = ((float) getPaddingLeft()) + ((f3 - f4) / 2.0f);
            while (i < 3) {
                f5 = (((float) i) * f3) + paddingTop;
                if (f >= f5 && f <= f5 + f4) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i >= 0 && !this.gBI[i2][i]) {
                cVar = com.tencent.mm.plugin.gesture.a.c.bJ(i2, i);
            }
        }
        if (cVar == null) {
            return null;
        }
        this.gBI[cVar.fkQ][cVar.fkR] = true;
        this.gBH.add(cVar);
        if (this.gCb != null) {
            ArrayList arrayList = new ArrayList(this.gBH);
        }
        if (!this.gBN) {
            return cVar;
        }
        performHapticFeedback(1, 3);
        return cVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = r13.gBP;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r13.isEnabled();
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        r0 = 0;
    L_0x000b:
        return r0;
    L_0x000c:
        r0 = r14.getAction();
        switch(r0) {
            case 0: goto L_0x0015;
            case 1: goto L_0x0060;
            case 2: goto L_0x0080;
            case 3: goto L_0x0207;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = 0;
        goto L_0x000b;
    L_0x0015:
        r13.atu();
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = r13.o(r0, r1);
        if (r2 == 0) goto L_0x005c;
    L_0x0026:
        r3 = 1;
        r13.gBX = r3;
        r3 = com.tencent.mm.plugin.gesture.ui.widget.PatternLockView.b.Correct;
        r13.gBQ = r3;
        r3 = r13.gCb;
        if (r3 == 0) goto L_0x0031;
    L_0x0031:
        if (r2 == 0) goto L_0x0056;
    L_0x0033:
        r3 = r2.fkR;
        r3 = r13.lK(r3);
        r2 = r2.fkQ;
        r2 = r13.lL(r2);
        r4 = r13.gBZ;
        r5 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r4 = r4 * r5;
        r5 = r13.gCa;
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r5 = r5 * r6;
        r6 = r3 - r4;
        r6 = (int) r6;
        r7 = r2 - r5;
        r7 = (int) r7;
        r3 = r3 + r4;
        r3 = (int) r3;
        r2 = r2 + r5;
        r2 = (int) r2;
        r13.invalidate(r6, r7, r3, r2);
    L_0x0056:
        r13.gBV = r0;
        r13.gBW = r1;
        r0 = 1;
        goto L_0x000b;
    L_0x005c:
        r3 = 0;
        r13.gBX = r3;
        goto L_0x0031;
    L_0x0060:
        r0 = r13.gBH;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x007e;
    L_0x0068:
        r0 = 0;
        r13.gBX = r0;
        r0 = r13.gCb;
        if (r0 == 0) goto L_0x007b;
    L_0x006f:
        r0 = r13.gCb;
        r1 = new java.util.ArrayList;
        r2 = r13.gBH;
        r1.<init>(r2);
        r0.a(r13, r1);
    L_0x007b:
        r13.invalidate();
    L_0x007e:
        r0 = 1;
        goto L_0x000b;
    L_0x0080:
        r0 = r13.gBK;
        r7 = (float) r0;
        r8 = r14.getHistorySize();
        r0 = r13.gBF;
        r0.setEmpty();
        r2 = 0;
        r0 = 0;
        r6 = r0;
    L_0x008f:
        r0 = r8 + 1;
        if (r6 >= r0) goto L_0x0159;
    L_0x0093:
        if (r6 >= r8) goto L_0x014b;
    L_0x0095:
        r0 = r14.getHistoricalX(r6);
        r3 = r0;
    L_0x009a:
        if (r6 >= r8) goto L_0x0152;
    L_0x009c:
        r0 = r14.getHistoricalY(r6);
        r1 = r0;
    L_0x00a1:
        r9 = r13.o(r3, r1);
        r0 = r13.gBH;
        r4 = r0.size();
        if (r9 == 0) goto L_0x00b3;
    L_0x00ad:
        r0 = 1;
        if (r4 != r0) goto L_0x00b3;
    L_0x00b0:
        r0 = 1;
        r13.gBX = r0;
    L_0x00b3:
        r0 = r13.gBV;
        r0 = r3 - r0;
        r0 = java.lang.Math.abs(r0);
        r5 = r13.gBW;
        r5 = r1 - r5;
        r5 = java.lang.Math.abs(r5);
        r10 = 0;
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 > 0) goto L_0x00cd;
    L_0x00c8:
        r0 = 0;
        r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x00cf;
    L_0x00cd:
        r0 = 1;
        r2 = r0;
    L_0x00cf:
        r0 = r13.gBX;
        if (r0 == 0) goto L_0x0146;
    L_0x00d3:
        if (r4 <= 0) goto L_0x0146;
    L_0x00d5:
        r0 = r13.gBH;
        r4 = r4 + -1;
        r0 = r0.get(r4);
        r0 = (com.tencent.mm.plugin.gesture.a.c) r0;
        r4 = r0.fkR;
        r4 = r13.lK(r4);
        r0 = r0.fkQ;
        r10 = r13.lL(r0);
        r0 = java.lang.Math.min(r4, r3);
        r0 = r0 - r7;
        r3 = java.lang.Math.max(r4, r3);
        r5 = r3 + r7;
        r3 = java.lang.Math.min(r10, r1);
        r3 = r3 - r7;
        r1 = java.lang.Math.max(r10, r1);
        r4 = r1 + r7;
        if (r9 == 0) goto L_0x021d;
    L_0x0103:
        r1 = r13.gBZ;
        r10 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r1 = r1 * r10;
        r10 = r13.gCa;
        r11 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r10 = r10 * r11;
        r11 = r9.fkR;
        r11 = r13.lK(r11);
        r9 = r9.fkQ;
        r9 = r13.lL(r9);
        r12 = r11 - r1;
        r0 = java.lang.Math.min(r12, r0);
        r1 = r1 + r11;
        r5 = java.lang.Math.max(r1, r5);
        r1 = r9 - r10;
        r1 = java.lang.Math.min(r1, r3);
        r3 = r9 + r10;
        r3 = java.lang.Math.max(r3, r4);
        r4 = r5;
    L_0x0131:
        r5 = r13.gBF;
        r0 = java.lang.Math.round(r0);
        r1 = java.lang.Math.round(r1);
        r4 = java.lang.Math.round(r4);
        r3 = java.lang.Math.round(r3);
        r5.union(r0, r1, r4, r3);
    L_0x0146:
        r0 = r6 + 1;
        r6 = r0;
        goto L_0x008f;
    L_0x014b:
        r0 = r14.getX();
        r3 = r0;
        goto L_0x009a;
    L_0x0152:
        r0 = r14.getY();
        r1 = r0;
        goto L_0x00a1;
    L_0x0159:
        r0 = r14.getX();
        r13.gBV = r0;
        r0 = r13.gBV;
        r1 = r13.getPaddingLeft();
        r3 = r13.gBK;
        r1 = r1 + r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x01ad;
    L_0x016d:
        r0 = r13.getPaddingLeft();
        r1 = r13.gBK;
        r0 = r0 + r1;
        r0 = (float) r0;
        r13.gBV = r0;
    L_0x0177:
        r0 = r14.getY();
        r13.gBW = r0;
        r0 = r13.gBW;
        r1 = r13.getPaddingTop();
        r3 = r13.gBK;
        r1 = r1 + r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x01da;
    L_0x018b:
        r0 = r13.getPaddingTop();
        r1 = r13.gBK;
        r0 = r0 + r1;
        r0 = (float) r0;
        r13.gBW = r0;
    L_0x0195:
        if (r2 == 0) goto L_0x01aa;
    L_0x0197:
        r0 = r13.gBG;
        r1 = r13.gBF;
        r0.union(r1);
        r0 = r13.gBG;
        r13.invalidate(r0);
        r0 = r13.gBG;
        r1 = r13.gBF;
        r0.set(r1);
    L_0x01aa:
        r0 = 1;
        goto L_0x000b;
    L_0x01ad:
        r0 = r13.gBV;
        r1 = r13.getPaddingLeft();
        r3 = r13.getWidth();
        r1 = r1 + r3;
        r3 = r13.getPaddingRight();
        r1 = r1 - r3;
        r3 = r13.gBK;
        r1 = r1 - r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0177;
    L_0x01c5:
        r0 = r13.getPaddingLeft();
        r1 = r13.getWidth();
        r0 = r0 + r1;
        r1 = r13.getPaddingRight();
        r0 = r0 - r1;
        r1 = r13.gBK;
        r0 = r0 - r1;
        r0 = (float) r0;
        r13.gBV = r0;
        goto L_0x0177;
    L_0x01da:
        r0 = r13.gBW;
        r1 = r13.getPaddingTop();
        r3 = r13.getHeight();
        r1 = r1 + r3;
        r3 = r13.getPaddingRight();
        r1 = r1 - r3;
        r3 = r13.gBK;
        r1 = r1 - r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0195;
    L_0x01f2:
        r0 = r13.getPaddingTop();
        r1 = r13.getHeight();
        r0 = r0 + r1;
        r1 = r13.getPaddingBottom();
        r0 = r0 - r1;
        r1 = r13.gBK;
        r0 = r0 - r1;
        r0 = (float) r0;
        r13.gBW = r0;
        goto L_0x0195;
    L_0x0207:
        r0 = r13.gBX;
        if (r0 == 0) goto L_0x021a;
    L_0x020b:
        r0 = 0;
        r13.gBX = r0;
        r13.atu();
        r0 = r13.gCb;
        if (r0 == 0) goto L_0x021a;
    L_0x0215:
        r0 = r13.gCb;
        r0.a(r13);
    L_0x021a:
        r0 = 1;
        goto L_0x000b;
    L_0x021d:
        r1 = r3;
        r3 = r4;
        r4 = r5;
        goto L_0x0131;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gesture.ui.widget.PatternLockView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void att() {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.gBI[i][i2] = false;
            }
        }
    }

    private float lK(int i) {
        return (((float) getPaddingLeft()) + (((float) i) * this.gBZ)) + (this.gBZ * 0.5f);
    }

    private float lL(int i) {
        return (((float) getPaddingTop()) + (((float) i) * this.gCa)) + (this.gCa * 0.5f);
    }

    private void a(b bVar, List<com.tencent.mm.plugin.gesture.a.c> list) {
        this.gBH.clear();
        att();
        this.gBH.addAll(list);
        Iterator it = this.gBH.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.gesture.a.c cVar = (com.tencent.mm.plugin.gesture.a.c) it.next();
            this.gBI[cVar.fkQ][cVar.fkR] = true;
        }
        a(bVar);
    }

    private void atu() {
        this.gBH.clear();
        att();
        this.gBQ = b.Correct;
        invalidate();
    }

    public final void atv() {
        atu();
        if (this.gCb != null) {
            this.gCb.a(this);
        }
    }

    public final void a(b bVar) {
        switch (bVar) {
            case Correct:
                this.fEG = getResources().getColor(2131689763);
                break;
            case Wrong:
                this.fEG = getResources().getColor(2131689766);
                break;
            case Animate:
                if (this.gBH.size() != 0) {
                    this.gBP = false;
                    this.fEG = getResources().getColor(2131689763);
                    com.tencent.mm.plugin.gesture.a.c cVar = (com.tencent.mm.plugin.gesture.a.c) this.gBH.get(0);
                    this.gBV = lK(cVar.fkR);
                    this.gBW = lL(cVar.fkQ);
                    att();
                    this.gBY = SystemClock.elapsedRealtime();
                    break;
                }
                throw new IllegalStateException("You should set a pattern before animating.");
        }
        this.gBQ = bVar;
        invalidate();
    }
}

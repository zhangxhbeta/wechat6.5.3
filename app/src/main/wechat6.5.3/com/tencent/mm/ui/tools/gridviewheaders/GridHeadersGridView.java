package com.tencent.mm.ui.tools.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView extends GridView implements OnScrollListener, OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener {
    private DataSetObserver AB;
    private OnItemSelectedListener Fp;
    private OnItemClickListener abT;
    protected int adi;
    private OnItemLongClickListener dWv;
    private int eZz;
    private int flZ;
    private int iD;
    private ac mHandler;
    private int nSB;
    private int nSC;
    protected boolean nSV;
    private Runnable nXS;
    public a oVR;
    public b oVS;
    private boolean oVT;
    private final Rect oVU;
    private boolean oVV;
    private boolean oVW;
    private long oVX;
    private int oVY;
    private float oVZ;
    private boolean oWa;
    private int oWb;
    public c oWc;
    d oWd;
    private e oWe;
    private OnScrollListener oWf;
    private View oWg;
    protected c oWh;
    protected int oWi;
    private boolean oWj;
    private int xe;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean oWn;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.oWn = parcel.readByte() != (byte) 0;
        }

        public String toString() {
            return "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.oWn + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.oWn ? 1 : 0));
        }
    }

    final class b implements Runnable {
        final /* synthetic */ GridHeadersGridView oWk;

        b(GridHeadersGridView gridHeadersGridView) {
            this.oWk = gridHeadersGridView;
        }

        public final void run() {
            if (this.oWk.adi == 0) {
                this.oWk.adi = 1;
                View yk = this.oWk.yk(this.oWk.oWi);
                if (yk != null && !yk.hasFocusable()) {
                    if (this.oWk.nSV) {
                        this.oWk.adi = 2;
                        return;
                    }
                    yk.setPressed(true);
                    this.oWk.setPressed(true);
                    this.oWk.refreshDrawableState();
                    int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    if (this.oWk.isLongClickable()) {
                        if (this.oWk.oVR == null) {
                            this.oWk.oVR = new a();
                        }
                        this.oWk.oVR.ahT();
                        this.oWk.mHandler.postDelayed(this.oWk.oVR, (long) longPressTimeout);
                        return;
                    }
                    this.oWk.adi = 2;
                }
            }
        }
    }

    public interface c {
        void bQ(View view);
    }

    public interface d {
        boolean bJE();
    }

    private class f {
        private int fnj;
        final /* synthetic */ GridHeadersGridView oWk;

        private f(GridHeadersGridView gridHeadersGridView) {
            this.oWk = gridHeadersGridView;
        }

        public final void ahT() {
            this.fnj = this.oWk.getWindowAttachCount();
        }

        public final boolean ahU() {
            return this.oWk.hasWindowFocus() && this.oWk.getWindowAttachCount() == this.fnj;
        }
    }

    private class a extends f implements Runnable {
        final /* synthetic */ GridHeadersGridView oWk;

        private a(GridHeadersGridView gridHeadersGridView) {
            this.oWk = gridHeadersGridView;
            super();
        }

        public final void run() {
            View yk = this.oWk.yk(this.oWk.oWi);
            if (yk != null) {
                boolean z;
                GridHeadersGridView.a(this.oWk, this.oWk.oWi);
                if (!ahU() || this.oWk.nSV) {
                    z = false;
                } else {
                    GridHeadersGridView gridHeadersGridView = this.oWk;
                    if (gridHeadersGridView.oWd != null) {
                        z = gridHeadersGridView.oWd.bJE();
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (yk != null) {
                            yk.sendAccessibilityEvent(2);
                        }
                        gridHeadersGridView.performHapticFeedback(0);
                    }
                }
                if (z) {
                    this.oWk.adi = -2;
                    this.oWk.setPressed(false);
                    yk.setPressed(false);
                    return;
                }
                this.oWk.adi = 2;
            }
        }
    }

    private class e extends f implements Runnable {
        int fni;
        final /* synthetic */ GridHeadersGridView oWk;

        private e(GridHeadersGridView gridHeadersGridView) {
            this.oWk = gridHeadersGridView;
            super();
        }

        public final void run() {
            if (!this.oWk.nSV && this.oWk.oWh != null && this.oWk.oWh.getCount() > 0 && this.fni != -1 && this.fni < this.oWk.oWh.getCount() && ahU()) {
                View yk = this.oWk.yk(this.fni);
                if (yk != null) {
                    GridHeadersGridView gridHeadersGridView = this.oWk;
                    GridHeadersGridView.a(this.oWk, this.fni);
                    if (gridHeadersGridView.oWc != null) {
                        gridHeadersGridView.playSoundEffect(0);
                        if (yk != null) {
                            yk.sendAccessibilityEvent(1);
                        }
                        gridHeadersGridView.oWc.bQ(yk);
                    }
                }
            }
        }
    }

    static /* synthetic */ long a(GridHeadersGridView gridHeadersGridView, int i) {
        return i == -2 ? gridHeadersGridView.oVX : gridHeadersGridView.oWh.jw(gridHeadersGridView.getFirstVisiblePosition() + i);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new ac();
        this.oVT = true;
        this.oVU = new Rect();
        this.oVX = -1;
        this.AB = new DataSetObserver(this) {
            final /* synthetic */ GridHeadersGridView oWk;

            {
                this.oWk = r1;
            }

            public final void onChanged() {
                this.oWk.reset();
            }

            public final void onInvalidated() {
                this.oWk.reset();
            }
        };
        this.oWb = 1;
        this.xe = 0;
        this.oWj = true;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.oWa) {
            this.eZz = -1;
        }
        this.iD = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public final View yk(int i) {
        if (i == -2) {
            return this.oWg;
        }
        try {
            return (View) getChildAt(i).getTag();
        } catch (Exception e) {
            return null;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.abT.onItemClick(adapterView, view, this.oWh.yj(i).kB, j);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return this.dWv.onItemLongClick(adapterView, view, this.oWh.yj(i).kB, j);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.Fp.onItemSelected(adapterView, view, this.oWh.yj(i).kB, j);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        this.Fp.onNothingSelected(adapterView);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.oVT = savedState.oWn;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.oWn = this.oVT;
        return savedState;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.oWf != null) {
            this.oWf.onScroll(absListView, i, i2, i3);
        }
        if (VERSION.SDK_INT >= 8) {
            yl(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.oWf != null) {
            this.oWf.onScrollStateChanged(absListView, i);
        }
        this.xe = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r11) {
        /*
        r10 = this;
        r1 = -2;
        r4 = 1;
        r2 = 0;
        r3 = -1;
        r0 = r11.getAction();
        r0 = r0 & 255;
        switch(r0) {
            case 0: goto L_0x0011;
            case 1: goto L_0x00b4;
            case 2: goto L_0x0082;
            default: goto L_0x000d;
        };
    L_0x000d:
        r0 = r2;
    L_0x000e:
        if (r0 == 0) goto L_0x013a;
    L_0x0010:
        return r2;
    L_0x0011:
        r0 = r10.oVS;
        if (r0 != 0) goto L_0x001c;
    L_0x0015:
        r0 = new com.tencent.mm.ui.tools.gridviewheaders.GridHeadersGridView$b;
        r0.<init>(r10);
        r10.oVS = r0;
    L_0x001c:
        r0 = r10.mHandler;
        r4 = r10.oVR;
        r5 = android.view.ViewConfiguration.getTapTimeout();
        r6 = (long) r5;
        r0.postDelayed(r4, r6);
        r0 = r11.getY();
        r0 = (int) r0;
        r4 = (float) r0;
        r10.oVZ = r4;
        r4 = (float) r0;
        r0 = r10.oWg;
        if (r0 == 0) goto L_0x004e;
    L_0x0035:
        r0 = r10.oWg;
        r0 = r0.getBottom();
        r0 = (float) r0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x004e;
    L_0x0040:
        r10.oWi = r1;
        r0 = r10.oWi;
        if (r0 == r3) goto L_0x000d;
    L_0x0046:
        r0 = r10.xe;
        r1 = 2;
        if (r0 == r1) goto L_0x000d;
    L_0x004b:
        r10.adi = r2;
        goto L_0x000d;
    L_0x004e:
        r0 = r10.getFirstVisiblePosition();
        r1 = r2;
    L_0x0053:
        r5 = r10.getLastVisiblePosition();
        if (r0 > r5) goto L_0x0080;
    L_0x0059:
        r6 = r10.getItemIdAtPosition(r0);
        r8 = -1;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 != 0) goto L_0x0079;
    L_0x0063:
        r5 = r10.getChildAt(r1);
        r6 = r5.getBottom();
        r5 = r5.getTop();
        r6 = (float) r6;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 > 0) goto L_0x0079;
    L_0x0074:
        r5 = (float) r5;
        r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x0040;
    L_0x0079:
        r5 = r10.oWb;
        r0 = r0 + r5;
        r5 = r10.oWb;
        r1 = r1 + r5;
        goto L_0x0053;
    L_0x0080:
        r1 = r3;
        goto L_0x0040;
    L_0x0082:
        r0 = r10.oWi;
        if (r0 == r3) goto L_0x000d;
    L_0x0086:
        r0 = r11.getY();
        r1 = r10.oVZ;
        r0 = r0 - r1;
        r0 = java.lang.Math.abs(r0);
        r1 = r10.iD;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x000d;
    L_0x0098:
        r10.adi = r3;
        r0 = r10.oWi;
        r0 = r10.yk(r0);
        if (r0 == 0) goto L_0x00a5;
    L_0x00a2:
        r0.setPressed(r2);
    L_0x00a5:
        r0 = r10.oVR;
        if (r0 == 0) goto L_0x00b0;
    L_0x00a9:
        r0 = r10.mHandler;
        r1 = r10.oVR;
        r0.removeCallbacks(r1);
    L_0x00b0:
        r10.oWi = r3;
        goto L_0x000d;
    L_0x00b4:
        r0 = r10.adi;
        if (r0 == r1) goto L_0x000d;
    L_0x00b8:
        r0 = r10.adi;
        if (r0 == r3) goto L_0x000d;
    L_0x00bc:
        r0 = r10.oWi;
        if (r0 == r3) goto L_0x000d;
    L_0x00c0:
        r0 = r10.oWi;
        r1 = r10.yk(r0);
        if (r1 == 0) goto L_0x012c;
    L_0x00c8:
        r0 = r1.hasFocusable();
        if (r0 != 0) goto L_0x012c;
    L_0x00ce:
        r0 = r10.adi;
        if (r0 == 0) goto L_0x00d5;
    L_0x00d2:
        r1.setPressed(r2);
    L_0x00d5:
        r0 = r10.oWe;
        if (r0 != 0) goto L_0x00e0;
    L_0x00d9:
        r0 = new com.tencent.mm.ui.tools.gridviewheaders.GridHeadersGridView$e;
        r0.<init>();
        r10.oWe = r0;
    L_0x00e0:
        r5 = r10.oWe;
        r0 = r10.oWi;
        r5.fni = r0;
        r5.ahT();
        r0 = r10.adi;
        if (r0 != 0) goto L_0x00f1;
    L_0x00ed:
        r0 = r10.adi;
        if (r0 == r4) goto L_0x0130;
    L_0x00f1:
        r6 = r10.mHandler;
        r0 = r10.adi;
        if (r0 != 0) goto L_0x0127;
    L_0x00f7:
        r0 = r10.oVS;
    L_0x00f9:
        r6.removeCallbacks(r0);
        r0 = r10.nSV;
        if (r0 != 0) goto L_0x012a;
    L_0x0100:
        r10.adi = r4;
        r1.setPressed(r4);
        r10.setPressed(r4);
        r0 = r10.nXS;
        if (r0 == 0) goto L_0x0111;
    L_0x010c:
        r0 = r10.nXS;
        r10.removeCallbacks(r0);
    L_0x0111:
        r0 = new com.tencent.mm.ui.tools.gridviewheaders.GridHeadersGridView$2;
        r0.<init>(r10, r1, r5);
        r10.nXS = r0;
        r0 = r10.mHandler;
        r1 = r10.nXS;
        r3 = android.view.ViewConfiguration.getPressedStateDuration();
        r6 = (long) r3;
        r0.postDelayed(r1, r6);
        r0 = r4;
        goto L_0x000e;
    L_0x0127:
        r0 = r10.oVR;
        goto L_0x00f9;
    L_0x012a:
        r10.adi = r3;
    L_0x012c:
        r10.adi = r3;
        goto L_0x000d;
    L_0x0130:
        r0 = r10.nSV;
        if (r0 != 0) goto L_0x012c;
    L_0x0134:
        r5.run();
        r0 = r4;
        goto L_0x000e;
    L_0x013a:
        r2 = super.dispatchTouchEvent(r11);
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.gridviewheaders.GridHeadersGridView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (!(this.oWh == null || this.AB == null)) {
            this.oWh.unregisterDataSetObserver(this.AB);
        }
        if (!this.oVW) {
            this.oVV = true;
        }
        if (listAdapter instanceof b) {
            listAdapter = (b) listAdapter;
        } else if (listAdapter instanceof e) {
            r3 = new f((e) listAdapter);
        } else {
            r3 = new d(listAdapter);
        }
        this.oWh = new c(getContext(), this, listAdapter);
        this.oWh.registerDataSetObserver(this.AB);
        reset();
        super.setAdapter(this.oWh);
    }

    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.oVV = z;
        this.oVW = true;
    }

    public void setColumnWidth(int i) {
        super.setColumnWidth(i);
        this.flZ = i;
    }

    public void setHorizontalSpacing(int i) {
        super.setHorizontalSpacing(i);
        this.nSB = i;
    }

    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.oWa = true;
        this.eZz = i;
        if (i != -1 && this.oWh != null) {
            this.oWh.setNumColumns(i);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.abT = onItemClickListener;
        super.setOnItemClickListener(this);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.dWv = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.Fp = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.oWf = onScrollListener;
    }

    public void setVerticalSpacing(int i) {
        super.setVerticalSpacing(i);
        this.nSC = i;
    }

    private int bJC() {
        if (this.oWg != null) {
            return this.oWg.getMeasuredHeight();
        }
        return 0;
    }

    private void bJD() {
        if (this.oWg != null) {
            int makeMeasureSpec;
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
            LayoutParams layoutParams = this.oWg.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            this.oWg.measure(makeMeasureSpec2, makeMeasureSpec);
            this.oWg.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.oWg.getMeasuredHeight());
        }
    }

    private void reset() {
        this.oVY = 0;
        this.oWg = null;
        this.oVX = Long.MIN_VALUE;
    }

    private void yl(int i) {
        if (this.oWh != null && this.oWh.getCount() != 0 && this.oVT && ((d) getChildAt(0)) != null) {
            int i2;
            long jw;
            int childCount;
            View view;
            int i3;
            View view2;
            View view3;
            int i4 = i - this.oWb;
            if (i4 < 0) {
                i4 = i;
            }
            int i5 = this.oWb + i;
            if (i5 >= this.oWh.getCount()) {
                i5 = i;
            }
            if (this.nSC != 0) {
                if (this.nSC < 0) {
                    this.oWh.jw(i);
                    if (getChildAt(this.oWb).getTop() <= 0) {
                        i2 = i5;
                        jw = this.oWh.jw(i5);
                    } else {
                        jw = this.oWh.jw(i);
                        i2 = i;
                    }
                } else {
                    i5 = getChildAt(0).getTop();
                    if (i5 > 0 && i5 < this.nSC) {
                        i2 = i4;
                        jw = this.oWh.jw(i4);
                    }
                }
                if (this.oVX != jw) {
                    this.oWg = this.oWh.a(i2, this.oWg, this);
                    bJD();
                    this.oVX = jw;
                }
                childCount = getChildCount();
                if (childCount != 0) {
                    view = null;
                    i2 = 99999;
                    i3 = 0;
                    while (i3 < childCount) {
                        view2 = (d) super.getChildAt(i3);
                        if (this.oVV) {
                            i5 = view2.getTop();
                        } else {
                            i5 = view2.getTop() - getPaddingTop();
                        }
                        if (i5 >= 0 || !(view2.getChildAt(0) instanceof b) || i5 >= i2) {
                            i4 = i2;
                            view3 = view;
                        } else {
                            int i6 = i5;
                            view3 = view2;
                            i4 = i6;
                        }
                        i3 = this.oWb + i3;
                        view = view3;
                        i2 = i4;
                    }
                    i4 = bJC();
                    if (view != null) {
                        this.oVY = i4;
                        if (this.oVV) {
                            this.oVY += getPaddingTop();
                            return;
                        }
                        return;
                    } else if (i != 0 && super.getChildAt(0).getTop() > 0 && !this.oVV) {
                        this.oVY = 0;
                        return;
                    } else if (this.oVV) {
                        this.oVY = Math.min(view.getTop(), i4);
                        if (this.oVY >= 0) {
                            i4 = this.oVY;
                        }
                        this.oVY = i4;
                        return;
                    } else {
                        this.oVY = Math.min(view.getTop(), getPaddingTop() + i4);
                        this.oVY = this.oVY >= getPaddingTop() ? i4 + getPaddingTop() : this.oVY;
                    }
                }
            }
            jw = this.oWh.jw(i);
            i2 = i;
            if (this.oVX != jw) {
                this.oWg = this.oWh.a(i2, this.oWg, this);
                bJD();
                this.oVX = jw;
            }
            childCount = getChildCount();
            if (childCount != 0) {
                view = null;
                i2 = 99999;
                i3 = 0;
                while (i3 < childCount) {
                    view2 = (d) super.getChildAt(i3);
                    if (this.oVV) {
                        i5 = view2.getTop();
                    } else {
                        i5 = view2.getTop() - getPaddingTop();
                    }
                    if (i5 >= 0) {
                    }
                    i4 = i2;
                    view3 = view;
                    i3 = this.oWb + i3;
                    view = view3;
                    i2 = i4;
                }
                i4 = bJC();
                if (view != null) {
                    this.oVY = i4;
                    if (this.oVV) {
                        this.oVY += getPaddingTop();
                        return;
                    }
                    return;
                }
                if (i != 0) {
                }
                if (this.oVV) {
                    this.oVY = Math.min(view.getTop(), i4);
                    if (this.oVY >= 0) {
                        i4 = this.oVY;
                    }
                    this.oVY = i4;
                    return;
                }
                this.oVY = Math.min(view.getTop(), getPaddingTop() + i4);
                if (this.oVY >= getPaddingTop()) {
                }
                this.oVY = this.oVY >= getPaddingTop() ? i4 + getPaddingTop() : this.oVY;
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        Object obj;
        if (VERSION.SDK_INT < 8) {
            yl(getFirstVisiblePosition());
        }
        if (this.oWg != null && this.oVT && this.oWg.getVisibility() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        int bJC = bJC();
        int i = this.oVY - bJC;
        if (obj != null && this.oWj) {
            this.oVU.left = getPaddingLeft();
            this.oVU.right = getWidth() - getPaddingRight();
            this.oVU.top = this.oVY;
            this.oVU.bottom = getHeight();
            canvas.save();
            canvas.clipRect(this.oVU);
        }
        super.dispatchDraw(canvas);
        List arrayList = new ArrayList();
        int i2 = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                arrayList.add(Integer.valueOf(i2));
            }
            firstVisiblePosition += this.oWb;
            i2 += this.oWb;
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            d dVar = (d) getChildAt(((Integer) arrayList.get(i3)).intValue());
            try {
                View view = (View) dVar.getTag();
                Object obj2 = (((long) ((b) dVar.getChildAt(0)).oVN) == this.oVX && dVar.getTop() < 0 && this.oVT) ? 1 : null;
                if (view.getVisibility() == 0 && obj2 == null) {
                    view.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
                    view.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), dVar.getHeight());
                    this.oVU.left = getPaddingLeft();
                    this.oVU.right = getWidth() - getPaddingRight();
                    this.oVU.bottom = dVar.getBottom();
                    this.oVU.top = dVar.getTop();
                    canvas.save();
                    canvas.clipRect(this.oVU);
                    canvas.translate((float) getPaddingLeft(), (float) dVar.getTop());
                    view.draw(canvas);
                    canvas.restore();
                }
                i3++;
            } catch (Exception e) {
                return;
            }
        }
        if (obj != null && this.oWj) {
            canvas.restore();
        } else if (obj == null) {
            return;
        }
        if (this.oWg.getWidth() != (getWidth() - getPaddingLeft()) - getPaddingRight()) {
            this.oWg.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
            this.oWg.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.oWg.getHeight());
        }
        this.oVU.left = getPaddingLeft();
        this.oVU.right = getWidth() - getPaddingRight();
        this.oVU.bottom = i + bJC;
        if (this.oVV) {
            this.oVU.top = getPaddingTop();
        } else {
            this.oVU.top = 0;
        }
        canvas.save();
        canvas.clipRect(this.oVU);
        canvas.translate((float) getPaddingLeft(), (float) i);
        canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (int) ((255.0f * ((float) this.oVY)) / ((float) bJC)), 4);
        this.oWg.draw(canvas);
        canvas.restore();
        canvas.restore();
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        if (this.eZz == -1) {
            if (this.flZ > 0) {
                int max = Math.max((MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight(), 0);
                int i4 = max / this.flZ;
                if (i4 > 0) {
                    while (i4 != 1 && (this.flZ * i4) + ((i4 - 1) * this.nSB) > max) {
                        i4--;
                    }
                    i3 = i4;
                }
            } else {
                i3 = 2;
            }
            this.oWb = i3;
        } else {
            this.oWb = this.eZz;
        }
        if (this.oWh != null) {
            this.oWh.setNumColumns(this.oWb);
        }
        bJD();
        super.onMeasure(i, i2);
    }
}

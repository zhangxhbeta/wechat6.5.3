package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.y;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListViewV2 extends AdapterView<ListAdapter> {
    protected ListAdapter EK;
    private Drawable Wp = null;
    private int Wq = 0;
    private GestureDetector fjR;
    private Rect fu = new Rect();
    private OnClickListener mOnClickListener;
    protected int nSN;
    protected int nSO;
    private int nSP = Integer.MAX_VALUE;
    private int nSQ;
    private boolean nSV = false;
    protected Scroller nSZ = new Scroller(getContext());
    private final a nTa = new a();
    private List<Queue<View>> nTb = new ArrayList();
    private View nTc = null;
    private Integer nTd = null;
    private int nTe;
    private int nTf;
    private int nTg;
    private e nTh = null;
    private int nTi = 0;
    private boolean nTj = false;
    private d nTk = null;
    private int nTl = a.nTu;
    private i nTm;
    private i nTn;
    private int nTo;
    private boolean nTp = false;
    private boolean nTq = false;
    private DataSetObserver nTr = new DataSetObserver(this) {
        final /* synthetic */ HorizontalListViewV2 nTt;

        {
            this.nTt = r1;
        }

        public final void onChanged() {
            this.nTt.nSV = true;
            this.nTt.nTj = false;
            this.nTt.bBM();
            this.nTt.invalidate();
            this.nTt.requestLayout();
        }

        public final void onInvalidated() {
            this.nTt.nTj = false;
            this.nTt.bBM();
            this.nTt.reset();
            this.nTt.invalidate();
            this.nTt.requestLayout();
        }
    };
    private Runnable nTs = new Runnable(this) {
        final /* synthetic */ HorizontalListViewV2 nTt;

        {
            this.nTt = r1;
        }

        public final void run() {
            this.nTt.requestLayout();
        }
    };

    private class a extends SimpleOnGestureListener {
        final /* synthetic */ HorizontalListViewV2 nTt;

        private a(HorizontalListViewV2 horizontalListViewV2) {
            this.nTt = horizontalListViewV2;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return this.nTt.onDown(motionEvent);
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return this.nTt.ag(f);
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.nTt.e(Boolean.valueOf(true));
            this.nTt.nTl = a.nTv;
            this.nTt.bBM();
            HorizontalListViewV2 horizontalListViewV2 = this.nTt;
            horizontalListViewV2.nSO += (int) f;
            HorizontalListViewV2.b(this.nTt, Math.round(f));
            this.nTt.requestLayout();
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            this.nTt.bBM();
            OnItemClickListener onItemClickListener = this.nTt.getOnItemClickListener();
            int a = this.nTt.de((int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !this.nTt.nTp) {
                View childAt = this.nTt.getChildAt(a);
                int g = this.nTt.nTe + a;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(this.nTt, childAt, g, this.nTt.EK.getItemId(g));
                    return true;
                }
            }
            if (!(this.nTt.mOnClickListener == null || this.nTt.nTp)) {
                this.nTt.mOnClickListener.onClick(this.nTt);
            }
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            this.nTt.bBM();
            int a = this.nTt.de((int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !this.nTt.nTp) {
                View childAt = this.nTt.getChildAt(a);
                OnItemLongClickListener onItemLongClickListener = this.nTt.getOnItemLongClickListener();
                if (onItemLongClickListener != null) {
                    int g = this.nTt.nTe + a;
                    if (onItemLongClickListener.onItemLongClick(this.nTt, childAt, g, this.nTt.EK.getItemId(g))) {
                        this.nTt.performHapticFeedback(0);
                    }
                }
            }
        }
    }

    @TargetApi(11)
    private static final class b {
        static {
            if (VERSION.SDK_INT < 11) {
                throw new RuntimeException("sdk is >= 11!");
            }
        }

        public static void a(Scroller scroller) {
            if (scroller != null) {
                scroller.setFriction(0.009f);
            }
        }
    }

    @TargetApi(14)
    private static final class c {
        static {
            if (VERSION.SDK_INT < 14) {
                throw new RuntimeException("sdk is >= 14!");
            }
        }

        public static float b(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }

    public interface d {

        public enum a {
            ;

            static {
                nTu = 1;
                nTv = 2;
                nTw = 3;
                nTx = new int[]{nTu, nTv, nTw};
            }
        }
    }

    public interface e {
    }

    static /* synthetic */ void b(HorizontalListViewV2 horizontalListViewV2, int i) {
        if (horizontalListViewV2.nTm != null && horizontalListViewV2.nTn != null) {
            int i2 = horizontalListViewV2.nSN + i;
            if (horizontalListViewV2.nSZ != null && !horizontalListViewV2.nSZ.isFinished()) {
                return;
            }
            if (i2 < 0) {
                horizontalListViewV2.nTm.t(((float) Math.abs(i)) / ((float) horizontalListViewV2.bBL()));
                if (!horizontalListViewV2.nTn.isFinished()) {
                    horizontalListViewV2.nTn.cv();
                }
            } else if (i2 > horizontalListViewV2.nSP) {
                horizontalListViewV2.nTn.t(((float) Math.abs(i)) / ((float) horizontalListViewV2.bBL()));
                if (!horizontalListViewV2.nTm.isFinished()) {
                    horizontalListViewV2.nTm.cv();
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.EK;
    }

    public HorizontalListViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nTm = new i(context);
        this.nTn = new i(context);
        this.fjR = new GestureDetector(context, this.nTa);
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ HorizontalListViewV2 nTt;

            {
                this.nTt = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.nTt.fjR.onTouchEvent(motionEvent);
            }
        });
        NI();
        setWillNotDraw(false);
        if (VERSION.SDK_INT >= 11) {
            b.a(this.nSZ);
        }
    }

    private void e(Boolean bool) {
        if (this.nTq != bool.booleanValue()) {
            View view = this;
            while (view.getParent() instanceof View) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.nTq = bool.booleanValue();
                    return;
                }
                view = (View) view.getParent();
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.nSN);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.nTd = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    private void NI() {
        this.nTe = -1;
        this.nTf = -1;
        this.nSQ = 0;
        this.nSN = 0;
        this.nSO = 0;
        this.nSP = Integer.MAX_VALUE;
        this.nTl = a.nTu;
    }

    private void reset() {
        NI();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int i) {
        this.nTg = i;
    }

    public View getSelectedView() {
        int i = this.nTg;
        return (i < this.nTe || i > this.nTf) ? null : getChildAt(i - this.nTe);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        int i = 0;
        if (this.EK != null) {
            this.EK.unregisterDataSetObserver(this.nTr);
        }
        if (listAdapter != null) {
            this.nTj = false;
            this.EK = listAdapter;
            this.EK.registerDataSetObserver(this.nTr);
        }
        int viewTypeCount = this.EK.getViewTypeCount();
        this.nTb.clear();
        while (i < viewTypeCount) {
            this.nTb.add(new LinkedList());
            i++;
        }
        reset();
    }

    private View wd(int i) {
        int itemViewType = this.EK.getItemViewType(i);
        if (we(itemViewType)) {
            return (View) ((Queue) this.nTb.get(itemViewType)).poll();
        }
        return null;
    }

    private void h(int i, View view) {
        int itemViewType = this.EK.getItemViewType(i);
        if (we(itemViewType)) {
            ((Queue) this.nTb.get(itemViewType)).offer(view);
        }
    }

    private boolean we(int i) {
        return i < this.nTb.size();
    }

    private void B(View view, int i) {
        addViewInLayout(view, i, cB(view), true);
        LayoutParams cB = cB(view);
        view.measure(cB.width > 0 ? MeasureSpec.makeMeasureSpec(cB.width, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0), ViewGroup.getChildMeasureSpec(this.nTo, getPaddingTop() + getPaddingBottom(), cB.height));
    }

    private static LayoutParams cB(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return new LayoutParams(-2, -1);
        }
        return layoutParams;
    }

    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = false;
        super.onLayout(z, i, i2, i3, i4);
        if (this.EK != null) {
            int i5;
            int i6;
            View bBK;
            View view;
            int i7;
            invalidate();
            if (this.nSV) {
                i5 = this.nSN;
                NI();
                removeAllViewsInLayout();
                this.nSO = i5;
                this.nSV = false;
            }
            if (this.nTd != null) {
                this.nSO = this.nTd.intValue();
                this.nTd = null;
            }
            if (this.nSZ.computeScrollOffset()) {
                this.nSO = this.nSZ.getCurrX();
            }
            if (this.nSO < 0) {
                this.nSO = 0;
                if (this.nTm.isFinished()) {
                    this.nTm.ah((int) bBJ());
                }
                this.nSZ.forceFinished(true);
                this.nTl = a.nTu;
            } else if (this.nSO > this.nSP) {
                this.nSO = this.nSP;
                if (this.nTn.isFinished()) {
                    this.nTn.ah((int) bBJ());
                }
                this.nSZ.forceFinished(true);
                this.nTl = a.nTu;
            }
            int i8 = this.nSN - this.nSO;
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i8 <= 0) {
                i6 = this.nSQ;
                if (wf(this.nTe)) {
                    i5 = childAt.getMeasuredWidth();
                } else {
                    i5 = this.Wq + childAt.getMeasuredWidth();
                }
                this.nSQ = i5 + i6;
                h(this.nTe, childAt);
                removeViewInLayout(childAt);
                this.nTe++;
                childAt = getChildAt(0);
            }
            while (true) {
                bBK = bBK();
                if (bBK == null || bBK.getLeft() + i8 < getWidth()) {
                    bBK = bBK();
                } else {
                    h(this.nTf, bBK);
                    removeViewInLayout(bBK);
                    this.nTf--;
                }
            }
            bBK = bBK();
            i5 = bBK != null ? bBK.getRight() : 0;
            while ((i5 + i8) + this.Wq < getWidth() && this.nTf + 1 < this.EK.getCount()) {
                this.nTf++;
                if (this.nTe < 0) {
                    this.nTe = this.nTf;
                }
                view = this.EK.getView(this.nTf, wd(this.nTf), this);
                B(view, -1);
                i5 += (this.nTf == 0 ? 0 : this.Wq) + view.getMeasuredWidth();
                if (!(this.nTh == null || this.EK == null || this.EK.getCount() - (this.nTf + 1) >= this.nTi || this.nTj)) {
                    this.nTj = true;
                }
            }
            bBK = getChildAt(0);
            i5 = bBK != null ? bBK.getLeft() : 0;
            while ((i5 + i8) - this.Wq > 0 && this.nTe > 0) {
                this.nTe--;
                view = this.EK.getView(this.nTe, wd(this.nTe), this);
                B(view, 0);
                i5 -= this.nTe == 0 ? view.getMeasuredWidth() : this.Wq + view.getMeasuredWidth();
                this.nSQ -= i5 + i8 == 0 ? view.getMeasuredWidth() : this.Wq + view.getMeasuredWidth();
            }
            i6 = getChildCount();
            if (i6 > 0) {
                this.nSQ += i8;
                i7 = this.nSQ;
                for (i5 = 0; i5 < i6; i5++) {
                    View childAt2 = getChildAt(i5);
                    int paddingLeft = getPaddingLeft() + i7;
                    int paddingTop = getPaddingTop();
                    childAt2.layout(paddingLeft, paddingTop, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + paddingTop);
                    i7 += childAt2.getMeasuredWidth() + this.Wq;
                }
            }
            this.nSN = this.nSO;
            if (wf(this.nTf)) {
                bBK = bBK();
                if (bBK != null) {
                    i7 = this.nSP;
                    this.nSP = ((bBK.getRight() - getPaddingLeft()) + this.nSN) - bBL();
                    if (this.nSP < 0) {
                        this.nSP = 0;
                    }
                    if (this.nSP != i7) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                onLayout(z, i, i2, i3, i4);
            } else if (!this.nSZ.isFinished()) {
                y.a(this, this.nTs);
            } else if (this.nTl == a.nTw) {
                this.nTl = a.nTu;
            }
        }
    }

    protected float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.nSN == 0) {
            return 0.0f;
        }
        if (this.nSN < horizontalFadingEdgeLength) {
            return ((float) this.nSN) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.nSN == this.nSP) {
            return 0.0f;
        }
        if (this.nSP - this.nSN < horizontalFadingEdgeLength) {
            return ((float) (this.nSP - this.nSN)) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    private float bBJ() {
        if (VERSION.SDK_INT >= 14) {
            return c.b(this.nSZ);
        }
        return 30.0f;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.nTo = i2;
    }

    private View bBK() {
        return getChildAt(getChildCount() - 1);
    }

    private int de(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getHitRect(this.fu);
            if (this.fu.contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    private boolean wf(int i) {
        return i == this.EK.getCount() + -1;
    }

    private int bBL() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void wg(int i) {
        this.nSZ.startScroll(this.nSO, 0, i - this.nSO, 0);
        this.nTl = a.nTw;
        requestLayout();
    }

    public int getFirstVisiblePosition() {
        return this.nTe;
    }

    public int getLastVisiblePosition() {
        return this.nTf;
    }

    private void a(Canvas canvas, Rect rect) {
        if (this.Wp != null) {
            this.Wp.setBounds(rect);
            this.Wp.draw(canvas);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int childCount = getChildCount();
        Rect rect = this.fu;
        this.fu.top = getPaddingTop();
        this.fu.bottom = this.fu.top + ((getHeight() - getPaddingTop()) - getPaddingBottom());
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1 || !wf(this.nTf)) {
                View childAt = getChildAt(i);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.Wq;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                a(canvas, rect);
                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    a(canvas, rect);
                }
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    protected void dispatchSetPressed(boolean z) {
    }

    protected final boolean ag(float f) {
        this.nSZ.fling(this.nSO, 0, (int) (-f), 0, 0, this.nSP, 0, 0);
        this.nTl = a.nTw;
        requestLayout();
        return true;
    }

    protected final boolean onDown(MotionEvent motionEvent) {
        this.nTp = !this.nSZ.isFinished();
        this.nSZ.forceFinished(true);
        this.nTl = a.nTu;
        bBM();
        if (!this.nTp) {
            int de = de((int) motionEvent.getX(), (int) motionEvent.getY());
            if (de >= 0) {
                this.nTc = getChildAt(de);
                if (this.nTc != null) {
                    this.nTc.setPressed(true);
                    refreshDrawableState();
                }
            }
        }
        return true;
    }

    private void bBM() {
        if (this.nTc != null) {
            this.nTc.setPressed(false);
            refreshDrawableState();
            this.nTc = null;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.nSZ == null || this.nSZ.isFinished()) {
                this.nTl = a.nTu;
            }
            e(Boolean.valueOf(false));
            bBN();
        } else if (motionEvent.getAction() == 3) {
            bBM();
            bBN();
            e(Boolean.valueOf(false));
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bBN() {
        if (this.nTm != null) {
            this.nTm.cv();
        }
        if (this.nTn != null) {
            this.nTn.cv();
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}

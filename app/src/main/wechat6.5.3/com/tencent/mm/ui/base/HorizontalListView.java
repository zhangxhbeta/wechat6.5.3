package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView extends AdapterView<ListAdapter> {
    protected ListAdapter EK;
    public a lOn;
    public boolean nSK = true;
    private int nSL = -1;
    private int nSM = 0;
    protected int nSN;
    protected int nSO;
    private int nSP = Integer.MAX_VALUE;
    private int nSQ = 0;
    private GestureDetector nSR;
    private Queue<View> nSS = new LinkedList();
    private OnItemSelectedListener nST;
    private OnItemClickListener nSU;
    private boolean nSV = false;
    private DataSetObserver nSW = new DataSetObserver(this) {
        final /* synthetic */ HorizontalListView nSY;

        {
            this.nSY = r1;
        }

        public final void onChanged() {
            synchronized (this.nSY) {
                this.nSY.nSV = true;
            }
            this.nSY.invalidate();
            this.nSY.requestLayout();
        }

        public final void onInvalidated() {
            this.nSY.reset();
            this.nSY.invalidate();
            this.nSY.requestLayout();
        }
    };
    private OnGestureListener nSX = new SimpleOnGestureListener(this) {
        final /* synthetic */ HorizontalListView nSY;

        {
            this.nSY = r1;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return this.nSY.bBI();
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return this.nSY.ag(f);
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            synchronized (this.nSY) {
                HorizontalListView horizontalListView = this.nSY;
                horizontalListView.nSO += (int) f;
            }
            this.nSY.requestLayout();
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Rect rect = new Rect();
            for (int i = 0; i < this.nSY.getChildCount(); i++) {
                View childAt = this.nSY.getChildAt(i);
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    if (this.nSY.nSU != null) {
                        this.nSY.nSU.onItemClick(this.nSY, childAt, (this.nSY.nSL + 1) + i, this.nSY.EK.getItemId((this.nSY.nSL + 1) + i));
                    }
                    if (this.nSY.nST != null) {
                        this.nSY.nST.onItemSelected(this.nSY, childAt, (this.nSY.nSL + 1) + i, this.nSY.EK.getItemId((this.nSY.nSL + 1) + i));
                    }
                    return true;
                }
            }
            return true;
        }
    };
    protected Scroller xF;

    public interface a {
        boolean v(MotionEvent motionEvent);
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.EK;
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        NI();
    }

    private synchronized void NI() {
        this.nSL = -1;
        this.nSM = 0;
        this.nSQ = 0;
        this.nSN = 0;
        this.nSO = 0;
        this.nSP = Integer.MAX_VALUE;
        this.xF = new Scroller(getContext());
        this.nSR = new GestureDetector(getContext(), this.nSX);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.nST = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.nSU = onItemClickListener;
    }

    public View getSelectedView() {
        return null;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.EK != null) {
            this.EK.unregisterDataSetObserver(this.nSW);
        }
        this.EK = listAdapter;
        this.EK.registerDataSetObserver(this.nSW);
        reset();
    }

    private synchronized void reset() {
        NI();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int i) {
    }

    private void B(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        synchronized (this) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.EK != null) {
                int i6;
                if (this.nSV) {
                    i6 = this.nSN;
                    NI();
                    removeAllViewsInLayout();
                    this.nSO = i6;
                    this.nSV = false;
                }
                if (this.xF.computeScrollOffset()) {
                    this.nSO = this.xF.getCurrX();
                }
                if (this.nSO <= 0) {
                    this.nSO = 0;
                    this.xF.forceFinished(true);
                }
                if (this.nSO >= this.nSP) {
                    this.nSO = this.nSP;
                    this.xF.forceFinished(true);
                }
                int i7 = this.nSN - this.nSO;
                View childAt = getChildAt(0);
                while (childAt != null && childAt.getRight() + i7 <= 0) {
                    this.nSQ += childAt.getMeasuredWidth();
                    this.nSS.offer(childAt);
                    removeViewInLayout(childAt);
                    this.nSL++;
                    childAt = getChildAt(0);
                }
                while (true) {
                    childAt = getChildAt(getChildCount() - 1);
                    if (childAt == null || childAt.getLeft() + i7 < getWidth()) {
                        break;
                    }
                    this.nSS.offer(childAt);
                    removeViewInLayout(childAt);
                    this.nSM--;
                }
                childAt = getChildAt(getChildCount() - 1);
                if (childAt != null) {
                    i6 = childAt.getRight();
                } else {
                    i6 = 0;
                }
                int i8 = i6;
                while (i8 + i7 < getWidth() && this.nSM < this.EK.getCount()) {
                    childAt = this.EK.getView(this.nSM, (View) this.nSS.poll(), this);
                    B(childAt, -1);
                    i6 = childAt.getMeasuredWidth() + i8;
                    if (this.nSM == this.EK.getCount() - 1) {
                        this.nSP = (this.nSN + i6) - getWidth();
                    }
                    if (this.nSP < 0) {
                        this.nSP = 0;
                    }
                    this.nSM++;
                    i8 = i6;
                }
                childAt = getChildAt(0);
                if (childAt != null) {
                    i6 = childAt.getLeft();
                } else {
                    i6 = 0;
                }
                i8 = i6;
                while (i8 + i7 > 0 && this.nSL >= 0) {
                    View view = this.EK.getView(this.nSL, (View) this.nSS.poll(), this);
                    B(view, 0);
                    i6 = i8 - view.getMeasuredWidth();
                    this.nSL--;
                    this.nSQ -= view.getMeasuredWidth();
                    i8 = i6;
                }
                if (getChildCount() > 0) {
                    this.nSQ += i7;
                    i6 = this.nSQ;
                    while (i5 < getChildCount()) {
                        View childAt2 = getChildAt(i5);
                        i7 = childAt2.getMeasuredWidth();
                        childAt2.layout(i6, 0, i6 + i7, childAt2.getMeasuredHeight());
                        i6 += i7;
                        i5++;
                    }
                }
                this.nSN = this.nSO;
                if (!this.xF.isFinished()) {
                    post(new Runnable(this) {
                        final /* synthetic */ HorizontalListView nSY;

                        {
                            this.nSY = r1;
                        }

                        public final void run() {
                            this.nSY.requestLayout();
                        }
                    });
                }
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.lOn != null) {
            this.lOn.v(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent) | this.nSR.onTouchEvent(motionEvent);
    }

    protected final boolean ag(float f) {
        synchronized (this) {
            this.xF.fling(this.nSO, 0, (int) (-f), 0, 0, this.nSP, 0, 0);
        }
        requestLayout();
        return true;
    }

    protected final boolean bBI() {
        this.xF.forceFinished(true);
        return true;
    }
}

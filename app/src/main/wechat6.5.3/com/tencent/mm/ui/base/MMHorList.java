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
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.Queue;

public class MMHorList extends AdapterView<ListAdapter> {
    public boolean hDR = false;
    public a nVW;
    private int nVX;
    private int nVY;
    public int nVZ;
    private int nWa;
    private int nWb = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
    private Queue<View> nWc = new LinkedList();
    private boolean nWd = false;
    private boolean nWe = false;
    protected Scroller nWf;
    private GestureDetector nWg;
    private OnItemSelectedListener nWh;
    private OnItemClickListener nWi;
    private ListAdapter nWj;
    private Runnable nWk = new Runnable(this) {
        final /* synthetic */ MMHorList nWs;

        {
            this.nWs = r1;
        }

        public final void run() {
            this.nWs.requestLayout();
        }
    };
    public boolean nWl = false;
    public boolean nWm = false;
    public int nWn = 0;
    private int nWo = 0;
    private boolean nWp = false;
    private DataSetObserver nWq = new DataSetObserver(this) {
        final /* synthetic */ MMHorList nWs;

        {
            this.nWs = r1;
        }

        public final void onChanged() {
            this.nWs.nWd = true;
            this.nWs.invalidate();
            this.nWs.requestLayout();
        }

        public final void onInvalidated() {
            this.nWs.reset();
            this.nWs.invalidate();
            this.nWs.requestLayout();
        }
    };
    private OnGestureListener nWr = new SimpleOnGestureListener(this) {
        final /* synthetic */ MMHorList nWs;

        {
            this.nWs = r1;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return this.nWs.bBI();
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return this.nWs.ag(f);
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            MMHorList.a(this.nWs, (int) f);
            this.nWs.requestLayout();
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Rect rect = new Rect();
            for (int i = 0; i < this.nWs.getChildCount(); i++) {
                View childAt = this.nWs.getChildAt(i);
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    if (this.nWs.nWi != null) {
                        this.nWs.nWi.onItemClick(this.nWs, childAt, (this.nWs.nVX + 1) + i, this.nWs.nWj.getItemId((this.nWs.nVX + 1) + i));
                    }
                    if (this.nWs.nWh != null) {
                        this.nWs.nWh.onItemSelected(this.nWs, childAt, (this.nWs.nVX + 1) + i, this.nWs.nWj.getItemId((this.nWs.nVX + 1) + i));
                    }
                    return true;
                }
            }
            return true;
        }
    };
    private int offset;

    public interface a {
        void ayd();

        void bau();

        void bav();
    }

    static /* synthetic */ int a(MMHorList mMHorList, int i) {
        int i2 = mMHorList.nWa + i;
        mMHorList.nWa = i2;
        return i2;
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.nWj;
    }

    private void init() {
        this.nWf = new Scroller(getContext());
        this.nVX = -1;
        this.nVY = 0;
        this.offset = 0;
        this.nVZ = 0;
        this.nWa = 0;
        this.nWd = false;
        this.nWb = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
        this.nWg = new GestureDetector(getContext(), this.nWr);
    }

    public MMHorList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.nWh = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.nWi = onItemClickListener;
    }

    public MMHorList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.nWj == null) {
            listAdapter.registerDataSetObserver(this.nWq);
        }
        this.nWj = listAdapter;
        reset();
    }

    private int bCf() {
        return this.nWj.getCount() * this.nWn;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nWj != null) {
            int i5;
            this.nWe = true;
            if (this.nWd) {
                i5 = this.nVZ;
                init();
                removeAllViewsInLayout();
                this.nWa = i5;
                if (this.nWl) {
                    this.nWo = Math.max(0, (getWidth() - bCf()) / 2);
                    this.offset = this.nWo;
                }
                this.nWd = false;
            }
            if (this.nWf.computeScrollOffset()) {
                this.nWa = this.nWf.getCurrX();
            }
            if (!this.nWm) {
                if (this.nWa < 0) {
                    this.nWa = 0;
                    this.nWf.forceFinished(true);
                }
                if (this.nWa > this.nWb) {
                    this.nWa = this.nWb;
                    this.nWf.forceFinished(true);
                }
            } else if (bCf() > getWidth()) {
                if (this.nWa < getWidth() * -1) {
                    this.nWa = (getWidth() * -1) + 1;
                    this.nWf.forceFinished(true);
                }
                if (this.nWa > this.nWb + getWidth()) {
                    this.nWa = (this.nWb + getWidth()) - 1;
                    this.nWf.forceFinished(true);
                }
            } else {
                if (this.nWa < (getWidth() * -1) + this.nWo) {
                    this.nWa = ((getWidth() * -1) + this.nWo) + 1;
                    this.nWf.forceFinished(true);
                }
                if (this.nWa > getWidth() - this.nWo) {
                    this.nWa = (getWidth() - this.nWo) - 1;
                    this.nWf.forceFinished(true);
                }
            }
            int i6 = this.nVZ - this.nWa;
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i6 <= 0) {
                this.offset += childAt.getMeasuredWidth();
                this.nWc.offer(childAt);
                removeViewInLayout(childAt);
                this.nVX++;
                childAt = getChildAt(0);
                this.nWe = true;
            }
            childAt = getChildAt(getChildCount() - 1);
            while (childAt != null && childAt.getLeft() + i6 >= getWidth()) {
                this.nWc.offer(childAt);
                removeViewInLayout(childAt);
                this.nVY--;
                childAt = getChildAt(getChildCount() - 1);
                this.nWe = true;
            }
            childAt = getChildAt(getChildCount() - 1);
            if (childAt != null) {
                i5 = childAt.getRight();
            } else {
                i5 = 0;
            }
            int i7 = i5;
            while (i7 + i6 < getWidth() && this.nVY < this.nWj.getCount()) {
                childAt = this.nWj.getView(this.nVY, (View) this.nWc.poll(), this);
                B(childAt, -1);
                i5 = childAt.getMeasuredWidth() + i7;
                if (this.nVY == this.nWj.getCount() - 1) {
                    this.nWb = (this.nVZ + i5) - getWidth();
                }
                this.nVY++;
                i7 = i5;
            }
            childAt = getChildAt(0);
            if (childAt != null) {
                i5 = childAt.getLeft();
            } else {
                i5 = 0;
            }
            i7 = i5;
            while (i7 + i6 > 0 && this.nVX >= 0) {
                View view = this.nWj.getView(this.nVX, (View) this.nWc.poll(), this);
                B(view, 0);
                i5 = i7 - view.getMeasuredWidth();
                this.nVX--;
                this.offset -= view.getMeasuredWidth();
                i7 = i5;
            }
            if (getChildCount() > 0 && this.nWe) {
                this.offset += i6;
                i7 = this.offset;
                for (i5 = 0; i5 < getChildCount(); i5++) {
                    View childAt2 = getChildAt(i5);
                    int measuredWidth = childAt2.getMeasuredWidth();
                    childAt2.layout(i7, 0, i7 + measuredWidth, childAt2.getMeasuredHeight());
                    i7 += measuredWidth;
                }
            }
            this.nVZ = this.nWa;
            if (!this.nWf.isFinished()) {
                post(this.nWk);
            } else if (this.nVW != null && this.nWp) {
                this.nVW.ayd();
                this.nWp = false;
            }
        }
    }

    private void B(View view, int i) {
        this.nWe = true;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    public View getSelectedView() {
        return null;
    }

    public void setSelection(int i) {
    }

    protected void onMeasure(int i, int i2) {
        if (this.nWj != null && this.nWj.getCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                super.onMeasure(i, MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), Integer.MIN_VALUE));
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.nWg.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.hDR = true;
            if (this.nVW != null) {
                this.nVW.bau();
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            if (this.nWm) {
                if (bCf() > getWidth()) {
                    if (this.nVZ < 0) {
                        this.nWf.forceFinished(true);
                        this.nWf.startScroll(this.nVZ, 0, 0 - this.nVZ, 0);
                        requestLayout();
                    } else if (this.nVZ > this.nWb) {
                        this.nWf.forceFinished(true);
                        this.nWf.startScroll(this.nVZ, 0, this.nWb - this.nVZ, 0);
                        requestLayout();
                    }
                } else if (this.nVZ != this.nWo * -1) {
                    this.nWf.forceFinished(true);
                    this.nWf.startScroll(this.nVZ, 0, 0 - this.nVZ, 0);
                    requestLayout();
                }
            }
            this.hDR = false;
            if (this.nVW != null) {
                this.nVW.bav();
            }
        }
        return onTouchEvent;
    }

    protected final boolean bBI() {
        this.nWf.forceFinished(true);
        return true;
    }

    public final void wz(int i) {
        this.nWf.forceFinished(true);
        this.nWf.startScroll(this.nVZ, 0, i - this.nVZ, 0);
        this.nWp = true;
        requestLayout();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    protected final boolean ag(float f) {
        this.nWf.fling(this.nWa, 0, (int) (-f), 0, 0, this.nWb, 0, 0);
        requestLayout();
        return true;
    }

    private void reset() {
        init();
        removeAllViewsInLayout();
        requestLayout();
    }
}

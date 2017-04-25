package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Locale;

public class MMListPopupWindow {
    private ListAdapter EK;
    private int Ul;
    public int Xc;
    public int Xd;
    private int Xe;
    private boolean Xg;
    private boolean Xh;
    private boolean Xi;
    int Xj;
    public View Xk;
    public int Xl;
    private DataSetObserver Xm;
    public View Xn;
    private Drawable Xo;
    public OnItemClickListener Xp;
    private OnItemSelectedListener Xq;
    private Runnable Xv;
    private boolean Xw;
    public o eLp;
    private Rect ep;
    private Context mContext;
    private ac mHandler;
    public a nWt;
    private final f nWu;
    private final e nWv;
    private final d nWw;
    private final b nWx;
    public boolean nWy;

    private static class a extends ListView {
        private boolean Xy;
        private boolean Xz;

        public a(Context context, boolean z) {
            super(context, null, android.support.v7.a.a.a.dropDownListViewStyle);
            this.Xz = z;
            setCacheColorHint(0);
        }

        public final boolean isInTouchMode() {
            return (this.Xz && this.Xy) || super.isInTouchMode();
        }

        public final boolean hasWindowFocus() {
            return this.Xz || super.hasWindowFocus();
        }

        public final boolean isFocused() {
            return this.Xz || super.isFocused();
        }

        public final boolean hasFocus() {
            return this.Xz || super.hasFocus();
        }

        final int K(int i, int i2) {
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
            getListPaddingLeft();
            getListPaddingRight();
            int dividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                return listPaddingTop + listPaddingBottom;
            }
            listPaddingBottom += listPaddingTop;
            if (dividerHeight <= 0 || divider == null) {
                dividerHeight = 0;
            }
            int count = adapter.getCount();
            int i3 = 0;
            View view = null;
            for (int i4 = 0; i4 < count; i4++) {
                View view2;
                listPaddingTop = adapter.getItemViewType(i4);
                if (listPaddingTop != i3) {
                    i3 = listPaddingTop;
                    view2 = null;
                } else {
                    view2 = view;
                }
                view = adapter.getView(i4, view2, this);
                listPaddingTop = view.getLayoutParams().height;
                if (listPaddingTop > 0) {
                    listPaddingTop = MeasureSpec.makeMeasureSpec(listPaddingTop, 1073741824);
                } else {
                    listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
                }
                view.measure(i, listPaddingTop);
                if (i4 > 0) {
                    listPaddingTop = listPaddingBottom + dividerHeight;
                } else {
                    listPaddingTop = listPaddingBottom;
                }
                listPaddingBottom = view.getMeasuredHeight() + listPaddingTop;
                if (listPaddingBottom >= i2) {
                    return i2;
                }
            }
            return listPaddingBottom;
        }
    }

    private class b implements Runnable {
        final /* synthetic */ MMListPopupWindow nWz;

        private b(MMListPopupWindow mMListPopupWindow) {
            this.nWz = mMListPopupWindow;
        }

        public final void run() {
            this.nWz.clearListSelection();
        }
    }

    private class c extends DataSetObserver {
        final /* synthetic */ MMListPopupWindow nWz;

        private c(MMListPopupWindow mMListPopupWindow) {
            this.nWz = mMListPopupWindow;
        }

        public final void onChanged() {
            if (this.nWz.eLp.isShowing()) {
                this.nWz.show();
            }
        }

        public final void onInvalidated() {
            this.nWz.dismiss();
        }
    }

    private class d implements OnScrollListener {
        final /* synthetic */ MMListPopupWindow nWz;

        private d(MMListPopupWindow mMListPopupWindow) {
            this.nWz = mMListPopupWindow;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.nWz.nWt != null && this.nWz.Xk != null && this.nWz.EK != null && this.nWz.nWt != null) {
                if (this.nWz.nWt.getLastVisiblePosition() != this.nWz.EK.getCount() - 1 || this.nWz.nWt.getChildAt(this.nWz.nWt.getChildCount() - 1) == null || this.nWz.nWt.getChildAt(this.nWz.nWt.getChildCount() - 1).getBottom() > this.nWz.nWt.getHeight()) {
                    this.nWz.Xk.setVisibility(0);
                } else {
                    this.nWz.Xk.setVisibility(8);
                }
            }
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.nWz.isInputMethodNotNeeded() && this.nWz.eLp.getContentView() != null) {
                this.nWz.mHandler.removeCallbacks(this.nWz.nWu);
                this.nWz.nWu.run();
            }
        }
    }

    private class e implements OnTouchListener {
        final /* synthetic */ MMListPopupWindow nWz;

        private e(MMListPopupWindow mMListPopupWindow) {
            this.nWz = mMListPopupWindow;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.nWz.eLp != null && this.nWz.eLp.isShowing() && x >= 0 && x < this.nWz.eLp.getWidth() && y >= 0 && y < this.nWz.eLp.getHeight()) {
                this.nWz.mHandler.postDelayed(this.nWz.nWu, 250);
            } else if (action == 1) {
                this.nWz.mHandler.removeCallbacks(this.nWz.nWu);
            }
            return false;
        }
    }

    private class f implements Runnable {
        final /* synthetic */ MMListPopupWindow nWz;

        private f(MMListPopupWindow mMListPopupWindow) {
            this.nWz = mMListPopupWindow;
        }

        public final void run() {
            if (this.nWz.nWt != null && this.nWz.nWt.getCount() > this.nWz.nWt.getChildCount() && this.nWz.nWt.getChildCount() <= this.nWz.Xj) {
                this.nWz.eLp.setInputMethodMode(2);
                this.nWz.show();
            }
        }
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this.Xc = -2;
        this.Ul = -2;
        this.Xh = false;
        this.Xi = false;
        this.Xj = Integer.MAX_VALUE;
        this.Xl = 0;
        this.nWu = new f();
        this.nWv = new e();
        this.nWw = new d();
        this.nWx = new b();
        this.mHandler = new ac();
        this.ep = new Rect();
        this.nWy = false;
        this.mContext = context;
        this.eLp = new o(context);
        this.eLp.setInputMethodMode(1);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.Xm == null) {
            this.Xm = new c();
        } else if (this.EK != null) {
            this.EK.unregisterDataSetObserver(this.Xm);
        }
        this.EK = listAdapter;
        if (this.EK != null) {
            listAdapter.registerDataSetObserver(this.Xm);
        }
        if (this.nWt != null) {
            this.nWt.setAdapter(this.EK);
        }
    }

    public final void fi() {
        this.Xw = true;
        this.eLp.setFocusable(true);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.eLp.setBackgroundDrawable(drawable);
    }

    public final void setAnimationStyle(int i) {
        this.eLp.setAnimationStyle(i);
    }

    public final void setVerticalOffset(int i) {
        this.Xe = i;
        this.Xg = true;
    }

    public final void setContentWidth(int i) {
        Drawable background = this.eLp.getBackground();
        if (background != null) {
            background.getPadding(this.ep);
            this.Ul = (this.ep.left + this.ep.right) + i;
            return;
        }
        this.Ul = i;
    }

    public final void show() {
        int i;
        int i2;
        boolean z;
        boolean z2 = true;
        int i3 = -1;
        View frameLayout;
        if (this.nWt == null) {
            Context context = this.mContext;
            this.Xv = new Runnable(this) {
                final /* synthetic */ MMListPopupWindow nWz;

                {
                    this.nWz = r1;
                }

                public final void run() {
                    View view = this.nWz.Xn;
                    if (view != null && view.getWindowToken() != null) {
                        this.nWz.show();
                    }
                }
            };
            this.nWt = new a(context, !this.Xw);
            if (this.Xo != null) {
                this.nWt.setSelector(this.Xo);
            }
            this.nWt.setAdapter(this.EK);
            this.nWt.setOnItemClickListener(this.Xp);
            this.nWt.setFocusable(true);
            this.nWt.setFocusableInTouchMode(true);
            this.nWt.setDivider(null);
            this.nWt.setDividerHeight(0);
            this.nWt.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ MMListPopupWindow nWz;

                {
                    this.nWz = r1;
                }

                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a a = this.nWz.nWt;
                        if (a != null) {
                            a.Xy = false;
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.nWt.setOnScrollListener(this.nWw);
            if (this.Xq != null) {
                this.nWt.setOnItemSelectedListener(this.Xq);
            }
            View view = this.nWt;
            View view2 = this.Xk;
            if (view2 != null) {
                bCg();
                frameLayout = new FrameLayout(context);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                switch (this.Xl) {
                    case 0:
                        layoutParams2.gravity = 48;
                        frameLayout.addView(view, layoutParams);
                        frameLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        layoutParams2.gravity = 80;
                        frameLayout.addView(view, layoutParams);
                        frameLayout.addView(view2, layoutParams2);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.Xl);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.Ul, Integer.MIN_VALUE), 0);
            } else {
                frameLayout = view;
            }
            this.eLp.setContentView(frameLayout);
            i = 0;
        } else {
            this.eLp.getContentView();
            frameLayout = this.Xk;
            i = frameLayout != null ? frameLayout.getMeasuredHeight() : 0;
        }
        Drawable background = this.eLp.getBackground();
        if (background != null) {
            background.getPadding(this.ep);
            i2 = this.ep.top + this.ep.bottom;
            if (!this.Xg) {
                this.Xe = -this.ep.top;
            }
        } else {
            this.ep.setEmpty();
            i2 = 0;
        }
        if (this.eLp.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        View view3 = this.Xn;
        int i4 = this.Xe;
        Rect rect = new Rect();
        view3.getWindowVisibleDisplayFrame(rect);
        view3.getLocationOnScreen(new int[2]);
        int i5 = (z ? view3.getContext().getResources().getDisplayMetrics().heightPixels : rect.bottom) - i4;
        if (this.eLp.getBackground() != null) {
            this.eLp.getBackground().getPadding(this.ep);
            i5 -= this.ep.top + this.ep.bottom;
        }
        if (this.Xh || this.Xc == -1) {
            i = i5 + i2;
        } else {
            int makeMeasureSpec;
            switch (this.Ul) {
                case -2:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ep.left + this.ep.right), Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ep.left + this.ep.right), 1073741824);
                    break;
                default:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.Ul, 1073741824);
                    break;
            }
            i5 = this.nWt.K(makeMeasureSpec, i5 - i);
            if (i5 > 0) {
                i += i2;
            }
            i += i5;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        o oVar;
        if (this.eLp.isShowing()) {
            if (this.Ul == -1) {
                i2 = -1;
            } else if (this.Ul == -2) {
                i2 = this.Xn.getWidth();
            } else {
                i2 = this.Ul;
            }
            if (this.Xc == -1) {
                if (isInputMethodNotNeeded) {
                    i5 = i;
                } else {
                    i5 = -1;
                }
                if (isInputMethodNotNeeded) {
                    oVar = this.eLp;
                    if (this.Ul != -1) {
                        i3 = 0;
                    }
                    oVar.setWindowLayoutMode(i3, 0);
                    i = i5;
                } else {
                    this.eLp.setWindowLayoutMode(this.Ul == -1 ? -1 : 0, -1);
                    i = i5;
                }
            } else if (this.Xc != -2) {
                i = this.Xc;
            }
            this.eLp.update(i2, i);
            oVar = this.eLp;
            if (this.Xi || this.Xh) {
                z2 = false;
            }
            oVar.setOutsideTouchable(z2);
            if (this.nWy) {
                this.eLp.showAtLocation(this.Xn, 17, 0, 0);
                return;
            } else {
                this.eLp.showAtLocation(this.Xn, 53, this.Xd, this.Xe);
                return;
            }
        }
        if (this.Ul == -1) {
            i2 = -1;
        } else if (this.Ul == -2) {
            this.eLp.setWidth(this.Xn.getWidth());
            i2 = 0;
        } else {
            this.eLp.setWidth(this.Ul);
            i2 = 0;
        }
        if (this.Xc == -1) {
            i = -1;
        } else if (this.Xc == -2) {
            this.eLp.setHeight(i);
            i = 0;
        } else {
            this.eLp.setHeight(this.Xc);
            i = 0;
        }
        this.eLp.setWindowLayoutMode(i2, i);
        oVar = this.eLp;
        if (this.Xi || this.Xh) {
            z2 = false;
        }
        oVar.setOutsideTouchable(z2);
        this.eLp.setTouchInterceptor(this.nWv);
        if (this.nWy) {
            this.eLp.showAtLocation(this.Xn, 17, 0, 0);
        } else {
            this.eLp.showAtLocation(this.Xn, 53, this.Xd, this.Xe);
        }
        this.nWt.setSelection(-1);
        if (!this.Xw || this.nWt.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Xw) {
            this.mHandler.post(this.nWx);
        }
    }

    public final void dismiss() {
        this.eLp.dismiss();
        bCg();
        this.eLp.setContentView(null);
        this.nWt = null;
        this.mHandler.removeCallbacks(this.nWu);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.eLp.setOnDismissListener(onDismissListener);
    }

    public final void bCg() {
        if (this.Xk != null) {
            ViewParent parent = this.Xk.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.Xk);
            }
        }
    }

    public final void fj() {
        this.eLp.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        a aVar = this.nWt;
        if (aVar != null) {
            aVar.Xy = true;
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.eLp.getInputMethodMode() == 2;
    }
}

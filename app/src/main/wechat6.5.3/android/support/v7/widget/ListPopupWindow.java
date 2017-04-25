package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ah;
import android.support.v4.view.n;
import android.support.v4.view.y;
import android.support.v4.widget.k;
import android.support.v4.widget.m;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import java.lang.reflect.Method;

public class ListPopupWindow {
    private static Method WY;
    private static Method WZ;
    private ListAdapter EK;
    public int Qx;
    int Ul;
    private int Wb;
    public PopupWindow Xa;
    public a Xb;
    private int Xc;
    int Xd;
    int Xe;
    private int Xf;
    boolean Xg;
    private boolean Xh;
    private boolean Xi;
    int Xj;
    private View Xk;
    int Xl;
    private DataSetObserver Xm;
    public View Xn;
    private Drawable Xo;
    public OnItemClickListener Xp;
    private OnItemSelectedListener Xq;
    private final g Xr;
    private final f Xs;
    private final e Xt;
    private final c Xu;
    private Runnable Xv;
    private boolean Xw;
    private Rect ep;
    private Context mContext;
    private final Handler mHandler;

    public static abstract class b implements OnTouchListener {
        private final float XD;
        private final int XE;
        private final int XF;
        private final View XG;
        private Runnable XH;
        private Runnable XI;
        private boolean XJ;
        private boolean XK;
        private final int[] XL = new int[2];
        private int fk;

        private class a implements Runnable {
            final /* synthetic */ b XM;

            private a(b bVar) {
                this.XM = bVar;
            }

            public final void run() {
                this.XM.XG.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        private class b implements Runnable {
            final /* synthetic */ b XM;

            private b(b bVar) {
                this.XM = bVar;
            }

            public final void run() {
                b.b(this.XM);
            }
        }

        public abstract ListPopupWindow dt();

        static /* synthetic */ void b(b bVar) {
            bVar.fl();
            View view = bVar.XG;
            if (view.isEnabled() && !view.isLongClickable() && bVar.du()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                bVar.XJ = true;
                bVar.XK = true;
            }
        }

        public b(View view) {
            this.XG = view;
            this.XD = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.XE = ViewConfiguration.getTapTimeout();
            this.XF = (this.XE + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
            /*
            r11 = this;
            r5 = 0;
            r8 = 1;
            r7 = 0;
            r10 = r11.XJ;
            if (r10 == 0) goto L_0x0027;
        L_0x0007:
            r0 = r11.XK;
            if (r0 == 0) goto L_0x0017;
        L_0x000b:
            r0 = r11.l(r13);
        L_0x000f:
            r11.XJ = r0;
            if (r0 != 0) goto L_0x0015;
        L_0x0013:
            if (r10 == 0) goto L_0x0016;
        L_0x0015:
            r7 = r8;
        L_0x0016:
            return r7;
        L_0x0017:
            r0 = r11.l(r13);
            if (r0 != 0) goto L_0x0023;
        L_0x001d:
            r0 = r11.ef();
            if (r0 != 0) goto L_0x0025;
        L_0x0023:
            r0 = r8;
            goto L_0x000f;
        L_0x0025:
            r0 = r7;
            goto L_0x000f;
        L_0x0027:
            r1 = r11.XG;
            r0 = r1.isEnabled();
            if (r0 == 0) goto L_0x0036;
        L_0x002f:
            r0 = android.support.v4.view.n.d(r13);
            switch(r0) {
                case 0: goto L_0x0057;
                case 1: goto L_0x00d2;
                case 2: goto L_0x0086;
                case 3: goto L_0x00d2;
                default: goto L_0x0036;
            };
        L_0x0036:
            r0 = r7;
        L_0x0037:
            if (r0 == 0) goto L_0x00d7;
        L_0x0039:
            r0 = r11.du();
            if (r0 == 0) goto L_0x00d7;
        L_0x003f:
            r9 = r8;
        L_0x0040:
            if (r9 == 0) goto L_0x0055;
        L_0x0042:
            r0 = android.os.SystemClock.uptimeMillis();
            r4 = 3;
            r2 = r0;
            r6 = r5;
            r0 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7);
            r1 = r11.XG;
            r1.onTouchEvent(r0);
            r0.recycle();
        L_0x0055:
            r0 = r9;
            goto L_0x000f;
        L_0x0057:
            r0 = r13.getPointerId(r7);
            r11.fk = r0;
            r11.XK = r7;
            r0 = r11.XH;
            if (r0 != 0) goto L_0x006a;
        L_0x0063:
            r0 = new android.support.v7.widget.ListPopupWindow$b$a;
            r0.<init>();
            r11.XH = r0;
        L_0x006a:
            r0 = r11.XH;
            r2 = r11.XE;
            r2 = (long) r2;
            r1.postDelayed(r0, r2);
            r0 = r11.XI;
            if (r0 != 0) goto L_0x007d;
        L_0x0076:
            r0 = new android.support.v7.widget.ListPopupWindow$b$b;
            r0.<init>();
            r11.XI = r0;
        L_0x007d:
            r0 = r11.XI;
            r2 = r11.XF;
            r2 = (long) r2;
            r1.postDelayed(r0, r2);
            goto L_0x0036;
        L_0x0086:
            r0 = r11.fk;
            r0 = r13.findPointerIndex(r0);
            if (r0 < 0) goto L_0x0036;
        L_0x008e:
            r2 = r13.getX(r0);
            r0 = r13.getY(r0);
            r3 = r11.XD;
            r4 = -r3;
            r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r4 < 0) goto L_0x00d0;
        L_0x009d:
            r4 = -r3;
            r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r4 < 0) goto L_0x00d0;
        L_0x00a2:
            r4 = r1.getRight();
            r6 = r1.getLeft();
            r4 = r4 - r6;
            r4 = (float) r4;
            r4 = r4 + r3;
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 >= 0) goto L_0x00d0;
        L_0x00b1:
            r2 = r1.getBottom();
            r4 = r1.getTop();
            r2 = r2 - r4;
            r2 = (float) r2;
            r2 = r2 + r3;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 >= 0) goto L_0x00d0;
        L_0x00c0:
            r0 = r8;
        L_0x00c1:
            if (r0 != 0) goto L_0x0036;
        L_0x00c3:
            r11.fl();
            r0 = r1.getParent();
            r0.requestDisallowInterceptTouchEvent(r8);
            r0 = r8;
            goto L_0x0037;
        L_0x00d0:
            r0 = r7;
            goto L_0x00c1;
        L_0x00d2:
            r11.fl();
            goto L_0x0036;
        L_0x00d7:
            r9 = r7;
            goto L_0x0040;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        public boolean du() {
            ListPopupWindow dt = dt();
            if (!(dt == null || dt.Xa.isShowing())) {
                dt.show();
            }
            return true;
        }

        protected boolean ef() {
            ListPopupWindow dt = dt();
            if (dt != null && dt.Xa.isShowing()) {
                dt.dismiss();
            }
            return true;
        }

        private void fl() {
            if (this.XI != null) {
                this.XG.removeCallbacks(this.XI);
            }
            if (this.XH != null) {
                this.XG.removeCallbacks(this.XH);
            }
        }

        private boolean l(MotionEvent motionEvent) {
            View view = this.XG;
            ListPopupWindow dt = dt();
            if (dt == null || !dt.Xa.isShowing()) {
                return false;
            }
            View a = dt.Xb;
            if (a == null || !a.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            int[] iArr = this.XL;
            view.getLocationOnScreen(iArr);
            obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
            int[] iArr2 = this.XL;
            a.getLocationOnScreen(iArr2);
            obtainNoHistory.offsetLocation((float) (-iArr2[0]), (float) (-iArr2[1]));
            boolean h = a.h(obtainNoHistory, this.fk);
            obtainNoHistory.recycle();
            int d = n.d(motionEvent);
            boolean z;
            if (d == 1 || d == 3) {
                z = false;
            } else {
                z = true;
            }
            if (h && r2) {
                return true;
            }
            return false;
        }
    }

    private class c implements Runnable {
        final /* synthetic */ ListPopupWindow Xx;

        private c(ListPopupWindow listPopupWindow) {
            this.Xx = listPopupWindow;
        }

        public final void run() {
            this.Xx.clearListSelection();
        }
    }

    private class d extends DataSetObserver {
        final /* synthetic */ ListPopupWindow Xx;

        private d(ListPopupWindow listPopupWindow) {
            this.Xx = listPopupWindow;
        }

        public final void onChanged() {
            if (this.Xx.Xa.isShowing()) {
                this.Xx.show();
            }
        }

        public final void onInvalidated() {
            this.Xx.dismiss();
        }
    }

    private class e implements OnScrollListener {
        final /* synthetic */ ListPopupWindow Xx;

        private e(ListPopupWindow listPopupWindow) {
            this.Xx = listPopupWindow;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.Xx.isInputMethodNotNeeded() && this.Xx.Xa.getContentView() != null) {
                this.Xx.mHandler.removeCallbacks(this.Xx.Xr);
                this.Xx.Xr.run();
            }
        }
    }

    private class f implements OnTouchListener {
        final /* synthetic */ ListPopupWindow Xx;

        private f(ListPopupWindow listPopupWindow) {
            this.Xx = listPopupWindow;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.Xx.Xa != null && this.Xx.Xa.isShowing() && x >= 0 && x < this.Xx.Xa.getWidth() && y >= 0 && y < this.Xx.Xa.getHeight()) {
                this.Xx.mHandler.postDelayed(this.Xx.Xr, 250);
            } else if (action == 1) {
                this.Xx.mHandler.removeCallbacks(this.Xx.Xr);
            }
            return false;
        }
    }

    private class g implements Runnable {
        final /* synthetic */ ListPopupWindow Xx;

        private g(ListPopupWindow listPopupWindow) {
            this.Xx = listPopupWindow;
        }

        public final void run() {
            if (this.Xx.Xb != null && y.ak(this.Xx.Xb) && this.Xx.Xb.getCount() > this.Xx.Xb.getChildCount() && this.Xx.Xb.getChildCount() <= this.Xx.Xj) {
                this.Xx.Xa.setInputMethodMode(2);
                this.Xx.show();
            }
        }
    }

    private static class a extends ListViewCompat {
        private boolean XA;
        private ah XB;
        private k XC;
        private boolean Xy;
        private boolean Xz;

        public a(Context context, boolean z) {
            super(context, null, android.support.v7.a.a.a.dropDownListViewStyle);
            this.Xz = z;
            setCacheColorHint(0);
        }

        public final boolean h(MotionEvent motionEvent, int i) {
            boolean z;
            boolean z2;
            View childAt;
            int d = n.d(motionEvent);
            switch (d) {
                case 1:
                    z = false;
                    break;
                case 2:
                    z = true;
                    break;
                case 3:
                    z = false;
                    z2 = false;
                    break;
                default:
                    z = false;
                    z2 = true;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z = false;
                z2 = false;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, findPointerIndex);
                if (pointToPosition == -1) {
                    z2 = z;
                    z = true;
                } else {
                    View childAt2 = getChildAt(pointToPosition - getFirstVisiblePosition());
                    float f = (float) x;
                    float f2 = (float) findPointerIndex;
                    this.XA = true;
                    if (VERSION.SDK_INT >= 21) {
                        drawableHotspotChanged(f, f2);
                    }
                    if (!isPressed()) {
                        setPressed(true);
                    }
                    layoutChildren();
                    if (this.XT != -1) {
                        childAt = getChildAt(this.XT - getFirstVisiblePosition());
                        if (!(childAt == null || childAt == childAt2 || !childAt.isPressed())) {
                            childAt.setPressed(false);
                        }
                    }
                    this.XT = pointToPosition;
                    float left = f - ((float) childAt2.getLeft());
                    float top = f2 - ((float) childAt2.getTop());
                    if (VERSION.SDK_INT >= 21) {
                        childAt2.drawableHotspotChanged(left, top);
                    }
                    if (!childAt2.isPressed()) {
                        childAt2.setPressed(true);
                    }
                    Drawable selector = getSelector();
                    if (selector == null || pointToPosition == -1) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        selector.setVisible(false, false);
                    }
                    super.a(pointToPosition, childAt2);
                    if (z) {
                        Rect rect = this.XO;
                        float exactCenterX = rect.exactCenterX();
                        float exactCenterY = rect.exactCenterY();
                        if (getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        selector.setVisible(z, false);
                        android.support.v4.b.a.a.a(selector, exactCenterX, exactCenterY);
                    }
                    Drawable selector2 = getSelector();
                    if (!(selector2 == null || pointToPosition == -1)) {
                        android.support.v4.b.a.a.a(selector2, f, f2);
                    }
                    Q(false);
                    refreshDrawableState();
                    if (d == 1) {
                        performItemClick(childAt2, pointToPosition, getItemIdAtPosition(pointToPosition));
                    }
                    z = false;
                    z2 = true;
                }
            }
            if (!z2 || r0) {
                this.XA = false;
                setPressed(false);
                drawableStateChanged();
                childAt = getChildAt(this.XT - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setPressed(false);
                }
                if (this.XB != null) {
                    this.XB.cancel();
                    this.XB = null;
                }
            }
            if (z2) {
                if (this.XC == null) {
                    this.XC = new k(this);
                }
                this.XC.s(true);
                this.XC.onTouch(this, motionEvent);
            } else if (this.XC != null) {
                this.XC.s(false);
            }
            return z2;
        }

        protected final boolean fk() {
            return this.XA || super.fk();
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
    }

    static {
        try {
            WY = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
        }
        try {
            WZ = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.Xc = -2;
        this.Ul = -2;
        this.Xf = MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED;
        this.Qx = 0;
        this.Xh = false;
        this.Xi = false;
        this.Xj = Integer.MAX_VALUE;
        this.Xl = 0;
        this.Xr = new g();
        this.Xs = new f();
        this.Xt = new e();
        this.Xu = new c();
        this.ep = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.a.a.k.ck, i, i2);
        this.Xd = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.a.a.k.Lr, 0);
        this.Xe = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.a.a.k.Ls, 0);
        if (this.Xe != 0) {
            this.Xg = true;
        }
        obtainStyledAttributes.recycle();
        this.Xa = new AppCompatPopupWindow(context, attributeSet, i);
        this.Xa.setInputMethodMode(1);
        this.Wb = android.support.v4.d.f.getLayoutDirectionFromLocale(this.mContext.getResources().getConfiguration().locale);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.Xm == null) {
            this.Xm = new d();
        } else if (this.EK != null) {
            this.EK.unregisterDataSetObserver(this.Xm);
        }
        this.EK = listAdapter;
        if (this.EK != null) {
            listAdapter.registerDataSetObserver(this.Xm);
        }
        if (this.Xb != null) {
            this.Xb.setAdapter(this.EK);
        }
    }

    public final void fi() {
        this.Xw = true;
        this.Xa.setFocusable(true);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.Xa.setBackgroundDrawable(drawable);
    }

    public final void setContentWidth(int i) {
        Drawable background = this.Xa.getBackground();
        if (background != null) {
            background.getPadding(this.ep);
            this.Ul = (this.ep.left + this.ep.right) + i;
            return;
        }
        this.Ul = i;
    }

    public void show() {
        int i;
        int i2;
        boolean z;
        int makeMeasureSpec;
        boolean z2 = true;
        LayoutParams layoutParams;
        View view;
        if (this.Xb == null) {
            Context context = this.mContext;
            this.Xv = new Runnable(this) {
                final /* synthetic */ ListPopupWindow Xx;

                {
                    this.Xx = r1;
                }

                public final void run() {
                    View view = this.Xx.Xn;
                    if (view != null && view.getWindowToken() != null) {
                        this.Xx.show();
                    }
                }
            };
            this.Xb = new a(context, !this.Xw);
            if (this.Xo != null) {
                this.Xb.setSelector(this.Xo);
            }
            this.Xb.setAdapter(this.EK);
            this.Xb.setOnItemClickListener(this.Xp);
            this.Xb.setFocusable(true);
            this.Xb.setFocusableInTouchMode(true);
            this.Xb.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ ListPopupWindow Xx;

                {
                    this.Xx = r1;
                }

                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a a = this.Xx.Xb;
                        if (a != null) {
                            a.Xy = false;
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.Xb.setOnScrollListener(this.Xt);
            if (this.Xq != null) {
                this.Xb.setOnItemSelectedListener(this.Xq);
            }
            View view2 = this.Xb;
            View view3 = this.Xk;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.Xl) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.Xl);
                        break;
                }
                if (this.Ul >= 0) {
                    i = this.Ul;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.Xa.setContentView(view);
        } else {
            this.Xa.getContentView();
            view = this.Xk;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.Xa.getBackground();
        if (background != null) {
            background.getPadding(this.ep);
            i = this.ep.top + this.ep.bottom;
            if (!this.Xg) {
                this.Xe = -this.ep.top;
            }
        } else {
            this.ep.setEmpty();
            i = 0;
        }
        if (this.Xa.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        int b = b(this.Xn, this.Xe, z);
        if (this.Xh || this.Xc == -1) {
            i2 = b + i;
        } else {
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
            makeMeasureSpec = this.Xb.K(makeMeasureSpec, b - i2);
            if (makeMeasureSpec > 0) {
                i2 += i;
            }
            i2 += makeMeasureSpec;
        }
        z = isInputMethodNotNeeded();
        m.a(this.Xa, this.Xf);
        if (this.Xa.isShowing()) {
            if (this.Ul == -1) {
                i = -1;
            } else if (this.Ul == -2) {
                i = this.Xn.getWidth();
            } else {
                i = this.Ul;
            }
            if (this.Xc == -1) {
                if (z) {
                    makeMeasureSpec = i2;
                } else {
                    makeMeasureSpec = -1;
                }
                PopupWindow popupWindow;
                if (z) {
                    popupWindow = this.Xa;
                    if (this.Ul == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.Xa.setHeight(0);
                    b = makeMeasureSpec;
                } else {
                    popupWindow = this.Xa;
                    if (this.Ul == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.Xa.setHeight(-1);
                    b = makeMeasureSpec;
                }
            } else if (this.Xc == -2) {
                b = i2;
            } else {
                b = this.Xc;
            }
            PopupWindow popupWindow2 = this.Xa;
            if (this.Xi || this.Xh) {
                z2 = false;
            }
            popupWindow2.setOutsideTouchable(z2);
            popupWindow2 = this.Xa;
            View view4 = this.Xn;
            int i3 = this.Xd;
            makeMeasureSpec = this.Xe;
            if (i < 0) {
                i = -1;
            }
            if (b < 0) {
                b = -1;
            }
            popupWindow2.update(view4, i3, makeMeasureSpec, i, b);
            return;
        }
        if (this.Ul == -1) {
            makeMeasureSpec = -1;
        } else if (this.Ul == -2) {
            makeMeasureSpec = this.Xn.getWidth();
        } else {
            makeMeasureSpec = this.Ul;
        }
        if (this.Xc == -1) {
            i2 = -1;
        } else if (this.Xc != -2) {
            i2 = this.Xc;
        }
        this.Xa.setWidth(makeMeasureSpec);
        this.Xa.setHeight(i2);
        if (WY != null) {
            try {
                WY.invoke(this.Xa, new Object[]{Boolean.valueOf(true)});
            } catch (Exception e) {
            }
        }
        popupWindow2 = this.Xa;
        if (this.Xi || this.Xh) {
            z2 = false;
        }
        popupWindow2.setOutsideTouchable(z2);
        this.Xa.setTouchInterceptor(this.Xs);
        m.a(this.Xa, this.Xn, this.Xd, this.Xe, this.Qx);
        this.Xb.setSelection(-1);
        if (!this.Xw || this.Xb.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Xw) {
            this.mHandler.post(this.Xu);
        }
    }

    public final void dismiss() {
        this.Xa.dismiss();
        if (this.Xk != null) {
            ViewParent parent = this.Xk.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.Xk);
            }
        }
        this.Xa.setContentView(null);
        this.Xb = null;
        this.mHandler.removeCallbacks(this.Xr);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.Xa.setOnDismissListener(onDismissListener);
    }

    public final void fj() {
        this.Xa.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        a aVar = this.Xb;
        if (aVar != null) {
            aVar.Xy = true;
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.Xa.getInputMethodMode() == 2;
    }

    private int b(View view, int i, boolean z) {
        if (WZ != null) {
            try {
                return ((Integer) WZ.invoke(this.Xa, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
            }
        }
        return this.Xa.getMaxAvailableHeight(view, i);
    }
}

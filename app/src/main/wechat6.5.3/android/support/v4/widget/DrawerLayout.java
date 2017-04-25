package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.ae;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mmdb.database.SQLiteDebug;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements h {
    private static final boolean AG = (VERSION.SDK_INT >= 19);
    private static final boolean AH;
    static final c Bj;
    private static final int[] xv = new int[]{16842931};
    private final b AI;
    private float AJ;
    private int AK;
    private int AL;
    private float AM;
    private Paint AN;
    final u AO;
    final u AP;
    private final f AQ;
    private final f AR;
    int AS;
    private int AT;
    private int AU;
    private int AV;
    private int AW;
    private boolean AX;
    boolean AY;
    private Drawable AZ;
    private Drawable Ba;
    CharSequence Bb;
    CharSequence Bc;
    private Object Bd;
    private Drawable Be;
    private Drawable Bf;
    private Drawable Bg;
    private Drawable Bh;
    private final ArrayList<View> Bi;
    List<Object> eD;
    private boolean ho;
    private Drawable hp;
    private boolean oQ;
    private float wL;
    private float wM;
    private boolean yf;

    public static class LayoutParams extends MarginLayoutParams {
        private float Bl;
        private boolean Bm;
        private int Bn;
        public int gravity = 0;

        static /* synthetic */ int b(LayoutParams layoutParams, int i) {
            int i2 = layoutParams.Bn | i;
            layoutParams.Bn = i2;
            return i2;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.xv);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Bo = 0;
        int Bp;
        int Bq;
        int Br;
        int Bs;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.Bo = parcel.readInt();
            this.Bp = parcel.readInt();
            this.Bq = parcel.readInt();
            this.Br = parcel.readInt();
            this.Bs = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Bo);
            parcel.writeInt(this.Bp);
            parcel.writeInt(this.Bq);
            parcel.writeInt(this.Br);
            parcel.writeInt(this.Bs);
        }
    }

    interface c {
        int G(Object obj);

        void a(View view, Object obj, int i);

        void a(MarginLayoutParams marginLayoutParams, Object obj, int i);

        void aA(View view);

        Drawable k(Context context);
    }

    class a extends android.support.v4.view.a {
        final /* synthetic */ DrawerLayout Bk;
        private final Rect gF = new Rect();

        a(DrawerLayout drawerLayout) {
            this.Bk = drawerLayout;
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            if (DrawerLayout.AG) {
                super.a(view, bVar);
            } else {
                android.support.v4.view.a.b a = android.support.v4.view.a.b.a(bVar);
                super.a(view, a);
                bVar.setSource(view);
                ViewParent J = y.J(view);
                if (J instanceof View) {
                    bVar.setParent((View) J);
                }
                Rect rect = this.gF;
                a.getBoundsInParent(rect);
                bVar.setBoundsInParent(rect);
                a.getBoundsInScreen(rect);
                bVar.setBoundsInScreen(rect);
                bVar.setVisibleToUser(a.isVisibleToUser());
                bVar.setPackageName(a.getPackageName());
                bVar.setClassName(a.getClassName());
                bVar.setContentDescription(a.getContentDescription());
                bVar.setEnabled(a.isEnabled());
                bVar.setClickable(a.isClickable());
                bVar.setFocusable(a.isFocusable());
                bVar.setFocused(a.isFocused());
                bVar.setAccessibilityFocused(a.isAccessibilityFocused());
                bVar.setSelected(a.isSelected());
                bVar.setLongClickable(a.isLongClickable());
                bVar.addAction(a.getActions());
                a.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.az(childAt)) {
                        bVar.addChild(childAt);
                    }
                }
            }
            bVar.setClassName(DrawerLayout.class.getName());
            bVar.setFocusable(false);
            bVar.setFocused(false);
            bVar.a(android.support.v4.view.a.b.a.yU);
            bVar.a(android.support.v4.view.a.b.a.yV);
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View a = this.Bk.cr();
            if (a != null) {
                int au = this.Bk.au(a);
                View view2 = this.Bk;
                au = android.support.v4.view.e.getAbsoluteGravity(au, y.I(view2));
                Object obj = au == 3 ? view2.Bb : au == 5 ? view2.Bc : null;
                if (obj != null) {
                    text.add(obj);
                }
            }
            return true;
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.AG || DrawerLayout.az(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    final class b extends android.support.v4.view.a {
        final /* synthetic */ DrawerLayout Bk;

        b(DrawerLayout drawerLayout) {
            this.Bk = drawerLayout;
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            if (!DrawerLayout.az(view)) {
                bVar.setParent(null);
            }
        }
    }

    static class d implements c {
        d() {
        }

        public final void aA(View view) {
            g.aA(view);
        }

        public final void a(View view, Object obj, int i) {
            g.a(view, obj, i);
        }

        public final void a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            g.a(marginLayoutParams, obj, i);
        }

        public final int G(Object obj) {
            return g.G(obj);
        }

        public final Drawable k(Context context) {
            return g.k(context);
        }
    }

    static class e implements c {
        e() {
        }

        public final void aA(View view) {
        }

        public final void a(View view, Object obj, int i) {
        }

        public final void a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public final int G(Object obj) {
            return 0;
        }

        public final Drawable k(Context context) {
            return null;
        }
    }

    private class f extends android.support.v4.widget.u.a {
        final /* synthetic */ DrawerLayout Bk;
        final int Bt;
        u Bu;
        private final Runnable Bv = new Runnable(this) {
            final /* synthetic */ f Bw;

            {
                this.Bw = r1;
            }

            public final void run() {
                View view;
                int i;
                int i2 = 0;
                f fVar = this.Bw;
                int i3 = fVar.Bu.Ef;
                boolean z = fVar.Bt == 3;
                int i4;
                if (z) {
                    View ag = fVar.Bk.ag(3);
                    i4 = (ag != null ? -ag.getWidth() : 0) + i3;
                    view = ag;
                    i = i4;
                } else {
                    i4 = fVar.Bk.getWidth() - i3;
                    view = fVar.Bk.ag(5);
                    i = i4;
                }
                if (view == null) {
                    return;
                }
                if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && fVar.Bk.as(view) == 0) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    fVar.Bu.e(view, i, view.getTop());
                    layoutParams.Bm = true;
                    fVar.Bk.invalidate();
                    fVar.ct();
                    DrawerLayout drawerLayout = fVar.Bk;
                    if (!drawerLayout.AY) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        i = drawerLayout.getChildCount();
                        while (i2 < i) {
                            drawerLayout.getChildAt(i2).dispatchTouchEvent(obtain);
                            i2++;
                        }
                        obtain.recycle();
                        drawerLayout.AY = true;
                    }
                }
            }
        };

        public f(DrawerLayout drawerLayout, int i) {
            this.Bk = drawerLayout;
            this.Bt = i;
        }

        public final void cp() {
            this.Bk.removeCallbacks(this.Bv);
        }

        public final boolean a(View view, int i) {
            return DrawerLayout.aw(view) && this.Bk.l(view, this.Bt) && this.Bk.as(view) == 0;
        }

        public final void j(int i) {
            int size;
            DrawerLayout drawerLayout = this.Bk;
            View view = this.Bu.Ei;
            int i2 = drawerLayout.AO.DU;
            int i3 = drawerLayout.AP.DU;
            i2 = (i2 == 1 || i3 == 1) ? 1 : (i2 == 2 || i3 == 2) ? 2 : 0;
            if (view != null && i == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.Bl == 0.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.Bn & 1) == 1) {
                        layoutParams.Bn = 0;
                        if (drawerLayout.eD != null) {
                            for (size = drawerLayout.eD.size() - 1; size >= 0; size--) {
                                drawerLayout.eD.get(size);
                            }
                        }
                        drawerLayout.d(view, false);
                        if (drawerLayout.hasWindowFocus()) {
                            View rootView = drawerLayout.getRootView();
                            if (rootView != null) {
                                rootView.sendAccessibilityEvent(32);
                            }
                        }
                    }
                } else if (layoutParams.Bl == 1.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.Bn & 1) == 0) {
                        layoutParams.Bn = 1;
                        if (drawerLayout.eD != null) {
                            for (size = drawerLayout.eD.size() - 1; size >= 0; size--) {
                                drawerLayout.eD.get(size);
                            }
                        }
                        drawerLayout.d(view, true);
                        if (drawerLayout.hasWindowFocus()) {
                            drawerLayout.sendAccessibilityEvent(32);
                        }
                        view.requestFocus();
                    }
                }
            }
            if (i2 != drawerLayout.AS) {
                drawerLayout.AS = i2;
                if (drawerLayout.eD != null) {
                    for (size = drawerLayout.eD.size() - 1; size >= 0; size--) {
                        drawerLayout.eD.get(size);
                    }
                }
            }
        }

        public final void a(View view, int i, int i2) {
            float f;
            int width = view.getWidth();
            if (this.Bk.l(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (this.Bk.getWidth() - i)) / ((float) width);
            }
            this.Bk.h(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            this.Bk.invalidate();
        }

        public final void e(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).Bm = false;
            ct();
        }

        final void ct() {
            int i = 3;
            if (this.Bt == 3) {
                i = 5;
            }
            View ag = this.Bk.ag(i);
            if (ag != null) {
                this.Bk.ay(ag);
            }
        }

        public final void a(View view, float f, float f2) {
            int i;
            float at = DrawerLayout.at(view);
            int width = view.getWidth();
            if (this.Bk.l(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && at > 0.5f)) ? 0 : -width;
            } else {
                i = this.Bk.getWidth();
                if (f < 0.0f || (f == 0.0f && at > 0.5f)) {
                    i -= width;
                }
            }
            this.Bu.p(i, view.getTop());
            this.Bk.invalidate();
        }

        public final void cu() {
            this.Bk.postDelayed(this.Bv, 160);
        }

        public final void m(int i, int i2) {
            View ag;
            if ((i & 1) == 1) {
                ag = this.Bk.ag(3);
            } else {
                ag = this.Bk.ag(5);
            }
            if (ag != null && this.Bk.as(ag) == 0) {
                this.Bu.m(ag, i2);
            }
        }

        public final int s(View view) {
            return DrawerLayout.aw(view) ? view.getWidth() : 0;
        }

        public final int c(View view, int i) {
            if (this.Bk.l(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.Bk.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public final int b(View view, int i) {
            return view.getTop();
        }
    }

    static /* synthetic */ boolean az(View view) {
        return (y.F(view) == 4 || y.F(view) == 2) ? false : true;
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        AH = z;
        if (VERSION.SDK_INT >= 21) {
            Bj = new d();
        } else {
            Bj = new e();
        }
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.AI = new b(this);
        this.AL = -1728053248;
        this.AN = new Paint();
        this.yf = true;
        this.AT = 3;
        this.AU = 3;
        this.AV = 3;
        this.AW = 3;
        this.Be = null;
        this.Bf = null;
        this.Bg = null;
        this.Bh = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.AK = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.AQ = new f(this, 3);
        this.AR = new f(this, 5);
        this.AO = u.a((ViewGroup) this, 1.0f, this.AQ);
        this.AO.Eg = 1;
        this.AO.Ee = f2;
        this.AQ.Bu = this.AO;
        this.AP = u.a((ViewGroup) this, 1.0f, this.AR);
        this.AP.Eg = 2;
        this.AP.Ee = f2;
        this.AR.Bu = this.AP;
        setFocusableInTouchMode(true);
        y.h(this, 1);
        y.a((View) this, new a(this));
        ae.b(this);
        if (y.Z(this)) {
            Bj.aA(this);
            this.hp = Bj.k(context);
        }
        this.AJ = f * 10.0f;
        this.Bi = new ArrayList();
    }

    public final void k(Object obj, boolean z) {
        this.Bd = obj;
        this.ho = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    private void l(int i, int i2) {
        int absoluteGravity = android.support.v4.view.e.getAbsoluteGravity(i2, y.I(this));
        switch (i2) {
            case 3:
                this.AT = i;
                break;
            case 5:
                this.AU = i;
                break;
            case 8388611:
                this.AV = i;
                break;
            case 8388613:
                this.AW = i;
                break;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.AO : this.AP).cancel();
        }
        View ag;
        switch (i) {
            case 1:
                ag = ag(absoluteGravity);
                if (ag != null) {
                    ay(ag);
                    return;
                }
                return;
            case 2:
                ag = ag(absoluteGravity);
                if (ag != null) {
                    ax(ag);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int as(View view) {
        if (aw(view)) {
            int i = ((LayoutParams) view.getLayoutParams()).gravity;
            int I = y.I(this);
            switch (i) {
                case 3:
                    if (this.AT != 3) {
                        return this.AT;
                    }
                    i = I == 0 ? this.AV : this.AW;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 5:
                    if (this.AU != 3) {
                        return this.AU;
                    }
                    i = I == 0 ? this.AW : this.AV;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388611:
                    if (this.AV != 3) {
                        return this.AV;
                    }
                    i = I == 0 ? this.AT : this.AU;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388613:
                    if (this.AW != 3) {
                        return this.AW;
                    }
                    i = I == 0 ? this.AU : this.AT;
                    if (i != 3) {
                        return i;
                    }
                    break;
            }
            return 0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    final void d(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || aw(childAt)) && !(z && childAt == view)) {
                y.h(childAt, 4);
            } else {
                y.h(childAt, 1);
            }
        }
    }

    final void h(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.Bl) {
            layoutParams.Bl = f;
            if (this.eD != null) {
                for (int size = this.eD.size() - 1; size >= 0; size--) {
                    this.eD.get(size);
                }
            }
        }
    }

    static float at(View view) {
        return ((LayoutParams) view.getLayoutParams()).Bl;
    }

    final int au(View view) {
        return android.support.v4.view.e.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, y.I(this));
    }

    final boolean l(View view, int i) {
        return (au(view) & i) == i;
    }

    private View cq() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).Bn & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    final View ag(int i) {
        int absoluteGravity = android.support.v4.view.e.getAbsoluteGravity(i, y.I(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((au(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.yf = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.yf = true;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int I;
        Object obj2;
        Object obj3;
        int childCount;
        int i3;
        View childAt;
        MarginLayoutParams marginLayoutParams;
        int absoluteGravity;
        int au;
        Object obj4;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    mode = size;
                    size = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
                    setMeasuredDimension(mode, size);
                    if (this.Bd == null && y.Z(this)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    I = y.I(this);
                    obj2 = null;
                    obj3 = null;
                    childCount = getChildCount();
                    for (i3 = 0; i3 < childCount; i3++) {
                        childAt = getChildAt(i3);
                        if (childAt.getVisibility() != 8) {
                            marginLayoutParams = (LayoutParams) childAt.getLayoutParams();
                            if (obj != null) {
                                absoluteGravity = android.support.v4.view.e.getAbsoluteGravity(marginLayoutParams.gravity, I);
                                if (y.Z(childAt)) {
                                    Bj.a(marginLayoutParams, this.Bd, absoluteGravity);
                                } else {
                                    Bj.a(childAt, this.Bd, absoluteGravity);
                                }
                            }
                            if (av(childAt)) {
                                childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                            } else if (aw(childAt)) {
                                throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                            } else {
                                if (AH && y.W(childAt) != this.AJ) {
                                    y.g(childAt, this.AJ);
                                }
                                au = au(childAt) & 7;
                                obj4 = au != 3 ? 1 : null;
                                if ((obj4 != null || r5 == null) && (obj4 != null || r4 == null)) {
                                    if (obj4 == null) {
                                        obj2 = 1;
                                    } else {
                                        obj3 = 1;
                                    }
                                    childAt.measure(getChildMeasureSpec(i, (this.AK + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                                } else {
                                    StringBuilder stringBuilder = new StringBuilder("Child drawer has absolute gravity ");
                                    String toHexString = (au & 3) == 3 ? "LEFT" : (au & 5) == 5 ? "RIGHT" : Integer.toHexString(au);
                                    throw new IllegalStateException(stringBuilder.append(toHexString).append(" but this DrawerLayout already has a drawer view along that edge").toString());
                                }
                            }
                        }
                    }
                }
            }
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        mode = size;
        size = size2;
        setMeasuredDimension(mode, size);
        if (this.Bd == null) {
        }
        obj = null;
        I = y.I(this);
        obj2 = null;
        obj3 = null;
        childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                marginLayoutParams = (LayoutParams) childAt.getLayoutParams();
                if (obj != null) {
                    absoluteGravity = android.support.v4.view.e.getAbsoluteGravity(marginLayoutParams.gravity, I);
                    if (y.Z(childAt)) {
                        Bj.a(marginLayoutParams, this.Bd, absoluteGravity);
                    } else {
                        Bj.a(childAt, this.Bd, absoluteGravity);
                    }
                }
                if (av(childAt)) {
                    childAt.measure(MeasureSpec.makeMeasureSpec((mode - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((size - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824));
                } else if (aw(childAt)) {
                    throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                } else {
                    y.g(childAt, this.AJ);
                    au = au(childAt) & 7;
                    if (au != 3) {
                    }
                    if (obj4 != null) {
                    }
                    if (obj4 == null) {
                        obj3 = 1;
                    } else {
                        obj2 = 1;
                    }
                    childAt.measure(getChildMeasureSpec(i, (this.AK + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i2, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                }
            }
        }
    }

    private static boolean c(Drawable drawable, int i) {
        if (drawable == null || !android.support.v4.b.a.a.c(drawable)) {
            return false;
        }
        android.support.v4.b.a.a.b(drawable, i);
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.oQ = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (av(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int a;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (l(childAt, 3)) {
                        a = ((int) (((float) measuredWidth) * layoutParams.Bl)) + (-measuredWidth);
                        f = ((float) (measuredWidth + a)) / ((float) measuredWidth);
                    } else {
                        a = i5 - ((int) (((float) measuredWidth) * layoutParams.Bl));
                        f = ((float) (i5 - a)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.Bl ? 1 : null;
                    int i7;
                    switch (layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                        case 16:
                            int i8 = i4 - i2;
                            i7 = (i8 - measuredHeight) / 2;
                            if (i7 < layoutParams.topMargin) {
                                i7 = layoutParams.topMargin;
                            } else if (i7 + measuredHeight > i8 - layoutParams.bottomMargin) {
                                i7 = (i8 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(a, i7, measuredWidth + a, measuredHeight + i7);
                            break;
                        case 80:
                            i7 = i4 - i2;
                            childAt.layout(a, (i7 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + a, i7 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(a, layoutParams.topMargin, measuredWidth + a, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        h(childAt, f);
                    }
                    int i9 = layoutParams.Bl > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i9) {
                        childAt.setVisibility(i9);
                    }
                }
            }
        }
        this.oQ = false;
        this.yf = false;
    }

    public void requestLayout() {
        if (!this.oQ) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).Bl);
        }
        this.AM = f;
        if ((this.AO.cL() | this.AP.cL()) != 0) {
            y.E(this);
        }
    }

    public void onRtlPropertiesChanged(int i) {
        if (!AH) {
            Drawable drawable;
            int I = y.I(this);
            if (I == 0) {
                if (this.Be != null) {
                    c(this.Be, I);
                    drawable = this.Be;
                }
                drawable = this.Bg;
            } else {
                if (this.Bf != null) {
                    c(this.Bf, I);
                    drawable = this.Bf;
                }
                drawable = this.Bg;
            }
            this.AZ = drawable;
            I = y.I(this);
            if (I == 0) {
                if (this.Bf != null) {
                    c(this.Bf, I);
                    drawable = this.Bf;
                }
                drawable = this.Bh;
            } else {
                if (this.Be != null) {
                    c(this.Be, I);
                    drawable = this.Be;
                }
                drawable = this.Bh;
            }
            this.Ba = drawable;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ho && this.hp != null) {
            int G = Bj.G(this.Bd);
            if (G > 0) {
                this.hp.setBounds(0, 0, getWidth(), G);
                this.hp.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int right;
        int height = getHeight();
        boolean av = av(view);
        int i = 0;
        int width = getWidth();
        int save = canvas.save();
        if (av) {
            int childCount = getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    Object obj = background != null ? background.getOpacity() == -1 ? 1 : null : null;
                    if (obj != null && aw(childAt) && childAt.getHeight() >= height) {
                        if (l(childAt, 3)) {
                            right = childAt.getRight();
                            if (right <= i) {
                                right = i;
                            }
                            i = right;
                            right = width;
                        } else {
                            right = childAt.getLeft();
                            if (right < width) {
                            }
                        }
                        i2++;
                        width = right;
                    }
                }
                right = width;
                i2++;
                width = right;
            }
            canvas.clipRect(i, 0, width, getHeight());
        }
        right = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.AM > 0.0f && av) {
            this.AN.setColor((((int) (((float) ((this.AL & WebView.NIGHT_MODE_COLOR) >>> 24)) * this.AM)) << 24) | (this.AL & 16777215));
            canvas.drawRect((float) i, 0.0f, (float) right, (float) getHeight(), this.AN);
        } else if (this.AZ != null && l(view, 3)) {
            right = this.AZ.getIntrinsicWidth();
            i = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i) / ((float) this.AO.Ef), 1.0f));
            this.AZ.setBounds(i, view.getTop(), right + i, view.getBottom());
            this.AZ.setAlpha((int) (255.0f * r2));
            this.AZ.draw(canvas);
        } else if (this.Ba != null && l(view, 5)) {
            right = this.Ba.getIntrinsicWidth();
            i = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i)) / ((float) this.AP.Ef), 1.0f));
            this.Ba.setBounds(i - right, view.getTop(), i, view.getBottom());
            this.Ba.setAlpha((int) (255.0f * r2));
            this.Ba.draw(canvas);
        }
        return drawChild;
    }

    private static boolean av(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    static boolean aw(View view) {
        int absoluteGravity = android.support.v4.view.e.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, y.I(view));
        if ((absoluteGravity & 3) != 0) {
            return true;
        }
        if ((absoluteGravity & 5) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
        r9 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.n.d(r10);
        r3 = r9.AO;
        r3 = r3.j(r10);
        r4 = r9.AP;
        r4 = r4.j(r10);
        r4 = r4 | r3;
        switch(r0) {
            case 0: goto L_0x003b;
            case 1: goto L_0x00ad;
            case 2: goto L_0x0064;
            case 3: goto L_0x00ad;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r4 != 0) goto L_0x0039;
    L_0x0019:
        if (r0 != 0) goto L_0x0039;
    L_0x001b:
        r4 = r9.getChildCount();
        r3 = r2;
    L_0x0020:
        if (r3 >= r4) goto L_0x00bb;
    L_0x0022:
        r0 = r9.getChildAt(r3);
        r0 = r0.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        r0 = r0.Bm;
        if (r0 == 0) goto L_0x00b6;
    L_0x0032:
        r0 = r1;
    L_0x0033:
        if (r0 != 0) goto L_0x0039;
    L_0x0035:
        r0 = r9.AY;
        if (r0 == 0) goto L_0x003a;
    L_0x0039:
        r2 = r1;
    L_0x003a:
        return r2;
    L_0x003b:
        r0 = r10.getX();
        r3 = r10.getY();
        r9.wL = r0;
        r9.wM = r3;
        r5 = r9.AM;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x00be;
    L_0x004e:
        r5 = r9.AO;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r5.q(r0, r3);
        if (r0 == 0) goto L_0x00be;
    L_0x0058:
        r0 = av(r0);
        if (r0 == 0) goto L_0x00be;
    L_0x005e:
        r0 = r1;
    L_0x005f:
        r9.AX = r2;
        r9.AY = r2;
        goto L_0x0017;
    L_0x0064:
        r5 = r9.AO;
        r0 = r5.DV;
        r6 = r0.length;
        r0 = r2;
    L_0x006a:
        if (r0 >= r6) goto L_0x00ab;
    L_0x006c:
        r3 = r5.an(r0);
        if (r3 == 0) goto L_0x00a6;
    L_0x0072:
        r3 = r5.DX;
        r3 = r3[r0];
        r7 = r5.DV;
        r7 = r7[r0];
        r3 = r3 - r7;
        r7 = r5.DY;
        r7 = r7[r0];
        r8 = r5.DW;
        r8 = r8[r0];
        r7 = r7 - r8;
        r3 = r3 * r3;
        r7 = r7 * r7;
        r3 = r3 + r7;
        r7 = r5.iD;
        r8 = r5.iD;
        r7 = r7 * r8;
        r7 = (float) r7;
        r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r3 <= 0) goto L_0x00a4;
    L_0x0091:
        r3 = r1;
    L_0x0092:
        if (r3 == 0) goto L_0x00a8;
    L_0x0094:
        r0 = r1;
    L_0x0095:
        if (r0 == 0) goto L_0x0016;
    L_0x0097:
        r0 = r9.AQ;
        r0.cp();
        r0 = r9.AR;
        r0.cp();
        r0 = r2;
        goto L_0x0017;
    L_0x00a4:
        r3 = r2;
        goto L_0x0092;
    L_0x00a6:
        r3 = r2;
        goto L_0x0092;
    L_0x00a8:
        r0 = r0 + 1;
        goto L_0x006a;
    L_0x00ab:
        r0 = r2;
        goto L_0x0095;
    L_0x00ad:
        r9.t(r1);
        r9.AX = r2;
        r9.AY = r2;
        goto L_0x0016;
    L_0x00b6:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0020;
    L_0x00bb:
        r0 = r2;
        goto L_0x0033;
    L_0x00be:
        r0 = r2;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.AO.k(motionEvent);
        this.AP.k(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.wL = x;
                this.wM = y;
                this.AX = false;
                this.AY = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View q = this.AO.q((int) x, (int) y);
                if (q != null && av(q)) {
                    x -= this.wL;
                    y -= this.wM;
                    int i = this.AO.iD;
                    if ((x * x) + (y * y) < ((float) (i * i))) {
                        View cq = cq();
                        if (cq != null) {
                            z = as(cq) == 2;
                            t(z);
                            this.AX = false;
                            break;
                        }
                    }
                }
                z = true;
                t(z);
                this.AX = false;
            case 3:
                t(true);
                this.AX = false;
                this.AY = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.AX = z;
        if (z) {
            t(true);
        }
    }

    private void t(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (aw(childAt) && (!z || layoutParams.Bm)) {
                int width = childAt.getWidth();
                if (l(childAt, 3)) {
                    i |= this.AO.e(childAt, -width, childAt.getTop());
                } else {
                    i |= this.AP.e(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.Bm = false;
            }
        }
        this.AQ.cp();
        this.AR.cp();
        if (i != 0) {
            invalidate();
        }
    }

    private void ax(View view) {
        if (aw(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.yf) {
                layoutParams.Bl = 1.0f;
                layoutParams.Bn = 1;
                d(view, true);
            } else {
                LayoutParams.b(layoutParams, 2);
                if (l(view, 3)) {
                    this.AO.e(view, 0, view.getTop());
                } else {
                    this.AP.e(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void ay(View view) {
        if (aw(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.yf) {
                layoutParams.Bl = 0.0f;
                layoutParams.Bn = 0;
            } else {
                LayoutParams.b(layoutParams, 4);
                if (l(view, 3)) {
                    this.AO.e(view, -view.getWidth(), view.getTop());
                } else {
                    this.AP.e(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            int i3 = 0;
            Object obj = null;
            while (i3 < childCount) {
                Object obj2;
                View childAt = getChildAt(i3);
                if (!aw(childAt)) {
                    this.Bi.add(childAt);
                    obj2 = obj;
                } else if (aw(childAt)) {
                    if ((((LayoutParams) childAt.getLayoutParams()).Bn & 1) == 1) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        childAt.addFocusables(arrayList, i, i2);
                        obj2 = 1;
                    }
                    obj2 = obj;
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                i3++;
                obj = obj2;
            }
            if (obj == null) {
                int size = this.Bi.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = (View) this.Bi.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.Bi.clear();
        }
    }

    private View cr() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (aw(childAt)) {
                if (aw(childAt)) {
                    Object obj;
                    if (((LayoutParams) childAt.getLayoutParams()).Bl > 0.0f) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (cr() != null) {
                android.support.v4.view.f.b(keyEvent);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View cr = cr();
        if (cr != null && as(cr) == 0) {
            t(false);
        }
        if (cr != null) {
            return true;
        }
        return false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.Bo != 0) {
                View ag = ag(savedState.Bo);
                if (ag != null) {
                    ax(ag);
                }
            }
            if (savedState.Bp != 3) {
                l(savedState.Bp, 3);
            }
            if (savedState.Bq != 3) {
                l(savedState.Bq, 5);
            }
            if (savedState.Br != 3) {
                l(savedState.Br, 8388611);
            }
            if (savedState.Bs != 3) {
                l(savedState.Bs, 8388613);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            Object obj = layoutParams.Bn == 1 ? 1 : null;
            Object obj2;
            if (layoutParams.Bn == 2) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj != null || r4 != null) {
                savedState.Bo = layoutParams.gravity;
                break;
            }
        }
        savedState.Bp = this.AT;
        savedState.Bq = this.AU;
        savedState.Br = this.AV;
        savedState.Bs = this.AW;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (cq() != null || aw(view)) {
            y.h(view, 4);
        } else {
            y.h(view, 1);
        }
        if (!AG) {
            y.a(view, this.AI);
        }
    }
}

package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ac.AnonymousClass1;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.WeakHashMap;

public final class y {
    static final m xi;

    interface m {
        int B(View view);

        boolean C(View view);

        boolean D(View view);

        void E(View view);

        int F(View view);

        float G(View view);

        int H(View view);

        int I(View view);

        ViewParent J(View view);

        boolean K(View view);

        int L(View view);

        int M(View view);

        int O(View view);

        int P(View view);

        float Q(View view);

        float R(View view);

        int S(View view);

        int T(View view);

        ah U(View view);

        float V(View view);

        float W(View view);

        int X(View view);

        void Y(View view);

        boolean Z(View view);

        ao a(View view, ao aoVar);

        void a(View view, int i, Paint paint);

        void a(View view, ColorStateList colorStateList);

        void a(View view, Paint paint);

        void a(View view, Mode mode);

        void a(View view, a aVar);

        void a(View view, Runnable runnable);

        void a(View view, Runnable runnable, long j);

        void a(View view, boolean z);

        void a(ViewGroup viewGroup, boolean z);

        void aa(View view);

        boolean ac(View view);

        boolean ad(View view);

        ColorStateList ae(View view);

        Mode af(View view);

        boolean ag(View view);

        void ah(View view);

        boolean ai(View view);

        float aj(View view);

        boolean ak(View view);

        boolean al(View view);

        ao b(View view, ao aoVar);

        void b(View view, float f);

        void b(View view, int i, int i2, int i3, int i4);

        void b(View view, s sVar);

        void b(View view, boolean z);

        void c(View view, float f);

        void c(View view, int i, int i2);

        void c(View view, int i, int i2, int i3, int i4);

        void c(View view, boolean z);

        int combineMeasuredStates(int i, int i2);

        void d(View view, float f);

        void e(View view, float f);

        void f(View view, float f);

        boolean f(View view, int i);

        void g(View view, float f);

        boolean g(View view, int i);

        void h(View view, int i);

        void i(View view, int i);

        void j(View view, int i);

        void k(View view, int i);

        int resolveSizeAndState(int i, int i2, int i3);
    }

    static class a implements m {
        WeakHashMap<View, ah> xj = null;

        a() {
        }

        public boolean f(View view, int i) {
            if (view instanceof v) {
                boolean z;
                v vVar = (v) view;
                int computeHorizontalScrollOffset = vVar.computeHorizontalScrollOffset();
                int computeHorizontalScrollRange = vVar.computeHorizontalScrollRange() - vVar.computeHorizontalScrollExtent();
                if (computeHorizontalScrollRange != 0) {
                    if (i < 0) {
                        z = computeHorizontalScrollOffset > 0;
                    } else if (computeHorizontalScrollOffset < computeHorizontalScrollRange - 1) {
                        z = true;
                    }
                    if (z) {
                        return true;
                    }
                }
                z = false;
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public boolean g(View view, int i) {
            if (view instanceof v) {
                boolean z;
                v vVar = (v) view;
                int computeVerticalScrollOffset = vVar.computeVerticalScrollOffset();
                int computeVerticalScrollRange = vVar.computeVerticalScrollRange() - vVar.computeVerticalScrollExtent();
                if (computeVerticalScrollRange != 0) {
                    if (i < 0) {
                        z = computeVerticalScrollOffset > 0;
                    } else if (computeVerticalScrollOffset < computeVerticalScrollRange - 1) {
                        z = true;
                    }
                    if (z) {
                        return true;
                    }
                }
                z = false;
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public int B(View view) {
            return 2;
        }

        public void a(View view, a aVar) {
        }

        public boolean C(View view) {
            return false;
        }

        public boolean D(View view) {
            return false;
        }

        public void E(View view) {
            view.invalidate();
        }

        public void b(View view, int i, int i2, int i3, int i4) {
            view.invalidate(i, i2, i3, i4);
        }

        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, bQ());
        }

        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, bQ() + j);
        }

        long bQ() {
            return 10;
        }

        public int F(View view) {
            return 0;
        }

        public void h(View view, int i) {
        }

        public float G(View view) {
            return 1.0f;
        }

        public void a(View view, int i, Paint paint) {
        }

        public int H(View view) {
            return 0;
        }

        public void a(View view, Paint paint) {
        }

        public int I(View view) {
            return 0;
        }

        public ViewParent J(View view) {
            return view.getParent();
        }

        public boolean K(View view) {
            Drawable background = view.getBackground();
            if (background == null || background.getOpacity() != -1) {
                return false;
            }
            return true;
        }

        public int resolveSizeAndState(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        public int L(View view) {
            return view.getMeasuredWidth();
        }

        public int M(View view) {
            return 0;
        }

        public void k(View view, int i) {
        }

        public int O(View view) {
            return view.getPaddingLeft();
        }

        public int P(View view) {
            return view.getPaddingRight();
        }

        public void c(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public boolean ac(View view) {
            return true;
        }

        public float Q(View view) {
            return 0.0f;
        }

        public float R(View view) {
            return 0.0f;
        }

        public float V(View view) {
            return 0.0f;
        }

        public int S(View view) {
            return z.S(view);
        }

        public int T(View view) {
            return z.T(view);
        }

        public ah U(View view) {
            return new ah(view);
        }

        public void b(View view, float f) {
        }

        public void c(View view, float f) {
        }

        public void d(View view, float f) {
        }

        public void e(View view, float f) {
        }

        public void f(View view, float f) {
        }

        public int X(View view) {
            return 0;
        }

        public void Y(View view) {
        }

        public void g(View view, float f) {
        }

        public float W(View view) {
            return 0.0f;
        }

        public float am(View view) {
            return 0.0f;
        }

        public void a(ViewGroup viewGroup, boolean z) {
        }

        public boolean Z(View view) {
            return false;
        }

        public void a(View view, boolean z) {
        }

        public void aa(View view) {
        }

        public void b(View view, s sVar) {
        }

        public ao a(View view, ao aoVar) {
            return aoVar;
        }

        public ao b(View view, ao aoVar) {
            return aoVar;
        }

        public void c(View view, boolean z) {
        }

        public void b(View view, boolean z) {
        }

        public boolean ad(View view) {
            return false;
        }

        public boolean ag(View view) {
            if (view instanceof o) {
                return ((o) view).isNestedScrollingEnabled();
            }
            return false;
        }

        public ColorStateList ae(View view) {
            return view instanceof w ? ((w) view).bO() : null;
        }

        public void a(View view, ColorStateList colorStateList) {
            if (view instanceof w) {
                ((w) view).e(colorStateList);
            }
        }

        public void a(View view, Mode mode) {
            if (view instanceof w) {
                ((w) view).b(mode);
            }
        }

        public Mode af(View view) {
            return view instanceof w ? ((w) view).bP() : null;
        }

        public void ah(View view) {
            if (view instanceof o) {
                ((o) view).stopNestedScroll();
            }
        }

        public boolean ai(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public int combineMeasuredStates(int i, int i2) {
            return i | i2;
        }

        public float aj(View view) {
            return am(view) + W(view);
        }

        public boolean ak(View view) {
            return view.getWindowToken() != null;
        }

        public boolean al(View view) {
            return false;
        }

        public void c(View view, int i, int i2) {
        }

        public void j(View view, int i) {
            int left = view.getLeft();
            view.offsetLeftAndRight(i);
            if (i != 0) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    int abs = Math.abs(i);
                    ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                    return;
                }
                view.invalidate();
            }
        }

        public void i(View view, int i) {
            int top = view.getTop();
            view.offsetTopAndBottom(i);
            if (i != 0) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    int abs = Math.abs(i);
                    ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                    return;
                }
                view.invalidate();
            }
        }
    }

    static class b extends a {
        b() {
        }

        public final boolean K(View view) {
            return view.isOpaque();
        }

        public final void a(ViewGroup viewGroup, boolean z) {
            if (aa.xq == null) {
                try {
                    aa.xq = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                }
                aa.xq.setAccessible(true);
            }
            try {
                aa.xq.invoke(viewGroup, new Object[]{Boolean.valueOf(true)});
            } catch (IllegalAccessException e2) {
            } catch (IllegalArgumentException e3) {
            } catch (InvocationTargetException e4) {
            }
        }
    }

    static class c extends b {
        c() {
        }

        public final int B(View view) {
            return view.getOverScrollMode();
        }
    }

    static class d extends c {
        d() {
        }

        final long bQ() {
            return ValueAnimator.getFrameDelay();
        }

        public final float G(View view) {
            return view.getAlpha();
        }

        public final void a(View view, int i, Paint paint) {
            view.setLayerType(i, paint);
        }

        public final int H(View view) {
            return view.getLayerType();
        }

        public void a(View view, Paint paint) {
            a(view, view.getLayerType(), paint);
            view.invalidate();
        }

        public final int resolveSizeAndState(int i, int i2, int i3) {
            return View.resolveSizeAndState(i, i2, i3);
        }

        public final int L(View view) {
            return view.getMeasuredWidthAndState();
        }

        public final int M(View view) {
            return view.getMeasuredState();
        }

        public final float Q(View view) {
            return view.getTranslationX();
        }

        public final float R(View view) {
            return view.getTranslationY();
        }

        public final void b(View view, float f) {
            view.setTranslationX(f);
        }

        public final void c(View view, float f) {
            view.setTranslationY(f);
        }

        public final void d(View view, float f) {
            view.setAlpha(f);
        }

        public final void e(View view, float f) {
            view.setScaleX(f);
        }

        public final void f(View view, float f) {
            view.setScaleY(f);
        }

        public final float V(View view) {
            return view.getScaleX();
        }

        public final void aa(View view) {
            view.jumpDrawablesToCurrentState();
        }

        public final void c(View view, boolean z) {
            view.setSaveFromParentEnabled(false);
        }

        public final void b(View view, boolean z) {
            view.setActivated(z);
        }

        public final int combineMeasuredStates(int i, int i2) {
            return View.combineMeasuredStates(i, i2);
        }

        public void j(View view, int i) {
            ab.j(view, i);
        }

        public void i(View view, int i) {
            ab.i(view, i);
        }
    }

    static class f extends d {
        static Field xk;
        static boolean xl = false;

        f() {
        }

        public final boolean f(View view, int i) {
            return view.canScrollHorizontally(i);
        }

        public final boolean g(View view, int i) {
            return view.canScrollVertically(i);
        }

        public final void a(View view, a aVar) {
            view.setAccessibilityDelegate((AccessibilityDelegate) (aVar == null ? null : aVar.vY));
        }

        public final boolean C(View view) {
            if (xl) {
                return false;
            }
            if (xk == null) {
                try {
                    Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                    xk = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable th) {
                    xl = true;
                    return false;
                }
            }
            try {
                if (xk.get(view) != null) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                xl = true;
                return false;
            }
        }

        public final ah U(View view) {
            if (this.xj == null) {
                this.xj = new WeakHashMap();
            }
            ah ahVar = (ah) this.xj.get(view);
            if (ahVar != null) {
                return ahVar;
            }
            ahVar = new ah(view);
            this.xj.put(view, ahVar);
            return ahVar;
        }

        public final void a(View view, boolean z) {
            view.setFitsSystemWindows(z);
        }
    }

    static class e extends f {
        e() {
        }

        public final boolean al(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class g extends e {
        g() {
        }

        public final boolean D(View view) {
            return view.hasTransientState();
        }

        public final void E(View view) {
            view.postInvalidateOnAnimation();
        }

        public final void b(View view, int i, int i2, int i3, int i4) {
            view.postInvalidate(i, i2, i3, i4);
        }

        public final void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public final void a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public final int F(View view) {
            return view.getImportantForAccessibility();
        }

        public void h(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        public final ViewParent J(View view) {
            return view.getParentForAccessibility();
        }

        public final int S(View view) {
            return view.getMinimumWidth();
        }

        public final int T(View view) {
            return view.getMinimumHeight();
        }

        public void Y(View view) {
            view.requestFitSystemWindows();
        }

        public final boolean Z(View view) {
            return view.getFitsSystemWindows();
        }

        public final boolean ac(View view) {
            return view.hasOverlappingRendering();
        }
    }

    static class h extends g {
        h() {
        }

        public final void a(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public final int I(View view) {
            return view.getLayoutDirection();
        }

        public final int O(View view) {
            return view.getPaddingStart();
        }

        public final int P(View view) {
            return view.getPaddingEnd();
        }

        public final void c(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        public final int X(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public final boolean ad(View view) {
            return view.isPaddingRelative();
        }
    }

    static class i extends h {
        i() {
        }
    }

    static class j extends i {
        j() {
        }

        public final void k(View view, int i) {
            view.setAccessibilityLiveRegion(1);
        }

        public final void h(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        public final boolean ai(View view) {
            return view.isLaidOut();
        }

        public final boolean ak(View view) {
            return view.isAttachedToWindow();
        }
    }

    static class k extends j {
        k() {
        }

        public final void Y(View view) {
            view.requestApplyInsets();
        }

        public final void g(View view, float f) {
            view.setElevation(f);
        }

        public final float W(View view) {
            return view.getElevation();
        }

        public final float am(View view) {
            return view.getTranslationZ();
        }

        public final void b(View view, s sVar) {
            if (sVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new AnonymousClass1(sVar));
            }
        }

        public final boolean ag(View view) {
            return view.isNestedScrollingEnabled();
        }

        public final void ah(View view) {
            view.stopNestedScroll();
        }

        public final ColorStateList ae(View view) {
            return view.getBackgroundTintList();
        }

        public final void a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public final void a(View view, Mode mode) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public final Mode af(View view) {
            return view.getBackgroundTintMode();
        }

        public final ao a(View view, ao aoVar) {
            if (!(aoVar instanceof ap)) {
                return aoVar;
            }
            WindowInsets windowInsets = ((ap) aoVar).yQ;
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            return onApplyWindowInsets != windowInsets ? new ap(onApplyWindowInsets) : aoVar;
        }

        public final ao b(View view, ao aoVar) {
            if (!(aoVar instanceof ap)) {
                return aoVar;
            }
            WindowInsets windowInsets = ((ap) aoVar).yQ;
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            return dispatchApplyWindowInsets != windowInsets ? new ap(dispatchApplyWindowInsets) : aoVar;
        }

        public final float aj(View view) {
            return view.getZ();
        }

        public void j(View view, int i) {
            Object obj;
            Rect bR = ac.bR();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                bR.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !bR.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            ab.j(view, i);
            if (obj != null && bR.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(bR);
            }
        }

        public void i(View view, int i) {
            Object obj;
            Rect bR = ac.bR();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                bR.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !bR.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            ab.i(view, i);
            if (obj != null && bR.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(bR);
            }
        }
    }

    static class l extends k {
        l() {
        }

        public final void c(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }

        public final void j(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        public final void i(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            xi = new l();
        } else if (i >= 21) {
            xi = new k();
        } else if (i >= 19) {
            xi = new j();
        } else if (i >= 17) {
            xi = new h();
        } else if (i >= 16) {
            xi = new g();
        } else if (i >= 15) {
            xi = new e();
        } else if (i >= 14) {
            xi = new f();
        } else if (i >= 11) {
            xi = new d();
        } else if (i >= 9) {
            xi = new c();
        } else if (i >= 7) {
            xi = new b();
        } else {
            xi = new a();
        }
    }

    public static boolean f(View view, int i) {
        return xi.f(view, i);
    }

    public static boolean g(View view, int i) {
        return xi.g(view, i);
    }

    public static int B(View view) {
        return xi.B(view);
    }

    public static void a(View view, a aVar) {
        xi.a(view, aVar);
    }

    public static boolean C(View view) {
        return xi.C(view);
    }

    public static boolean D(View view) {
        return xi.D(view);
    }

    public static void E(View view) {
        xi.E(view);
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        xi.b(view, i, i2, i3, i4);
    }

    public static void a(View view, Runnable runnable) {
        xi.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        xi.a(view, runnable, j);
    }

    public static int F(View view) {
        return xi.F(view);
    }

    public static void h(View view, int i) {
        xi.h(view, i);
    }

    public static float G(View view) {
        return xi.G(view);
    }

    public static void a(View view, int i, Paint paint) {
        xi.a(view, i, paint);
    }

    public static int H(View view) {
        return xi.H(view);
    }

    public static void a(View view, Paint paint) {
        xi.a(view, paint);
    }

    public static int I(View view) {
        return xi.I(view);
    }

    public static ViewParent J(View view) {
        return xi.J(view);
    }

    public static boolean K(View view) {
        return xi.K(view);
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        return xi.resolveSizeAndState(i, i2, i3);
    }

    public static int L(View view) {
        return xi.L(view);
    }

    public static int M(View view) {
        return xi.M(view);
    }

    public static int combineMeasuredStates(int i, int i2) {
        return xi.combineMeasuredStates(i, i2);
    }

    public static void N(View view) {
        xi.k(view, 1);
    }

    public static int O(View view) {
        return xi.O(view);
    }

    public static int P(View view) {
        return xi.P(view);
    }

    public static void c(View view, int i, int i2, int i3, int i4) {
        xi.c(view, i, i2, i3, i4);
    }

    public static float Q(View view) {
        return xi.Q(view);
    }

    public static float R(View view) {
        return xi.R(view);
    }

    public static int S(View view) {
        return xi.S(view);
    }

    public static int T(View view) {
        return xi.T(view);
    }

    public static ah U(View view) {
        return xi.U(view);
    }

    public static void b(View view, float f) {
        xi.b(view, f);
    }

    public static void c(View view, float f) {
        xi.c(view, f);
    }

    public static void d(View view, float f) {
        xi.d(view, f);
    }

    public static void e(View view, float f) {
        xi.e(view, f);
    }

    public static void f(View view, float f) {
        xi.f(view, f);
    }

    public static float V(View view) {
        return xi.V(view);
    }

    public static void g(View view, float f) {
        xi.g(view, f);
    }

    public static float W(View view) {
        return xi.W(view);
    }

    public static int X(View view) {
        return xi.X(view);
    }

    public static void Y(View view) {
        xi.Y(view);
    }

    public static void a(ViewGroup viewGroup) {
        xi.a(viewGroup, true);
    }

    public static boolean Z(View view) {
        return xi.Z(view);
    }

    public static void a(View view, boolean z) {
        xi.a(view, z);
    }

    public static void aa(View view) {
        xi.aa(view);
    }

    public static void b(View view, s sVar) {
        xi.b(view, sVar);
    }

    public static ao a(View view, ao aoVar) {
        return xi.a(view, aoVar);
    }

    public static ao b(View view, ao aoVar) {
        return xi.b(view, aoVar);
    }

    public static void ab(View view) {
        xi.c(view, false);
    }

    public static void b(View view, boolean z) {
        xi.b(view, z);
    }

    public static boolean ac(View view) {
        return xi.ac(view);
    }

    public static boolean ad(View view) {
        return xi.ad(view);
    }

    public static ColorStateList ae(View view) {
        return xi.ae(view);
    }

    public static void a(View view, ColorStateList colorStateList) {
        xi.a(view, colorStateList);
    }

    public static Mode af(View view) {
        return xi.af(view);
    }

    public static void a(View view, Mode mode) {
        xi.a(view, mode);
    }

    public static boolean ag(View view) {
        return xi.ag(view);
    }

    public static void ah(View view) {
        xi.ah(view);
    }

    public static boolean ai(View view) {
        return xi.ai(view);
    }

    public static float aj(View view) {
        return xi.aj(view);
    }

    public static void i(View view, int i) {
        xi.i(view, i);
    }

    public static void j(View view, int i) {
        xi.j(view, i);
    }

    public static boolean ak(View view) {
        return xi.ak(view);
    }

    public static boolean al(View view) {
        return xi.al(view);
    }

    public static void c(View view, int i, int i2) {
        xi.c(view, i, 3);
    }
}

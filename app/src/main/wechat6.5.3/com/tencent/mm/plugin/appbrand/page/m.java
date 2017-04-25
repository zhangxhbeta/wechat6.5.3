package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.k.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class m {
    WebView dOZ;
    List<a> dPa = new LinkedList();
    OnTouchListener dPb;
    private ac mHandler = new ac(Looper.getMainLooper());

    public static class a {
        WeakReference<View> cxw;
        int z;

        public a(View view, int i) {
            this.cxw = new WeakReference(view);
            this.z = i;
        }
    }

    static /* synthetic */ boolean a(m mVar, View view) {
        if (view == null) {
            return false;
        }
        for (int i = 0; i < mVar.dPa.size(); i++) {
            if (view == ((a) mVar.dPa.get(i)).cxw.get()) {
                mVar.dPa.remove(i);
                return true;
            }
        }
        return false;
    }

    public m(WebView webView) {
        this.dOZ = webView;
    }

    public final boolean a(View view, int i, int i2, int i3, int i4, int i5) {
        int i6;
        if (view == null) {
            i6 = -1;
        } else {
            int i7 = 0;
            while (i7 < this.dPa.size() && i >= ((a) this.dPa.get(i7)).z) {
                i7++;
            }
            this.dPa.add(i7, new a(view, i));
            i6 = i7;
        }
        if (i6 < 0) {
            String str = "MicroMsg.AppBrandWebViewCustomViewContainer";
            String str2 = "addCustomView(view : %s, z : %s, w : %s, h : %s, l : %s, t : %s)";
            Object[] objArr = new Object[6];
            objArr[0] = view != null ? Integer.valueOf(view.hashCode()) : null;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i5);
            v.i(str, str2, objArr);
            return false;
        }
        final int i8 = i2;
        final int i9 = i3;
        final int i10 = i4;
        final int i11 = i5;
        final View view2 = view;
        AnonymousClass1 anonymousClass1 = new az<Boolean>(this, Boolean.valueOf(false)) {
            final /* synthetic */ m dPh;

            protected final /* synthetic */ Object run() {
                ViewGroup viewGroup = (ViewGroup) this.dPh.dOZ.getView();
                if (viewGroup instanceof AbsoluteLayout) {
                    ((AbsoluteLayout) viewGroup).addView(view2, i6, new LayoutParams(i8, i9, i10, i11));
                    if (this.dPh.dPb == null) {
                        this.dPh.dPb = new OnTouchListener(this) {
                            final /* synthetic */ AnonymousClass1 dPi;

                            {
                                this.dPi = r1;
                            }

                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                ViewGroup viewGroup = (ViewGroup) view;
                                int childCount = viewGroup.getChildCount();
                                int pointerId = viewGroup.isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(motionEvent.getActionIndex()) : -1;
                                for (int i = childCount - 1; i >= 0; i--) {
                                    View childAt = viewGroup.getChildAt(i);
                                    float x = childAt.getX();
                                    float y = childAt.getY();
                                    if (((Boolean) i.a(ViewGroup.class, "canViewReceivePointerEvents", viewGroup, new Class[]{View.class}, new Object[]{childAt}, Boolean.valueOf(false))).booleanValue()) {
                                        if (((Boolean) i.a(ViewGroup.class, "isTransformedTouchPointInView", viewGroup, new Class[]{Float.TYPE, Float.TYPE, View.class, PointF.class}, new Object[]{Float.valueOf(x), Float.valueOf(y), childAt, null}, Boolean.valueOf(false))).booleanValue() && childAt.isDuplicateParentStateEnabled()) {
                                            if (childAt == null) {
                                                v.v("MicroMsg.ViewMotionHelper", "child is null.");
                                            } else {
                                                int action = motionEvent.getAction();
                                                if (action == 3) {
                                                    motionEvent.setAction(3);
                                                    childAt.dispatchTouchEvent(motionEvent);
                                                    motionEvent.setAction(action);
                                                } else {
                                                    childCount = ((Integer) i.a(MotionEvent.class, "getPointerIdBits", motionEvent, new Class[0], new Object[0], Integer.valueOf(0))).intValue();
                                                    int i2 = childCount & pointerId;
                                                    if (i2 == 0) {
                                                        v.v("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
                                                    } else {
                                                        MotionEvent obtain;
                                                        boolean booleanValue = ((Boolean) i.a(View.class, "hasIdentityMatrix", childAt, new Class[0], new Object[0], Boolean.valueOf(false))).booleanValue();
                                                        if (i2 != childCount) {
                                                            obtain = MotionEvent.obtain(motionEvent);
                                                        } else if (booleanValue) {
                                                            float scrollX = (float) (viewGroup.getScrollX() - childAt.getLeft());
                                                            float scrollY = (float) (viewGroup.getScrollY() - childAt.getTop());
                                                            motionEvent.offsetLocation(scrollX, scrollY);
                                                            childAt.dispatchTouchEvent(motionEvent);
                                                            motionEvent.offsetLocation(-scrollX, -scrollY);
                                                        } else {
                                                            obtain = MotionEvent.obtain(motionEvent);
                                                        }
                                                        obtain.offsetLocation((float) (viewGroup.getScrollX() - childAt.getLeft()), (float) (viewGroup.getScrollY() - childAt.getTop()));
                                                        if (!booleanValue) {
                                                            obtain.transform((Matrix) i.a(View.class, "getInverseMatrix", childAt, new Class[0], new Object[0], null));
                                                        }
                                                        childAt.dispatchTouchEvent(obtain);
                                                        obtain.recycle();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                return false;
                            }
                        };
                        this.dPh.dOZ.getView().setOnTouchListener(this.dPh.dPb);
                    }
                    v.i("MicroMsg.AppBrandWebViewCustomViewContainer", "addView(view : %s, index : %s)", new Object[]{Integer.valueOf(view2.hashCode()), Integer.valueOf(i6)});
                    return Boolean.valueOf(true);
                }
                m.a(this.dPh, view2);
                return Boolean.valueOf(false);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) anonymousClass1.c(null)).booleanValue();
        }
        return ((Boolean) anonymousClass1.c(this.mHandler)).booleanValue();
    }

    public final boolean by(final View view) {
        return ((Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
            final /* synthetic */ m dPh;

            protected final /* synthetic */ Object run() {
                ViewGroup viewGroup = (ViewGroup) this.dPh.dOZ.getView();
                if (!(viewGroup instanceof AbsoluteLayout)) {
                    return Boolean.valueOf(false);
                }
                AbsoluteLayout absoluteLayout = (AbsoluteLayout) viewGroup;
                m.a(this.dPh, view);
                absoluteLayout.removeView(view);
                return Boolean.valueOf(true);
            }
        }.c(this.mHandler)).booleanValue();
    }
}

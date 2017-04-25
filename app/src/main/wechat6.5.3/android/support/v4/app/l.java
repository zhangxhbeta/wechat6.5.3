package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.e.c;
import android.support.v4.e.d;
import android.support.v4.view.j;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.tencent.mmdb.FileUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class l extends k implements j {
    static boolean DEBUG = false;
    static final boolean pT;
    static Field qi = null;
    static final Interpolator qr = new DecelerateInterpolator(2.5f);
    static final Interpolator qs = new DecelerateInterpolator(1.5f);
    static final Interpolator qt = new AccelerateInterpolator(2.5f);
    static final Interpolator qu = new AccelerateInterpolator(1.5f);
    j oU;
    ArrayList<Runnable> pU;
    Runnable[] pV;
    boolean pW;
    ArrayList<Fragment> pX;
    ArrayList<Fragment> pY;
    ArrayList<Integer> pZ;
    ArrayList<d> qa;
    ArrayList<Fragment> qb;
    ArrayList<d> qc;
    ArrayList<Integer> qd;
    ArrayList<Object> qe;
    int qf = 0;
    h qg;
    Fragment qh;
    boolean qj;
    boolean qk;
    boolean ql;
    String qm;
    boolean qn;
    Bundle qo = null;
    SparseArray<Parcelable> qp = null;
    Runnable qq = new Runnable(this) {
        final /* synthetic */ l qv;

        {
            this.qv = r1;
        }

        public final void run() {
            this.qv.execPendingActions();
        }
    };

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ l qv;
        final /* synthetic */ int qw;
        final /* synthetic */ int qx = 1;

        AnonymousClass3(l lVar, int i, int i2) {
            this.qv = lVar;
            this.qw = i;
        }

        public final void run() {
            l lVar = this.qv;
            j jVar = this.qv.oU;
            lVar.g(this.qw, this.qx);
        }
    }

    static class a implements AnimationListener {
        private View mView = null;
        private boolean qA = false;
        private AnimationListener qz = null;

        public a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.mView = view;
            }
        }

        public a(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.qz = animationListener;
                this.mView = view;
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.mView != null) {
                this.qA = l.a(this.mView, animation);
                if (this.qA) {
                    this.mView.post(new Runnable(this) {
                        final /* synthetic */ a qB;

                        {
                            this.qB = r1;
                        }

                        public final void run() {
                            y.a(this.qB.mView, 2, null);
                        }
                    });
                }
            }
            if (this.qz != null) {
                this.qz.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.mView != null && this.qA) {
                this.mView.post(new Runnable(this) {
                    final /* synthetic */ a qB;

                    {
                        this.qB = r1;
                    }

                    public final void run() {
                        y.a(this.qB.mView, 0, null);
                    }
                });
            }
            if (this.qz != null) {
                this.qz.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.qz != null) {
                this.qz.onAnimationRepeat(animation);
            }
        }
    }

    static class b {
        public static final int[] qC = new int[]{16842755, 16842960, 16842961};
    }

    l() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        pT = z;
    }

    static boolean a(View view, Animation animation) {
        if (VERSION.SDK_INT < 19 || y.H(view) != 0 || !y.ac(view)) {
            return false;
        }
        boolean z;
        if (animation instanceof AlphaAnimation) {
            z = true;
        } else {
            if (animation instanceof AnimationSet) {
                List animations = ((AnimationSet) animation).getAnimations();
                for (int i = 0; i < animations.size(); i++) {
                    if (animations.get(i) instanceof AlphaAnimation) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
        }
        return z;
    }

    private void a(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new d("FragmentManager"));
        if (this.oU != null) {
            try {
                this.oU.a("  ", printWriter, new String[0]);
            } catch (Exception e) {
            }
        } else {
            try {
                dump("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
            }
        }
        throw runtimeException;
    }

    public final n aW() {
        return new d(this);
    }

    public final boolean executePendingTransactions() {
        return execPendingActions();
    }

    public final void popBackStack() {
        a(new Runnable(this) {
            final /* synthetic */ l qv;

            {
                this.qv = r1;
            }

            public final void run() {
                l lVar = this.qv;
                j jVar = this.qv.oU;
                lVar.g(-1, 0);
            }
        }, false);
    }

    public final boolean popBackStackImmediate() {
        aZ();
        execPendingActions();
        return g(-1, 0);
    }

    public final void F(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a(new AnonymousClass3(this, i, 1), false);
    }

    public final void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public final Fragment a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.pX.size()) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.pX.get(i);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public final List<Fragment> aX() {
        return this.pX;
    }

    public final SavedState e(Fragment fragment) {
        if (fragment.mIndex < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0) {
            return null;
        }
        Bundle j = j(fragment);
        if (j != null) {
            return new SavedState(j);
        }
        return null;
    }

    public final boolean isDestroyed() {
        return this.ql;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.qh != null) {
            c.a(this.qh, stringBuilder);
        } else {
            c.a(this.oU, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.pX != null) {
            size = this.pX.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.pX.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.pY != null) {
            size = this.pY.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.pY.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.qb != null) {
            size = this.qb.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.qb.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.qa != null) {
            size = this.qa.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    d dVar = (d) this.qa.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(dVar.toString());
                    dVar.a(str2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.qc != null) {
                int size2 = this.qc.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        dVar = (d) this.qc.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(dVar);
                    }
                }
            }
            if (this.qd != null && this.qd.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.qd.toArray()));
            }
        }
        if (this.pU != null) {
            i = this.pU.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.pU.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.oU);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.qg);
        if (this.qh != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.qh);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.qf);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.qk);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.ql);
        if (this.qj) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.qj);
        }
        if (this.qm != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.qm);
        }
        if (this.pZ != null && this.pZ.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.pZ.toArray()));
        }
    }

    private static Animation a(float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(qr);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(qs);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private static Animation f(float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(qs);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    private Animation a(Fragment fragment, int i, boolean z, int i2) {
        int i3 = fragment.ph;
        Fragment.aM();
        if (fragment.ph != 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.oU.mContext, fragment.ph);
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        Object obj = -1;
        switch (i) {
            case 4097:
                if (!z) {
                    obj = 2;
                    break;
                }
                obj = 1;
                break;
            case 4099:
                if (!z) {
                    obj = 6;
                    break;
                }
                obj = 5;
                break;
            case 8194:
                if (!z) {
                    obj = 4;
                    break;
                }
                obj = 3;
                break;
        }
        if (obj < null) {
            return null;
        }
        switch (obj) {
            case 1:
                return a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return f(0.0f, 1.0f);
            case 6:
                return f(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.oU.onHasWindowAnimations()) {
                    i2 = this.oU.onGetWindowAnimations();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public final void f(Fragment fragment) {
        if (!fragment.pk) {
            return;
        }
        if (this.pW) {
            this.qn = true;
            return;
        }
        fragment.pk = false;
        a(fragment, this.qf, 0, 0, false);
    }

    private static void b(View view, Animation animation) {
        if (view != null && animation != null && a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (qi == null) {
                    Field declaredField = Animation.class.getDeclaredField("mListener");
                    qi = declaredField;
                    declaredField.setAccessible(true);
                }
                animationListener = (AnimationListener) qi.get(animation);
            } catch (NoSuchFieldException e) {
                animationListener = null;
            } catch (IllegalAccessException e2) {
                animationListener = null;
            }
            animation.setAnimationListener(new a(view, animation, animationListener));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void a(final android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r7 = 0;
        r3 = 0;
        r0 = r11.oN;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.pb;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.oO;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.mState;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.mState;
    L_0x001a:
        r0 = r11.pk;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.mState;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.mState;
        if (r0 >= r12) goto L_0x0398;
    L_0x0029:
        r0 = r11.oP;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.oQ;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.oE;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.oE = r7;
        r2 = r11.oF;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.mState;
        switch(r0) {
            case 0: goto L_0x006f;
            case 1: goto L_0x01a2;
            case 2: goto L_0x02e5;
            case 3: goto L_0x02e5;
            case 4: goto L_0x033d;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.mState;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = new java.lang.StringBuilder;
        r1 = "moveToState: Fragment state for ";
        r0.<init>(r1);
        r0 = r0.append(r11);
        r1 = " not updated inline; expected state ";
        r0 = r0.append(r1);
        r0 = r0.append(r12);
        r1 = " found ";
        r0 = r0.append(r1);
        r1 = r11.mState;
        r0.append(r1);
        r11.mState = r12;
        goto L_0x0031;
    L_0x006f:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x007e;
    L_0x0073:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x007e:
        r0 = r11.oG;
        if (r0 == 0) goto L_0x00c8;
    L_0x0082:
        r0 = r11.oG;
        r1 = r10.oU;
        r1 = r1.mContext;
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.oG;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.oH = r0;
        r0 = r11.oG;
        r1 = "android:target_state";
        r0 = r10.a(r0, r1);
        r11.oK = r0;
        r0 = r11.oK;
        if (r0 == 0) goto L_0x00b4;
    L_0x00a9:
        r0 = r11.oG;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.oM = r0;
    L_0x00b4:
        r0 = r11.oG;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.pl = r0;
        r0 = r11.pl;
        if (r0 != 0) goto L_0x00c8;
    L_0x00c3:
        r11.pk = r5;
        if (r12 <= r6) goto L_0x00c8;
    L_0x00c7:
        r12 = r6;
    L_0x00c8:
        r0 = r10.oU;
        r11.oU = r0;
        r0 = r10.qh;
        r11.oW = r0;
        r0 = r10.qh;
        if (r0 == 0) goto L_0x010b;
    L_0x00d4:
        r0 = r10.qh;
        r0 = r0.oV;
    L_0x00d8:
        r11.oT = r0;
        r11.pg = r3;
        r11.pg = r5;
        r0 = r11.oU;
        if (r0 != 0) goto L_0x0110;
    L_0x00e2:
        r0 = r7;
    L_0x00e3:
        if (r0 == 0) goto L_0x00ea;
    L_0x00e5:
        r11.pg = r3;
        r11.onAttach(r0);
    L_0x00ea:
        r0 = r11.pg;
        if (r0 != 0) goto L_0x0115;
    L_0x00ee:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x010b:
        r0 = r10.oU;
        r0 = r0.oT;
        goto L_0x00d8;
    L_0x0110:
        r0 = r11.oU;
        r0 = r0.pP;
        goto L_0x00e3;
    L_0x0115:
        r0 = r11.oW;
        r0 = r11.pd;
        if (r0 != 0) goto L_0x0169;
    L_0x011b:
        r0 = r11.oG;
        r1 = r11.oV;
        if (r1 == 0) goto L_0x0125;
    L_0x0121:
        r1 = r11.oV;
        r1.qk = r3;
    L_0x0125:
        r11.mState = r5;
        r11.pg = r3;
        r11.onCreate(r0);
        r1 = r11.pg;
        if (r1 != 0) goto L_0x014d;
    L_0x0130:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onCreate()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x014d:
        if (r0 == 0) goto L_0x0169;
    L_0x014f:
        r1 = "android:support:fragments";
        r0 = r0.getParcelable(r1);
        if (r0 == 0) goto L_0x0169;
    L_0x0158:
        r1 = r11.oV;
        if (r1 != 0) goto L_0x015f;
    L_0x015c:
        r11.aO();
    L_0x015f:
        r1 = r11.oV;
        r1.restoreAllState(r0, r7);
        r0 = r11.oV;
        r0.dispatchCreate();
    L_0x0169:
        r11.pd = r3;
        r0 = r11.oP;
        if (r0 == 0) goto L_0x01a2;
    L_0x016f:
        r0 = r11.oG;
        r0 = r11.c(r0);
        r1 = r11.oG;
        r0 = r11.a(r0, r7, r1);
        r11.mView = r0;
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0292;
    L_0x0181:
        r0 = r11.mView;
        r11.pj = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0288;
    L_0x018b:
        r0 = r11.mView;
        android.support.v4.view.y.ab(r0);
    L_0x0190:
        r0 = r11.pa;
        if (r0 == 0) goto L_0x019b;
    L_0x0194:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x019b:
        r0 = r11.mView;
        r0 = r11.oG;
        r11.aN();
    L_0x01a2:
        if (r12 <= r5) goto L_0x02e5;
    L_0x01a4:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x01b3;
    L_0x01a8:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x01b3:
        r0 = r11.oP;
        if (r0 != 0) goto L_0x0255;
    L_0x01b7:
        r0 = r11.oY;
        if (r0 == 0) goto L_0x05d0;
    L_0x01bb:
        r0 = r10.qg;
        r1 = r11.oY;
        r0 = r0.onFindViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0209;
    L_0x01c7:
        r1 = r11.oR;
        if (r1 != 0) goto L_0x0209;
    L_0x01cb:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r4 = "No view found for id 0x";
        r2.<init>(r4);
        r4 = r11.oY;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.getResources();
        r8 = r11.oY;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.a(r1);
    L_0x0209:
        r11.pi = r0;
        r1 = r11.oG;
        r1 = r11.c(r1);
        r2 = r11.oG;
        r1 = r11.a(r1, r0, r2);
        r11.mView = r1;
        r1 = r11.mView;
        if (r1 == 0) goto L_0x029f;
    L_0x021d:
        r1 = r11.mView;
        r11.pj = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x0296;
    L_0x0227:
        r1 = r11.mView;
        android.support.v4.view.y.ab(r1);
    L_0x022c:
        if (r0 == 0) goto L_0x0243;
    L_0x022e:
        r1 = r10.a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x023e;
    L_0x0234:
        r2 = r11.mView;
        b(r2, r1);
        r2 = r11.mView;
        r2.startAnimation(r1);
    L_0x023e:
        r1 = r11.mView;
        r0.addView(r1);
    L_0x0243:
        r0 = r11.pa;
        if (r0 == 0) goto L_0x024e;
    L_0x0247:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x024e:
        r0 = r11.mView;
        r0 = r11.oG;
        r11.aN();
    L_0x0255:
        r0 = r11.oG;
        r1 = r11.oV;
        if (r1 == 0) goto L_0x025f;
    L_0x025b:
        r1 = r11.oV;
        r1.qk = r3;
    L_0x025f:
        r1 = 2;
        r11.mState = r1;
        r11.pg = r3;
        r11.onActivityCreated(r0);
        r0 = r11.pg;
        if (r0 != 0) goto L_0x02a2;
    L_0x026b:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onActivityCreated()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0288:
        r0 = r11.mView;
        r0 = android.support.v4.app.t.y(r0);
        r11.mView = r0;
        goto L_0x0190;
    L_0x0292:
        r11.pj = r7;
        goto L_0x01a2;
    L_0x0296:
        r1 = r11.mView;
        r1 = android.support.v4.app.t.y(r1);
        r11.mView = r1;
        goto L_0x022c;
    L_0x029f:
        r11.pj = r7;
        goto L_0x0255;
    L_0x02a2:
        r0 = r11.oV;
        if (r0 == 0) goto L_0x02ab;
    L_0x02a6:
        r0 = r11.oV;
        r0.dispatchActivityCreated();
    L_0x02ab:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x02e3;
    L_0x02af:
        r0 = r11.oG;
        r0 = r11.oH;
        if (r0 == 0) goto L_0x02be;
    L_0x02b5:
        r0 = r11.pj;
        r1 = r11.oH;
        r0.restoreHierarchyState(r1);
        r11.oH = r7;
    L_0x02be:
        r11.pg = r3;
        r11.pg = r5;
        r0 = r11.pg;
        if (r0 != 0) goto L_0x02e3;
    L_0x02c6:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onViewStateRestored()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x02e3:
        r11.oG = r7;
    L_0x02e5:
        if (r12 <= r6) goto L_0x033d;
    L_0x02e7:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02f6;
    L_0x02eb:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto STARTED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x02f6:
        r0 = r11.oV;
        if (r0 == 0) goto L_0x0303;
    L_0x02fa:
        r0 = r11.oV;
        r0.qk = r3;
        r0 = r11.oV;
        r0.execPendingActions();
    L_0x0303:
        r11.mState = r9;
        r11.pg = r3;
        r11.onStart();
        r0 = r11.pg;
        if (r0 != 0) goto L_0x032b;
    L_0x030e:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onStart()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x032b:
        r0 = r11.oV;
        if (r0 == 0) goto L_0x0334;
    L_0x032f:
        r0 = r11.oV;
        r0.dispatchStart();
    L_0x0334:
        r0 = r11.pm;
        if (r0 == 0) goto L_0x033d;
    L_0x0338:
        r0 = r11.pm;
        r0.bi();
    L_0x033d:
        if (r12 <= r9) goto L_0x0045;
    L_0x033f:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x034e;
    L_0x0343:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto RESUMED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x034e:
        r0 = r11.oV;
        if (r0 == 0) goto L_0x035b;
    L_0x0352:
        r0 = r11.oV;
        r0.qk = r3;
        r0 = r11.oV;
        r0.execPendingActions();
    L_0x035b:
        r0 = 5;
        r11.mState = r0;
        r11.pg = r3;
        r11.onResume();
        r0 = r11.pg;
        if (r0 != 0) goto L_0x0384;
    L_0x0367:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onResume()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0384:
        r0 = r11.oV;
        if (r0 == 0) goto L_0x0392;
    L_0x0388:
        r0 = r11.oV;
        r0.dispatchResume();
        r0 = r11.oV;
        r0.execPendingActions();
    L_0x0392:
        r11.oG = r7;
        r11.oH = r7;
        goto L_0x0045;
    L_0x0398:
        r0 = r11.mState;
        if (r0 <= r12) goto L_0x0045;
    L_0x039c:
        r0 = r11.mState;
        switch(r0) {
            case 1: goto L_0x03a3;
            case 2: goto L_0x0456;
            case 3: goto L_0x0442;
            case 4: goto L_0x0400;
            case 5: goto L_0x03bd;
            default: goto L_0x03a1;
        };
    L_0x03a1:
        goto L_0x0045;
    L_0x03a3:
        if (r12 > 0) goto L_0x0045;
    L_0x03a5:
        r0 = r10.ql;
        if (r0 == 0) goto L_0x03b4;
    L_0x03a9:
        r0 = r11.oE;
        if (r0 == 0) goto L_0x03b4;
    L_0x03ad:
        r0 = r11.oE;
        r11.oE = r7;
        r0.clearAnimation();
    L_0x03b4:
        r0 = r11.oE;
        if (r0 == 0) goto L_0x04ef;
    L_0x03b8:
        r11.oF = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x03bd:
        r0 = 5;
        if (r12 >= r0) goto L_0x0400;
    L_0x03c0:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x03cf;
    L_0x03c4:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom RESUMED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x03cf:
        r0 = r11.oV;
        if (r0 == 0) goto L_0x03d8;
    L_0x03d3:
        r0 = r11.oV;
        r0.G(r9);
    L_0x03d8:
        r11.mState = r9;
        r11.pg = r3;
        r11.onPause();
        r0 = r11.pg;
        if (r0 != 0) goto L_0x0400;
    L_0x03e3:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onPause()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0400:
        if (r12 >= r9) goto L_0x0442;
    L_0x0402:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0411;
    L_0x0406:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STARTED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0411:
        r0 = r11.oV;
        if (r0 == 0) goto L_0x041a;
    L_0x0415:
        r0 = r11.oV;
        r0.dispatchStop();
    L_0x041a:
        r11.mState = r6;
        r11.pg = r3;
        r11.onStop();
        r0 = r11.pg;
        if (r0 != 0) goto L_0x0442;
    L_0x0425:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onStop()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0442:
        if (r12 >= r6) goto L_0x0456;
    L_0x0444:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0453;
    L_0x0448:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STOPPED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0453:
        r11.aP();
    L_0x0456:
        r0 = 2;
        if (r12 >= r0) goto L_0x03a3;
    L_0x0459:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0468;
    L_0x045d:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0468:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x047b;
    L_0x046c:
        r0 = r10.oU;
        r0 = r0.aT();
        if (r0 == 0) goto L_0x047b;
    L_0x0474:
        r0 = r11.oH;
        if (r0 != 0) goto L_0x047b;
    L_0x0478:
        r10.i(r11);
    L_0x047b:
        r0 = r11.oV;
        if (r0 == 0) goto L_0x0484;
    L_0x047f:
        r0 = r11.oV;
        r0.G(r5);
    L_0x0484:
        r11.mState = r5;
        r11.pg = r3;
        r11.onDestroyView();
        r0 = r11.pg;
        if (r0 != 0) goto L_0x04ac;
    L_0x048f:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDestroyView()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x04ac:
        r0 = r11.pm;
        if (r0 == 0) goto L_0x04b5;
    L_0x04b0:
        r0 = r11.pm;
        r0.bh();
    L_0x04b5:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x04e7;
    L_0x04b9:
        r0 = r11.pi;
        if (r0 == 0) goto L_0x04e7;
    L_0x04bd:
        r0 = r10.qf;
        if (r0 <= 0) goto L_0x05cd;
    L_0x04c1:
        r0 = r10.ql;
        if (r0 != 0) goto L_0x05cd;
    L_0x04c5:
        r0 = r10.a(r11, r13, r3, r14);
    L_0x04c9:
        if (r0 == 0) goto L_0x04e0;
    L_0x04cb:
        r1 = r11.mView;
        r11.oE = r1;
        r11.oF = r12;
        r1 = r11.mView;
        r2 = new android.support.v4.app.l$4;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.mView;
        r1.startAnimation(r0);
    L_0x04e0:
        r0 = r11.pi;
        r1 = r11.mView;
        r0.removeView(r1);
    L_0x04e7:
        r11.pi = r7;
        r11.mView = r7;
        r11.pj = r7;
        goto L_0x03a3;
    L_0x04ef:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x04fe;
    L_0x04f3:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom CREATED: ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x04fe:
        r0 = r11.pd;
        if (r0 != 0) goto L_0x0533;
    L_0x0502:
        r0 = r11.oV;
        if (r0 == 0) goto L_0x050b;
    L_0x0506:
        r0 = r11.oV;
        r0.dispatchDestroy();
    L_0x050b:
        r11.mState = r3;
        r11.pg = r3;
        r11.onDestroy();
        r0 = r11.pg;
        if (r0 != 0) goto L_0x0535;
    L_0x0516:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDestroy()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0533:
        r11.mState = r3;
    L_0x0535:
        r11.pg = r3;
        r11.onDetach();
        r0 = r11.pg;
        if (r0 != 0) goto L_0x055b;
    L_0x053e:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x055b:
        if (r15 != 0) goto L_0x0045;
    L_0x055d:
        r0 = r11.pd;
        if (r0 != 0) goto L_0x05c3;
    L_0x0561:
        r0 = r11.mIndex;
        if (r0 < 0) goto L_0x0045;
    L_0x0565:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0574;
    L_0x0569:
        r0 = new java.lang.StringBuilder;
        r1 = "Freeing fragment index ";
        r0.<init>(r1);
        r0.append(r11);
    L_0x0574:
        r0 = r10.pX;
        r1 = r11.mIndex;
        r0.set(r1, r7);
        r0 = r10.pZ;
        if (r0 != 0) goto L_0x0586;
    L_0x057f:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.pZ = r0;
    L_0x0586:
        r0 = r10.pZ;
        r1 = r11.mIndex;
        r1 = java.lang.Integer.valueOf(r1);
        r0.add(r1);
        r0 = r10.oU;
        r1 = r11.oI;
        r0.j(r1);
        r0 = -1;
        r11.mIndex = r0;
        r11.oI = r7;
        r11.oN = r3;
        r11.oO = r3;
        r11.oP = r3;
        r11.oQ = r3;
        r11.oR = r3;
        r11.oS = r3;
        r11.oT = r7;
        r11.oV = r7;
        r11.oU = r7;
        r11.oX = r3;
        r11.oY = r3;
        r11.oZ = r7;
        r11.pa = r3;
        r11.pb = r3;
        r11.pd = r3;
        r11.pm = r7;
        r11.pn = r3;
        r11.po = r3;
        goto L_0x0045;
    L_0x05c3:
        r11.oU = r7;
        r11.oW = r7;
        r11.oT = r7;
        r11.oV = r7;
        goto L_0x0045;
    L_0x05cd:
        r0 = r7;
        goto L_0x04c9;
    L_0x05d0:
        r0 = r7;
        goto L_0x0209;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.l.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    private void g(Fragment fragment) {
        a(fragment, this.qf, 0, 0, false);
    }

    final void G(int i) {
        b(i, 0, 0, false);
    }

    final void b(int i, int i2, int i3, boolean z) {
        if (this.oU == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.qf != i) {
            this.qf = i;
            if (this.pX != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.pX.size()) {
                    int bd;
                    Fragment fragment = (Fragment) this.pX.get(i4);
                    if (fragment != null) {
                        a(fragment, i, i2, i3, false);
                        if (fragment.pm != null) {
                            bd = i5 | fragment.pm.bd();
                            i4++;
                            i5 = bd;
                        }
                    }
                    bd = i5;
                    i4++;
                    i5 = bd;
                }
                if (i5 == 0) {
                    aY();
                }
                if (this.qj && this.oU != null && this.qf == 5) {
                    this.oU.aU();
                    this.qj = false;
                }
            }
        }
    }

    final void aY() {
        if (this.pX != null) {
            for (int i = 0; i < this.pX.size(); i++) {
                Fragment fragment = (Fragment) this.pX.get(i);
                if (fragment != null) {
                    f(fragment);
                }
            }
        }
    }

    final void h(Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (this.pZ == null || this.pZ.size() <= 0) {
                if (this.pX == null) {
                    this.pX = new ArrayList();
                }
                fragment.c(this.pX.size(), this.qh);
                this.pX.add(fragment);
            } else {
                fragment.c(((Integer) this.pZ.remove(this.pZ.size() - 1)).intValue(), this.qh);
                this.pX.set(fragment.mIndex, fragment);
            }
            if (DEBUG) {
                new StringBuilder("Allocated fragment index ").append(fragment);
            }
        }
    }

    public final void a(Fragment fragment, boolean z) {
        if (this.pY == null) {
            this.pY = new ArrayList();
        }
        if (DEBUG) {
            new StringBuilder("add: ").append(fragment);
        }
        h(fragment);
        if (!fragment.pb) {
            if (this.pY.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.pY.add(fragment);
            fragment.oN = true;
            fragment.oO = false;
            if (fragment.pe && fragment.pf) {
                this.qj = true;
            }
            if (z) {
                g(fragment);
            }
        }
    }

    public final void a(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("remove: ").append(fragment).append(" nesting=").append(fragment.oS);
        }
        boolean z = !(fragment.oS > 0);
        if (!fragment.pb || z) {
            int i3;
            if (this.pY != null) {
                this.pY.remove(fragment);
            }
            if (fragment.pe && fragment.pf) {
                this.qj = true;
            }
            fragment.oN = false;
            fragment.oO = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            a(fragment, i3, i, i2, false);
        }
    }

    public final void b(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("hide: ").append(fragment);
        }
        if (!fragment.pa) {
            fragment.pa = true;
            if (fragment.mView != null) {
                Animation a = a(fragment, i, false, i2);
                if (a != null) {
                    b(fragment.mView, a);
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.oN && fragment.pe && fragment.pf) {
                this.qj = true;
            }
            Fragment.aH();
        }
    }

    public final void c(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("show: ").append(fragment);
        }
        if (fragment.pa) {
            fragment.pa = false;
            if (fragment.mView != null) {
                Animation a = a(fragment, i, true, i2);
                if (a != null) {
                    b(fragment.mView, a);
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.oN && fragment.pe && fragment.pf) {
                this.qj = true;
            }
            Fragment.aH();
        }
    }

    public final void d(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("detach: ").append(fragment);
        }
        if (!fragment.pb) {
            fragment.pb = true;
            if (fragment.oN) {
                if (this.pY != null) {
                    if (DEBUG) {
                        new StringBuilder("remove from detach: ").append(fragment);
                    }
                    this.pY.remove(fragment);
                }
                if (fragment.pe && fragment.pf) {
                    this.qj = true;
                }
                fragment.oN = false;
                a(fragment, 1, i, i2, false);
            }
        }
    }

    public final void e(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("attach: ").append(fragment);
        }
        if (fragment.pb) {
            fragment.pb = false;
            if (!fragment.oN) {
                if (this.pY == null) {
                    this.pY = new ArrayList();
                }
                if (this.pY.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (DEBUG) {
                    new StringBuilder("add from attach: ").append(fragment);
                }
                this.pY.add(fragment);
                fragment.oN = true;
                if (fragment.pe && fragment.pf) {
                    this.qj = true;
                }
                a(fragment, this.qf, i, i2, false);
            }
        }
    }

    public final Fragment E(int i) {
        int size;
        Fragment fragment;
        if (this.pY != null) {
            for (size = this.pY.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.pY.get(size);
                if (fragment != null && fragment.oX == i) {
                    return fragment;
                }
            }
        }
        if (this.pX != null) {
            for (size = this.pX.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.pX.get(size);
                if (fragment != null && fragment.oX == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment k(String str) {
        int size;
        Fragment fragment;
        if (!(this.pY == null || str == null)) {
            for (size = this.pY.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.pY.get(size);
                if (fragment != null && str.equals(fragment.oZ)) {
                    return fragment;
                }
            }
        }
        if (!(this.pX == null || str == null)) {
            for (size = this.pX.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.pX.get(size);
                if (fragment != null && str.equals(fragment.oZ)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment i(String str) {
        if (!(this.pX == null || str == null)) {
            for (int size = this.pX.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.pX.get(size);
                if (fragment != null) {
                    if (!str.equals(fragment.oI)) {
                        fragment = fragment.oV != null ? fragment.oV.i(str) : null;
                    }
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void aZ() {
        if (this.qk) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.qm != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.qm);
        }
    }

    public final void a(Runnable runnable, boolean z) {
        if (!z) {
            aZ();
        }
        synchronized (this) {
            if (this.ql || this.oU == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.pU == null) {
                this.pU = new ArrayList();
            }
            this.pU.add(runnable);
            if (this.pU.size() == 1) {
                this.oU.mHandler.removeCallbacks(this.qq);
                this.oU.mHandler.post(this.qq);
            }
        }
    }

    public final int a(d dVar) {
        int size;
        synchronized (this) {
            if (this.qd == null || this.qd.size() <= 0) {
                if (this.qc == null) {
                    this.qc = new ArrayList();
                }
                size = this.qc.size();
                if (DEBUG) {
                    new StringBuilder("Setting back stack index ").append(size).append(" to ").append(dVar);
                }
                this.qc.add(dVar);
            } else {
                size = ((Integer) this.qd.remove(this.qd.size() - 1)).intValue();
                if (DEBUG) {
                    new StringBuilder("Adding back stack index ").append(size).append(" with ").append(dVar);
                }
                this.qc.set(size, dVar);
            }
        }
        return size;
    }

    private void a(int i, d dVar) {
        synchronized (this) {
            if (this.qc == null) {
                this.qc = new ArrayList();
            }
            int size = this.qc.size();
            if (i < size) {
                if (DEBUG) {
                    new StringBuilder("Setting back stack index ").append(i).append(" to ").append(dVar);
                }
                this.qc.set(i, dVar);
            } else {
                while (size < i) {
                    this.qc.add(null);
                    if (this.qd == null) {
                        this.qd = new ArrayList();
                    }
                    if (DEBUG) {
                        this.qd.add(Integer.valueOf(size));
                        size++;
                    } else {
                        this.qd.add(Integer.valueOf(size));
                        size++;
                    }
                }
                if (DEBUG) {
                    new StringBuilder("Adding back stack index ").append(i).append(" with ").append(dVar);
                }
                this.qc.add(dVar);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean execPendingActions() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.pW;
        if (r1 == 0) goto L_0x000f;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000f:
        r1 = android.os.Looper.myLooper();
        r3 = r6.oU;
        r3 = r3.mHandler;
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0026;
    L_0x001d:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r1 = r2;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.pU;	 Catch:{ all -> 0x0099 }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.pU;	 Catch:{ all -> 0x0099 }
        r3 = r3.size();	 Catch:{ all -> 0x0099 }
        if (r3 != 0) goto L_0x005c;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x0099 }
        r0 = r6.qn;
        if (r0 == 0) goto L_0x00a7;
    L_0x0039:
        r3 = r2;
        r4 = r2;
    L_0x003b:
        r0 = r6.pX;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x00a0;
    L_0x0043:
        r0 = r6.pX;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0058;
    L_0x004d:
        r5 = r0.pm;
        if (r5 == 0) goto L_0x0058;
    L_0x0051:
        r0 = r0.pm;
        r0 = r0.bd();
        r4 = r4 | r0;
    L_0x0058:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x003b;
    L_0x005c:
        r1 = r6.pU;	 Catch:{ all -> 0x0099 }
        r3 = r1.size();	 Catch:{ all -> 0x0099 }
        r1 = r6.pV;	 Catch:{ all -> 0x0099 }
        if (r1 == 0) goto L_0x006b;
    L_0x0066:
        r1 = r6.pV;	 Catch:{ all -> 0x0099 }
        r1 = r1.length;	 Catch:{ all -> 0x0099 }
        if (r1 >= r3) goto L_0x006f;
    L_0x006b:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0099 }
        r6.pV = r1;	 Catch:{ all -> 0x0099 }
    L_0x006f:
        r1 = r6.pU;	 Catch:{ all -> 0x0099 }
        r4 = r6.pV;	 Catch:{ all -> 0x0099 }
        r1.toArray(r4);	 Catch:{ all -> 0x0099 }
        r1 = r6.pU;	 Catch:{ all -> 0x0099 }
        r1.clear();	 Catch:{ all -> 0x0099 }
        r1 = r6.oU;	 Catch:{ all -> 0x0099 }
        r1 = r1.mHandler;	 Catch:{ all -> 0x0099 }
        r4 = r6.qq;	 Catch:{ all -> 0x0099 }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x0099 }
        monitor-exit(r6);	 Catch:{ all -> 0x0099 }
        r6.pW = r0;
        r1 = r2;
    L_0x0088:
        if (r1 >= r3) goto L_0x009c;
    L_0x008a:
        r4 = r6.pV;
        r4 = r4[r1];
        r4.run();
        r4 = r6.pV;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0088;
    L_0x0099:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0099 }
        throw r0;
    L_0x009c:
        r6.pW = r2;
        r1 = r0;
        goto L_0x0027;
    L_0x00a0:
        if (r4 != 0) goto L_0x00a7;
    L_0x00a2:
        r6.qn = r2;
        r6.aY();
    L_0x00a7:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.l.execPendingActions():boolean");
    }

    final void ba() {
        if (this.qe != null) {
            for (int i = 0; i < this.qe.size(); i++) {
                this.qe.get(i);
            }
        }
    }

    final boolean g(int i, int i2) {
        if (this.qa == null) {
            return false;
        }
        int i3;
        d dVar;
        if (i >= 0 || (i2 & 1) != 0) {
            int size;
            i3 = -1;
            if (i >= 0) {
                size = this.qa.size() - 1;
                while (size >= 0) {
                    dVar = (d) this.qa.get(size);
                    if (i >= 0 && i == dVar.mIndex) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size--;
                    while (size >= 0) {
                        dVar = (d) this.qa.get(size);
                        if (i < 0 || i != dVar.mIndex) {
                            break;
                        }
                        size--;
                    }
                }
                i3 = size;
            }
            if (i3 == this.qa.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size = this.qa.size() - 1; size > i3; size--) {
                arrayList.add(this.qa.remove(size));
            }
            int size2 = arrayList.size() - 1;
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            for (size = 0; size <= size2; size++) {
                ((d) arrayList.get(size)).b(sparseArray, sparseArray2);
            }
            android.support.v4.app.d.b bVar = null;
            int i4 = 0;
            while (i4 <= size2) {
                boolean z;
                if (DEBUG) {
                    new StringBuilder("Popping back stack state: ").append(arrayList.get(i4));
                }
                dVar = (d) arrayList.get(i4);
                if (i4 == size2) {
                    z = true;
                } else {
                    z = false;
                }
                i4++;
                bVar = dVar.a(z, bVar, sparseArray, sparseArray2);
            }
        } else {
            i3 = this.qa.size() - 1;
            if (i3 < 0) {
                return false;
            }
            dVar = (d) this.qa.remove(i3);
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            dVar.b(sparseArray3, sparseArray4);
            dVar.a(true, null, sparseArray3, sparseArray4);
        }
        ba();
        return true;
    }

    private void i(Fragment fragment) {
        if (fragment.pj != null) {
            if (this.qp == null) {
                this.qp = new SparseArray();
            } else {
                this.qp.clear();
            }
            fragment.pj.saveHierarchyState(this.qp);
            if (this.qp.size() > 0) {
                fragment.oH = this.qp;
                this.qp = null;
            }
        }
    }

    private Bundle j(Fragment fragment) {
        Bundle bundle;
        if (this.qo == null) {
            this.qo = new Bundle();
        }
        fragment.d(this.qo);
        if (this.qo.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.qo;
            this.qo = null;
        }
        if (fragment.mView != null) {
            i(fragment);
        }
        if (fragment.oH != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.oH);
        }
        if (!fragment.pl) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.pl);
        }
        return bundle;
    }

    final Parcelable saveAllState() {
        BackStackState[] backStackStateArr = null;
        execPendingActions();
        if (pT) {
            this.qk = true;
        }
        if (this.pX == null || this.pX.size() <= 0) {
            return null;
        }
        int size = this.pX.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.pX.get(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState <= 0 || fragmentState.oG != null) {
                    fragmentState.oG = fragment.oG;
                } else {
                    fragmentState.oG = j(fragment);
                    if (fragment.oK != null) {
                        if (fragment.oK.mIndex < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.oK));
                        }
                        if (fragmentState.oG == null) {
                            fragmentState.oG = new Bundle();
                        }
                        a(fragmentState.oG, "android:target_state", fragment.oK);
                        if (fragment.oM != 0) {
                            fragmentState.oG.putInt("android:target_req_state", fragment.oM);
                        }
                    }
                }
                if (DEBUG) {
                    new StringBuilder("Saved state of ").append(fragment).append(": ").append(fragmentState.oG);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (!z) {
            return null;
        }
        int[] iArr;
        int i2;
        FragmentManagerState fragmentManagerState;
        if (this.pY != null) {
            i = this.pY.size();
            if (i > 0) {
                iArr = new int[i];
                for (i2 = 0; i2 < i; i2++) {
                    iArr[i2] = ((Fragment) this.pY.get(i2)).mIndex;
                    if (iArr[i2] < 0) {
                        a(new IllegalStateException("Failure saving state: active " + this.pY.get(i2) + " has cleared index: " + iArr[i2]));
                    }
                    if (DEBUG) {
                        new StringBuilder("saveAllState: adding fragment #").append(i2).append(": ").append(this.pY.get(i2));
                    }
                }
                if (this.qa != null) {
                    i = this.qa.size();
                    if (i > 0) {
                        backStackStateArr = new BackStackState[i];
                        for (i2 = 0; i2 < i; i2++) {
                            backStackStateArr[i2] = new BackStackState((d) this.qa.get(i2));
                            if (DEBUG) {
                                new StringBuilder("saveAllState: adding back stack #").append(i2).append(": ").append(this.qa.get(i2));
                            }
                        }
                    }
                }
                fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.qD = fragmentStateArr;
                fragmentManagerState.qE = iArr;
                fragmentManagerState.qF = backStackStateArr;
                return fragmentManagerState;
            }
        }
        iArr = null;
        if (this.qa != null) {
            i = this.qa.size();
            if (i > 0) {
                backStackStateArr = new BackStackState[i];
                for (i2 = 0; i2 < i; i2++) {
                    backStackStateArr[i2] = new BackStackState((d) this.qa.get(i2));
                    if (DEBUG) {
                        new StringBuilder("saveAllState: adding back stack #").append(i2).append(": ").append(this.qa.get(i2));
                    }
                }
            }
        }
        fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.qD = fragmentStateArr;
        fragmentManagerState.qE = iArr;
        fragmentManagerState.qF = backStackStateArr;
        return fragmentManagerState;
    }

    final void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.qD != null) {
                int i;
                Fragment fragment;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        fragment = (Fragment) list.get(i);
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: re-attaching retained ").append(fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.qD[fragment.mIndex];
                        fragmentState.qH = fragment;
                        fragment.oH = null;
                        fragment.oS = 0;
                        fragment.oQ = false;
                        fragment.oN = false;
                        fragment.oK = null;
                        if (fragmentState.oG != null) {
                            fragmentState.oG.setClassLoader(this.oU.mContext.getClassLoader());
                            fragment.oH = fragmentState.oG.getSparseParcelableArray("android:view_state");
                            fragment.oG = fragmentState.oG;
                        }
                    }
                }
                this.pX = new ArrayList(fragmentManagerState.qD.length);
                if (this.pZ != null) {
                    this.pZ.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.qD.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.qD[i2];
                    if (fragmentState2 != null) {
                        j jVar = this.oU;
                        Fragment fragment2 = this.qh;
                        if (fragmentState2.qH == null) {
                            Context context = jVar.mContext;
                            if (fragmentState2.oJ != null) {
                                fragmentState2.oJ.setClassLoader(context.getClassLoader());
                            }
                            fragmentState2.qH = Fragment.a(context, fragmentState2.qG, fragmentState2.oJ);
                            if (fragmentState2.oG != null) {
                                fragmentState2.oG.setClassLoader(context.getClassLoader());
                                fragmentState2.qH.oG = fragmentState2.oG;
                            }
                            fragmentState2.qH.c(fragmentState2.mIndex, fragment2);
                            fragmentState2.qH.oP = fragmentState2.oP;
                            fragmentState2.qH.oR = true;
                            fragmentState2.qH.oX = fragmentState2.oX;
                            fragmentState2.qH.oY = fragmentState2.oY;
                            fragmentState2.qH.oZ = fragmentState2.oZ;
                            fragmentState2.qH.pc = fragmentState2.pc;
                            fragmentState2.qH.pb = fragmentState2.pb;
                            fragmentState2.qH.oT = jVar.oT;
                            if (DEBUG) {
                                new StringBuilder("Instantiated fragment ").append(fragmentState2.qH);
                            }
                        }
                        Fragment fragment3 = fragmentState2.qH;
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: active #").append(i2).append(": ").append(fragment3);
                        }
                        this.pX.add(fragment3);
                        fragmentState2.qH = null;
                    } else {
                        this.pX.add(null);
                        if (this.pZ == null) {
                            this.pZ = new ArrayList();
                        }
                        if (DEBUG) {
                            this.pZ.add(Integer.valueOf(i2));
                        } else {
                            this.pZ.add(Integer.valueOf(i2));
                        }
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        fragment = (Fragment) list.get(i3);
                        if (fragment.oL >= 0) {
                            if (fragment.oL < this.pX.size()) {
                                fragment.oK = (Fragment) this.pX.get(fragment.oL);
                            } else {
                                new StringBuilder("Re-attaching retained fragment ").append(fragment).append(" target no longer exists: ").append(fragment.oL);
                                fragment.oK = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.qE != null) {
                    this.pY = new ArrayList(fragmentManagerState.qE.length);
                    for (i = 0; i < fragmentManagerState.qE.length; i++) {
                        fragment = (Fragment) this.pX.get(fragmentManagerState.qE[i]);
                        if (fragment == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.qE[i]));
                        }
                        fragment.oN = true;
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: added #").append(i).append(": ").append(fragment);
                        }
                        if (this.pY.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.pY.add(fragment);
                    }
                } else {
                    this.pY = null;
                }
                if (fragmentManagerState.qF != null) {
                    this.qa = new ArrayList(fragmentManagerState.qF.length);
                    for (i2 = 0; i2 < fragmentManagerState.qF.length; i2++) {
                        d a = fragmentManagerState.qF[i2].a(this);
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: back stack #").append(i2).append(" (index ").append(a.mIndex).append("): ").append(a);
                            a.a("  ", new PrintWriter(new d("FragmentManager")), false);
                        }
                        this.qa.add(a);
                        if (a.mIndex >= 0) {
                            a(a.mIndex, a);
                        }
                    }
                    return;
                }
                this.qa = null;
            }
        }
    }

    public final void a(j jVar, h hVar, Fragment fragment) {
        if (this.oU != null) {
            throw new IllegalStateException("Already attached");
        }
        this.oU = jVar;
        this.qg = hVar;
        this.qh = fragment;
    }

    public final void dispatchCreate() {
        this.qk = false;
        G(1);
    }

    public final void dispatchActivityCreated() {
        this.qk = false;
        G(2);
    }

    public final void dispatchStart() {
        this.qk = false;
        G(4);
    }

    public final void dispatchResume() {
        this.qk = false;
        G(5);
    }

    public final void dispatchStop() {
        this.qk = true;
        G(3);
    }

    public final void dispatchDestroy() {
        this.ql = true;
        execPendingActions();
        G(0);
        this.oU = null;
        this.qg = null;
        this.qh = null;
    }

    public final void dispatchConfigurationChanged(Configuration configuration) {
        if (this.pY != null) {
            for (int i = 0; i < this.pY.size(); i++) {
                Fragment fragment = (Fragment) this.pY.get(i);
                if (fragment != null) {
                    fragment.onConfigurationChanged(configuration);
                    if (fragment.oV != null) {
                        fragment.oV.dispatchConfigurationChanged(configuration);
                    }
                }
            }
        }
    }

    public final void dispatchLowMemory() {
        if (this.pY != null) {
            for (int i = 0; i < this.pY.size(); i++) {
                Fragment fragment = (Fragment) this.pY.get(i);
                if (fragment != null) {
                    fragment.onLowMemory();
                    if (fragment.oV != null) {
                        fragment.oV.dispatchLowMemory();
                    }
                }
            }
        }
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z;
        int i = 0;
        ArrayList arrayList = null;
        if (this.pY != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.pY.size()) {
                boolean z2;
                Fragment fragment = (Fragment) this.pY.get(i2);
                if (fragment != null) {
                    int i3;
                    if (fragment.pa) {
                        i3 = 0;
                    } else {
                        if (fragment.pe && fragment.pf) {
                            fragment.onCreateOptionsMenu(menu, menuInflater);
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (fragment.oV != null) {
                            i3 |= fragment.oV.dispatchCreateOptionsMenu(menu, menuInflater);
                        }
                    }
                    if (i3 != 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(fragment);
                        z2 = true;
                        i2++;
                        z = z2;
                    }
                }
                z2 = z;
                i2++;
                z = z2;
            }
        } else {
            z = false;
        }
        if (this.qb != null) {
            while (i < this.qb.size()) {
                fragment = (Fragment) this.qb.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    Fragment.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.qb = arrayList;
        return z;
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.pY == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.pY.size(); i++) {
            Fragment fragment = (Fragment) this.pY.get(i);
            if (fragment != null) {
                int i2;
                if (fragment.pa) {
                    i2 = 0;
                } else {
                    if (fragment.pe && fragment.pf) {
                        fragment.onPrepareOptionsMenu(menu);
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (fragment.oV != null) {
                        i2 |= fragment.oV.dispatchPrepareOptionsMenu(menu);
                    }
                }
                if (i2 != 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.pY == null) {
            return false;
        }
        for (int i = 0; i < this.pY.size(); i++) {
            Fragment fragment = (Fragment) this.pY.get(i);
            if (fragment != null) {
                boolean z;
                if (!fragment.pa) {
                    if (fragment.pe && fragment.pf && fragment.onOptionsItemSelected(menuItem)) {
                        z = true;
                        if (!z) {
                            return true;
                        }
                    } else if (fragment.oV != null && fragment.oV.dispatchOptionsItemSelected(menuItem)) {
                        z = true;
                        if (!z) {
                            return true;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.pY == null) {
            return false;
        }
        for (int i = 0; i < this.pY.size(); i++) {
            Fragment fragment = (Fragment) this.pY.get(i);
            if (fragment != null) {
                boolean z;
                if (!fragment.pa) {
                    if (fragment.onContextItemSelected(menuItem)) {
                        z = true;
                    } else if (fragment.oV != null && fragment.oV.dispatchContextItemSelected(menuItem)) {
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
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu) {
        if (this.pY != null) {
            for (int i = 0; i < this.pY.size(); i++) {
                Fragment fragment = (Fragment) this.pY.get(i);
                if (!(fragment == null || fragment.pa || fragment.oV == null)) {
                    fragment.oV.dispatchOptionsMenuClosed(menu);
                }
            }
        }
    }

    public static int H(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.qC);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.c(this.oU.mContext, string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment E = resourceId != -1 ? E(resourceId) : null;
        if (E == null && string2 != null) {
            E = k(string2);
        }
        if (E == null && id != -1) {
            E = E(id);
        }
        if (DEBUG) {
            new StringBuilder("onCreateView: id=0x").append(Integer.toHexString(resourceId)).append(" fname=").append(string).append(" existing=").append(E);
        }
        if (E == null) {
            Fragment b = Fragment.b(context, string);
            b.oP = true;
            b.oX = resourceId != 0 ? resourceId : id;
            b.oY = id;
            b.oZ = string2;
            b.oQ = true;
            b.oT = this;
            b.oU = this.oU;
            Bundle bundle = b.oG;
            b.aL();
            a(b, true);
            fragment = b;
        } else if (E.oQ) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            E.oQ = true;
            E.oU = this.oU;
            if (!E.pd) {
                Bundle bundle2 = E.oG;
                E.aL();
            }
            fragment = E;
        }
        if (this.qf > 0 || !fragment.oP) {
            g(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }
}

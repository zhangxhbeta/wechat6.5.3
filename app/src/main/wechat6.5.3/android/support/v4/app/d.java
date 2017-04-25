package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.o.AnonymousClass4;
import android.support.v4.e.g;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mmdb.FileUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class d extends n implements Runnable {
    static final boolean nz = (VERSION.SDK_INT >= 21);
    int mIndex = -1;
    String mName;
    final l nA;
    a nB;
    a nC;
    int nD;
    int nE;
    int nF;
    int nG;
    int nH;
    int nI;
    int nJ;
    boolean nK;
    boolean nL = true;
    boolean nM;
    int nN;
    CharSequence nO;
    int nP;
    CharSequence nQ;
    ArrayList<String> nR;
    ArrayList<String> nS;

    static final class a {
        a od;
        a oe;
        int of;
        Fragment og;
        int oh;
        int oi;
        int oj;
        int ok;
        ArrayList<Fragment> ol;

        a() {
        }
    }

    public class b {
        final /* synthetic */ d nU;
        public android.support.v4.e.a<String, String> om = new android.support.v4.e.a();
        public ArrayList<View> oo = new ArrayList();
        public android.support.v4.app.o.a oq = new android.support.v4.app.o.a();
        public View or;

        public b(d dVar) {
            this.nU = dVar;
        }
    }

    static /* synthetic */ android.support.v4.e.a a(d dVar, b bVar, boolean z, Fragment fragment) {
        android.support.v4.e.a a;
        Map aVar = new android.support.v4.e.a();
        View view = fragment.mView;
        if (!(view == null || dVar.nR == null)) {
            o.a(aVar, view);
            if (z) {
                a = a(dVar.nR, dVar.nS, (android.support.v4.e.a) aVar);
            } else {
                g.a(aVar, dVar.nS);
            }
        }
        ai aiVar;
        if (z) {
            if (fragment.py != null) {
                aiVar = fragment.py;
            }
            dVar.a(bVar, a, true);
        } else {
            if (fragment.px != null) {
                aiVar = fragment.px;
            }
            b(bVar, a, true);
        }
        return a;
    }

    static /* synthetic */ void a(Fragment fragment, Fragment fragment2, boolean z, android.support.v4.e.a aVar) {
        if ((z ? fragment2.px : fragment.px) != null) {
            ArrayList arrayList = new ArrayList(aVar.keySet());
            arrayList = new ArrayList(aVar.values());
        }
    }

    static /* synthetic */ void a(d dVar, android.support.v4.e.a aVar, b bVar) {
        if (dVar.nS != null && !aVar.isEmpty()) {
            View view = (View) aVar.get(dVar.nS.get(0));
            if (view != null) {
                bVar.oq.rj = view;
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mName != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mName);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public final void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.nM);
            if (this.nI != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.nI));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.nJ));
            }
            if (!(this.nE == 0 && this.nF == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.nE));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.nF));
            }
            if (!(this.nG == 0 && this.nH == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.nG));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.nH));
            }
            if (!(this.nN == 0 && this.nO == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.nN));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.nO);
            }
            if (!(this.nP == 0 && this.nQ == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.nP));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.nQ);
            }
        }
        if (this.nB != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            a aVar = this.nB;
            while (aVar != null) {
                String str3;
                switch (aVar.of) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + aVar.of;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(aVar.og);
                if (z) {
                    if (!(aVar.oh == 0 && aVar.oi == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.oh));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.oi));
                    }
                    if (!(aVar.oj == 0 && aVar.ok == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.oj));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.ok));
                    }
                }
                if (aVar.ol != null && aVar.ol.size() > 0) {
                    for (int i2 = 0; i2 < aVar.ol.size(); i2++) {
                        printWriter.print(str2);
                        if (aVar.ol.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(aVar.ol.get(i2));
                    }
                }
                aVar = aVar.od;
                i++;
            }
        }
    }

    public d(l lVar) {
        this.nA = lVar;
    }

    final void a(a aVar) {
        if (this.nB == null) {
            this.nC = aVar;
            this.nB = aVar;
        } else {
            aVar.oe = this.nC;
            this.nC.od = aVar;
            this.nC = aVar;
        }
        aVar.oh = this.nE;
        aVar.oi = this.nF;
        aVar.oj = this.nG;
        aVar.ok = this.nH;
        this.nD++;
    }

    public final n a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public final n a(int i, Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    public final n a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        fragment.oT = this.nA;
        if (str != null) {
            if (fragment.oZ == null || str.equals(fragment.oZ)) {
                fragment.oZ = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.oZ + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.oX == 0 || fragment.oX == i) {
                fragment.oX = i;
                fragment.oY = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.oX + " now " + i);
            }
        }
        a aVar = new a();
        aVar.of = i2;
        aVar.og = fragment;
        a(aVar);
    }

    public final n b(int i, Fragment fragment) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, null, 2);
        return this;
    }

    public final n a(Fragment fragment) {
        a aVar = new a();
        aVar.of = 3;
        aVar.og = fragment;
        a(aVar);
        return this;
    }

    public final n b(Fragment fragment) {
        a aVar = new a();
        aVar.of = 6;
        aVar.og = fragment;
        a(aVar);
        return this;
    }

    public final n c(Fragment fragment) {
        a aVar = new a();
        aVar.of = 7;
        aVar.og = fragment;
        a(aVar);
        return this;
    }

    final void D(int i) {
        if (this.nK) {
            if (l.DEBUG) {
                new StringBuilder("Bump nesting in ").append(this).append(" by ").append(i);
            }
            for (a aVar = this.nB; aVar != null; aVar = aVar.od) {
                Fragment fragment;
                if (aVar.og != null) {
                    fragment = aVar.og;
                    fragment.oS += i;
                    if (l.DEBUG) {
                        new StringBuilder("Bump nesting of ").append(aVar.og).append(" to ").append(aVar.og.oS);
                    }
                }
                if (aVar.ol != null) {
                    for (int size = aVar.ol.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) aVar.ol.get(size);
                        fragment.oS += i;
                        if (l.DEBUG) {
                            new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.oS);
                        }
                    }
                }
            }
        }
    }

    public final int commit() {
        return m(false);
    }

    public final int commitAllowingStateLoss() {
        return m(true);
    }

    private int m(boolean z) {
        if (this.nM) {
            throw new IllegalStateException("commit already called");
        }
        if (l.DEBUG) {
            new StringBuilder("Commit: ").append(this);
            a("  ", new PrintWriter(new android.support.v4.e.d("FragmentManager")));
        }
        this.nM = true;
        if (this.nK) {
            this.mIndex = this.nA.a(this);
        } else {
            this.mIndex = -1;
        }
        this.nA.a((Runnable) this, z);
        return this.mIndex;
    }

    public final void run() {
        if (l.DEBUG) {
            new StringBuilder("Run: ").append(this);
        }
        if (!this.nK || this.mIndex >= 0) {
            b a;
            D(1);
            if (nz) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                a(sparseArray, sparseArray2);
                a = a(sparseArray, sparseArray2, false);
            } else {
                Object obj = null;
            }
            int i = a != null ? 0 : this.nJ;
            int i2 = a != null ? 0 : this.nI;
            a aVar = this.nB;
            while (aVar != null) {
                int i3 = a != null ? 0 : aVar.oh;
                int i4 = a != null ? 0 : aVar.oi;
                Fragment fragment;
                switch (aVar.of) {
                    case 1:
                        fragment = aVar.og;
                        fragment.ph = i3;
                        this.nA.a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = aVar.og;
                        int i5 = fragment2.oY;
                        if (this.nA.pY != null) {
                            int size = this.nA.pY.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.nA.pY.get(size);
                                if (l.DEBUG) {
                                    new StringBuilder("OP_REPLACE: adding=").append(fragment2).append(" old=").append(fragment);
                                }
                                if (fragment.oY == i5) {
                                    if (fragment == fragment2) {
                                        aVar.og = null;
                                        fragment = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (aVar.ol == null) {
                                            aVar.ol = new ArrayList();
                                        }
                                        aVar.ol.add(fragment);
                                        fragment.ph = i4;
                                        if (this.nK) {
                                            fragment.oS++;
                                            if (l.DEBUG) {
                                                new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.oS);
                                            }
                                        }
                                        this.nA.a(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.ph = i3;
                        this.nA.a(fragment2, false);
                        break;
                    case 3:
                        fragment = aVar.og;
                        fragment.ph = i4;
                        this.nA.a(fragment, i2, i);
                        break;
                    case 4:
                        fragment = aVar.og;
                        fragment.ph = i4;
                        this.nA.b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = aVar.og;
                        fragment.ph = i3;
                        this.nA.c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = aVar.og;
                        fragment.ph = i4;
                        this.nA.d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = aVar.og;
                        fragment.ph = i3;
                        this.nA.e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.of);
                }
                aVar = aVar.od;
            }
            this.nA.b(this.nA.qf, i2, i, true);
            if (this.nK) {
                l lVar = this.nA;
                if (lVar.qa == null) {
                    lVar.qa = new ArrayList();
                }
                lVar.qa.add(this);
                lVar.ba();
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.oY;
            if (i != 0 && !fragment.pa) {
                if (fragment.isAdded() && fragment.mView != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private static void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.oY;
            if (i != 0) {
                if (!fragment.isAdded()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
        }
    }

    private void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.nA.qg.onHasView()) {
            for (a aVar = this.nB; aVar != null; aVar = aVar.od) {
                switch (aVar.of) {
                    case 1:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 2:
                        Fragment fragment = aVar.og;
                        if (this.nA.pY != null) {
                            Fragment fragment2 = fragment;
                            for (int i = 0; i < this.nA.pY.size(); i++) {
                                Fragment fragment3 = (Fragment) this.nA.pY.get(i);
                                if (fragment2 == null || fragment3.oY == fragment2.oY) {
                                    if (fragment3 == fragment2) {
                                        fragment2 = null;
                                        sparseArray2.remove(fragment3.oY);
                                    } else {
                                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, fragment3);
                                    }
                                }
                            }
                        }
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 3:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 4:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 5:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 6:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 7:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.nA.qg.onHasView()) {
            for (a aVar = this.nC; aVar != null; aVar = aVar.oe) {
                switch (aVar.of) {
                    case 1:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 2:
                        if (aVar.ol != null) {
                            for (int size = aVar.ol.size() - 1; size >= 0; size--) {
                                b((SparseArray) sparseArray, (SparseArray) sparseArray2, (Fragment) aVar.ol.get(size));
                            }
                        }
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 3:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 4:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 5:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 6:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    case 7:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.og);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final b a(boolean z, b bVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (l.DEBUG) {
            new StringBuilder("popFromBackStack: ").append(this);
            a("  ", new PrintWriter(new android.support.v4.e.d("FragmentManager")));
        }
        if (nz) {
            if (bVar == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    bVar = a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                a(bVar, this.nS, this.nR);
            }
        }
        D(-1);
        int i = bVar != null ? 0 : this.nJ;
        int i2 = bVar != null ? 0 : this.nI;
        a aVar = this.nC;
        while (aVar != null) {
            int i3 = bVar != null ? 0 : aVar.oj;
            int i4 = bVar != null ? 0 : aVar.ok;
            Fragment fragment;
            Fragment fragment2;
            switch (aVar.of) {
                case 1:
                    fragment = aVar.og;
                    fragment.ph = i4;
                    this.nA.a(fragment, l.H(i2), i);
                    break;
                case 2:
                    fragment = aVar.og;
                    if (fragment != null) {
                        fragment.ph = i4;
                        this.nA.a(fragment, l.H(i2), i);
                    }
                    if (aVar.ol == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < aVar.ol.size(); i5++) {
                        fragment2 = (Fragment) aVar.ol.get(i5);
                        fragment2.ph = i3;
                        this.nA.a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = aVar.og;
                    fragment2.ph = i3;
                    this.nA.a(fragment2, false);
                    break;
                case 4:
                    fragment2 = aVar.og;
                    fragment2.ph = i3;
                    this.nA.c(fragment2, l.H(i2), i);
                    break;
                case 5:
                    fragment = aVar.og;
                    fragment.ph = i4;
                    this.nA.b(fragment, l.H(i2), i);
                    break;
                case 6:
                    fragment2 = aVar.og;
                    fragment2.ph = i3;
                    this.nA.e(fragment2, l.H(i2), i);
                    break;
                case 7:
                    fragment2 = aVar.og;
                    fragment2.ph = i3;
                    this.nA.d(fragment2, l.H(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.of);
            }
            aVar = aVar.oe;
        }
        if (z) {
            this.nA.b(this.nA.qf, l.H(i2), i, true);
            bVar = null;
        }
        if (this.mIndex >= 0) {
            l lVar = this.nA;
            i4 = this.mIndex;
            synchronized (lVar) {
                lVar.qc.set(i4, null);
                if (lVar.qd == null) {
                    lVar.qd = new ArrayList();
                }
                if (l.DEBUG) {
                    lVar.qd.add(Integer.valueOf(i4));
                } else {
                    lVar.qd.add(Integer.valueOf(i4));
                }
            }
            this.mIndex = -1;
        }
        return bVar;
    }

    private b a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = (Fragment) sparseArray2.valueAt(i2);
            if (fragment.mState <= 0) {
                this.nA.h(fragment);
                this.nA.a(fragment, 1, 0, 0, false);
            }
        }
        b bVar = new b(this);
        bVar.or = new View(this.nA.oU.mContext);
        int i3 = 0;
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            if (a(sparseArray.keyAt(i4), bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
        }
        while (i < sparseArray2.size()) {
            int keyAt = sparseArray2.keyAt(i);
            if (sparseArray.get(keyAt) == null && a(keyAt, bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return bVar;
    }

    private static Object a(Object obj, Fragment fragment, ArrayList<View> arrayList, android.support.v4.e.a<String, View> aVar, View view) {
        if (obj == null) {
            return obj;
        }
        View view2 = fragment.mView;
        if (obj == null) {
            return obj;
        }
        o.a((ArrayList) arrayList, view2);
        if (aVar != null) {
            arrayList.removeAll(aVar.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view);
        o.b((Transition) obj, arrayList);
        return obj;
    }

    private android.support.v4.e.a<String, View> a(b bVar, Fragment fragment, boolean z) {
        android.support.v4.e.a aVar = new android.support.v4.e.a();
        if (this.nR != null) {
            o.a((Map) aVar, fragment.mView);
            if (z) {
                g.a((Map) aVar, this.nS);
            } else {
                aVar = a(this.nR, this.nS, aVar);
            }
        }
        ai aiVar;
        if (z) {
            if (fragment.px != null) {
                aiVar = fragment.px;
            }
            a(bVar, aVar, false);
        } else {
            if (fragment.py != null) {
                aiVar = fragment.py;
            }
            b(bVar, aVar, false);
        }
        return aVar;
    }

    private boolean a(int i, b bVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        final View view = (ViewGroup) this.nA.qg.onFindViewById(i);
        if (view == null) {
            return false;
        }
        Object obj;
        Object obj2;
        Transition transition;
        Object obj3;
        android.support.v4.e.a aVar;
        Object obj4;
        final Fragment fragment = (Fragment) sparseArray2.get(i);
        final Fragment fragment2 = (Fragment) sparseArray.get(i);
        if (fragment == null) {
            obj = null;
        } else {
            Object obj5 = z ? fragment.ps == Fragment.oD ? fragment.pr : fragment.ps : fragment.pp;
            obj = o.e(obj5);
        }
        if (fragment == null || fragment2 == null) {
            obj2 = null;
        } else {
            obj5 = z ? fragment2.pu == Fragment.oD ? fragment2.pt : fragment2.pu : fragment.pt;
            if (obj5 == null) {
                obj2 = null;
            } else {
                transition = (Transition) obj5;
                if (transition == null) {
                    obj2 = null;
                } else {
                    obj2 = new TransitionSet();
                    obj2.addTransition(transition);
                }
            }
        }
        if (fragment2 == null) {
            obj3 = null;
        } else {
            obj5 = z ? fragment2.pq == Fragment.oD ? fragment2.pp : fragment2.pq : fragment2.pr;
            obj3 = o.e(obj5);
        }
        final ArrayList arrayList = new ArrayList();
        if (obj2 != null) {
            android.support.v4.e.a a = a(bVar, fragment2, z);
            if (a.isEmpty()) {
                aVar = null;
                obj4 = null;
            } else {
                if ((z ? fragment2.px : fragment.px) != null) {
                    ArrayList arrayList2 = new ArrayList(a.keySet());
                    arrayList2 = new ArrayList(a.values());
                }
                final b bVar2 = bVar;
                final boolean z2 = z;
                view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                    final /* synthetic */ d nU;

                    public final boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (obj2 != null) {
                            o.a(obj2, arrayList);
                            arrayList.clear();
                            android.support.v4.e.a a = d.a(this.nU, bVar2, z2, fragment);
                            o.a(obj2, bVar2.or, a, arrayList);
                            d.a(this.nU, a, bVar2);
                            d.a(fragment, fragment2, z2, a);
                        }
                        return true;
                    }
                });
                aVar = a;
                obj4 = obj2;
            }
        } else {
            aVar = null;
            obj4 = obj2;
        }
        if (obj == null && obj4 == null && obj3 == null) {
            return false;
        }
        Object obj6;
        ArrayList arrayList3 = new ArrayList();
        obj2 = a(obj3, fragment2, arrayList3, aVar, bVar.or);
        if (!(this.nS == null || aVar == null)) {
            View view2 = (View) aVar.get(this.nS.get(0));
            if (view2 != null) {
                if (obj2 != null) {
                    o.a(obj2, view2);
                }
                if (obj4 != null) {
                    o.a(obj4, view2);
                }
            }
        }
        android.support.v4.app.o.b anonymousClass1 = new android.support.v4.app.o.b(this) {
            final /* synthetic */ d nU;

            public final View getView() {
                return fragment.mView;
            }
        };
        ArrayList arrayList4 = new ArrayList();
        Map aVar2 = new android.support.v4.e.a();
        if (fragment != null) {
            boolean booleanValue = z ? fragment.pv == null ? true : fragment.pv.booleanValue() : fragment.pw == null ? true : fragment.pw.booleanValue();
            z2 = booleanValue;
        } else {
            z2 = true;
        }
        transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj4;
        if (transition == null || transition2 == null) {
            z2 = true;
        }
        if (z2) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 != null) {
                transitionSet.addTransition(transition3);
            }
            obj6 = transitionSet;
        } else {
            if (transition2 != null && transition != null) {
                transition = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
            } else if (transition2 != null) {
                transition = transition2;
            } else if (transition == null) {
                transition = null;
            }
            if (transition3 != null) {
                obj6 = new TransitionSet();
                if (transition != null) {
                    obj6.addTransition(transition);
                }
                obj6.addTransition(transition3);
            } else {
                transition2 = transition;
            }
        }
        if (obj6 != null) {
            View view3 = bVar.or;
            android.support.v4.app.o.a aVar3 = bVar.oq;
            Map map = bVar.om;
            if (!(obj == null && obj4 == null)) {
                Transition transition4 = (Transition) obj;
                if (transition4 != null) {
                    transition4.addTarget(view3);
                }
                if (obj4 != null) {
                    o.a(obj4, view3, aVar, arrayList);
                }
                view.getViewTreeObserver().addOnPreDrawListener(new android.support.v4.app.o.AnonymousClass2(view, transition4, view3, anonymousClass1, map, aVar2, arrayList4));
                if (transition4 != null) {
                    transition4.setEpicenterCallback(new android.support.v4.app.o.AnonymousClass3(aVar3));
                }
            }
            final View view4 = view;
            final b bVar3 = bVar;
            final int i2 = i;
            final Object obj7 = obj6;
            view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ d nU;

                public final boolean onPreDraw() {
                    view4.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.nU.a(bVar3, i2, obj7);
                    return true;
                }
            });
            o.a(obj6, bVar.or, true);
            a(bVar, i, obj6);
            TransitionManager.beginDelayedTransition(view, (Transition) obj6);
            View view5 = bVar.or;
            ArrayList arrayList5 = bVar.oo;
            Transition transition5 = (Transition) obj;
            Transition transition6 = (Transition) obj2;
            Transition transition7 = (Transition) obj4;
            Transition transition8 = (Transition) obj6;
            if (transition8 != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass4(view, transition5, arrayList4, transition6, arrayList3, transition7, arrayList, aVar2, arrayList5, transition8, view5));
            }
        }
        if (obj6 != null) {
            return true;
        }
        return false;
    }

    private static android.support.v4.e.a<String, View> a(ArrayList<String> arrayList, ArrayList<String> arrayList2, android.support.v4.e.a<String, View> aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        android.support.v4.e.a<String, View> aVar2 = new android.support.v4.e.a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) aVar.get(arrayList.get(i));
            if (view != null) {
                aVar2.put(arrayList2.get(i), view);
            }
        }
        return aVar2;
    }

    private void a(b bVar, int i, Object obj) {
        if (this.nA.pY != null) {
            for (int i2 = 0; i2 < this.nA.pY.size(); i2++) {
                Fragment fragment = (Fragment) this.nA.pY.get(i2);
                if (!(fragment.mView == null || fragment.pi == null || fragment.oY != i)) {
                    if (!fragment.pa) {
                        o.a(obj, fragment.mView, false);
                        bVar.oo.remove(fragment.mView);
                    } else if (!bVar.oo.contains(fragment.mView)) {
                        o.a(obj, fragment.mView, true);
                        bVar.oo.add(fragment.mView);
                    }
                }
            }
        }
    }

    private static void a(android.support.v4.e.a<String, String> aVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < aVar.size(); i++) {
                if (str.equals(aVar.valueAt(i))) {
                    aVar.setValueAt(i, str2);
                    return;
                }
            }
            aVar.put(str, str2);
        }
    }

    private static void a(b bVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                a(bVar.om, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void a(b bVar, android.support.v4.e.a<String, View> aVar, boolean z) {
        int size = this.nS == null ? 0 : this.nS.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.nR.get(i);
            View view = (View) aVar.get((String) this.nS.get(i));
            if (view != null) {
                String transitionName = view.getTransitionName();
                if (z) {
                    a(bVar.om, str, transitionName);
                } else {
                    a(bVar.om, transitionName, str);
                }
            }
        }
    }

    private static void b(b bVar, android.support.v4.e.a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) aVar.keyAt(i);
            String transitionName = ((View) aVar.valueAt(i)).getTransitionName();
            if (z) {
                a(bVar.om, str, transitionName);
            } else {
                a(bVar.om, transitionName, str);
            }
        }
    }
}

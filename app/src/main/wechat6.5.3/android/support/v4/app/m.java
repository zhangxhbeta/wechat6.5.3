package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.t;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class m extends t {
    private final k qI;
    private n qJ = null;
    private ArrayList<SavedState> qK = new ArrayList();
    private ArrayList<Fragment> qL = new ArrayList();
    private Fragment qM = null;

    public abstract Fragment I(int i);

    public m(k kVar) {
        this.qI = kVar;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.qL.size() > i) {
            Fragment fragment = (Fragment) this.qL.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.qJ == null) {
            this.qJ = this.qI.aW();
        }
        Fragment I = I(i);
        if (this.qK.size() > i) {
            SavedState savedState = (SavedState) this.qK.get(i);
            if (savedState != null) {
                if (I.mIndex >= 0) {
                    throw new IllegalStateException("Fragment already active");
                }
                Bundle bundle;
                if (savedState == null || savedState.pA == null) {
                    bundle = null;
                } else {
                    bundle = savedState.pA;
                }
                I.oG = bundle;
            }
        }
        while (this.qL.size() <= i) {
            this.qL.add(null);
        }
        I.setMenuVisibility(false);
        I.setUserVisibleHint(false);
        this.qL.set(i, I);
        this.qJ.a(viewGroup.getId(), I);
        return I;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.qJ == null) {
            this.qJ = this.qI.aW();
        }
        while (this.qK.size() <= i) {
            this.qK.add(null);
        }
        this.qK.set(i, fragment.isAdded() ? this.qI.e(fragment) : null);
        this.qL.set(i, null);
        this.qJ.a(fragment);
    }

    public final void d(Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.qM) {
            if (this.qM != null) {
                this.qM.setMenuVisibility(false);
                this.qM.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.qM = fragment;
        }
    }

    public final void bb() {
        if (this.qJ != null) {
            this.qJ.commitAllowingStateLoss();
            this.qJ = null;
            this.qI.executePendingTransactions();
        }
    }

    public final boolean a(View view, Object obj) {
        return ((Fragment) obj).mView == view;
    }

    public final Parcelable bc() {
        Bundle bundle = null;
        if (this.qK.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.qK.size()];
            this.qK.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.qL.size(); i++) {
            Fragment fragment = (Fragment) this.qL.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.qI.a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public final void a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.qK.clear();
            this.qL.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.qK.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.qI.a(bundle, str);
                    if (a != null) {
                        while (this.qL.size() <= parseInt) {
                            this.qL.add(null);
                        }
                        a.setMenuVisibility(false);
                        this.qL.set(parseInt, a);
                    }
                }
            }
        }
    }
}

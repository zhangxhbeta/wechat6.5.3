package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.e.c;
import android.support.v4.e.i;
import android.support.v4.view.g;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.tencent.mmdb.FileUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final i<String, Class<?>> oC = new i();
    static final Object oD = new Object();
    int mIndex = -1;
    int mState = 0;
    public View mView;
    View oE;
    int oF;
    Bundle oG;
    SparseArray<Parcelable> oH;
    String oI;
    public Bundle oJ;
    Fragment oK;
    int oL = -1;
    int oM;
    boolean oN;
    public boolean oO;
    boolean oP;
    boolean oQ;
    boolean oR;
    int oS;
    l oT;
    j oU;
    l oV;
    Fragment oW;
    int oX;
    int oY;
    String oZ;
    boolean pa;
    boolean pb;
    boolean pc;
    boolean pd;
    boolean pe;
    boolean pf = true;
    boolean pg;
    int ph;
    ViewGroup pi;
    View pj;
    boolean pk;
    boolean pl = true;
    r pm;
    boolean pn;
    boolean po;
    Object pp = null;
    Object pq = oD;
    Object pr = null;
    Object ps = oD;
    Object pt = null;
    Object pu = oD;
    Boolean pv;
    Boolean pw;
    ai px = null;
    ai py = null;

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final Bundle pA;

        SavedState(Bundle bundle) {
            this.pA = bundle;
        }

        SavedState(Parcel parcel) {
            this.pA = parcel.readBundle();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.pA);
        }
    }

    public static class a extends RuntimeException {
        public a(String str, Exception exception) {
            super(str, exception);
        }
    }

    public static Fragment b(Context context, String str) {
        return a(context, str, null);
    }

    public static Fragment a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) oC.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                oC.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.oJ = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (Exception e2) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e22);
        }
    }

    static boolean c(Context context, String str) {
        try {
            Class cls = (Class) oC.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                oC.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void c(int i, Fragment fragment) {
        this.mIndex = i;
        if (fragment != null) {
            this.oI = fragment.oI + ":" + this.mIndex;
        } else {
            this.oI = "android:fragment:" + this.mIndex;
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        c.a(this, stringBuilder);
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.oX != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.oX));
        }
        if (this.oZ != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.oZ);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final void setArguments(Bundle bundle) {
        if (this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.oJ = bundle;
    }

    public Context getContext() {
        return this.oU == null ? null : this.oU.mContext;
    }

    public final FragmentActivity aG() {
        return this.oU == null ? null : (FragmentActivity) this.oU.pP;
    }

    public final Resources getResources() {
        if (this.oU != null) {
            return this.oU.mContext.getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final boolean isAdded() {
        return this.oU != null && this.oN;
    }

    public static void aH() {
    }

    public final void aI() {
        if (!this.pe) {
            this.pe = true;
            if (isAdded() && !this.pa) {
                this.oU.aU();
            }
        }
    }

    public final void setMenuVisibility(boolean z) {
        if (this.pf != z) {
            this.pf = z;
            if (this.pe && isAdded() && !this.pa) {
                this.oU.aU();
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        if (!this.pl && z && this.mState < 4) {
            this.oT.f(this);
        }
        this.pl = z;
        this.pk = !z;
    }

    public final q aJ() {
        if (this.pm != null) {
            return this.pm;
        }
        if (this.oU == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.po = true;
        this.pm = this.oU.a(this.oI, this.pn, true);
        return this.pm;
    }

    public void startActivity(Intent intent) {
        if (this.oU == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.oU.b(this, intent, -1, null);
    }

    public final void startActivityForResult(Intent intent, int i) {
        if (this.oU == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.oU.b(this, intent, i, null);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public static void aK() {
    }

    public LayoutInflater c(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = this.oU.onGetLayoutInflater();
        if (this.oV == null) {
            aO();
            if (this.mState >= 5) {
                this.oV.dispatchResume();
            } else if (this.mState >= 4) {
                this.oV.dispatchStart();
            } else if (this.mState >= 2) {
                this.oV.dispatchActivityCreated();
            } else if (this.mState > 0) {
                this.oV.dispatchCreate();
            }
        }
        g.a(onGetLayoutInflater, this.oV);
        return onGetLayoutInflater;
    }

    public final void aL() {
        this.pg = true;
        if ((this.oU == null ? null : this.oU.pP) != null) {
            this.pg = false;
            this.pg = true;
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.pg = true;
    }

    public static Animation aM() {
        return null;
    }

    public void onCreate(Bundle bundle) {
        this.pg = true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void aN() {
    }

    public void onActivityCreated(Bundle bundle) {
        this.pg = true;
    }

    public void onStart() {
        this.pg = true;
        if (!this.pn) {
            this.pn = true;
            if (!this.po) {
                this.po = true;
                this.pm = this.oU.a(this.oI, this.pn, false);
            }
            if (this.pm != null) {
                this.pm.be();
            }
        }
    }

    public void onResume() {
        this.pg = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.pg = true;
    }

    public void onPause() {
        this.pg = true;
    }

    public void onStop() {
        this.pg = true;
    }

    public void onLowMemory() {
        this.pg = true;
    }

    public void onDestroyView() {
        this.pg = true;
    }

    public void onDestroy() {
        this.pg = true;
        if (!this.po) {
            this.po = true;
            this.pm = this.oU.a(this.oI, this.pn, false);
        }
        if (this.pm != null) {
            this.pm.bj();
        }
    }

    public void onDetach() {
        this.pg = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public static void onDestroyOptionsMenu() {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        aG().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.oX));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.oY));
        printWriter.print(" mTag=");
        printWriter.println(this.oZ);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mIndex=");
        printWriter.print(this.mIndex);
        printWriter.print(" mWho=");
        printWriter.print(this.oI);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.oS);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.oN);
        printWriter.print(" mRemoving=");
        printWriter.print(this.oO);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.oP);
        printWriter.print(" mInLayout=");
        printWriter.println(this.oQ);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.pa);
        printWriter.print(" mDetached=");
        printWriter.print(this.pb);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.pf);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.pe);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.pc);
        printWriter.print(" mRetaining=");
        printWriter.print(this.pd);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.pl);
        if (this.oT != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.oT);
        }
        if (this.oU != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.oU);
        }
        if (this.oW != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.oW);
        }
        if (this.oJ != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.oJ);
        }
        if (this.oG != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.oG);
        }
        if (this.oH != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.oH);
        }
        if (this.oK != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.oK);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.oM);
        }
        if (this.ph != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.ph);
        }
        if (this.pi != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.pi);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.pj != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (this.oE != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.oE);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.oF);
        }
        if (this.pm != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.pm.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.oV != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.oV + ":");
            this.oV.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    final void aO() {
        this.oV = new l();
        this.oV.a(this.oU, new h(this) {
            final /* synthetic */ Fragment pz;

            {
                this.pz = r1;
            }

            public final View onFindViewById(int i) {
                if (this.pz.mView != null) {
                    return this.pz.mView.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            public final boolean onHasView() {
                return this.pz.mView != null;
            }
        }, this);
    }

    final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.oV != null) {
            this.oV.qk = false;
        }
        return onCreateView(layoutInflater, viewGroup, bundle);
    }

    final void d(Bundle bundle) {
        onSaveInstanceState(bundle);
        if (this.oV != null) {
            Parcelable saveAllState = this.oV.saveAllState();
            if (saveAllState != null) {
                bundle.putParcelable("android:support:fragments", saveAllState);
            }
        }
    }

    final void aP() {
        if (this.oV != null) {
            this.oV.G(2);
        }
        this.mState = 2;
        if (this.pn) {
            this.pn = false;
            if (!this.po) {
                this.po = true;
                this.pm = this.oU.a(this.oI, this.pn, false);
            }
            if (this.pm == null) {
                return;
            }
            if (this.oU.pS) {
                this.pm.bg();
            } else {
                this.pm.bf();
            }
        }
    }
}

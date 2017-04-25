package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.e.i;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class j<E> extends h {
    final Context mContext;
    final Handler mHandler;
    final l oT;
    final Activity pP;
    final int pQ;
    i<String, q> pR;
    boolean pS;
    r pm;
    boolean pn;
    boolean po;

    j(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler);
    }

    private j(Activity activity, Context context, Handler handler) {
        this.oT = new l();
        this.pP = activity;
        this.mContext = context;
        this.mHandler = handler;
        this.pQ = 0;
    }

    public void a(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean aT() {
        return true;
    }

    public LayoutInflater onGetLayoutInflater() {
        return (LayoutInflater) this.mContext.getSystemService("layout_inflater");
    }

    public void aU() {
    }

    public void b(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.mContext.startActivity(intent);
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public int onGetWindowAnimations() {
        return this.pQ;
    }

    public View onFindViewById(int i) {
        return null;
    }

    public boolean onHasView() {
        return true;
    }

    final void j(String str) {
        if (this.pR != null) {
            r rVar = (r) this.pR.get(str);
            if (rVar != null && !rVar.pd) {
                rVar.bj();
                this.pR.remove(str);
            }
        }
    }

    final r a(String str, boolean z, boolean z2) {
        if (this.pR == null) {
            this.pR = new i();
        }
        r rVar = (r) this.pR.get(str);
        if (rVar != null) {
            rVar.oU = this;
            return rVar;
        } else if (!z2) {
            return rVar;
        } else {
            rVar = new r(str, this, z);
            this.pR.put(str, rVar);
            return rVar;
        }
    }

    final i<String, q> aV() {
        int i;
        int i2 = 0;
        if (this.pR != null) {
            int size = this.pR.size();
            r[] rVarArr = new r[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                rVarArr[i3] = (r) this.pR.valueAt(i3);
            }
            i = 0;
            while (i2 < size) {
                r rVar = rVarArr[i2];
                if (rVar.pd) {
                    i = 1;
                } else {
                    rVar.bj();
                    this.pR.remove(rVar.oI);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.pR;
        }
        return null;
    }
}

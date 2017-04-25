package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class p extends h {
    String className;
    public k nDR = new k(this) {
        final /* synthetic */ p nFx;

        {
            this.nFx = r1;
        }

        protected final int getLayoutId() {
            return this.nFx.getLayoutId();
        }

        protected final void bB(View view) {
            this.nFx.bB(view);
        }

        protected final String avS() {
            return this.nFx.avS();
        }

        protected final View bAd() {
            return this.nFx.bAd();
        }

        public final void aRG() {
            this.nFx.aRG();
        }

        protected final void PK() {
            p.PK();
        }

        protected final String getClassName() {
            return this.nFx.getClass().getName();
        }

        protected final boolean bzR() {
            return false;
        }

        public final boolean Sk() {
            return this.nFx.Sk();
        }
    };
    protected ActionBarActivity nFu;
    public boolean nFv = false;
    public SwipeBackLayout nFw;

    public abstract int getLayoutId();

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.nDR.nEl;
    }

    public p(boolean z) {
        super(z);
    }

    protected static void PK() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.a(bzo().getBaseContext(), (ActionBarActivity) bzo());
    }

    public final void aN() {
        if (bAm()) {
            View view = this.nDR.dtW;
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                this.nFw = (SwipeBackLayout) LayoutInflater.from(bzo()).inflate(2130904532, viewGroup, false);
                viewGroup.removeView(view);
                viewGroup.addView(this.nFw);
            } else {
                this.nFw = (SwipeBackLayout) LayoutInflater.from(bzo()).inflate(2130904532, null);
            }
            this.nFw.addView(view);
            this.nFw.Hq = view;
            this.nFw.ks(true);
            this.nFw.peB = new a(this) {
                final /* synthetic */ p nFx;

                {
                    this.nFx = r1;
                }

                public final void Rj() {
                    this.nFx.Rj();
                }

                public final void onCancel() {
                    this.nFx.bAo();
                }

                public final void Rk() {
                    this.nFx.bAn();
                }
            };
        }
    }

    public final boolean bAm() {
        if (d.dW(19) && com.tencent.mm.compatible.h.a.sh()) {
            return aXG();
        }
        return false;
    }

    public boolean aXG() {
        return true;
    }

    public boolean Sk() {
        return false;
    }

    public void Rj() {
    }

    public void bAn() {
    }

    public void bAo() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aI();
        return this.nDR.dtW;
    }

    public void bB(View view) {
    }

    public void aRG() {
    }

    public final void a(ActionBarActivity actionBarActivity) {
        this.nFu = actionBarActivity;
    }

    public final Activity aLx() {
        return this.nDR.nEl;
    }

    public final void ca(boolean z) {
        this.nDR.ca(z);
    }

    public void onStart() {
        this.nDR.onStart();
        super.onStart();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.nDR.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.nDR.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        v.ar(1, this.className);
        super.onResume();
        v.v("MicroMsg.INIT", "KEVIN MMActivity super..onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.nDR.onResume();
        v.v("MicroMsg.INIT", "KEVIN MMActivity onResume :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onDestroy() {
        super.onDestroy();
        this.nDR.onDestroy();
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        v.ar(2, this.className);
        super.onPause();
        if (this.nFv) {
            this.nFv = false;
        } else {
            this.nDR.onPause();
        }
        v.v("MicroMsg.INIT", "KEVIN MMActivity onPause:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (!this.nDR.onCreateOptionsMenu(menu)) {
            super.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    public final void onPrepareOptionsMenu(Menu menu) {
        this.nDR.onPrepareOptionsMenu(menu);
        super.onPrepareOptionsMenu(menu);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.nDR.onOptionsItemSelected(menuItem);
    }

    public String avS() {
        return SQLiteDatabase.KeyEmpty;
    }

    public View bAd() {
        return null;
    }

    public void Fd(String str) {
        this.nDR.Fd(str);
    }

    public final void NZ(String str) {
        this.nDR.NZ(str);
    }

    public void vD(int i) {
        this.nDR.vD(i);
    }

    public void NY(String str) {
        this.nDR.NY(str);
    }

    public void vE(int i) {
        this.nDR.vE(i);
    }

    public final void iS(boolean z) {
        this.nDR.iS(z);
    }

    public final void iT(boolean z) {
        this.nDR.a(true, -1, z);
    }

    public final void iU(boolean z) {
        this.nDR.b(true, -1, z);
    }

    public final void iY(boolean z) {
        this.nDR.b(false, 2, z);
    }

    public final void a(boolean z, com.tencent.mm.ui.tools.p pVar) {
        this.nDR.a(z, pVar);
    }

    public final void a(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.nDR.a(i, i2, onMenuItemClickListener);
    }

    public final void a(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        this.nDR.a(i, i2, i3, onMenuItemClickListener);
    }

    public final void vL(int i) {
        k kVar = this.nDR;
        k.a vK = kVar.vK(2);
        if (vK != null && vK.nEN != i) {
            vK.nEN = i;
            kVar.aR();
        }
    }

    public void b(OnMenuItemClickListener onMenuItemClickListener) {
        this.nDR.a(onMenuItemClickListener, 0);
    }

    public void vM(int i) {
        k kVar = this.nDR;
        kVar.nEk = i == 0;
        kVar.bAg();
    }

    public void vI(int i) {
        this.nDR.vI(i);
    }

    public boolean ale() {
        return this.nDR.ale();
    }

    public void finish() {
        super.finish();
        int intExtra = bzo().getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
        int intExtra2 = bzo().getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
        if (intExtra != -1) {
            this.nDR.nEl.overridePendingTransition(intExtra, intExtra2);
        }
    }

    public final void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    public final Resources bAp() {
        FragmentActivity aG = super.aG();
        if (aG == null) {
            return aa.getContext().getResources();
        }
        return aG.getResources();
    }

    public final FragmentActivity bzo() {
        if (this.nDR.nEl != null) {
            return this.nDR.nEl;
        }
        return super.aG();
    }

    public final Resources bAq() {
        return bzo().getResources();
    }

    public final String vN(int i) {
        return bzo().getString(i);
    }

    public final String d(int i, Object... objArr) {
        return bzo().getString(i, objArr);
    }
}

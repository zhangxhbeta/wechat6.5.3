package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.k.AnonymousClass2;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.ui.tools.p;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity extends MMFragmentActivity {
    String className;
    public boolean nDQ = false;
    public k nDR = new k(this) {
        final /* synthetic */ MMActivity nDU;

        {
            this.nDU = r1;
        }

        protected final int getLayoutId() {
            return this.nDU.getLayoutId();
        }

        protected final void bB(View view) {
            this.nDU.bB(view);
        }

        protected final String avS() {
            return this.nDU.avS();
        }

        protected final View bAd() {
            return null;
        }

        public final void aRG() {
            this.nDU.aRG();
        }

        protected final void PK() {
            this.nDU.PK();
        }

        protected final String getClassName() {
            return this.nDU.getClass().getName();
        }

        protected final boolean bzR() {
            return this.nDU.bzR();
        }

        public final boolean Sk() {
            return this.nDU.Sk();
        }

        public final boolean bkk() {
            return this.nDU.bkk();
        }
    };
    public a nDS = null;
    public boolean nDT = false;

    public interface a {
        void a(int i, int i2, Intent intent);
    }

    public abstract int getLayoutId();

    @Deprecated
    public void NI() {
    }

    public final void vA(int i) {
        k kVar = this.nDR;
        if (kVar.dtW != null) {
            if (kVar.nEa == null) {
                kVar.nEa = (FrameLayout) kVar.dtW.findViewById(2131758195);
            }
            kVar.nEa.setBackgroundResource(i);
            kVar.nDX.setBackgroundResource(i);
        }
    }

    public static Locale ed(Context context) {
        return k.ed(context);
    }

    public void PK() {
    }

    public boolean bzR() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (aYi()) {
            this.nDR.a(getBaseContext(), (ActionBarActivity) this);
            v.i("MicroMsg.MMActivity", "checktask onCreate:%s#0x%x, taskid:%d, task:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), be.ea(this));
            bAr();
            return;
        }
        v.e("MicroMsg.MMActivity", "can not init activity");
    }

    public boolean aYi() {
        return true;
    }

    public void bB(View view) {
        setContentView(view);
    }

    public boolean Sk() {
        return false;
    }

    public void aRG() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final void ca(boolean z) {
        this.nDR.ca(z);
    }

    public void oa(int i) {
        this.nDR.dtW.setVisibility(i);
        if (i == 0) {
            bzZ();
        } else {
            this.nDR.bAj();
        }
    }

    public void Rj() {
        if (!bkj()) {
            this.nDR.bAf();
        }
        super.Rj();
    }

    public boolean bkj() {
        return false;
    }

    public int NO() {
        return -1;
    }

    public void Se() {
        if (NO() == -1) {
            this.nDQ = getSharedPreferences(aa.bti(), 0).getBoolean("settings_landscape_mode", false);
            if (this.nDQ) {
                setRequestedOrientation(-1);
                return;
            } else {
                setRequestedOrientation(1);
                return;
            }
        }
        setRequestedOrientation(NO());
    }

    public void onStart() {
        Se();
        super.onStart();
    }

    @TargetApi(17)
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (!this.nDR.onKeyUp(i, keyEvent)) {
            try {
                z = super.onKeyUp(i, keyEvent);
            } catch (Throwable e) {
                v.a("MicroMsg.MMActivity", e, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
            }
        }
        return z;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.nDR.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean bkk() {
        return true;
    }

    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        v.ar(1, this.className);
        super.onResume();
        v.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.nDR.onResume();
        v.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(hashCode()));
    }

    public final void a(Dialog dialog) {
        k kVar = this.nDR;
        if (dialog != null) {
            if (kVar.nEq == null) {
                kVar.nEq = new ArrayList();
            }
            kVar.nEq.add(dialog);
        }
    }

    public final ActionBarActivity bzS() {
        return this.nDR.nEl;
    }

    public void onDestroy() {
        v.i("MicroMsg.MMActivity", "checktask onDestroy:%s#0x%x task:%s ", getClass().getSimpleName(), Integer.valueOf(hashCode()), be.ea(this));
        super.onDestroy();
        com.tencent.mm.sdk.platformtools.a.cu(this.nDR.dtW);
        com.tencent.mm.sdk.platformtools.a.dC(this.nDR.nEl);
        this.nDR.onDestroy();
        this.nDT = true;
    }

    public static void bzT() {
        k.bzT();
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        v.ar(2, this.className);
        super.onPause();
        this.nDR.onPause();
        boolean isFinishing = isFinishing();
        v.v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(isFinishing), Integer.valueOf(hashCode()));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.nDR.onCreateOptionsMenu(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.nDR.onPrepareOptionsMenu(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.nDR.onOptionsItemSelected(menuItem);
    }

    public String avS() {
        return SQLiteDatabase.KeyEmpty;
    }

    public final void iR(boolean z) {
        this.nDR.iR(z);
    }

    public final void vB(int i) {
        k kVar = this.nDR;
        if (kVar.FG == null) {
            return;
        }
        if (i == 0) {
            kVar.FG.show();
            if (VERSION.SDK_INT >= 21) {
                kVar.nEl.getWindow().setStatusBarColor(kVar.nEl.getResources().getColor(2131690051));
                return;
            }
            return;
        }
        kVar.FG.hide();
        if (VERSION.SDK_INT >= 21) {
            kVar.nEl.getWindow().setStatusBarColor(kVar.nEl.getResources().getColor(2131689547));
        }
    }

    public final void vC(int i) {
        k kVar = this.nDR;
        if (kVar.FG != null) {
            kVar.nEs.setTextColor(i);
        }
    }

    public void Fd(String str) {
        this.nDR.Fd(str);
    }

    public final void H(CharSequence charSequence) {
        this.nDR.H(charSequence);
    }

    public final void vD(int i) {
        this.nDR.vD(i);
    }

    public final void NY(String str) {
        this.nDR.NY(str);
    }

    public final void vE(int i) {
        this.nDR.vE(i);
    }

    public final void vF(int i) {
        this.nDR.nEs.setVisibility(i);
    }

    public final void vG(int i) {
        k kVar = this.nDR;
        if (kVar.FG != null) {
            kVar.nEd = 0;
            kVar.nEf = null;
            if (i == 0) {
                kVar.nEe = 0;
                kVar.nEg = null;
            } else if (kVar.nEe != i) {
                kVar.nEe = i;
                kVar.nEg = kVar.dc(kVar.mContext.getResources().getDimensionPixelSize(2131492967), kVar.nEe);
            }
            kVar.bAg();
        }
    }

    public final void bzU() {
        k kVar = this.nDR;
        if (kVar.nEr != null) {
            kVar.nEr.setVisibility(8);
        }
    }

    public final void bzV() {
        k kVar = this.nDR;
        if (kVar.FG != null) {
            kVar.FG.setDisplayHomeAsUpEnabled(false);
            if (kVar.nEt != null && kVar.nEv != null) {
                kVar.nEt.setVisibility(8);
                kVar.nEv.setVisibility(0);
            }
        }
    }

    public final void iS(boolean z) {
        this.nDR.iS(z);
    }

    public final void iT(boolean z) {
        this.nDR.a(true, -1, z);
    }

    public final void U(int i, boolean z) {
        this.nDR.a(false, i, z);
    }

    public final void iU(boolean z) {
        this.nDR.b(true, -1, z);
    }

    public final void V(int i, boolean z) {
        this.nDR.b(false, i, z);
    }

    public final boolean bzW() {
        Iterator it = this.nDR.nEo.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.k.a aVar = (com.tencent.mm.ui.k.a) it.next();
            if (aVar.nEM == 0) {
                return aVar.aZw;
            }
        }
        return false;
    }

    public final boolean bzX() {
        Iterator it = this.nDR.nEo.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.k.a aVar = (com.tencent.mm.ui.k.a) it.next();
            if (aVar.nEM == 0) {
                return aVar.visible;
            }
        }
        return false;
    }

    public final void a(p pVar) {
        this.nDR.a(true, pVar);
    }

    public void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.nDR.a(i, 0, str, onMenuItemClickListener, null, b.nES);
    }

    public final void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener, int i2) {
        this.nDR.a(i, str, onMenuItemClickListener, null, i2);
    }

    public final void a(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.nDR.a(i, i2, onMenuItemClickListener);
    }

    public final void a(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        this.nDR.a(i, i2, i3, onMenuItemClickListener);
    }

    public final void aq(int i, String str) {
        k kVar = this.nDR;
        com.tencent.mm.ui.k.a vK = kVar.vK(i);
        if (vK != null && !be.ah(str, SQLiteDatabase.KeyEmpty).equals(vK.text)) {
            vK.text = str;
            kVar.aR();
        }
    }

    public final void a(OnMenuItemClickListener onMenuItemClickListener) {
        com.tencent.mm.ui.k.a vK = this.nDR.vK(1);
        if (vK != null) {
            vK.iuP = onMenuItemClickListener;
            vK.fRk = null;
        }
    }

    public final void P(Runnable runnable) {
        k kVar = this.nDR;
        if (kVar.FG != null) {
            kVar.FG.getCustomView().setOnClickListener(new AnonymousClass2(kVar, runnable));
        }
    }

    public void b(OnMenuItemClickListener onMenuItemClickListener) {
        this.nDR.a(onMenuItemClickListener, 0);
    }

    public final void a(OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.nDR.a(onMenuItemClickListener, i);
    }

    public final void iV(boolean z) {
        k kVar = this.nDR;
        if (kVar.nEu == null) {
            return;
        }
        if (z) {
            kVar.nEu.setVisibility(0);
        } else {
            kVar.nEu.setVisibility(8);
        }
    }

    public final boolean vH(int i) {
        return this.nDR.vH(i);
    }

    public final CharSequence bzY() {
        k kVar = this.nDR;
        if (kVar.FG == null) {
            return null;
        }
        return kVar.nEc != null ? kVar.nEc : kVar.FG.getTitle();
    }

    public final void bzZ() {
        boolean z = true;
        k kVar = this.nDR;
        String str = "MicroMsg.MMActivity";
        String str2 = "showTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (kVar.FG == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.v(str, str2, objArr);
        if (kVar.FG != null) {
            kVar.FG.show();
        }
    }

    public final boolean bAa() {
        boolean z = true;
        k kVar = this.nDR;
        String str = "MicroMsg.MMActivity";
        String str2 = "isTitleShowing hasTitle:%b";
        Object[] objArr = new Object[1];
        if (kVar.FG == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.v(str, str2, objArr);
        return kVar.FG == null ? false : kVar.FG.isShowing();
    }

    public final void vI(int i) {
        this.nDR.vI(i);
    }

    public void axg() {
        this.nDR.ale();
    }

    public final void cx(View view) {
        this.nDR.cw(view);
    }

    public void aJs() {
        this.nDR.aJs();
    }

    public static void J(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }

    public void finish() {
        super.finish();
        int a = r.a(getIntent(), "MMActivity.OverrideEnterAnimation", -1);
        int a2 = r.a(getIntent(), "MMActivity.OverrideExitAnimation", -1);
        if (a != -1) {
            super.overridePendingTransition(a, a2);
        }
    }

    public final void q(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void a(Class<?> cls, Intent intent) {
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void a(a aVar, Intent intent, int i) {
        this.nDS = aVar;
        startActivityForResult(intent, i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.nDS != null) {
            this.nDS.a(i, i2, intent);
        }
        this.nDS = null;
    }

    public final void bAb() {
        k kVar = this.nDR;
        kVar.nEv.setVisibility(0);
        kVar.nEu.setVisibility(8);
        kVar.nEt.setVisibility(8);
    }

    public final void bAc() {
        k kVar = this.nDR;
        if (kVar.mContext != null) {
            kVar.W(kVar.nEl);
        }
    }
}

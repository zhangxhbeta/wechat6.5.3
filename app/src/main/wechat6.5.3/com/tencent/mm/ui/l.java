package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.view.f;
import android.support.v7.view.g;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.b.b.a;

public final class l extends k implements a {
    private ActionBar FG;
    public p nFo = null;
    public b nFp;

    public final ActionMode startActionMode(Callback callback) {
        com.tencent.mm.ui.b.a aVar = this.nFp;
        Object aVar2 = new f.a(aVar.pP, callback);
        if (aVar.FY != null) {
            aVar.FY.finish();
        }
        android.support.v7.view.b.a aVar3 = new a(aVar, aVar2);
        ActionBar cV = aVar.cV();
        if (cV != null) {
            aVar.FY = cV.a(aVar3);
        }
        android.support.v7.view.b bVar = aVar.FY;
        return bVar != null ? aVar2.b(bVar) : null;
    }

    protected final int getLayoutId() {
        if (this.nFo != null) {
            return this.nFo.getLayoutId();
        }
        return -1;
    }

    protected final void bB(View view) {
        if (this.nFo != null) {
            this.nFo.bB(view);
        }
    }

    protected final String avS() {
        if (this.nFo != null) {
            return this.nFo.avS();
        }
        return null;
    }

    protected final View bAd() {
        if (this.nFo != null) {
            return this.nFo.bAd();
        }
        return null;
    }

    public final void aRG() {
        if (this.nFo != null) {
            this.nFo.aRG();
        }
    }

    protected final void PK() {
        if (this.nFo != null) {
            p.PK();
        }
    }

    protected final String getClassName() {
        return this.nFo.getClass().getName();
    }

    protected final boolean bzR() {
        return false;
    }

    public final ActionBar cV() {
        if (this.FG == null) {
            this.FG = this.nFp.bBv();
        }
        return this.FG;
    }

    public final boolean bAh() {
        return true;
    }

    public final void aR() {
        this.nFp.aR();
    }

    public final boolean c(Menu menu) {
        if (this.nFo != null) {
            this.nFo.onPrepareOptionsMenu(menu);
        }
        return true;
    }

    public final boolean d(Menu menu) {
        p pVar = this.nFo;
        com.tencent.mm.ui.b.a aVar = this.nFp;
        if (aVar.iO == null) {
            ActionBar cV = aVar.cV();
            if (cV != null) {
                aVar.iO = new g(cV.getThemedContext());
            } else {
                aVar.iO = new g(aVar.pP);
            }
        }
        pVar.onCreateOptionsMenu(menu, aVar.iO);
        return true;
    }

    public final boolean h(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }
}

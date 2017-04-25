package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.f;
import android.support.v7.widget.u;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public final class b extends a implements android.support.v7.view.menu.f.a, android.support.v7.view.menu.l.a {
    public ViewGroup Ek;
    private boolean Gd;
    private f dV;
    a nPj;
    boolean nPk;
    private final Runnable nPl = new Runnable(this) {
        final /* synthetic */ b nPm;

        {
            this.nPm = r1;
        }

        public final void run() {
            android.support.v7.view.menu.f.a aVar = this.nPm;
            Context context = aVar.pP;
            ActionBar cV = aVar.cV();
            if (cV != null) {
                context = cV.getThemedContext();
            }
            f fVar = new f(context);
            fVar.a(aVar);
            if (this.nPm.nPj != null) {
                this.nPm.nPj.d(fVar);
                this.nPm.nPj.c(fVar);
                b.a(this.nPm, fVar);
            } else {
                b.a(this.nPm, null);
            }
            fVar.h(true);
            this.nPm.nPk = false;
        }
    };

    public interface a {
        boolean c(Menu menu);

        boolean d(Menu menu);

        boolean h(MenuItem menuItem);
    }

    static /* synthetic */ void a(b bVar, f fVar) {
        if (fVar != bVar.dV) {
            bVar.dV = fVar;
            if (bVar.FG != null) {
                ((d) bVar.FG).GR.a((Menu) fVar, (android.support.v7.view.menu.l.a) bVar);
            }
        }
    }

    public b(Activity activity, a aVar) {
        super(activity);
        this.nPj = aVar;
    }

    public final ActionBar bBv() {
        if (!this.Gd) {
            this.Gd = true;
            aR();
        }
        if (this.FG == null) {
            this.FG = new d(this.pP, this.Ek);
        }
        return this.FG;
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        if (this.nPj != null) {
            return this.nPj.h(menuItem);
        }
        return false;
    }

    public final void b(f fVar) {
        if (this.FG != null) {
            u uVar = ((d) this.FG).GR;
            if (uVar != null && uVar.dY()) {
                if (uVar.isOverflowMenuShowing()) {
                    uVar.hideOverflowMenu();
                    return;
                } else if (uVar.getVisibility() == 0) {
                    uVar.showOverflowMenu();
                    return;
                } else {
                    return;
                }
            }
        }
        fVar.close();
    }

    public final void a(f fVar, boolean z) {
    }

    public final boolean d(f fVar) {
        return false;
    }

    public final void aR() {
        if (!this.nPk) {
            this.nPk = true;
            this.nPl.run();
        }
    }
}

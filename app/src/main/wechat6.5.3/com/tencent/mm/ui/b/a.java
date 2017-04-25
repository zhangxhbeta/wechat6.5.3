package com.tencent.mm.ui.b;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public abstract class a {
    public ActionBar FG;
    public b FY = null;
    public MenuInflater iO;
    public final Activity pP;

    class a implements android.support.v7.view.b.a {
        private android.support.v7.view.b.a Gt;
        final /* synthetic */ a nPi;

        public a(a aVar, android.support.v7.view.b.a aVar2) {
            this.nPi = aVar;
            this.Gt = aVar2;
        }

        public final boolean a(b bVar, Menu menu) {
            return this.Gt.a(bVar, menu);
        }

        public final boolean b(b bVar, Menu menu) {
            return this.Gt.b(bVar, menu);
        }

        public final boolean a(b bVar, MenuItem menuItem) {
            return this.Gt.a(bVar, menuItem);
        }

        public final void a(b bVar) {
            this.Gt.a(bVar);
            this.nPi.FY = null;
        }
    }

    abstract ActionBar bBv();

    public a(Activity activity) {
        this.pP = activity;
    }

    public final ActionBar cV() {
        if (this.FG == null) {
            this.FG = bBv();
        }
        return this.FG;
    }
}

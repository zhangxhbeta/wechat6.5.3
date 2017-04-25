package android.support.v7.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.support.v7.view.menu.f;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class e extends d {
    final Window Eo;
    final Callback FD = this.Eo.getCallback();
    final Callback FE;
    final c FF;
    ActionBar FG;
    boolean FH;
    boolean FI;
    boolean FJ;
    boolean FK;
    boolean FL;
    boolean FM;
    MenuInflater iO;
    final Context mContext;
    CharSequence up;

    class a extends i {
        final /* synthetic */ e FN;

        a(e eVar, Callback callback) {
            this.FN = eVar;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.FN.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.FN.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof f)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            f fVar;
            if (menu instanceof f) {
                fVar = (f) menu;
            } else {
                fVar = null;
            }
            if (i == 0 && fVar == null) {
                return false;
            }
            if (fVar != null) {
                fVar.PP = true;
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (fVar == null) {
                return onPreparePanel;
            }
            fVar.PP = false;
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.FN.as(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.FN.ar(i);
        }
    }

    abstract void ar(int i);

    abstract boolean as(int i);

    abstract void cZ();

    abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    abstract void f(CharSequence charSequence);

    abstract boolean onKeyShortcut(int i, KeyEvent keyEvent);

    e(Context context, Window window, c cVar) {
        this.mContext = context;
        this.Eo = window;
        this.FF = cVar;
        if (this.FD instanceof a) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.FE = a(this.FD);
        this.Eo.setCallback(this.FE);
    }

    Callback a(Callback callback) {
        return new a(this, callback);
    }

    public final ActionBar cV() {
        cZ();
        return this.FG;
    }

    public final MenuInflater getMenuInflater() {
        if (this.iO == null) {
            cZ();
            this.iO = new g(this.FG != null ? this.FG.getThemedContext() : this.mContext);
        }
        return this.iO;
    }

    final Context da() {
        Context context = null;
        ActionBar cV = cV();
        if (cV != null) {
            context = cV.getThemedContext();
        }
        if (context == null) {
            return this.mContext;
        }
        return context;
    }

    public void onDestroy() {
        this.FM = true;
    }

    public boolean cY() {
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.up = charSequence;
        f(charSequence);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }
}

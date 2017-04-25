package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class e extends b implements a {
    private b.a HM;
    private WeakReference<View> HN;
    private ActionBarContextView Hp;
    private boolean NJ;
    private f dV;
    private Context mContext;
    private boolean mFinished;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.mContext = context;
        this.Hp = actionBarContextView;
        this.HM = aVar;
        f fVar = new f(actionBarContextView.getContext());
        this.dV = fVar;
        this.dV.a((a) this);
        this.NJ = z;
    }

    public final void setTitle(CharSequence charSequence) {
        this.Hp.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.Hp.setSubtitle(charSequence);
    }

    public final void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public final void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    public final void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.Hp.K(z);
    }

    public final boolean isTitleOptional() {
        return this.Hp.Rc;
    }

    public final void setCustomView(View view) {
        this.Hp.setCustomView(view);
        this.HN = view != null ? new WeakReference(view) : null;
    }

    public final void invalidate() {
        this.HM.b(this, this.dV);
    }

    public final void finish() {
        if (!this.mFinished) {
            this.mFinished = true;
            this.Hp.sendAccessibilityEvent(32);
            this.HM.a(this);
        }
    }

    public final Menu getMenu() {
        return this.dV;
    }

    public final CharSequence getTitle() {
        return this.Hp.up;
    }

    public final CharSequence getSubtitle() {
        return this.Hp.uq;
    }

    public final View getCustomView() {
        return this.HN != null ? (View) this.HN.get() : null;
    }

    public final MenuInflater getMenuInflater() {
        return new MenuInflater(this.Hp.getContext());
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        return this.HM.a((b) this, menuItem);
    }

    public final void b(f fVar) {
        invalidate();
        this.Hp.showOverflowMenu();
    }
}

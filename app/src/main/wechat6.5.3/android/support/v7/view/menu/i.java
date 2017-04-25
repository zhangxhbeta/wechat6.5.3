package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.l.e;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
public class i extends c<android.support.v4.c.a.b> implements MenuItem {
    public Method Qg;

    class a extends android.support.v4.view.d {
        final ActionProvider Qh;
        final /* synthetic */ i Qi;

        public a(i iVar, Context context, ActionProvider actionProvider) {
            this.Qi = iVar;
            super(context);
            this.Qh = actionProvider;
        }

        public final View onCreateActionView() {
            return this.Qh.onCreateActionView();
        }

        public final boolean onPerformDefaultAction() {
            return this.Qh.onPerformDefaultAction();
        }

        public final boolean hasSubMenu() {
            return this.Qh.hasSubMenu();
        }

        public final void onPrepareSubMenu(SubMenu subMenu) {
            this.Qh.onPrepareSubMenu(this.Qi.a(subMenu));
        }
    }

    static class b extends FrameLayout implements android.support.v7.view.c {
        final CollapsibleActionView Qj;

        b(View view) {
            super(view.getContext());
            this.Qj = (CollapsibleActionView) view;
            addView(view);
        }

        public final void onActionViewExpanded() {
            this.Qj.onActionViewExpanded();
        }

        public final void onActionViewCollapsed() {
            this.Qj.onActionViewCollapsed();
        }
    }

    private class c extends d<OnActionExpandListener> implements e {
        final /* synthetic */ i Qi;

        c(i iVar, OnActionExpandListener onActionExpandListener) {
            this.Qi = iVar;
            super(onActionExpandListener);
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.Pe).onMenuItemActionExpand(this.Qi.f(menuItem));
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.Pe).onMenuItemActionCollapse(this.Qi.f(menuItem));
        }
    }

    private class d extends d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ i Qi;

        d(i iVar, OnMenuItemClickListener onMenuItemClickListener) {
            this.Qi = iVar;
            super(onMenuItemClickListener);
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.Pe).onMenuItemClick(this.Qi.f(menuItem));
        }
    }

    i(Context context, android.support.v4.c.a.b bVar) {
        super(context, bVar);
    }

    public int getItemId() {
        return ((android.support.v4.c.a.b) this.Pe).getItemId();
    }

    public int getGroupId() {
        return ((android.support.v4.c.a.b) this.Pe).getGroupId();
    }

    public int getOrder() {
        return ((android.support.v4.c.a.b) this.Pe).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((android.support.v4.c.a.b) this.Pe).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((android.support.v4.c.a.b) this.Pe).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((android.support.v4.c.a.b) this.Pe).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((android.support.v4.c.a.b) this.Pe).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((android.support.v4.c.a.b) this.Pe).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((android.support.v4.c.a.b) this.Pe).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((android.support.v4.c.a.b) this.Pe).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((android.support.v4.c.a.b) this.Pe).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((android.support.v4.c.a.b) this.Pe).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((android.support.v4.c.a.b) this.Pe).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((android.support.v4.c.a.b) this.Pe).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((android.support.v4.c.a.b) this.Pe).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((android.support.v4.c.a.b) this.Pe).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((android.support.v4.c.a.b) this.Pe).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((android.support.v4.c.a.b) this.Pe).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((android.support.v4.c.a.b) this.Pe).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((android.support.v4.c.a.b) this.Pe).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((android.support.v4.c.a.b) this.Pe).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((android.support.v4.c.a.b) this.Pe).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((android.support.v4.c.a.b) this.Pe).setVisible(z);
    }

    public boolean isVisible() {
        return ((android.support.v4.c.a.b) this.Pe).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((android.support.v4.c.a.b) this.Pe).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((android.support.v4.c.a.b) this.Pe).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((android.support.v4.c.a.b) this.Pe).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return a(((android.support.v4.c.a.b) this.Pe).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((android.support.v4.c.a.b) this.Pe).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((android.support.v4.c.a.b) this.Pe).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((android.support.v4.c.a.b) this.Pe).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((android.support.v4.c.a.b) this.Pe).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((android.support.v4.c.a.b) this.Pe).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((android.support.v4.c.a.b) this.Pe).setActionView(i);
        View actionView = ((android.support.v4.c.a.b) this.Pe).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((android.support.v4.c.a.b) this.Pe).setActionView(new b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((android.support.v4.c.a.b) this.Pe).getActionView();
        if (actionView instanceof b) {
            return (View) ((b) actionView).Qj;
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((android.support.v4.c.a.b) this.Pe).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        android.support.v4.view.d bx = ((android.support.v4.c.a.b) this.Pe).bx();
        if (bx instanceof a) {
            return ((a) bx).Qh;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((android.support.v4.c.a.b) this.Pe).expandActionView();
    }

    public boolean collapseActionView() {
        return ((android.support.v4.c.a.b) this.Pe).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((android.support.v4.c.a.b) this.Pe).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((android.support.v4.c.a.b) this.Pe).a(onActionExpandListener != null ? new c(this, onActionExpandListener) : null);
        return this;
    }

    a a(ActionProvider actionProvider) {
        return new a(this, this.mContext, actionProvider);
    }
}

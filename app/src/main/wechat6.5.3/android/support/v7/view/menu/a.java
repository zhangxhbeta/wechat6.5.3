package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.b;
import android.support.v4.view.d;
import android.support.v4.view.l.e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class a implements b {
    private final int OD;
    private final int OE;
    private final int OF;
    private CharSequence OG;
    private Intent OH;
    private char OI;
    private char OJ;
    private Drawable OK;
    private int OL = 0;
    private OnMenuItemClickListener OM;
    private final int dW;
    private Context mContext;
    private int tM = 16;
    private CharSequence up;

    public final /* synthetic */ MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public a(Context context, CharSequence charSequence) {
        this.mContext = context;
        this.dW = 16908332;
        this.OD = 0;
        this.OE = 0;
        this.OF = 0;
        this.up = charSequence;
    }

    public final char getAlphabeticShortcut() {
        return this.OJ;
    }

    public final int getGroupId() {
        return this.OD;
    }

    public final Drawable getIcon() {
        return this.OK;
    }

    public final Intent getIntent() {
        return this.OH;
    }

    public final int getItemId() {
        return this.dW;
    }

    public final ContextMenuInfo getMenuInfo() {
        return null;
    }

    public final char getNumericShortcut() {
        return this.OI;
    }

    public final int getOrder() {
        return this.OF;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final CharSequence getTitle() {
        return this.up;
    }

    public final CharSequence getTitleCondensed() {
        return this.OG != null ? this.OG : this.up;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final boolean isCheckable() {
        return (this.tM & 1) != 0;
    }

    public final boolean isChecked() {
        return (this.tM & 2) != 0;
    }

    public final boolean isEnabled() {
        return (this.tM & 16) != 0;
    }

    public final boolean isVisible() {
        return (this.tM & 8) == 0;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        this.OJ = c;
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        this.tM = (z ? 1 : 0) | (this.tM & -2);
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        this.tM = (z ? 2 : 0) | (this.tM & -3);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        this.tM = (z ? 16 : 0) | (this.tM & -17);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.OK = drawable;
        this.OL = 0;
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.OL = i;
        this.OK = android.support.v4.content.a.a(this.mContext, i);
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.OH = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        this.OI = c;
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.OM = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.OI = c;
        this.OJ = c2;
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.up = charSequence;
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.up = this.mContext.getResources().getString(i);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.OG = charSequence;
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        this.tM = (z ? 0 : 8) | (this.tM & 8);
        return this;
    }

    public final void setShowAsAction(int i) {
    }

    public final View getActionView() {
        return null;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public final d bx() {
        return null;
    }

    public final b a(d dVar) {
        throw new UnsupportedOperationException();
    }

    public final boolean expandActionView() {
        return false;
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public final b a(e eVar) {
        return this;
    }
}

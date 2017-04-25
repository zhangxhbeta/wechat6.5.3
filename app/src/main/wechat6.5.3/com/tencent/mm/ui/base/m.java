package com.tencent.mm.ui.base;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.tencent.mm.sdk.platformtools.aa;

public final class m implements MenuItem {
    private int NW;
    private int Od;
    public String guw;
    private int iconId;
    public boolean mVW = false;
    public CharSequence nWG = null;
    private int nWH;
    private Drawable nWI;
    public ContextMenuInfo nWJ;
    private OnMenuItemClickListener nWK;
    private CharSequence title;

    public m(int i, int i2) {
        this.Od = i;
        this.NW = i2;
    }

    public final int getItemId() {
        return this.Od;
    }

    public final int getGroupId() {
        return this.NW;
    }

    public final int getOrder() {
        return 0;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.title = charSequence;
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.nWH = i;
        return this;
    }

    public final CharSequence getTitle() {
        if (this.title != null) {
            return this.title;
        }
        if (this.nWH != 0) {
            return aa.getContext().getString(this.nWH);
        }
        return null;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        return this;
    }

    public final CharSequence getTitleCondensed() {
        return null;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.nWI = drawable;
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.iconId = i;
        return this;
    }

    public final Drawable getIcon() {
        if (this.nWI != null) {
            return this.nWI;
        }
        if (this.iconId != 0) {
            return aa.getContext().getResources().getDrawable(this.iconId);
        }
        return null;
    }

    public final MenuItem setIntent(Intent intent) {
        return this;
    }

    public final Intent getIntent() {
        return null;
    }

    public final MenuItem setShortcut(char c, char c2) {
        return this;
    }

    public final MenuItem setNumericShortcut(char c) {
        return this;
    }

    public final char getNumericShortcut() {
        return '\u0000';
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        return this;
    }

    public final char getAlphabeticShortcut() {
        return '\u0000';
    }

    public final MenuItem setCheckable(boolean z) {
        return this;
    }

    public final boolean isCheckable() {
        return false;
    }

    public final MenuItem setChecked(boolean z) {
        return this;
    }

    public final boolean isChecked() {
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        return this;
    }

    public final boolean isVisible() {
        return true;
    }

    public final MenuItem setEnabled(boolean z) {
        return this;
    }

    public final boolean isEnabled() {
        return true;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.nWK = onMenuItemClickListener;
        return this;
    }

    public final boolean performClick() {
        if (this.nWK != null) {
            return this.nWK.onMenuItemClick(this);
        }
        return false;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.nWJ;
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final boolean expandActionView() {
        return false;
    }

    public final ActionProvider getActionProvider() {
        return null;
    }

    public final View getActionView() {
        return null;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        return null;
    }

    public final MenuItem setActionView(View view) {
        return null;
    }

    public final MenuItem setActionView(int i) {
        return null;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        return null;
    }

    public final void setShowAsAction(int i) {
    }

    public final MenuItem setShowAsActionFlags(int i) {
        return null;
    }
}

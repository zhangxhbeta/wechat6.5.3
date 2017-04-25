package com.tencent.mm.ui.base;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.ArrayList;
import java.util.List;

public final class l implements ContextMenu {
    public CharSequence PF;
    public List<MenuItem> nWF = new ArrayList();

    public final boolean bCl() {
        return this.nWF.size() == 0;
    }

    public final MenuItem add(int i, int i2, int i3, int i4) {
        MenuItem mVar = new m(i2, i);
        mVar.setTitle(i4);
        this.nWF.add(mVar);
        return mVar;
    }

    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        MenuItem mVar = new m(i2, i);
        mVar.setTitle(charSequence);
        this.nWF.add(mVar);
        return mVar;
    }

    public final MenuItem add(int i) {
        MenuItem mVar = new m(0, 0);
        mVar.setTitle(i);
        this.nWF.add(mVar);
        return mVar;
    }

    public final MenuItem add(CharSequence charSequence) {
        MenuItem mVar = new m(0, 0);
        mVar.setTitle(charSequence);
        this.nWF.add(mVar);
        return mVar;
    }

    public final MenuItem S(int i, int i2, int i3) {
        MenuItem mVar = new m(i, 0);
        mVar.setTitle(i2);
        mVar.setIcon(i3);
        this.nWF.add(mVar);
        return mVar;
    }

    public final MenuItem dg(int i, int i2) {
        MenuItem mVar = new m(i, 0);
        mVar.setTitle(i2);
        this.nWF.add(mVar);
        return mVar;
    }

    public final MenuItem d(int i, CharSequence charSequence) {
        MenuItem mVar = new m(i, 0);
        mVar.setTitle(charSequence);
        this.nWF.add(mVar);
        return mVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, int i2) {
        MenuItem mVar = new m(i, 0);
        mVar.setTitle(charSequence);
        mVar.setIcon(i2);
        this.nWF.add(mVar);
        return mVar;
    }

    public final MenuItem a(int i, int i2, CharSequence charSequence) {
        MenuItem mVar = new m(i, 0);
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i2), 0, spannableString.length(), 0);
        mVar.setTitle(spannableString);
        this.nWF.add(mVar);
        return mVar;
    }

    public final SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    public final SubMenu addSubMenu(int i) {
        return null;
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return null;
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return null;
    }

    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return 0;
    }

    public final void removeItem(int i) {
    }

    public final void removeGroup(int i) {
    }

    public final void clear() {
        for (MenuItem menuItem : this.nWF) {
            ((m) menuItem).nWJ = null;
            ((m) menuItem).setOnMenuItemClickListener(null);
        }
        this.nWF.clear();
        this.PF = null;
    }

    public final void setGroupCheckable(int i, boolean z, boolean z2) {
    }

    public final void setGroupVisible(int i, boolean z) {
    }

    public final void setGroupEnabled(int i, boolean z) {
    }

    public final boolean hasVisibleItems() {
        return false;
    }

    public final MenuItem findItem(int i) {
        for (MenuItem menuItem : this.nWF) {
            if (menuItem.getItemId() == i) {
                return menuItem;
            }
        }
        return null;
    }

    public final int size() {
        return this.nWF == null ? 0 : this.nWF.size();
    }

    public final MenuItem getItem(int i) {
        return (MenuItem) this.nWF.get(i);
    }

    public final void close() {
    }

    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return false;
    }

    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return false;
    }

    public final boolean performIdentifierAction(int i, int i2) {
        return false;
    }

    public final void setQwertyMode(boolean z) {
    }

    public final ContextMenu setHeaderTitle(int i) {
        if (i > 0) {
            return setHeaderTitle(aa.getContext().getString(i));
        }
        return this;
    }

    public final ContextMenu setHeaderTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.PF = charSequence;
        }
        return this;
    }

    public final ContextMenu setHeaderIcon(int i) {
        return this;
    }

    public final ContextMenu setHeaderIcon(Drawable drawable) {
        return this;
    }

    public final ContextMenu setHeaderView(View view) {
        return this;
    }

    public final void clearHeader() {
    }
}

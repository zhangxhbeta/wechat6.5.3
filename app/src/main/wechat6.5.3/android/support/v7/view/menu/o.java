package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.c.a.a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;

class o extends c<a> implements Menu {
    o(Context context, a aVar) {
        super(context, aVar);
    }

    public MenuItem add(CharSequence charSequence) {
        return f(((a) this.Pe).add(charSequence));
    }

    public MenuItem add(int i) {
        return f(((a) this.Pe).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return f(((a) this.Pe).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return f(((a) this.Pe).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((a) this.Pe).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return a(((a) this.Pe).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(((a) this.Pe).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(((a) this.Pe).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((a) this.Pe).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = f(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        if (this.Pc != null) {
            Iterator it = this.Pc.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    break;
                }
            }
        }
        ((a) this.Pe).removeItem(i);
    }

    public void removeGroup(int i) {
        if (this.Pc != null) {
            Iterator it = this.Pc.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
        ((a) this.Pe).removeGroup(i);
    }

    public void clear() {
        if (this.Pc != null) {
            this.Pc.clear();
        }
        if (this.Pd != null) {
            this.Pd.clear();
        }
        ((a) this.Pe).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((a) this.Pe).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((a) this.Pe).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((a) this.Pe).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((a) this.Pe).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return f(((a) this.Pe).findItem(i));
    }

    public int size() {
        return ((a) this.Pe).size();
    }

    public MenuItem getItem(int i) {
        return f(((a) this.Pe).getItem(i));
    }

    public void close() {
        ((a) this.Pe).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((a) this.Pe).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((a) this.Pe).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((a) this.Pe).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((a) this.Pe).setQwertyMode(z);
    }
}

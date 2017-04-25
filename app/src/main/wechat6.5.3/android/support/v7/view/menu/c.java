package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.c.a.b;
import android.support.v4.e.a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

abstract class c<T> extends d<T> {
    Map<b, MenuItem> Pc;
    Map<android.support.v4.c.a.c, SubMenu> Pd;
    final Context mContext;

    c(Context context, T t) {
        super(t);
        this.mContext = context;
    }

    final MenuItem f(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.Pc == null) {
            this.Pc = new a();
        }
        MenuItem menuItem2 = (MenuItem) this.Pc.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = n.a(this.mContext, bVar);
        this.Pc.put(bVar, menuItem2);
        return menuItem2;
    }

    final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof android.support.v4.c.a.c)) {
            return subMenu;
        }
        android.support.v4.c.a.c cVar = (android.support.v4.c.a.c) subMenu;
        if (this.Pd == null) {
            this.Pd = new a();
        }
        SubMenu subMenu2 = (SubMenu) this.Pd.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        Context context = this.mContext;
        if (VERSION.SDK_INT >= 14) {
            subMenu2 = new q(context, cVar);
            this.Pd.put(cVar, subMenu2);
            return subMenu2;
        }
        throw new UnsupportedOperationException();
    }
}

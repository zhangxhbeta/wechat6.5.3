package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.view.SubMenu;

public final class a extends f {
    public a(Context context) {
        super(context);
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        h hVar = (h) a(i, i2, i3, charSequence);
        SubMenu cVar = new c(this.mContext, this, hVar);
        hVar.b(cVar);
        return cVar;
    }
}

package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.RecyclerView.e.b;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;

public abstract class aj extends e {
    boolean acd = true;

    public abstract boolean a(s sVar, int i, int i2, int i3, int i4);

    public abstract boolean a(s sVar, s sVar2, int i, int i2, int i3, int i4);

    public abstract boolean b(s sVar);

    public abstract boolean c(s sVar);

    public final boolean l(s sVar) {
        return !this.acd || sVar.gn();
    }

    public final boolean d(s sVar, b bVar, b bVar2) {
        int i = bVar.left;
        int i2 = bVar.top;
        View view = sVar.aal;
        int left = bVar2 == null ? view.getLeft() : bVar2.left;
        int top = bVar2 == null ? view.getTop() : bVar2.top;
        if (sVar.isRemoved() || (i == left && i2 == top)) {
            return b(sVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(sVar, i, i2, left, top);
    }

    public final boolean e(s sVar, b bVar, b bVar2) {
        if (bVar == null || (bVar.left == bVar2.left && bVar.top == bVar2.top)) {
            return c(sVar);
        }
        return a(sVar, bVar.left, bVar.top, bVar2.left, bVar2.top);
    }

    public final boolean f(s sVar, b bVar, b bVar2) {
        if (bVar.left == bVar2.left && bVar.top == bVar2.top) {
            k(sVar);
            return false;
        }
        return a(sVar, bVar.left, bVar.top, bVar2.left, bVar2.top);
    }

    public final boolean a(s sVar, s sVar2, b bVar, b bVar2) {
        int i;
        int i2;
        int i3 = bVar.left;
        int i4 = bVar.top;
        if (sVar2.gf()) {
            i = bVar.left;
            i2 = bVar.top;
        } else {
            i = bVar2.left;
            i2 = bVar2.top;
        }
        return a(sVar, sVar2, i3, i4, i, i2);
    }
}

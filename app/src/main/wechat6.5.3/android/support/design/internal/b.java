package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.p;
import android.support.v7.widget.RecyclerView.s;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class b implements l {
    ColorStateList dR;
    public NavigationMenuView dS;
    public LinearLayout dT;
    private android.support.v7.view.menu.l.a dU;
    android.support.v7.view.menu.f dV;
    public int dW;
    public b dX;
    public LayoutInflater dY;
    int dZ;
    boolean ea;
    ColorStateList eb;
    Drawable ec;
    public int ed;
    int ee;
    final OnClickListener mOnClickListener = new OnClickListener(this) {
        final /* synthetic */ b ef;

        {
            this.ef = r1;
        }

        public final void onClick(View view) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
            this.ef.g(true);
            MenuItem menuItem = navigationMenuItemView.dQ;
            boolean a = this.ef.dV.a(menuItem, this.ef, 0);
            if (menuItem != null && menuItem.isCheckable() && a) {
                this.ef.dX.d(menuItem);
            }
            this.ef.g(false);
            this.ef.f(false);
        }
    };

    private interface d {
    }

    private class b extends android.support.v7.widget.RecyclerView.a<j> {
        final /* synthetic */ b ef;
        final ArrayList<d> eg = new ArrayList();
        private android.support.v7.view.menu.h eh;
        private ColorDrawable ei;
        boolean ej;

        public final /* synthetic */ s a(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new g(this.ef.dY, viewGroup, this.ef.mOnClickListener);
                case 1:
                    return new i(this.ef.dY, viewGroup);
                case 2:
                    return new h(this.ef.dY, viewGroup);
                case 3:
                    return new a(this.ef.dT);
                default:
                    return null;
            }
        }

        public final /* synthetic */ void a(s sVar) {
            j jVar = (j) sVar;
            if (jVar instanceof g) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.aal;
                if (navigationMenuItemView.dP != null) {
                    navigationMenuItemView.dP.removeAllViews();
                }
                navigationMenuItemView.dO.setCompoundDrawables(null, null, null, null);
            }
        }

        public final /* synthetic */ void a(s sVar, int i) {
            j jVar = (j) sVar;
            switch (getItemViewType(i)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.aal;
                    navigationMenuItemView.dR = this.ef.dR;
                    if (navigationMenuItemView.dQ != null) {
                        navigationMenuItemView.setIcon(navigationMenuItemView.dQ.getIcon());
                    }
                    if (this.ef.ea) {
                        navigationMenuItemView.dO.setTextAppearance(navigationMenuItemView.getContext(), this.ef.dZ);
                    }
                    if (this.ef.eb != null) {
                        navigationMenuItemView.dO.setTextColor(this.ef.eb);
                    }
                    navigationMenuItemView.setBackgroundDrawable(this.ef.ec != null ? this.ef.ec.getConstantState().newDrawable() : null);
                    navigationMenuItemView.a(((f) this.eg.get(i)).em);
                    return;
                case 1:
                    ((TextView) jVar.aal).setText(((f) this.eg.get(i)).em.getTitle());
                    return;
                case 2:
                    e eVar = (e) this.eg.get(i);
                    jVar.aal.setPadding(0, eVar.ek, 0, eVar.el);
                    return;
                default:
                    return;
            }
        }

        public b(b bVar) {
            this.ef = bVar;
            F();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemCount() {
            return this.eg.size();
        }

        public final int getItemViewType(int i) {
            d dVar = (d) this.eg.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (!(dVar instanceof f)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((f) dVar).em.hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        final void F() {
            if (!this.ej) {
                this.ej = true;
                this.eg.clear();
                this.eg.add(new c());
                int i = -1;
                int i2 = 0;
                Object obj = null;
                int size = this.ef.dV.dE().size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2;
                    int i4;
                    int i5;
                    android.support.v7.view.menu.h hVar = (android.support.v7.view.menu.h) this.ef.dV.dE().get(i3);
                    if (hVar.isChecked()) {
                        d(hVar);
                    }
                    if (hVar.isCheckable()) {
                        hVar.E(false);
                    }
                    int i6;
                    if (hVar.hasSubMenu()) {
                        SubMenu subMenu = hVar.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i3 != 0) {
                                this.eg.add(new e(this.ef.ee, 0));
                            }
                            this.eg.add(new f(hVar));
                            Object obj3 = null;
                            int size2 = this.eg.size();
                            int size3 = subMenu.size();
                            for (i6 = 0; i6 < size3; i6++) {
                                android.support.v7.view.menu.h hVar2 = (android.support.v7.view.menu.h) subMenu.getItem(i6);
                                if (hVar2.isVisible()) {
                                    if (obj3 == null && hVar2.getIcon() != null) {
                                        obj3 = 1;
                                    }
                                    if (hVar2.isCheckable()) {
                                        hVar2.E(false);
                                    }
                                    if (hVar.isChecked()) {
                                        d(hVar);
                                    }
                                    this.eg.add(new f(hVar2));
                                }
                            }
                            if (obj3 != null) {
                                b(size2, this.eg.size());
                            }
                        }
                        obj2 = obj;
                        i4 = i2;
                        i5 = i;
                    } else {
                        Object obj4;
                        i6 = hVar.getGroupId();
                        if (i6 != i) {
                            i2 = this.eg.size();
                            obj = hVar.getIcon() != null ? 1 : null;
                            if (i3 != 0) {
                                i2++;
                                this.eg.add(new e(this.ef.ee, this.ef.ee));
                                obj4 = obj;
                                i5 = i2;
                            }
                            obj4 = obj;
                            i5 = i2;
                        } else {
                            if (obj == null && hVar.getIcon() != null) {
                                obj = 1;
                                b(i2, this.eg.size());
                            }
                            obj4 = obj;
                            i5 = i2;
                        }
                        if (obj4 != null && hVar.getIcon() == null) {
                            hVar.setIcon(17170445);
                        }
                        this.eg.add(new f(hVar));
                        obj2 = obj4;
                        i4 = i5;
                        i5 = i6;
                    }
                    i3++;
                    i2 = i4;
                    i = i5;
                    obj = obj2;
                }
                this.ej = false;
            }
        }

        private void b(int i, int i2) {
            while (i < i2) {
                MenuItem menuItem = ((f) this.eg.get(i)).em;
                if (menuItem.getIcon() == null) {
                    if (this.ei == null) {
                        this.ei = new ColorDrawable(0);
                    }
                    menuItem.setIcon(this.ei);
                }
                i++;
            }
        }

        public final void d(android.support.v7.view.menu.h hVar) {
            if (this.eh != hVar && hVar.isCheckable()) {
                if (this.eh != null) {
                    this.eh.setChecked(false);
                }
                this.eh = hVar;
                hVar.setChecked(true);
            }
        }

        public final Bundle G() {
            Bundle bundle = new Bundle();
            if (this.eh != null) {
                bundle.putInt("android:menu:checked", this.eh.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.eg.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar instanceof f) {
                    android.support.v7.view.menu.h hVar = ((f) dVar).em;
                    View actionView = hVar != null ? hVar.getActionView() : null;
                    if (actionView != null) {
                        SparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(hVar.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }
    }

    private static class c implements d {
        private c() {
        }
    }

    private static class e implements d {
        final int ek;
        final int el;

        public e(int i, int i2) {
            this.ek = i;
            this.el = i2;
        }
    }

    private static class f implements d {
        final android.support.v7.view.menu.h em;

        private f(android.support.v7.view.menu.h hVar) {
            this.em = hVar;
        }
    }

    private static abstract class j extends s {
        public j(View view) {
            super(view);
        }
    }

    private static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    private static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
            super(layoutInflater.inflate(android.support.design.a.f.aB, viewGroup, false));
            this.aal.setOnClickListener(onClickListener);
        }
    }

    private static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(android.support.design.a.f.aD, viewGroup, false));
        }
    }

    private static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(android.support.design.a.f.aE, viewGroup, false));
        }
    }

    public final void a(Context context, android.support.v7.view.menu.f fVar) {
        this.dY = LayoutInflater.from(context);
        this.dV = fVar;
        this.ee = context.getResources().getDimensionPixelOffset(android.support.design.a.d.al);
    }

    public final void f(boolean z) {
        if (this.dX != null) {
            android.support.v7.widget.RecyclerView.a aVar = this.dX;
            aVar.F();
            aVar.Zi.notifyChanged();
        }
    }

    public final boolean a(p pVar) {
        return false;
    }

    public final void a(android.support.v7.view.menu.f fVar, boolean z) {
        if (this.dU != null) {
            this.dU.a(fVar, z);
        }
    }

    public final boolean E() {
        return false;
    }

    public final boolean b(android.support.v7.view.menu.h hVar) {
        return false;
    }

    public final boolean c(android.support.v7.view.menu.h hVar) {
        return false;
    }

    public final int getId() {
        return this.dW;
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        if (this.dS != null) {
            SparseArray sparseArray = new SparseArray();
            this.dS.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.dX != null) {
            bundle.putBundle("android:menu:adapter", this.dX.G());
        }
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.dS.restoreHierarchyState(sparseParcelableArray);
        }
        Bundle bundle2 = bundle.getBundle("android:menu:adapter");
        if (bundle2 != null) {
            d dVar;
            b bVar = this.dX;
            int i = bundle2.getInt("android:menu:checked", 0);
            if (i != 0) {
                bVar.ej = true;
                Iterator it = bVar.eg.iterator();
                while (it.hasNext()) {
                    dVar = (d) it.next();
                    if (dVar instanceof f) {
                        android.support.v7.view.menu.h hVar = ((f) dVar).em;
                        if (hVar != null && hVar.getItemId() == i) {
                            bVar.d(hVar);
                            break;
                        }
                    }
                }
                bVar.ej = false;
                bVar.F();
            }
            SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
            Iterator it2 = bVar.eg.iterator();
            while (it2.hasNext()) {
                dVar = (d) it2.next();
                if (dVar instanceof f) {
                    android.support.v7.view.menu.h hVar2 = ((f) dVar).em;
                    View actionView = hVar2 != null ? hVar2.getActionView() : null;
                    if (actionView != null) {
                        actionView.restoreHierarchyState((SparseArray) sparseParcelableArray2.get(hVar2.getItemId()));
                    }
                }
            }
        }
    }

    public final void a(ColorStateList colorStateList) {
        this.dR = colorStateList;
        f(false);
    }

    public final void b(ColorStateList colorStateList) {
        this.eb = colorStateList;
        f(false);
    }

    public final void e(int i) {
        this.dZ = i;
        this.ea = true;
        f(false);
    }

    public final void a(Drawable drawable) {
        this.ec = drawable;
        f(false);
    }

    public final void g(boolean z) {
        if (this.dX != null) {
            this.dX.ej = z;
        }
    }
}

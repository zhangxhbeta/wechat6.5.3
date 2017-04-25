package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.f.a;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class p extends f implements SubMenu {
    public f QA;
    private h QB;

    public p(Context context, f fVar, h hVar) {
        super(context);
        this.QA = fVar;
        this.QB = hVar;
    }

    public void setQwertyMode(boolean z) {
        this.QA.setQwertyMode(z);
    }

    public final boolean dy() {
        return this.QA.dy();
    }

    public final boolean dz() {
        return this.QA.dz();
    }

    public MenuItem getItem() {
        return this.QB;
    }

    public final void a(a aVar) {
        this.QA.a(aVar);
    }

    public final f dH() {
        return this.QA;
    }

    final boolean b(f fVar, MenuItem menuItem) {
        return super.b(fVar, menuItem) || this.QA.b(fVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.QB.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.QB.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.k(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.k(android.support.v4.content.a.a(this.mContext, i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.g(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.g(this.mContext.getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(null, null, view);
        return this;
    }

    public final boolean g(h hVar) {
        return this.QA.g(hVar);
    }

    public final boolean h(h hVar) {
        return this.QA.h(hVar);
    }

    public final String dx() {
        int itemId = this.QB != null ? this.QB.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.dx() + ":" + itemId;
    }
}

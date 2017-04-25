package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.c.a.b;
import android.support.v4.e.i;
import android.support.v7.view.menu.n;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
public final class f extends ActionMode {
    final b NK;
    final Context mContext;

    public static class a implements android.support.v7.view.b.a {
        final Callback NL;
        final ArrayList<f> NM = new ArrayList();
        final i<Menu, Menu> NN = new i();
        final Context mContext;

        public a(Context context, Callback callback) {
            this.mContext = context;
            this.NL = callback;
        }

        public final boolean a(b bVar, Menu menu) {
            return this.NL.onCreateActionMode(b(bVar), b(menu));
        }

        public final boolean b(b bVar, Menu menu) {
            return this.NL.onPrepareActionMode(b(bVar), b(menu));
        }

        public final boolean a(b bVar, MenuItem menuItem) {
            return this.NL.onActionItemClicked(b(bVar), n.a(this.mContext, (b) menuItem));
        }

        public final void a(b bVar) {
            this.NL.onDestroyActionMode(b(bVar));
        }

        private Menu b(Menu menu) {
            Menu menu2 = (Menu) this.NN.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = n.a(this.mContext, (android.support.v4.c.a.a) menu);
            this.NN.put(menu, menu2);
            return menu2;
        }

        public final ActionMode b(b bVar) {
            int size = this.NM.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.NM.get(i);
                if (fVar != null && fVar.NK == bVar) {
                    return fVar;
                }
            }
            ActionMode fVar2 = new f(this.mContext, bVar);
            this.NM.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.mContext = context;
        this.NK = bVar;
    }

    public final Object getTag() {
        return this.NK.NF;
    }

    public final void setTag(Object obj) {
        this.NK.NF = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        this.NK.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.NK.setSubtitle(charSequence);
    }

    public final void invalidate() {
        this.NK.invalidate();
    }

    public final void finish() {
        this.NK.finish();
    }

    public final Menu getMenu() {
        return n.a(this.mContext, (android.support.v4.c.a.a) this.NK.getMenu());
    }

    public final CharSequence getTitle() {
        return this.NK.getTitle();
    }

    public final void setTitle(int i) {
        this.NK.setTitle(i);
    }

    public final CharSequence getSubtitle() {
        return this.NK.getSubtitle();
    }

    public final void setSubtitle(int i) {
        this.NK.setSubtitle(i);
    }

    public final View getCustomView() {
        return this.NK.getCustomView();
    }

    public final void setCustomView(View view) {
        this.NK.setCustomView(view);
    }

    public final MenuInflater getMenuInflater() {
        return this.NK.getMenuInflater();
    }

    public final boolean getTitleOptionalHint() {
        return this.NK.NG;
    }

    public final void setTitleOptionalHint(boolean z) {
        this.NK.setTitleOptionalHint(z);
    }

    public final boolean isTitleOptional() {
        return this.NK.isTitleOptional();
    }
}

package com.tencent.mm.pluginsdk.ui.b;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

public abstract class b implements a {
    public WeakReference<Context> lKT = null;
    public View view = null;

    public abstract void destroy();

    public abstract int getLayoutId();

    public b(Context context) {
        this.lKT = new WeakReference(context);
        if (getLayoutId() > 0) {
            this.view = View.inflate((Context) this.lKT.get(), getLayoutId(), null);
        }
    }

    public void setVisibility(int i) {
        if (this.view != null) {
            this.view.setVisibility(i);
        }
    }

    public final View getView() {
        return this.view;
    }

    public boolean Ui() {
        return false;
    }

    public boolean refresh() {
        return false;
    }

    public void Uj() {
    }

    public void Uk() {
    }
}

package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d implements OnScrollListener {
    private OnScrollListener lGc;
    private ArrayList<WeakReference<a>> lGd;

    public interface a {
        void onScrollStateChanged(boolean z);
    }

    public d() {
        this(null);
    }

    public d(OnScrollListener onScrollListener) {
        this.lGd = new ArrayList();
        this.lGc = onScrollListener;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lGc != null) {
            this.lGc.onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            hR(true);
        } else {
            hR(false);
        }
        if (this.lGc != null) {
            this.lGc.onScrollStateChanged(absListView, i);
        }
    }

    public final void a(a aVar) {
        this.lGd.add(new WeakReference(aVar));
    }

    private void hR(boolean z) {
        for (int i = 0; i < this.lGd.size(); i++) {
            WeakReference weakReference = (WeakReference) this.lGd.get(i);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.onScrollStateChanged(z);
                } else {
                    this.lGd.remove(i);
                }
            } else {
                this.lGd.remove(i);
            }
        }
    }
}

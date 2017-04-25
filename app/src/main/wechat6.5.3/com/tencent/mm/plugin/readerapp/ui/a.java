package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ui.j;

public abstract class a<T> extends j<T> implements OnScrollListener {
    private static final String TAG = ("MicroMsg." + a.class.getName());
    protected boolean fHM;

    public abstract int aJh();

    public abstract boolean abO();

    public abstract int abP();

    public a(Context context, T t) {
        super(context, t);
        iQ(true);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.fHM = false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}

package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public final class a extends h {
    private SparseArray<View> oce = new SparseArray();

    public a(Context context, SharedPreferences sharedPreferences) {
        super(context, sharedPreferences);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        this.oce.put(i, view2);
        return view2;
    }

    public final View a(int i, ListView listView) {
        if (i > listView.getLastVisiblePosition() || i < listView.getFirstVisiblePosition()) {
            return null;
        }
        return (View) this.oce.get(i);
    }
}

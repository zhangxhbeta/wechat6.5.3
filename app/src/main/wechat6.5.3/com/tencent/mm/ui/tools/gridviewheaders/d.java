package com.tencent.mm.ui.tools.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public final class d extends BaseAdapter implements b {
    private DataSetObserver AB = new DataSetObserver(this) {
        final /* synthetic */ d oWp;

        {
            this.oWp = r1;
        }

        public final void onChanged() {
            this.oWp.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            this.oWp.notifyDataSetInvalidated();
        }
    };
    private ListAdapter oWo;

    public d(ListAdapter listAdapter) {
        this.oWo = listAdapter;
        listAdapter.registerDataSetObserver(this.AB);
    }

    public final int getCount() {
        return this.oWo.getCount();
    }

    public final Object getItem(int i) {
        return this.oWo.getItem(i);
    }

    public final long getItemId(int i) {
        return this.oWo.getItemId(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.oWo.getView(i, view, viewGroup);
    }

    public final int yg(int i) {
        return 0;
    }

    public final int bJB() {
        return 0;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}

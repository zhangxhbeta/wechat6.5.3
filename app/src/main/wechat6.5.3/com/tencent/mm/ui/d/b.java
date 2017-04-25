package com.tencent.mm.ui.d;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.pluginsdk.m.a.a;
import com.tencent.mm.ui.j;
import java.util.ArrayList;

public final class b extends j<c> {
    private ArrayList<c> nLz = new ArrayList();
    public a nQp = null;

    public final /* bridge */ /* synthetic */ Object a(Object obj, Cursor cursor) {
        return null;
    }

    public final /* synthetic */ Object getItem(int i) {
        return vY(i);
    }

    public b(Context context) {
        super(context, null);
        Om();
    }

    protected final void Om() {
        Ol();
    }

    public final void Ol() {
        this.nLz.clear();
        if (this.nQp != null) {
            this.nLz.add(new c(this.nQp));
            notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return this.nLz.size();
    }

    public final c vY(int i) {
        return (c) this.nLz.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        c cVar = (c) this.nLz.get(i);
        if (view == null) {
            view = View.inflate(this.context, 2130903091, null);
            d dVar2 = new d();
            dVar2.nQr = view;
            dVar2.nQs = (Button) view.findViewById(2131755338);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        if (cVar.a(dVar) != 0) {
            return null;
        }
        return view;
    }
}

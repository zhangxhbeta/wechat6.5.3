package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import java.util.List;

public final class b extends BaseAdapter implements a {
    private Context context;
    boolean kgB = false;
    private List<f> kgD;

    public b(Context context, List<f> list) {
        this.context = context;
        this.kgD = list;
    }

    public final void gC(boolean z) {
        this.kgB = z;
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            cVar = new c();
            view = View.inflate(this.context, 2130903123, null);
            cVar.hEP = (ImageView) view.findViewById(2131755429);
            cVar.kgY = (TextView) view.findViewById(2131755430);
            cVar.dyN = (TextView) view.findViewById(2131755432);
            cVar.kgZ = view.findViewById(2131755431);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.kgZ.setVisibility(4);
        if (lB(i)) {
            cVar.hEP.setVisibility(4);
            cVar.kgY.setVisibility(4);
            cVar.dyN.setVisibility(4);
        } else {
            f fVar = (f) getItem(i);
            cVar.hEP.setVisibility(0);
            Bitmap b = g.b(fVar.field_appId, 5, com.tencent.mm.bd.a.getDensity(this.context));
            if (b == null) {
                cVar.hEP.setBackgroundResource(2130837663);
            } else {
                cVar.hEP.setBackgroundDrawable(new BitmapDrawable(b));
            }
            cVar.dyN.setVisibility(0);
            cVar.dyN.setText(g.a(this.context, fVar, null));
            if (this.kgB) {
                cVar.kgY.setVisibility(0);
            } else {
                cVar.kgY.setVisibility(8);
            }
        }
        return view;
    }

    public final int getCount() {
        return aij() + asv();
    }

    public final boolean lB(int i) {
        int size = this.kgD.size();
        return i >= size && i < size + asv();
    }

    public final Object getItem(int i) {
        if (lB(i)) {
            return null;
        }
        return this.kgD.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int aij() {
        return this.kgD.size();
    }

    private int asv() {
        return (4 - (aij() % 4)) % 4;
    }

    public final void a(String str, i iVar) {
        notifyDataSetChanged();
    }
}

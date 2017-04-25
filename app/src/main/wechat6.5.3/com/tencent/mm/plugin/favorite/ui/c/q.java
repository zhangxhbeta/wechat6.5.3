package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.s;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;

public final class q extends a {

    public static class a extends b {
        TextView dtY;
        ImageView eZn;
        TextView fST;
    }

    public q(g gVar) {
        super(gVar);
    }

    public final View a(View view, ViewGroup viewGroup, i iVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, 2130903601, null), aVar, iVar);
            aVar.dtY = (TextView) view.findViewById(2131755050);
            aVar.fST = (TextView) view.findViewById(2131755035);
            aVar.eZn = (ImageView) view.findViewById(2131756943);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, iVar);
        bVar.dtY.setText(context.getString(2131231178));
        bVar.fST.setText(s.v(this.fJV.context, (int) v.au((long) v.n(iVar).duration)));
        bVar.eZn.setImageResource(2131165515);
        return view;
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}

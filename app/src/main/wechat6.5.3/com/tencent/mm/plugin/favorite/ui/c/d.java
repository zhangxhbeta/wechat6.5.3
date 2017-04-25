package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;

public final class d extends a {
    private static int fSt;
    private static int fSu;

    public static class a extends b {
        ImageView fSv;
        TextView fSw;
    }

    public d(g gVar) {
        super(gVar);
        fSu = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 138);
        fSt = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 230);
    }

    public final View a(View view, ViewGroup viewGroup, i iVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, 2130903605, null), aVar, iVar);
            aVar.fSv = (ImageView) view.findViewById(2131756948);
            aVar.fSw = (TextView) view.findViewById(2131756949);
            aVar.fSw.setVisibility(8);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, iVar);
        g.a(bVar.fSv, v.n(iVar), iVar, false, fSt, fSu);
        return view;
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}

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
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.be;

public final class c extends a {

    public static class a extends b {
        TextView dtY;
        TextView dtZ;
        ImageView eZn;
    }

    public c(g gVar) {
        super(gVar);
    }

    public final View a(View view, ViewGroup viewGroup, i iVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, 2130903601, null), aVar, iVar);
            aVar.eZn = (ImageView) view.findViewById(2131756943);
            aVar.dtY = (TextView) view.findViewById(2131755050);
            aVar.dtZ = (TextView) view.findViewById(2131755035);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, iVar);
        pw n = v.n(iVar);
        qg qgVar = iVar.field_favProto.mtP;
        CharSequence charSequence = iVar.field_favProto.title;
        if (be.kS(charSequence)) {
            charSequence = n.title;
        }
        bVar.dtY.setText(charSequence);
        bVar.dtZ.setText(v.N((float) n.msn));
        bVar.eZn.setImageResource(v.ta(n.msh));
        return view;
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}

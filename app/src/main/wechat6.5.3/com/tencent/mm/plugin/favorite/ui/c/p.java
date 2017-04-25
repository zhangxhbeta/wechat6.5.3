package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.s;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.ui.MMImageView;
import java.util.LinkedList;

public final class p extends a {
    final int fSt;
    final int fSu;

    public static class a extends b {
        MMImageView fSR;
        TextView fSS;
    }

    public p(g gVar) {
        super(gVar);
        this.fSu = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 138);
        this.fSt = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 230);
    }

    public final View a(View view, ViewGroup viewGroup, i iVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, 2130903607, null), aVar, iVar);
            aVar.fSR = (MMImageView) view.findViewById(2131756948);
            aVar.fSS = (TextView) view.findViewById(2131756958);
        } else {
            aVar = (a) view.getTag();
        }
        view.findViewById(2131756959).setVisibility(8);
        aVar.fSS.setVisibility(0);
        LinkedList linkedList = iVar.field_favProto.mtR;
        if (linkedList.size() > 0) {
            aVar.fSS.setText(s.s(context, ((pw) linkedList.getFirst()).duration));
        } else {
            aVar.fSS.setText("");
        }
        a(aVar, iVar);
        this.fJV.a(aVar.fSR, v.n(iVar), iVar, 2131165518, this.fSt, this.fSu);
        return view;
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}

package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMImageView;

public final class g extends a {
    private final String fSA;
    private final int fSr;

    public static class a extends b {
        TextView dtY;
        TextView dtZ;
        MMImageView fQG;
        TextView fSs;
    }

    public g(com.tencent.mm.plugin.favorite.c.g gVar) {
        super(gVar);
        this.fSr = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 60);
        this.fSA = gVar.context.getString(2131232686);
    }

    public final View a(View view, ViewGroup viewGroup, i iVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, 2130903600, null), aVar, iVar);
            aVar.fQG = (MMImageView) view.findViewById(2131756943);
            aVar.dtY = (TextView) view.findViewById(2131755050);
            aVar.dtZ = (TextView) view.findViewById(2131755034);
            aVar.fSs = (TextView) view.findViewById(2131755046);
            aVar.fSs.setVisibility(8);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, iVar);
        qe qeVar = iVar.field_favProto.mte;
        aVar.dtY.setText(be.ma(qeVar.title));
        aVar.dtZ.setText(be.ma(qeVar.desc));
        aVar.dtY.setSingleLine(false);
        aVar.dtY.setMaxLines(2);
        this.fJV.a(aVar.fQG, null, iVar, 2131165241, this.fSr, this.fSr);
        return view;
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}
